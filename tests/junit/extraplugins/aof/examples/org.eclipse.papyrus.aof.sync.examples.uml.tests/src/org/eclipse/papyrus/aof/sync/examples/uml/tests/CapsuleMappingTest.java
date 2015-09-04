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
import static org.junit.Assume.assumeThat;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingFactory;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.CapsuleMapping;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ResourceSetFixture;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests the {@link CapsuleMapping} class.
 */
@JavaResource("capsules.uml")
public class CapsuleMappingTest extends AbstractPapyrusTest {
	static final UMLFactory UML = UMLFactory.eINSTANCE;

	@Rule
	public final ResourceSetFixture rset = new ResourceSetFixture();

	private IMapping<Class> fixture;

	private Class capsule1;
	private Class capsule2;

	@Test
	public void addStateMachineToParent() {
		fixture.map(capsule1, capsule2);

		assertThat(capsule2.getClassifierBehavior(), nullValue());

		StateMachine parent = UML.createStateMachine();
		parent.setName("Lifecycle");
		rset.execute(SetCommand.create(rset.getEditingDomain(), capsule1, UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR, parent));

		StateMachine child = as(capsule2.getClassifierBehavior(), StateMachine.class);
		assertThat(child, notNullValue());
		assertThat(child, not(sameInstance(parent)));
		assertThat(child.getName(), is(parent.getName()));
	}

	@Test
	@JavaResource("capsules-with-machines.uml")
	public void synchStateMachineFromParent() {
		// Initially, there is a state machine in the super-capsule
		assumeThat(capsule1.getClassifierBehavior(), notNullValue());

		// but not in the sub-capsule
		assumeThat(capsule2.getClassifierBehavior(), nullValue());

		fixture.map(capsule1, capsule2);

		StateMachine parent = as(capsule1.getClassifierBehavior(), StateMachine.class);
		assertThat(parent, notNullValue());

		StateMachine child = as(capsule2.getClassifierBehavior(), StateMachine.class);
		assertThat(child, notNullValue());
		assertThat(child, not(sameInstance(parent)));
		assertThat(child.getName(), is(parent.getName()));
	}

	//
	// Test framework
	//

	@Before
	public void setup() {
		fixture = new UMLRTMappingFactory().getCapsuleMapping();

		capsule1 = (Class) rset.getModel().getOwnedType("Capsule1");
		capsule2 = (Class) rset.getModel().getOwnedType("Capsule2");
	}
}
