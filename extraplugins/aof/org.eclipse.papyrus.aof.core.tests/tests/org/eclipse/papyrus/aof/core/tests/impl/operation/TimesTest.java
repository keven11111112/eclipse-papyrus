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
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.impl.operation.Times;
import org.junit.Before;
import org.junit.Test;

public class TimesTest {
	
	private IOne<Integer> oneInt;
	private IOne<Integer> n;
	private Times<Integer> times;

	@Before
	public void setUp() throws Exception {
		oneInt = AOFFactory.INSTANCE.createOne(2,5);
		n = AOFFactory.INSTANCE.createOne(3);
		times = new Times<Integer>(oneInt,n);
	}

	public void tearDown() throws Exception {
		oneInt = null;
		n = null;
		times = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#Times(org.eclipse.papyrus.aof.core.ISingleton, org.eclipse.papyrus.aof.core.IOne}.
	 * Testing size of times at creation
	 */
	public void testTimesSize() {
		assertTrue(times.getResult().size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#Times(org.eclipse.papyrus.aof.core.ISingleton, org.eclipse.papyrus.aof.core.IOne}.
	 * Testing values of times at creation
	 */
	public void testTimesValues() {
		assertTrue(times.getResult().get(0)==5 && times.getResult().get(1)==5 && times.getResult().get(2)==5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isOptional()}.
	 * Times results in the production of a sequence which is optional
	 */
	@Test
	public void testIsOptional() {
		assertTrue(times.getResult().isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isSingleton()}.
	 * Times results in the production of a sequence which is not a singleton
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(times.getResult().isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isOrdered()}.
	 * Times results in the production of a sequence which is ordered
	 */
	@Test
	public void testIsOrdered() {
		assertTrue(times.getResult().isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Select#isUnique()}.
	 * Times results in the production of a sequence which is not unique
	 */
	@Test
	public void testIsUnique() {
		assertFalse(times.getResult().isUnique());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Operation#getResult()}.
	 */
	@Test
	public void testGetResult() {
		assertNotNull(times.getResult());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add a new value to the one value 
	 */
	@Test
	public void testTimesValueAddNewSize() {
		oneInt.add(0,7);
		assertTrue(times.getResult().size()==n.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add a new value to the one value 
	 */
	@Test
	public void testTimesValueAddNewValues() {
		oneInt.add(0,7);
		assertTrue(times.getResult().get(0)==7 && times.getResult().get(1)==7 && times.getResult().get(2)==7);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the one value 
	 */
	@Test
	public void testTimesRemoveExistingSize() {
		oneInt.remove(7);
		assertTrue(times.getResult().size()==n.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the one value
	 * uses the defaultValue instead 
	 */
	@Test
	public void testTimesRemoveExistingValues() {
		oneInt.remove(5);
		assertTrue(times.getResult().get(0)==2 && times.getResult().get(1)==2 && times.getResult().get(2)==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the one value 
	 */
	@Test
	public void testTimesRemoveSize() {
		oneInt.remove(8);
		assertTrue(times.getResult().size()==n.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the one value 
	 */
	@Test
	public void testTimesRemoveValues() {
		oneInt.remove(8);
		assertTrue(times.getResult().get(0)==5 && times.getResult().get(1)==5 && times.getResult().get(2)==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the one value 
	 */
	@Test
	public void testTimesReplaceSize() {
		oneInt.replace(0,0);
		assertTrue(times.getResult().size()==n.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Times#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the one value 
	 */
	@Test
	public void testTimesReplaceValues() {
		oneInt.replace(0,0);
		assertTrue(times.getResult().get(0)==0 && times.getResult().get(1)==0 && times.getResult().get(2)==0);
	}

}
