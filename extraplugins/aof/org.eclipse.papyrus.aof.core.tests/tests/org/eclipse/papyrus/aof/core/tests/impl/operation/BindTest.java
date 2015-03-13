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

import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.impl.operation.Bind;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BindTest {
	
	private ISet<Integer> setInt;
	private ISet<Integer> setInt2;

	@Before
	public void setUp() throws Exception {
		setInt = AOFFactory.INSTANCE.createSet(2,3);
		setInt2 = AOFFactory.INSTANCE.createSet(8);
		new Bind<Integer>(setInt,setInt2);
	}

	@After
	public void tearDown() throws Exception {
		setInt = null;
		setInt2 = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#add(int,java.lang.Object}.
	 * Testing the size of the result when we add a new value to the second collection 
	 */
	@Test
	public void testBindResultAddNewSize() {
		int setIntSize = setInt.size();
		setInt2.add(0,5);
		assertTrue(setInt.size()==setIntSize+1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#add(int,java.lang.Object}.
	 * Testing the values of the result when we add a new value to the second collection 
	 */
	@Test
	public void testBindResultAddNewValues() {
		setInt2.add(0,5);
		assertTrue(setInt.get(0)==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#add(int,java.lang.Object}.
	 * Testing the size of the result when we add an existing value to the second collection 
	 */
	@Test
	public void testBindResultAddExistingSize() {
		int setIntSize = setInt.size();
		setInt2.add(0,2);
		assertTrue(setInt.size()==setIntSize);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#add(int,java.lang.Object}.
	 * Testing the values of the result when we add an existing value to the second collection 
	 */
	@Test
	public void testBindResultAddExistingValues() {
		setInt2.add(0,2);
		assertTrue(setInt.get(0)==8 && setInt.get(1)==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the second collection 
	 */
	@Test
	public void testBindResultRemoveExistingSize() {
		int setIntSize = setInt.size();
		setInt2.remove(8);
		assertTrue(setInt.size()==setIntSize-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the second collection
	 */
	@Test
	public void testBindResultRemoveExistingValues() {
		setInt2.remove(8);
		assertTrue(setInt.get(0)==2 && setInt.get(1)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBindResultRemoveSize() {
		int setIntSize = setInt.size();
		setInt2.remove(5);
		assertTrue(setInt.size()==setIntSize);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBindResultRemoveValues() {
		setInt2.remove(5);
		assertTrue(setInt.get(0)==8 && setInt.get(1)==2 && setInt.get(2)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBindResultReplaceSize() {
		int setIntSize = setInt.size();
		setInt2.replace(0,5);
		assertTrue(setInt.size()==setIntSize);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Bind#ObserverB#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBindResultReplaceValues() {
		setInt2.replace(0,5);
		assertTrue(setInt.get(0)==5 && setInt.get(1)==2 && setInt.get(2)==3);
	}

}
