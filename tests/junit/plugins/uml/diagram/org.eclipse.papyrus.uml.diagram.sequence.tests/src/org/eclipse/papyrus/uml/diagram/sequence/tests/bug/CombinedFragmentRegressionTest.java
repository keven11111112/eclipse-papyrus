/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.greaterThan;
import static org.eclipse.papyrus.junit.matchers.MoreMatchers.isEmpty;
import static org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture.at;
import static org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture.sized;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.Consumer;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.matchers.DiagramMatchers;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;
import org.junit.Rule;
import org.junit.Test;

/**
 * Regression tests specifically for {@link CombinedFragment}s in the sequence diagram
 * editor, especially those tracked under the umbrella of <a href="http://eclip.se/533670">bug 533670</a>.
 * 
 * @author Christian W. Damus
 * @see <a href="http://eclip.se/533670">bug 533670</a>
 */
public class CombinedFragmentRegressionTest extends AbstractPapyrusTest {

	@Rule
	public final PapyrusEditorFixture editor = new PapyrusEditorFixture();

	/**
	 * Initializes me.
	 */
	public CombinedFragmentRegressionTest() {
		super();
	}

	/**
	 * Verify the creation and extent of a default interaction operand in a newly
	 * created combined fragment.
	 */
	@Test
	@PluginResource("resource/bugs/bug533673.di")
	@ActiveDiagram("sequence")
	public void defaultInteractionOperand_533673() {
		EditPart interactionEP = editor.findEditPart("DoIt", Interaction.class);
		EditPart interactionCompartment = editor.getShapeCompartment(interactionEP);

		EditPart combinedFragment = editor.createShape(interactionCompartment, UMLElementTypes.CombinedFragment_Shape, at(15, 60), sized(360, 200));

		assertThat(combinedFragment, DiagramMatchers.semanticThat(instanceOf(CombinedFragment.class)));
		CombinedFragment cf = (CombinedFragment) combinedFragment.getAdapter(EObject.class);

		assertThat("No interaction operand", cf.getOperands(), not(isEmpty()));

		InteractionOperand operand = cf.getOperands().get(0);
		EditPart operandEP = editor.requireEditPart(combinedFragment, operand);

		assertThat(operandEP, instanceOf(GraphicalEditPart.class));
		IFigure figure = ((GraphicalEditPart) operandEP).getFigure();

		Consumer<Rectangle> verifyBounds = bounds -> {
			// Account for margins
			assertThat("Width too small", bounds.width, greaterThan(350));
			// Account for some space for the combined fragment operator label
			// and some extra for font size variance across platforms (esp.
			// Linux and Windows, which seem to be bigger than MacOS)
			assertThat("Height too small", bounds.height, greaterThan(160));
		};

		verifyBounds.accept(figure.getBounds());

		editor.undo();

		operandEP = editor.findEditPart(operand);
		assertThat("Operand still present in the diagram", operandEP, nullValue());

		editor.redo();

		operandEP = editor.findEditPart(operand);
		assertThat(operandEP, instanceOf(GraphicalEditPart.class));
		figure = ((GraphicalEditPart) operandEP).getFigure();
		verifyBounds.accept(figure.getBounds());
	}

}
