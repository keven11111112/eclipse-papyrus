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
package org.eclipse.papyrus.uml.diagram.component.test.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule

/**
 * Xtend program for the generation of the Component Diagram tests.
 */
class ComponentDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.component.tests'
		gmfgenUri = resourceURI('/org.eclipse.papyrus.uml.diagram.component/model/ComponentDiagram.gmfgen')
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/ComponentDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.component.test'
                topContainerEditPart = 'PackageEditPart';
            ]
        ]
        
        except [
        	editPart [
        		reason = 'Most tests aren\'t applicable.'
        		editPart = named('DependencyNodeEditPart') || 'DependencyBranchEditPart'
        	]
        	editPart [
        		reason = 'Not a conventional UML presentation.'
        		editPart = named('DefaultNamedElementEditPart')
        	]
        	permutation [
        		critical
        		reason = 'GMFGen has non-behaviored-classifiers as sources.'
        		testContexts = #[ createLink, synchronization ]
        		editParts [
        			link += named('InterfaceRealizationEditPart')
        			source += !(named('ComponentEditPart') || 'ComponentEditPartCN' || 'ComponentEditPartPCN')
        			target += any
        		]
        	]
        	permutation [
        		critical
        		reason = 'GMFGen has noncomponents as sources and non-classifiers as targets.'
        		testContexts = #[ createLink, synchronization ]
        		editParts [
        			link += named('ComponentRealizationEditPart')
        			linkEnds [
	        			source += !(named('ComponentEditPart') || 'ComponentEditPartCN' || 'ComponentEditPartPCN')
	        			target += !(named('InterfaceEditPart') || 'RectangleInterfaceEditPart' || 'ComponentEditPart'
	        				|| 'InterfaceEditPartPCN' || 'RectangleInterfaceEditPartCN' || 'ComponentEditPartCN' || 'ComponentEditPartPCN')
        			]
        		]
        	]
		]
        
		run(new WorkflowContextImpl);
	}

}
