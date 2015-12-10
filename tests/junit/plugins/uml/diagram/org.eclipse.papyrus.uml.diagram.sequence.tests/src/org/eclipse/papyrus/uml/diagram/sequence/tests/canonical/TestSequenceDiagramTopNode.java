/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
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
package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.uml2.uml.Element;
import org.junit.Test;


public class TestSequenceDiagramTopNode extends TestTopNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	@Test
	public void testToManageLifeline() {
		testToManageTopNode(UMLElementTypes.Lifeline_Shape, provider);
	}

	/**
	 * Test to manage constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageTopNode(UMLElementTypes.Constraint_Shape, provider);
	}

	/**
	 * Test to manage comment.
	 */
	@Test
	public void testToManageComment() {
		testToManageTopNode(UMLElementTypes.Comment_Shape, provider);
	}

	@Test
	public void testToManageInteractionUse() {
		testToManageTopNode(UMLElementTypes.InteractionUse_Shape, provider);
	}

	//	@Test
	//	public void testToManageConsiderIgnoreFragment() { // popup menu when delete
	//		PopupUtil.addMenuListener(0);
	//		testToManageTopNode(UMLElementTypes.ConsiderIgnoreFragment_Shape, provider);
	//
	//		waitForComplete();
	//		PopupUtil.removeMenuListener();
	//	}
	//
	//	@Test
	//	public void testToManageCombinedFragment() { // popup menu when delete
	//		PopupUtil.addMenuListener(0);
	//		testToManageTopNode(UMLElementTypes.CombinedFragment_Shape, provider);
	//
	//		waitForComplete();
	//		PopupUtil.removeMenuListener();
	//	}

	@Test
	public void testToManageTimeObservation() {
		testToManageTopNode(UMLElementTypes.TimeObservation_Shape, observationProvider);
	}

	@Test
	public void testToManageDurationObservation() {
		testToManageTopNode(UMLElementTypes.DurationObservation_Shape, observationProvider);
	}

	ITestProvider provider = new ITestProvider() {

		public int getEditPartChildrenSize() {
			return getRootEditPart().getChildren().size();
		}

		public int getSemanticChildrenSize() {
			return getRootSemanticModel().getOwnedElements().size();
		}

		public int getViewChildrenSize() {
			return getRootView().getChildren().size();
		}

		public Element getDropElement() {
			return getRootSemanticModel().getOwnedElements().get(0);
		}

		public GraphicalEditPart getParentEditPart() {
			return getRootEditPart();
		}

		public GraphicalEditPart getDestroyEditPart() {
			return (GraphicalEditPart)getParentEditPart().getChildren().get(0);
		}

	};

	ITestProvider observationProvider = new ITestProvider() {

		public int getEditPartChildrenSize() {
			return getRootEditPart().getChildren().size();
		}

		public int getSemanticChildrenSize() {
			return getPackage().getPackagedElements().size() - 1;
		}

		public int getViewChildrenSize() {
			return getRootView().getChildren().size();
		}

		public Element getDropElement() {
			return null;
		}

		public GraphicalEditPart getParentEditPart() {
			return getRootEditPart();
		}

		public GraphicalEditPart getDestroyEditPart() {
			return (GraphicalEditPart)getParentEditPart().getChildren().get(0);
		}
	};
}
