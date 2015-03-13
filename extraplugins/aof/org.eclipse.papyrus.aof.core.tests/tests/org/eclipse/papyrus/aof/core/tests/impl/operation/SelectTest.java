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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.impl.operation.Select;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SelectTest {
	
	private Select<Integer> select;
	private ISet<Integer> setInt;
	private ISet<Boolean> setBoolean;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		setInt = AOFFactory.INSTANCE.createSet(4,6);
		setBoolean = AOFFactory.INSTANCE.createSet(true,false);
		select = new Select<Integer>(setInt.zip(setBoolean));
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#Select(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing size after creation
	 */
	@Test
	public void testSelectCreateSize() {
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#Select(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing values after creation
	 */
	@Test
	public void testSelectCreateValues() {
		assertTrue(select.getResult().get(0)==4);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(select.getResult().isOptional()==setInt.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertTrue(select.getResult().isSingleton()==setInt.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertTrue(select.getResult().isOrdered()==setInt.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(select.getResult().isUnique()==setInt.isUnique());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Operation#getResult()}.
	 */
	@Test
	public void testGetResult() {
		assertNotNull(select.getResult());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add a new value to the second collection 
	 */
	@Test
	public void testSelectFirstSetAddNewSize() {
		setInt.add(0,5);
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add a new value to the first collection 
	 */
	@Test
	public void testSelectFirstSetAddNewValues() {
		setInt.add(0,5);
		assertTrue(select.getResult().get(0)==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add an existing value to the first collection 
	 */
	@Test
	public void testSelectFirstSetAddExistingSize() {
		setInt.add(0,4);
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add an existing value to the first collection 
	 */
	@Test
	public void testSelectFirstSetAddExistingValues() {
		setInt.add(0,4);
		assertTrue(select.getResult().get(0)==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the first collection 
	 */
	@Test
	public void testSelectFirstSetRemoveExistingSize() {
		setInt.remove(6);
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the first collection 
	 */
	@Test
	public void testSelectFirstSetRemoveExistingValues() {
		setInt.remove(4);
		assertTrue(select.getResult().get(0)==6);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testSelectFirstSetRemoveSize() {
		setInt.remove(5);
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testSelectFirstSetRemoveValues() {
		setInt.remove(5);
		assertTrue(select.getResult().get(0)==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testSelectFirstSetReplaceSize() {
		setInt.replace(0,5);
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testSelectFirstSetReplaceValues() {
		setInt.replace(0,5);
		assertTrue(select.getResult().get(0)==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add an existing value to the first collection 
	 */
	@Test
	public void testSelectSecondSetAddExistingSize() {
		setBoolean.add(1,true);
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add an existing value to the first collection 
	 */
	@Test
	public void testSelectSecondSetAddExistingValues() {
		setBoolean.add(1,true);
		assertTrue(select.getResult().get(0)==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the first collection 
	 */
	@Test
	public void testSelectSecondSetRemoveExistingSize() {
		setBoolean.remove(true);
		assertTrue(select.getResult().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the first collection 
	 * throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testSelectSecondSetRemoveExistingValues() {
		setBoolean.remove(true);
		thrown.expect(IndexOutOfBoundsException.class);
		select.getResult().get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testSelectSecondSetReplaceSize() {
		setBoolean.replace(1,true);
		assertTrue(select.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testSelectSecondSetReplaceValues() {
		setBoolean.replace(1,true);
		assertTrue(select.getResult().get(0)==4);
	}

}
