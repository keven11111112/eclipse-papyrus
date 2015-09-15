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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.gef.ui.views.palette.PaletteView;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.junit.utils.rules.ShowView;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Generalization;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the mappings of capsule (class) diagrams.
 */
@PluginResource("resources/capsules.di")
@ActiveDiagram(CapsuleDiagramMappingTest.CAPSULES)
@ShowView(PaletteView.ID)
public class CapsuleDiagramMappingTest extends AbstractDiagramSyncTest {
	static final String CAPSULES = "Capsules";
	static final String DOPPELGANGERS = "Doppelgangers";

	private Class capsule1;
	private Class capsule2;
	private Class someClass;

	@Test
	public void topShapeViews() {
		requireView(capsule1);
		requireView(capsule2);
		requireView(someClass);
	}

	@Test
	public void childLabelViews() {
		requireView(someClass.getOwnedAttribute("isOK", null));
	}

	@Test
	public void connectorViews() {
		Edge edge = requireEdge(requireView(capsule2), requireView(capsule1));
		assertThat(edge.getElement(), instanceOf(Generalization.class));
	}

	@Test
	public void addConnector() {
		// Add a new connector in the original diagram
		editor.activateDiagram(CAPSULES);
		Dependency dependency = createDependencyWithView(capsule1, someClass);

		// Verify the new connector in the other
		editor.activateDiagram(DOPPELGANGERS);
		requireView(dependency);
	}

	@Test
	public void moveCapsule() {
		// Move a capsule in the original diagram
		editor.activateDiagram(CAPSULES);
		Shape original = requireShape(capsule1);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newX = bounds.getX() + 30;
		int newY = bounds.getY() + 30;
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// Verify the location in the other
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule1);
		assumeThat(other, not(is(original)));
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getX(), is(newX));
		assertThat(otherBounds.getY(), is(newY));
	}

	@Test
	public void resizeCapsule() {
		// Resize a capsule in the original diagram
		editor.activateDiagram(CAPSULES);
		Shape original = requireShape(capsule1);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newW = 150;
		int newH = 150;
		execute(() -> {
			bounds.setWidth(newW);
			bounds.setHeight(newH);
		});

		// Verify the size in the other
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule1);
		assumeThat(other, not(is(original)));
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getWidth(), is(newW));
		assertThat(otherBounds.getHeight(), is(newH));
	}

	@Test
	public void undoSynchronizedChange() {
		// First, grab the original location of the doppelganger
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule1);
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		final int oldX = otherBounds.getX();
		final int oldY = otherBounds.getY();

		// Move a capsule in the original diagram
		editor.activateDiagram(CAPSULES);
		Shape original = requireShape(capsule1);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newX = bounds.getX() + 30;
		int newY = bounds.getY() + 30;
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// Assume the new location in the other (verified by another test case)
		editor.activateDiagram(DOPPELGANGERS);
		otherBounds = (Bounds) other.getLayoutConstraint();
		assumeThat(otherBounds.getX(), is(newX));
		assumeThat(otherBounds.getY(), is(newY));

		// Undo the move
		undo();

		// Verify both diagrams
		otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getX(), is(oldX));
		assertThat(otherBounds.getY(), is(oldY));
		Bounds originalBounds = (Bounds) original.getLayoutConstraint();
		assertThat(originalBounds.getX(), not(newX));
		assertThat(originalBounds.getY(), not(newY));
	}

	@Test
	public void redoSynchronizedChange() {
		// First, grab the original location of the doppelganger
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule1);
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		final int oldX = otherBounds.getX();
		final int oldY = otherBounds.getY();

		// Move a capsule in the original diagram
		editor.activateDiagram(CAPSULES);
		Shape original = requireShape(capsule1);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newX = bounds.getX() + 30;
		int newY = bounds.getY() + 30;
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// Assume the new location in the other (verified by another test case)
		editor.activateDiagram(DOPPELGANGERS);
		otherBounds = (Bounds) other.getLayoutConstraint();
		assumeThat(otherBounds.getX(), is(newX));
		assumeThat(otherBounds.getY(), is(newY));

		// Undo the move
		undo();

		// Assume both diagrams (verified by another test case)
		otherBounds = (Bounds) other.getLayoutConstraint();
		assumeThat(otherBounds.getX(), is(oldX));
		assumeThat(otherBounds.getY(), is(oldY));
		Bounds originalBounds = (Bounds) original.getLayoutConstraint();
		assumeThat(originalBounds.getX(), not(newX));
		assumeThat(originalBounds.getY(), not(newY));

		// Redo the move
		redo();

		editor.activateDiagram(DOPPELGANGERS);
		otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getX(), is(newX));
		assertThat(otherBounds.getY(), is(newY));
	}

	@Test
	public void undoSynchronization() {
		// First, grab the original location of the doppelganger
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule1);
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		final int oldX = otherBounds.getX();
		final int oldY = otherBounds.getY();

		// Move a capsule in the original diagram
		editor.activateDiagram(CAPSULES);
		Shape original = requireShape(capsule1);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newX = bounds.getX() + 30;
		int newY = bounds.getY() + 30;
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// Assume the new location in the other (verified by another test case)
		editor.activateDiagram(DOPPELGANGERS);
		assumeThat(otherBounds.getX(), is(newX));
		assumeThat(otherBounds.getY(), is(newY));

		// Undo the move
		undo();

		// Assume the old location in the other (verified by another test case)
		otherBounds = (Bounds) other.getLayoutConstraint();
		assumeThat(otherBounds.getX(), is(oldX));
		assumeThat(otherBounds.getY(), is(oldY));

		// Undo the synchronization set-up
		undo();

		// Repeat the move
		editor.activateDiagram(CAPSULES);
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// The doppelganger is no longer synchronized
		otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getX(), is(oldX));
		assertThat(otherBounds.getY(), is(oldY));
	}

	@Test
	public void redoSynchronization() {
		// First, grab the original location of the doppelganger
		editor.activateDiagram(DOPPELGANGERS);
		Shape other = requireShape(capsule1);
		Bounds otherBounds = (Bounds) other.getLayoutConstraint();
		final int oldX = otherBounds.getX();
		final int oldY = otherBounds.getY();

		// Move a capsule in the original diagram
		editor.activateDiagram(CAPSULES);
		Shape original = requireShape(capsule1);

		Bounds bounds = (Bounds) original.getLayoutConstraint();
		int newX = bounds.getX() + 30;
		int newY = bounds.getY() + 30;
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// Assume the new location in the other (verified by another test case)
		editor.activateDiagram(DOPPELGANGERS);
		assumeThat(otherBounds.getX(), is(newX));
		assumeThat(otherBounds.getY(), is(newY));

		// Undo the move
		undo();

		// Assume the old location in the other (verified by another test case)
		otherBounds = (Bounds) other.getLayoutConstraint();
		assumeThat(otherBounds.getX(), is(oldX));
		assumeThat(otherBounds.getY(), is(oldY));

		// Undo the synchronization set-up
		undo();

		// Redo it
		redo();

		// Repeat the move
		editor.activateDiagram(CAPSULES);
		execute(() -> {
			bounds.setX(newX);
			bounds.setY(newY);
		});

		// The doppelganger is once again synchronized
		otherBounds = (Bounds) other.getLayoutConstraint();
		assertThat(otherBounds.getX(), is(newX));
		assertThat(otherBounds.getY(), is(newY));
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
		capsule1 = (Class) editor.getModel().getOwnedType("Capsule1");
		capsule2 = (Class) editor.getModel().getOwnedType("Capsule2");
		someClass = (Class) editor.getModel().getOwnedType("SomeClass");
	}
}
