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
import org.eclipse.papyrus.tests.framework.m2m.Metamodels
import org.eclipse.papyrus.tests.framework.xtend.annotations.FrameworkConfig
import org.eclipse.papyrus.tests.framework.xtend.annotations.TestPackageRule
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.UMLFactory
import org.eclipse.papyrus.tests.framework.xtend.annotations.TestContextRule
import org.apache.log4j.Logger

/**
 * Mapping of UML instance specifications for GMFGen model elements to palette tests in the UTP test model.
 */
class CreateFromPaletteTest {
	static extension UMLFactory = UMLFactory.eINSTANCE

	@Inject(optional=true) Logger log = Logger.getLogger(CreateFromPaletteTest)
	@Inject extension Metamodels
	@Inject extension TransformationUtilities
	@Inject extension CreateFromPaletteChildLabelNodesTest

	@FrameworkConfig String topContainerEditPart = ''
	@FrameworkConfig Collection<String> topNodesToTest = Collections.emptyList
	@FrameworkConfig Collection<String> childNodesToTest = Collections.emptyList
	@FrameworkConfig Collection<String> childLabelNodesToTest = Collections.emptyList
	@FrameworkConfig Collection<String> linksToTest = Collections.emptyList
	@FrameworkConfig Collection<String> linksOwnedBySourceToTest = Collections.emptyList

	@TestPackageRule val createFromPalettePackage = [
		name = 'createFromPalette'

		testContextRules += #[
			mapNone -> topNodeCreation,
			childLabelNodesToTest.mapChildLabelNode -> childLabelNodeCreation,
			topNodesToTest.mapTopNode -> childNodeCreation,
			linksToTest.mapLink -> linkCreation,
			linksOwnedBySourceToTest.mapLink -> linkOwnedBySourceCreation
		]
	]

	@TestContextRule val topNodeCreation = [
		common('AbstractCreateNodeFromPaletteTest', 'TopNodesTest')
		topEditParts += gmfgen.getTopNodes(topNodesToTest)
		testBehaviors += mapTests(topEditParts) [
			toCallTestNodeOperationActivity('AbstractCreateNodeFromPaletteTest', 'TestTopNode')
		]
		testCaseRule = testCaseRule('testTopNode')
	]

	@TestContextRule val childLabelNodeCreation = [
		common('AbstractCreateChildLabelNodeFromPaletteTest', 'Label' + selfInstance.editPart + 'Test')
		childLabelEditParts += selfInstance
		
		val validLabels = childLabelEditParts.filter[getSlot('containers') != null]
		validLabels.forEach[label |
			label.containerCompartments.forEach[compartment |
				val allParentNodes = compartment.parentNodes
				val nestedParentNodes = allParentNodes.filter[isChildNode && containerCompartments.exists[parentNodes.exists[isTopNode]]]
				val topParentNodes = allParentNodes.filter[isTopNode]
				
				testBehaviors += mapTestsByInstance(#[label], #[compartment], topParentNodes) [
					labelEditPart, compartmentEditPart, parentNodeEditPart |
					labelEditPart.toCallTestChildLabelNodeOperationActivity(compartmentEditPart, parentNodeEditPart)
				]
				
				for (nested : nestedParentNodes) {
					// Compute a representative top node and compartment in which to create the nested node (in which to create the label)
					val topNodeCompartment = nested.containerCompartments.filter[parentNodes.exists[isTopNode]].head
					val topNode = topNodeCompartment.parentNodes.filter[isTopNode].head
					
					testBehaviors += mapTestsByInstance(#[label], #[compartment], #[nested]) [
						labelEditPart, compartmentEditPart, parentNodeEditPart |
						labelEditPart.toCallTestChildLabelNodeOperationActivity(compartmentEditPart, parentNodeEditPart, topNodeCompartment, topNode)
					]
				}
			]
		]
		testCaseRule = testCaseRule('testChildLabel')
	]

	@TestContextRule val childNodeCreation = [
		common('AbstractCreateNodeFromPaletteTest', 'ChildNodeIn' + selfInstance.editPart + 'Test')
		containerEditPart = selfInstance
		
		selfInstance.compartments.forEach[compartment |
			val contents = compartment.childNodes.filter[childNodesToTest.contains(editPart)]
			childEditParts += contents
			testBehaviors += mapTestsByInstance(#[containerEditPart], contents) [parent, child |
				child.toCallTestChildNodeOperationActivity(parent, 'AbstractCreateNodeFromPaletteTest', 'TestChildNode')
			]
		]
		testCaseRule = testCaseRule('testChildNode')
	]

	@TestContextRule val linkCreation = [
		common('AbstractCreateLinkFromPaletteTest', selfInstance.editPart + 'Test')
		linkEditParts += selfInstance
		
		if (!selfInstance.canCreateTests) {
			log.warn('Cannot create test cases for ' + selfInstance.editPart + ' because it is missing either source or target edit-parts.')
		} else {
			val ctx = it
			
			testBehaviors += mapTests(linkEditParts, topNodesToTest.filter[linksTo(ctx.selfInstance)], topNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target)
			]
			
			testBehaviors += mapTests(linkEditParts, childNodesToTest.filter[linksTo(ctx.selfInstance)], childNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target, gmfgen.getNode(topContainerEditPart))
			]
			
			testCaseRule = testCaseRule('testLink')
		}
	]

	@TestContextRule val linkOwnedBySourceCreation = [
		common('AbstractCreateLinkOwnedBySourceFromPaletteTest', selfInstance.editPart + 'Test')
		linkOwnedBySourceEditParts += selfInstance
		
		if (!selfInstance.canCreateTests) {
			log.warn('Cannot create test cases for ' + selfInstance.editPart + ' because it is missing either source or target edit-parts.')
		} else {
			val ctx = it
			
			testBehaviors += mapTests(linkOwnedBySourceEditParts, topNodesToTest.filter[linksTo(ctx.selfInstance)], topNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target)
			]
			
			testBehaviors += mapTests(linkOwnedBySourceEditParts, childNodesToTest.filter[linksTo(ctx.selfInstance)], childNodesToTest.filter[linksFrom(ctx.selfInstance)])[
				link, source, target | link.toCallTestLinkOperationActivity(source, target, gmfgen.getNode(topContainerEditPart))
			]
			
			testCaseRule = testCaseRule('testLinkOwnedBySource')
		}
	]
    
    protected def toCallTestChildNodeOperationActivity(InstanceSpecification childEditPart, InstanceSpecification parentEditPart, String abstractTestClassName, String nodeType) {
        createActivity => [
            name = childEditPart.testBehaviorName
            ownedNodes += createCallOperationAction => [
                operation = frameworkClass(abstractTestClassName).allOperations.head
                arguments += #[
                	childEditPart.toValuePin('node'),
                	parentEditPart.toValuePin('container'),
                	true.toValuePin('mustSucceed')
                ]
            ]
        ]
    }

	protected def toCallTestLinkOperationActivity(InstanceSpecification linkEditPart, InstanceSpecification sourceEditPart, InstanceSpecification targetEditPart) {
		createActivity => [
			name = String.format('%s_%s_%s',
				linkEditPart.editPart.replace('EditPart', '').toFirstLower,
				sourceEditPart.editPart.replace('EditPart', '').toFirstLower,
				targetEditPart.editPart.replace('EditPart', '').toFirstLower)

			ownedNodes += createCallOperationAction => [
					operation = frameworkClass('AbstractCreateLinkFromPaletteTest').allOperations.head
					arguments += #[
						linkEditPart.toValuePin(sourceEditPart.editPart, 'source'),
						linkEditPart.toValuePin(targetEditPart.editPart, 'target'),
						linkEditPart.toValuePin('link'),
						true.toValuePin('mustSucceed')
					]
				]
		]
	}

	protected def toCallTestLinkOperationActivity(InstanceSpecification linkEditPart, InstanceSpecification sourceEditPart, InstanceSpecification targetEditPart, InstanceSpecification containerEditPart) {
		createActivity => [
			name = String.format('%s_%s_%s',
				linkEditPart.editPart.replace('EditPart', '').toFirstLower,
				sourceEditPart.editPart.replace('EditPart', '').toFirstLower,
				targetEditPart.editPart.replace('EditPart', '').toFirstLower)

			ownedNodes += createCallOperationAction => [
					operation = frameworkClass('AbstractCreateLinkFromPaletteTest').allOperations.head
					arguments += #[
						linkEditPart.toValuePin(sourceEditPart.editPart, 'source'),
						linkEditPart.toValuePin(targetEditPart.editPart, 'target'),
						linkEditPart.toValuePin('link'),
						linkEditPart.toValuePin(containerEditPart.editPart, 'container'),
						true.toValuePin('mustSucceed')
					]
				]
		]
	}

	/**
	 * Queries whether a node edit-part may be the source of a link edit-part, according to the GMFGen model. 
	 */
	public def linksTo(String sourceNodeEditPart, InstanceSpecification linkEditPart) {
		linkEditPart.getSlotStringValues('sources').contains(sourceNodeEditPart)
	}

	/**
	 * Queries whether a node edit-part may be the target of a link edit-part, according to the GMFGen model. 
	 */
	public def linksFrom(String targetNodeEditPart, InstanceSpecification linkEditPart) {
		linkEditPart.getSlotStringValues('targets').contains(targetNodeEditPart)
	}

	protected def linksToOrFrom(String nodeEditPart, InstanceSpecification linkEditPart) {
		nodeEditPart.linksTo(linkEditPart) || nodeEditPart.linksFrom(linkEditPart)
	}

	/**
	 * Queries whether we can create any tests for the specified link edit-part.  This is generally only
	 * {@code false} when the link edit part either has no viable source edit-parts or no viable target
	 * edit-parts.
	 */
	public def canCreateTests(InstanceSpecification linkEditPart) {
		!linkEditPart.nodesRequiredForTest.empty 
	}

	protected def nodesRequiredForTest(InstanceSpecification linkEditPart) {
		val sources = linkEditPart.getSlotStringValues('sources')
		val targets = linkEditPart.getSlotStringValues('targets')
		
		val sourceTopNodes = sources.toSet => [retainAll(topNodesToTest)]
		val sourceChildNodes = sources.toSet => [retainAll(childNodesToTest)]
		val targetTopNodes = targets.toSet => [retainAll(topNodesToTest)]
		val targetChildNodes = targets.toSet => [retainAll(childNodesToTest)]
		
		newLinkedHashSet => [
			// Handle top nodes together and child nodes together
			if (!(sourceTopNodes.empty || targetTopNodes.empty)) {
				it.addAll(sourceTopNodes)
				it.addAll(targetTopNodes)
			}
			if (!(sourceChildNodes.empty || targetChildNodes.empty)) {
				it.addAll(sourceChildNodes)
				it.addAll(targetChildNodes)
				it.add(topContainerEditPart)
			}
		]
	}

	private def toValuePin(InstanceSpecification linkEditPart, String editPartName, String role) {
		createValuePin => [
			val otherInstance = linkEditPart.model.getNode(editPartName)
			name = role
			value = createInstanceValue => [
				name = otherInstance.name
				instance = otherInstance
			]
		]
	}
}
