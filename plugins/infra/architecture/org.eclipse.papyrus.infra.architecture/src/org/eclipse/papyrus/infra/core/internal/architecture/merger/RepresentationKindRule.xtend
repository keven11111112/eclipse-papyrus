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

import javax.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind
import javax.inject.Singleton
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
import org.eclipse.papyrus.infra.core.architecture.Concern
import org.eclipse.papyrus.infra.core.architecture.Stakeholder
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext

/**
 * Merge rule for {@link RepresentationKind}s.
 */
@Singleton
class RepresentationKindRule {

	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureContextRule
	@Inject extension ArchitectureDomainRule
	 
	def merged(RepresentationKind representation) {
		representation.merged(currentScope) // Unique merge per domain scope
	}
	
	private def create result: EcoreUtil.copy(representation) as RepresentationKind merged(RepresentationKind representation, Object scope) {
		// Replace the concerns with the merged copies. Also, any other cross-references to
		// architecture elements, e.g. PapyrusDiagram::parent reference. Do this reflectively
		// because we don't know the specifics of the representation kind model
		representation.eClass.EAllReferences.reject[containment || container || !changeable]
				.filter[AD_ELEMENT.isSuperTypeOf(EReferenceType)].forEach[xref |
			
			switch type: xref.EReferenceType {
				case CONCERN.isSuperTypeOf(type): result.<Concern> eGetAsList(xref).replaceAll[name.mergedConcern]
				case STAKEHOLDER.isSuperTypeOf(type): result.<Stakeholder> eGetAsList(xref).replaceAll[name.mergedStakeholder]
				case REPRESENTATION_KIND.isSuperTypeOf(type): result.<RepresentationKind> eGetAsList(xref).replaceAll[merged]
				// TODO(cwd): Not sure that the following make sense
				case ARCHITECTURE_CONTEXT.isSuperTypeOf(type): result.<ArchitectureContext> eGetAsList(xref).replaceAll[merged]
				case ARCHITECTURE_DOMAIN.isSuperTypeOf(type): result.<ArchitectureDomain> eGetAsList(xref).replaceAll[merged]
			}
		]
		
	}
	
}
