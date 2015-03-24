/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ed Seidewitz (MDS) - Initial implementation
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.tests.generator

import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith

import static org.junit.Assert.*

import org.junit.Test
import org.junit.BeforeClass
import java.io.IOException
import org.eclipse.emf.common.util.BasicDiagnostic
import java.io.File
import org.eclipse.papyrus.uml.alf.MappingError
import org.eclipse.papyrus.uml.alf.tests.ParserTest
import org.eclipse.papyrus.uml.alf.tests.generator.AlfGenerator
import java.io.PrintWriter
import java.io.FileWriter

@RunWith(XtextRunner)
class GenerationTest extends ParserTest {

  static final public String ALF_DIRECTORY = System.getProperty("user.dir") + "/Alf"
  static final public String UML_DIRECTORY = System.getProperty("user.dir") + "/UML"

  static protected AlfGenerator generator;
  static protected String umlDirectory;

  @BeforeClass
  static def void setUp() {       
    generator = new AlfGenerator()
    umlDirectory = System.getProperty("uml.directory", UML_DIRECTORY)
  }

  @Test
  def void testGeneration() {
    var failures = 0;
    System.out.println("[GenerationTest] Directory " + umlDirectory + ":")
    val directory = new File(umlDirectory)
    for (file : directory.listFiles()) {
      val name = file.name;
      val l = name.length
      if (name.substring(l - 4, l).equals(".uml")) {
        System.out.println(name)
        val resource = generator.getResource(file.path)
        try {
          val text = generator.generate(resource.getContents())
          val output = new PrintWriter(new FileWriter(
            ALF_DIRECTORY + "/" + name.substring(0, l - 4) + ".alf"
          )); 
          output.print(text);
          output.close
        } catch (MappingError e) {
          val diagnostic = e.diagnostic
          if (diagnostic != null) {
            val status = BasicDiagnostic.toIStatus(diagnostic)
            System.out.println("  " + status)
          } else {
            System.out.println(e.getMessage());
          }
          failures = failures + 1          
        } catch (IOException e) {
          e.printStackTrace()
        }        
        catch (Exception e) {
          e.printStackTrace()
          failures = failures + 1
        }
        resource.unload()
      }
    }
    System.out.println()
    assertEquals(0, failures)
  }

}
