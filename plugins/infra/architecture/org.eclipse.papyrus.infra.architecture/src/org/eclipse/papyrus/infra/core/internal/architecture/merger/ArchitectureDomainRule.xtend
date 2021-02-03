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

import static org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage.Literals.*

import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
import javax.inject.Inject
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
import javax.inject.Singleton
import java.util.Set

/**
 * Merge rule for {@link Architecture Domain}s.
 */
@Singleton
class ArchitectureDomainRule {
	static extension ArchitectureFactory factory = ArchitectureFactory.eINSTANCE
	
	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureContextRule
	@Inject extension ArchitectureContextInheritanceRule
	
	def hasExtensions(ArchitectureDomain domain) {
		domain.contexts.exists[hasExtensions || extension]
	}
	
	def hasInheritance(ArchitectureDomain domain) {
		domain.contexts.exists[hasGeneral || hasSpecializations]
	}
	
	def hasContexts(ArchitectureDomain domain) {
		!domain.contexts.empty
	}
	
	/** A domain's extensions are implied by the domains defining extensions of its contexts. */
	def extensions(ArchitectureDomain extended) {
		if (inExtensionsPhase) extended.contexts.flatMap[extensions].mapUnique[domain] else emptyList
	}
	
	/** A domain's extensions are implied by the domains defining extensions of its contexts. */
	def allExtensions(ArchitectureDomain extended) {
		if (inExtensionsPhase) extended.contexts.flatMap[allExtensions].mapUnique[domain] else emptyList
	}
	
	def generals(ArchitectureDomain specific) {
		if (inInheritancePhase) specific.contexts.map[general].filterNull.map[domain].unique.excluding(specific) else emptyList
	}
	
	def inherit(ArchitectureDomain domain) {
		domain.generals.withScope[
			// Contexts that are to be inherited have dependencies on these, so inherit them
			domain.concerns += currentScope.flatMap[concerns].mapUnique[name].map[mergedConcern]
			domain.stakeholders += currentScope.flatMap[stakeholders].mapUnique[name].map[mergedStakeholder]
		]
				
		if (inInheritancePhase) domain.contexts.forEach[it.inherit]
		domain
	}
	
	def finalizeInheritance(ArchitectureDomain domain) {
		domain.contexts.forEach[it.finalizeInheritance]
	}
	
	def create createArchitectureDomain merged(ArchitectureDomain domain) {
		(Set.of(domain) + domain.allExtensions).withScope[
			copy(domain) => [ result |
				// Gather up stakeholders and concerns from merged domains
				concerns += currentScope.flatMap[concerns].mapUnique[name].map[mergedConcern]
				stakeholders += currentScope.flatMap[stakeholders].mapUnique[name].map[mergedStakeholder]
				
				// Extension contexts exist only to contribute to others
				contexts += domain.contexts.reject[extension].map[merged]
				
				// Trace to the merged domains
				domain.allExtensions.forEach[result.traceTo(it)]
			]
		]
	}
	
	/** Get contexts sorted with ArchitectureDescriptionLanguages first. */
	def sortedContexts(Iterable<? extends ArchitectureDomain> domains) {
		domains.flatMap[contexts].sortBy[eClass == ARCHITECTURE_DESCRIPTION_LANGUAGE ? 0 : 1]
	}
	
	def create result: createArchitectureDomain legacyMergedDomain(String name) {
		val sameName = currentScope.named(name).toList
		sameName.withScope[
			currentScope.forEach[result.copy(it)]
			result.stakeholders += currentScope.flatMap[stakeholders].mapUnique[it.name].map[mergedStakeholder]
			result.concerns += currentScope.flatMap[concerns].mapUnique[it.name].map[mergedConcern]
					
			// Be sure to process ADLs first when name matching to lose no data (otherwise ADLs could be merged into AFs)
			val allContexts = currentScope.sortedContexts.filter[legacyContext].toSet
			val uniqueContexts = allContexts.uniqueBy[it.name]
			result.contexts += uniqueContexts.map[it.legacyMergedContext(allContexts)]
		]
	}
	
}
