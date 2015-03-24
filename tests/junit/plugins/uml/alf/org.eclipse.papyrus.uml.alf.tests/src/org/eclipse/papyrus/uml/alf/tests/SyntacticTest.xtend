/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  IJI - Initial implementation
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.junit.Test
import org.eclipse.emf.ecore.resource.ResourceSet
import org.junit.BeforeClass
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.ocl.examples.pivot.OCL
import org.eclipse.ocl.examples.pivot.model.OCLstdlib
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.papyrus.uml.alf.AlfInjectorProvider
import org.junit.AfterClass

@InjectWith(AlfInjectorProvider)
@RunWith(XtextRunner)
// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SyntacticTest extends ParserTest {

  static final public String TEST_DIRECTORY = "./tests"
  
  static protected ResourceSet resourceSet
  static protected String testDirectory;
  
  @BeforeClass
  static def void setUp() {
    resourceSet = new XtextResourceSet()
    
    OCL.initialize(resourceSet);
    // UML2Pivot.initialize(resourceSet)
    OCLstdlib.install();
    OCLDelegateDomain.initialize(null)
    OCLinEcoreStandaloneSetup.doSetup()
    OCLstdlibStandaloneSetup.doSetup()

    testDirectory = System.getProperty("test.directory", TEST_DIRECTORY)
  }
  
  @Test
  def void testSyntax() {
  	System.out.print("[SyntacticTest] ")
    val failures = parseDirectory(resourceSet, testDirectory, false);
    assertEquals(0, failures)
  }
  
  @AfterClass
  static def void cleanUp() {
    resourceSet = null;
  }
  
}
