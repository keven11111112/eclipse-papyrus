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

package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.junit.framework.classification.InteractiveTest;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.tests.IActivityDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Base class for test containers  which add children using right features
 */
public class TestSemanticContainerFeature extends AbstractPapyrusTestCase {

	@Override
	protected String getProjectName() {
		return IActivityDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IActivityDiagramTestsConstants.FILE_NAME;
	}

	protected IGraphicalEditPart getActivityCompartmentEditPart() {
		IGraphicalEditPart activityEP = findChildBySemanticHint(getDiagramEditPart(), ActivityEditPart.VISUAL_ID);
		return findChildBySemanticHint(activityEP, ActivityActivityContentCompartmentEditPart.VISUAL_ID);
	}
	
	@Test
	public void testFeatureActivityInActivity() {
		IGraphicalEditPart activity = createChild(ActivityEditPartCN.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(activity, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior());
	}
	
	@Test
	public void testFeatureTestIdentityActionInActivity() {
		IGraphicalEditPart testIdentityAction = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(testIdentityAction, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureCreateLinkActionInActivity() {
		IGraphicalEditPart createLinkAction = createChild(CreateLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(createLinkAction, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureOpaqueActionActionInActivity() {
		IGraphicalEditPart opaqueAction = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(opaqueAction, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureInitialNodeActionActionInActivity() {
		IGraphicalEditPart initialNode = createChild(InitialNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(initialNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureLoopNodeInActivity() {
		IGraphicalEditPart loopNode = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(loopNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode(), UMLPackage.eINSTANCE.getActivity_Group());
	}

	@Test
	public void testFeatureSequenceNodeInActivity() {
		IGraphicalEditPart loopNode = createChild(SequenceNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(loopNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode(), UMLPackage.eINSTANCE.getActivity_Group());
	}

	@Test
	public void testFeatureStructuredActivityNodeInActivity() {
		IGraphicalEditPart structuredNode = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(structuredNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode());
	}
	
	@Test
	public void testFeatureExpansionRegionInActivity() {
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(expansionRegion, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode());
	}
	
	@Test
	public void testFeatureConditionalNodeInActivity() {
		IGraphicalEditPart conditionalNode = createChild(ConditionalNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListElementReferenceSemantic(conditionalNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode());
	}
	
	@Test
	public void testFeatureExpansionNodeAsOutInExpansionRegion() {
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart expansionNode = createChild(ExpansionNodeAsOutEditPart.VISUAL_ID, expansionRegion);
		
		checkListElementReferenceSemantic(expansionNode, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), UMLPackage.eINSTANCE.getExpansionRegion_OutputElement());
	}
	
	@Test
	public void testFeatureExpansionNodeAsInInExpansionRegion() {
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart expansionNode = createChild(ExpansionNodeAsInEditPart.VISUAL_ID, expansionRegion);
		
		checkListElementReferenceSemantic(expansionNode, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), UMLPackage.eINSTANCE.getExpansionRegion_InputElement());
	}
	
	
	@Test
	public void testFeatureExpansionRegonInStructuredActivityNode() {
		IGraphicalEditPart structuredNode = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart structuredNodeCompartment =  findChildBySemanticHint(structuredNode, StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, structuredNodeCompartment);
		
		checkListElementReferenceSemantic(expansionRegion, structuredNodeCompartment, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
	}
	
	@Test
	public void testFeatureAcceptEventActionInLoopNode() {
		IGraphicalEditPart loopNode = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart loopNodeCompartment =  findChildBySemanticHint(loopNode, LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart acceptEventAction= createChild(AcceptEventActionEditPart.VISUAL_ID, loopNodeCompartment);
		
		checkListElementReferenceSemantic(acceptEventAction, loopNodeCompartment, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
	}
	
	@Test
	public void testFeatureDecisionNodeInConditionalNode() {
		IGraphicalEditPart conditionalNode = createChild(ConditionalNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart loopNodeCompartment =  findChildBySemanticHint(conditionalNode, ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart decisionNode= createChild(DecisionNodeEditPart.VISUAL_ID, loopNodeCompartment);
		
		checkListElementReferenceSemantic(decisionNode, loopNodeCompartment, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testInputPinAsArgumentInCallBeAct() {
		IGraphicalEditPart actionEP = createChild(CallBehaviorActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInCallBeActEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testActionPinAsArgumentInCallBeAct() {
		IGraphicalEditPart actionEP = createChild(CallBehaviorActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInCallBeActEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testValuePinAsArgumentInCallBeAct() {
		IGraphicalEditPart actionEP = createChild(CallBehaviorActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInCallBeActEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testOuputPinAsResultInCallBeAct() {
		IGraphicalEditPart actionEP = createChild(CallBehaviorActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInCallBeActEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getCallAction_Result());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testInputPinAsArgumentInCallOpAct() {
		IGraphicalEditPart actionEP = createChild(CallOperationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInCallOpActEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testActionPinAsArgumentInCallOpAct() {
		IGraphicalEditPart actionEP = createChild(CallOperationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInCallOpActEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testValuePinAsArgumentInCallOpAct() {
		IGraphicalEditPart actionEP = createChild(CallOperationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInCallOpActEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testOuputPinAsResultInCallOpAct() {
		IGraphicalEditPart actionEP = createChild(CallOperationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInCallOpActEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getCallAction_Result());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testInputPinAsTargetInCallOpAct() {
		IGraphicalEditPart actionEP = createChild(CallOperationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInCallOpActAsTargetEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getCallOperationAction_Target());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testActionPinAsTargetInCallOpAct() {
		IGraphicalEditPart actionEP = createChild(CallOperationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getCallOperationAction_Target());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testValuePinAsTargetInCallOpAct() {
		IGraphicalEditPart actionEP = createChild(CallOperationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getCallOperationAction_Target());
	}
	
	@Test
	public void testInputPinAsInputValueInOpaqueAction() {
		IGraphicalEditPart actionEP = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInOpaqueActEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getOpaqueAction_InputValue());
	}
	
	@Test
	public void testActionPinAsInputValueInOpaqueAction() {
		IGraphicalEditPart actionEP = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInOpaqueActEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getOpaqueAction_InputValue());
	}
	
	@Test
	public void testValuePinAsInputValueInOpaqueAction() {
		IGraphicalEditPart actionEP = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInOpaqueActEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getOpaqueAction_InputValue());
	}
	
	@Test
	public void testOuputPinAsOuputValueInOpaqueAction() {
		IGraphicalEditPart actionEP = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInOpaqueActEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getOpaqueAction_OutputValue());
	}
	
	@Test
	public void testInputPinAsRequestInSendObjectAction() {
		IGraphicalEditPart actionEP = createChild(SendObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInSendObjActAsReqEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendObjectAction_Request());
	}
	
	@Test
	public void testActionPinAsRequestInSendObjectAction() {
		IGraphicalEditPart actionEP = createChild(SendObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendObjectAction_Request());
	}
	
	@Test
	public void testValuePinAsRequestInSendObjectAction() {
		IGraphicalEditPart actionEP = createChild(SendObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInSendObjActAsReqEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendObjectAction_Request());
	}
	
	@Test
	public void testInputPinAsTargetInSendObjectAction() {
		IGraphicalEditPart actionEP = createChild(SendObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInSendObjActAsTargetEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendObjectAction_Target());
	}
	
	@Test
	public void testActionPinAsTargetInSendObjectAction() {
		IGraphicalEditPart actionEP = createChild(SendObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendObjectAction_Target());
	}
	
	@Test
	public void testValuePinAsTargetInSendObjectAction() {
		IGraphicalEditPart actionEP = createChild(SendObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendObjectAction_Target());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testInputPinAsArgumentInSendSignalAction() {
		IGraphicalEditPart actionEP = createChild(SendSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInSendSigActEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testActionPinAsArgumentInSendSignalAction() {
		IGraphicalEditPart actionEP = createChild(SendSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInSendSigActEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testValuePinAsArgumentInSendSignalAction() {
		IGraphicalEditPart actionEP = createChild(SendSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInSendSigActEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testInputPinAsTargetInSendSignalAction() {
		IGraphicalEditPart actionEP = createChild(SendSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInSendSigActAsTargetEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendSignalAction_Target());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testActionPinAsTargetInSendSignalAction() {
		IGraphicalEditPart actionEP = createChild(SendSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendSignalAction_Target());
	}
	
	@Test
	@InteractiveTest("It opens a dialog")
	public void testValuePinAsTargetInSendSignalAction() {
		IGraphicalEditPart actionEP = createChild(SendSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getSendSignalAction_Target());
	}
	
	@Test
	public void testInputPinAsLoopVariableInputInLoopNode() {
		IGraphicalEditPart actionEP = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInLoopNodeAsVariableEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput());
	}
	
	@Test
	public void testActionPinAsLoopVariableInputInLoopNode() {
		IGraphicalEditPart actionEP = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInLoopNodeAsVariableEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput());
	}
	
	@Test
	public void testValuePinAsLoopVariableInputInLoopNode() {
		IGraphicalEditPart actionEP = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInLoopNodeAsVariableEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput());
	}
	@Test
	public void testOuputPinAsResultInLoopNode() {
		IGraphicalEditPart actionEP = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInLoopNodeAsResultEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLoopNode_Result());
	}
	
	@Test
	public void testOuputPinAsLoopVariableInLoopNode() {
		IGraphicalEditPart actionEP = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLoopNode_LoopVariable());
	}
	
	@Test
	public void testInputPinAsStrucutredNodeInputInStructuredActivityNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testActionPinAsStrucutredNodeInputInStructuredActivityNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testValuePinAsStrucutredNodeInputInStructuredActivityNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testOuputAsStrucutredNodeOutputInStructuredActivityNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeOutput());
	}
	
	@Test
	public void testInputPinAsStrucutredNodeInputInConditionalNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testActionPinAsStrucutredNodeInputInConditionalNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testValuePinAsStrucutredNodeInputInConditionalNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testOuputAsStrucutredNodeOutputInConditionalNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeOutput());
	}
	
	@Test
	public void testInputPinAsStrucutredNodeInputInExpansionRegion() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testActionPinAsStrucutredNodeInputInExpansionRegion() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testValuePinAsStrucutredNodeInputInExpansionRegion() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testOuputAsStrucutredNodeOutputInExpansionRegion() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeOutput());
	}
	
	@Test
	public void testInputPinAsStrucutredNodeInputInSequenceNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testActionPinAsStrucutredNodeInputInSequenceNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testValuePinAsStrucutredNodeInputInSequenceNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeInput());
	}
	
	@Test
	public void testOuputAsStrucutredNodeOutputInSequenceNode() {
		IGraphicalEditPart actionEP = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInStructuredActivityNodeAsStructuredNodeInputsEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuredActivityNode_StructuredNodeOutput());
	}
	
	@Test
	public void testInputPinAsInsertAtInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInAddStructuralFeatureValueActionAsInserAtEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction_InsertAt());
	}
	
	@Test
	public void testActionPinAsInsertAtInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInAddStructuralFeatureValueActionAsInserAtEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction_InsertAt());
	}
	
	@Test
	public void testValuePinAsInsertAtInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInAddStructuralFeatureValueActionAsInserAtEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction_InsertAt());
	}
	
	@Test
	public void testOuputAsResultInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getWriteStructuralFeatureAction_Result());
	}
	
	@Test
	public void testInputPinAsObjectInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object());
	}
	
	@Test
	public void testActionPinAsObjectInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object());
	}
	
	@Test
	public void testValuePinAsObjectInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object());
	}
	
	@Test
	public void testInputPinAsValueInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getWriteStructuralFeatureAction_Value());
	}
	
	@Test
	public void testActionPinAsValueInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getWriteStructuralFeatureAction_Value());
	}
	
	@Test
	public void testValuePinAsValueInAddStructuralFeatureValueAction() {
		IGraphicalEditPart actionEP = createChild(AddStructuralFeatureValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getWriteStructuralFeatureAction_Value());
	}
	
	@Test
	public void testInputPinAsTargetInDestroyObjectAction() {
		IGraphicalEditPart actionEP = createChild(DestroyObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInDestroyObjectActionEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getDestroyObjectAction_Target());
	}
	
	@Test
	public void testActionPinAsTargetInDestroyObjectAction() {
		IGraphicalEditPart actionEP = createChild(DestroyObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInDestroyObjectActionEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getDestroyObjectAction_Target());
	}
	
	@Test
	public void testValuePinAsTargetInDestroyObjectAction() {
		IGraphicalEditPart actionEP = createChild(DestroyObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInDestroyObjectActionEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getDestroyObjectAction_Target());
	}
	
	@Test
	public void testOuputAsResultInReadVariableAction() {
		IGraphicalEditPart actionEP = createChild(ReadVariableActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReadVariableAction_Result());
	}
	
	@Test
	public void testInputPinAsInsertAtInAddVariableValueAction() {
		IGraphicalEditPart actionEP = createChild(AddVariableValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getAddVariableValueAction_InsertAt());
	}
	
	@Test
	public void testActionPinAsInsertAtInAddVariableValueAction() {
		IGraphicalEditPart actionEP = createChild(AddVariableValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getAddVariableValueAction_InsertAt());
	}
	
	@Test
	public void testValuePinAsInsertAtInAddVariableValueAction() {
		IGraphicalEditPart actionEP = createChild(AddVariableValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getAddVariableValueAction_InsertAt());
	}
	
	@Test
	public void testInputPinAsValueInAddVariableValueAction() {
		IGraphicalEditPart actionEP = createChild(AddVariableValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getWriteVariableAction_Value());
	}
	
	@Test
	public void testActionPinAsValueInAddVariableValueAction() {
		IGraphicalEditPart actionEP = createChild(AddVariableValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInAddVariableValueActionAsValueEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getWriteVariableAction_Value());
	}
	
	@Test
	public void testValuePinAsValueInAddVariableValueAction() {
		IGraphicalEditPart actionEP = createChild(AddVariableValueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInAddVariableValueActionAsValueEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getWriteVariableAction_Value());
	}
	
	@Test
	public void testInputPinAsArgumentInBroadcastSignalAction() {
		IGraphicalEditPart actionEP = createChild(BroadcastSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInBroadcastSignalActionEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	public void testActionPinAsArgumentInBroadcastSignalAction() {
		IGraphicalEditPart actionEP = createChild(BroadcastSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInBroadcastSignalActionEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	public void testValuePinAsArgumentInBroadcastSignalAction() {
		IGraphicalEditPart actionEP = createChild(BroadcastSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInBroadcastSignalActionEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	public void testInputPinAsArgumentInStartObjectBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartObjectBehavoiurActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInStartObjectBehaviorActionAsArgumentEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	public void testActionPinAsArgumentInStartObjectBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartObjectBehavoiurActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInStartObjectBehaviorActionAsArgumentEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	public void testValuePinAsArgumentInStartObjectBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartObjectBehavoiurActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInStartObjectBehaviorActionAsArgumentEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getInvocationAction_Argument());
	}
	
	@Test
	public void testInputPinAsObjectInStartObjectBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartObjectBehavoiurActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInStartObjectBehaviorActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStartObjectBehaviorAction_Object());
	}
	
	@Test
	public void testActionPinAsObjectInStartObjectBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartObjectBehavoiurActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInStartObjectBehaviorActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStartObjectBehaviorAction_Object());
	}
	
	@Test
	public void testValuePinAsObjectInStartObjectBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartObjectBehavoiurActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInStartObjectBehaviorActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStartObjectBehaviorAction_Object());
	}
	
	@Test
	public void testOuputAsResultInStartObjectBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartObjectBehavoiurActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInStartObjectBehaviorActionEditPart.VISUAL_ID, actionEP);
		
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getCallAction_Result());
	}
	
	@Test
	public void testInputPinAsFirstInTestIdentityAction() {
		IGraphicalEditPart actionEP = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInTestIdentityActionAsFirstEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getTestIdentityAction_First());
	}
	
	@Test
	public void testActionPinAsFirstInInsertAtTestIdentityAction() {
		IGraphicalEditPart actionEP = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInTestIdentityActionAsFirstEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getTestIdentityAction_First());
	}
	
	@Test
	public void testValuePinAsFirstInTestIdentityAction() {
		IGraphicalEditPart actionEP = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInTestIdentityActionAsFirstEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getTestIdentityAction_First());
	}
	
	@Test
	public void testInputPinAsSecondInTestIdentityAction() {
		IGraphicalEditPart actionEP = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInTestIdentityActionAsSecondEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getTestIdentityAction_Second());
	}
	
	@Test
	public void testActionPinAsSecondInTestIdentityAction() {
		IGraphicalEditPart actionEP = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInTestIdentityActionAsSecondEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getTestIdentityAction_Second());
	}
	
	@Test
	public void testValuePinAsSecondInTestIdentityAction() {
		IGraphicalEditPart actionEP = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInTestIdentityActionAsSecondEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getTestIdentityAction_Second());
	}
	
	@Test
	public void testOuputAsResultInTestIdentityAction() {
		IGraphicalEditPart actionEP = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInTestIdentityActionEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getTestIdentityAction_Result());
	}
	
	@Test
	public void testInputPinAsObjectInClearStructuralFeatureAction() {
		IGraphicalEditPart actionEP = createChild(ClearStructuralFeatureActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInClearStructuralFeatureActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object());
	}
	
	@Test
	public void testActionPinAsObjectInClearStructuralFeatureAction() {
		IGraphicalEditPart actionEP = createChild(ClearStructuralFeatureActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInClearStructuralFeatureActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object());
	}
	
	@Test
	public void testValuePinAsObjectInClearStructuralFeatureAction() {
		IGraphicalEditPart actionEP = createChild(ClearStructuralFeatureActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInClearStructuralFeatureActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object());
	}
	
	@Test
	public void testOuputAsResultInClearStructuralFeatureAction() {
		IGraphicalEditPart actionEP = createChild(ClearStructuralFeatureActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInClearStructuralFeatureActionEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getClearStructuralFeatureAction_Result());
	}
	
	@Test
	public void testInputPinAsInputValueInCreateLinkAction() {
		IGraphicalEditPart actionEP = createChild(CreateLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInCreateLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testActionPinAsInputValueInCreateLinkAction() {
		IGraphicalEditPart actionEP = createChild(CreateLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInCreateLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testValuePinAsInputValueInCreateLinkAction() {
		IGraphicalEditPart actionEP = createChild(CreateLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInCreateLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testInputPinAsInputValueInReadLinkAction() {
		IGraphicalEditPart actionEP = createChild(ReadLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInReadLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testActionPinAsInputValueInReadLinkAction() {
		IGraphicalEditPart actionEP = createChild(ReadLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInReadLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testValuePinAsInputValueInReadLinkAction() {
		IGraphicalEditPart actionEP = createChild(ReadLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInReadLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testOuputAsResultInReadLinkAction() {
		IGraphicalEditPart actionEP = createChild(ReadLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInReadLinkActionEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReadLinkAction_Result());
	}
	
	@Test
	public void testInputPinAsInputValueInDestroyLinkAction() {
		IGraphicalEditPart actionEP = createChild(DestroyLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInDestroyLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testActionPinAsInputValueInDestroyLinkAction() {
		IGraphicalEditPart actionEP = createChild(DestroyLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionInputPinInDestroyLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testValuePinAsInputValueInDestroyLinkAction() {
		IGraphicalEditPart actionEP = createChild(DestroyLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInDestroyLinkActionAsInputValueEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkListElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getLinkAction_InputValue());
	}
	
	@Test
	public void testInputPinAsObjectInClearAssociationAction() {
		IGraphicalEditPart actionEP = createChild(ClearAssociationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInClearAssociationActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getClearAssociationAction_Object());
	}
	
	@Test
	public void testActionPinAsObjectInClearAssociationAction() {
		IGraphicalEditPart actionEP = createChild(ClearAssociationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInClearAssociationActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getClearAssociationAction_Object());
	}
	
	@Test
	public void testValuePinAsObjectInClearAssociationAction() {
		IGraphicalEditPart actionEP = createChild(ClearAssociationActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInClearAssociationActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getClearAssociationAction_Object());
	}
	
	@Test
	public void testOuputAsResultInReadExtentAction() {
		IGraphicalEditPart actionEP = createChild(ReadExtentActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInReadExtentActionEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReadExtentAction_Result());
	}
	
	@Test
	public void testInputPinAsObjectInReclassifyObjectAction() {
		IGraphicalEditPart actionEP = createChild(ReclassifyObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInReclassifyObjectActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReclassifyObjectAction_Object());
	}
	
	@Test
	public void testActionPinAsObjectInReclassifyObjectAction() {
		IGraphicalEditPart actionEP = createChild(ReclassifyObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInReclassifyObjectActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReclassifyObjectAction_Object());
	}
	
	@Test
	public void testValuePinAsObjectInReclassifyObjectAction() {
		IGraphicalEditPart actionEP = createChild(ReclassifyObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInReclassifyObjectActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReclassifyObjectAction_Object());
	}
	
	@Test
	public void testInputPinAsObjectInReadIsClassifiedObjectAction() {
		IGraphicalEditPart actionEP = createChild(ReadIsClassifiedObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInReadIsClassifiedObjectActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReadIsClassifiedObjectAction_Object());
	}
	
	@Test
	public void testActionPinAsObjectInReadIsClassifiedObjectAction() {
		IGraphicalEditPart actionEP = createChild(ReadIsClassifiedObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInReadIsClassifiedObjectActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReadIsClassifiedObjectAction_Object());
	}
	
	@Test
	public void testValuePinAsObjectInReadIsClassifiedObjectAction() {
		IGraphicalEditPart actionEP = createChild(ReadIsClassifiedObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInReadIsClassifiedObjectActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReadIsClassifiedObjectAction_Object());
	}
	
	@Test
	public void testOuputAsResultInReadIsClassifiedObjectAction() {
		IGraphicalEditPart actionEP = createChild(ReadIsClassifiedObjectActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInReadIsClassifiedObjectActionEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReadIsClassifiedObjectAction_Result());
	}
	
	@Test
	public void testInputPinAsCollectionInReduceAction() {
		IGraphicalEditPart actionEP = createChild(ReduceActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInReduceActionAsCollectionEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReduceAction_Collection());
	}
	
	@Test
	public void testActionPinAsCollectionInReduceAction() {
		IGraphicalEditPart actionEP = createChild(ReduceActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInReduceActionAsCollectionEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReduceAction_Collection());
	}
	
	@Test
	public void testValuePinAsCollectionInReduceAction() {
		IGraphicalEditPart actionEP = createChild(ReduceActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInReduceActionAsCollectionEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReduceAction_Collection());
	}
	
	@Test
	public void testOuputAsResultInReduceAction() {
		IGraphicalEditPart actionEP = createChild(ReduceActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(OutputPinInReduceActionEditPart.VISUAL_ID, actionEP);
		
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getReduceAction_Result());
	}
	
	@Test
	public void testInputPinAsObjectIngetStartClassifierBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartClassifierBehaviorActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(InputPinInStartClassifierBehaviorActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertInputPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStartClassifierBehaviorAction_Object());
	}
	
	@Test
	public void testActionPinAsObjectIngetStartClassifierBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartClassifierBehaviorActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ActionPinInStartClassifierBehaviorActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertActionPinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStartClassifierBehaviorAction_Object());
	}
	
	@Test
	public void testValuePinAsObjectIngetStartClassifierBehaviorAction() {
		IGraphicalEditPart actionEP = createChild(StartClassifierBehaviorActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart pinEP = createChild(ValuePinInStartClassifierBehaviorActionAsObjectEditPart.VISUAL_ID, actionEP);

		assertValuePinType(pinEP);
		checkOneElementReferenceSemantic(pinEP, actionEP, UMLPackage.eINSTANCE.getStartClassifierBehaviorAction_Object());
	}
	
	public void assertInputPinType(IGraphicalEditPart pinEP) {
		EObject pin = getSemanticElement(pinEP);
		Assert.assertSame(pin.eClass(), UMLPackage.eINSTANCE.getInputPin());
	}
	
	public void assertActionPinType(IGraphicalEditPart pinEP) {
		EObject actionPin = getSemanticElement(pinEP);
		Assert.assertSame(actionPin.eClass(), UMLPackage.eINSTANCE.getActionInputPin());
	}
	
	public void assertValuePinType(IGraphicalEditPart pinEP) {
		EObject valuePin = getSemanticElement(pinEP);
		Assert.assertSame(valuePin.eClass(), UMLPackage.eINSTANCE.getValuePin());
	}

	public void checkListElementReferenceSemantic(IGraphicalEditPart childEP, IGraphicalEditPart parentEP, EReference... expectedFeature) {
		EObject child = getSemanticElement(childEP);
		EObject parent = getSemanticElement(parentEP);
		for (EReference feature: expectedFeature) {
			Object objectList = parent.eGet(feature);
			Assert.assertTrue("Feature result should be list", objectList instanceof List<?>);
			List<?> children = (List<?>) objectList;
			Assert.assertTrue(getAssertMasageForContainChild(parent, child, feature), children.contains(child));
		}
	}
	
	public void checkOneElementReferenceSemantic(IGraphicalEditPart childEP, IGraphicalEditPart parentEP, EReference feature) {
		EObject child = getSemanticElement(childEP);
		EObject parent = getSemanticElement(parentEP);

		Object objectChildElement = parent.eGet(feature);
		Assert.assertEquals(getAssertMasageForContainChild(child, parent, feature), child, objectChildElement);
	}
	
	protected EObject getSemanticElement(IGraphicalEditPart ep) {
		EObject activityNode = ep.resolveSemanticElement();
		assertNotNull("Primary view of " + ep.getNotationView() + " must have EObject element", activityNode);
		return activityNode;
	}
	
	private String getAssertMasageForContainChild(EObject child, EObject parent, EReference feature) {
		return "Element:" + parent.getClass().getSimpleName() +  "should contein child:" + child.getClass().getSimpleName()  + " in feature: " + feature.getName();
	}
}
