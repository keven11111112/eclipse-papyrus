/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * 		Géry Deloge (gery.deloge@cea.fr) CEATech AQUI - Initial API and implementation
 *
 *****************************************************************************/

/* to execute tests, decomment and add junit to plugin dependencies */
/*
package org.eclipse.papyrus.requirements.export;

import org.eclipse.papyrus.requirements.export.ExportRequirementCommandHandler;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class ExportRequirementCommandHandlerTest extends TestCase {
	
	
	@Test
	public void testFormatCsvField1(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "";
		assertEquals("", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField2(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "1";
		assertEquals(test, handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField3(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "\"1\"";
		assertEquals("\"\"1\"\"", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField4(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "1,2";
		assertEquals("\"" + test + "\"", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField5(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "1,\"2\"";
		assertEquals("\"1,\"\"2\"\"\"", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField6(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "1\n2";
		assertEquals("1 2", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField7(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "1\r\n2";
		assertEquals("1 2", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField8(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "\"\"";
		assertEquals("\"\"\"\"", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField9(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "\"";
		assertEquals("\"\"\"\"", handler.formatCsvField(test));
	}
	
	@Test
	public void testFormatCsvField10(){
		
		ExportRequirementCommandHandler handler = new ExportRequirementCommandHandler();
		
		String test = "1 \"2\"";
		assertEquals("\"1 \"\"2\"\"\"", handler.formatCsvField(test));
	}
	
}
*/