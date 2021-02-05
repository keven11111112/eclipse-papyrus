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

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter
import org.eclipse.papyrus.infra.core.architecture.ADElement
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.papyrus.infra.core.architecture.TreeViewerConfiguration
import javax.inject.Singleton
import java.util.Set
import com.google.common.collect.AbstractIterator
import javax.inject.Inject
import javax.inject.Named
import java.util.function.BiConsumer
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.xbase.lib.Functions.Function0
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0

/**
 * Utility extensions for the <em>Architecture Description</em> model.
 */
@Singleton
class ArchitectureExtensions {
	
	static extension ArchitectureFactory factory = ArchitectureFactory.eINSTANCE
	
	@Inject @Named(ArchitectureMergerModule.MERGE_TRACE) BiConsumer<? super ADElement, ? super ADElement> mergeTrace
	
	@Inject extension MergeState
	
	val ECrossReferenceAdapter xrefAdapter = new ECrossReferenceAdapter {
		// Also propagate up the content tree
		
		override protected setTarget(Resource target) {
			super.setTarget(target)
			
			target.resourceSet?.addAdapter
		}
		
		override protected setTarget(EObject target) {
			super.setTarget(target)

			// If iterating, then we came down the tree, so no need to go up			
			if (!iterating) {
				target as InternalEObject => [
					eDirectResource?.addAdapter
					eInternalContainer?.addAdapter
				]
			}
		}
		
	}
	
	private def xrefs(EObject object) {
		ECrossReferenceAdapter.getCrossReferenceAdapter(object) ?: (xrefAdapter => [
			object.eAdapters += it
		])
	}
	
	def <T extends EObject> Iterable<T> invert(EObject target, EReference reference) {
		target.xrefs.getInverseReferences(target, reference, true).map[EObject as T]
	}
	
	def isReferenced(EObject target, EReference reference) {
		!target.xrefs.getInverseReferences(target, reference, true).empty
	}
	
	/** Get the first source element that was merged into the given output. */
	def <T extends ADElement> trace(T mergedElement) {
		MergeTraceAdapter.getMergeTraces(mergedElement)?.trace(mergedElement).head as T
	}
	
	/** Get a feature of an object as a list, even if it isn't a list. */
	def <T> EList<T> eGetAsList(EObject owner, EStructuralFeature feature) {
		if (feature.many) {
			owner.eGet(feature) as EList<T>
		} else {
			new BasicEList<T>(owner.eGet(feature) === null ? 0 : 1, #[owner.eGet(feature)]) {
				
				override protected didAdd(int index, Object newObject) {
					if (index == 0) owner.eSet(feature, newObject)
				}
				
				override protected didSet(int index, Object newObject, Object oldObject) {
					if (index == 0) owner.eSet(feature, newObject)
				}
				
				override protected didRemove(int index, Object oldObject) {
					if (index == 0) {
						if (empty) owner.eSet(feature, null) else owner.eSet(feature, get(0))
					}
				}
				
				override protected didClear(int size, Object[] oldObjects) {
					owner.eSet(feature, null)
				}
				
				override protected didMove(int index, Object movedObject, int oldIndex) {
					if (index == 0) owner.eSet(feature, movedObject)
				}
				
			}
		}
	} 
	
	def <T extends ADElement> traceTo(T target, T source) {
		mergeTrace.accept(target, source)
	}
	
	def <T extends ADElement> copy(T target, T source) {
		// Establish trace from the output element to the input
		target.traceTo(source)
		
		target.id = target.id ?: source.id
		target.name = target.name ?: source.name
		target.description = target.description ?: source.description
		target.icon = target.icon ?: source.icon
		target
	}
		
	def mergedStakeholder(String name) {		
		name.mergedStakeholder(currentScope) // Unique merge per domain scope
	}
	private def create result: factory.createStakeholder mergedStakeholder(String name, Object scope) {
		currentScope.flatMap[stakeholders].filter[it.name == name].forEach[
			result.copy(it)
			result.concerns += it.concerns.mapUnique[it.name].map[mergedConcern]
		]
	} 
	
	def mergedConcern(String name) {
		name.mergedConcern(currentScope) // Unique merge per domain scope
	}
	private def create result: factory.createConcern mergedConcern(String name, Object scope) {
		currentScope.flatMap[concerns].filter[it.name == name].forEach[result.copy(it)]
	} 
	
	def create EcoreUtil.copy(treeViewerConfig) merged(TreeViewerConfiguration treeViewerConfig) {} 
	
	def inInheritancePhase() { phase === MergePhase.INHERITANCE }
	def inExtensionsPhase() { phase === MergePhase.EXTENSIONS || phase === MergePhase.LEGACY }
	def currentScope() { currentDomains }
	def <T> T withScope(Iterable<? extends ArchitectureDomain> domains, Function0<T> block) { domains.withDomains(block)}
	def <T> T withScope(Iterable<? extends ArchitectureDomain> domains, Procedure0 block) {
		domains.withScope[
			block.apply
			null
		]
	}
	
	@Pure
	def <T, K> Iterable<T> uniqueBy(Iterable<T> iterable, Function1<? super T, K> keyer) {
		[
			new AbstractIterator<T> {
				val delegate = iterable.iterator
				val Set<K> uniquifier = newHashSet
				
				override protected computeNext() {
					while (delegate.hasNext) {
						val next = delegate.next
						if (uniquifier += keyer.apply(next)) return next
					}
					
					endOfData
				}
			}
		]
	}
	
	@Pure
	def <T, R> mapUnique(Iterable<T> iterable, Function1<? super T, R> mapper) {
		iterable.map(mapper).unique
	}
	
	/** Obtain the unique elements in an {@code iterable}. */
	@Pure
	def <T> Iterable<T> unique(Iterable<T> iterable) {
		[
			new AbstractIterator<T> {
				val delegate = iterable.iterator
				val Set<T> uniquifier = newHashSet
				
				override protected computeNext() {
					while (delegate.hasNext) {
						val next = delegate.next
						if (uniquifier += next) return next
					}
					
					endOfData
				}
			}
		]
	}
	
	/** Filter architecture elements by name. */
	@Pure
	def <T extends ADElement> named(Iterable<T> iterable, String selectedName) {
		iterable.filter[name == selectedName]
	}
	
	@Pure
	def <T> excluding(Iterable<T> iterable, Object... excluded) {
		val unwanted = newHashSet(excluded)
		iterable.reject[unwanted.contains(it)]
	}
	
}
