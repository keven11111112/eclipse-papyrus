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

import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.TestNodeTemplate
import org.eclipse.uml2.uml.Class
import javax.inject.Inject

/**
 * Template for the test class for creation of a top-node edit-part.
 */
class CustomTestNodeTemplate extends TestNodeTemplate {
	@Inject extension CustomCommonTemplate
	
    override additionalMethods(Class class_) '''
		«super.additionalMethods(class_)»
		
		«customGetContainerEditPart»
    '''
}
