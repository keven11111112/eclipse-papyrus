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

import javax.inject.Inject;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.papyrus.aof.sync.tests.AbstractBaseMappingTest;
import org.eclipse.papyrus.aof.sync.tests.ModelFixtureRuleModule;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.ServiceRegistryModelSetFixture;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests the {@link CapsuleSyncServiceDelegateTest} class, indirectly.
 */
@InjectWith({ ModelFixtureRuleModule.class, TestModelModule.class })
@JavaResource("capsules.di")
public class CapsuleSyncServiceDelegateTest extends AbstractBaseMappingTest<Class, Class> {
	@Rule
	public final ModelSetFixture rset = new ServiceRegistryModelSetFixture();

	@Inject
	protected UMLFactory uml;

	public CapsuleSyncServiceDelegateTest() {
		super();
	}

	@Test
	public void addStateMachineToParent() {
		assertThat(getTo().getClassifierBehavior(), nullValue());

		StateMachine parent = uml.createStateMachine();
		parent.setName("Lifecycle");
		rset.getEditingDomain().getCommandStack().execute(SetCommand.create(rset.getEditingDomain(),
				getFrom(), UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR, parent));

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assertThat(child, notNullValue());
		assertThat(child, not(sameInstance(parent)));
		assertThat(child.getName(), is(parent.getName()));
	}

	@Test
	@JavaResource("capsules-with-machines.di")
	public void synchStateMachineFromParent() {
		StateMachine parent = as(getFrom().getClassifierBehavior(), StateMachine.class);
		assertThat(parent, notNullValue());

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assertThat(child, notNullValue());
		assertThat(child, not(sameInstance(parent)));
		assertThat(child.getName(), is(parent.getName()));
	}

	//
	// Test framework
	//

	@Override
	@Before
	public void performMapping() {
		// Don't actually do the mapping (the ISyncService triggers it automatically)
	}

}
