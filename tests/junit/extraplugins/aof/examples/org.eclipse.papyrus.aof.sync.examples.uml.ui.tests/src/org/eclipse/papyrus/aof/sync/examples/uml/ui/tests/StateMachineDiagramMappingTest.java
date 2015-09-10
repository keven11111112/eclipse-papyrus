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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;

import org.eclipse.gef.ui.views.palette.PaletteView;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers.SynchronizeCapsulesHandler;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.junit.utils.rules.ShowView;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the mappings of capsule (class) diagrams.
 */
@PluginResource("resources/capsules-with-machines.di")
@ActiveDiagram(StateMachineDiagramMappingTest.LIFECYCLE)
@ShowView(PaletteView.ID)
public class StateMachineDiagramMappingTest extends AbstractDiagramSyncTest {
	static final String LIFECYCLE = "Lifecycle";
	static final String DOPPELGANGERS = "Doppelgangers";

	private StateMachine capsule1Behavior;
	private Region capsule1Region;
	private State capsule1Open;

	private StateMachine capsule2Behavior;
	private Region capsule2Region;
	private Pseudostate capsule2Start;
	private State capsule2Open;
	private Transition capsule2Attach;

	@Test
	public void topShapeViews() {
		requireView(capsule2Behavior);
	}

	@Test
	public void nestedShapeViews() {
		requireView(capsule2Start);
		requireView(capsule2Open);
	}

	@Test
	public void connectorViews() {
		requireView(capsule2Attach);
	}

	@Test
	public void addShapeAndConnector() {
		// Add a new shape and connector in the original diagram
		editor.activateDiagram(LIFECYCLE);
		FinalState capsule1End = createFinalStateWithView(capsule1Region, "end");
		createTransitionWithView(capsule1Open, capsule1End, "detach");

		// Verify the new shape and connector in the other
		editor.activateDiagram(DOPPELGANGERS);
		assertThat(capsule2Region.getSubvertex("end"), instanceOf(FinalState.class));
		FinalState capsule2End = (FinalState) capsule2Region.getSubvertex("end");
		Transition capsule2Detach = capsule2Region.getTransition("detach");
		assertThat(capsule2Detach, notNullValue());
		requireView(capsule2End);
		requireView(capsule2Detach);
	}

	@Test
	public void moveState() {
		// Move a state in the original diagram
		editor.activateDiagram(LIFECYCLE);
		Shape original = requireShape(capsule1Open);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newX = bounds.getX() + 30;
		int newY = bounds.getY() + 30;
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// Verify the location in the other
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule2Open);
		assumeThat(other, not(is(original)));
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getX(), is(newX));
		assertThat(otherBounds.getY(), is(newY));
	}

	@Test
	public void resizeState() {
		// Resize a state in the original diagram
		editor.activateDiagram(LIFECYCLE);
		Shape original = requireShape(capsule1Open);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newW = 115;
		int newH = 115;
		execute(() -> {
			bounds.setWidth(newW);
			bounds.setHeight(newH);
		});

		// Verify the size in the other
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule2Open);
		assumeThat(other, not(is(original)));
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getWidth(), is(newW));
		assertThat(otherBounds.getHeight(), is(newH));
	}

	//
	// Test framework
	//

	@Before
	public void switchActiveDiagram() {
		editor.activateDiagram(DOPPELGANGERS);
	}

	@Before
	public void gatherElements() {
		Class capsule1 = (Class) editor.getModel().getOwnedType("Capsule1");
		capsule1Behavior = (StateMachine) capsule1.getClassifierBehavior();
		capsule1Region = capsule1Behavior.getRegions().get(0);
		capsule1Open = (State) capsule1Region.getSubvertex("open");

		Class capsule2 = (Class) editor.getModel().getOwnedType("Capsule2");
		capsule2Behavior = (StateMachine) capsule2.getClassifierBehavior();
		capsule2Region = capsule2Behavior.getRegions().get(0);
		capsule2Start = (Pseudostate) capsule2Region.getSubvertex("start");
		capsule2Open = (State) capsule2Region.getSubvertex("open");
		capsule2Attach = capsule2Region.getTransition("attach");

		// Synchronize the capsules for creation of new elements
		new SynchronizeCapsulesHandler().synchronize(Arrays.asList(capsule1, capsule2));
	}
}
