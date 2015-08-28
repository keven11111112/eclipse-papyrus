/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.test.canonical;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.CreateComponentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.component.test.IComponentDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLink;
import org.eclipse.uml2.uml.Element;
import org.junit.Assert;
import org.junit.Test;

/**
 * The Class TestComponentDiagramLink.
 */
public class TestComponentDiagramLink extends TestLink {

	protected int diagramUpdaterContainedLinksSize = 1;

	protected int diagramUpdaterSourceOutgoingLinksSize = 1;

	protected int diagramChildrenSizeBeforeDrop = 4;

	protected int diagramChildrenSizeAfterDrop = 4;

	protected int dropDiagramEdgesCount = 1;

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return UMLDiagramUpdater.INSTANCE;
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateComponentDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IComponentDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IComponentDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to manage Abstraction
	 */
	@Test
	@FailingTest
	public void testToManageAbstraction() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Abstraction_4013, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Dependency
	 */
	@Test
	@FailingTest
	public void testToManageDependency() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Dependency_4010, UMLElementTypes.Package_3200, true);

	}

	/**
	 * Test to manage Manifestation
	 */
	@Test
	@FailingTest
	public void testToManageManifestation() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Manifestation_4014, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Usage
	 */
	@Test
	@FailingTest
	public void testToManageUsage() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Interface_3205, UMLElementTypes.Usage_4001, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Interface Realization
	 */
	@Test
	@FailingTest
	public void testToManageInterfaceRealization() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Interface_3205, UMLElementTypes.InterfaceRealization_4006, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Component Realization
	 */
	@Test
	@FailingTest
	public void testToManageComponentRealization() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.ComponentRealization_4007, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Abstraction without multi
	 */
	@Test
	public void testToManageAbstractionWithoutMulti() {
		testToManageLinkWithoutMulti(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Abstraction_4013, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Dependency without multi
	 */
	@Test
	public void testToManageDependencyWithoutMulti() {
		testToManageLinkWithoutMulti(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Dependency_4010, UMLElementTypes.Package_3200, true);

	}

	/**
	 * Test to manage Manifestation
	 */
	@Test
	public void testToManageManifestationWithoutMulti() {
		testToManageLinkWithoutMulti(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Manifestation_4014, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Usage without multi
	 */
	@Test
	public void testToManageUsageWithoutMulti() {
		testToManageLinkWithoutMulti(UMLElementTypes.Component_2002, UMLElementTypes.Interface_3205, UMLElementTypes.Usage_4001, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Interface Realization without multi
	 */
	@Test
	public void testToManageInterfaceRealizationWithoutMulti() {
		testToManageLinkWithoutMulti(UMLElementTypes.Component_2002, UMLElementTypes.Interface_3205, UMLElementTypes.InterfaceRealization_4006, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Component Realization without multi
	 */
	@Test
	public void testToManageComponentRealizationWithoutMulti() {
		testToManageLinkWithoutMulti(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.ComponentRealization_4007, UMLElementTypes.Package_3200, true);
	}

	@Override
	public void installEnvironment(IElementType sourceType, IElementType targetType) {
		super.installEnvironment(sourceType, targetType);
		rootSemanticOwnedElements = 4;
		diagramUpdaterContainedLinksSize = 0;
		diagramUpdaterSourceOutgoingLinksSize = 0;
		diagramChildrenSizeAfterDrop = 5;
		dropDiagramEdgesCount = 0;
		createdEdgesCount = 0;
		initialEnvironmentChildsCount = 5;
	}

	/**
	 * Test drop.
	 *
	 * @param type
	 *            the type
	 */
	@Override
	public void testDrop(IElementType type) {
		// DROP
		assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == diagramChildrenSizeBeforeDrop);
		assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == rootSemanticOwnedElements);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram) getRootView()).getEdges().size() == 0);
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		list.add(getRootSemanticModel().getOwnedElements().get(rootSemanticOwnedElements - 1));
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20, 20));
		Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DROP + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == diagramChildrenSizeAfterDrop);
		assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == rootSemanticOwnedElements);
		assertTrue(DROP + TEST_THE_EXECUTION, ((Diagram) getRootView()).getEdges().size() == dropDiagramEdgesCount);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(DROP + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == diagramChildrenSizeBeforeDrop);
		assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == rootSemanticOwnedElements);
		assertTrue(DROP + TEST_THE_UNDO, ((Diagram) getRootView()).getEdges().size() == 0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(DROP + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == diagramChildrenSizeAfterDrop);
		assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == rootSemanticOwnedElements);
		assertTrue(DROP + TEST_THE_REDO, ((Diagram) getRootView()).getEdges().size() == dropDiagramEdgesCount);
	}

	public void testToCreateALink(IElementType linkType, String initialName) {
		testCreateLink(linkType, initialName);

		Assert.assertEquals("Diagram updater must detect that node children has been created", 4, getDiagramUpdater().getSemanticChildren(getRootView()).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no link has been created", diagramUpdaterContainedLinksSize, getDiagramUpdater().getContainedLinks(getRootView()).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no link are incoming", 0, getDiagramUpdater().getIncomingLinks((View) ((Diagram) getRootView()).getEdges().get(0)).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no link are outgoing", 0, getDiagramUpdater().getOutgoingLinks((View) ((Diagram) getRootView()).getEdges().get(0)).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no children has ben created in the new element", 0, getDiagramUpdater().getSemanticChildren(((View) ((Diagram) getRootView()).getEdges().get(0))).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no link has been created in the new element", 0, getDiagramUpdater().getContainedLinks(((View) ((Diagram) getRootView()).getEdges().get(0))).size()); //$NON-NLS-1$

		Assert.assertEquals("Diagram updater must detect that no link are incoming", 1, getDiagramUpdater().getIncomingLinks(target.getNotationView()).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no link are OutgoingLinks", 0, getDiagramUpdater().getOutgoingLinks(target.getNotationView()).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no link are IncomingLinks", 0, getDiagramUpdater().getIncomingLinks(source.getNotationView()).size()); //$NON-NLS-1$
		Assert.assertEquals("Diagram updater must detect that no link are OutgoingLinks", diagramUpdaterSourceOutgoingLinksSize, getDiagramUpdater().getOutgoingLinks(source.getNotationView()).size()); //$NON-NLS-1$
	}

	/**
	 * Test to manage top node.
	 *
	 * @param type
	 *            the type
	 * @param containerType
	 *            the container type
	 */
	public void testToManageLinkWithoutMulti(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType containerType, boolean allowedOntheSame) {
		installEnvironment(sourceType, targetType);
		testToCreateALink(linkType, null);
		testDestroy(linkType);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		testViewDeletion(linkType);
		testDrop(linkType);
	}

	/**
	 * htis method is used to test the created link editpart
	 *
	 * @param linkEditPart
	 */
	@Override
	protected void testLinkEditPart(ConnectionEditPart linkEditPart, String initialName) {
		super.testLinkEditPart(linkEditPart, initialName);
		EditPolicy policy = linkEditPart.getEditPolicy(AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY);
		Assert.assertNotNull("the link must have an stereotype edipolicy.", policy); //$NON-NLS-1$
		Assert.assertTrue("the policy of the link must be an instance of AppliedStereotypeLinkLabelDisplayEditPolicy", policy instanceof AppliedStereotypeLinkLabelDisplayEditPolicy); //$NON-NLS-1$
		Assert.assertTrue("Expected link childs count is 2.", linkEditPart.getChildren().size() == 2);
	}
}
