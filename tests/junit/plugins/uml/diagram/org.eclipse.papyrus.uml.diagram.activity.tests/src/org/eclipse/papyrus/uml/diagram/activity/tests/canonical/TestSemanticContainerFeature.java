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
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPartCN;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateLinkActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionNodeAsInEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionNodeAsOutEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.TestIdentityActionEditPart;
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
		checkListSemantic(activity, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior());
	}
	
	@Test
	public void testFeatureTestIdentityActionInActivity() {
		IGraphicalEditPart testIdentityAction = createChild(TestIdentityActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(testIdentityAction, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureCreateLinkActionInActivity() {
		IGraphicalEditPart createLinkAction = createChild(CreateLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(createLinkAction, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureOpaqueActionActionInActivity() {
		IGraphicalEditPart opaqueAction = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(opaqueAction, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureInitialNodeActionActionInActivity() {
		IGraphicalEditPart initialNode = createChild(InitialNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(initialNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
	}
	
	@Test
	public void testFeatureLoopNodeInActivity() {
		IGraphicalEditPart loopNode = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(loopNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode(), UMLPackage.eINSTANCE.getActivity_Group());
	}
	
	@Test
	public void testFeatureStructuredActivityNodeInActivity() {
		IGraphicalEditPart structuredNode = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(structuredNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode());
	}
	
	@Test
	public void testFeatureExpansionRegionInActivity() {
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(expansionRegion, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode());
	}
	
	@Test
	public void testFeatureConditionalNodeInActivity() {
		IGraphicalEditPart conditionalNode = createChild(ConditionalNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		checkListSemantic(conditionalNode, getActivityCompartmentEditPart(), UMLPackage.eINSTANCE.getActivity_StructuredNode());
	}
	
	@Test
	public void testFeatureExpansionNodeAsOutInExpansionRegion() {
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart expansionNode = createChild(ExpansionNodeAsOutEditPart.VISUAL_ID, expansionRegion);
		
		checkListSemantic(expansionNode, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), UMLPackage.eINSTANCE.getExpansionRegion_OutputElement());
	}
	
	@Test
	public void testFeatureExpansionNodeAsInInExpansionRegion() {
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart expansionNode = createChild(ExpansionNodeAsInEditPart.VISUAL_ID, expansionRegion);
		
		checkListSemantic(expansionNode, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), UMLPackage.eINSTANCE.getExpansionRegion_InputElement());
	}
	
	
	@Test
	public void testFeatureExpansionRegonInStructuredActivityNode() {
		IGraphicalEditPart structuredNode = createChild(StructuredActivityNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart structuredNodeCompartment =  findChildBySemanticHint(structuredNode, StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart expansionRegion = createChild(ExpansionRegionEditPart.VISUAL_ID, structuredNodeCompartment);
		
		checkListSemantic(expansionRegion, structuredNodeCompartment, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
	}
	
	@Test
	public void testFeatureAcceptEventActionInLoopNode() {
		IGraphicalEditPart loopNode = createChild(LoopNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart loopNodeCompartment =  findChildBySemanticHint(loopNode, LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart acceptEventAction= createChild(AcceptEventActionEditPart.VISUAL_ID, loopNodeCompartment);
		
		checkListSemantic(acceptEventAction, loopNodeCompartment, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
	}
	
	@Test
	public void testFeatureDecisionNodeInConditionalNode() {
		IGraphicalEditPart conditionalNode = createChild(ConditionalNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart loopNodeCompartment =  findChildBySemanticHint(conditionalNode, ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart decisionNode= createChild(DecisionNodeEditPart.VISUAL_ID, loopNodeCompartment);
		
		checkListSemantic(decisionNode, loopNodeCompartment, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
	}
	
	public void checkListSemantic(IGraphicalEditPart ep,IGraphicalEditPart parentEP, EReference... expectedFeature) {
		EObject child = getSemanticElement(ep);
		EObject parent = getSemanticElement(parentEP);
		for (EReference feature: expectedFeature) {
			Object objectList = parent.eGet(feature);
			Assert.assertTrue(objectList instanceof List<?>);
			List<Object> children = (List<Object>) objectList;
			Assert.assertTrue("Element:" + parent.getClass().getSimpleName() + " should contein child:" + child.getClass().getSimpleName()  + " in feature: " + feature.getName(), children.contains(child));
		}
	}
	
	protected EObject getSemanticElement(IGraphicalEditPart ep) {
		EObject activityNode = ep.resolveSemanticElement();
		assertNotNull("Primary view of " + ep.getNotationView() + " must have EObject element", activityNode);
		return activityNode;
	}
}
