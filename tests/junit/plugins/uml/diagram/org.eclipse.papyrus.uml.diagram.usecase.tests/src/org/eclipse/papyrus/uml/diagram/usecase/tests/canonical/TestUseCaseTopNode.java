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
package org.eclipse.papyrus.uml.diagram.usecase.tests.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.usecase.CreateUseCaseDiagramCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.usecase.tests.IUseCaseDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestUseCaseTopNode.
 */
public class TestUseCaseTopNode extends TestSpecificTopNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateUseCaseDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IUseCaseDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IUseCaseDiagramTestsConstants.FILE_NAME;
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

	/**
	 * Test to manage subjects.
	 */
	@Test
	public void testToManageSubjectActivity() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getActivity());
	}


	@Test
	public void testToManageSubjectActor() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getActor());
	}


	@Test
	public void testToManageSubjectArtifact() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getArtifact());
	}


	// @Test
	// public void testToManageSubjectAssociation() {
	// testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getAssociation());
	// }


	// @Test
	// public void testToManageSubjectAssociationClass() {
	// testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getAssociationClass());
	// }


	@Test
	public void testToManageSubjectClass() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getClass_());
	}


	@Test
	public void testToManageSubjectCollaboration() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getCollaboration());
	}


	// @Test
	// public void testToManageSubjectCommunicationPath() {
	// testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getCommunicationPath());
	// }

	@Test
	public void testToManageSubjectComponent() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getComponent());
	}

	@Test
	public void testToManageSubjectDatatype() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getDataType());
	}


	@Test
	public void testToManageSubjectDeployementSpecification() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getDeploymentSpecification());
	}

	@Test
	public void testToManageSubjectDevice() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getDevice());
	}

	@Test
	public void testToManageSubjectEnumeration() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getEnumeration());
	}

	@Test
	public void testToManageSubjectExecutionEnvironment() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getExecutionEnvironment());
	}

	// @Test
	// public void testToManageSubjectExtension() {
	// testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getExtension());
	// }

	@Test
	public void testToManageSubjectFunctionBehavior() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getFunctionBehavior());
	}

	@Test
	public void testToManageSubjectInformationItem() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getInformationItem());
	}

	@Test
	public void testToManageSubjectInteraction() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getInteraction());
	}

	@Test
	public void testToManageSubjectInterface() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getInterface());
	}

	@Test
	public void testToManageSubjectNode() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getNode());
	}

	@Test
	public void testToManageSubjectOpaqueBehavior() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getOpaqueBehavior());
	}

	@Test
	public void testToManageSubjectPrimitiveType() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getPrimitiveType());
	}

	@Test
	public void testToManageSubjectProtocolStateMachine() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getProtocolStateMachine());
	}

	@Test
	public void testToManageSubjectSignal() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getSignal());
	}

	@Test
	public void testToManageSubjectStateMachine() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getStateMachine());
	}

	@Test
	public void testToManageSubjectStereotype() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getStereotype());
	}

	@Test
	public void testToManageSubjectUsecase() {
		testToManageSpecificTopNode(UMLElementTypes.Classifier_2015, UMLElementTypes.Package_2016, UMLPackage.eINSTANCE.getUseCase());
	}
}
