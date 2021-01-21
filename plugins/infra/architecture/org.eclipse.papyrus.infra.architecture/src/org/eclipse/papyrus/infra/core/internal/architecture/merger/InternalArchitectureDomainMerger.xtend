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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager
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

/**
 * Model-to-model transformation that generates merged <em>Architecture Description</em> model instances
 * from the input {@link ArchitectureDomain}s (which usually will be those that are registered with
 * the {@link ArchitectureDomainManager}).
 */
@Singleton
class InternalArchitectureDomainMerger {

	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureDomainRule
	
	def mergeDomains(Iterable<? extends ArchitectureDomain> domains) {
		val resourceSet = new ResourceSetImpl
		resourceSet.packageRegistry = ResourceUtils.createWorkspaceAwarePackageRegistry
		resourceSet.URIConverter = ResourceUtils.createWorkspaceAwareURIConverter
		
		val extendedDomains = domains.filter[hasExtensions]
		val legacyDomains = domains.reject[hasExtensions].toSet
		
		// Prepare resources to store the merged domains
		val mergedResources = domains.toMap([it], [
			resourceSet.createResource(eResource.URI)
		])
		
		newArrayList(extendedDomains.map[merged],
				legacyDomains.mapUnique[name].map[legacyDomains.legacyMergedDomain(it)])
			.flatten.filter[hasContexts] // We don't need any empty domains
			.map[toMergedArchitectureDomain(mergedResources)]
	}
	
	def create result: new MergedArchitectureDomain(domain) toMergedArchitectureDomain(
		ArchitectureDomain domain, 
		Map<ArchitectureDomain, Resource> resources
	) {
		domain.contexts.forEach[toMergedArchitectureContext(result)]
		
		// Add the merged domain to its resource
		resources.get(domain.trace)?.contents?.add(domain)
	}
	
	def dispatch create result: new MergedArchitectureDescriptionLanguage(domain, context) toMergedArchitectureContext(ArchitectureDescriptionLanguage context, MergedArchitectureDomain domain) {
		context.viewpoints.forEach[toMergedArchitectureViewpoint(result)]
	}
	
	def dispatch create result: new MergedArchitectureFramework(domain, context) toMergedArchitectureContext(ArchitectureFramework context, MergedArchitectureDomain domain) {
		context.viewpoints.forEach[toMergedArchitectureViewpoint(result)]
	}
	
	def create result: new MergedArchitectureViewpoint(context, viewpoint) toMergedArchitectureViewpoint(ArchitectureViewpoint viewpoint, MergedArchitectureContext context) {
		// Pass
	}
	
	static def InternalArchitectureDomainMerger newInstance() {
		newInstance(new ArchitectureMergerModule())
	}
	
	static def InternalArchitectureDomainMerger newInstance(AbstractModule module) {
		Guice.createInjector(module).getInstance(InternalArchitectureDomainMerger)
	}
	
}
