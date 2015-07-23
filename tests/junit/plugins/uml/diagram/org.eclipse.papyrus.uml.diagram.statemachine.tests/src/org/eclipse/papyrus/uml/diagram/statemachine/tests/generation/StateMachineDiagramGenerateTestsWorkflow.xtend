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
package org.eclipse.papyrus.uml.diagram.statemachine.tests.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule

/**
 * Xtend program for the generation of the State Machine Diagram tests.
 */
class StateMachineDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(GenerateTestsWorkflow workflow) {
        workflow.testProjectName = 'org.eclipse.papyrus.uml.diagram.statemachine.tests'
		workflow.gmfgenUri = workflow.resourceURI('/org.eclipse.papyrus.uml.diagram.statemachine/model/stateMachineDiagram.gmfgen')
		workflow.testSrcGenLocation = 'test-gen/'
		workflow.testModel = 'model/StateMachineDiagramTest.uml'
		
        workflow.utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.statemachine.test'
                topContainerEditPart = 'StateMachineEditPart';
                topNodesToTest += #[
                    'StateMachineEditPart'
                ]
                childNodesToTest += #[
                    'RegionEditPart',
                    'FinalStateEditPart',
                    'StateEditPart',
                    'PseudostateInitialEditPart',
                    'PseudostateJoinEditPart',
                    'PseudostateForkEditPart',
                    'PseudostateChoiceEditPart',
                    'PseudostateJunctionEditPart',
                    'PseudostateShallowHistoryEditPart',
                    'PseudostateDeepHistoryEditPart',
                    'PseudostateTerminateEditPart',
                    'CommentEditPart',
                    'ConstraintEditPart'
                ]
                linksToTest += #[
                    'TransitionEditPart'
                ]
                linksOwnedBySourceToTest += #[
                    'GeneralizationEditPart'
                ]
                elementTypesAppearanceTests += #[
                    'RegionEditPart',
                    'FinalStateEditPart',
                    'StateEditPart',
                    'PseudostateInitialEditPart',
                    'PseudostateJoinEditPart',
                    'PseudostateForkEditPart',
                    'PseudostateChoiceEditPart',
                    'PseudostateJunctionEditPart',
                    'PseudostateShallowHistoryEditPart',
                    'PseudostateDeepHistoryEditPart',
                    'PseudostateTerminateEditPart',
                    'CommentEditPart',
                    'ConstraintEditPart'
                ]
                elementTypesDropTests += #[
                    'StateMachineEditPart',
                    'RegionEditPart',
                    'FinalStateEditPart',
                    'StateEditPart',
                    'PseudostateInitialEditPart',
                    'PseudostateJoinEditPart',
                    'PseudostateForkEditPart',
                    'PseudostateChoiceEditPart',
                    'PseudostateJunctionEditPart',
                    'PseudostateShallowHistoryEditPart',
                    'PseudostateDeepHistoryEditPart',
                    'PseudostateTerminateEditPart',
                    'CommentEditPart',
                    'ConstraintEditPart'
                ]
            ]
        ]
        
        workflow.run(new WorkflowContextImpl);
	}

}
