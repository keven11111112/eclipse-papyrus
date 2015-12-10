/*****************************************************************************
 * Copyright (c) 2009, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 476436
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.test.canonical;

import static org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.DEFAULT_DIRECT_EDITOR;
import static org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.EXTENDED_DIRECT_EDITOR;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.edition.AbstractEditableNodeTest;
import org.eclipse.papyrus.uml.diagram.tests.edition.ExpectedDirectEditor;
import org.junit.Test;

/**
 * The Class TestClassDiagramTopNode.
 */
public class TestEditableClassDiagramTopNode extends AbstractEditableNodeTest {

	@Override
	public GraphicalEditPart getContainerEditPart() {
		return getDiagramEditPart();
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
	 * Test to manage component.
	 */
	@Test
	public void testToManageComponent() {
		testEdition(UMLElementTypes.Component_Shape);
	}

	/**
	 * Test to manage instance specification.
	 */
	@Test
	public void testToManageInstanceSpecification() {
		testEdition(UMLElementTypes.InstanceSpecification_Shape);
	}

	/**
	 * Test to manage signal.
	 */
	@Test
	public void testToManageSignal() {
		testEdition(UMLElementTypes.Signal_Shape);
	}

	/**
	 * Test to manage model.
	 */
	@Test
	public void testToManageModel() {
		testEdition(UMLElementTypes.Model_Shape);
	}

	/**
	 * Test to manage enumeration.
	 */
	@Test
	public void testToManageEnumeration() {
		testEdition(UMLElementTypes.Enumeration_Shape);
	}

	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testEdition(UMLElementTypes.Package_Shape);
	}

	/**
	 * Test to manage class.
	 */
	@Test
	public void testToManageClass() {
		testEdition(UMLElementTypes.Class_Shape);
	}

	/**
	 * Test to manage primitive type.
	 */
	@Test
	public void testToManagePrimitiveType() {
		testEdition(UMLElementTypes.PrimitiveType_Shape);
	}

	/**
	 * Test to manage data type.
	 */
	@Test
	public void testToManageDataType() {
		testEdition(UMLElementTypes.DataType_Shape);
	}

	/**
	 * Test to manage constraint.
	 */
	@Test
	@ExpectedDirectEditor(DEFAULT_DIRECT_EDITOR | EXTENDED_DIRECT_EDITOR)
	public void testToManageConstraint() {
		testEdition(UMLElementTypes.Constraint_PackagedElementShape);
	}

	/**
	 * Test to manage comment.
	 */
	@Test
	public void testToManageComment() {
		testEdition(UMLElementTypes.Comment_Shape);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageInformationItem() {
		testEdition(UMLElementTypes.InformationItem_Shape);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageInterface() {
		testEdition(UMLElementTypes.Interface_Shape);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageTimeObservation() {
		testEdition(UMLElementTypes.TimeObservation_Shape);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageDurationObservation() {
		testEdition(UMLElementTypes.DurationObservation_Shape);
	}


}
