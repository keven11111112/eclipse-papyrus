/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  IJI - Initial implementation
 *  MDS - Update for Luna
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.junit.Test
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.BeforeClass
import org.eclipse.xtext.junit4.InjectWith
import org.junit.AfterClass
import org.eclipse.papyrus.uml.alf.AlfInjectorProvider
import org.eclipse.papyrus.uml.alf.impl.ModelNamespaceImpl
import org.eclipse.papyrus.uml.alf.tests.utils.ContextModelArea
import org.eclipse.ocl.uml.OCL
import org.eclipse.ocl.pivot.model.OCLstdlib
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain

@InjectWith(AlfInjectorProvider)
@RunWith(XtextRunner)
// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SemanticTest extends ParserTest {

  static final public String TEST_DIRECTORY = "./tests"

  static protected ResourceSet resourceSet
  static protected String testDirectory;
  
  @BeforeClass
  static def void setUp() {
    resourceSet = new XtextResourceSet()
    
    OCL.initialize(resourceSet);
    //UML2Pivot.initialize(resourceSet)
    OCLstdlib.install();
    OCLDelegateDomain.initialize(resourceSet)
    //OCLinEcoreStandaloneSetup.doSetup()
    //OCLstdlibStandaloneSetup.doSetup()
    
    var modelArea = new ContextModelArea("Model")
    ModelNamespaceImpl.setContext(modelArea.getModel);    

    testDirectory = System.getProperty("test.directory", TEST_DIRECTORY)
  }
  
  @Test
  def void testStaticSemantics() {
  	System.out.print("[SemanticTest] ")
    val failures = parseDirectory(resourceSet, testDirectory, true);
    assertEquals(0, failures)
  }
    
  @AfterClass
  static def void cleanUp() {
    resourceSet = null;
  }
  
}
