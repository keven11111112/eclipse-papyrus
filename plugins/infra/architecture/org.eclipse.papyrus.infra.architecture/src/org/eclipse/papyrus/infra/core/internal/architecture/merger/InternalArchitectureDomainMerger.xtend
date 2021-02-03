/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.internal.architecture.merger

import com.google.inject.AbstractModule
import com.google.inject.Guice
import java.util.Map
import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager
import org.eclipse.papyrus.infra.core.architecture.ADElement
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDomain
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureFramework
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils

import static extension org.eclipse.papyrus.infra.emf.utils.EMFHelper.*
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject

/**
 * Model-to-model transformation that generates merged <em>Architecture Description</em> model instances
 * from the input {@link ArchitectureDomain}s (which usually will be those that are registered with
 * the {@link ArchitectureDomainManager}).
 */
@Singleton
class InternalArchitectureDomainMerger {

	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureDomainRule

	@Inject extension MergeState

	def mergeDomains(Iterable<? extends ArchitectureDomain> domains) {
		// First, make a safe copy of all of the incoming domains
		val inheritanceSet = new ResourceSetImpl
		val inheritedDomains = domains.copy(inheritanceSet)
		val mergeableDomains = inheritedDomains.filter[hasExtensions || hasInheritance].toSet
		val legacyDomains = inheritedDomains.reject[hasExtensions || hasInheritance].toSet

		// Process inheritance in place (on the safe copy)
		advancePhase
		mergeableDomains.forEach[inherit]

		// Delete inheritance relationships
		mergeableDomains.forEach[finalizeInheritance]

		// Prepare resources to store the merged domains
		val resourceSet = new ResourceSetImpl
		resourceSet.packageRegistry = ResourceUtils.createWorkspaceAwarePackageRegistry
		resourceSet.URIConverter = ResourceUtils.createWorkspaceAwareURIConverter
		val mergedResources = inheritedDomains.toMap([eResource.URI], [resourceSet.createResource(eResource.URI)])

		// Then, process merges
		advancePhase
		val mergedDomains = mergeableDomains.map[merged].toList // Collapse the lazy iterable before we advance to 'done'
		val legacyMergedDomains = legacyDomains.withScope[legacyDomains.mapUnique[name].map[legacyMergedDomain].toList]

		// Done. Screen and encapsulate the results
		advancePhase

		inheritanceSet.unload // No longer need the intermediate inheritance result
		
		return (mergedDomains + legacyMergedDomains).filter[hasContexts] // We don't need any empty domains
			.map[toMergedArchitectureDomain(mergedResources)].toList 
	}

	def create result: new MergedArchitectureDomain(domain) toMergedArchitectureDomain(ArchitectureDomain domain, Map<URI, Resource> resources) {
		domain.contexts.forEach[toMergedArchitectureContext(result)]

		// Add the merged domain to its resource
		resources.get(domain.trace?.eResource?.URI)?.contents?.add(domain)
	}

	def dispatch create result: new MergedArchitectureDescriptionLanguage(domain, context) toMergedArchitectureContext(
		ArchitectureDescriptionLanguage context, MergedArchitectureDomain domain) {
		context.viewpoints.forEach[toMergedArchitectureViewpoint(result)]
	}

	def dispatch create result: new MergedArchitectureFramework(domain, context) toMergedArchitectureContext(
		ArchitectureFramework context, MergedArchitectureDomain domain) {
		context.viewpoints.forEach[toMergedArchitectureViewpoint(result)]
	}

	def create result: new MergedArchitectureViewpoint(context, viewpoint) toMergedArchitectureViewpoint(
		ArchitectureViewpoint viewpoint, MergedArchitectureContext context) {
		// Pass
	}

	private def copy(Iterable<? extends ArchitectureDomain> domains, ResourceSet resourceSet) {
		val copier = new EcoreUtil.Copier {
			override protected createCopy(EObject eObject) {
				super.createCopy(eObject) => [
					switch (it) {
						ADElement: it.traceTo(eObject as ADElement)
					}
				]
			}
		}
		
		val result = copier.copyAll(domains.toSet)
		copier.copyReferences

		domains.forEach[ orig | resourceSet.createResource(orig.eResource.URI).contents += copier.get(orig) ]

		result
	}

	static def InternalArchitectureDomainMerger newInstance() {
		newInstance(new ArchitectureMergerModule())
	}

	static def InternalArchitectureDomainMerger newInstance(AbstractModule module) {
		Guice.createInjector(module).getInstance(InternalArchitectureDomainMerger)
	}

}
