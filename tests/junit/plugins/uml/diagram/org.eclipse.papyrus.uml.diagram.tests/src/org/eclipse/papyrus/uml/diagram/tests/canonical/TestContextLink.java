package org.eclipse.papyrus.uml.diagram.tests.canonical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;

public abstract class TestContextLink extends TestLink {

	protected void manageContextLink(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType containerType) {
		testToManageLink(sourceType, targetType, linkType, containerType, false, null);
		checkUnexecutableCreateLinkCommand(linkType, source, target);
		checkUnexecutableCreateLinkCommand(linkType, source, targetPlayer);
	}

	@Override
	public void testToCreateALink(IElementType linkType, String initialName) {
		testCreateLink(linkType, initialName);
	}

	@Override
	public void testToManageLink(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType containerType, boolean allowedOntheSame, String initialName) {
		installEnvironment(sourceType, targetType);
		testToCreateALink(linkType, initialName);
		testToManageDropConstraint();
	}

	private void testToManageDropConstraint() {
		testConstraintViewDeletion();
		testDropConstraint();
	}

	private void testConstraintViewDeletion() {
		assertEquals(VIEW_DELETION + INITIALIZATION_TEST, 4, ((Diagram) getRootView()).getChildren().size());
		assertEquals(VIEW_DELETION + INITIALIZATION_TEST, 1, ((Diagram) getRootView()).getEdges().size());
		assertEquals(VIEW_DELETION + INITIALIZATION_TEST, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = source.getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertEquals(VIEW_DELETION + TEST_THE_EXECUTION, 3, ((Diagram) getRootView()).getChildren().size());
		assertEquals(VIEW_DELETION + TEST_THE_EXECUTION, 0, ((Diagram) getRootView()).getEdges().size());
		assertEquals(VIEW_DELETION + TEST_THE_EXECUTION, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertEquals(VIEW_DELETION + TEST_THE_UNDO, 4, ((Diagram) getRootView()).getChildren().size());
		assertEquals(VIEW_DELETION + TEST_THE_UNDO, 1, ((Diagram) getRootView()).getEdges().size());
		assertEquals(VIEW_DELETION + TEST_THE_UNDO, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertEquals(VIEW_DELETION + TEST_THE_REDO, 3, ((Diagram) getRootView()).getChildren().size());
		assertEquals(VIEW_DELETION + TEST_THE_REDO, 0, ((Diagram) getRootView()).getEdges().size());
		assertEquals(VIEW_DELETION + TEST_THE_REDO, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
	}

	private void testDropConstraint() {
		assertEquals(DROP + INITIALIZATION_TEST, 3, getDiagramEditPart().getChildren().size());
		assertEquals(DROP + INITIALIZATION_TEST, 3, ((Diagram) getRootView()).getChildren().size());
		assertEquals(DROP + INITIALIZATION_TEST, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
		assertEquals(CREATION + INITIALIZATION_TEST, 0, ((Diagram) getRootView()).getEdges().size());
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		list.add(((Element) target.resolveSemanticElement()).getOwnedElements().get(0));
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20, 20));
		Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertEquals(DROP + TEST_THE_EXECUTION, 4, getDiagramEditPart().getChildren().size());
		assertEquals(DROP + TEST_THE_EXECUTION, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
		assertEquals(DROP + TEST_THE_EXECUTION, 4, ((Diagram) getRootView()).getChildren().size());
		assertEquals(DROP + TEST_THE_EXECUTION, 1, ((Diagram) getRootView()).getEdges().size());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertEquals(DROP + TEST_THE_UNDO, 3, getDiagramEditPart().getChildren().size());
		assertEquals(DROP + TEST_THE_UNDO, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
		assertEquals(DROP + TEST_THE_UNDO, 3, ((Diagram) getRootView()).getChildren().size());
		assertEquals(DROP + TEST_THE_UNDO, 0, ((Diagram) getRootView()).getEdges().size());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertEquals(DROP + TEST_THE_REDO, 4, getDiagramEditPart().getChildren().size());
		assertEquals(DROP + TEST_THE_REDO, rootSemanticOwnedElements, getRootSemanticModel().getOwnedElements().size());
		assertEquals(DROP + TEST_THE_REDO, 4, ((Diagram) getRootView()).getChildren().size());
		assertEquals(DROP + TEST_THE_REDO, 1, ((Diagram) getRootView()).getEdges().size());
	}

	@Override
	public void installEnvironment(IElementType sourceType, IElementType targetType) {
		rootSemanticOwnedElements = 3;
		super.installEnvironment(sourceType, targetType);
		assertTrue(CREATION + INITIALIZATION_TEST, source.resolveSemanticElement() instanceof Constraint);
	}

	private void checkUnexecutableCreateLinkCommand(IElementType linkType, GraphicalEditPart source, GraphicalEditPart target) {
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertNull("Creation of the second context link from the constraint should be forbidden.", command);
	}
}