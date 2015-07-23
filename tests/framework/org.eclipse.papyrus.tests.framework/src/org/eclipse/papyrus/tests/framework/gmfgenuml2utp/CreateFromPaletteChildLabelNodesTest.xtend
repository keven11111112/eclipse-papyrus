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
import org.eclipse.papyrus.tests.framework.m2m.Metamodels
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.UMLFactory

/**
 * Mapping of UML instance specifications for GMFGen model elements to child label palette tests in the UTP test model.
 */
class CreateFromPaletteChildLabelNodesTest {
    static extension UMLFactory = UMLFactory.eINSTANCE
    
    @Inject extension Metamodels
    @Inject extension TransformationUtilities
    
    protected def getContainerCompartmentNames(InstanceSpecification node) {
        node.containerCompartments.map[editPart]
    }
    
    protected def getParentNodeNames(InstanceSpecification node) {
        node.parentNodes.map[editPart]
    }
    
    protected def toCallTestChildLabelNodeOperationActivity(InstanceSpecification labelEditPart,
    		InstanceSpecification compartmentEditPart, InstanceSpecification parentNodeEditPart) {
    	
        createActivity => [
            name = labelEditPart.editPart.replace('EditPart', '').toFirstLower
            
            ownedNodes += createCallOperationAction => [
                name = 'ChildLabelTestNodeActivity_' + parentNodeEditPart.name + '_' + labelEditPart.name + '_' + compartmentEditPart.name
                operation = frameworkClass('AbstractCreateChildLabelNodeFromPaletteTest').allOperations.head
                arguments += #[
                    parentNodeEditPart.toValuePin('parentNode'),
                    labelEditPart.toValuePin('childNode'),
                    compartmentEditPart.toIntegerValuePin('compartment'),
                    true.toValuePin('mustPass')
                ]
            ]
        ]
    }
    
    protected def toCallTestChildLabelNodeOperationActivity(InstanceSpecification labelEditPart,
    		InstanceSpecification compartmentEditPart, InstanceSpecification nestedNodeEditPart,
    		InstanceSpecification topNodeCompartmentEditPart, InstanceSpecification topNodeEditPart) {
    	
        createActivity => [
            name = labelEditPart.editPart.replace('EditPart', '').toFirstLower
            
            ownedNodes += createCallOperationAction => [
                name = 'ChildLabelTestNodeActivity_' + nestedNodeEditPart.name + '_' + labelEditPart.name + '_' + compartmentEditPart.name
                operation = frameworkClass('AbstractCreateChildLabelNodeFromPaletteTest').allOperations.head
                arguments += #[
                    topNodeEditPart.toValuePin('topNode'),
                    topNodeCompartmentEditPart.toIntegerValuePin('topNodeCompartment'),
                    nestedNodeEditPart.toValuePin('parentNode'),
                    labelEditPart.toValuePin('childNode'),
                    compartmentEditPart.toIntegerValuePin('compartment'),
                    true.toValuePin('mustPass')
                ]
            ]
        ]
    }
}
