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

package org.eclipse.papyrus.infra.gmfdiag.canonical.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the CSS-based canonical presentation of composite structures.
 */
@PluginResource("models/composite.di")
@ActiveDiagram("main")
public class CSSCanonicalCompositeDiagramTest extends AbstractCSSCanonicalTest {

	private org.eclipse.uml2.uml.Class blackBox;
	private Property blackBox_nested;
	private Port blackBox_output;
	private Connector blackBox_delegateToBlueBox;

	private org.eclipse.uml2.uml.Class blueBox;
	private Property blueBox_nested;
	private Port blueBox_output;

	public CSSCanonicalCompositeDiagramTest() {
		super();
	}

	/**
	 * Tests that recursive structures are "safe" in a fully canonical presentation (that they
	 * do not induce unbounded recursion in creation of nested visuals).
	 */
	@CSSResource("models/compositediagram.css")
	@NeedsUIEvents
	@Test
	public void recursiveStructureCanonical() {
		Map<EObject, View> views = requireViews(blackBox_nested, blackBox_output, blueBox_nested, blueBox_output, blackBox_delegateToBlueBox);

		// The blueBox part in the blackBox structure shows nested structure
		requireView(blueBox_nested, views.get(blackBox_nested));
		requireView(blueBox_output, views.get(blackBox_nested));

		// But, the blackBox part nested inside of the blueBox part in the blackBox structure
		// does not show recursive structure
		assertNoView(blackBox_nested, views.get(blueBox_nested));
		assertNoView(blackBox_output, views.get(blueBox_nested));

		// All ports show the connectors that they should
		View blackBoxPortView = requireView(blackBox_output, requireView(blackBox));
		assertThat("Wrong number of edges attached to class's port", blackBoxPortView.getSourceEdges().size() + blackBoxPortView.getTargetEdges().size(), is(1));
		View blueBoxPortView = requireView(blueBox_output, requireView(blackBox_nested));
		assertThat("Wrong number of edges attached to part's port", blueBoxPortView.getSourceEdges().size() + blueBoxPortView.getTargetEdges().size(), is(1));
	}

	/**
	 * Tests that parts and connectors added to a composite structure are correctly reflected
	 * in the diagram.
	 */
	@CSSResource("models/compositediagram.css")
	@NeedsUIEvents
	@Test
	public void addPartAndConnector() {
		// Create a new part and a connector between it and the existing part
		final Property otherBox = UMLFactory.eINSTANCE.createProperty();
		otherBox.setName("otherBox");
		otherBox.setType(blueBox);

		final Connector assembly = UMLFactory.eINSTANCE.createConnector();
		assembly.createEnd().setRole(blackBox_nested);
		assembly.createEnd().setRole(otherBox);

		add(blackBox, otherBox, UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE);
		add(blackBox, assembly, UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_CONNECTOR);

		// Views should have been created for these new things
		Map<EObject, View> newViews = requireViews(otherBox, assembly);
		View otherPartView = newViews.get(otherBox);

		// And the new part of BlueBox type also has canonical contents (because of the CSS stylesheet)
		requireView(blueBox_nested, otherPartView);
		View otherPartPortView = requireView(blueBox_output, otherPartView);

		// All ports show the connectors that they should
		View blackBoxPortView = requireView(blackBox_output, requireView(blackBox));
		assertThat("Wrong number of edges attached to class's port", blackBoxPortView.getSourceEdges().size() + blackBoxPortView.getTargetEdges().size(), is(1));
		View blueBoxPortView = requireView(blueBox_output, requireView(blackBox_nested));
		assertThat("Wrong number of edges attached to part's port", blueBoxPortView.getSourceEdges().size() + blueBoxPortView.getTargetEdges().size(), is(1));

		// This one has none, of course, because we haven't connected to this part via this port
		assertThat("Wrong number of edges attached to otherPart's port", otherPartPortView.getSourceEdges().size() + otherPartPortView.getTargetEdges().size(), is(0));
	}

	//
	// Test framework
	//
	@Before
	public void getModelElements() {
		org.eclipse.uml2.uml.Package root = editor.getModel();
		blackBox = (org.eclipse.uml2.uml.Class) root.getOwnedType("BlackBox");
		blackBox_nested = blackBox.getOwnedAttribute("nested", null);
		blackBox_output = blackBox.getOwnedPort("output", null);
		blackBox_delegateToBlueBox = blackBox.getOwnedConnector("delegateToBlueBox");

		blueBox = (org.eclipse.uml2.uml.Class) root.getOwnedType("BlueBox");
		blueBox_nested = blueBox.getOwnedAttribute("nested", null);
		blueBox_output = blueBox.getOwnedPort("output", null);
	}

}
