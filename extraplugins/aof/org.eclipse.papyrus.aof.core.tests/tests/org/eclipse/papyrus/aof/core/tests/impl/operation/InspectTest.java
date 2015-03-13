/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Mickael Clavreul - JUnit testing of the initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.tests.impl.operation;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.impl.operation.Inspect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InspectTest {
	
	private ISet<Integer> setInt;
	private Inspect<Integer> inspect;
	private ByteArrayOutputStream out;
	private String message;
	
	@Before
	public void setUp() throws Exception {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		message = "inspecting setInt ";
		setInt = AOFFactory.INSTANCE.createSet(4,7);
		inspect = new Inspect<Integer>(setInt,message);
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
		setInt = null;
		inspect = null;
		message = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#getResult()}.
	 */
	@Test
	public void testGetResult() {
		assertTrue(inspect.getResult().equals(setInt));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(inspect.getResult().isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(inspect.getResult().isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertFalse(inspect.getResult().isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(inspect.getResult().isUnique());
	}
	
	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#Inspect(org.eclipse.papyrus.aof.core.IBox, java.lang.String)}
	 * Testing output when created
	 */
	@Test
	public void testInspectCreated() {
		assertEquals(message+setInt+"\n",out.toString());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#AObserver#add(int,java.lang.Object}.
	 * Testing output when we add a new value to the initial collection 
	 */
	@Test
	public void testApplyResultAddNewSize() {
		String outMessage = message+setInt+"\n";
		setInt.add(0,5);
		outMessage += message+setInt+"\n";
		outMessage += "                      ^ Add(0, 5)"+"\n";
		assertEquals(outMessage,out.toString());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#AObserver#add(int,java.lang.Object}.
	 * Testing output when we add an existing value to the initial collection 
	 */
	@Test
	public void testApplyResultAddExistingSize() {
		String outMessage = message+setInt+"\n";
		setInt.add(0,1);
		outMessage += message+setInt+"\n";
		outMessage += "                      ^ Add(0, 1)"+"\n";
		assertEquals(outMessage,out.toString());
	}
	
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#AObserver#remove(int,java.lang.Object}.
	 * Testing output when we remove an existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveExistingSize() {
		setInt.remove(1);
		assertEquals(message+setInt+"\n",out.toString());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#AObserver#remove(int,java.lang.Object}.
	 * Testing output when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveSize() {
		setInt.remove(5);
		assertEquals(message+setInt+"\n",out.toString());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Inspect#AObserver#remove(int,java.lang.Object}.
	 * Testing output when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultReplaceSize() {
		String outMessage = message+setInt+"\n";
		setInt.replace(0,5);
		outMessage += message+setInt+"\n";
		outMessage += "                      ^ Remove(0, 4)"+"\n";
		outMessage += message+setInt+"\n";
		outMessage += "                      ^ Add(0, 5)"+"\n";
		assertEquals(outMessage,out.toString());
	}
}
