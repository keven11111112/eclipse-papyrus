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
package org.eclipse.papyrus.uml.diagram.profile.tests.generation

import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl
import org.eclipse.papyrus.tests.framework.mwe.GenerateTestsWorkflow
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.CreateFromPaletteTest

/**
 * Xtend program for the generation of the Profile Diagram tests.
 */
class ProfileDiagramGenerateTestsWorkflow {

	def static void main(String[] args) {
		val workflow = new GenerateTestsWorkflow()
		runWorkflow(workflow);
	}

	def static void runWorkflow(extension GenerateTestsWorkflow workflow) {
        testProjectName = 'org.eclipse.papyrus.uml.diagram.profile.tests'
		gmfgenUri = resourceURI('/org.eclipse.papyrus.uml.diagram.profile/model/profilediagram.gmfgen')
		testSrcGenLocation = 'test-gen/'
		testModel = 'model/ProfileDiagramTest.uml'
		
        utpModuleFunction = [gmfgen, framework, utp |
            new GMFGen2UTPModule(gmfgen, framework, utp) {
            	override protected void bindTestRules() {
					// Inject our custom test transformation rules
					bind(CreateFromPaletteTest).to(CustomCreateFromPaletteTest)
				}
            } => [
                diagramTestPackageName = 'org.eclipse.papyrus.uml.diagram.profile.tests'
                topContainerEditPart = 'PackageEditPart';
            ]
        ]
        
        except [
        	editPart [
        		reason = 'Most tests aren\'t applicable.'
        		editPart = named('AssociationNodeEditPart') || 'DependencyNodeEditPart'
        				|| 'AssociationBranchEditPart' || 'DependencyBranchEditPart'
        	]
        	editPart [
        		critical
        		reason = 'Cannot generate tests for non-UML elements.'
        		editPart = named('ShortCutDiagramEditPart')
        	]
        	editPart [
        		kind = interactive
        		reason = 'Pops up dialog to select metaclasses to import.'
        		editPart = named('MetaclassEditPart') || 'MetaclassEditPartCN'
        	]
        ]
        
        run(new WorkflowContextImpl);
	}

}
