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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.BoxType;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BagTest {

	public IBag<Integer> bagInt;
	public IBag<Object> emptyBag;
	public IBag<String> bagString;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		bagInt = AOFFactory.INSTANCE.createBag(1,2,3);
		emptyBag = AOFFactory.INSTANCE.createBag();
		bagString = AOFFactory.INSTANCE.createBag("test1","test3");
	}

	@After
	public void tearDown() throws Exception {
		bagInt = null;
		emptyBag = null;
		bagString = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Bag#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(bagInt.getType(),BoxType.BAG);
		assertEquals(emptyBag.getType(),BoxType.BAG);
		assertEquals(bagString.getType(),BoxType.BAG);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(bagInt.isOptional());
		assertTrue(emptyBag.isOptional());
		assertTrue(bagString.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(bagInt.isSingleton());
		assertFalse(emptyBag.isSingleton());
		assertFalse(bagString.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertFalse(bagInt.isOrdered());
		assertFalse(emptyBag.isOrdered());
		assertFalse(bagString.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertFalse(bagInt.isUnique());
		assertFalse(emptyBag.isUnique());
		assertFalse(bagString.isUnique());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing empty bag throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testGetEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyBag.get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testGetNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagInt.get(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testGetOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagString.get(5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a bag of integers
	 */
	@Test
	public void testGetValidIntegerValue() {
		assertTrue(bagInt.get(2)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a bag of strings
	 */
	@Test
	public void testGetValidStringValue() {
		assertEquals(bagString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(bagInt.size()==3);
		assertTrue(emptyBag.size()==0);
		assertTrue(bagString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing empty bag
	 */
	@Test
	public void testIndexOfEmpty() {
		assertTrue(emptyBag.indexOf(new Object())==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on a bag of integers
	 */
	@Test
	public void testIndexOfValidIntegerValue() {
		assertTrue(bagInt.indexOf(1)==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on a bag of strings
	 */
	@Test
	public void testIndexOfValidStringValue() {
		assertTrue(bagString.indexOf("test3")==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on a bag of integers
	 */
	@Test
	public void testIndexOfInvalidIntegerValue() {
		assertTrue(bagInt.indexOf(4)==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on a bag of strings
	 */
	@Test
	public void testIndexOfInvalidStringValue() {
		assertTrue(bagString.indexOf("test5")==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing value for empty bag
	 */
	@Test
	public void testAddEmptyValue() {
		emptyBag.add(0,new Object());
		assertNotNull(emptyBag.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size for empty bag
	 */
	@Test
	public void testAddEmptySize() {
		emptyBag.add(0,new Object());
		assertTrue(emptyBag.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testAddNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagInt.add(-1,5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testAddOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagString.add(5,"test5");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a bag of integers
	 */
	@Test
	public void testAddValidIntegerSize() {
		bagInt.add(2,4);
		bagInt.add(1,6);
		assertTrue(bagInt.size()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a bag of integers
	 */
	@Test
	public void testAddValidIntegerValue() {
		bagInt.add(2,4);
		assertTrue(bagInt.get(2)==4 && bagInt.get(3)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a bag of strings
	 */
	@Test
	public void testAddValidStringValue() {
		bagString.add(0,"test0");
		assertEquals(bagString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a bag of strings
	 */
	@Test
	public void testAddValidStringSize() {
		bagString.add(1,"test6");
		assertTrue(bagString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value already present on a bag of integers
	 */
	@Test
	public void testAddExistingIntegerValue() {
		bagInt.add(0,1);
		assertTrue(bagInt.get(0)==1 && bagInt.get(1)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value already present on a bag of integers
	 */
	@Test
	public void testAddExistingIntegerSize() {
		bagInt.add(1,2);
		assertTrue(bagInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an empty bag
	 */
	@Test
	public void testAppendEmpty() {
		emptyBag.append(new Object());
		assertTrue(emptyBag.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a bag of integers
	 */
	@Test
	public void testAppendIntegerValue() {
		bagInt.append(5);
		assertTrue(bagInt.get(bagInt.size()-1)==5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a bag of integers
	 */
	@Test
	public void testAppendIntegerSize() {
		bagInt.append(8);
		assertTrue(bagInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a bag of strings
	 */
	@Test
	public void testAppendStringValue() {
		bagString.append("test2");
		assertTrue(bagString.get(bagString.size()-1).equals("test2"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a bag of strings
	 */
	@Test
	public void testAppendStringSize() {
		bagString.append("test2");
		assertTrue(bagString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value already present on a bag of integers
	 */
	@Test
	public void testAppendExistingIntegerValue() {
		bagInt.append(1);
		assertTrue(bagInt.get(bagInt.size()-1)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value already present on a bag of integers
	 */
	@Test
	public void testAppendExistingIntegerSize() {
		bagInt.append(1);
		assertTrue(bagInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing empty bag throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testRemoveAtEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyBag.removeAt(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testRemoveAtNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagInt.removeAt(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testRemoveAtOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagString.removeAt(5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a bag of integers
	 */
	@Test
	public void testRemoveAtValidIntegerSize() {
		bagInt.removeAt(2);
		bagInt.removeAt(1);
		assertTrue(bagInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on a bag of integers
	 */
	@Test
	public void testRemoveAtValidIntegerValue() {
		bagInt.removeAt(2);
		assertTrue(bagInt.get(0)==1 && bagInt.get(1)==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on a bag of strings
	 */
	@Test
	public void testRemoveAtValidStringValue() {
		bagString.removeAt(0);
		assertEquals(bagString.get(0),"test3");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a bag of strings
	 */
	@Test
	public void testRemoveAtValidStringSize() {
		bagString.removeAt(1);
		assertTrue(bagString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing empty bag size unchanged
	 */
	@Test
	public void testRemoveEmpty() {
		int emptyBagSize = emptyBag.size();
		emptyBag.remove(0);
		assertTrue(emptyBag.size()==emptyBagSize);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on a bag of integers
	 */
	@Test
	public void testRemoveValidIntegerValue() {
		bagInt.remove(2);
		assertTrue(bagInt.get(0)==1 && bagInt.get(1)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a bag of integers
	 */
	@Test
	public void testRemoveValidIntegerSize() {
		bagInt.remove(2);
		bagInt.remove(3);
		assertTrue(bagInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on a bag of strings
	 */
	@Test
	public void testRemoveValidStringValue() {
		bagString.remove("test3");
		assertEquals(bagString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a bag of strings
	 */
	@Test
	public void testRemoveValidStringSize() {
		bagString.remove("test3");
		assertTrue(bagString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing an invalid value on a bag of integers
	 */
	@Test
	public void testRemoveInvalidIntegerValue() {
		bagInt.remove(7);
		assertTrue(bagInt.get(0)==1 && bagInt.get(1)==2 && bagInt.get(2)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing an invalid value on a bag of integers
	 */
	@Test
	public void testRemoveInvalidIntegerSize() {
		bagInt.remove(12);
		assertTrue(bagInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing empty bag throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testReplaceEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyBag.replace(0,new Object());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testReplaceNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagInt.replace(-1,4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing bag throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testReplaceOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		bagString.replace(5,"test5");
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a bag of integers
	 */
	@Test
	public void testReplaceIntegerValues() {
		bagInt.replace(0, 4);
		bagInt.replace(2, 6);
		assertTrue(bagInt.get(0)==4 && bagInt.get(2)==6);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a bag of integers
	 */
	@Test
	public void testReplaceIntegerSize() {
		bagInt.replace(0, 4);
		bagInt.replace(2, 6);
		assertTrue(bagInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a bag of integers
	 */
	@Test
	public void testReplaceStringSize() {
		bagString.replace(0, "test0");
		bagString.replace(1, "test1");
		assertTrue(bagString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a bag of strings
	 */
	@Test
	public void testReplaceStringValues() {
		bagString.replace(0, "test0");
		bagString.replace(1, "test1");
		assertTrue(bagString.get(0).equals("test0") && bagString.get(1).equals("test1"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#clear()}.
	 */
	@Test
	public void testClear() {
		// Empty Bag
		emptyBag.clear();
		assertTrue(emptyBag.size()==0);
		// Bag Int
		bagInt.clear();
		assertTrue(bagInt.size()==0);
		// Bag String
		bagString.clear();
		assertTrue(bagString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing null bag assignment
	 */
	@Test
	public void testAssignNull() {
		emptyBag.assign(null);
		assertTrue(emptyBag.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty bag assignment
	 */
	@Test
	public void testAssignEmptySize() {
		IBag<Object> emptyBag2 = AOFFactory.INSTANCE.createBag();
		emptyBag.assign(emptyBag2);
		assertTrue(emptyBag.size()==emptyBag2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of integer bag assignment
	 */
	@Test
	public void testAssignBagIntegerValues() {
		IBag<Integer> bagInt2 = AOFFactory.INSTANCE.createBag(4,5,6);
		bagInt.assign(bagInt2);
		assertTrue(bagInt.get(bagInt.size()-1)==bagInt2.get(bagInt2.size()-1) &&
				bagInt.get(bagInt.size()-2)==bagInt2.get(bagInt2.size()-2) &&
				bagInt.get(bagInt.size()-3)==bagInt2.get(bagInt2.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of integer bag assignment
	 */
	@Test
	public void testAssignBagIntegerSize() {
		IBag<Integer> bagInt2 = AOFFactory.INSTANCE.createBag(4,5);
		bagInt.assign(bagInt2);
		assertTrue(bagInt.size()==bagInt2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of string bag assignment
	 */
	@Test
	public void testAssignBagStringValues() {
		IBag<String> bagString2 = AOFFactory.INSTANCE.createBag("test");
		bagString.assign(bagString2);
		assertEquals(bagString.get(bagString.size()-1),bagString2.get(bagString2.size()-1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of string bag assignment
	 */
	@Test
	public void testAssignBagStringSize() {
		IBag<String> bagString2 = AOFFactory.INSTANCE.createBag("test");
		bagString.assign(bagString2);
		assertTrue(bagString.size()==bagString2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of set to bag assignment
	 */
	@Test
	public void testAssignSetToBagSize() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		bagInt.assign(setInt);
		assertTrue(bagInt.size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of set to bag assignment
	 */
	@Test
	public void testAssignSetToBagValues() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		bagInt.assign(setInt);
		assertTrue(bagInt.get(bagInt.size()-1)==setInt.get(setInt.size()-1) &&
				bagInt.get(bagInt.size()-2)==setInt.get(setInt.size()-2) &&
				bagInt.get(bagInt.size()-3)==setInt.get(setInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of ordered set to bag assignment
	 */
	@Test
	public void testAssignOSetToBagSize() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		bagInt.assign(osetInt);
		assertTrue(bagInt.size()==osetInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of ordered set to bag assignment
	 */
	@Test
	public void testAssignOSetToBagValues() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		bagInt.assign(osetInt);
		assertTrue(bagInt.get(bagInt.size()-1)==osetInt.get(osetInt.size()-1) &&
				bagInt.get(bagInt.size()-2)==osetInt.get(osetInt.size()-2) &&
				bagInt.get(bagInt.size()-3)==osetInt.get(osetInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of sequence to bag assignment
	 */
	@Test
	public void testAssignSeqToBagSize() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		bagInt.assign(seqInt);
		assertTrue(bagInt.size()==seqInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of sequence to bag assignment
	 */
	@Test
	public void testAssignSeqToBagValues() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		bagInt.assign(seqInt);
		assertTrue(bagInt.get(bagInt.size()-1)==seqInt.get(seqInt.size()-1) &&
				bagInt.get(bagInt.size()-2)==seqInt.get(seqInt.size()-2) &&
				bagInt.get(bagInt.size()-3)==seqInt.get(seqInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of one to bag assignment
	 */
	@Test
	public void testAssignOneToBagSize() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		bagInt.assign(oneInt);
		assertTrue(bagInt.size()==oneInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of one to bag assignment
	 */
	@Test
	public void testAssignOneToBagValues() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		bagInt.assign(oneInt);
		assertTrue(bagInt.get(bagInt.size()-1)==oneInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty option to bag assignment
	 */
	@Test
	public void testAssignEmptyOptionToBagSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption();
		bagInt.assign(optionInt);
		assertTrue(bagInt.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of option to bag assignment
	 */
	@Test
	public void testAssignOptionToBagSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(6);
		bagInt.assign(optionInt);
		assertTrue(bagInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of option to bag assignment
	 */
	@Test
	public void testAssignOptionToBagValues() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(8);
		bagInt.assign(optionInt);
		assertTrue(bagInt.get(bagInt.size()-1)==optionInt.get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size of adding a new observer to a bag
	 */
	@Test
	public void testAddObserverSize() {
		int bagIntObserversSize = bagInt.getObservers().size();
		bagInt.addObserver(new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(bagInt.getObservers().size() == bagIntObserversSize+1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when adding a new observer to a bag
	 */
	@Test
	public void testAddObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		};
		bagInt.addObserver(dov);
		assertTrue(bagInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size when removing an observer from a bag
	 */
	@Test
	public void testRemoveObserverSize() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		};
		bagInt.addObserver(dov);
		int bagIntObserversSize = bagInt.getObservers().size();
		bagInt.removeObserver(dov);
		assertTrue(bagInt.getObservers().size() == bagIntObserversSize-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when removing an observer from a bag
	 */
	@Test
	public void testRemoveObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		}; 
		bagInt.removeObserver(dov);
		assertFalse(bagInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is empty
	 */
	@Test
	public void testGetEmptyObserversSize() {
		assertTrue(bagInt.getObservers().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is not empty
	 */
	@Test
	public void testGetObserversSize() {
		bagInt.addObserver(new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		});
		bagInt.addObserver(new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		});
		bagInt.addObserver(new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(bagInt.getObservers().size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing values when getting observers when the list is not empty
	 */
	@Test
	public void testGetObserversValues() {
		DefaultObserver<Integer> dov1 = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		};
		DefaultObserver<Integer> dov2 = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		};
		DefaultObserver<Integer> dov3 = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		};
		bagInt.addObserver(dov2);
		bagInt.addObserver(dov1);
		bagInt.addObserver(new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		});
		bagInt.addObserver(dov3);
		assertTrue(bagInt.getObservers().contains(dov1) && bagInt.getObservers().contains(dov2) && bagInt.getObservers().contains(dov3));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#bind(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing size of the observers
	 */
	@Test
	public void testBindObserverSize() {
		//FIXME should we test with an empty option?
		IBag<String> bagString2 = AOFFactory.INSTANCE.createBag("testX");
		bagString.bind(bagString2);
		assertTrue(bagString2.getObservers().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#inspect(java.lang.String)}.
	 * Testing that inspect returns an object
	 */
	@Test
	public void testInspect() {
		assertNotNull(bagInt.inspect("testing bag-> "));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#apply(org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testApply() {
		assertNotNull(bagInt.apply(new IUnaryFunction<Integer,Integer>() {
			public Integer apply(Integer a) {
				return a*2;
			}
		}));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#map(org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testMap() {
		assertNotNull(bagString.map(new IUnaryFunction<String,String>(){
			public String apply(String s){
				return s.toUpperCase();
			}
		}));
	}
}
