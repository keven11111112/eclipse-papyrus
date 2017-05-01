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

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.updater.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Test;


public class TestSequenceDiagramInsideInteraction extends AbstractTestSequenceChildNode {

	//this test has been overloaded for combined fragment no name
	// and interactionUse Ref for the label.
	@Override
	protected void testNameLabel(EditPart createdEditPart, String initialName) {
		if (createdEditPart instanceof NamedElementEditPart && (!(createdEditPart instanceof CombinedFragmentEditPart))) {
			GraphicalEditPart namedEditPart = (GraphicalEditPart) ((NamedElementEditPart) createdEditPart).getPrimaryChildEditPart();
			Assert.assertTrue("the primary editpart must be the namelabelEditpart", namedEditPart instanceof ITextAwareEditPart); //$NON-NLS-1$
			String name = namedEditPart.resolveSemanticElement().eClass().getName();
			if (initialName != null) {
				name = initialName;
			}
			// Don't test if it's a Pseudostate: the name = the kind of element
			if (!(((View) namedEditPart.getModel()).getElement() instanceof Pseudostate)) {
				if (name.length() < ((ITextAwareEditPart) namedEditPart).getEditText().length()) {
					Assert.assertEquals(" the name must contain the name of the metaclass", name, ((ITextAwareEditPart) namedEditPart).getEditText().substring(0, name.length())); //$NON-NLS-1$
				} else {
					
					if(createdEditPart instanceof InteractionUseEditPart){
						//this is a particularity of interactionUse
						Assert.assertEquals(" the name must contain the name of the metaclass", "Ref", ((ITextAwareEditPart) namedEditPart).getEditText()); //$NON-NLS-1$
						
					}
					else{
						// not the same it sure but display the mistake is important
						Assert.assertEquals(" the name must contain the name of the metaclass", name, ((ITextAwareEditPart) namedEditPart).getEditText()); //$NON-NLS-1$
					}
				}
			}
			if (namedEditPart instanceof CompartmentEditPart) {
				Assert.assertTrue("the primary editpart must be the namelabelEditpart", namedEditPart instanceof CompartmentEditPart); //$NON-NLS-1$
				Assert.assertTrue("namelabelEditpart must be editable", ((CompartmentEditPart) namedEditPart).isEditModeEnabled()); //$NON-NLS-1$
			} else {
				Assert.assertTrue("the primary editpart must be the namelabelEditpart", namedEditPart instanceof LabelEditPart); //$NON-NLS-1$

			}
		}
	}
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

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return null;
	}


	@Override
	protected boolean isSemanticTest() {
		// TODO Auto-generated method stub
		return true;
	}

	@Test
	public void testToManageLifeline() {
		testToManageNode(UMLElementTypes.Lifeline_Shape, UMLPackage.eINSTANCE.getLifeline(),UMLElementTypes.Interaction_Shape, false);
	}

	/**
	 * Test to manage constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageNode(UMLElementTypes.Constraint_Shape, UMLPackage.eINSTANCE.getConstraint(),UMLElementTypes.Interaction_Shape, false);
	}
	/**
	 * Test to manage constraint.
	 */
	@Test
	public void testToManageCombinedFragment() {
		testToManageNode(UMLElementTypes.CombinedFragment_Shape, UMLPackage.eINSTANCE.getCombinedFragment(),UMLElementTypes.Interaction_Shape, false);
	}

	/**
	 * Test to manage constraint.
	 */
	@Test
	public void testToManageConsiderIgnoreFragment() {
		testToManageNode(UMLElementTypes.ConsiderIgnoreFragment_Shape, UMLPackage.eINSTANCE.getConsiderIgnoreFragment(),UMLElementTypes.Interaction_Shape, false);
	}

	/**
	 * Test to manage comment.
	 */
	@Test
	public void testToManageComment() {
		testToManageNode(UMLElementTypes.Comment_Shape, UMLPackage.eINSTANCE.getComment(),UMLElementTypes.Interaction_Shape, false);
	}

	@Test
	public void testToManageInteractionUse() {
		testToManageNode(UMLElementTypes.InteractionUse_Shape, UMLPackage.eINSTANCE.getInteractionUse(),UMLElementTypes.Interaction_Shape, false);
	}
	
	/**
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractTestNode#createViewRequestShapeContainer()
	 *
	 * @return
	 */
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return null;
	}

}
