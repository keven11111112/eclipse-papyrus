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
package org.eclipse.papyrus.uml.diagram.sequence.tests.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule

/**
 * Xtend program for the generation of the Sequence Diagram tests.
 */
class SequenceDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.sequence.tests'
		gmfgenUri = resourceURI('/org.eclipse.papyrus.uml.diagram.sequence/model/sequenceDiagram.gmfgen')
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/SequenceDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.sequence.test'
                topContainerEditPart = 'InteractionEditPart'
                topNodesToTest += #[
                    'InteractionEditPart'
                ]
                childNodesToTest += #[
                    'ConsiderIgnoreFragmentEditPart',
                    'CombinedFragmentEditPart',
                    'InteractionOperandEditPart',
                    'InteractionUseEditPart',
                    'LifelineEditPart',
                    'ActionExecutionSpecificationEditPart',
                    'BehaviorExecutionSpecificationEditPart',
                    'CombinedFragment2EditPart',
                    'ConstraintEditPart',
                    'CommentEditPart',
                    'DurationConstraintInMessageEditPart',
                    'DurationObservationEditPart'
                ]
                linksToTest += #[
                    'GeneralOrderingEditPart'
                ]
                linksOwnedBySourceToTest += #[
                    
                ]
                elementTypesAppearanceTests += #[
                    'InteractionEditPart',
                    'ConsiderIgnoreFragmentEditPart',
                    'CombinedFragmentEditPart',
                    'InteractionOperandEditPart',
                    'InteractionUseEditPart',
                    'LifelineEditPart',
                    'ActionExecutionSpecificationEditPart',
                    'BehaviorExecutionSpecificationEditPart',
                    'CombinedFragment2EditPart',
                    'ConstraintEditPart',
                    'CommentEditPart',
                    'DurationConstraintInMessageEditPart',
                    'DurationObservationEditPart'
                ]
                elementTypesDropTests += #[
                    'InteractionEditPart',
                    'ConsiderIgnoreFragmentEditPart',
                    'CombinedFragmentEditPart',
                    'InteractionOperandEditPart',
                    'InteractionUseEditPart',
                    'LifelineEditPart',
                    'ActionExecutionSpecificationEditPart',
                    'BehaviorExecutionSpecificationEditPart',
                    'CombinedFragment2EditPart',
                    'ConstraintEditPart',
                    'CommentEditPart',
                    'DurationConstraintInMessageEditPart',
                    'DurationObservationEditPart'
                ]
            ]
        ]
        
        run(new WorkflowContextImpl);
	}

}
