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

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * Mapping of transitions in a region of a state machine.
 */
@Singleton
public class TransitionMapping extends NamedElementMapping<Transition> {
	@Inject
	private ICorrespondenceResolver<Vertex, Region> vertexRedef;

	@Inject
	public TransitionMapping(IFactory factory) {
		super(UMLPackage.Literals.TRANSITION, factory);
	}

	@Override
	protected void mapProperties(IOne<Transition> parentTransition, IOne<Transition> childTransition) {
		super.mapProperties(parentTransition, childTransition);

		bindPropertyValue(parentTransition, childTransition, UMLPackage.Literals.TRANSITION__REDEFINED_TRANSITION);

		IBox<Vertex> parentSource = property(parentTransition, UMLPackage.Literals.TRANSITION__SOURCE);
		IBox<Vertex> childSource = property(childTransition, UMLPackage.Literals.TRANSITION__SOURCE);
		IBox<Vertex> sourceMapping = parentSource.collectTo(v -> getCorrespondingSource(v, childTransition.get()));
		childSource.bind(sourceMapping).setAutoDisable(true);

		IBox<Vertex> parentTarget = property(parentTransition, UMLPackage.Literals.TRANSITION__TARGET);
		IBox<Vertex> childtarget = property(childTransition, UMLPackage.Literals.TRANSITION__TARGET);
		IBox<Vertex> targetMapping = parentTarget.collectTo(v -> getCorrespondingTarget(v, childTransition.get()));
		childtarget.bind(targetMapping).setAutoDisable(true);
	}

	protected Vertex getCorrespondingSource(Vertex parentVertex, Transition childTransition) {
		if (parentVertex == null) {
			// This happens when getting the IOne's default value
			return null;
		}

		return vertexRedef.getCorrespondent(parentVertex, childTransition.getContainer());
	}

	protected Vertex getCorrespondingTarget(Vertex parentVertex, Transition childTransition) {
		if (parentVertex == null) {
			// This happens when getting the IOne's default value
			return null;
		}

		return vertexRedef.getCorrespondent(parentVertex, childTransition.getContainer());
	}
}
