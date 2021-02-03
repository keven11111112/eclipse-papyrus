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

/**
 * Extension merge rule for {@link ArchitectureContext}s.
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
	
	def canExtend(ArchitectureContext extending, ArchitectureContext extended) {
		extending.eClass === extended.eClass
	}
	
	def <T extends ArchitectureContext> extensions(T context) {
		if (inExtensionsPhase) context.<T> invert(ARCHITECTURE_CONTEXT__EXTENDED_CONTEXTS).filter[context.canExtend(it)] else emptyList
	}
	
	def <T extends ArchitectureContext> allExtensions(T context) {
		if (inExtensionsPhase) allExtensionsHelper(context, newLinkedHashSet).toList else emptyList
	}
	
	private def <T extends ArchitectureContext> Iterable<T> allExtensionsHelper(T context, Set<T> result) {
		context.extensions.reject[result.contains(it)].forEach[
			result += it
			allExtensionsHelper(it, result)
		]
		result
	}
	
	def dispatch merged(ArchitectureDescriptionLanguage context) {
		context.merged(currentScope) // Unique merge per domain scope
	}
	private def create createArchitectureDescriptionLanguage merged(ArchitectureDescriptionLanguage context, Object scope) {
		merge(context)
	}
	
	package def <T extends ArchitectureContext> merge(T target, T source) {
		(Set.of(source) + source.allExtensions).toSet => [
			forEach[target.copyContext(it)]
			target.mergeViewpoints(it)
		]
	}
	
	private def mergeViewpoints(ArchitectureContext target, Set<? extends ArchitectureContext> sources) {
		target => [
			val allViewpoints = sources.flatMap[viewpoints]
			viewpoints += allViewpoints.mapUnique[name].map[mergedViewpoint(sources)]
			
			val allDefaults = sources.flatMap[defaultViewpoints]
			if (!allDefaults.empty) {
				// Now we have all the viewpoints, so find the defaults by name
				val viewpointsByName = viewpoints.toMap([name], [it]);
				
				defaultViewpoints += allDefaults.mapUnique[name].map[viewpointsByName.get(it)].filterNull
			}
		]
	}
	
	def dispatch merged(ArchitectureFramework context) {
		context.merged(currentScope) // Unique merge per domain scope
	}
	private def create createArchitectureFramework merged(ArchitectureFramework context, Object scope) {
		merge(context)
	}
	
	private def copyContext(ArchitectureContext target, ArchitectureContext source) {
		target.copyContext(source, target.contextCopier)
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
	
	private def dispatch Consumer<? super ArchitectureContext> contextCopier(ArchitectureDescriptionLanguage adl) {
		[ source |
			switch source {
				ArchitectureDescriptionLanguage case source:
					adl => [
						representationKinds+= source.representationKinds.map[merged]
						treeViewerConfigurations += source.treeViewerConfigurations.map[merged]
						
						metamodel = it.metamodel ?: source.metamodel
						profiles += source.profiles
					]
			}
		]
	}
	
	private def dispatch Consumer<? super ArchitectureContext> contextCopier(ArchitectureContext context) {
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
		contexts.map[domain].withScope[
			contextsToMerge.forEach[target.copyContext(it)]
			target.mergeViewpoints(contextsToMerge)
		]
	}
	
	def create createArchitectureFramework legacyMergedAF(String name, Set<? extends ArchitectureContext> contexts) {
		legacyMerge(name, contexts)
	}
	
}
