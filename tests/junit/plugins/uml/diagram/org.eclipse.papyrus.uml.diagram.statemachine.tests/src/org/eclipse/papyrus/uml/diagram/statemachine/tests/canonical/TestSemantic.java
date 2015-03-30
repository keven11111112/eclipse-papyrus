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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoGEFCommandWrapper;
import org.eclipse.papyrus.junit.framework.classification.InteractiveTest;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.DoActivityStateBehaviorStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.EntryStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ExitStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateChoiceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateDeepHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateForkEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateInitialEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJoinEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJunctionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateShallowHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateTerminateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
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

	@Test
	public void testFinalStateInRegino() {
		IGraphicalEditPart finalStateEP = createChild(FinalStateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		FinalState state = (FinalState) finalStateEP.resolveSemanticElement();
		Region region = (Region) getRegionCompartmentEditPart().resolveSemanticElement();
		
		EReference expectedFeature = UMLPackage.eINSTANCE.getRegion_Subvertex();

		checkContainsChildren(region, state, expectedFeature);
	}

	@Test
	public void testPseudostateChoiseInRegion() {
		checkPseudostate(PseudostateChoiceEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudostateDeepHistoryInRegion() {
		checkPseudostate(PseudostateDeepHistoryEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudostateForkInRegion() {
		checkPseudostate(PseudostateForkEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudostateInitialInRegion() {
		checkPseudostate(PseudostateInitialEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudostateJoinInRegion() {
		checkPseudostate(PseudostateJoinEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudostateJunctionInRegion() {
		checkPseudostate(PseudostateJunctionEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudostateShallowHistoryInRegion() {
		checkPseudostate(PseudostateShallowHistoryEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudostateTerminateInRegion() {
		checkPseudostate(PseudostateTerminateEditPart.VISUAL_ID);
	}

	public void checkPseudostate(int VID) {
		IGraphicalEditPart stateEP = createChild(VID, getRegionCompartmentEditPart());

		Pseudostate pseudostate = (Pseudostate) stateEP.resolveSemanticElement();
		Region region = (Region) getRegionCompartmentEditPart().resolveSemanticElement();

		checkContainsChildren(region, pseudostate, UMLPackage.eINSTANCE.getRegion_Subvertex());
	}

	@Test
	public void testPseudostateChoiseKind() {
		checkPseudostateKind(PseudostateChoiceEditPart.VISUAL_ID, PseudostateKind.CHOICE_LITERAL, "Choice");
	}

	@Test
	public void testPseudostateDeepHistoryKind() {
		checkPseudostateKind(PseudostateDeepHistoryEditPart.VISUAL_ID, PseudostateKind.DEEP_HISTORY_LITERAL, "DeepHistory");
	}

	@Test
	public void testPseudostateForkKind() {
		checkPseudostateKind(PseudostateForkEditPart.VISUAL_ID, PseudostateKind.FORK_LITERAL, "Fork");
	}

	@Test
	public void testPseudostateInitialKind() {
		checkPseudostateKind(PseudostateInitialEditPart.VISUAL_ID, PseudostateKind.INITIAL_LITERAL, "Initial");
	}

	@Test
	public void testPseudostateJoinKind() {
		checkPseudostateKind(PseudostateJoinEditPart.VISUAL_ID, PseudostateKind.JOIN_LITERAL, "Join");
	}

	@Test
	public void testPseudostateJunctionKind() {
		checkPseudostateKind(PseudostateJunctionEditPart.VISUAL_ID, PseudostateKind.JUNCTION_LITERAL, "Junction");
	}

	@Test
	public void testPseudostateShallowHistoryKind() {
		checkPseudostateKind(PseudostateShallowHistoryEditPart.VISUAL_ID, PseudostateKind.SHALLOW_HISTORY_LITERAL, "ShallowHistory");
	}

	@Test
	public void testEntryPointJunctionKind() {
		checkPseudostateKind(PseudostateEntryPointEditPart.VISUAL_ID, PseudostateKind.ENTRY_POINT_LITERAL, "EntryPoint");
	}

	@Test
	public void testPseudostateExitPointKind() {
		checkPseudostateKind(PseudostateExitPointEditPart.VISUAL_ID, PseudostateKind.EXIT_POINT_LITERAL, "ExitPoint");
	}

	@Test
	public void testPseudostateTerminateKind() {
		checkPseudostateKind(PseudostateTerminateEditPart.VISUAL_ID, PseudostateKind.TERMINATE_LITERAL, "Terminate");
	}

	public void checkPseudostateKind(int VID, PseudostateKind kind, String startName) {
		IGraphicalEditPart stateEP = createChild(VID, getRegionCompartmentEditPart());
		Pseudostate pseudostate = (Pseudostate) stateEP.resolveSemanticElement();
		Assert.assertEquals(kind, pseudostate.getKind());
		Assert.assertTrue(pseudostate.getName().startsWith(startName));
	}

	@Test
	public void testPseudoEntryPointInStateMachine() {
		checkPseudoPointInStateMachine(PseudostateEntryPointEditPart.VISUAL_ID);
	}

	@Test
	public void testPseudoExitPointInStateMachine() {
		checkPseudoPointInStateMachine(PseudostateExitPointEditPart.VISUAL_ID);
	}

	public void checkPseudoPointInStateMachine(int VID) {
		IGraphicalEditPart stateMachineEP = findChildBySemanticHint(getDiagramEditPart(), StateMachineEditPart.VISUAL_ID);
		IGraphicalEditPart pseudostateEP = createChild(VID, stateMachineEP);

		Pseudostate pseudostate = (Pseudostate) pseudostateEP.resolveSemanticElement();
		StateMachine stateMachine = (StateMachine) stateMachineEP.resolveSemanticElement();

		checkContainsChildren(stateMachine, pseudostate, UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint());
	}
	
	@Test
	public void testPseudoEntryPointInRegion() {
		checkPseudoPointInRegion(PseudostateEntryPointEditPart.VISUAL_ID);
	}
	
	@Test
	public void testPseudoExitPointInRegion() {
		checkPseudoPointInRegion(PseudostateExitPointEditPart.VISUAL_ID);
	}

	public void checkPseudoPointInRegion(int VID) {
		Request req = createUnspecifiedToolRequest(VID);
		
		Command cmd = getRegionCompartmentEditPart().getCommand(req);
		executeOnUIThread(cmd);
		
		IGraphicalEditPart stateMachineEP = findChildBySemanticHint(getDiagramEditPart(), StateMachineEditPart.VISUAL_ID);
		IGraphicalEditPart pseudostateEP = findChildBySemanticHint(stateMachineEP, VID);
		
		StateMachine stateMachine = (StateMachine) stateMachineEP.resolveSemanticElement();
		Pseudostate pseudostate = (Pseudostate) pseudostateEP.resolveSemanticElement();

		checkContainsChildren(stateMachine, pseudostate, UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint());
	}
	
	@Test
	public void testRegionInRegion() {
		Request createRegionInRegionRequest = createUnspecifiedToolRequest(RegionEditPart.VISUAL_ID);
		Command cmd = getRegionCompartmentEditPart().getCommand(createRegionInRegionRequest);
		executeOnUIThread(cmd);
		
		IGraphicalEditPart stateMachineComp = (IGraphicalEditPart)getRegionCompartmentEditPart().getParent().getParent();
		Assert.assertEquals(stateMachineComp.getChildren().size(), 2);
		
		IGraphicalEditPart firstRegionEP = (IGraphicalEditPart) stateMachineComp.getChildren().get(0);
		IGraphicalEditPart secondRegionEP = (IGraphicalEditPart) stateMachineComp.getChildren().get(1);
		
		Assert.assertNotEquals(firstRegionEP, secondRegionEP);
		
		StateMachine stateMachine = (StateMachine)getRegionCompartmentEditPart().resolveSemanticElement().eContainer();
		
		Region region_1 = (Region) firstRegionEP.resolveSemanticElement();
		Region region_2 = (Region) secondRegionEP.resolveSemanticElement();
		
		checkContainsChildren(stateMachine, region_1, UMLPackage.eINSTANCE.getStateMachine_Region());
		checkContainsChildren(stateMachine, region_2, UMLPackage.eINSTANCE.getStateMachine_Region());
	}

	@Test
	public void testRegionInStateMachine() {
		IGraphicalEditPart stateMachineComp = (IGraphicalEditPart)getRegionCompartmentEditPart().getParent().getParent();
		IGraphicalEditPart regionEP = createChild(RegionEditPart.VISUAL_ID, stateMachineComp);
		
		StateMachine stateMachine = (StateMachine)stateMachineComp.resolveSemanticElement();
		Region region = (Region) regionEP.resolveSemanticElement();
		
		checkContainsChildren(stateMachine, region, UMLPackage.eINSTANCE.getStateMachine_Region());
	}

	@Test
	public void testRegionInState() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart regionEP = createChild(RegionEditPart.VISUAL_ID, stateEP);
		
		State stateMachine = (State)stateEP.resolveSemanticElement();
		Region region = (Region) regionEP.resolveSemanticElement();
		
		checkContainsChildren(stateMachine, region, UMLPackage.eINSTANCE.getState_Region());
	}

	@Test
	public void testRegionInStateCompartment() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart stateComp = findChildBySemanticHint(stateEP, StateCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart regionEP = createChild(RegionEditPart.VISUAL_ID, stateComp);
		
		State state = (State)stateEP.resolveSemanticElement();
		Region region = (Region) regionEP.resolveSemanticElement();
		
		checkContainsChildren(state, region, UMLPackage.eINSTANCE.getState_Region());
	}

	@Test
	public void testStateInRegion() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		
		State state = (State)stateEP.resolveSemanticElement();
		Region region = (Region) getRegionCompartmentEditPart().resolveSemanticElement();
		
		checkContainsChildren(region, state, UMLPackage.eINSTANCE.getRegion_Subvertex());
	}

	protected Request createUnspecifiedToolRequest(int VID) {
		List<IElementType> types = new LinkedList<IElementType>();
		
		types.add(UMLElementTypes.getElementType(VID));
		
		AspectUnspecifiedTypeCreationTool.CreateAspectUnspecifiedTypeRequest req =
				new AspectUnspecifiedTypeCreationTool(types).new CreateAspectUnspecifiedTypeRequest(types, getRegionCompartmentEditPart().getDiagramPreferencesHint());
		return req;
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
