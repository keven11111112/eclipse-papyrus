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
package org.eclipse.papyrus.uml.diagram.usecase.tests.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow

/**
 * Xtend program for the generation of the Use Case Diagram tests.
 */
class UseCaseDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.usecase.tests'
		gmfgenUri = workflow.resourceURI('/org.eclipse.papyrus.uml.diagram.usecase/models/usecaseDiagram.gmfgen')
		
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/UseCaseDiagramTest.uml'
		
		utpModuleFunction = [gmfgen, framework, utp |
		    new GMFGen2UTPModule(gmfgen, framework, utp) => [
		        diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.usecase.test'
                diagramUpdater = 'CustomUMLDiagramUpdater'
                topContainerEditPart = 'PackageEditPartTN'
		    ]
		]
		
		except [
			// Any namespace can import a package, but the diagram only allows packages to import
			permutation [
				reason = 'Not supported by the diagram design (not a useful construct).'
				testContexts = #[ createLink, synchronization ]
				editParts [
					link += named('PackageImportEditPart')
					source += named('ActorEditPartTN') || 'UseCaseEditPartTN' || 'ActorInPackageEditPart'
							|| 'UseCaseInPackageEditPart' || 'ActorInComponentEditPart' || 'UseCaseInComponentEditPart'
					target += named('PackageEditPartTN') || 'PackageEditPartCN'
				]
			]
			// Any namespace can import a package, but the diagram only allows packages to import
			permutation [
				reason = 'Not supported by the diagram design (though arguably, it should be).'
				testContexts = #[ createLink, synchronization ]
				editParts [
					link += named('PackageImportEditPart')
					source += named('SubjectClassifierEditPartTN') || 'ComponentInPackageEditPart' || 'ComponentInComponentEditPart'
					target += named('PackageEditPartTN') || 'PackageEditPartCN'
				]
			]
			// The framework isn't equipped for testing diagram shortcuts (not even generating the code for it)
			permutation [
				critical
				reason = 'Diagram shortcuts are not currently testable.'
				editParts [ node += named('ShortCutDiagramEditPart') ]
			]
			
			// Avoid popping up interactive dialogs for the selection of classifier metaclass
			editPart [
				kind = interactive
				reason = 'The subject classifier tool pops up a dialog to select the classifier metaclass.'
				editPart = named('SubjectClassifierEditPartTN') || 'UseCasePointsInComponentEditPart'
						|| 'UseCaseInComponentEditPart' || 'ActorInComponentEditPart'
						|| 'ConstraintInComponentEditPart' || 'ComponentInPackageEditPart'
			]
			
			editPart [
				kind = invalid
				reason = 'Not a normal UML presentation.'
				editPart = named('DefaultNamedElementEditPartTN')
			]
		]
		
		workflow.run(new WorkflowContextImpl);
	}

}
