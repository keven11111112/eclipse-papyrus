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

import java.util.ArrayList
import java.util.List
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.Package
import javax.inject.Inject

/**
 * The main entry-point rule for the model-to-text transformation that generates the test code
 * from a UML-UTP model describing the diagram test cases.
 */
class PapyrusDiagramCanonicalTests {
    @Inject extension TemplateQueries
    @Inject extension CodegenContext
    
    @Inject AllPackageTestsTemplate allPackageTests
    @Inject AppearanceTestTemplate appearanceTests
    @Inject DirectEditTestTemplate directEditTests
    @Inject DeleteTestTemplate deleteTests
    @Inject DropTestTemplate dropTests
    @Inject TestChildLabelNodeTemplate childLabelNodeTests
    @Inject TestLinkTemplate linkTests
    @Inject TestNodeTemplate nodeTests
    @Inject SynchronizationTestTemplate synchronizationTests
	
	def generate(Model model) {
		var List<String> suiteClasses = new ArrayList<String>
		for (Package subpackage : model.ownedElements.filter(Package)){
			val allTestClasses = subpackage.allOwnedElements.filter(Class)
				.filter[getAppliedStereotype("utp::TestContext") != null]
				.filter[!ownedAttributes.empty]
				.filter[hasTestCases]
				
		    if (!allTestClasses.empty) {
                for (Class clazz : allTestClasses) {

                    // Invoke the proper template for the class
                    val superClass = clazz.generals.head as Class

                    createFile(clazz) [
                        switch superClass.name {
                            case "AbstractCreateNodeFromPaletteTest": nodeTests.generate(clazz)
                            case "AbstractCreateLinkFromPaletteTest": linkTests.generate(clazz)
                            case "AbstractCreateChildLabelNodeFromPaletteTest": childLabelNodeTests.generate(clazz)
                            case "AbstractCreateLinkOwnedBySourceFromPaletteTest": linkTests.generate(clazz)
                            case "AbstractAppearanceNodeTest": appearanceTests.generate(clazz)
                            case "AbstractDropNodeTest": dropTests.generate(clazz)
                            case "AbstractDeleteNodeTest": deleteTests.generate(clazz)
                            case "AbstractEditableNodeTest": directEditTests.generate(clazz)
                            case "AbstractSynchronizationTest",
                            case "AbstractCSSSynchronizationTest" : synchronizationTests.generate(clazz)
                            default: throw new RuntimeException("Type of test not recognized: " + superClass.name)
                        }
                    ]
                }
                var className = generatePackageTestSuiteClass(subpackage, allTestClasses)
                suiteClasses.add(className);
            }
		}
		generateAllTestSuiteClass(model, suiteClasses)
	}
	
	def generateAllTestSuiteClass(Package model, List<String> testSuiteNames) {
	    val className = "AllGenTests"
		createClass(model, className) [
            allPackageTests.generate(className, model.name, testSuiteNames);
        ]
	}
	
	def generatePackageTestSuiteClass(Package package_, Iterable<Class> allTestClasses) {
	    val packageName = package_.name
		val className = "All" + packageName.substring(packageName.lastIndexOf('.') + 1).toFirstUpper + "Tests"
		createClass(package_, className) [
            allPackageTests.generate(className, packageName, allTestClasses.toList.map[name]);
        ]
        
        packageName + '.' + className
	}
}
