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
import org.eclipse.papyrus.tests.framework.xtend.annotations.FrameworkConfig
import org.eclipse.papyrus.tests.framework.xtend.annotations.TestPackageRule
import org.eclipse.papyrus.tests.framework.xtend.annotations.TestContextRule

/**
 * Mapping of UML instance specifications for GMFGen model elements to deletion tests in the UTP test model.
 */
class DeleteTest {
    @Inject extension TransformationUtilities
    
    @FrameworkConfig Collection<String> elementTypesDeleteTests = Collections.emptyList
    
    @TestPackageRule val deletePackage = [
        name = 'delete'
        
        testContextRules += mapNone -> topNodeDeletion 
    ]
    
    @TestContextRule val topNodeDeletion = [
        common('AbstractDeleteNodeTest', 'DeleteTest')
        topEditParts += gmfgen.getTopNodes(elementTypesDeleteTests)
        testBehaviors += mapTests(topEditParts) [toCallTestNodeOperationActivity('AbstractDeleteNodeTest', 'DeleteNodeTest', false)]
        testCaseRule = testCaseRule('testDeleteNode')
    ]
}
