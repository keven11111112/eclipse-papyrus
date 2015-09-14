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
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Mapping of the state machines in a behaviored classifier.
 */
@Singleton
public class StateMachineMapping extends NamedElementMapping<StateMachine> {
	@Inject
	private ISyncMapping<Region> region;

	@Inject
	private ISyncCorrespondenceResolver<Region, StateMachine> regionRedef;

	@Inject
	public StateMachineMapping(IFactory factory) {
		super(UMLPackage.Literals.STATE_MACHINE, factory);
	}

	@Override
	protected void mapProperties(IOne<StateMachine> parentMachine, IOne<StateMachine> childMachine) {
		super.mapProperties(parentMachine, childMachine);

		bindPropertyValue(parentMachine.asOrderedSet(), childMachine, UMLPackage.Literals.BEHAVIOR__REDEFINED_BEHAVIOR);

		mapCorresponding(parentMachine, childMachine, UMLPackage.Literals.STATE_MACHINE__REGION, regionRedef, region);
	}
}
