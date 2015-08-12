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
package org.eclipse.papyrus.tests.framework.mwe

import java.util.Collection
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.emf.mwe.utils.DirectoryCleaner
import org.eclipse.emf.mwe.utils.Mapping
import org.eclipse.emf.mwe.utils.Reader
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.papyrus.mwe2.utils.XtendWorkflow
import org.eclipse.papyrus.mwe2.utils.components.MultiReader
import org.eclipse.papyrus.mwe2.utils.components.RegisterUmlProfile
import org.eclipse.papyrus.mwe2.utils.components.UMLWriter
import org.eclipse.papyrus.tests.framework.gmfgen2uml.GMFGen2UMLComponent
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPComponent
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPModule
import org.eclipse.papyrus.tests.framework.m2t.xtend.CodeGeneratorComponent
import org.eclipse.papyrus.tests.framework.m2t.xtend.CodeGeneratorModule
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A workflow orchestrating a transformation pipeline for generation of JUnit tests for the edit-parts of a diagram.
 * <p>
 * Inputs:  a GMFGen model and references to the UML representation of the GMFGen metamodel, the test framework's base
 * model describing the abstract test class library, and the UML Testing (UTP) Profile.  Also a Guice model that
 * injects various transformation options such as which edit-parts are to have tests generated.
 * </p>
 * Steps:
 * <ol>
 * <li>Generate a UML representation of the diagram's GMFGen model, as a UML model collecting instance-specifications
 *     of the classes in the UML representation of the GMFGen metamodel</li>
 * <li>Transform the UML representation of the GMFGen model to a UML-UTP model describing the test cases</li>
 * <li>Transform the UML-UTP model of the test cases to JUnit test sources</li>
 * </ol>
 */
class GenerateTestsWorkflow extends XtendWorkflow {

	@Accessors String testProjectName
	@Accessors String gmfgenUri
	@Accessors String testSrcGenLocation
	@Accessors String testModel
	@Accessors List<String> testExceptions = newArrayList()
	@Accessors String gitRoot = "../../../../../../"

	(Model, Model, Profile)=>GMFGen2UTPModule utpModuleFunction

	@Accessors ()=>CodeGeneratorModule codegenModuleSupplier = [new CodeGeneratorModule]
	
	final TestExceptionsBuilder testExceptionsBuilder = new TestExceptionsBuilder
	
	def setUtpModuleFunction((Model, Model, Profile)=>GMFGen2UTPModule utpModuleFunction) {
		this.utpModuleFunction = utpModuleFunction
	}

	def (Model, Model, Profile)=>GMFGen2UTPModule getUtpModuleFunction() {
		utpModuleFunction
	}

	public override run(IWorkflowContext context) {
		beans += new StandaloneSetup => [
			platformUri = gitRoot

			// Ensure that we can resolve references to the UML metamodel
			addUriMap(new Mapping => [
				from = 'pathmap://UML_METAMODELS/'
				// Most likely to be in the right plug-in
				to = classpathURI('metamodels/UML.metamodel.properties').trimSegments(1).appendSegment('').toString()
			])

			// Ensure that we can resolve references to the Ecore profile
			addUriMap(new Mapping => [
				from = 'pathmap://UML_PROFILES/'
				// Most likely to be in the right plug-in
				to = classpathURI('profiles/Ecore.profile.properties').trimSegments(1).appendSegment('').toString()
			])

			// Ensure that we can resolve references to the UML genmodel and ecore
			addUriMap(new Mapping => [
				from = 'platform:/plugin/org.eclipse.uml2.uml/model/'
				// Most likely to be in the right plug-in
				to = classpathURI('model/CMOF_2_UML.ecore2xml').trimSegments(1).appendSegment('').toString()
			])

			// Ensure that we can resolve references to the GMFGen genmodel and ecore
			addUriMap(new Mapping => [
				from = 'platform:/plugin/org.eclipse.gmf.codegen/models/'
				to = classpathURI('models/gmfgen.ecore').trimSegments(1).appendSegment('').toString()
			])

			// Ensure that we can resolve references to the Notation genmodel and ecore
			addUriMap(new Mapping => [
				from = 'platform:/plugin/org.eclipse.gmf.runtime.notation/model/'
				to = classpathURI('model/notation.genmodel').trimSegments(1).appendSegment('').toString()
			])
			
			scanClassPath = true

			// Ensure UML's registrations for standard profiles and libraries, legacy metamodel migrations, etc.
			UMLResourcesUtil.init(null)

			addRegisterGeneratedEPackage('org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage')
			addRegisterGeneratedEPackage('org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage')
			addRegisterGeneratedEPackage('org.eclipse.upr.utp.UTPPackage')
			addRegisterGeneratedEPackage('org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage')
		]

		// 1. Transform GMFGen file to UML
		context.transformGmfgenToUmlPhase

		// 2. Generate Test specification (UML-UTP) model
		context.generateTestModelPhase

		// 3. Generate Test code
		context.generateTestCodePhase
		
		super.run(context)
	}

	def resourceURI(String path) {
		('platform:/resource/' + path).replace('//', '/')
	}

	def classpathURI(String path) {
		URI.createURI(getClass().classLoader.getResource(path).toExternalForm(), true)
	}

	def projectFile(String path) {
		EcorePlugin.resolvePlatformResourcePath(("/" + testProjectName + '/' + path).replace('//', '/')).toFileString
	}

	def projectResourceURI(String path) {
		resourceURI((testProjectName + '/' + path).replace('//', '/'))
	}

	def frameworkFile(String path) {
		EcorePlugin.resolvePlatformResourcePath(('/org.eclipse.papyrus.tests.framework/' + path).replace('//', '/')).
			toFileString
	}

	def frameworkResourceURI(String path) {
		resourceURI(('org.eclipse.papyrus.tests.framework/' + path).replace('//', '/'))
	}

	protected def transformGmfgenToUmlPhase(IWorkflowContext context) {
		components += new Reader => [
			uri = gmfgenUri
			modelSlot = 'inputGmfgen'
			firstElementOnly = true
			useSingleGlobalResourceSet = true
		]

		components += new Reader => [
			uri = 'pathmap://UML_PROFILES/Ecore.profile.uml'
			modelSlot = 'ecoreprofile'
			useSingleGlobalResourceSet = true
		]

		components += new RegisterUmlProfile => [
			profileSlot = 'ecoreprofile'
		]

		components += new Reader => [
			uri = resourceURI('/org.eclipse.papyrus.tests.framework/model/gmfgen.uml')
			modelSlot = 'gmfgenUmlMetamodel'
			useSingleGlobalResourceSet = true
		]

		components += new GMFGen2UMLComponent => [
			modelSlot = 'inputGmfgen'
			metamodelSlot = 'gmfgenUmlMetamodel'
			outputSlot = 'inputGmfgenUml'
		]

		components += new UMLWriter => [
			modelSlot = 'inputGmfgenUml'
			uri = gmfgenUri + '.uml'
			useSingleGlobalResourceSet = true
			addXmiIdentifierFilters('^org\\.eclipse\\.papyrus\\.uml\\.diagram\\.' -> '')
		]
	}

	protected def generateTestModelPhase(IWorkflowContext context) {
		components += new Reader => [
			uri = gmfgenUri + '.uml'
			modelSlot = 'inputModels'
			useSingleGlobalResourceSet = true
		]
		components += new Reader => [
			uri = resourceURI('/org.eclipse.papyrus.tests.framework/model/testingFrameworkBase.uml')
			modelSlot = 'frameworkBase'
			useSingleGlobalResourceSet = true
		]

		components += new Reader => [
			uri = resourceURI('/org.eclipse.upr.utp/model/utp.profile.uml')
			modelSlot = 'utp'
			useSingleGlobalResourceSet = true
		]
		components += new RegisterUmlProfile => [
			profileSlot = 'utp'
			generatedPackageInterfaceName = 'org.eclipse.upr.utp.UTPPackage'
		]
		
		testExceptions.forEach[next |
			var modelURI = URI.createURI(next, true)
			if (modelURI.relative) {
				modelURI = URI.createURI(resourceURI('/' + testProjectName + '/' + next), true)
			}
			val excURI = modelURI.toString
			
			components += new MultiReader => [
				uri = excURI
				modelSlot = 'inputModels'
				useSingleGlobalResourceSet = true
			]
		]

		// And build ad hoc test exceptions
		components += new AbstractWorkflowComponent2 {
			override def invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
				val frameworkBase = context.get('frameworkBase') as Model
				val gmfgen = context.get('inputGmfgen') as GenEditorGenerator
				
				val adHocExceptions = testExceptionsBuilder.build(frameworkBase, gmfgen)
				
				// If we have ad hoc test exceptions, add them to the input models
				val inputModels = context.get('inputModels')
				if ((adHocExceptions != null) && !adHocExceptions.constraints.empty) {
					val newInputModels = switch inputModels {
						Collection<Object> : inputModels
						default : newArrayList(inputModels)
					}
					newInputModels += adHocExceptions
					context.set('inputModels', newInputModels)
				}
			}
		}

		components += new GMFGen2UTPComponent => [
			modelSlot = 'inputModels'
			metamodelSlot = 'gmfgenUmlMetamodel'
			frameworkBaseSlot = 'frameworkBase'
			utpSlot = 'utp'
			utpModule = utpModuleFunction
			outputSlot = 'papyrusTestModel'
		]

		components += new UMLWriter => [
			modelSlot = 'papyrusTestModel'
			uri = projectResourceURI(testModel)
			useSameResource = true
//			addXmiIdentifierFilters('^org\\.eclipse\\.papyrus\\.uml\\.diagram\\.' -> '')
		]
	}

	protected def generateTestCodePhase(IWorkflowContext context) {
		components += new Reader => [
			uri = projectResourceURI(testModel).toString
			modelSlot = 'papyrusTestModel'
		]

		components += new DirectoryCleaner => [
			directory = projectFile(testSrcGenLocation)
		]
		components += new CodeGeneratorComponent(codegenModuleSupplier) => [
			tempSrcPath = projectFile(testSrcGenLocation)
			modelSlot = 'papyrusTestModel'
		]
	}
    
    //
    // Test Exceptions DSL
    //
    
    def except((TestExceptionsBuilder)=>void buildScript) {
    	buildScript.apply(testExceptionsBuilder)
    }

}
