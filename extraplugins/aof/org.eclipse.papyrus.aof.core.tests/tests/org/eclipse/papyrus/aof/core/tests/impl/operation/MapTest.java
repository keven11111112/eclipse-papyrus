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
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.operation.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapTest {
	
	private ISet<Integer> setInt;
	private Map<Integer,Integer> map;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		setInt = AOFFactory.INSTANCE.createSet(2,3);
		map = new Map<Integer, Integer>(setInt, new IUnaryFunction<Integer,Integer>() {
			public Integer apply(Integer a) {
				return a*2;
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		setInt = null;
		map = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Map#Map(org.eclipse.papyrus.aof.core.IBox, org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testMap() {
		assertTrue(map.getResult().get(0)==4 && map.getResult().get(1)==6);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Map#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(map.getResult().isOptional()==setInt.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Map#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertTrue(map.getResult().isSingleton()==setInt.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Map#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertTrue(map.getResult().isOrdered()==setInt.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Map#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(map.getResult().isUnique()==setInt.isUnique());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Operation#getResult()}.
	 */
	@Test
	public void testGetResult() {
		assertNotNull(map.getResult());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add a new value to the initial collection 
	 */
	@Test
	public void testApplyResultAddNewSize() {
		setInt.add(0,5);
		assertTrue(map.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add a new value to the initial collection 
	 */
	@Test
	public void testApplyResultAddNewValues() {
		setInt.add(0,5);
		assertTrue(map.getResult().get(0)==2*setInt.get(0) &&
				map.getResult().get(1)==2*setInt.get(1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add an existing value to the initial collection 
	 */
	@Test
	public void testApplyResultAddExistingSize() {
		setInt.add(0,2);
		assertTrue(map.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add an existing value to the initial collection 
	 */
	@Test
	public void testApplyResultAddExistingValues() {
		setInt.add(0,2);
		assertTrue(map.getResult().get(0)==2*setInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveExistingSize() {
		setInt.remove(3);
		assertTrue(map.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveExistingValues() {
		setInt.remove(3);
		assertTrue(map.getResult().get(0)==2*setInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveSize() {
		setInt.remove(5);
		assertTrue(map.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveValues() {
		setInt.remove(5);
		assertTrue(map.getResult().get(0)==2*setInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultReplaceSize() {
		setInt.replace(0,5);
		assertTrue(map.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultReplaceValues() {
		setInt.replace(0,5);
		assertTrue(map.getResult().get(0)==2*setInt.get(0));
	}

}
