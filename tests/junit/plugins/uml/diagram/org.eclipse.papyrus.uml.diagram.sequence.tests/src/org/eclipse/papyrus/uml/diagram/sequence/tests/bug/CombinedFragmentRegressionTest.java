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
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

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
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
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

	/**
	 * Verify that the deletion of an interaction operand does not delete the
	 * interaction fragments that it owns, but transfers them up to the next
	 * fragment container.
	 */
	@Test
	@PluginResource("resource/bugs/bug533682.di")
	@ActiveDiagram("sequence")
	public void deleteInteractionOperand() {
		EditPart combinedFragmentEP = editor.findEditPart("cfrag", CombinedFragment.class);
		CombinedFragment cfrag = (CombinedFragment) combinedFragmentEP.getAdapter(EObject.class);
		Interaction interaction = cfrag.getEnclosingInteraction();
		assumeThat("No interaction", interaction, notNullValue());

		InteractionOperand operand = cfrag.getOperands().get(0);
		EditPart operandEP = editor.requireEditPart(combinedFragmentEP, operand);

		// We have at least four message ends and one execution specification
		InteractionFragment[] fragments = operand.getFragments().toArray(new InteractionFragment[0]);
		assumeThat("Lost fragments on opening editor", fragments.length, greaterThan(4));
		ExecutionSpecification exec = (ExecutionSpecification) operand.getFragment("exec");
		assumeThat("No execution specification", exec, notNullValue());

		editor.delete(operandEP);

		assertThat("Interaction fragments not retained", interaction.getFragments(), hasItems(fragments));
		assertThat("Execution specification lost from diagram", editor.findEditPart(exec), notNullValue());

		// Cannot test undo/redo because after Undo, the GridManagementEditPolicy
		// erroneously adds the combined fragment to the fragments of the operand
		// that is restored to its operands list, which is a containment cycle
		// that breaks EMF
	}

	/**
	 * Verify that the deletion of a combined fragment does not delete the
	 * interaction fragments that its operand owns, but transfers them up to the next
	 * fragment container.
	 */
	@Test
	@PluginResource("resource/bugs/bug533682.di")
	@ActiveDiagram("sequence")
	public void deleteCombinedFragment() {
		EditPart combinedFragmentEP = editor.findEditPart("cfrag", CombinedFragment.class);
		CombinedFragment cfrag = (CombinedFragment) combinedFragmentEP.getAdapter(EObject.class);
		Interaction interaction = cfrag.getEnclosingInteraction();
		assumeThat("No interaction", interaction, notNullValue());

		InteractionOperand operand = cfrag.getOperands().get(0);

		// We have at least four message ends and one execution specification
		InteractionFragment[] fragments = operand.getFragments().toArray(new InteractionFragment[0]);
		assumeThat("Lost fragments on opening editor", fragments.length, greaterThan(4));
		ExecutionSpecification exec = (ExecutionSpecification) operand.getFragment("exec");
		assumeThat("No execution specification", exec, notNullValue());

		editor.delete(combinedFragmentEP);

		assertThat("Interaction fragments not retained", interaction.getFragments(), hasItems(fragments));
		assertThat("Execution specification lost from diagram", editor.findEditPart(exec), notNullValue());
	}

	/**
	 * Verify that the deletion of an interaction fragment inside of an operand
	 * is not impeded.
	 */
	@Test
	@PluginResource("resource/bugs/bug533682.di")
	@ActiveDiagram("sequence")
	public void deleteInteractionFragmentInOperand() {
		EditPart combinedFragmentEP = editor.findEditPart("cfrag", CombinedFragment.class);
		CombinedFragment cfrag = (CombinedFragment) combinedFragmentEP.getAdapter(EObject.class);
		Interaction interaction = cfrag.getEnclosingInteraction();
		assumeThat("No interaction", interaction, notNullValue());

		InteractionOperand operand = cfrag.getOperands().get(0);

		// Find the execution specification
		EditPart execEP = editor.findEditPart("exec", ExecutionSpecification.class);
		ExecutionSpecification exec = (ExecutionSpecification) execEP.getAdapter(EObject.class);

		editor.delete(execEP);

		assertThat("Execution specification not deleted", exec.eResource(), nullValue());
		assertThat("Operand still has the execution specification", operand.getFragments(), not(hasItem(exec)));
		assertThat("Interaction has the execution specification", interaction.getFragments(), not(hasItem(exec)));

		execEP = editor.findEditPart("exec", ExecutionSpecification.class);
		assertThat("Execution specification still presented in diagram", execEP, nullValue());
	}

	/**
	 * Verify that the deletion of the interaction is not impeded.
	 */
	@Test
	@PluginResource("resource/bugs/bug533682.di")
	@ActiveDiagram("sequence")
	public void deleteInteraction() {
		EditPart combinedFragmentEP = editor.findEditPart("cfrag", CombinedFragment.class);
		CombinedFragment cfrag = (CombinedFragment) combinedFragmentEP.getAdapter(EObject.class);
		Interaction interaction = cfrag.getEnclosingInteraction();
		assumeThat("No interaction", interaction, notNullValue());

		// Find the execution specification
		EditPart execEP = editor.findEditPart("exec", ExecutionSpecification.class);
		ExecutionSpecification exec = (ExecutionSpecification) execEP.getAdapter(EObject.class);

		EditPart interactionEP = editor.requireEditPart(editor.getActiveDiagram(), interaction);
		editor.delete(interactionEP);

		assertThat("Execution specification not deleted", exec.eResource(), nullValue());
		assertThat("Interaction not deleted", interaction.eResource(), nullValue());
	}
}
