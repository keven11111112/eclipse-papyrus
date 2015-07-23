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
package org.eclipse.papyrus.uml.diagram.activity.tests.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule

/**
 * Xtend program that generates the Activity Diagram tests.
 */
class ActivityDiagramGenerateTestsWorkflow {

	
	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
	    testProjectName = 'org.eclipse.papyrus.uml.diagram.activity.tests'
		gmfgenUri = workflow.resourceURI('/org.eclipse.papyrus.uml.diagram.activity/model/activityDiagram.gmfgen')
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/ActivityDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.activity.test'
                topContainerEditPart = 'ActivityEditPart'
            ]
        ]
        
        except [
        	editPart [
        		kind = interactive
        		reason = 'Pops up dialog to configure invoked feature.'
        		editPart = named('CallOperationActionEditPart') || 'CallBehaviorActionEditPart'
        				|| 'SendSignalActionEditPart'
        	]
        ]
        
		run(new WorkflowContextImpl);
	}

}
