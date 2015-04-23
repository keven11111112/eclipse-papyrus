/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.service.types.tests;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * This class is to check any change in the SysML 1.4 element type id
 * (since the ids can be used a specialization they are part of public API)
 *
 */
public class SysML14ElementTypesTest {

	@BeforeClass
	public static void loadSysml14Defintion() {
		ElementTypeSetConfigurationRegistry instance = ElementTypeSetConfigurationRegistry.getInstance();
		ElementTypeSetConfiguration elementTypeSetConfiguration = instance.getElementTypeSetConfigurations().get("org.eclipse.papyrus.sysml14.service.types.elementTypeSet");
		Assert.assertNotNull("The SysML 1.4 element type set definition is missing", elementTypeSetConfiguration);
	}
	

    @Test
	public void testRegistryContentForValueType() {
		Assert.assertTrue("ValueType element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ValueType"));
	}

    @Test
	public void testRegistryContentForDistributedProperty() {
		Assert.assertTrue("DistributedProperty element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DistributedProperty"));
	}

    @Test
	public void testRegistryContentForConnectorProperty() {
		Assert.assertTrue("ConnectorProperty element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ConnectorProperty"));
	}

    @Test
	public void testRegistryContentForParticipantProperty() {
		Assert.assertTrue("ParticipantProperty element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ParticipantProperty"));
	}

    @Test
	public void testRegistryContentForBindingConnector() {
		Assert.assertTrue("BindingConnector element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.BindingConnector"));
	}

    @Test
	public void testRegistryContentForBlock() {
		Assert.assertTrue("Block element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Block"));
	}

    @Test
	public void testRegistryContentForPropertySpecificType() {
		Assert.assertTrue("PropertySpecificType element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.PropertySpecificType"));
	}

    @Test
	public void testRegistryContentForNestedConnectorEnd_ConnectorEnd() {
		Assert.assertTrue("NestedConnectorEnd ConnectorEnd element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.NestedConnectorEnd_ConnectorEnd"));
	}

    @Test
	public void testRegistryContentForNestedConnectorEnd_Element() {
		Assert.assertTrue("NestedConnectorEnd Element element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.NestedConnectorEnd_Element"));
	}

    @Test
	public void testRegistryContentForDirectedRelationshipPropertyPath() {
		Assert.assertTrue("DirectedRelationshipPropertyPath element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DirectedRelationshipPropertyPath"));
	}

    @Test
	public void testRegistryContentForElementPropertyPath() {
		Assert.assertTrue("ElementPropertyPath element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ElementPropertyPath"));
	}

    @Test
	public void testRegistryContentForEndPathMultiplicity() {
		Assert.assertTrue("EndPathMultiplicity element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.EndPathMultiplicity"));
	}

    @Test
	public void testRegistryContentForBoundReference() {
		Assert.assertTrue("BoundReference element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.BoundReference"));
	}

    @Test
	public void testRegistryContentForAdjunctProperty() {
		Assert.assertTrue("AdjunctProperty element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.AdjunctProperty"));
	}

    @Test
	public void testRegistryContentForClassifierBehaviorProperty() {
		Assert.assertTrue("ClassifierBehaviorProperty element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ClassifierBehaviorProperty"));
	}

    @Test
	public void testRegistryContentForItemFlow() {
		Assert.assertTrue("ItemFlow element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ItemFlow"));
	}

    @Test
	public void testRegistryContentForFlowProperty() {
		Assert.assertTrue("FlowProperty element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowProperty"));
	}

    @Test
	public void testRegistryContentForFullPort() {
		Assert.assertTrue("FullPort element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FullPort"));
	}

    @Test
	public void testRegistryContentForInterfaceBlock() {
		Assert.assertTrue("InterfaceBlock element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.InterfaceBlock"));
	}

    @Test
	public void testRegistryContentForProxyPort() {
		Assert.assertTrue("ProxyPort element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ProxyPort"));
	}

    @Test
	public void testRegistryContentForAcceptChangeStructuralFeatureEventAction() {
		Assert.assertTrue("AcceptChangeStructuralFeatureEventAction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.AcceptChangeStructuralFeatureEventAction"));
	}

    @Test
	public void testRegistryContentForChangeStructuralFeatureEvent() {
		Assert.assertTrue("ChangeStructuralFeatureEvent element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ChangeStructuralFeatureEvent"));
	}

    @Test
	public void testRegistryContentForDirectedFeature() {
		Assert.assertTrue("DirectedFeature element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DirectedFeature"));
	}

    @Test
	public void testRegistryContentForInvocationOnNestedPortAction_InvocationAction() {
		Assert.assertTrue("InvocationOnNestedPortAction InvocationAction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.InvocationOnNestedPortAction_InvocationAction"));
	}

    @Test
	public void testRegistryContentForInvocationOnNestedPortAction_Element() {
		Assert.assertTrue("InvocationOnNestedPortAction Element element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.InvocationOnNestedPortAction_Element"));
	}

    @Test
	public void testRegistryContentForTriggerOnNestedPort_Trigger() {
		Assert.assertTrue("TriggerOnNestedPort Trigger element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.TriggerOnNestedPort_Trigger"));
	}

    @Test
	public void testRegistryContentForTriggerOnNestedPort_Element() {
		Assert.assertTrue("TriggerOnNestedPort Element element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.TriggerOnNestedPort_Element"));
	}

    @Test
	public void testRegistryContentForOverwrite() {
		Assert.assertTrue("Overwrite element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Overwrite"));
	}

    @Test
	public void testRegistryContentForControlOperator_Behavior() {
		Assert.assertTrue("ControlOperator Behavior element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ControlOperator_Behavior"));
	}

    @Test
	public void testRegistryContentForControlOperator_Operation() {
		Assert.assertTrue("ControlOperator Operation element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ControlOperator_Operation"));
	}

    @Test
	public void testRegistryContentForRate_ActivityEdge() {
		Assert.assertTrue("Rate ActivityEdge element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Rate_ActivityEdge"));
	}

    @Test
	public void testRegistryContentForRate_Parameter() {
		Assert.assertTrue("Rate Parameter element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Rate_Parameter"));
	}

    @Test
	public void testRegistryContentForNoBuffer() {
		Assert.assertTrue("NoBuffer element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.NoBuffer"));
	}

    @Test
	public void testRegistryContentForDiscrete_ActivityEdge() {
		Assert.assertTrue("Discrete ActivityEdge element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Discrete_ActivityEdge"));
	}

    @Test
	public void testRegistryContentForDiscrete_Parameter() {
		Assert.assertTrue("Discrete Parameter element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Discrete_Parameter"));
	}

    @Test
	public void testRegistryContentForContinuous_ActivityEdge() {
		Assert.assertTrue("Continuous ActivityEdge element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Continuous_ActivityEdge"));
	}

    @Test
	public void testRegistryContentForContinuous_Parameter() {
		Assert.assertTrue("Continuous Parameter element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Continuous_Parameter"));
	}

    @Test
	public void testRegistryContentForProbability_ActivityEdge() {
		Assert.assertTrue("Probability ActivityEdge element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Probability_ActivityEdge"));
	}

    @Test
	public void testRegistryContentForProbability_ParameterSet() {
		Assert.assertTrue("Probability ParameterSet element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Probability_ParameterSet"));
	}

    @Test
	public void testRegistryContentForOptional() {
		Assert.assertTrue("Optional element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Optional"));
	}

    @Test
	public void testRegistryContentForRationale() {
		Assert.assertTrue("Rationale element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Rationale"));
	}

    @Test
	public void testRegistryContentForView_Package() {
		Assert.assertTrue("View Package element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.View_Package"));
	}

    @Test
	public void testRegistryContentForView_Class() {
		Assert.assertTrue("View Class element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.View_Class"));
	}

    @Test
	public void testRegistryContentForConform_Dependency() {
		Assert.assertTrue("Conform Dependency element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Conform_Dependency"));
	}

    @Test
	public void testRegistryContentForConform_Generalization() {
		Assert.assertTrue("Conform Generalization element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Conform_Generalization"));
	}

    @Test
	public void testRegistryContentForProblem() {
		Assert.assertTrue("Problem element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Problem"));
	}

    @Test
	public void testRegistryContentForViewPoint() {
		Assert.assertTrue("ViewPoint element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ViewPoint"));
	}

    @Test
	public void testRegistryContentForStakeholder() {
		Assert.assertTrue("Stakeholder element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Stakeholder"));
	}

    @Test
	public void testRegistryContentForExpose() {
		Assert.assertTrue("Expose element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Expose"));
	}

    @Test
	public void testRegistryContentForElementGroup() {
		Assert.assertTrue("ElementGroup element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ElementGroup"));
	}

    @Test
	public void testRegistryContentForConstraintBlock() {
		Assert.assertTrue("ConstraintBlock element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ConstraintBlock"));
	}

    @Test
	public void testRegistryContentForAllocateActivityPartition() {
		Assert.assertTrue("AllocateActivityPartition element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.AllocateActivityPartition"));
	}

    @Test
	public void testRegistryContentForAllocate_Abstraction() {
		Assert.assertTrue("Allocate Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Allocate_Abstraction"));
	}

    @Test
	public void testRegistryContentForAllocate_DirectedRelationship() {
		Assert.assertTrue("Allocate DirectedRelationship element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Allocate_DirectedRelationship"));
	}

    @Test
	public void testRegistryContentForDeriveReqt_Abstraction() {
		Assert.assertTrue("DeriveReqt Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DeriveReqt_Abstraction"));
	}

    @Test
	public void testRegistryContentForDeriveReqt_DirectedRelationship() {
		Assert.assertTrue("DeriveReqt DirectedRelationship element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DeriveReqt_DirectedRelationship"));
	}

    @Test
	public void testRegistryContentForCopy_Abstraction() {
		Assert.assertTrue("Copy Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Copy_Abstraction"));
	}

    @Test
	public void testRegistryContentForCopy_DirectedRelationship() {
		Assert.assertTrue("Copy DirectedRelationship element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Copy_DirectedRelationship"));
	}

    @Test
	public void testRegistryContentForSatisfy_Abstraction() {
		Assert.assertTrue("Satisfy Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Satisfy_Abstraction"));
	}

    @Test
	public void testRegistryContentForSatisfy_DirectedRelationship() {
		Assert.assertTrue("Satisfy DirectedRelationship element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Satisfy_DirectedRelationship"));
	}

    @Test
	public void testRegistryContentForTestCase_Operation() {
		Assert.assertTrue("TestCase Operation element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.TestCase_Operation"));
	}

    @Test
	public void testRegistryContentForTestCase_Behavior() {
		Assert.assertTrue("TestCase Behavior element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.TestCase_Behavior"));
	}

    @Test
	public void testRegistryContentForRequirement() {
		Assert.assertTrue("Requirement element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Requirement"));
	}

    @Test
	public void testRegistryContentForVerify_Abstraction() {
		Assert.assertTrue("Verify Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Verify_Abstraction"));
	}

    @Test
	public void testRegistryContentForVerify_DirectedRelationship() {
		Assert.assertTrue("Verify DirectedRelationship element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Verify_DirectedRelationship"));
	}

    @Test
	public void testRegistryContentForTrace_Abstraction() {
		Assert.assertTrue("Trace Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Trace_Abstraction"));
	}

    @Test
	public void testRegistryContentForTrace_DirectedRelationship() {
		Assert.assertTrue("Trace DirectedRelationship element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Trace_DirectedRelationship"));
	}

    @Test
	public void testRegistryContentForRefine_Abstraction() {
		Assert.assertTrue("Refine Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Refine_Abstraction"));
	}

    @Test
	public void testRegistryContentForRefine_DirectedRelationship() {
		Assert.assertTrue("Refine DirectedRelationship element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Refine_DirectedRelationship"));
	}

    @Test
	public void testRegistryContentForFlowPort() {
		Assert.assertTrue("FlowPort element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowPort"));
	}

    @Test
	public void testRegistryContentForFlowSpecification() {
		Assert.assertTrue("FlowSpecification element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowSpecification"));
	}

    @Test
	public void testRegistryContentForAllocated() {
		Assert.assertTrue("Allocated element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Allocated"));
	}

    @Test
	public void testRegistryContentForRequirementRelated() {
		Assert.assertTrue("RequirementRelated element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.RequirementRelated"));
	}

    @Test
	public void testRegistryContentForUnit() {
		Assert.assertTrue("Unit element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Unit"));
	}

    @Test
	public void testRegistryContentForQuantityKind() {
		Assert.assertTrue("QuantityKind element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.QuantityKind"));
	}

    @Test
	public void testRegistryContentForPartAssociation() {
		Assert.assertTrue("PartAssociation element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.PartAssociation"));
	}



}
