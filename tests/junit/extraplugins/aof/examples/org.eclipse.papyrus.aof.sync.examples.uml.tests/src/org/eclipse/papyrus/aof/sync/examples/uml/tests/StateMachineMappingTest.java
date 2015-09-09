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

import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.CapsuleMapping;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the {@link CapsuleMapping} class.
 */
@JavaResource("capsules-with-machines.uml")
public class StateMachineMappingTest extends AbstractUMLMappingTest<Class> {
	private StateMachine parent;
	private StateMachine child;
	private Region parentRegion;
	private Region childRegion;

	@Test
	public void synchInitialRegionFromParent() {
		assertThat(childRegion.getName(), is(parentRegion.getName()));
		assertThat(childRegion.getExtendedRegion(), is(parentRegion));
		assertThat(childRegion.getSubvertices().size(), is(2));
		assertThat(childRegion.getTransitions().size(), is(1));

		Pseudostate start = as(childRegion.getSubvertex("start"), Pseudostate.class);
		assertThat(start, notNullValue());
		assertThat(start.getKind(), is(PseudostateKind.INITIAL_LITERAL));

		State open = as(childRegion.getSubvertex("open"), State.class);
		assertThat(open, notNullValue());
		assertThat(open.getRedefinedState(), is(parentRegion.getSubvertex("open")));

		Transition attach = childRegion.getTransition("attach");
		assertThat(attach, notNullValue());

		assertThat(attach.getSource(), is(start));
		assertThat(attach.getTarget(), is(open));
	}

	@Test
	public void addVertexAndTransitionToParent() {
		final State parentOpen = as(parentRegion.getSubvertex("open"), State.class);
		final State open = as(childRegion.getSubvertex("open"), State.class);
		assumeThat(open, notNullValue());

		FinalState parentEnd = create(parentRegion, UMLPackage.Literals.REGION__SUBVERTEX, FinalState.class, "end");

		Vertex end = childRegion.getSubvertex("end");
		assertThat(end, instanceOf(FinalState.class));
		assertThat(((FinalState) end).getRedefinedState(), is(parentEnd));

		// Create a transition by first setting its source and target verticies
		// and then adding it to its region
		Transition parentTransition = uml.createTransition();
		parentTransition.setName("finish");
		exec().set(parentTransition, UMLPackage.Literals.TRANSITION__SOURCE, parentOpen)
				.set(parentTransition, UMLPackage.Literals.TRANSITION__TARGET, parentEnd)
				.add(parentRegion, UMLPackage.Literals.REGION__TRANSITION, parentTransition)
				.execute();

		Transition transition = childRegion.getTransition("finish");
		assertThat(transition, notNullValue());
		assertThat(transition.getRedefinedTransition(), is(parentTransition));
		assertThat(transition.getSource(), is(open));
		assertThat(transition.getTarget(), is(end));
	}

	@Test
	public void addVertexAndTransitionToParent2() {
		final State parentOpen = as(parentRegion.getSubvertex("open"), State.class);
		final State open = as(childRegion.getSubvertex("open"), State.class);
		assumeThat(open, notNullValue());

		FinalState parentEnd = create(parentRegion, UMLPackage.Literals.REGION__SUBVERTEX, FinalState.class, "end");

		Vertex end = childRegion.getSubvertex("end");
		assumeThat(end, instanceOf(FinalState.class));
		assumeThat(((FinalState) end).getRedefinedState(), is(parentEnd));

		// Create a transition by first adding it to its region and then
		// setting its source and target vertices
		Transition parentTransition = uml.createTransition();
		parentTransition.setName("finish");
		exec().add(parentRegion, UMLPackage.Literals.REGION__TRANSITION, parentTransition)
				.set(parentTransition, UMLPackage.Literals.TRANSITION__SOURCE, parentOpen)
				.set(parentTransition, UMLPackage.Literals.TRANSITION__TARGET, parentEnd)
				.execute();

		Transition transition = childRegion.getTransition("finish");
		assertThat(transition, notNullValue());
		assertThat(transition.getRedefinedTransition(), is(parentTransition));
		assertThat(transition.getSource(), is(open));
		assertThat(transition.getTarget(), is(end));
	}

	@Test
	public void compositeState() {
		final State parentOpen = as(parentRegion.getSubvertex("open"), State.class);
		final State open = as(childRegion.getSubvertex("open"), State.class);
		assumeThat(open, notNullValue());

		// Make the parent 'open' state composite
		Region parentComposite = create(parentOpen, UMLPackage.Literals.STATE__REGION, Region.class, "composite");
		Region childComposite = open.getRegion("composite");
		assertThat(childComposite, notNullValue());
		assertThat(childComposite.getExtendedRegion(), is(parentComposite));

		// Create a nested state
		State parentNested = create(parentComposite, UMLPackage.Literals.REGION__SUBVERTEX, State.class, "nested");
		Vertex childNested = childComposite.getSubvertex("nested");
		assertThat(childNested, notNullValue());
		assertThat(childNested, instanceOf(State.class));
		assertThat(((State) childNested).getRedefinedState(), is(parentNested));

		Pseudostate parentFork = create(parentRegion, UMLPackage.Literals.REGION__SUBVERTEX, Pseudostate.class, "fork",
				fork -> fork.setKind(PseudostateKind.FORK_LITERAL));
		Vertex childFork = childRegion.getSubvertex("fork");
		assertThat(childFork, notNullValue());
		assertThat(childFork, instanceOf(Pseudostate.class));
		assertThat(((Pseudostate) childFork).getKind(), is(PseudostateKind.FORK_LITERAL));

		// And a transition from the nested state out of the composite
		Transition parentTransition = uml.createTransition();
		parentTransition.setName("finish");
		exec().add(parentComposite, UMLPackage.Literals.REGION__TRANSITION, parentTransition)
				.set(parentTransition, UMLPackage.Literals.TRANSITION__SOURCE, parentNested)
				.set(parentTransition, UMLPackage.Literals.TRANSITION__TARGET, parentFork)
				.execute();

		Transition transition = childComposite.getTransition("finish");
		assertThat(transition, notNullValue());
		assertThat(transition.getRedefinedTransition(), is(parentTransition));
		assertThat(transition.getSource(), is(childNested));
		assertThat(transition.getTarget(), is(childFork));
	}

	//
	// Test framework
	//

	@Before
	public void getSignposts() {
		parent = as(getFrom().getClassifierBehavior(), StateMachine.class);
		assumeThat(parent, notNullValue());
		assumeThat(parent.getRegions().size(), is(1));
		parentRegion = parent.getRegions().get(0);

		child = as(getTo().getClassifierBehavior(), StateMachine.class);
		assumeThat(child, notNullValue());
		assumeThat(child, not(sameInstance(parent)));

		assumeThat(child.getRegions().size(), is(1));
		childRegion = child.getRegions().get(0);
	}
}
