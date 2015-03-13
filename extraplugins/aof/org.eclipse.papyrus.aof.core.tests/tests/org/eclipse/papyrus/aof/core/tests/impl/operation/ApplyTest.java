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

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.operation.Apply;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ApplyTest {
	
	private ISet<Integer> setInt;
	private Apply<Integer,Integer> apply;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		setInt = AOFFactory.INSTANCE.createSet(1);
		apply = new Apply<Integer, Integer>(setInt, new IUnaryFunction<Integer,Integer>() {
			public Integer apply(Integer a) {
				return a*2;
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		setInt = null;
		apply = null;
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#Apply(org.eclipse.papyrus.aof.core.IBox, org.eclipse.papyrus.aof.core.IUnaryFunction f}.
	 * Testing apply initialization for observers
	 */
	@Test
	public void testApplyObservers() {
		assertTrue(apply.getInternalBox().getObservers().size()>0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#Apply(org.eclipse.papyrus.aof.core.IBox, org.eclipse.papyrus.aof.core.IUnaryFunction f}.
	 * Testing apply initialization for result size
	 */
	@Test
	public void testApplyResultSize() {
		assertTrue(apply.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#Apply(org.eclipse.papyrus.aof.core.IBox, org.eclipse.papyrus.aof.core.IUnaryFunction f}.
	 * Testing apply initialization for result values
	 */
	@Test
	public void testApplyResultValues() {
		assertTrue(apply.getResult().get(0)==2*setInt.get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#isOptional()}.
	 * Apply results in the production of a bag which is optional
	 */
	@Test
	public void testIsOptional() {
		assertTrue(apply.getResult().isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#isSingleton()}.
	 * Apply results in the production of a bag which is not a singleton
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(apply.getResult().isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#isOrdered()}.
	 * Apply results in the production of a bag which is not ordered
	 */
	@Test
	public void testIsOrdered() {
		assertFalse(apply.getResult().isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#isUnique()}.
	 * Apply results in the production of a bag which is not unique
	 */
	@Test
	public void testIsUnique() {
		assertFalse(apply.getResult().isUnique());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Operation#getResult()}.
	 */
	@Test
	public void testGetResult() {
		assertNotNull(apply.getResult());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add a new value to the initial collection 
	 */
	@Test
	public void testApplyResultAddNewSize() {
		setInt.add(0,5);
		assertTrue(apply.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add a new value to the initial collection 
	 */
	@Test
	public void testApplyResultAddNewValues() {
		setInt.add(0,5);
		assertTrue(apply.getResult().get(0)==2*setInt.get(0) &&
				apply.getResult().get(1)==2*setInt.get(1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the size of the result when we add an existing value to the initial collection 
	 */
	@Test
	public void testApplyResultAddExistingSize() {
		setInt.add(0,1);
		assertTrue(apply.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#add(int,java.lang.Object}.
	 * Testing the values of the result when we add an existing value to the initial collection 
	 */
	@Test
	public void testApplyResultAddExistingValues() {
		setInt.add(0,1);
		assertTrue(apply.getResult().get(0)==2*setInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove an existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveExistingSize() {
		setInt.remove(1);
		assertTrue(apply.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove an existing value from the initial collection 
	 * throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testApplyResultRemoveExistingValues() {
		setInt.remove(1);
		thrown.expect(IndexOutOfBoundsException.class);
		apply.getResult().get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveSize() {
		setInt.remove(5);
		assertTrue(apply.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultRemoveValues() {
		setInt.remove(5);
		assertTrue(apply.getResult().get(0)==2*setInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the size of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultReplaceSize() {
		setInt.replace(0,5);
		assertTrue(apply.getResult().size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.operation.Apply#ObserverA#remove(int,java.lang.Object}.
	 * Testing the values of the result when we remove a non existing value from the initial collection 
	 */
	@Test
	public void testApplyResultReplaceValues() {
		setInt.replace(0,5);
		assertTrue(apply.getResult().get(0)==2*setInt.get(0));
	}
}
