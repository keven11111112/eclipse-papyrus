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

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.papyrus.tests.framework.m2m.Metamodels
import org.eclipse.papyrus.tests.framework.xtend.annotations.FrameworkConfig
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.UMLFactory

/**
 * Mapping of UML instance specifications for GMFGen model elements to UTP test model.
 */
@Singleton
class CanonicalTests {
    static extension UMLFactory = UMLFactory.eINSTANCE
    
    @Inject extension Metamodels
    @Inject extension TransformationUtilities
    
    @Inject extension AppearanceTest
    @Inject extension CreateFromPaletteTest
    @Inject extension DirectEditTest
    @Inject extension DropTest
    @Inject extension DeleteTest
    @Inject extension SynchronizationTest
    
    @FrameworkConfig String diagramTestPackageName
    
    def create createModel toUTPModel(Model gmfgenModel, Resource extent) {
        name = diagramTestPackageName
        
        // Add the output model to a resource-set context now to support the static UTP profile
        extent.contents.add(it)
        applyProfile(utp)
        
       // createTestPackage(gmfgenModel, appearancePackage)
        //remove test creation not usefull.
       // createTestPackage(gmfgenModel, createFromPalettePackage)
       // createTestPackage(gmfgenModel, directEditPackage)
       // createTestPackage(gmfgenModel, dropPackage)
       // createTestPackage(gmfgenModel, deletePackage)
      //  createTestPackage(gmfgenModel, synchronizationPackage)
    }
}
