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
package org.eclipse.papyrus.uml.diagram.clazz.tests.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.CreateFromPaletteTest

/**
 * Xtend program for generation of the Class Diagram tests.
 */
class ClassDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.clazz.tests'
		gmfgenUri = workflow.resourceURI('/org.eclipse.papyrus.uml.diagram.clazz/model/classdiagram.gmfgen')
		
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/ClassDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) {
            	override protected void bindTestRules() {
					// Inject our custom test transformation rules
					bind(CreateFromPaletteTest).to(CustomCreateFromPaletteTest)
				}
            } => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.clazz.test'
                diagramUpdater = 'CustomUMLDiagramUpdater'
                topContainerEditPart = 'PackageEditPart'
            ]
        ]
        
        except [
        	editPart [
        		reason = 'Most tests aren\'t applicable.'
        		editPart = named('AssociationNodeEditPart') || 'DependencyNodeEditPart'
        				|| 'AssociationBranchEditPart' || 'DependencyBranchEditPart'
        	]
        	editPart [
        		reason = 'Template bindings need their targets already to have template signatures.'
        		editPart = named('TemplateBindingEditPart')
        	]
        	editPart [
        		reason = 'Not a conventional UML presentation.'
        		editPart = named('DefaultNamedElementEditPart')
        	]
        	editPart [
        		critical
        		reason = 'Cannot generate tests for non-UML elements.'
        		editPart = named('ShortCutDiagramEditPart')
        	]
        	permutation [
        		kind = failing
        		reason = 'Classifiers should be supported as package import sources.'
        		testContexts = #[ createLink, synchronization ]
        		editParts [
        			link += named('PackageImportEditPart')
        			source += !(named('PackageEditPart') || 'ModelEditPartTN' || 'PackageEditPartCN' || 'ModelEditPartCN')
        			target += any
        		]
        	]
        	permutation [
        		reason = 'Assocation class links only make sense from association classes to other classifiers.'
        		testContexts = #[ createLink, synchronization ]
        		editParts [
        			// Match an association-class link either
        			//  - from something not an association-class to anything else, or
        			//  - from anything to an association-class
        			link += named('AssociationClassLinkEditPart')
	        		linkEnds [
	        			source += !named('AssociationClassEditPart')
	        			target += named('AssociationClassEditPart')
	        		]
        		]
        	]
        	editPart [
        		kind = failing
        		reason = 'Association Class editing is broken.'
        		editPart = named('AssociationClassEditPart')
        	]
        ]
        
        run(new WorkflowContextImpl);
	}

}
