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
package org.eclipse.papyrus.tests.framework.m2t.xtend.templates

import org.eclipse.uml2.uml.Activity
import org.eclipse.uml2.uml.CallOperationAction
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.ValuePin

/**
 * Template for the test class for creation of a top-node edit-part.
 */
class TestNodeTemplate extends AbstractTestTemplate {
    
    override purpose(Operation testCase, String componentName) '''Test to create node «componentName».'''
    
    override testCaseBody(Activity method, Class class_) '''
    «FOR action : method.ownedNodes.filter(CallOperationAction)»
    testCreateNodeFromPalette(«FOR pin : action.arguments.filter(ValuePin) SEPARATOR ', '»«pin.toCallArgument(class_)»«ENDFOR»);
    «ENDFOR»
    '''
    
    override additionalMethods(Class class_) '''«IF (class_.getAttribute('containerEditPart', null) != null)»
		@Override 
		protected «imported('org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest')» createViewRequestShapeContainer() {
		    return «imported('org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory')».getCreateShapeRequest(«imported(class_.packageRootName + '.providers.UMLElementTypes')».getElementType(«class_.getDefaultValueInstanceSpecification('containerEditPart').getStringSlotValue('editPartClassName')».VISUAL_ID), getDiagramEditPart().getDiagramPreferencesHint());
		}
	«ENDIF»'''
}
