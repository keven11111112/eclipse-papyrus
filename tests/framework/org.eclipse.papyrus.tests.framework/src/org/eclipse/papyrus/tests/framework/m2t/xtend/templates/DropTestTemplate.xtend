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
import org.eclipse.uml2.uml.InstanceValue
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.ValuePin

/**
 * Template for the drag-and-drop tests class for an edit-part.
 */
class DropTestTemplate extends AbstractTestTemplate {
    
    override diagramCreationMethods(Class class_) '''
        @Override
        public «imported('org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart')» getContainerEditPart() {
            return getDiagramEditPart();
        }
        
        «super.diagramCreationMethods(class_)»
    '''
	
    override getDiagramUpdaterMethod(Class class_) ''''''
    
    override purpose(Operation testCase, String componentName) '''Test to drop «componentName».'''
    
    override testCaseBody(Activity method, Class class_) '''
	    «FOR action : method.ownedNodes.filter(CallOperationAction)»
	    	«val pin = action.arguments.head as ValuePin»
	    	«val node = (pin.value as InstanceValue).instance»
	    	«action.operation.name»(«pin.toCallArgument(class_)», «node.umlPackageElementType», true);
	    «ENDFOR»
    '''
    
    override additionalMethods(Class class_) '''
        @Override
        protected «imported('org.eclipse.gmf.runtime.notation.View')» getRootView() {
            return («imported('org.eclipse.gmf.runtime.notation.View')»)getContainerEditPart().getModel();
        }
    '''
    
}
