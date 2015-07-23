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

import com.google.inject.Inject
import java.util.Collection
import java.util.Collections
import org.apache.log4j.Logger
import org.eclipse.papyrus.tests.framework.xtend.annotations.FrameworkConfig
import org.eclipse.papyrus.tests.framework.xtend.annotations.TestContextRule
import org.eclipse.papyrus.tests.framework.xtend.annotations.TestPackageRule
import org.eclipse.uml2.uml.Activity
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.UMLFactory
import org.eclipse.papyrus.tests.framework.m2m.Metamodels

/**
 * Mapping of UML instance specifications for GMFGen model elements to view synchronization tests in the UTP test model.
 */
class SynchronizationTest {
	static extension UMLFactory = UMLFactory.eINSTANCE

	@Inject(optional=true) Logger log = Logger.getLogger(SynchronizationTest)
	@Inject extension Metamodels
	@Inject extension TransformationUtilities
	@Inject extension CreateFromPaletteTest

	@FrameworkConfig String topContainerEditPart = ''
	@FrameworkConfig Collection<String> topNodesToTest = Collections.emptyList
	@FrameworkConfig Collection<String> childNodesToTest = Collections.emptyList
	@FrameworkConfig Collection<String> childLabelNodesToTest = Collections.emptyList
	@FrameworkConfig Collection<String> linksToTest = Collections.emptyList
	@FrameworkConfig Collection<String> linksOwnedBySourceToTest = Collections.emptyList

	@TestPackageRule val synchronizationPackage = [
		name = 'synchronization'

		// Top node synchronization
		testContextRules += #[
			topContainerEditPart.mapTopNode -> topNodeSynchronization,
			childLabelNodesToTest.mapChildLabelNode -> childLabelNodeSynchronization,
			topNodesToTest.mapTopNode -> childNodeSynchronization,
			linksToTest.mapLink -> linkSynchronization,
			linksOwnedBySourceToTest.mapLink -> linkOwnedBySourceSynchronization
		]
	]

	@TestContextRule val topNodeSynchronization = [
		simple('AbstractCSSSynchronizationTest', 'SynchTest')
		makeSynchSUTProperties('topnode')
		val abstractTestOperation = superclass.findOperation('testSynchronizeTopNode')

		containerEditPart = selfInstance
		topEditParts += gmfgen.getTopNodes(topNodesToTest)
		testBehaviors += mapTests(topEditParts)[toCallTestTopNodeSynchronizationActivity(abstractTestOperation)]
		testCaseRule = testScenarioRule(abstractTestOperation, 'testSynchronize')
	]

	@TestContextRule val childLabelNodeSynchronization = [
		simple('AbstractCSSSynchronizationTest', 'Label' + selfInstance.editPart + 'SynchTest')
		makeSynchSUTProperties('labelnode')
		val abstractTestOperation = superclass.findOperation('testSynchronizeLabelNode')

		childLabelEditParts += selfInstance

		val validLabels = childLabelEditParts.filter[getSlot('containers') != null]
		validLabels.forEach[label |
			label.containerCompartments.forEach[compartment |
				val allParentNodes = compartment.parentNodes
				val nestedParentNodes = allParentNodes.filter[isChildNode && containerCompartments.exists[parentNodes.exists[isTopNode]]]
				val topParentNodes = allParentNodes.filter[isTopNode]
				
				testBehaviors += mapTestsByInstance(#[label], #[compartment], topParentNodes) [
					labelEditPart, compartmentEditPart, parentNodeEditPart |
					labelEditPart.toCallTestLabelNodeSynchronizationActivity(compartmentEditPart, parentNodeEditPart, abstractTestOperation)
				]
				
				for (nested : nestedParentNodes) {
					// Compute a representative top node and compartment in which to create the nested node (in which to create the label)
					val topNodeCompartment = nested.containerCompartments.filter[parentNodes.exists[isTopNode]].head
					val topNode = topNodeCompartment.parentNodes.filter[isTopNode].head
					
					testBehaviors += mapTestsByInstance(#[label], #[compartment], #[nested]) [
						labelEditPart, compartmentEditPart, parentNodeEditPart |
						labelEditPart.toCallTestLabelNodeSynchronizationActivity(compartmentEditPart, parentNodeEditPart, topNodeCompartment, topNode, abstractTestOperation)
					]
				}
			]
		]
		testCaseRule = testScenarioRule(abstractTestOperation, 'testChildLabel')
	]

	@TestContextRule val childNodeSynchronization = [
		simple('AbstractCSSSynchronizationTest', 'ChildNodeIn' + selfInstance.editPart + 'SynchTest')
		makeSynchSUTProperties('childnode')
		val abstractTestOperation = superclass.findOperation('testSynchronizeChildNode')
		val parentEditPart = selfInstance

		containerEditPart = parentEditPart
		childEditParts += gmfgen.getChildNodes(childNodesToTest).filter[parentEditPart.canContain(it)]
		testBehaviors += mapTestsByInstance(#[containerEditPart], childEditParts) [parent, child |
			child.toCallTestChildNodeSynchronizationActivity(parent, abstractTestOperation)
		]
		testCaseRule = testScenarioRule(abstractTestOperation, 'testSynchronizeChild')
	]

	@TestContextRule val linkSynchronization = [
		common('AbstractCSSSynchronizationTest', selfInstance.editPart + 'SynchTest')
		makeSynchSUTProperties('link')
		val linkTestOperation = superclass.findOperation('testSynchronizeLink')
		val linkTestInContainerOperation = superclass.findOperation('testSynchronizeLinkInContainer')

		linkEditParts += selfInstance
		
		if (!selfInstance.canCreateTests) {
			log.warn('Cannot create test cases for ' + selfInstance.editPart +
				' because it is missing either source or target edit-parts.')
		} else {
			val ctx = it
			
			testBehaviors += mapTests(linkEditParts, topNodesToTest.filter[linksTo(ctx.selfInstance)], topNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target, linkTestOperation)
			]
			
			testBehaviors += mapTests(linkEditParts, childNodesToTest.filter[linksTo(ctx.selfInstance)], childNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target, gmfgen.getNode(topContainerEditPart), linkTestInContainerOperation)
			]

			testCaseRule = testLinkScenarioRule(linkTestOperation, 'testLink')
		}
	]

	@TestContextRule val linkOwnedBySourceSynchronization = [
		common('AbstractCSSSynchronizationTest', selfInstance.editPart + 'SynchTest')
		makeSynchSUTProperties('link')
		val linkTestOperation = superclass.findOperation('testSynchronizeLink')
		val linkTestInContainerOperation = superclass.findOperation('testSynchronizeLinkInContainer')

		linkOwnedBySourceEditParts += selfInstance
		
		if (!selfInstance.canCreateTests) {
			log.warn('Cannot create test cases for ' + selfInstance.editPart +
				' because it is missing either source or target edit-parts.')
		} else {
			val ctx = it
			
			testBehaviors += mapTests(linkOwnedBySourceEditParts, topNodesToTest.filter[linksTo(ctx.selfInstance)], topNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target, linkTestOperation)
			]
			
			testBehaviors += mapTests(linkOwnedBySourceEditParts, childNodesToTest.filter[linksTo(ctx.selfInstance)], childNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target, gmfgen.getNode(topContainerEditPart), linkTestInContainerOperation)
			]

			testCaseRule = testLinkScenarioRule(linkTestOperation, 'testLinkOwnedBySource')
		}
	]

	def (Object, Activity)=>Operation testScenarioRule(Operation abstractTestOperation, String testName) {
		[ tuple, test |
			tuple.toTestCaseOperation(testName, test)
		]
	}

	def (Object, Activity)=>Operation testLinkScenarioRule(Operation abstractTestOperation, String testName) {
		[ tuple, test |
			tuple.toTestCaseOperation(testName, test)
		]
	}

	protected def toCallTestTopNodeSynchronizationActivity(InstanceSpecification editPart, Operation abstractTestOperation) {
		createActivity => [
			name = editPart.testBehaviorName
			ownedNodes += createCallOperationAction => [
				operation = abstractTestOperation
				arguments += #[
					editPart.toValuePin('node'),
					editPart.toIntegerValuePin('expectedEditPartType')
				]
			]
		]
	}

	protected def toCallTestLabelNodeSynchronizationActivity(InstanceSpecification labelEditPart,
			InstanceSpecification compartmentEditPart, InstanceSpecification topEditPart, Operation abstractTestOperation) {
				
		createActivity => [
			name = labelEditPart.editPart.replace('EditPart', '').toFirstLower

			// Find the compartments of the topEditPart that contain the labelEditParts
			ownedNodes += createCallOperationAction =>[
				name = 'ChildLabelTestNodeActivity_' + topEditPart.editPart + '_' + labelEditPart.editPart +
					'_' + compartmentEditPart.editPart
				operation = abstractTestOperation
				arguments += #[
					topEditPart.toValuePin('topNode'),
					labelEditPart.toValuePin('childNode'),
					compartmentEditPart.toIntegerValuePin('expectedCompartmentType'),
					labelEditPart.toIntegerValuePin('expectedEditPartType')
				]
			]
		]
	}

	protected def toCallTestLabelNodeSynchronizationActivity(InstanceSpecification labelEditPart,
			InstanceSpecification compartmentEditPart, InstanceSpecification nestedEditPart,
			InstanceSpecification topNodeCompartmentEditPart, InstanceSpecification topNodeEditPart,
			Operation abstractTestOperation) {
				
		createActivity => [
			name = labelEditPart.editPart.replace('EditPart', '').toFirstLower

			// Find the compartments of the topEditPart that contain the labelEditParts
			ownedNodes += createCallOperationAction => [
				name = 'ChildLabelTestNodeActivity_' + nestedEditPart.editPart + '_' + labelEditPart.editPart +
					'_' + compartmentEditPart.editPart
				operation = abstractTestOperation
				arguments += #[
					topNodeEditPart.toValuePin('topNode'),
					nestedEditPart.toValuePin('nestedNode'),
					labelEditPart.toValuePin('childNode'),
					compartmentEditPart.toIntegerValuePin('expectedCompartmentType'),
					labelEditPart.toIntegerValuePin('expectedEditPartType')
				]
			]
		]
	}
	
	protected def toCallTestChildNodeSynchronizationActivity(InstanceSpecification childEditPart,
		InstanceSpecification parentEditPart, Operation abstractTestOperation) {
		createActivity => [
			name = childEditPart.testBehaviorName
			ownedNodes += createCallOperationAction => [
				operation = abstractTestOperation
				arguments += #[
					parentEditPart.toValuePin('parent'),
					childEditPart.toValuePin('child'),
					childEditPart.toIntegerValuePin('expectedEditPartType')
				]
			]
		]
	}

	protected def toCallTestLinkOperationActivity(InstanceSpecification linkEditPart, InstanceSpecification sourceEditPart,
			InstanceSpecification targetEditPart, Operation linkTestOperation) {
				
		createActivity => [
			name = linkEditPart.testBehaviorName

			ownedNodes += createCallOperationAction => [
				operation = linkTestOperation
				arguments += #[
					linkEditPart.toValuePin(sourceEditPart.editPart, 'source'),
					linkEditPart.toValuePin(targetEditPart.editPart, 'target'),
					linkEditPart.toValuePin('link'),
					linkEditPart.toIntegerValuePin('expectedEditPartType')
				]
			]
		]
	}

	protected def toCallTestLinkOperationActivity(InstanceSpecification linkEditPart, InstanceSpecification sourceEditPart,
			InstanceSpecification targetEditPart, InstanceSpecification containerEditPart, Operation linkTestOperation) {
		
		createActivity => [
			name = linkEditPart.testBehaviorName

			ownedNodes += createCallOperationAction => [
				operation = linkTestOperation
				arguments += #[
					linkEditPart.toValuePin(containerEditPart.editPart, 'container'),
					linkEditPart.toValuePin(sourceEditPart.editPart, 'source'),
					linkEditPart.toValuePin(targetEditPart.editPart, 'target'),
					linkEditPart.toValuePin('link'),
					linkEditPart.toIntegerValuePin('expectedEditPartType')
				]
			]
		]
	}

	private def toValuePin(InstanceSpecification editPart, String otherEditPartName, String role) {
		createValuePin => [
			val otherInstance = editPart.model.getNode(otherEditPartName)
			name = role
			value = createInstanceValue => [
				name = otherInstance.name
				instance = otherInstance
			]
		]
	}
	
	private def testKindConfigurator(String kind) {
		[org.eclipse.uml2.uml.Property sutProperty |
			sutProperty.name = 'syncTestKind'
			
			val syncTestKindEnum = 'SynchronizationTestKind'.frameworkEnum
			sutProperty.type = syncTestKindEnum
			sutProperty.defaultValue = createInstanceValue => [
				instance = syncTestKindEnum.getOwnedLiteral(kind)
			]
		]
	}
	
	protected def makeSynchSUTProperties(TransformationUtilities.TestContextBuilder tcBuilder, String testKind) {
		tcBuilder.makeSUTProperty(testKindConfigurator(testKind))
		tcBuilder.makeSUTProperty('css', stringType, createLiteralString => [value = '* { canonical: true }'])
	}
}
