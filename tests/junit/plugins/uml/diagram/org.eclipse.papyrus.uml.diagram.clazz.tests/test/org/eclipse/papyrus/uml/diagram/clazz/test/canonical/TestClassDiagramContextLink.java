/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.clazz.test.canonical;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.CustomUMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLink;
import org.junit.Test;

public class TestClassDiagramContextLink extends TestLink {

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return CustomUMLDiagramUpdater.INSTANCE;
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Creation of the second context link from Constraint should be forbidden
	 */
	@Test
	public void testCreateSecondContextLinkFromConstraint() {
		GraphicalEditPart class1EditPart = createNodeOnDiagram(UMLElementTypes.Class_2008, new Point(100, 100), 1);
		GraphicalEditPart class2EditPart = createNodeOnDiagram(UMLElementTypes.Class_2008, new Point(100, 300), 2);
		GraphicalEditPart constraintEditPart = createNodeOnDiagram(UMLElementTypes.Constraint_2011, new Point(300, 100), 3);
		createLink(UMLElementTypes.ConstraintContext_8500, constraintEditPart, class1EditPart, true);
		createLink(UMLElementTypes.ConstraintContext_8500, constraintEditPart, class2EditPart, false);
	}

	private GraphicalEditPart createNodeOnDiagram(IElementType nodeType, Point loc, int expectedChildsCount) {
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(nodeType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(loc);
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		return (GraphicalEditPart) getDiagramEditPart().getChildren().get(expectedChildsCount - 1);
	}

	private void createLink(IElementType linkType, GraphicalEditPart source, GraphicalEditPart target, boolean canExecute) {
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == canExecute);
		if (canExecute) {
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		}
	}
}
