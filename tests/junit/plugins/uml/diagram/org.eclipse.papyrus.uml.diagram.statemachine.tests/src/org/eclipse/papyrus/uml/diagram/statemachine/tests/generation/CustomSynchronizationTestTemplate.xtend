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
package org.eclipse.papyrus.uml.diagram.statemachine.tests.generation

import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.SynchronizationTestTemplate
import org.eclipse.uml2.uml.Class

/**
 * Template for the test class for model-view synchronization tests.
 */
class CustomSynchronizationTestTemplate extends SynchronizationTestTemplate {
	override additionalMethods(Class class_) '''
		«super.additionalMethods(class_)»
		
		«class_.customCreateSemanticElement»
    '''
    
    def customCreateSemanticElement(Class class_) '''
    	@Override
    	protected «'org.eclipse.emf.ecore.EObject'.imported» createSemanticElement(«'org.eclipse.gmf.runtime.emf.type.core.IElementType'.imported» elementType, EObject container) {
    		if (elementType.equals(«class_.umlElementTypes».StateMachine_Shape)) {
    			// Return the already existing state machine
    			return container;
    		}
    		
    		if (container instanceof «'org.eclipse.uml2.uml.StateMachine'.imported») {
    			// Create the element in the first region, instead, unless it's a region that we're creating
    			if (!elementType.getId().contains(".Region")) {
    				container = ((StateMachine) container).getRegions().get(0);
    			}
    		}
    		
    		return super.createSemanticElement(elementType, container);
    	}
    '''
}
