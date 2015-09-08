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
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.CapsuleMapping;
import org.eclipse.papyrus.aof.sync.tests.AbstractBaseMappingTest;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ResourceSetFixture;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.junit.Rule;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * Tests the {@link CapsuleMapping} class.
 */
@InjectWith(TestModelModule.class)
@JavaResource("capsules-with-machines.uml")
public class StateMachineMappingTest extends AbstractBaseMappingTest<Class> {
	@Rule
	public final ResourceSetFixture rset = new ResourceSetFixture();

	@Inject
	private UMLFactory uml;

	@Test
	public void synchInitialRegionFromParent() {
		StateMachine parent = as(getFrom().getClassifierBehavior(), StateMachine.class);
		assumeThat(parent, notNullValue());

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assumeThat(child, notNullValue());
		assumeThat(child, not(sameInstance(parent)));

		assertThat(child.getRegions().size(), is(1));
		Region region = child.getRegions().get(0);

		final Region parentRegion = parent.getRegions().get(0);
		assertThat(region.getName(), is(parentRegion.getName()));
		assertThat(region.getExtendedRegion(), is(parentRegion));
		assertThat(region.getSubvertices().size(), is(2));
		assertThat(region.getTransitions().size(), is(1));

		Pseudostate start = as(region.getSubvertex("start"), Pseudostate.class);
		assertThat(start, notNullValue());
		assertThat(start.getKind(), is(PseudostateKind.INITIAL_LITERAL));

		State open = as(region.getSubvertex("open"), State.class);
		assertThat(open, notNullValue());
		assertThat(open.getRedefinedState(), is(parentRegion.getSubvertex("open")));

		Transition attach = region.getTransition("attach");
		assertThat(attach, notNullValue());

		assertThat(attach.getSource(), is(start));
		assertThat(attach.getTarget(), is(open));
	}

	@Test
	public void addVertexAndTransitionToParent() {
		StateMachine parent = as(getFrom().getClassifierBehavior(), StateMachine.class);
		assumeThat(parent, notNullValue());
		final Region parentRegion = parent.getRegions().get(0);
		final State parentOpen = as(parentRegion.getSubvertex("open"), State.class);
		assumeThat(parentOpen, notNullValue());

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assumeThat(child, notNullValue());

		assumeThat(child.getRegions().size(), is(1));
		Region region = child.getRegions().get(0);
		final State open = as(region.getSubvertex("open"), State.class);
		assumeThat(open, notNullValue());

		FinalState parentEnd = uml.createFinalState();
		parentEnd.setName("end");
		rset.execute(AddCommand.create(rset.getEditingDomain(), parentRegion, UMLPackage.Literals.REGION__SUBVERTEX, parentEnd));

		Vertex end = region.getSubvertex("end");
		assertThat(end, instanceOf(FinalState.class));
		assertThat(((FinalState) end).getRedefinedState(), is(parentEnd));

		// Create a transition by first setting its source and target verticies
		// and then adding it to its region
		Transition parentTransition = uml.createTransition();
		parentTransition.setName("finish");
		rset.execute(
				SetCommand.create(rset.getEditingDomain(), parentTransition, UMLPackage.Literals.TRANSITION__SOURCE, parentOpen).chain(
						SetCommand.create(rset.getEditingDomain(), parentTransition, UMLPackage.Literals.TRANSITION__TARGET, parentEnd).chain(
								AddCommand.create(rset.getEditingDomain(), parentRegion, UMLPackage.Literals.REGION__TRANSITION, parentTransition))));

		Transition transition = region.getTransition("finish");
		assertThat(transition, notNullValue());
		assertThat(transition.getRedefinedTransition(), is(parentTransition));
		assertThat(transition.getSource(), is(open));
		assertThat(transition.getTarget(), is(end));
	}

	@Test
	public void addVertexAndTransitionToParent2() {
		StateMachine parent = as(getFrom().getClassifierBehavior(), StateMachine.class);
		assumeThat(parent, notNullValue());
		final Region parentRegion = parent.getRegions().get(0);
		final State parentOpen = as(parentRegion.getSubvertex("open"), State.class);
		assumeThat(parentOpen, notNullValue());

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assumeThat(child, notNullValue());

		assumeThat(child.getRegions().size(), is(1));
		Region region = child.getRegions().get(0);
		final State open = as(region.getSubvertex("open"), State.class);
		assumeThat(open, notNullValue());

		FinalState parentEnd = uml.createFinalState();
		parentEnd.setName("end");
		rset.execute(AddCommand.create(rset.getEditingDomain(), parentRegion, UMLPackage.Literals.REGION__SUBVERTEX, parentEnd));

		Vertex end = region.getSubvertex("end");
		assumeThat(end, instanceOf(FinalState.class));
		assumeThat(((FinalState) end).getRedefinedState(), is(parentEnd));

		// Create a transition by first adding it to its region and then
		// setting its source and target vertices
		Transition parentTransition = uml.createTransition();
		parentTransition.setName("finish");
		rset.execute(
				AddCommand.create(rset.getEditingDomain(), parentRegion, UMLPackage.Literals.REGION__TRANSITION, parentTransition).chain(
						SetCommand.create(rset.getEditingDomain(), parentTransition, UMLPackage.Literals.TRANSITION__SOURCE, parentOpen).chain(
								SetCommand.create(rset.getEditingDomain(), parentTransition, UMLPackage.Literals.TRANSITION__TARGET, parentEnd))));

		Transition transition = region.getTransition("finish");
		assertThat(transition, notNullValue());
		assertThat(transition.getRedefinedTransition(), is(parentTransition));
		assertThat(transition.getSource(), is(open));
		assertThat(transition.getTarget(), is(end));
	}
}
