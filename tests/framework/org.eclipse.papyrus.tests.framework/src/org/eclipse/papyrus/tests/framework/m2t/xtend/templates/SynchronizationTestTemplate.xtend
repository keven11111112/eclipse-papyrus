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

import javax.inject.Inject
import org.eclipse.uml2.uml.Activity
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.InstanceValue
import org.eclipse.uml2.uml.InvocationAction
import org.eclipse.uml2.uml.ValuePin
import org.eclipse.uml2.uml.InputPin
import org.eclipse.uml2.uml.Operation

/**
 * Common structure of the model-view synchronization tests for an edit-part.  Provides several
 * abstract or default-blank snippets that subclasses should override to plug in specific code fragments.
 */
class SynchronizationTestTemplate extends AbstractTestTemplate {
    @Inject protected extension TemplateQueries
    @Inject protected extension Importator
    
    protected def syncTestKind(Class testContext) {
    	testContext.getOwnedAttribute('syncTestKind', null)?.defaultValue?.stringValue
    }
    
    override additionalAnnotations(Class testContext) {
    	val org.eclipse.uml2.uml.Property css = testContext.getAttribute('css', null);
    	if (css != null) {
    		'''@«'org.eclipse.papyrus.uml.diagram.tests.synchronization.AbstractCSSSynchronizationTest.CSS'.imported»("«css.defaultValue.stringValue»")'''
    	} else {
    		super.additionalAnnotations(testContext)
    	}
    }
    
    override purpose(Operation testCase, String componentName) {
    	switch (testCase.class_.syncTestKind) {
    		case 'labelnode' : '''Test to synchronize child label node «componentName».'''
    		case 'childnode' : '''Test to synchronize child node «componentName».'''
    		case 'link' : '''Test to synchronize link «componentName».'''
    		default: '''Test to synchronize node «componentName».'''
    	}
    } 
    
    override getDiagramUpdaterMethod(Class class_) ''''''
    
    protected def instanceValue(Activity method, String pinName) {
        (method.ownedNodes.head as InvocationAction).instanceValue(pinName)
    }
    
    protected def instanceValue(InvocationAction action, String pinName) {
        action.arguments.findFirst[name == pinName].instanceValue
    }
    
    protected def instanceValue(InputPin pin) {
        ((pin as ValuePin).value as InstanceValue).instance
    }
    
    protected def umlElementTypes(Class class_) {
        (class_.packageRootName + '.providers.UMLElementTypes').imported
    }
}
