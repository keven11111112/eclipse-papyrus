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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.impl.operation.BinaryZip;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BinaryZipTest {

	private ISet<Integer> setInt;
	private ISet<Integer> setInt2;
	private BinaryZip<Integer, Integer> bin;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		setInt = AOFFactory.INSTANCE.createSet(2, 3);
		setInt2 = AOFFactory.INSTANCE.createSet(5);
		bin = new BinaryZip<Integer, Integer>(setInt, setInt2);
	}

	@After
	public void tearDown() throws Exception {
		setInt = null;
		setInt2 = null;
		bin = null;
	}
	
	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#BinaryZip(org.eclipse.papyrus.aof.core.IBox, org.eclipse.papyrus.aof.core.IBox)}
	 * Testing size of the new created set
	 */
	@Test
	public void testBinaryZipCreatedSize() {
		assertTrue(bin.getResult().size()==1);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#BinaryZip(org.eclipse.papyrus.aof.core.IBox, org.eclipse.papyrus.aof.core.IBox)}
	 * Testing value for the new created set
	 */
	@Test
	public void testBinaryZipCreatedValues() {
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==2 && pair.get(0).getSecond()==5);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#isOptional()}
	 * .
	 */
	@Test
	public void testIsOptional() {
		assertTrue(bin.getResult().isOptional());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#isSingleton()}
	 * .
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(bin.getResult().isSingleton());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#isOrdered()}
	 * .
	 */
	@Test
	public void testIsOrdered() {
		assertFalse(bin.getResult().isOrdered());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(bin.getResult().isUnique());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.aof.core.impl.operation.Operation#getResult()}
	 * .
	 */
	@Test
	public void testGetResult() {
		assertNotNull(bin.getResult());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add a new value to the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetAddNewSize() {
		setInt.add(0,5);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add a new value to the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetAddNewValue() {
		setInt.add(0,5);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==5 &&	pair.get(0).getSecond()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add an existing value to the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetAddExistingSize() {
		setInt.add(0,2);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add an existing value to the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetAddExistingValue() {
		setInt.add(0,2);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==2 && pair.get(0).getSecond()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetRemoveExistingSize() {
		setInt.remove(3);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetRemoveExistingValues() {
		setInt.remove(2);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==3 && pair.get(0).getSecond()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetRemoveSize() {
		setInt.remove(5);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetRemoveValues() {
		setInt.remove(5);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==2 && pair.get(0).getSecond()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetReplaceSize() {
		setInt.replace(0,5);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the first collection 
	 */
	@Test
	public void testBinaryZipFirstSetReplaceValues() {
		setInt.replace(0,5);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==5 && pair.get(0).getSecond()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#add(int,java.lang.Object}.
	 * Testing the size of the result when we add a new value to the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetAddNewSize() {
		setInt2.add(1,6);
		assertTrue(bin.getResult().size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#add(int,java.lang.Object}.
	 * Testing the values of the result when we add a new value to the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetAddNewValue() {
		setInt2.add(1,6);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==2 &&	pair.get(0).getSecond()==5 &&
				pair.get(1).getFirst()==3 &&	pair.get(1).getSecond()==6);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#add(int,java.lang.Object}.
	 * Testing the size of the result when we add an existing value to the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetAddExistingSize() {
		setInt2.add(0,5);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#add(int,java.lang.Object}.
	 * Testing the values of the result when we add an existing value to the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetAddExistingValue() {
		setInt2.add(0,5);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==2 && pair.get(0).getSecond()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetRemoveExistingSize() {
		setInt2.remove(5);
		assertTrue(bin.getResult().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetRemoveExistingValues() {
		setInt2.remove(5);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		thrown.expect(IndexOutOfBoundsException.class);
		pair.get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetRemoveSize() {
		setInt2.remove(8);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetRemoveValues() {
		setInt2.remove(8);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==2 && pair.get(0).getSecond()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetReplaceSize() {
		setInt2.replace(0,4);
		assertTrue(bin.getResult().size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.BinaryZip#ObserverB#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the second collection 
	 */
	@Test
	public void testBinaryZipSecondSetReplaceValues() {
		setInt2.replace(0,4);
		ISet<IPair<Integer,Integer>> pair = (ISet<IPair<Integer,Integer>>)bin.getResult();
		assertTrue(pair.get(0).getFirst()==2 && pair.get(0).getSecond()==4);
	}

}
