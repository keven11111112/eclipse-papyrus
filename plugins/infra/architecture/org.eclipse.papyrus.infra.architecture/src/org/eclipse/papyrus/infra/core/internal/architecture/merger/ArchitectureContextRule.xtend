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

import java.util.Set
import java.util.function.Consumer
import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework

import static org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage.Literals.*
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain

/**
 * Merge rule for {@link ArchitectureContext}s.
 */
@Singleton
class ArchitectureContextRule {
	static extension ArchitectureFactory factory = ArchitectureFactory.eINSTANCE
	
	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureViewpointRule
	@Inject extension RepresentationKindRule
	
	def hasExtensions(ArchitectureContext context) {
		context.isReferenced(ARCHITECTURE_CONTEXT__EXTENDED_CONTEXTS)
	}
	
	def <T extends ArchitectureContext> extensions(T context) {
		context.<T> invert(ARCHITECTURE_CONTEXT__EXTENDED_CONTEXTS).filter[eClass == context.eClass]
	}
	
	def <T extends ArchitectureContext> allExtensions(T context) {
		val Set<T> result = newLinkedHashSet
		allExtensionsHelper(context, result).toList
	}
	
	private def <T extends ArchitectureContext> Iterable<T> allExtensionsHelper(T context, Set<T> result) {
		context.extensions.reject[result.contains(it)].forEach[
			result += it
			allExtensionsHelper(it, result)
		]
		result
	}
	
	def legacyContext(ArchitectureContext context) {
		!(context.hasExtensions || context.extension)
	}
	
	def dispatch create createArchitectureDescriptionLanguage merged(ArchitectureDescriptionLanguage context, Set<? extends ArchitectureDomain> domains) {
		merge(context, domains)
	}
	
	private def <T extends ArchitectureContext> merge(T target, T source, Set<? extends ArchitectureDomain> domains) {
		(Set.of(source) + source.allExtensions).toSet => [
			forEach[target.copyContext(it, domains)]
			target.mergeViewpoints(it)
		]
	}
	
	private def mergeViewpoints(ArchitectureContext target, Set<? extends ArchitectureContext> sources) {
		target => [
			val allViewpoints = sources.flatMap[viewpoints]
			viewpoints += allViewpoints.mapUnique[it.name].map[sources.mergedViewpoint(it)]
			
			val allDefaults = sources.flatMap[defaultViewpoints]
			if (!allDefaults.empty) {
				// Now we have all the viewpoints, so find the defaults by name
				val viewpointsByName = viewpoints.toMap([name], [it]);
				
				defaultViewpoints += allDefaults.mapUnique[name].map[viewpointsByName.get(it)].filterNull
			}
		]
	}
	
	def dispatch create createArchitectureFramework merged(ArchitectureFramework context, Set<? extends ArchitectureDomain> domains) {
		merge(context, domains)
	}
	
	private def copyContext(ArchitectureContext target, ArchitectureContext source, Set<? extends ArchitectureDomain> domains) {
		target.copyContext(source, target.contextCopier(domains))
	}
	
	private def <T extends ArchitectureContext> copyContext(T target, T source, Consumer<? super T> extensionMerger) {
		target => [
			copy(source)
			
			creationCommandClass = creationCommandClass ?: source.creationCommandClass
			conversionCommandClass = conversionCommandClass ?: source.conversionCommandClass
			extensionPrefix = extensionPrefix ?: source.extensionPrefix
			elementTypes += source.elementTypes
		
			// Further processing specific to the context type
			if (extensionMerger !== null) {
				extensionMerger.accept(source)
			}
		]
	}
	
	private def dispatch Consumer<? super ArchitectureContext> contextCopier(ArchitectureDescriptionLanguage adl, Set<? extends ArchitectureDomain> domains) {
		[ source |
			switch source {
				ArchitectureDescriptionLanguage case source:
					adl => [
						representationKinds+= source.representationKinds.map[merged(domains)]
						treeViewerConfigurations += source.treeViewerConfigurations.map[merged]
						
						metamodel = it.metamodel ?: source.metamodel
						profiles += source.profiles
					]
			}
		]
	}
	
	private def dispatch Consumer<? super ArchitectureContext> contextCopier(ArchitectureContext context, Set<? extends ArchitectureDomain> domains) {
		[ source |
			context => [
				// pass
			]
		]
	}
	
	def dispatch legacyMergedContext(ArchitectureDescriptionLanguage context, Set<? extends ArchitectureContext> contexts) {
		context.name.legacyMergedADL(contexts)
	}
	
	def dispatch legacyMergedContext(ArchitectureFramework context, Set<? extends ArchitectureContext> contexts) {
		context.name.legacyMergedAF(contexts)
	}
	
	def create createArchitectureDescriptionLanguage legacyMergedADL(String name, Set<? extends ArchitectureContext> contexts) {
		legacyMerge(name, contexts)
	}
	
	private def legacyMerge(ArchitectureContext target, String name, Set<? extends ArchitectureContext> contexts) {
		val contextsToMerge = contexts.named(name).toSet
		val domainsToMerge = contexts.map[domain].toSet
		contextsToMerge.forEach[target.copyContext(it, domainsToMerge)]
		target.mergeViewpoints(contextsToMerge)
	}
	
	def create createArchitectureFramework legacyMergedAF(String name, Set<? extends ArchitectureContext> contexts) {
		legacyMerge(name, contexts)
	}
	
}
