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

package org.eclipse.papyrus.uml.diagram.statemachine.tests.canonical;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoGEFCommandWrapper;
import org.eclipse.papyrus.junit.framework.classification.InteractiveTest;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.DoActivityStateBehaviorStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.EntryStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ExitStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Test;

public class TestSemantic extends BaseTestCase {
	
	@Test
	public void testCommentInRegion() {
		IGraphicalEditPart commentEP = createChild(CommentEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		
		Comment comment = (Comment) commentEP.resolveSemanticElement();
		Region region = (Region) getRegionCompartmentEditPart().resolveSemanticElement();
		
		EReference expectedFeature = UMLPackage.eINSTANCE.getElement_OwnedComment();
		
		checkContainsChildren(region, comment, expectedFeature);
	}

	@Test
	public void testConstraintInRegion() {
		IGraphicalEditPart constraintEP = createChild(ConstraintEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		
		Constraint constraint = (Constraint) constraintEP.resolveSemanticElement();
		Region region = (Region) getRegionCompartmentEditPart().resolveSemanticElement();
		Package packageElement = region.getNearestPackage();
		
		EReference expectedFeature = UMLPackage.eINSTANCE.getPackage_PackagedElement();
		
		checkContainsChildren(packageElement, constraint, expectedFeature);
	}

	@Test
	public void testConnectionPointReferenceInState() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		
		State state = (State) stateEP.resolveSemanticElement();
		StateMachine stateMachine = UMLFactory.eINSTANCE.createStateMachine();
		
		SetRequest req = new SetRequest(stateEP.getEditingDomain(), state, UMLPackage.eINSTANCE.getState_Submachine(), stateMachine);
		SetValueCommand setValueCmd = new SetValueCommand(req);
		
		executeOnUIThread(new GMFtoGEFCommandWrapper(setValueCmd));
		
		IGraphicalEditPart connectionPointReferenceEP = createChild(ConnectionPointReferenceEditPart.VISUAL_ID, stateEP);
		ConnectionPointReference point = (ConnectionPointReference) connectionPointReferenceEP.resolveSemanticElement();
		
		EReference expectedFeature = UMLPackage.eINSTANCE.getState_Connection();
		
		checkContainsChildren(state, point, expectedFeature);
	}

	@Test
	public void testConnectionPointReferenceInStateWithoutSubmachine() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		
		CreateViewRequest req = createRequest(ConnectionPointReferenceEditPart.VISUAL_ID, stateEP);
		
		Command cmd = stateEP.getCommand(req);
		
		Assert.assertNotNull(cmd);
		Assert.assertFalse(cmd.canExecute());
	}

	@Test
	@InteractiveTest("Open a dialog")
	public void testDoActivtyInState() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart doActivityEP = createChild(DoActivityStateBehaviorStateEditPart.VISUAL_ID, stateEP);
		
		Behavior doActivity = (Behavior) doActivityEP.resolveSemanticElement();
		State state = (State) stateEP.resolveSemanticElement();
		
		EReference expectedFeature = UMLPackage.eINSTANCE.getState_DoActivity();
		
		checkContainChild(state, doActivity, expectedFeature);
	}

	@Test
	@InteractiveTest("Open a dialog")
	public void testEntryInState() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart entryEP = createChild(EntryStateBehaviorEditPart.VISUAL_ID, stateEP);

		Behavior entry = (Behavior) entryEP.resolveSemanticElement();
		State state = (State) stateEP.resolveSemanticElement();

		EReference expectedFeature = UMLPackage.eINSTANCE.getState_Entry();

		checkContainChild(state, entry, expectedFeature);
	}

	@Test
	@InteractiveTest("Open a dialog")
	public void testExitInState() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart exitEP = createChild(ExitStateBehaviorEditPart.VISUAL_ID, stateEP);

		Behavior exit = (Behavior) exitEP.resolveSemanticElement();
		State state = (State) stateEP.resolveSemanticElement();

		EReference expectedFeature = UMLPackage.eINSTANCE.getState_Exit();

		checkContainChild(state, exit, expectedFeature);
	}
	
	protected void checkContainsChildren(EObject parent, EObject child, EReference feature) {
		List<?> containmentList = (List<?>)parent.eGet(feature);
		String message = "Element [" + parent + "] don't contain [" + child +"] whith feature:" + feature.getName();
		Assert.assertTrue(message, containmentList.contains(child));
	}
	
	protected void checkContainChild(EObject parent, EObject child, EReference feature) {
		Object containmentElement = parent.eGet(feature);
		String message = "Element [" + parent + "] don't contain [" + child +"] whith feature:" + feature.getName();
		Assert.assertTrue(message, child.equals(containmentElement));
	}
}
