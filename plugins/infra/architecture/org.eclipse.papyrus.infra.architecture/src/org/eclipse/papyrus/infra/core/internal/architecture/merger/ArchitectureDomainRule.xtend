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
	
	def hasExtensions(ArchitectureDomain domain) {
		domain.contexts.exists[hasExtensions]
	}
	
	def hasContexts(ArchitectureDomain domain) {
		!domain.contexts.empty
	}
	
	/** A domain's extensions are implied by the domains defining extensions of its contexts. */
	def extensions(ArchitectureDomain domain) {
		domain.contexts.flatMap[extensions].mapUnique[it.domain]
	}
	
	/** A domain's extensions are implied by the domains defining extensions of its contexts. */
	def allExtensions(ArchitectureDomain domain) {
		domain.contexts.flatMap[allExtensions].mapUnique[it.domain]
	}
	
	def create createArchitectureDomain merged(ArchitectureDomain domain) {
		copy(domain) => [
			// Gather up stakeholders and concerns from merged domains
			val allDomains = (Set.of(domain) + domain.allExtensions).toSet
			stakeholders += allDomains.flatMap[stakeholders].map[name].map[mergedStakeholder(allDomains)]
			concerns += allDomains.flatMap[concerns].map[name].map[mergedConcern(allDomains)]
			
			// Extension contexts exist only to contribute to others
			contexts += domain.contexts.reject[extension].map[merged(allDomains)]
		]
	}
	
	/** Get contexts sorted with ArchitectureDescriptionLanguages first. */
	def sortedContexts(Iterable<? extends ArchitectureDomain> domains) {
		domains.flatMap[contexts].sortBy[eClass == ARCHITECTURE_DESCRIPTION_LANGUAGE ? 0 : 1]
	}
	
	def create result: createArchitectureDomain legacyMergedDomain(Set<? extends ArchitectureDomain> domains, String name) {
		val mergedDomains = domains.named(name).toSet
		
		mergedDomains.forEach[result.copy(it)]
		result.stakeholders += mergedDomains.flatMap[stakeholders].mapUnique[it.name].map[mergedStakeholder(mergedDomains)]
		result.concerns += mergedDomains.flatMap[concerns].mapUnique[it.name].map[mergedConcern(mergedDomains)]
		
		// Be sure to process ADLs first when name matching to lose no data (otherwise ADLs could be merged into AFs)
		val allContexts = domains.named(name).sortedContexts.filter[legacyContext].toSet
		val uniqueContexts = allContexts.uniqueBy[it.name]
		result.contexts += uniqueContexts.map[it.legacyMergedContext(allContexts)]
	}
	
}
