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

package org.eclipse.papyrus.aof.sync.examples.uml.tests;

import static org.eclipse.papyrus.infra.tools.util.TypeUtils.as;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.CapsuleMapping;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * Tests the {@link CapsuleMapping} class.
 */
@JavaResource("capsules.uml")
public class CapsuleMappingTest extends AbstractUMLMappingTest<Class> {
	@Test
	public void addStateMachineToParent() {
		assertThat(getTo().getClassifierBehavior(), nullValue());

		StateMachine parent = uml.createStateMachine();
		parent.setName("Lifecycle");
		set(getFrom(), UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR, parent);

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assertThat(child, notNullValue());
		assertThat(child, not(sameInstance(parent)));
		assertThat(child.getName(), is(parent.getName()));
	}

	@Test
	@JavaResource("capsules-with-machines.uml")
	public void synchStateMachineFromParent() {
		StateMachine parent = as(getFrom().getClassifierBehavior(), StateMachine.class);
		assertThat(parent, notNullValue());

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assertThat(child, notNullValue());
		assertThat(child, not(sameInstance(parent)));
		assertThat(child.getName(), is(parent.getName()));
	}
}
