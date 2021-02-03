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
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
import javax.inject.Singleton
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext
import java.util.Set

/**
 * Merge rule for {@link ArchitectureViewpoint}s.
 */
@Singleton
class ArchitectureViewpointRule {
	static extension ArchitectureFactory factory = ArchitectureFactory.eINSTANCE
	
	@Inject extension ArchitectureExtensions
	@Inject extension RepresentationKindRule
	
	/** Viewpoints are always merged by name (not just for legacy mode). */
	def mergedViewpoint(String name, Set<? extends ArchitectureContext> contexts) {
		name.mergedViewpoint(contexts, currentScope) // Unique merge per domain scope
	}
	
	private def create result: createArchitectureViewpoint mergedViewpoint(String name, Set<? extends ArchitectureContext> contexts, Object scope) {
		contexts.flatMap[viewpoints].named(name).forEach[viewpoint |
			result.copy(viewpoint) => [
				concerns += viewpoint.concerns.mapUnique[it.name].map[mergedConcern]
				representationKinds += viewpoint.representationKinds.map[merged]
			]
		]
	}
	
}
