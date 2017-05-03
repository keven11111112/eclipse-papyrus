/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ExecutionSpecificationEndEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEndEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.TooltipUtil.TooltipFigure;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * Bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=402964
 *
 * Description:
 * http://ec2-46-137-124-143.eu-west-1.compute.amazonaws.com/confluence/display/PAPYRUS/402964+-+Display+type+name+as+tooltip+of+each+node+element
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestTooltip_402964 extends AbstractNodeTest {

	private Property representsProperty;

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void testLifelineTooltip() {
		LifelineEditPart lifeline = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		final Package model = getPackage();
		getDiagramCommandStack().execute(new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(), "", Collections.singletonList(file)) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Class libraryType = model.createOwnedClass("Library", false);
				Class bookType = model.createOwnedClass("Book", false);
				representsProperty = libraryType.createOwnedAttribute("books", bookType, 0, -1);
				return CommandResult.newOKCommandResult();
			}
		}));
		waitForComplete();
		assertNotNull(representsProperty);
		Command setRepresentCommand = createSetCommand(getEditingDomain(), lifeline.resolveSemanticElement(), UMLPackage.Literals.LIFELINE__REPRESENTS, representsProperty);
		assertNotNull(setRepresentCommand);
		assertTrue(setRepresentCommand.canExecute());
		getDiagramCommandStack().execute(setRepresentCommand);
		waitForComplete();
		IFigure figure = lifeline.getFigure();
		assertNotNull(figure);
		IFigure toolTip = figure.getToolTip();
		// The tooltip of Lifeline is changed.
		checkTooltip(toolTip, "Lifeline", "name: Lifeline\nrepresent: books\nrepresent type: Book");
	}

	@Test
	public void testActionExecutionSpecification() {
		LifelineEditPart lifeline = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		ActionExecutionSpecificationEditPart aes = (ActionExecutionSpecificationEditPart) createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline, getAbsoluteCenter(lifeline), null);
		assertNotNull(aes);
		String name = "TestActionExecutionSpecification";
		changeName(getEditingDomain(), (NamedElement) aes.resolveSemanticElement(), name);
		checkTooltip(aes.getFigure().getToolTip(), "Action Execution Specification", "name: " + name);
	}

	@Test
	public void testBehaviorExecutionSpecification() {
		LifelineEditPart lifeline = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		BehaviorExecutionSpecificationEditPart bes = (BehaviorExecutionSpecificationEditPart) createNode(UMLElementTypes.BehaviorExecutionSpecification_Shape, lifeline, getAbsoluteCenter(lifeline), null);
		assertNotNull(bes);
		String name = "TestBehaviorExecutionSpecification";
		changeName(getEditingDomain(), (NamedElement) bes.resolveSemanticElement(), name);
		checkTooltip(bes.getFigure().getToolTip(), "Behavior Execution Specification", "name: " + name);
	}

	@Test
	public void testCombinedFragment() {
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart) createNode(UMLElementTypes.CombinedFragment_Shape, getRootEditPart(), new Point(100, 100), new Dimension(200, 100));
		assertNotNull(cf);
		String name = "Test Combined Fragment";
		CombinedFragment elt = (CombinedFragment) cf.resolveSemanticElement();
		changeName(getEditingDomain(), elt, name);
		checkTooltip(cf.getFigure().getToolTip(), "Combined Fragment", "name: " + name + "\noperator: " + elt.getInteractionOperator().getName());
	}

	@Test
	public void testInteractionOperand() {
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart) createNode(UMLElementTypes.CombinedFragment_Shape, getRootEditPart(), new Point(100, 100), new Dimension(200, 100));
		assertNotNull(cf);
		String cfName = "Test Combined Fragment";
		CombinedFragment elt = (CombinedFragment) cf.resolveSemanticElement();
		changeName(getEditingDomain(), elt, cfName);
		CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart) cf.getChildBySemanticHint("" + CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID);
		assertNotNull(compartment);
		InteractionOperandEditPart operand = (InteractionOperandEditPart) createNode(UMLElementTypes.InteractionOperand_Shape, compartment, getAbsoluteCenter(compartment), null);
		assertNotNull(operand);
		String name = "Test Interaction Operand";
		changeName(getEditingDomain(), (NamedElement) operand.resolveSemanticElement(), name);
		checkTooltip(operand.getFigure().getToolTip(), "Interaction Operand", "name: " + name + "\nparent:name: " + cfName + "\nparent:operator: " + elt.getInteractionOperator().getName());
	}

	@Test
	public void testSynchronousMessage() {
		LifelineEditPart lifeline1 = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline1);
		ActionExecutionSpecificationEditPart source = (ActionExecutionSpecificationEditPart) createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline1, getAbsoluteBounds(lifeline1).getTop().translate(0, 50), null);
		assertNotNull(source);
		LifelineEditPart lifeline2 = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(lifeline2);
		ActionExecutionSpecificationEditPart target = (ActionExecutionSpecificationEditPart) createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline2, getAbsoluteBounds(lifeline2).getTop().translate(0, 50), null);
		assertNotNull(target);
		MessageSyncEditPart message = (MessageSyncEditPart) createLink(UMLElementTypes.Message_SynchEdge, lifeline1.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		String name = "Test Synchronous Message";
		changeName(getEditingDomain(), (NamedElement) message.resolveSemanticElement(), name);
		checkTooltip(message.getFigure().getToolTip(), "Synchronous Message", "name: " + name);
	}

	@Test
	public void testAsynchronousMessage() {
		LifelineEditPart source = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		MessageAsyncEditPart message = (MessageAsyncEditPart) createLink(UMLElementTypes.Message_AsynchEdge, source.getViewer(), getAbsoluteBounds(source).getTop().translate(0, 50), getAbsoluteBounds(target).getTop().translate(0, 50));
		assertNotNull(message);
		String name = "Test Asynchronous Message";
		changeName(getEditingDomain(), (NamedElement) message.resolveSemanticElement(), name);
		checkTooltip(message.getFigure().getToolTip(), "Asynchronous Message", "name: " + name);
	}

	@Test
	public void testCreateMessage() {
		LifelineEditPart source = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		MessageCreateEditPart message = (MessageCreateEditPart) createLink(UMLElementTypes.Message_CreateEdge, source.getViewer(), getAbsoluteBounds(source).getTop().translate(0, 50), getAbsoluteBounds(target).getTop().translate(0, 50));
		assertNotNull(message);
		String name = "Test Create Message";
		changeName(getEditingDomain(), (NamedElement) message.resolveSemanticElement(), name);
		checkTooltip(message.getFigure().getToolTip(), "Create Message", "name: " + name);
	}

	@Test
	public void testReplyMessage() {
		LifelineEditPart lifeline1 = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(lifeline1);
		ActionExecutionSpecificationEditPart source = (ActionExecutionSpecificationEditPart) createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline1, getAbsoluteBounds(lifeline1).getTop().translate(0, 50), null);
		assertNotNull(source);
		LifelineEditPart lifeline2 = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline2);
		ActionExecutionSpecificationEditPart target = (ActionExecutionSpecificationEditPart) createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline2, getAbsoluteBounds(lifeline2).getTop().translate(0, 150), null);
		assertNotNull(target);
		MessageReplyEditPart message = (MessageReplyEditPart) createLink(UMLElementTypes.Message_ReplyEdge, source.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		String name = "Test Reply Message";
		changeName(getEditingDomain(), (NamedElement) message.resolveSemanticElement(), name);
		checkTooltip(message.getFigure().getToolTip(), "Reply Message", "name: " + name);
	}

	@Test
	public void testFoundMessage() {
		LifelineEditPart target = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Point targetLocation = getAbsoluteBounds(target).getTop().translate(0, 50);
		Point sourceLocation = targetLocation.getTranslated(-100, 0);
		MessageFoundEditPart message = (MessageFoundEditPart) createLink(UMLElementTypes.Message_FoundEdge, target.getViewer(), sourceLocation, targetLocation);
		assertNotNull(message);
		String name = "Test Found Message";
		changeName(getEditingDomain(), (NamedElement) message.resolveSemanticElement(), name);
		checkTooltip(message.getFigure().getToolTip(), "Found Message", "name: " + name);
	}

	@Test
	public void testLostMessage() {
		LifelineEditPart source = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(source);
		Point sourceLocation = getAbsoluteBounds(source).getTop().translate(0, 50);
		Point targetLocation = sourceLocation.getTranslated(100, 0);
		MessageLostEditPart message = (MessageLostEditPart) createLink(UMLElementTypes.Message_LostEdge, source.getViewer(), sourceLocation, targetLocation);
		assertNotNull(message);
		String name = "Test Lost Message";
		changeName(getEditingDomain(), (NamedElement) message.resolveSemanticElement(), name);
		checkTooltip(message.getFigure().getToolTip(), "Lost Message", "name: " + name);
	}

	@Test
	public void testDeleteMessage() {
		LifelineEditPart source = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		MessageDeleteEditPart message = (MessageDeleteEditPart) createLink(UMLElementTypes.Message_DeleteEdge, source.getViewer(), getAbsoluteBounds(source).getTop().translate(0, 50), getAbsoluteBounds(target).getTop().translate(0, 50));
		assertNotNull(message);
		String name = "Test Delete Message";
		changeName(getEditingDomain(), (NamedElement) message.resolveSemanticElement(), name);
		checkTooltip(message.getFigure().getToolTip(), "Delete Message", "name: " + name);
	}

	@Test
	public void testMessageOccurrenceSpecification() {
		LifelineEditPart source = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		MessageAsyncEditPart message = (MessageAsyncEditPart) createLink(UMLElementTypes.Message_AsynchEdge, source.getViewer(), getAbsoluteBounds(source).getTop().translate(0, 50), getAbsoluteBounds(target).getTop().translate(0, 50));
		assertNotNull(message);
		MessageEndEditPart messageEnd = (MessageEndEditPart) message.getChildBySemanticHint(MessageEndEditPart.VISUAL_ID);
		assertNotNull(messageEnd);
		String name = "Test Message Occurrence Specification";
		changeName(getEditingDomain(), (NamedElement) messageEnd.resolveSemanticElement(), name);
		checkTooltip(messageEnd.getFigure().getToolTip(), "Message Occurrence Specification", "name: " + name);
	}

	@Test
	public void testExecutionOccurrenceSpecification() {
		LifelineEditPart lifeline = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		ActionExecutionSpecificationEditPart es = (ActionExecutionSpecificationEditPart) createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline, getAbsoluteCenter(lifeline), null);
		assertNotNull(es);
		ExecutionSpecificationEndEditPart esEnd = (ExecutionSpecificationEndEditPart) es.getChildren().get(0);
		assertNotNull(esEnd);
		String name = "Test Execution Occurrence Specification";
		changeName(getEditingDomain(), (NamedElement) esEnd.resolveSemanticElement(), name);
		checkTooltip(esEnd.getFigure().getToolTip(), "Execution Occurrence Specification", "name: " + name);
	}

	@Test
	public void testInteractionUse() {
		InteractionUseEditPart interactionUse = (InteractionUseEditPart) createNode(UMLElementTypes.InteractionUse_Shape, getRootEditPart(), new Point(300, 200), new Dimension(200, 100));
		assertNotNull(interactionUse);
		String name = "Test Interaction Use";
		NamedElement element = (NamedElement) interactionUse.resolveSemanticElement();
		changeName(getEditingDomain(), element, name);
		checkTooltip(interactionUse.getFigure().getToolTip(), "Interaction Use", "name: " + name);
		// add Refer
		final String referInteractionName = "Refered Interaction";
		final List<Interaction> refers = new ArrayList<Interaction>();
		final Model model = (Model) getPackage();
		getDiagramCommandStack().execute(new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(), "", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Interaction interaction = (Interaction) model.createPackagedElement(referInteractionName, UMLPackage.Literals.INTERACTION);
				refers.add(interaction);
				return CommandResult.newOKCommandResult();
			}
		}));
		waitForComplete();
		assertEquals(refers.size(), 1);
		Command command = createSetCommand(getEditingDomain(), element, UMLPackage.Literals.INTERACTION_USE__REFERS_TO, refers.get(0));
		assertNotNull(command);
		assertEquals(true, command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
		checkTooltip(interactionUse.getFigure().getToolTip(), "Interaction Use", "name: " + name + "\nref: " + referInteractionName);
	}

	@Test
	public void testStateInvariant() {
		LifelineEditPart lifeline = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		Rectangle r = getAbsoluteBounds(lifeline);
		StateInvariantEditPart stateInvariant = (StateInvariantEditPart) createNode(UMLElementTypes.StateInvariant_Shape, lifeline, r.getCenter(), null);
		assertNotNull(stateInvariant);
		String name = "Test State Invariant";
		changeName(getEditingDomain(), (NamedElement) stateInvariant.resolveSemanticElement(), name);
		checkTooltip(stateInvariant.getFigure().getToolTip(), "State Invariant", "");
	}

	@Test
	public void testDestructionEvent() {
		LifelineEditPart lifeline = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		DestructionOccurrenceSpecificationEditPart destructionEvent = (DestructionOccurrenceSpecificationEditPart) createNode(UMLElementTypes.DestructionOccurrenceSpecification_Shape, lifeline, getAbsoluteCenter(lifeline), null);
		assertNotNull(destructionEvent);
		checkTooltip(destructionEvent.getFigure().getToolTip(), "Destruction Event", "");
	}

	@Test
	public void testGeneralOrdering() {
		LifelineEditPart source = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart) createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Point sourcePoint = getAbsoluteBounds(source).getTop().translate(0, 50);
		Point targetPoint = getAbsoluteBounds(target).getTop().translate(0, 50);
		MessageAsyncEditPart message1 = (MessageAsyncEditPart) createLink(UMLElementTypes.Message_AsynchEdge, source.getViewer(), sourcePoint, targetPoint);
		assertNotNull(message1);
		MessageAsyncEditPart message2 = (MessageAsyncEditPart) createLink(UMLElementTypes.Message_AsynchEdge, source.getViewer(), sourcePoint.getTranslated(0, 50), targetPoint.getTranslated(0, 50));
		assertNotNull(message2);
		sourcePoint = SequenceUtil.getAbsoluteEdgeExtremity(message1, true);
		targetPoint = SequenceUtil.getAbsoluteEdgeExtremity(message2, false);
		GeneralOrderingEditPart generalOrdering = (GeneralOrderingEditPart) createLink(UMLElementTypes.GeneralOrdering_Edge, source.getViewer(), sourcePoint, targetPoint);
		assertNotNull(generalOrdering);
		checkTooltip(generalOrdering.getFigure().getToolTip(), "General Ordering", "");
	}

	// @Test
	// public void testCoRegion() {
	// LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
	// assertNotNull(lifeline);
	// Rectangle r = getAbsoluteBounds(lifeline);
	// CombinedFragment2EditPart coRegion = (CombinedFragment2EditPart)createNode(UMLElementTypes.CombinedFragment_CoRegionShape, lifeline, r.getCenter(), null);
	// assertNotNull(coRegion);
	// String name = "Test CoRegion";
	// changeName(getEditingDomain(), (NamedElement)coRegion.resolveSemanticElement(), name);
	// checkTooltip(coRegion.getFigure().getToolTip(), "Co Region", "name: " + name);
	// }

	private void checkTooltip(IFigure figure, String name, String description) {
		assertNotNull(figure);
		assertTrue(figure instanceof TooltipFigure);
		TooltipFigure tipFig = (TooltipFigure) figure;
		tipFig.update();
		assertEquals("Tooltip Name: ", trim(name), trim(tipFig.getName()));
		assertEquals("Tooltip Description: ", trim(description), trim(tipFig.getDescription()));
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
