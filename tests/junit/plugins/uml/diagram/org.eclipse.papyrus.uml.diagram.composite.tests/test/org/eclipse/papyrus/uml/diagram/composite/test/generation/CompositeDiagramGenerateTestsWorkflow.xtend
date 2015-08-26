/*******************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 464647
 *     
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.test.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule

/**
 * Xtend program for the generation of the Composite Structure Diagram tests.
 */
class CompositeDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.composite.tests'
        gmfgenUri = resourceURI('/org.eclipse.papyrus.uml.diagram.composite/model/compositediagram.gmfgen')
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/CompositeDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.composite.test'
                
                // Nonconformant API names for this diagram
                diagramCreationCommand = 'CreateCompositeDiagramCommand';
                testConstantsInterface = 'ICompositeDiagramTestsConstants';
                
                topContainerEditPart = 'ClassCompositeEditPart';
                topNodesToTest += #[
                    'ClassCompositeEditPart',
                    'CollaborationCompositeEditPart',
                    'CommentEditPart',
                    'ConstraintEditPart',
                    'TimeObservationEditPart',
                    'DurationObservationEditPart',
                    'InformationItemEditPart',
                    'DurationEditPart',
                    'InteractionCompositeEditPart',
                    'OpaqueBehaviorCompositeEditPart',
                    'StateMachineCompositeEditPart',
                    'TimeConstraintEditPart',
                    'TimeEventEditPart',
                    'TimeExpressionEditPart',
                    'TimeIntervalEditPart',
                    'DurationConstraintEditPart',
                    'DurationIntervalEditPart'
                    
                    /*,
                    'ActivityEditPart',
                    'ActorEditPart',
                    'AnyReceiveEventEditPart',
                    'ArtifactEditPart',
                    'CallEventEditPart',
                    'ChangeEventEditPart',
                    'ComponentEditPart',
                    'DataTypeEditPart',
                    'DeploymentSpecificationEditPart',
                    'DeviceEditPart',
                    'EnumerationEditPart',
                    'ExecutionEnvironmentEditPart',
                    'ExpressionEditPart',
                    'FunctionBehaviorEditPart',
                    'InstanceValueEditPart',
                    'InteractionConstraintEditPart',
                    'InterfaceEditPart',
                    'IntervalEditPart',
                    'IntervalConstraintEditPart',
                    'LiteralBooleanEditPart',
                    'LiteralIntegerEditPart',
                    'LiteralNullEditPart',
                    'LiteralStringEditPart',
                    'LiteralUnlimitedNaturalEditPart',
                    'NodeEditPart',
                    'OpaqueExpressionEditPart',
                    'PrimitiveTypeEditPart',
                    'ProtocolStateMachineEditPart',
                    'SignalEditPart',
                    'SignalEventEditPart',
                    'StringExpressionEditPart',
                    'UseCaseEditPart'
                    */
                ]
                childNodesToTest += #[
                    'PropertyPartEditPartCN',
                    'CollaborationUseEditPartCN',
                    'CollaborationCompositeEditPartCN',
                    'CommentEditPartCN',
                    'ProtocolStateMachineCompositeEditPartCN',
                    'FunctionBehaviorCompositeEditPartCN',
                    'OpaqueBehaviorCompositeEditPartCN',
                    'InformationItemEditPartCN',
                    'DurationConstraintEditPartCN',
                    'TimeConstraintEditPartCN'
            
                    /*
                    'ActivityCompositeEditPartCN',
                    'InteractionCompositeEditPartCN',
                    'StateMachineCompositeEditPartCN',
                    'ComponentCompositeEditPartCN',
                    'DeviceCompositeEditPartCN',
                    'ExecutionEnvironmentCompositeEditPartCN',
                    'NodeCompositeEditPartCN',
                    'ClassCompositeEditPartCN',
                    'InterfaceEditPartCN',
                    'PrimitiveTypeEditPartCN',
                    'EnumerationEditPartCN',
                    'DataTypeEditPartCN',
                    'ActorEditPartCN',
                    'DeploymentSpecificationEditPartCN',
                    'ArtifactEditPartCN',
                    'SignalEditPartCN',
                    'UseCaseEditPartCN',
                    'IntervalConstraintEditPartCN',
                    'InteractionConstraintEditPartCN',
                    'ConstraintEditPartCN'
                    */
                ]
            ]
        ]
        
        except [
        	editPart [
        		kind = interactive
        		reason = 'Pops up a dialog to configure the element.'
        		editPart = named('CollaborationRoleEditPartCN')
        	]
        ]
        
        run(new WorkflowContextImpl);
	}

}
