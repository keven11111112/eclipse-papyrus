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
import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.TestNodeTemplate
import org.eclipse.papyrus.tests.framework.m2t.xtend.CodeGeneratorModule
import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.TestLinkTemplate
import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.SynchronizationTestTemplate

/**
 * Xtend program for the generation of the State Machine Diagram tests.
 */
class StateMachineDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.statemachine.tests'
		gmfgenUri = resourceURI('/org.eclipse.papyrus.uml.diagram.statemachine/model/stateMachineDiagram.gmfgen')
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/StateMachineDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.statemachine.test'
                topContainerEditPart = 'StateMachineEditPart';
            ]
        ]
        
        // Custom code generation templates
        codegenModuleSupplier = [new CodeGeneratorModule {
			override protected bindTestNodeTemplate() {
				bind(TestNodeTemplate).to(CustomTestNodeTemplate)
				bind(TestLinkTemplate).to(CustomTestLinkTemplate)
				bind(SynchronizationTestTemplate).to(CustomSynchronizationTestTemplate)
			}
        }]
        
        run(new WorkflowContextImpl);
	}

}
