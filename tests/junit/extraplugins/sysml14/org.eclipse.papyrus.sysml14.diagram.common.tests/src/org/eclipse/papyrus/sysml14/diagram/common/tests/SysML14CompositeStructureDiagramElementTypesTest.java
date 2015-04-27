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
package org.eclipse.papyrus.sysml14.diagram.common.tests;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class is to check any change in the SysML 1.4 Composite Structure Diagram element type id
 * (since the ids can be used a specialization they are part of public API)
 *
 */
public class SysML14CompositeStructureDiagramElementTypesTest {

	
	@BeforeClass
	public static void loadSysML14CompositeStructureDiagramDefinition() {
		ElementTypeSetConfigurationRegistry instance = ElementTypeSetConfigurationRegistry.getInstance();
		ElementTypeSetConfiguration elementTypeSetConfiguration = instance.getElementTypeSetConfigurations().get("org.eclipse.papyrus.sysml14.service.types.elementTypeSet.composite");
		Assert.assertNotNull("The SysML 1.4 Composite Structure Diagram element type set definition is missing", elementTypeSetConfiguration);
	}
	
	   @Test
		public void testRegistryContentForValueType_3080() {
			Assert.assertTrue("ValueType (3080) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ValueType_3080"));
		}

	    @Test
		public void testRegistryContentForValueType_2068() {
			Assert.assertTrue("ValueType (2068) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ValueType_2068"));
		}

	    @Test
		public void testRegistryContentForDistributedProperty_3070() {
			Assert.assertTrue("DistributedProperty (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DistributedProperty_3070"));
		}

	    @Test
		public void testRegistryContentForDistributedProperty_3101() {
			Assert.assertTrue("DistributedProperty (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DistributedProperty_3101"));
		}

	    @Test
		public void testRegistryContentForConnectorProperty_3070() {
			Assert.assertTrue("ConnectorProperty (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ConnectorProperty_3070"));
		}

	    @Test
		public void testRegistryContentForConnectorProperty_3101() {
			Assert.assertTrue("ConnectorProperty (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ConnectorProperty_3101"));
		}

	    @Test
		public void testRegistryContentForParticipantProperty_3070() {
			Assert.assertTrue("ParticipantProperty (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ParticipantProperty_3070"));
		}

	    @Test
		public void testRegistryContentForParticipantProperty_3101() {
			Assert.assertTrue("ParticipantProperty (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ParticipantProperty_3101"));
		}

	    @Test
		public void testRegistryContentForBindingConnector() {
			Assert.assertTrue("BindingConnector element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.BindingConnector_4013"));
		}

	    @Test
		public void testRegistryContentForBlock_3085() {
			Assert.assertTrue("Block (3085) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Block_3085"));
		}

	    @Test
		public void testRegistryContentForBlock_2073() {
			Assert.assertTrue("Block (2073) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Block_2073"));
		}

	    @Test
		public void testRegistryContentForEndPathMultiplicity_3070() {
			Assert.assertTrue("EndPathMultiplicity (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.EndPathMultiplicity_3070"));
		}

	    @Test
		public void testRegistryContentForEndPathMultiplicity_3101() {
			Assert.assertTrue("EndPathMultiplicity (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.EndPathMultiplicity_3101"));
		}

	    @Test
		public void testRegistryContentForBoundReference_3070() {
			Assert.assertTrue("BoundReference (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.BoundReference_3070"));
		}

	    @Test
		public void testRegistryContentForBoundReference_3101() {
			Assert.assertTrue("BoundReference (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.BoundReference_3101"));
		}

	    @Test
		public void testRegistryContentForAdjunctProperty_3070() {
			Assert.assertTrue("AdjunctProperty (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.AdjunctProperty_3070"));
		}

	    @Test
		public void testRegistryContentForAdjunctProperty_3101() {
			Assert.assertTrue("AdjunctProperty (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.AdjunctProperty_3101"));
		}

	    @Test
		public void testRegistryContentForClassifierBehaviorProperty_3070() {
			Assert.assertTrue("ClassifierBehaviorProperty (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ClassifierBehaviorProperty_3070"));
		}

	    @Test
		public void testRegistryContentForClassifierBehaviorProperty_3101() {
			Assert.assertTrue("ClassifierBehaviorProperty (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ClassifierBehaviorProperty_3101"));
		}

	    @Test
		public void testRegistryContentForItemFlow() {
			Assert.assertTrue("ItemFlow element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ItemFlow_4021"));
		}

	    @Test
		public void testRegistryContentForFlowProperty_3070() {
			Assert.assertTrue("FlowProperty (3070) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowProperty_3070"));
		}

	    @Test
		public void testRegistryContentForFlowProperty_3101() {
			Assert.assertTrue("FlowProperty (3101) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowProperty_3101"));
		}

	    @Test
		public void testRegistryContentForFullPort() {
			Assert.assertTrue("FullPort element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FullPort_3069"));
		}

	    @Test
		public void testRegistryContentForInterfaceBlock_3085() {
			Assert.assertTrue("InterfaceBlock (3085) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.InterfaceBlock_3085"));
		}

	    @Test
		public void testRegistryContentForInterfaceBlock_2073() {
			Assert.assertTrue("InterfaceBlock (2073) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.InterfaceBlock_2073"));
		}

	    @Test
		public void testRegistryContentForProxyPort() {
			Assert.assertTrue("ProxyPort element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ProxyPort_3069"));
		}

	    @Test
		public void testRegistryContentForChangeStructuralFeatureEvent() {
			Assert.assertTrue("ChangeStructuralFeatureEvent element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ChangeStructuralFeatureEvent_2088"));
		}

	    @Test
		public void testRegistryContentForControlOperator_Operation() {
			Assert.assertTrue("ControlOperator Operation element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ControlOperator_Operation_3102"));
		}

	    @Test
		public void testRegistryContentForRate_Parameter() {
			Assert.assertTrue("Rate Parameter element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Rate_Parameter_3088"));
		}

	    @Test
		public void testRegistryContentForDiscrete_Parameter() {
			Assert.assertTrue("Discrete Parameter element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Discrete_Parameter_3088"));
		}

	    @Test
		public void testRegistryContentForContinuous_Parameter() {
			Assert.assertTrue("Continuous Parameter element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Continuous_Parameter_3088"));
		}

	    @Test
		public void testRegistryContentForOptional() {
			Assert.assertTrue("Optional element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Optional_3088"));
		}

	    @Test
		public void testRegistryContentForRationale_3097() {
			Assert.assertTrue("Rationale (3097) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Rationale_3097"));
		}

	    @Test
		public void testRegistryContentForRationale_2109() {
			Assert.assertTrue("Rationale (2109) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Rationale_2109"));
		}

	    @Test
		public void testRegistryContentForView_Package() {
			Assert.assertTrue("View Package element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.View_Package_CompositeStructure"));
		}

	    @Test
		public void testRegistryContentForView_3085() {
			Assert.assertTrue("View (3085) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.View_Class_3085"));
		}

	    @Test
		public void testRegistryContentForView_2073() {
			Assert.assertTrue("View (2073) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.View_Class_2073"));
		}

	    @Test
		public void testRegistryContentForConform_Dependency() {
			Assert.assertTrue("Conform Dependency element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Conform_Dependency_4010"));
		}

	    @Test
		public void testRegistryContentForConform_Generalization() {
			Assert.assertTrue("Conform Generalization element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Conform_Generalization_4015"));
		}

	    @Test
		public void testRegistryContentForProblem_3097() {
			Assert.assertTrue("Problem (3097) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Problem_3097"));
		}

	    @Test
		public void testRegistryContentForProblem_2109() {
			Assert.assertTrue("Problem (2109) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Problem_2109"));
		}

	    @Test
		public void testRegistryContentForViewPoint_3085() {
			Assert.assertTrue("ViewPoint (3085) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ViewPoint_3085"));
		}

	    @Test
		public void testRegistryContentForViewPoint_2073() {
			Assert.assertTrue("ViewPoint (2073) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ViewPoint_2073"));
		}

	    @Test
		public void testRegistryContentForExpose() {
			Assert.assertTrue("Expose element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Expose_4010"));
		}

	    @Test
		public void testRegistryContentForElementGroup_3097() {
			Assert.assertTrue("ElementGroup (3097) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ElementGroup_3097"));
		}

	    @Test
		public void testRegistryContentForElementGroup_2109() {
			Assert.assertTrue("ElementGroup (2109) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ElementGroup_2109"));
		}

	    @Test
		public void testRegistryContentForConstraintBlock_3085() {
			Assert.assertTrue("ConstraintBlock (3085) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ConstraintBlock_3085"));
		}

	    @Test
		public void testRegistryContentForConstraintBlock_2073() {
			Assert.assertTrue("ConstraintBlock (2073) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.ConstraintBlock_2073"));
		}

	    @Test
		public void testRegistryContentForAllocate_Abstraction() {
			Assert.assertTrue("Allocate Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Allocate_Abstraction_4007"));
		}

	    @Test
		public void testRegistryContentForDeriveReqt_Abstraction() {
			Assert.assertTrue("DeriveReqt Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.DeriveReqt_Abstraction_4007"));
		}

	    @Test
		public void testRegistryContentForCopy_Abstraction() {
			Assert.assertTrue("Copy Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Copy_Abstraction_4007"));
		}

	    @Test
		public void testRegistryContentForSatisfy_Abstraction() {
			Assert.assertTrue("Satisfy Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Satisfy_Abstraction_4007"));
		}

	    @Test
		public void testRegistryContentForTestCase_Operation() {
			Assert.assertTrue("TestCase Operation element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.TestCase_Operation_3102"));
		}

	    @Test
		public void testRegistryContentForRequirement_3085() {
			Assert.assertTrue("Requirement (3085) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Requirement_3085"));
		}

	    @Test
		public void testRegistryContentForRequirement_2073() {
			Assert.assertTrue("Requirement (2073) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Requirement_2073"));
		}

	    @Test
		public void testRegistryContentForVerify_Abstraction() {
			Assert.assertTrue("Verify Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Verify_Abstraction_4007"));
		}

	    @Test
		public void testRegistryContentForTrace_Abstraction() {
			Assert.assertTrue("Trace Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Trace_Abstraction_4007"));
		}

	    @Test
		public void testRegistryContentForRefine_Abstraction() {
			Assert.assertTrue("Refine Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Refine_Abstraction_4007"));
		}

	    @Test
		public void testRegistryContentForFlowPort() {
			Assert.assertTrue("FlowPort element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowPort_3069"));
		}

	    @Test
		public void testRegistryContentForFlowSpecification_3087() {
			Assert.assertTrue("FlowSpecification (3087) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowSpecification_3087"));
		}

	    @Test
		public void testRegistryContentForFlowSpecification_2076() {
			Assert.assertTrue("FlowSpecification (2076) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.FlowSpecification_2076"));
		}

}
