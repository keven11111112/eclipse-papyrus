/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - adapted from QVTo
 *   Christian W. Damus - bug 464647
 *   
 *****************************************************************************/

package org.eclipse.papyrus.tests.framework.gmfgenuml2utp

import com.google.common.collect.ImmutableList
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton
import java.util.Collection
import java.util.Collections
import java.util.List
import java.util.Set
import org.eclipse.papyrus.tests.framework.m2m.Metamodels
import org.eclipse.papyrus.tests.framework.xtend.annotations.Cached
import org.eclipse.papyrus.tests.framework.xtend.annotations.FrameworkConfig
import org.eclipse.uml2.uml.Activity
import org.eclipse.uml2.uml.Behavior
import org.eclipse.uml2.uml.BehavioredClassifier
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Classifier
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.InstanceValue
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.OpaqueExpression
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.Package
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.Type
import org.eclipse.uml2.uml.UMLFactory
import org.eclipse.uml2.uml.ValueSpecification
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples

/**
 * Commmon helpers and utilities for the GMFGen (as UML) to UTP transformation.
 */
@Singleton
class TransformationUtilities {
    static extension UMLFactory = UMLFactory.eINSTANCE
    
    @Inject extension Metamodels
	@Inject extension TestExceptionManager
    
    @Inject Injector guice
    
    @FrameworkConfig String diagramCreationCommand
    @FrameworkConfig String testConstantsInterface
    @FrameworkConfig String diagramUpdater = 'UMLDiagramUpdater'
    
    def getDiagramName(Model gmfgen) {
        gmfgen.getInstance('GenEditorGenerator').getSlotStringValue('modelID').replace('PapyrusUML', '')
    }
    
    def getInstance(Model gmfgen, String classifierName) {
        gmfgen.getInstances[isA(classifierName)].head
    }
    
    @Cached def InstanceSpecification getInstanceNamed(Model gmfgen, String instanceName) {
        gmfgen.getInstances[name == instanceName].head
    }
    
    def getTopNode(Model gmfgen, String editPart) {
        gmfgen.getInstanceNamed('GenTopLevelNode_' + editPart)
    }
    
    def getChildNode(Model gmfgen, String editPart) {
        gmfgen.getInstanceNamed('GenChildNode_' + editPart)
    }
    
    def getNode(Model gmfgen, String editPart) {
        gmfgen.getTopNode(editPart) ?: gmfgen.getChildNode(editPart)
    }
    
    def getCompartment(Model gmfgen, String editPart) {
        gmfgen.getInstanceNamed('GenCompartment_' + editPart)
    }
    
    def getLink(Model gmfgen, String editPart) {
        gmfgen.getInstanceNamed('GenLink_' + editPart)
    }
    
    def getInstances(Model gmfgen, (InstanceSpecification)=>Boolean predicate) {
        gmfgen.packagedElements.filter(InstanceSpecification).filter(predicate)
    }
    
    def getInstances(Model gmfgen, String classifierName, Collection<String> testedEditParts) {
        gmfgen.getInstances[is | is.isA(classifierName) && testedEditParts.contains(is.editPart)]
    }
    
    def getTopNodes(Model gmfgen, Collection<String> editParts) {
        gmfgen.getInstances[is | is.isTopNode && editParts.contains(is.editPart)]
    }
    
    def isTopNode(InstanceSpecification editPart) {
    	editPart.isA('GenTopLevelNode')
    }
    
    def getChildNodes(Model gmfgen, Collection<String> editParts) {
        gmfgen.getInstances[is | is.isChildNode && editParts.contains(is.editPart)]
    }
    
    def isChildNode(InstanceSpecification editPart) {
    	editPart.isA('GenChildNode')
    }
    
    def getChildLabels(Model gmfgen, Collection<String> editParts) {
        gmfgen.getInstances[is | is.isLabelNode && editParts.contains(is.editPart)]
    }
    
    def isLabelNode(InstanceSpecification editPart) {
    	editPart.isA('GenChildLabelNode')
    }
    
    def getNodes(Model gmfgen, Collection<String> editParts) {
        gmfgen.getInstances[is | (is.isTopNode || is.isChildNode) && editParts.contains(is.editPart)]
    }
    
    def getCompartments(Model gmfgen, Collection<String> editParts) {
        gmfgen.getInstances[is | is.isCompartment && editParts.contains(is.editPart)]
    }
    
    def isCompartment(InstanceSpecification editPart) {
    	editPart.isA('GenCompartment')
    }
    
    def getContainerCompartments(InstanceSpecification node) {
        node.getSlotInstances('containers')
    }
    
    def getParentNodes(InstanceSpecification compartment) {
        compartment.getSlotInstances('node')
    }
    
    def getCompartments(InstanceSpecification node) {
    	node.getSlotInstances('compartments')
    }
    
    def getChildNodes(InstanceSpecification compartment) {
    	compartment.getSlotInstances('childNodes')
    }
    
    def canContain(InstanceSpecification node, InstanceSpecification child) {
    	node.compartments.exists[childNodes.contains(child)]
    }
    
    def getLinks(Model gmfgen, Collection<String> editParts) {
        gmfgen.getInstances[is | is.isLink && editParts.contains(is.editPart)]
    }
    
    def isLink(InstanceSpecification editPart) {
    	editPart.isA('GenLink')
    }
    
    def getSlot(InstanceSpecification instance, String slotName) {
        instance.slots.findFirst[definingFeature?.name == slotName]
    }
    
    def getSlotStringValue(InstanceSpecification instance, String slotName) {
        instance.getSlot(slotName)?.values?.head.stringValue
    }
    
    def List<String> getSlotStringValues(InstanceSpecification instance, String slotName) {
    	val slot = instance.getSlot(slotName)
    	if (slot != null) {
    		slot.values.map[stringValue]
    	} else {
    		#[]
    	}
    }
    
    def List<InstanceSpecification> getSlotInstances(InstanceSpecification instance, String slotName) {
    	val slot = instance.getSlot(slotName)
    	if (slot != null) {
    		slot.values.filter(InstanceValue).map[it.instance].filterNull.toList
    	} else {
    		#[]
    	}
    }
    
    def isKindOfEditPart(InstanceSpecification instance) {
    	!instance.classifiers.empty && instance.classifiers.head.conformsToEx('GenCommonBase'.gmfgenMetaclass)
    }
    
    def dispatch boolean conformsToEx(Classifier subtype, Classifier supertype) {
    	// No implemented interfaces to worry about
    	(subtype == supertype) || subtype.generals.exists[conformsToEx(supertype)]
    }
    
    def dispatch boolean conformsToEx(BehavioredClassifier subtype, Classifier supertype) {
    	(subtype == supertype) || subtype.generals.exists[conformsToEx(supertype)]
    		|| subtype.implementedInterfaces.exists[conformsToEx(supertype)]
    }
    
    def isA(InstanceSpecification instance, String classifierName) {
        instance.classifiers.exists[name == classifierName]
    }
    
    def computeImports(Model gmfgen, Iterable<? extends String> classNames) {
        classNames.map[name|createElementImport => [alias = name]]
    }

    def createSelfProperty(Class class_) {
        createProperty => [
            name = 'self'
            type = class_
        ]
    }
 
    def toDiagramUpdaterProperty(Model gmfgen) {
        createProperty => [
            name = 'diagramUpdater'
            defaultValue = createStringExpression => [
                symbol = diagramUpdater
            ]
        ]
    }
    
    def upTo(String string, String substring) {
        string.substring(0, string.indexOf(substring))
    }
    
    def following(String string, String substring) {
        string.substring(string.indexOf(substring) + substring.length)
    }
    
    def toNodeEditPartProperty(InstanceSpecification node, String nodeType) {
        createProperty => [
            name = node.name.following('_')
            type = node.classifiers.head.name.gmfgenMetaclass
            defaultValue = createInstanceValue => [ instance = node ]
        ]
    }
    
    def toDiagramProperty(InstanceSpecification diagram) {
        createProperty => [
            name = 'diagram' 
            type = diagram.name.upTo('_').gmfgenMetaclass;
            defaultValue = createInstanceValue => [ instance = diagram ]
        ]
    }
    
    def toEditorGeneratorProperty(InstanceSpecification editorGenerator) {
        createProperty => [
            name = 'generator' 
            type = 'GenEditorGenerator'.gmfgenMetaclass;
            defaultValue = createInstanceValue => [ instance = editorGenerator ]
        ]
    }
    
    private def getDiagramCreationCommand(InstanceSpecification editorGenerator) {
        if (diagramCreationCommand == null) {
            var commandClassName = editorGenerator.getSlotStringValue('modelID')
            
            // Strip off 'PapyrusUML' prefix, if any, and ensure that it ends with 'Diagram'
            commandClassName = commandClassName.replaceFirst('^PapyrusUML', '')
            commandClassName = commandClassName.replaceFirst('(?<!Diagram)$', 'Diagram')
            
            diagramCreationCommand = 'Create' + commandClassName + 'Command'
        }
        diagramCreationCommand
    }
    
    def toCreationCommandProperty(InstanceSpecification editorGenerator) {
        createProperty => [
            name = 'diagramCreationCommand' 
            type = stringType
            defaultValue = createLiteralString => [ value = editorGenerator.diagramCreationCommand]
        ]
    }
    
    private def getTestConstantsInterface(InstanceSpecification editorGenerator) {
        if (testConstantsInterface == null) {
            var interfaceName = editorGenerator.getSlotStringValue('modelID')
            
            // Strip off 'PapyrusUML' prefix, if any, and ensure that it ends with 'Diagram'
            interfaceName = interfaceName.replaceFirst('^PapyrusUML', '')
            interfaceName = interfaceName.replaceFirst('(?<!Diagram)$', 'Diagram')
            
            testConstantsInterface = 'I' + interfaceName + 'TestsConstants'
        }
        testConstantsInterface
    }
    
    def toTestConstantsInterfaceProperty(InstanceSpecification editorGenerator) {
        createProperty => [
            name = 'testConstantsInterface' 
            type = stringType
            defaultValue = createLiteralString => [ value = editorGenerator.testConstantsInterface]
        ]
    }
    
    def toTestConfigurationProperties(InstanceSpecification editorGenerator) {
        #[
            editorGenerator.toEditorGeneratorProperty,
            editorGenerator.toCreationCommandProperty,
            editorGenerator.toTestConstantsInterfaceProperty
        ]
    }

    def dispatch toTestCaseOperation(Void editPart, String testName, Behavior testBehavior) {
        createOperation => [
            name = testName.toFirstLower
            methods += testBehavior
        ]
    }

    def dispatch toTestCaseOperation(InstanceSpecification editPart, String testName, Behavior testBehavior) {
        editPart.toTestCaseOperationWithBlock([String coreName | testName + coreName], testBehavior)
    }

    def dispatch toTestCaseOperation(Pair<InstanceSpecification, InstanceSpecification> editParts, String testName, Behavior testBehavior) {
    	val childEditPart = editParts.value.editPart
        editParts.key.toTestCaseOperationWithBlock([String coreName | String.format("%s%s_%s", testName, coreName, childEditPart)], testBehavior)
    }

    def dispatch toTestCaseOperation(Triple<InstanceSpecification, InstanceSpecification, InstanceSpecification> editParts, String testName, Behavior testBehavior) {
    	val sourceEditPart = editParts.second.editPart
    	val targetEditPart = editParts.third.editPart
        editParts.first.toTestCaseOperationWithBlock([String coreName | String.format("%s%s_%s_%s", testName, coreName, sourceEditPart, targetEditPart)], testBehavior)
    }

    private def toTestCaseOperationWithBlock(InstanceSpecification editPart, (String)=>String testName, Behavior testBehavior) {
        val isLink = editPart.isA('GenLink')
        val operationName = testName.apply(editPart.name.following('_'))
        
        createOperation => [
            name = if (isLink) operationName.replace('EditPart', '') else operationName
            ownedParameters += createParameter => [
                name = if (isLink) 'link' else 'node'
                defaultValue = createInstanceValue => [ instance = editPart ]
            ]
            methods += testBehavior
        ]
    }

    def (Object, Activity)=>Operation testCaseRule(String name) {
        [tuple, test | tuple.toTestCaseOperation(name, test) ]
    }

    def getEditPart(InstanceSpecification instance) {
        instance.getSlotStringValue('editPartClassName')
    }
    
    def getTestBehaviorName(InstanceSpecification editPartToTest) {
        editPartToTest.editPart + 'TestCase'
    }
    
    def dispatch findOperation(Class testClass, Void operationName) {
        testClass.allOperations.head
    }
    
    def dispatch findOperation(Class testClass, String operationName) {
        testClass.allOperations.findFirst[name == operationName]
    }
    
    def toCallTestNodeOperationActivity(InstanceSpecification nodeEditPart, String abstractTestClassName, String nodeType) {
        toCallTestNodeOperationActivity(nodeEditPart, abstractTestClassName, nodeType, true)
    }
    
    def toCallTestNodeOperationActivity(InstanceSpecification nodeEditPart, String abstractTestClassName, String nodeType, boolean includeMustSucceed) {
        createActivity => [
            name = nodeEditPart.testBehaviorName
            ownedNodes += createCallOperationAction => [
                operation = frameworkClass(abstractTestClassName).allOperations.head
                arguments += createValuePin => [
                    name = 'node'
                    value = createInstanceValue => [
                        name = nodeEditPart.name
                        instance = nodeEditPart
                    ]
                ]
                
                if (includeMustSucceed) {
                	arguments += true.toValuePin('mustSucceed')
                }
            ]
        ]
    }
    
    def toValuePin(boolean value, String role) {
		createValuePin => [
			name = role
			value = createLiteralBoolean => [
				it.value = value
				type = booleanType
			]
		]
	}
    
    def toValuePin(String value, String role) {
		createValuePin => [
			name = role
			value = createLiteralString => [
				it.value = value
				type = stringType
			]
		]
	}

    def toValuePin(InstanceSpecification editPart, String role) {
        createValuePin => [
            name = role
            value = createInstanceValue => [
                name = editPart.name
                instance = editPart
                type = editPart.classifiers.get(0)
            ]
        ]
    }
    
    /**
     * Creates a value pin that casts an edit-part to its integer visual ID.
     */
    def toIntegerValuePin(InstanceSpecification editPart, String role) {
        createValuePin => [
            name = role
            value = createOpaqueExpression => [
                languages += 'Java'
                bodies += editPart.editPart + '.VISUAL_ID'
                type = integerType
            ]
        ]
    }
    
    def toContainerDerivedProperty(InstanceSpecification editPart) {
        createProperty => [
            name = 'containerEditPart'
            isDerived = true
            type = redefinedProperties.head?.type // TODO: What is supposed to be redefined?
            defaultValue = createInstanceValue => [ instance = editPart ]
        ]   
    }
    
    def createTestPackage(Model testsModel, Model gmfgen, (TestPackageBuilder)=>void script) {
        val builder = new TestPackageBuilder(createPackage, gmfgen, testsModel) => [
            guice.injectMembers(it)
            
            testsModel.packagedElements += testPackage // Get the profile context now
        ]
        script.apply(builder)
        builder.build
    }
    
    def isEligible(InstanceSpecification editPart) {
    	!editPart.isExcluded
    }
    
    //
    // Nested types: test builder DSL
    //
    
    @FinalFieldsConstructor
    static class TestPackageBuilder {
        @Inject extension Metamodels
        @Inject extension TransformationUtilities
        
        final Package testPackage
        final Model gmfgen
        final Model testsModel
        
        @Accessors(PUBLIC_GETTER)
        List<Pair<? extends Pair<GenType, ? extends Collection<String>>, (TestContextBuilder)=>void>> testContextRules = newArrayList
        
        @Accessors(PUBLIC_GETTER)
        List<Class> testContexts = newArrayList
        
        def void setName(String name) {
            testPackage.name = testsModel.name + '.' + name
        }
        
        def Class mapNone((TestContextBuilder)=>void nodeRule) {
            (null as InstanceSpecification).createTestContext(gmfgen, nodeRule)
        }
        
        def Class mapNode(String editPart, (TestContextBuilder)=>void nodeRule) {
            gmfgen.getNode(editPart).createTestContext(nodeRule)
        }
        
        def Iterable<Class> mapTopNodes(Collection<String> editParts, (TestContextBuilder)=>void topNodeRule) {
            gmfgen.getTopNodes(editParts).map[createTestContext(topNodeRule)]
        }
        
        def Iterable<Class> mapChildNodes(Collection<String> editParts, (TestContextBuilder)=>void childNodeRule) {
            gmfgen.getChildNodes(editParts).map[createTestContext(childNodeRule)]
        }
        
        def Iterable<Class> mapChildLabelNodes(Collection<String> editParts, (TestContextBuilder)=>void childLabelNodeRule) {
            gmfgen.getChildLabels(editParts).map[createTestContext(childLabelNodeRule)]
        }
        
        def Iterable<Class> mapLinks(Collection<String> editParts, (TestContextBuilder)=>void linkRule) {
            gmfgen.getLinks(editParts).map[createTestContext(linkRule)]
        }
        
        def build() {
            // First, process rules
            testContextRules.forEach[editParts2block |
                val genType = editParts2block.key.key
                val editParts = editParts2block.key.value
                val block = editParts2block.value
                
                testContexts += switch (genType) {
                    case TOP_NODE : editParts.mapTopNodes(block)
                    case CHILD_NODE : editParts.mapChildNodes(block)
                    case CHILD_LABEL_NODE : editParts.mapChildLabelNodes(block)
                    case LINK : editParts.mapLinks(block)
                    case NIL : #[mapNone(block)]
                }
            ]
            
            // Now add all of the contexts (including those generated by rules)
            testPackage.packagedElements += testContexts
            
            testContexts.forEach[
                applyTestContext
                ownedAttributes.forEach[applySUT]
                ownedOperations.forEach[applyTestCase]
            ]
            
            testPackage
        }
    }
    
    def mapTopNode(Collection<String> editParts) { GenType.TOP_NODE -> editParts }
    def mapTopNode(String editPart) { #[editPart].mapTopNode }
    def mapChildNode(Collection<String> editParts) { GenType.CHILD_NODE -> editParts }
    def mapChildNode(String editPart) { #[editPart].mapChildNode }
    def mapChildLabelNode(Collection<String> editParts) { GenType.CHILD_LABEL_NODE -> editParts }
    def mapChildLabelNode(String editPart) { #[editPart].mapChildLabelNode }
    def mapLink(Collection<String> editParts) { GenType.LINK -> editParts }
    def mapLink(String editPart) { #[editPart].mapLink }
    def mapNone() { GenType.NIL -> Collections.<String>emptyList }
    enum GenType { TOP_NODE, CHILD_NODE, CHILD_LABEL_NODE, LINK, NIL }
        
    private def createTestContext(InstanceSpecification selfInstance, (TestContextBuilder)=>void script) {
        createTestContext(selfInstance, selfInstance.model, script)
    }
    
    private def createTestContext(InstanceSpecification selfInstance, Model gmfgen, (TestContextBuilder)=>void script) {
        val builder = new TestContextBuilder(selfInstance, gmfgen, createClass) => [
            guice.injectMembers(it)
        ]
        script.apply(builder)
        builder.build
    }
    
    @FinalFieldsConstructor
    static class TestContextBuilder {
        @Inject extension Metamodels
        @Inject extension TransformationUtilities
 	    @Inject extension TestExceptionManager
        
        @Accessors final InstanceSpecification selfInstance
        @Accessors final Model gmfgen
        final Class testContext
        
        @Accessors(PUBLIC_GETTER)
        Set<String> imports = newHashSet
        
        @Accessors
        InstanceSpecification containerEditPart
        
        @Accessors(PUBLIC_GETTER)
        List<InstanceSpecification> topEditParts = newArrayList
        
        @Accessors(PUBLIC_GETTER)
        List<InstanceSpecification> childEditParts = newArrayList
        
        @Accessors(PUBLIC_GETTER)
        List<InstanceSpecification> childLabelEditParts = newArrayList
        
        @Accessors(PUBLIC_GETTER)
        List<InstanceSpecification> linkEditParts = newArrayList
        
        @Accessors(PUBLIC_GETTER)
        List<InstanceSpecification> linkOwnedBySourceEditParts = newArrayList
        
        @Accessors(PUBLIC_GETTER)
        List<Pair<?, Activity>> testBehaviors = newArrayList
        
        @Accessors(PUBLIC_SETTER)
        (Object, Activity)=>Operation testCaseRule
        
        def void common(String superclassName, String nameSuffix) {
            simple(superclassName, nameSuffix)
            makeDiagramUpdater
        }
        
        def void simple(String superclassName, String nameSuffix) {
            superclass = superclassName
            name = [it + nameSuffix]
            makeSelf
            makeSimpleProperties
        }
        
        def void setSuperclass(String abstractTestClass) {
            testContext.generals += abstractTestClass.frameworkClass
        }
        
        def getSuperclass() {
            testContext.generals.head as Class
        }
        
        def void setName((String)=>String name) {
            testContext.name = name.apply(gmfgen.diagramName)
        }
        
        def void makeSelf() {
            testContext.ownedAttributes += testContext.createSelfProperty
        }
        
        def void makeDiagram() {
            testContext.ownedAttributes += gmfgen.getInstance('GenDiagram').toDiagramProperty
        }
        
        def void makeEditor() {
            testContext.ownedAttributes += gmfgen.getInstance('GenEditorGenerator').toEditorGeneratorProperty
        }
        
        def void makeCreationCommand() {
            testContext.ownedAttributes += gmfgen.getInstance('GenEditorGenerator').toCreationCommandProperty
        }
        
        def void makeTestConstants() {
            testContext.ownedAttributes += gmfgen.getInstance('GenEditorGenerator').toTestConstantsInterfaceProperty
        }
        
        def void makeDiagramUpdater() {
            testContext.ownedAttributes += gmfgen.toDiagramUpdaterProperty
        }
        
        private def void makeSimpleProperties() {
            makeDiagram
            makeEditor
            makeCreationCommand
            makeTestConstants
        }
        
        def void makeSUTProperty(String name, Type type, ValueSpecification defaultValue) {
        	testContext.ownedAttributes += UMLFactory.eINSTANCE.createProperty => [
        		it.name = name
        		it.type = type
       			it.defaultValue = defaultValue
        	]
        }
        
        def void makeSUTProperty((Property)=>void propertyConfigurator) {
        	testContext.ownedAttributes += UMLFactory.eINSTANCE.createProperty => [
        		propertyConfigurator.apply(it)
        	]
        }
        
        def <T extends Behavior> Iterable<Pair<InstanceSpecification, T>> mapTests(Iterable<? extends InstanceSpecification> editParts,
        		(InstanceSpecification)=>T testRule) {
        			
            editParts.map[ (it -> testRule.apply(it)) ].filter[
            	processExclusions(testContext, value, key)
            ].toList // Filter exactly once because of the side-effects
        }
        
        def <T extends Behavior> Iterable<Pair<Pair<InstanceSpecification, InstanceSpecification>, T>> mapTests(
        		Iterable<? extends InstanceSpecification> editParts,
        		Iterable<String> children,
        		(InstanceSpecification, InstanceSpecification)=>T testRule) {
        			
        	val childEditParts = children.map[gmfgen.getNode(it)].filterNull
        	
        	mapTestsByInstance(editParts, childEditParts, testRule)
        }
        
        def <T extends Behavior> Iterable<Pair<Pair<InstanceSpecification, InstanceSpecification>, T>> mapTestsByInstance(
        		Iterable<? extends InstanceSpecification> editParts,
        		Iterable<InstanceSpecification> children,
        		(InstanceSpecification, InstanceSpecification)=>T testRule) {
        			
        	editParts.map[top |
        		children.map[ ((top -> it) -> testRule.apply(top, it)) ]
        	].flatten.filter[
        		processExclusions(testContext, value, key.key, key.value)
        	].toList // Filter exactly once because of the side-effects
        }
        
        def <T extends Behavior> Iterable<Pair<Triple<InstanceSpecification, InstanceSpecification, InstanceSpecification>, T>> mapTests(
        		Iterable<? extends InstanceSpecification> linkEditParts,
        		Iterable<String> sources,
        		Iterable<String> targets,
        		(InstanceSpecification, InstanceSpecification, InstanceSpecification)=>T testRule) {
        			
        	val sourceEditParts = sources.map[gmfgen.getNode(it)].filterNull
        	val targetEditParts = targets.map[gmfgen.getNode(it)].filterNull
        	
        	mapTestsByInstance(linkEditParts, sourceEditParts, targetEditParts, testRule)
        }
        
        def <T extends Behavior> Iterable<Pair<Triple<InstanceSpecification, InstanceSpecification, InstanceSpecification>, T>> mapTestsByInstance(
        		Iterable<? extends InstanceSpecification> linkEditParts,
        		Iterable<? extends InstanceSpecification> sources,
        		Iterable<? extends InstanceSpecification> targets,
        		(InstanceSpecification, InstanceSpecification, InstanceSpecification)=>T testRule) {
        			
        	linkEditParts.map[link |
        		sources.map[source |
        			targets.map[ (Tuples.create(link, source, it) -> testRule.apply(link, source, it)) ]
       			].flatten
        	].flatten.filter[
        		processExclusions(testContext, value, key.first, key.second, key.third)
        	].toList // Filter exactly once because of the side-effects
        }
        
        def build() {
            if (containerEditPart != null) {
                testContext.ownedAttributes += containerEditPart.toContainerDerivedProperty
            }
            testContext.ownedAttributes += topEditParts.map[toNodeEditPartProperty('GenTopLevelNode')]
            testContext.ownedAttributes += childEditParts.map[toNodeEditPartProperty('GenChildNode')]
            testContext.ownedAttributes += childLabelEditParts.map[toNodeEditPartProperty('GenChildLabelNode')]
            testContext.ownedAttributes += linkEditParts.map[toNodeEditPartProperty('GenLink')]
            testContext.ownedAttributes += linkOwnedBySourceEditParts.map[toNodeEditPartProperty('GenLinkOwnedBySource')]
            
            importTypesRequiredByTestBehaviors
            testContext.elementImports += gmfgen.computeImports(imports)
            
            testContext.ownedBehaviors += testBehaviors.map[value]
            if (testCaseRule != null) {
                testContext.ownedOperations += testBehaviors.map[pair |
                	testCaseRule.apply(pair.key, pair.value) => [
                		if (!pair.value.preconditions.empty) {
	                		// Transfer the pre-condition constraints to the operation
	                		it.preconditions += ImmutableList.copyOf(pair.value.preconditions)
	                	}
                	]
                ]
            }
            
            testContext
        }
        
        protected def void importTypesRequiredByTestBehaviors() {
        	testBehaviors.map[value].forEach[
        		// References to actual edit-part instances
        		allOwnedElements.filter(InstanceValue).filter[instance.isKindOfEditPart].forEach[imports += instance.editPart]
        		
        		// References to edit-part types by visual ID
        		allOwnedElements.filter(OpaqueExpression).filter[languages.contains('Java') && bodies.exists[endsWith('.VISUAL_ID')]].forEach[
        			imports += bodies.get(languages.indexOf('Java')).upTo('.VISUAL_ID')
        		]
        	]
        }
    }
}
