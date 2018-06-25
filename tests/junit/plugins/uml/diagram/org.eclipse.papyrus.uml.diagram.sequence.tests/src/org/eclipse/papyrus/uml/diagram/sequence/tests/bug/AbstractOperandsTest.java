/*****************************************************************************
 * Copyright (c) 2018 EclipseSource, CEA LIST and others.
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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Rule;

public abstract class AbstractOperandsTest extends AbstractPapyrusTest {

	@Rule
	public final PapyrusEditorFixture editor = new PapyrusEditorFixture();

	protected void assertCovered(IGraphicalEditPart coveredPart, IGraphicalEditPart operandPart) {
		assertCoverage(coveredPart, operandPart, true);
	}

	protected void assertNotCovered(IGraphicalEditPart coveredPart, IGraphicalEditPart operandPart) {
		assertCoverage(coveredPart, operandPart, false);
	}

	protected void assertCoverage(IGraphicalEditPart coveredPart, IGraphicalEditPart operandPart, boolean expectedCoverage) {
		EObject semantic = coveredPart.getNotationView().getElement();
		InteractionOperand operand = getOperand(operandPart);

		assertCoverage(semantic, operand, expectedCoverage);
	}

	protected InteractionOperand getOperand(IGraphicalEditPart operandPart) {
		return (InteractionOperand) operandPart.getNotationView().getElement();
	}

	protected void assertCoverage(EObject semantic, InteractionOperand operand, boolean expectedCoverage) {
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

	protected MessageEnd getSend(IGraphicalEditPart messageEditPart) {
		return ((Message) messageEditPart.getNotationView().getElement()).getSendEvent();
	}

	protected MessageEnd getReceive(IGraphicalEditPart messageEditPart) {
		return ((Message) messageEditPart.getNotationView().getElement()).getReceiveEvent();
	}

	protected InteractionFragment getStart(IGraphicalEditPart execSpecEditPart) {
		return ((ExecutionSpecification) execSpecEditPart.getNotationView().getElement()).getStart();
	}

	protected InteractionFragment getFinish(IGraphicalEditPart execSpecEditPart) {
		return ((ExecutionSpecification) execSpecEditPart.getNotationView().getElement()).getFinish();
	}

	protected void assertCoverage(Message message, InteractionOperand operand, boolean expectedCoverage) {
		assertCoverage(message.getSendEvent(), operand, expectedCoverage);
		assertCoverage(message.getReceiveEvent(), operand, expectedCoverage);
	}

	protected void assertCoverage(MessageEnd messageEnd, InteractionOperand operand, boolean expectedCoverage) {
		Assert.assertThat(messageEnd, IsInstanceOf.instanceOf(MessageOccurrenceSpecification.class));
		assertCoverage((InteractionFragment) messageEnd, operand, expectedCoverage);
	}

	protected void assertCoverage(ExecutionSpecification exec, InteractionOperand operand, boolean expectedCoverage) {
		assertCoverage(exec.getStart(), operand, expectedCoverage);
		assertCoverage(exec.getFinish(), operand, expectedCoverage);
	}

	protected void assertCoverage(InteractionFragment fragment, InteractionOperand operand, boolean expectedCoverage) {
		Assert.assertEquals(expectedCoverage, operand.getFragments().contains(fragment));
	}

	// Don't use editor.createShape(), because we need a special type of request to create operands.
	// The "InsertAt" behavior will only be computed if we use a CreateUnspecifiedTypeRequest (From the palette)
	// and target an Operand. The Operand will then be responsible for setting the InsertAt parameter
	// and delegate to the CombinedFragment compartment for the actual creation
	protected GraphicalEditPart createOperand(IGraphicalEditPart targetVisualPart, Point location) {
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
	protected static Point at(int x, int y, IGraphicalEditPart relativeTo) {
		Point at = new Point(x, y);

		IFigure figure = relativeTo.getContentPane();
		Point layoutOrigin = figure.getClientArea().getLocation();

		at.performTranslate(layoutOrigin.x, layoutOrigin.y);
		figure.translateToParent(at);
		figure.translateToAbsolute(at);

		return at;
	}
}
