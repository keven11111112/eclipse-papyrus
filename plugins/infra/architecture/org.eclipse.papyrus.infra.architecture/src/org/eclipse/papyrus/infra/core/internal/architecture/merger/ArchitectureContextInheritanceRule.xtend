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

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext

import static org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage.Literals.*

/**
 * Inheritance rule for {@link ArchitectureContext}s.
 */
@Singleton
class ArchitectureContextInheritanceRule {

	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureContextRule
	
	def legacyContext(ArchitectureContext context) {
		!(context.hasGeneral || context.extension || context.hasSpecializations || context.hasExtensions)
	}

	def hasGeneral(ArchitectureContext context) {
		context.generalContext !== null
	}
	
	def general(ArchitectureContext context) {
		if (context.hasGeneral && context.canInherit(context.generalContext)) context.generalContext
	}
	
	def hasSpecializations(ArchitectureContext context) {
		context.isReferenced(ARCHITECTURE_CONTEXT__GENERAL_CONTEXT)
	}

	def canInherit(ArchitectureContext specific, ArchitectureContext general) {
		specific.eClass === general.eClass
	}
	
	def <T extends ArchitectureContext> specializations(T context) {
		context.<T> invert(ARCHITECTURE_CONTEXT__GENERAL_CONTEXT).filter[canInherit(context)]
	}
	
	// Create returning self is a "once function"
	def create context inherit(ArchitectureContext context) {
		if (context.hasGeneral && context.canInherit(context.generalContext)) {
			context.inherit(context.generalContext.inherit) // Recursive inheritance
		}
	}
	
	private def inherit(ArchitectureContext specific, ArchitectureContext general) {
		// During the inheritance phase, merge does not "see" any extensions
		newLinkedHashSet(specific.domain, general.domain).withScope[specific.merge(general)]
	}
	
	def finalizeInheritance(ArchitectureContext context) {
		context.generalContext = null
	}
	
}
