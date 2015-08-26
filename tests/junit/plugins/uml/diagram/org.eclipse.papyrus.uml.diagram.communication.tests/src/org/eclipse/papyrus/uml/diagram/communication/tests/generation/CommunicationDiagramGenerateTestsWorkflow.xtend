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
package org.eclipse.papyrus.uml.diagram.communication.tests.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule

/**
 * Xtend program for the generation of the Communication Diagram tests.
 */
class CommunicationDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.communication.tests'
        gmfgenUri = resourceURI('/org.eclipse.papyrus.uml.diagram.communication/model/communicationdiagram.gmfgen')
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/CommunicationDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.communication.test'
                topContainerEditPart = 'InteractionEditPart';
            ]
        ]
        
        except [
	    	editPart [
	    		critical
	    		reason = 'Cannot generate tests for non-UML elements.'
	    		editPart = named('ShortCutDiagramEditPart')
	    	]
	    	
	    	permutation [
	    		reason = "Interaction frame always implicitly exists and only once."
	    		testContexts = #[ createNode, dropNode ]
	    		editParts [ topNode += named('InteractionEditPart')]
	    	]
	    	
	    	permutation [
	    		reason = 'Messages can only connect Lifelines.'
        		testContexts = #[ createLink, synchronization ]
	    		editParts [
	    			link += named('MessageEditPart')
	    			linkEnds [
		    			source += !named('LifelineEditPartCN')
		    			target += !named('LifelineEditPartCN')
	    			]
	    		]
	    	]
		]
		    	
		run(new WorkflowContextImpl);
	}

}
