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
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Mapping of capsules, specifically the {@link BehavioredClassifier#getClassifierBehavior() classifierBehavior}
 * when that behavior is a {@link StateMachine}.
 */
@Singleton
public class CapsuleMapping extends NamedElementMapping<Class> {
	@Inject
	private ISyncMapping<StateMachine> stateMachine;

	@Inject
	private ISyncCorrespondenceResolver<Behavior, BehavioredClassifier> behaviorRedef;

	@Inject
	public CapsuleMapping(IFactory factory) {
		super(UMLPackage.Literals.CLASS, factory);
	}

	@Override
	protected void mapProperties(IOne<Class> parentCapsule, IOne<Class> childCapsule) {
		// Don't call super because we don't want to synchronize the names

		IBox<StateMachine> parentMachine = property(parentCapsule, UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR).select(StateMachine.class);
		IBox<StateMachine> childMachine = property(childCapsule, UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR).select(StateMachine.class);

		IBox<StateMachine> mapping = parentMachine.collectTo(m -> getCorresponding(m, childCapsule.get()));

		autoDisable(childCapsule, childMachine.bind(mapping));
	}

	protected StateMachine getCorresponding(StateMachine superMachine, Class subCapsule) {
		StateMachine result = (StateMachine) behaviorRedef.getCorrespondent(superMachine, subCapsule);

		stateMachine.map(superMachine, result);

		return result;
	}
}
