/*****************************************************************************
 * Copyright (c) 2018 EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.requests.MoveSeparatorRequest;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

/**
 * <p>
 * Test the semantic coverage update when the CombinedFragment and/or operands
 * are updated visually (Creation/Deletion/Resize/Move).
 * </p>
 */
// Test class for Bug 535097
@PluginResource({ "resource/bugs/bug535097-OperandsSemantic.di", "resource/bugs/style.css" })
@ActiveDiagram("SemanticCoverageTest")
public class TestCFOperandsSemanticCoverage {

	@Rule
	public final PapyrusEditorFixture editor = new PapyrusEditorFixture();

	private IGraphicalEditPart cfPart;
	private IGraphicalEditPart operandPart;

	private IGraphicalEditPart message10;
	private IGraphicalEditPart message11;
	private IGraphicalEditPart message12;

	private IGraphicalEditPart exec1;
	private IGraphicalEditPart exec2;

	@Before
	public void initParts() {
		cfPart = (IGraphicalEditPart) editor.findEditPart("TestFragment", CombinedFragment.class);
		operandPart = (IGraphicalEditPart) editor.findEditPart("InteractionOperand0", InteractionOperand.class);

		message10 = (IGraphicalEditPart) editor.findEditPart("Message10", Message.class);
		message11 = (IGraphicalEditPart) editor.findEditPart("Message11", Message.class);
		message12 = (IGraphicalEditPart) editor.findEditPart("Message12", Message.class);

		exec1 = (IGraphicalEditPart) editor.findEditPart("Exec1", ActionExecutionSpecification.class);
		exec2 = (IGraphicalEditPart) editor.findEditPart("Exec2", ActionExecutionSpecification.class);
	}

	// The coverage is already set properly in the test model.
	// This test is here to make sure that opening the diagram doesn't
	// break the current values by incorrectly changing them.
	@Test
	public void testInitialCoverage() {
		assertCovered(message10, operandPart);
		assertCovered(message11, operandPart);
		assertCovered(exec1, operandPart);

		assertNotCovered(message12, operandPart);
		assertNotCovered(exec2, operandPart);
	}

	@Test
	public void testExpandCF() {
		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		request.setEditParts(cfPart);
		request.setResizeDirection(PositionConstants.SOUTH_EAST);

		// Expand the Fragment (South-East)
		request.setSizeDelta(new Dimension(40, 160)); // Cover Exec2, and Message12#start

		editor.execute(cfPart.getCommand(request));

		assertCovered(message10, operandPart);
		assertCovered(message11, operandPart);
		assertCovered(exec1, operandPart);
		assertCovered(exec2, operandPart);

		assertCoverage(getSend(message12), getOperand(operandPart), true);
		assertCoverage(getReceive(message12), getOperand(operandPart), false);
	}

	@Test
	@Ignore
	public void testExpandCFWidth() {
		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		request.setEditParts(cfPart);
		request.setResizeDirection(PositionConstants.SOUTH_EAST);

		// Expand the Fragment (South-East)
		request.setSizeDelta(new Dimension(200, 160));

		editor.execute(cfPart.getCommand(request));

		// TODO Assert

		// assertCovered(message10, operandPart);
		// assertCovered(message11, operandPart);
		// assertCovered(exec1, operandPart);
		// assertCovered(exec2, operandPart);
		//
		// assertCoverage(getSend(message12), getOperand(operandPart), true);
		// assertCoverage(getReceive(message12), getOperand(operandPart), false);
	}

	@Test
	public void testShrinkCF() {
		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		request.setEditParts(cfPart);
		request.setResizeDirection(PositionConstants.SOUTH_EAST);

		// Shrink the Fragment (South-East)
		request.setSizeDelta(new Dimension(0, -100)); // Between Message10 and Message11, only partially covers Exec1

		editor.execute(cfPart.getCommand(request));

		assertCovered(message10, operandPart);
		assertNotCovered(message11, operandPart);

		assertCoverage(getStart(exec1), getOperand(operandPart), true);
		assertCoverage(getFinish(exec1), getOperand(operandPart), false);

		assertNotCovered(exec2, operandPart);
		assertNotCovered(message12, operandPart);
	}

	@Test
	@Ignore
	public void testCreateCombinedFragmentSpecificSize() {
		// Create a fragment with a predefined size

	}

	@Test
	public void testCreateOperand() {
		IGraphicalEditPart operand2Part = createOperand(operandPart, at(200, 100, cfPart)); // Between Message10 and Message11

		// Covered by the first operand
		assertCovered(message10, operandPart);
		assertCoverage(getStart(exec1), getOperand(operandPart), true);

		// Covered by the second operand
		assertCovered(message11, operand2Part);
		assertCoverage(getFinish(exec1), getOperand(operand2Part), true);

		// Not covered
		assertNotCovered(message12, operandPart);
		assertNotCovered(message12, operand2Part);
		assertNotCovered(exec2, operandPart);
		assertNotCovered(exec2, operand2Part);
	}

	@Test
	public void testMoveCF() {
		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		request.setEditParts(cfPart);

		// Move to the bottom
		request.setMoveDelta(new Point(0, 180)); // Move over Exec2 and start of Message12
		editor.execute(cfPart.getCommand(request));

		assertNotCovered(exec1, operandPart);
		assertNotCovered(message10, operandPart);
		assertNotCovered(message11, operandPart);

		assertCovered(exec2, operandPart);

		assertCoverage(getSend(message12), getOperand(operandPart), true);
		assertCoverage(getReceive(message12), getOperand(operandPart), false);

		// Move again, to the right

		request.setMoveDelta(new Point(280, 0)); // Move fully over Message12
		editor.execute(cfPart.getCommand(request));

		assertNotCovered(exec1, operandPart);
		assertNotCovered(message10, operandPart);
		assertNotCovered(message11, operandPart);
		assertNotCovered(exec2, operandPart);

		assertCovered(message12, operandPart);
	}

	@Test
	public void testDeleteOperand() {
		// Create a new operand, delete the first one, and check that the new
		// one covers everything that was initially covered by the first
		IGraphicalEditPart operand2Part = createOperand(operandPart, at(200, 100, cfPart)); // Between Message10 and Message11
		editor.delete(operandPart);

		assertCovered(message10, operand2Part);
		assertCovered(message11, operand2Part);
		assertCovered(exec1, operand2Part);

		assertNotCovered(message12, operand2Part);
		assertNotCovered(exec2, operand2Part);

		// Same idea, with more operands. We'll need a bigger CF...
		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		request.setEditParts(cfPart);
		request.setResizeDirection(PositionConstants.SOUTH_EAST);
		request.setSizeDelta(new Dimension(40, 160)); // Cover Exec2, and Message12#start
		editor.execute(cfPart.getCommand(request));

		// Create some operands every 100px
		IGraphicalEditPart operand3Part = createOperand(operand2Part, at(200, 100, cfPart)); // Between Message10 and Message11
		IGraphicalEditPart operand4Part = createOperand(operand3Part, at(150, 200, cfPart)); // Between Exec1 and Exec2
		IGraphicalEditPart operand5Part = createOperand(operand4Part, at(75, 300, cfPart)); // Middle of exec 2, below Message12

		// Before deleting, make sure everything is what we expect...
		assertCovered(message10, operand2Part);
		assertCoverage(getStart(exec1), getOperand(operand2Part), true);

		assertCovered(message11, operand3Part);
		assertCoverage(getFinish(exec1), getOperand(operand3Part), true);

		assertCoverage(getStart(exec2), getOperand(operand4Part), true);
		assertCoverage(getSend(message12), getOperand(operand4Part), true);

		assertCoverage(getFinish(exec2), getOperand(operand5Part), true);

		// Now, start deleting some operands...
		editor.delete(operand2Part); // Delete the top operand. Give its fragments to Operand3

		assertCovered(message10, operand3Part);
		assertCovered(message11, operand3Part);
		assertCovered(exec1, operand3Part);

		// 4 and 5 still expect the same coverage
		assertCoverage(getStart(exec2), getOperand(operand4Part), true);
		assertCoverage(getSend(message12), getOperand(operand4Part), true);
		assertCoverage(getFinish(exec2), getOperand(operand5Part), true);

		editor.delete(operand4Part); // Delete the middle operand. Give its fragments to Operand3

		assertCovered(message10, operand3Part);
		assertCovered(message11, operand3Part);
		assertCovered(exec1, operand3Part);
		assertCoverage(getStart(exec2), getOperand(operand3Part), true);
		assertCoverage(getSend(message12), getOperand(operand3Part), true);

		// 5 still expects the same coverage
		assertCoverage(getFinish(exec2), getOperand(operand5Part), true);

		editor.delete(operand5Part); // Delete the bottom operand. Give its fragments to Operand3

		assertCovered(message10, operand3Part);
		assertCovered(message11, operand3Part);
		assertCovered(exec1, operand3Part);
		assertCoverage(getStart(exec2), getOperand(operand3Part), true);
		assertCoverage(getSend(message12), getOperand(operand3Part), true);
		assertCoverage(getFinish(exec2), getOperand(operand3Part), true);
	}

	@Test
	public void testMoveOperandSeparator() {
		// First, expand the CF...
		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		request.setEditParts(cfPart);
		request.setResizeDirection(PositionConstants.SOUTH_EAST);
		request.setSizeDelta(new Dimension(40, 160)); // Cover Exec2, and Message12#start
		editor.execute(cfPart.getCommand(request));

		// ...and create some operands...
		IGraphicalEditPart operand2Part = createOperand(operandPart, at(200, 100, cfPart)); // Between Message10 and Message11
		IGraphicalEditPart operand3Part = createOperand(operand2Part, at(150, 200, cfPart)); // Between Exec1 and Exec2
		IGraphicalEditPart operand4Part = createOperand(operand3Part, at(75, 300, cfPart)); // Middle of exec 2, below Message12

		// ...Check the initial state...
		assertCovered(message10, operandPart);
		assertCoverage(getStart(exec1), getOperand(operandPart), true);

		assertCovered(message11, operand2Part);
		assertCoverage(getFinish(exec1), getOperand(operand2Part), true);

		assertCoverage(getStart(exec2), getOperand(operand3Part), true);
		assertCoverage(getSend(message12), getOperand(operand3Part), true);

		assertCoverage(getFinish(exec2), getOperand(operand4Part), true);

		// Prepare the request to move the first separator...
		MoveSeparatorRequest resizeOperands = new MoveSeparatorRequest(0);
		resizeOperands.setLocation(at(100, 0, operandPart));
		resizeOperands.setEditParts(Collections.singletonList(cfPart));

		// Move the first separator down
		resizeOperands.setMoveDelta(new Point(0, 80)); // Below Message 11 and Exec1
		editor.execute(cfPart.getCommand(resizeOperands));

		assertCovered(message10, operandPart);
		assertCovered(message11, operandPart);
		assertCovered(exec1, operandPart);

		// Move the first separator up
		resizeOperands.setMoveDelta(new Point(0, -150)); // Above message 10 and exec1
		editor.execute(cfPart.getCommand(resizeOperands));

		assertCovered(message10, operand2Part);
		assertCovered(message11, operand2Part);
		assertCovered(exec1, operand2Part);

		// Last separator...
		resizeOperands = new MoveSeparatorRequest(2);
		resizeOperands.setLocation(at(100, 0, operand4Part));
		resizeOperands.setEditParts(Collections.singletonList(cfPart));

		// Move the last separator down
		resizeOperands.setMoveDelta(new Point(0, 45)); // Below Exec2
		editor.execute(cfPart.getCommand(resizeOperands));

		assertCovered(exec2, operand3Part);
		assertCoverage(getSend(message12), getOperand(operand3Part), true);

		// Move the last separator up
		resizeOperands.setMoveDelta(new Point(0, -100)); // Between start of Exec2 and start of message12
		editor.execute(cfPart.getCommand(resizeOperands));

		assertCoverage(getStart(exec2), getOperand(operand3Part), true);
		// --- separator is here ---
		assertCoverage(getSend(message12), getOperand(operand4Part), true);
		assertCoverage(getFinish(exec2), getOperand(operand4Part), true);
	}

	private void assertCovered(IGraphicalEditPart coveredPart, IGraphicalEditPart operandPart) {
		assertCoverage(coveredPart, operandPart, true);
	}

	private void assertNotCovered(IGraphicalEditPart coveredPart, IGraphicalEditPart operandPart) {
		assertCoverage(coveredPart, operandPart, false);
	}

	private void assertCoverage(IGraphicalEditPart coveredPart, IGraphicalEditPart operandPart, boolean expectedCoverage) {
		EObject semantic = coveredPart.getNotationView().getElement();
		InteractionOperand operand = getOperand(operandPart);

		assertCoverage(semantic, operand, expectedCoverage);
	}

	private InteractionOperand getOperand(IGraphicalEditPart operandPart) {
		return (InteractionOperand) operandPart.getNotationView().getElement();
	}

	private void assertCoverage(EObject semantic, InteractionOperand operand, boolean expectedCoverage) {
		new UMLSwitch<Void>() {
			@Override
			public Void caseMessage(Message object) {
				assertCoverage(object, operand, expectedCoverage);
				return null;
			}

			@Override
			public Void caseExecutionSpecification(ExecutionSpecification object) {
				assertCoverage(object, operand, expectedCoverage);
				return null;
			}
		}.doSwitch(semantic);
	}

	private MessageEnd getSend(IGraphicalEditPart messageEditPart) {
		return ((Message) messageEditPart.getNotationView().getElement()).getSendEvent();
	}

	private MessageEnd getReceive(IGraphicalEditPart messageEditPart) {
		return ((Message) messageEditPart.getNotationView().getElement()).getReceiveEvent();
	}

	private InteractionFragment getStart(IGraphicalEditPart execSpecEditPart) {
		return ((ExecutionSpecification) execSpecEditPart.getNotationView().getElement()).getStart();
	}

	private InteractionFragment getFinish(IGraphicalEditPart execSpecEditPart) {
		return ((ExecutionSpecification) execSpecEditPart.getNotationView().getElement()).getFinish();
	}

	private void assertCoverage(Message message, InteractionOperand operand, boolean expectedCoverage) {
		assertCoverage(message.getSendEvent(), operand, expectedCoverage);
		assertCoverage(message.getReceiveEvent(), operand, expectedCoverage);
	}

	private void assertCoverage(MessageEnd messageEnd, InteractionOperand operand, boolean expectedCoverage) {
		Assert.assertThat(messageEnd, IsInstanceOf.instanceOf(MessageOccurrenceSpecification.class));
		assertCoverage((InteractionFragment) messageEnd, operand, expectedCoverage);
	}

	private void assertCoverage(ExecutionSpecification exec, InteractionOperand operand, boolean expectedCoverage) {
		assertCoverage(exec.getStart(), operand, expectedCoverage);
		assertCoverage(exec.getFinish(), operand, expectedCoverage);
	}

	private void assertCoverage(InteractionFragment fragment, InteractionOperand operand, boolean expectedCoverage) {
		Assert.assertEquals(expectedCoverage, operand.getFragments().contains(fragment));
	}

	// Don't use editor.createShape(), because we need a special type of request to create operands.
	// The "InsertAt" behavior will only be computed if we use a CreateUnspecifiedTypeRequest (From the palette)
	// and target an Operand. The Operand will then be responsible for setting the InsertAt parameter
	// and delegate to the CombinedFragment compartment for the actual creation
	private GraphicalEditPart createOperand(IGraphicalEditPart targetVisualPart, Point location) {
		CreateUnspecifiedTypeRequest request = new CreateUnspecifiedTypeRequest(Collections.singletonList(UMLElementTypes.InteractionOperand_Shape), targetVisualPart.getDiagramPreferencesHint());

		request.setLocation(location);

		EditPart target = targetVisualPart.getTargetEditPart(request);
		assertThat("No target edit part", target, notNullValue());
		org.eclipse.gef.commands.Command command = target.getCommand(request);
		editor.execute(command);

		// Find the new edit-part
		Object result = request.getNewObject();
		Assert.assertThat(result, instanceOf(Collection.class));
		Collection<?> results = (Collection<?>) result;
		return results.stream()
				.filter(ViewDescriptor.class::isInstance).map(ViewDescriptor.class::cast)
				.map(desc -> desc.getAdapter(View.class)).map(View.class::cast)
				.filter(Objects::nonNull)
				.map(view -> DiagramEditPartsUtil.getEditPartFromView(view, targetVisualPart))
				.filter(GraphicalEditPart.class::isInstance).map(GraphicalEditPart.class::cast)
				.filter(Objects::nonNull)
				.findAny().orElseThrow(() -> new IllegalStateException("Could not find new shape edit-part"));
	}

	// Convert a point that is relative to the given part to a point relative to the current Viewport (Taking zoom & translate into account).
	// This can be used to get a "Mouse Location" to configure Requests
	private static Point at(int x, int y, IGraphicalEditPart relativeTo) {
		Point at = new Point(x, y);

		IFigure figure = relativeTo.getContentPane();
		Point layoutOrigin = figure.getClientArea().getLocation();

		at.performTranslate(layoutOrigin.x, layoutOrigin.y);
		figure.translateToParent(at);
		figure.translateToAbsolute(at);

		return at;
	}

}
