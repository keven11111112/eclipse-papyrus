/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * Mapping of transitions in a region of a state machine.
 */
@Singleton
public class TransitionMapping extends NamedElementMapping<Transition> {
	@Inject
	private ICorrespondenceResolver<Vertex, Transition> transitionEndRedef;

	@Inject
	public TransitionMapping(IFactory factory) {
		super(UMLPackage.Literals.TRANSITION, factory);
	}

	@Override
	protected void mapProperties(IOne<Transition> parentTransition, IOne<Transition> childTransition) {
		super.mapProperties(parentTransition, childTransition);

		bindPropertyValue(parentTransition, childTransition, UMLPackage.Literals.TRANSITION__REDEFINED_TRANSITION);

		mapCorresponding(parentTransition, childTransition, UMLPackage.Literals.TRANSITION__SOURCE, transitionEndRedef);
		mapCorresponding(parentTransition, childTransition, UMLPackage.Literals.TRANSITION__TARGET, transitionEndRedef);
	}
}
