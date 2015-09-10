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
