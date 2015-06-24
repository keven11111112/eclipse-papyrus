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
 * This class is to check any change in the SysML 1.4 element type id
 * (since the ids can be used a specialization they are part of public API)
 *
 */
public class SysML14UMLClassDiagramElementTypesTest {

	@BeforeClass
	public static void loadSysML14UMLClassDiagramDefinition() {
		ElementTypeSetConfigurationRegistry instance = ElementTypeSetConfigurationRegistry.getInstance();		
		ElementTypeSetConfiguration celementTypeSetConfiguration = instance.getElementTypeSetConfigurations().get("org.eclipse.papyrus.sysml14.service.types.elementTypeSet.class");
		Assert.assertNotNull("The SysML 1.4 UML Class Diagram element type set definition is missing", celementTypeSetConfiguration);		
	}	
	
    @Test
	public void testRegistryContentForValueType_2010() {
		Assert.assertTrue("ValueType (2010) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ValueType_2010"));
	}

    @Test
	public void testRegistryContentForValueType_3027() {
		Assert.assertTrue("ValueType (3027) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ValueType_3027"));
	}

    @Test
	public void testRegistryContentForValueType_3043() {
		Assert.assertTrue("ValueType (3043) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ValueType_3043"));
	}

    @Test
	public void testRegistryContentForValueType_3044() {
		Assert.assertTrue("ValueType (3044) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ValueType_3044"));
	}

    @Test
	public void testRegistryContentForValueType_3045() {
		Assert.assertTrue("ValueType (3045) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ValueType_3045"));
	}

    @Test
	public void testRegistryContentForDistributedProperty_3002() {
		Assert.assertTrue("DistributedProperty (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.DistributedProperty_3002"));
	}

    @Test
	public void testRegistryContentForDistributedProperty_3005() {
		Assert.assertTrue("DistributedProperty (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.DistributedProperty_3005"));
	}

    @Test
	public void testRegistryContentForDistributedProperty_3006() {
		Assert.assertTrue("DistributedProperty (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.DistributedProperty_3006"));
	}

    @Test
	public void testRegistryContentForDistributedProperty_3012() {
		Assert.assertTrue("DistributedProperty (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.DistributedProperty_3012"));
	}

    @Test
	public void testRegistryContentForDistributedProperty_3018() {
		Assert.assertTrue("DistributedProperty (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.DistributedProperty_3018"));
	}

    @Test
	public void testRegistryContentForDistributedProperty_3041() {
		Assert.assertTrue("DistributedProperty (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.DistributedProperty_3041"));
	}

    @Test
	public void testRegistryContentForConnectorProperty_3002() {
		Assert.assertTrue("ConnectorProperty (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConnectorProperty_3002"));
	}

    @Test
	public void testRegistryContentForConnectorProperty_3005() {
		Assert.assertTrue("ConnectorProperty (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConnectorProperty_3005"));
	}

    @Test
	public void testRegistryContentForConnectorProperty_3006() {
		Assert.assertTrue("ConnectorProperty (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConnectorProperty_3006"));
	}

    @Test
	public void testRegistryContentForConnectorProperty_3012() {
		Assert.assertTrue("ConnectorProperty (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConnectorProperty_3012"));
	}

    @Test
	public void testRegistryContentForConnectorProperty_3018() {
		Assert.assertTrue("ConnectorProperty (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConnectorProperty_3018"));
	}

    @Test
	public void testRegistryContentForConnectorProperty_3041() {
		Assert.assertTrue("ConnectorProperty (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConnectorProperty_3041"));
	}

    @Test
	public void testRegistryContentForParticipantProperty_3002() {
		Assert.assertTrue("ParticipantProperty (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ParticipantProperty_3002"));
	}

    @Test
	public void testRegistryContentForParticipantProperty_3005() {
		Assert.assertTrue("ParticipantProperty (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ParticipantProperty_3005"));
	}

    @Test
	public void testRegistryContentForParticipantProperty_3006() {
		Assert.assertTrue("ParticipantProperty (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ParticipantProperty_3006"));
	}

    @Test
	public void testRegistryContentForParticipantProperty_3012() {
		Assert.assertTrue("ParticipantProperty (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ParticipantProperty_3012"));
	}

    @Test
	public void testRegistryContentForParticipantProperty_3018() {
		Assert.assertTrue("ParticipantProperty (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ParticipantProperty_3018"));
	}

    @Test
	public void testRegistryContentForParticipantProperty_3041() {
		Assert.assertTrue("ParticipantProperty (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ParticipantProperty_3041"));
	}

    @Test
	public void testRegistryContentForBlock_2008() {
		Assert.assertTrue("Block (2008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Block_2008"));
	}

    @Test
	public void testRegistryContentForBlock_NestedBlock_Classifier() {
		Assert.assertTrue("Block (NestedBlock_Classifier) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Block_NestedBlock_Classifier"));
	}

    @Test
	public void testRegistryContentForBlock_3004() {
		Assert.assertTrue("Block (3004) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Block_3004"));
	}

    @Test
	public void testRegistryContentForBlock_3008() {
		Assert.assertTrue("Block (3008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Block_3008"));
	}

    @Test
	public void testRegistryContentForBlock_3010() {
		Assert.assertTrue("Block (3010) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Block_3010"));
	}

    @Test
	public void testRegistryContentForBlock_3014() {
		Assert.assertTrue("Block (3014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Block_3014"));
	}

    @Test
	public void testRegistryContentForEndPathMultiplicity_3002() {
		Assert.assertTrue("EndPathMultiplicity (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.EndPathMultiplicity_3002"));
	}

    @Test
	public void testRegistryContentForEndPathMultiplicity_3005() {
		Assert.assertTrue("EndPathMultiplicity (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.EndPathMultiplicity_3005"));
	}

    @Test
	public void testRegistryContentForEndPathMultiplicity_3006() {
		Assert.assertTrue("EndPathMultiplicity (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.EndPathMultiplicity_3006"));
	}

    @Test
	public void testRegistryContentForEndPathMultiplicity_3012() {
		Assert.assertTrue("EndPathMultiplicity (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.EndPathMultiplicity_3012"));
	}

    @Test
	public void testRegistryContentForEndPathMultiplicity_3018() {
		Assert.assertTrue("EndPathMultiplicity (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.EndPathMultiplicity_3018"));
	}

    @Test
	public void testRegistryContentForEndPathMultiplicity_3041() {
		Assert.assertTrue("EndPathMultiplicity (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.EndPathMultiplicity_3041"));
	}

    @Test
	public void testRegistryContentForBoundReference_3002() {
		Assert.assertTrue("BoundReference (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.BoundReference_3002"));
	}

    @Test
	public void testRegistryContentForBoundReference_3005() {
		Assert.assertTrue("BoundReference (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.BoundReference_3005"));
	}

    @Test
	public void testRegistryContentForBoundReference_3006() {
		Assert.assertTrue("BoundReference (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.BoundReference_3006"));
	}

    @Test
	public void testRegistryContentForBoundReference_3012() {
		Assert.assertTrue("BoundReference (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.BoundReference_3012"));
	}

    @Test
	public void testRegistryContentForBoundReference_3018() {
		Assert.assertTrue("BoundReference (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.BoundReference_3018"));
	}

    @Test
	public void testRegistryContentForBoundReference_3041() {
		Assert.assertTrue("BoundReference (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.BoundReference_3041"));
	}

    @Test
	public void testRegistryContentForAdjunctProperty_3002() {
		Assert.assertTrue("AdjunctProperty (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.AdjunctProperty_3002"));
	}

    @Test
	public void testRegistryContentForAdjunctProperty_3005() {
		Assert.assertTrue("AdjunctProperty (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.AdjunctProperty_3005"));
	}

    @Test
	public void testRegistryContentForAdjunctProperty_3006() {
		Assert.assertTrue("AdjunctProperty (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.AdjunctProperty_3006"));
	}

    @Test
	public void testRegistryContentForAdjunctProperty_3012() {
		Assert.assertTrue("AdjunctProperty (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.AdjunctProperty_3012"));
	}

    @Test
	public void testRegistryContentForAdjunctProperty_3018() {
		Assert.assertTrue("AdjunctProperty (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.AdjunctProperty_3018"));
	}

    @Test
	public void testRegistryContentForAdjunctProperty_3041() {
		Assert.assertTrue("AdjunctProperty (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.AdjunctProperty_3041"));
	}

    @Test
	public void testRegistryContentForClassifierBehaviorProperty_3002() {
		Assert.assertTrue("ClassifierBehaviorProperty (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ClassifierBehaviorProperty_3002"));
	}

    @Test
	public void testRegistryContentForClassifierBehaviorProperty_3005() {
		Assert.assertTrue("ClassifierBehaviorProperty (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ClassifierBehaviorProperty_3005"));
	}

    @Test
	public void testRegistryContentForClassifierBehaviorProperty_3006() {
		Assert.assertTrue("ClassifierBehaviorProperty (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ClassifierBehaviorProperty_3006"));
	}

    @Test
	public void testRegistryContentForClassifierBehaviorProperty_3012() {
		Assert.assertTrue("ClassifierBehaviorProperty (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ClassifierBehaviorProperty_3012"));
	}

    @Test
	public void testRegistryContentForClassifierBehaviorProperty_3018() {
		Assert.assertTrue("ClassifierBehaviorProperty (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ClassifierBehaviorProperty_3018"));
	}

    @Test
	public void testRegistryContentForClassifierBehaviorProperty_3041() {
		Assert.assertTrue("ClassifierBehaviorProperty (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ClassifierBehaviorProperty_3041"));
	}

    @Test
	public void testRegistryContentForItemFlow() {
		Assert.assertTrue("ItemFlow element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ItemFlow_4026"));
	}

    @Test
	public void testRegistryContentForFlowProperty_3002() {
		Assert.assertTrue("FlowProperty (3002) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowProperty_3002"));
	}

    @Test
	public void testRegistryContentForFlowProperty_3005() {
		Assert.assertTrue("FlowProperty (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowProperty_3005"));
	}

    @Test
	public void testRegistryContentForFlowProperty_3006() {
		Assert.assertTrue("FlowProperty (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowProperty_3006"));
	}

    @Test
	public void testRegistryContentForFlowProperty_3012() {
		Assert.assertTrue("FlowProperty (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowProperty_3012"));
	}

    @Test
	public void testRegistryContentForFlowProperty_3018() {
		Assert.assertTrue("FlowProperty (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowProperty_3018"));
	}

    @Test
	public void testRegistryContentForFlowProperty_3041() {
		Assert.assertTrue("FlowProperty (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowProperty_3041"));
	}

    @Test
	public void testRegistryContentForInterfaceBlock_2008() {
		Assert.assertTrue("InterfaceBlock (2008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.InterfaceBlock_2008"));
	}

    @Test
	public void testRegistryContentForInterfaceBlock_3004() {
		Assert.assertTrue("InterfaceBlock (3004) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.InterfaceBlock_3004"));
	}

    @Test
	public void testRegistryContentForInterfaceBlock_3008() {
		Assert.assertTrue("InterfaceBlock (3008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.InterfaceBlock_3008"));
	}

    @Test
	public void testRegistryContentForInterfaceBlock_3010() {
		Assert.assertTrue("InterfaceBlock (3010) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.InterfaceBlock_3010"));
	}

    @Test
	public void testRegistryContentForInterfaceBlock_3014() {
		Assert.assertTrue("InterfaceBlock (3014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.InterfaceBlock_3014"));
	}

    @Test
	public void testRegistryContentForControlOperator_3003() {
		Assert.assertTrue("ControlOperator (3003) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ControlOperator_Operation_3003"));
	}

    @Test
	public void testRegistryContentForControlOperator_3007() {
		Assert.assertTrue("ControlOperator (3007) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ControlOperator_Operation_3007"));
	}

    @Test
	public void testRegistryContentForControlOperator_3013() {
		Assert.assertTrue("ControlOperator (3013) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ControlOperator_Operation_3013"));
	}

    @Test
	public void testRegistryContentForControlOperator_3019() {
		Assert.assertTrue("ControlOperator (3019) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ControlOperator_Operation_3019"));
	}

    @Test
	public void testRegistryContentForControlOperator_3042() {
		Assert.assertTrue("ControlOperator (3042) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ControlOperator_Operation_3042"));
	}

    @Test
	public void testRegistryContentForRationale_2012() {
		Assert.assertTrue("Rationale (2012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Rationale_2012"));
	}

    @Test
	public void testRegistryContentForRationale_3028() {
		Assert.assertTrue("Rationale (3028) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Rationale_3028"));
	}

    @Test
	public void testRegistryContentForView_2007() {
		Assert.assertTrue("View (2007) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Package_2007"));
	}

    @Test
	public void testRegistryContentForView_3009() {
		Assert.assertTrue("View (3009) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Package_3009"));
	}

    @Test
	public void testRegistryContentForView_PapyrusUMLClassDiagram() {
		Assert.assertTrue("View (PapyrusUMLClassDiagram) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Package_PapyrusUMLClassDiagram"));
	}

    @Test
	public void testRegistryContentForView_2008() {
		Assert.assertTrue("View (2008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Class_2008"));
	}

    @Test
	public void testRegistryContentForView_3004() {
		Assert.assertTrue("View (3004) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Class_3004"));
	}

    @Test
	public void testRegistryContentForView_3008() {
		Assert.assertTrue("View (3008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Class_3008"));
	}

    @Test
	public void testRegistryContentForView_3010() {
		Assert.assertTrue("View (3010) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Class_3010"));
	}

    @Test
	public void testRegistryContentForView_3014() {
		Assert.assertTrue("View (3014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.View_Class_3014"));
	}

    @Test
	public void testRegistryContentForConform_2014() {
		Assert.assertTrue("Conform (2014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Conform_Dependency_2014"));
	}

    @Test
	public void testRegistryContentForConform_4008() {
		Assert.assertTrue("Conform (4008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Conform_Dependency_4008"));
	}

    @Test
	public void testRegistryContentForConform_4018() {
		Assert.assertTrue("Conform (4018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Conform_Dependency_4018"));
	}

    @Test
	public void testRegistryContentForConform_Generalization() {
		Assert.assertTrue("Conform Generalization element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Conform_Generalization_4002"));
	}

    @Test
	public void testRegistryContentForProblem_2012() {
		Assert.assertTrue("Problem (2012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Problem_2012"));
	}

    @Test
	public void testRegistryContentForProblem_3028() {
		Assert.assertTrue("Problem (3028) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Problem_3028"));
	}

    @Test
	public void testRegistryContentForViewPoint_2008() {
		Assert.assertTrue("ViewPoint (2008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ViewPoint_2008"));
	}

    @Test
	public void testRegistryContentForViewPoint_3004() {
		Assert.assertTrue("ViewPoint (3004) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ViewPoint_3004"));
	}

    @Test
	public void testRegistryContentForViewPoint_3008() {
		Assert.assertTrue("ViewPoint (3008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ViewPoint_3008"));
	}

    @Test
	public void testRegistryContentForViewPoint_3010() {
		Assert.assertTrue("ViewPoint (3010) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ViewPoint_3010"));
	}

    @Test
	public void testRegistryContentForViewPoint_3014() {
		Assert.assertTrue("ViewPoint (3014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ViewPoint_3014"));
	}

    @Test
	public void testRegistryContentForExpose_2014() {
		Assert.assertTrue("Expose (2014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Expose_2014"));
	}

    @Test
	public void testRegistryContentForExpose_4008() {
		Assert.assertTrue("Expose (4008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Expose_4008"));
	}

    @Test
	public void testRegistryContentForExpose_4018() {
		Assert.assertTrue("Expose (4018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Expose_4018"));
	}

    @Test
	public void testRegistryContentForElementGroup_2012() {
		Assert.assertTrue("ElementGroup (2012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ElementGroup_2012"));
	}

    @Test
	public void testRegistryContentForElementGroup_3028() {
		Assert.assertTrue("ElementGroup (3028) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ElementGroup_3028"));
	}

    @Test
	public void testRegistryContentForConstraintBlock_2008() {
		Assert.assertTrue("ConstraintBlock (2008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConstraintBlock_2008"));
	}

    @Test
	public void testRegistryContentForConstraintBlock_3004() {
		Assert.assertTrue("ConstraintBlock (3004) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConstraintBlock_3004"));
	}

    @Test
	public void testRegistryContentForConstraintBlock_3008() {
		Assert.assertTrue("ConstraintBlock (3008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConstraintBlock_3008"));
	}

    @Test
	public void testRegistryContentForConstraintBlock_3010() {
		Assert.assertTrue("ConstraintBlock (3010) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConstraintBlock_3010"));
	}

    @Test
	public void testRegistryContentForConstraintBlock_3014() {
		Assert.assertTrue("ConstraintBlock (3014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ConstraintBlock_3014"));
	}

    @Test
	public void testRegistryContentForAllocate_Abstraction() {
		Assert.assertTrue("Allocate Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Allocate_Abstraction_4006"));
	}

    @Test
	public void testRegistryContentForDeriveReqt_Abstraction() {
		Assert.assertTrue("DeriveReqt Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.DeriveReqt_Abstraction_4006"));
	}

    @Test
	public void testRegistryContentForCopy_Abstraction() {
		Assert.assertTrue("Copy Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Copy_Abstraction_4006"));
	}

    @Test
	public void testRegistryContentForSatisfy_Abstraction() {
		Assert.assertTrue("Satisfy Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Satisfy_Abstraction_4006"));
	}

    @Test
	public void testRegistryContentForTestCase_3003() {
		Assert.assertTrue("TestCase (3003) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.TestCase_Operation_3003"));
	}

    @Test
	public void testRegistryContentForTestCase_3007() {
		Assert.assertTrue("TestCase (3007) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.TestCase_Operation_3007"));
	}

    @Test
	public void testRegistryContentForTestCase_3013() {
		Assert.assertTrue("TestCase (3013) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.TestCase_Operation_3013"));
	}

    @Test
	public void testRegistryContentForTestCase_3019() {
		Assert.assertTrue("TestCase (3019) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.TestCase_Operation_3019"));
	}

    @Test
	public void testRegistryContentForTestCase_3042() {
		Assert.assertTrue("TestCase (3042) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.TestCase_Operation_3042"));
	}

    @Test
	public void testRegistryContentForRequirement_2008() {
		Assert.assertTrue("Requirement (2008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Requirement_2008"));
	}

    @Test
	public void testRegistryContentForRequirement_3004() {
		Assert.assertTrue("Requirement (3004) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Requirement_3004"));
	}

    @Test
	public void testRegistryContentForRequirement_3008() {
		Assert.assertTrue("Requirement (3008) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Requirement_3008"));
	}

    @Test
	public void testRegistryContentForRequirement_3010() {
		Assert.assertTrue("Requirement (3010) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Requirement_3010"));
	}

    @Test
	public void testRegistryContentForRequirement_3014() {
		Assert.assertTrue("Requirement (3014) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Requirement_3014"));
	}

    @Test
	public void testRegistryContentForVerify_Abstraction() {
		Assert.assertTrue("Verify Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Verify_Abstraction_4006"));
	}

    @Test
	public void testRegistryContentForTrace_Abstraction() {
		Assert.assertTrue("Trace Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Trace_Abstraction_4006"));
	}

    @Test
	public void testRegistryContentForRefine_Abstraction() {
		Assert.assertTrue("Refine Abstraction element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Refine_Abstraction_4006"));
	}

    @Test
	public void testRegistryContentForFlowSpecification_2004() {
		Assert.assertTrue("FlowSpecification (2004) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowSpecification_2004"));
	}

    @Test
	public void testRegistryContentForFlowSpecification_3023() {
		Assert.assertTrue("FlowSpecification (3023) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowSpecification_3023"));
	}

    @Test
	public void testRegistryContentForFlowSpecification_3036() {
		Assert.assertTrue("FlowSpecification (3036) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowSpecification_3036"));
	}

    @Test
	public void testRegistryContentForFlowSpecification_3037() {
		Assert.assertTrue("FlowSpecification (3037) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowSpecification_3037"));
	}

    @Test
	public void testRegistryContentForFlowSpecification_3038() {
		Assert.assertTrue("FlowSpecification (3038) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowSpecification_3038"));
	}

    @Test
	public void testRegistryContentForAllocated() {
		Assert.assertTrue("Allocated element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Allocated_2097"));
	}

    @Test
	public void testRegistryContentForRequirementRelated() {
		Assert.assertTrue("RequirementRelated element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.RequirementRelated_2097"));
	}

    @Test
	public void testRegistryContentForFlowPort_FlowPort_Label() {
		Assert.assertTrue("FlowPort (FlowPort_Label) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowPort_Label"));
	}

    @Test
	public void testRegistryContentForFlowPort_3005() {
		Assert.assertTrue("FlowPort (3005) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowPort_3005"));
	}

    @Test
	public void testRegistryContentForFlowPort_3006() {
		Assert.assertTrue("FlowPort (3006) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowPort_3006"));
	}

    @Test
	public void testRegistryContentForFlowPort_3012() {
		Assert.assertTrue("FlowPort (3012) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowPort_3012"));
	}

    @Test
	public void testRegistryContentForFlowPort_3018() {
		Assert.assertTrue("FlowPort (3018) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowPort_3018"));
	}

    @Test
	public void testRegistryContentForFlowPort_3041() {
		Assert.assertTrue("FlowPort (3041) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.FlowPort_3041"));
	}

    @Test
	public void testRegistryContentForControlOperator_Operation_BorderItem() {
		Assert.assertTrue("ControlOperator (Operation_BorderItem) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.ControlOperator_Operation_Operation_BorderItem"));
	}

    @Test
	public void testRegistryContentForVerify_Link() {
		Assert.assertTrue("Verify_Link element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.SysML14.Verify_Abstraction_Verify_Link"));
	}

    @Test
	public void testRegistryContentForConstraint_Constraint_Label() {
		Assert.assertTrue("Constraint (Constraint_Label) element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Constraint_Label"));
	}

    @Test
	public void testRegistryContentForActor() {
		Assert.assertTrue("Actor element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Actor_2008"));
	}

    @Test
	public void testRegistryContentForUnit_2001() {
		Assert.assertTrue("Unit_2001 element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Unit_2001"));
	}

    @Test
	public void testRegistryContentForUnit_3020() {
		Assert.assertTrue("Unit_3020 element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.Unit_3020"));
	}

    @Test
	public void testRegistryContentForQuantityKind_2001() {
		Assert.assertTrue("QuantityKind_2001 element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.QuantityKind_2001"));
	}

    @Test
	public void testRegistryContentForQuantityKind_3020() {
		Assert.assertTrue("QuantityKind_3020 element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.QuantityKind_3020"));
	}

    @Test
	public void testRegistryContentForPartAssociation_4001() {
		Assert.assertTrue("PartAssociation_4001 element type not found in SysML element type set ", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysML.PartAssociation_4001"));
	}

}
