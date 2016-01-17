/*
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 */

package org.eclipse.papyrus.tests.framework.m2t.xtend.templates

import static extension com.google.common.base.Strings.nullToEmpty

import org.eclipse.uml2.uml.Activity
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.InstanceValue
import org.eclipse.uml2.uml.Operation
import javax.inject.Inject
import org.eclipse.uml2.uml.ValuePin
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.ValueSpecification
import org.eclipse.uml2.uml.OpaqueExpression
import org.eclipse.uml2.uml.CallOperationAction
import org.eclipse.uml2.uml.LiteralString

/**
 * Common structure for all generated test classes.  Provides several abstract or default-blank snippets
 * that subclasses should override to plug in specific code fragments.
 */
abstract class AbstractTestTemplate {
    @Inject protected extension Queries
    @Inject protected extension TemplateQueries
    @Inject protected extension Importator
    
	def generate(Class clazz) '''
		«javaHeader»
		package «clazz.package.name»;
		
		«markImports»
        «clazz.elementImports.map[alias].forEach[imported(packageRootName(clazz)+'.edit.parts.'+it)]»
		
		/**
		 * The Class «clazz.name».
		 */
		«clazz.generatedTest»
		«clazz.runWith»
		«clazz.additionalAnnotations»
		public class «clazz.name» «clazz.extendsDeclaration» {
			
			«clazz.diagramCreationMethods»
		
			«FOR Operation testCaseOperation : clazz.testCases SEPARATOR '\n'»
				«val instanceSpec = (testCaseOperation.ownedParameters.head?.defaultValue as InstanceValue)?.instance»
				/**
				 * «testCaseOperation.purpose(instanceSpec?.componentName)»
				 */
				«testCaseOperation.testAnnotations»
				«testCaseOperation.exclusionAnnotation»
				public void «testCaseOperation.name»() {
					«safeTestCaseBody(testCaseOperation.methods.head as Activity, clazz)»
				}
			«ENDFOR»
			
			«clazz.getDiagramUpdaterMethod»
			
			«clazz.additionalMethods»
		}	
	'''

    def extendsDeclaration(Class class_) '''extends «imported(class_.generals.head.qualifiedJavaName)»'''
    
    def diagramCreationMethods(Class class_) '''
        @Override
        protected «imported('org.eclipse.papyrus.commands.ICreationCommand')» getDiagramCommandCreation() {
            return new «class_.diagramCreationCommand»();
        }
         
        @Override
        protected String getProjectName() {
            return «class_.constantsInterface».PROJECT_NAME;
        }
         
        @Override
        protected String getFileName() {
            return «class_.constantsInterface».FILE_NAME;
        }
    '''
    
    def getDiagramUpdaterMethod(Class class_) '''
        @Override
        public «imported('org.eclipse.papyrus.infra.gmfdiag.common.updater.DiagramUpdater')» getDiagramUpdater() {
            return «class_.diagramUpdater».«class_.diagramUpdaterInstanceField»;
        }
    '''
    
    def additionalMethods(Class class_) ''''''

    def runWith(Class testContext) ''''''
   	
    def generatedTest(Class testContext) '''@«imported('org.eclipse.papyrus.junit.framework.classification.GeneratedTest')»'''
    
   	protected def additionalAnnotations(Class testContext) ''''''

    abstract def CharSequence purpose(Operation testCase, String componentName)
    
    def junitTest(Operation testCase) '''@«imported('org.junit.Test')»'''
    def generatedTest(Operation testCase) ''''''
    def testAnnotations(Operation testCase) '''
        «testCase.junitTest»
        «testCase.generatedTest»
    '''
    
    def exclusionAnnotation(Operation testCase) '''
    «val pre = testCase.exclusionPrecondition»
    «IF pre != null»
    	@«pre.name.imported»("«pre.specification.stringValue»")
    «ENDIF»
    '''
    
    protected def getExclusionPrecondition(Operation testCase) {
    	testCase.preconditions.findFirst[
    		(name != null) && (specification instanceof LiteralString) 
    	]
    }
    
    private def safeTestCaseBody(Activity method, Class class_) {
        try {
            testCaseBody(method, class_);
        } catch (Exception e) {
             imported('org.junit.Assert') + '.fail("Test case specification problem: ' + (e.message ?: e.class.simpleName) +'");'
        }
    }
    
    def testCaseBody(Activity method, Class class_) '''
	    «FOR action : method.ownedNodes.filter(CallOperationAction)»
	    	«action.operation.name»(«FOR pin : action.arguments.filter(ValuePin) SEPARATOR ', '»«pin.toCallArgument(class_)»«ENDFOR»);
	    «ENDFOR»
    '''
    
    protected def dispatch CharSequence toCallArgument(ValuePin pin, Class testContext)
    '''«pin.value.toCallArgument(testContext)»'''
    
    protected def dispatch toCallArgument(ValueSpecification value, Class testContext)
    '''«value.stringValue»'''
    
    protected def dispatch toCallArgument(LiteralString value, Class testContext)
    '''"«value.stringValue.nullToEmpty.replace('"', '\\"')»"'''
    
    protected def dispatch toCallArgument(InstanceValue value, Class testContext) {
        var node = value.instance as InstanceSpecification
        val umlElementTypes = imported(packageRootName(testContext) + '.providers.UMLElementTypes')
    	'''«umlElementTypes».getElementType(«node.getStringSlotValue('editPartClassName')».VISUAL_ID)'''
   	}
    
    protected def dispatch toCallArgument(OpaqueExpression value, Class testContext) {
        val index = value.languages.indexOf('Java')
        '''«value.bodies.get(index)»'''
   	}
}
