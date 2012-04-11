/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.tests.canonical;

import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.usecase.CreateUseCaseDiagramCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestUseCaseTopNode.
 */
public class TestUseCaseTopNode extends TestTopNode {
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateUseCaseDiagramCommand();
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManagePackage() {
		testToManageTopNode(UMLElementTypes.Package_2016, UMLElementTypes.Package_2016);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageActor() {
		testToManageTopNode(UMLElementTypes.Actor_2011, UMLElementTypes.Package_2016);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageComment() {
		testToManageTopNode(UMLElementTypes.Comment_2018, UMLElementTypes.Package_2016);
	}
	
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageTopNode(UMLElementTypes.Constraint_2017, UMLElementTypes.Package_2016);
	}
	@Test
	public void testToManageSubjectComponent() {
		testToManageTopNode(UMLElementTypes.Component_2015, UMLElementTypes.Package_2016);
	}
	
	@Test
	public void testToManageSubjectClass() {
		testToManageTopNode(UMLElementTypes.Class_2020, UMLElementTypes.Package_2016);
	}
	@Test
	public void testToManageSubjectInterface() {
		testToManageTopNode(UMLElementTypes.Interface_2021, UMLElementTypes.Package_2016);
	}
	@Test
	public void testToManageUseCase() {
		testToManageTopNode(UMLElementTypes.UseCase_2013, UMLElementTypes.Package_2016);
	}
}
