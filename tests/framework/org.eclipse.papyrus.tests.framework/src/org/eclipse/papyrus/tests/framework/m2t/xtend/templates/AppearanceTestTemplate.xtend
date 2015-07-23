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

import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Operation

/**
 * Code generation template for the appearance tests class for an edit-part.
 */
class AppearanceTestTemplate extends AbstractTestTemplate {

    override diagramCreationMethods(Class class_) '''
        @Override
        public «imported('org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart')» getContainerEditPart() {
            return getDiagramEditPart();
        }
        
        «super.diagramCreationMethods(class_)»
    '''
    
    override getDiagramUpdaterMethod(Class class_) ''''''
    
    override purpose(Operation testCase, String componentName) '''Test the appearance properties of «componentName».'''
}
