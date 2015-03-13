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
package org.eclipse.papyrus.aof.core.tests.impl;

import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IBoxType;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.Bag;
import org.eclipse.papyrus.aof.core.impl.Box;
import org.eclipse.papyrus.aof.core.impl.One;
import org.eclipse.papyrus.aof.core.impl.Option;
import org.eclipse.papyrus.aof.core.impl.OrderedSet;
import org.eclipse.papyrus.aof.core.impl.Sequence;
import org.eclipse.papyrus.aof.core.impl.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createTuple(java.lang.Object, java.lang.Object)}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateTupleNature() {
		IPair<Integer, Integer> pair = AOFFactory.INSTANCE.createTuple(1, 2);
		assertTrue(pair instanceof IPair);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createTuple(java.lang.Object, java.lang.Object)}.
	 * Testing content of the object created
	 */
	@Test
	public void testCreateTupleValues() {
		IPair<Integer, Integer> pair = AOFFactory.INSTANCE.createTuple(1, 2);
		assertTrue(pair.getFirst()==1 && pair.getSecond()==2);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createBox(org.eclipse.papyrus.aof.core.IConstrained, A[])}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateBoxIConstrainedAArray() {
		IBox<Integer> box = AOFFactory.INSTANCE.createBox(IBoxType.BAG, 2,3);
		assertTrue(box instanceof Box);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOption()}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateOptionNature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOption();
		assertTrue(box instanceof Option);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOption()}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateOptionValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOption();
		assertTrue(box.size()==0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOption(java.lang.Object)}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateOptionANature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOption(2);
		assertTrue(box instanceof Option);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOption(java.lang.Object)}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateOptionAValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOption(2);
		assertTrue(box.get(0)==2);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOne(java.lang.Object)}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateOneANature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOne(2);
		assertTrue(box instanceof One);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOne(java.lang.Object)}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateOneAValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOne(2);
		assertTrue(box.get(0)==2 && ((Integer)((One<Integer>)box).getDefaultElement())==2);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOne(java.lang.Object, java.lang.Object)}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateOneAANature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOne(8,9);
		assertTrue(box instanceof One);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOne(java.lang.Object, java.lang.Object)}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateOneAAValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOne(8,1);
		assertTrue(box.get(0)==1 && ((Integer)((One<Integer>)box).getDefaultElement())==8);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createSet(A[])}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateSetNature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createSet(8,9);
		assertTrue(box instanceof Set);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createSet(A[])}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateSetValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createSet(8,9);
		assertTrue(box.get(0)==8 && box.get(1)==9);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOrderedSet(A[])}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateOrderedSetNature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOrderedSet(1,1);
		assertTrue(box instanceof OrderedSet);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createOrderedSet(A[])}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateOrderedSetValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createOrderedSet(1,1);
		assertTrue(box.get(0)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createSequence(A[])}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateSequenceNature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createSequence(1,1);
		assertTrue(box instanceof Sequence);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createSequence(A[])}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateSequenceValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createSequence(1,1);
		assertTrue(box.get(0)==1 && box.get(1)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createBag(A[])}.
	 * Testing nature of the object created
	 */
	@Test
	public void testCreateBagNature() {
		IBox<Integer> box = AOFFactory.INSTANCE.createBag(2,4);
		assertTrue(box instanceof Bag);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.BaseFactory#createBag(A[])}.
	 * Testing values of the object created
	 */
	@Test
	public void testCreateBagValues() {
		IBox<Integer> box = AOFFactory.INSTANCE.createBag(2,4);
		assertTrue(box.get(0)==2 && box.get(1)==4);
	}
}
