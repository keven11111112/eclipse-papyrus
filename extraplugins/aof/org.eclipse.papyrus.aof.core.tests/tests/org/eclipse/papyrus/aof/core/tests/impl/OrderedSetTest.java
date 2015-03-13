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

public class OrderedSetTest {

	public IOrderedSet<Integer> osInt;
	public IOrderedSet<Object> emptyOSet;
	public IOrderedSet<String> osString;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		osInt = AOFFactory.INSTANCE.createOrderedSet(1,2,3);
		emptyOSet = AOFFactory.INSTANCE.createOrderedSet();
		osString = AOFFactory.INSTANCE.createOrderedSet("test1","test3");
	}

	@After
	public void tearDown() throws Exception {
		osInt = null;
		emptyOSet = null;
		osString = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.OrderedSet#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(osInt.getType(),BoxType.ORDERED_SET);
		assertEquals(emptyOSet.getType(),BoxType.ORDERED_SET);
		assertEquals(osString.getType(),BoxType.ORDERED_SET);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(osInt.isOptional());
		assertTrue(emptyOSet.isOptional());
		assertTrue(osString.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(osInt.isSingleton());
		assertFalse(emptyOSet.isSingleton());
		assertFalse(osString.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertTrue(osInt.isOrdered());
		assertTrue(emptyOSet.isOrdered());
		assertTrue(osString.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(osInt.isUnique());
		assertTrue(emptyOSet.isUnique());
		assertTrue(osString.isUnique());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing empty ordered set throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testGetEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyOSet.get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testGetNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osInt.get(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testGetOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osString.get(5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on an ordered set of integers
	 */
	@Test
	public void testGetValidIntegerValue() {
		assertTrue(osInt.get(2)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on an ordered set of strings
	 */
	@Test
	public void testGetValidStringValue() {
		assertEquals(osString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(osInt.size()==3);
		assertTrue(emptyOSet.size()==0);
		assertTrue(osString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing empty ordered set
	 */
	@Test
	public void testIndexOfEmpty() {
		assertTrue(emptyOSet.indexOf(new Object())==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on an ordered set of integers
	 */
	@Test
	public void testIndexOfValidIntegerValue() {
		assertTrue(osInt.indexOf(1)==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on an ordered set of strings
	 */
	@Test
	public void testIndexOfValidStringValue() {
		assertTrue(osString.indexOf("test3")==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on an ordered set of integers
	 */
	@Test
	public void testIndexOfInvalidIntegerValue() {
		assertTrue(osInt.indexOf(4)==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on an ordered set of strings
	 */
	@Test
	public void testIndexOfInvalidStringValue() {
		assertTrue(osString.indexOf("test5")==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing value for empty ordered set
	 */
	@Test
	public void testAddEmptyValue() {
		emptyOSet.add(0,new Object());
		assertNotNull(emptyOSet.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size for empty ordered set
	 */
	@Test
	public void testAddEmptySize() {
		emptyOSet.add(0,new Object());
		assertTrue(emptyOSet.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testAddNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osInt.add(-1,5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testAddOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osString.add(5,"test5");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on an ordered set of integers
	 */
	@Test
	public void testAddValidIntegerSize() {
		osInt.add(2,4);
		osInt.add(1,6);
		assertTrue(osInt.size()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on an ordered set of integers
	 */
	@Test
	public void testAddValidIntegerValue() {
		osInt.add(2,4);
		assertTrue(osInt.get(2)==4 && osInt.get(3)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on an ordered set of strings
	 */
	@Test
	public void testAddValidStringValue() {
		osString.add(0,"test0");
		assertEquals(osString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on an ordered set of strings
	 */
	@Test
	public void testAddValidStringSize() {
		osString.add(1,"test6");
		assertTrue(osString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value already present on an ordered set of integers
	 */
	@Test
	public void testAddExistingIntegerValue() {
		osInt.add(0,1);
		assertTrue(osInt.get(0)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value already present on an ordered set of integers
	 */
	@Test
	public void testAddExistingIntegerSize() {
		osInt.add(1,2);
		assertTrue(osInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an empty ordered set
	 */
	@Test
	public void testAppendEmpty() {
		emptyOSet.append(new Object());
		assertTrue(emptyOSet.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on an ordered set of integers
	 */
	@Test
	public void testAppendIntegerValue() {
		osInt.append(5);
		assertTrue(osInt.get(osInt.size()-1)==5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an ordered set of integers
	 */
	@Test
	public void testAppendIntegerSize() {
		osInt.append(8);
		assertTrue(osInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on an ordered set of strings
	 */
	@Test
	public void testAppendStringValue() {
		osString.append("test2");
		assertTrue(osString.get(osString.size()-1).equals("test2"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an ordered set of strings
	 */
	@Test
	public void testAppendStringSize() {
		osString.append("test2");
		assertTrue(osString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value already present on an ordered set of integers
	 */
	@Test
	public void testAppendExistingIntegerValue() {
		osInt.append(1);
		assertFalse(osInt.get(osInt.size()-1)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value already present on an ordered set of integers
	 */
	@Test
	public void testAppendExistingIntegerSize() {
		osInt.append(1);
		assertTrue(osInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing empty ordered set throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testRemoveAtEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyOSet.removeAt(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testRemoveAtNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osInt.removeAt(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testRemoveAtOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osString.removeAt(5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on an ordered set of integers
	 */
	@Test
	public void testRemoveAtValidIntegerSize() {
		osInt.removeAt(2);
		osInt.removeAt(1);
		assertTrue(osInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on an ordered set of integers
	 */
	@Test
	public void testRemoveAtValidIntegerValue() {
		osInt.removeAt(2);
		assertTrue(osInt.get(0)==1 && osInt.get(1)==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on an ordered set of strings
	 */
	@Test
	public void testRemoveAtValidStringValue() {
		osString.removeAt(0);
		assertEquals(osString.get(0),"test3");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on an ordered set of strings
	 */
	@Test
	public void testRemoveAtValidStringSize() {
		osString.removeAt(1);
		assertTrue(osString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing empty ordered set
	 */
	@Test
	public void testRemoveEmpty() {
		// FIXME should remove on an empty cause an exception or we just ignore?
		emptyOSet.remove(0);
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on an ordered set of integers
	 */
	@Test
	public void testRemoveValidIntegerValue() {
		osInt.remove(2);
		assertTrue(osInt.get(0)==1 && osInt.get(1)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on an ordered set of integers
	 */
	@Test
	public void testRemoveValidIntegerSize() {
		osInt.remove(2);
		osInt.remove(3);
		assertTrue(osInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on an ordered set of strings
	 */
	@Test
	public void testRemoveValidStringValue() {
		osString.remove("test3");
		assertEquals(osString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on an ordered set of strings
	 */
	@Test
	public void testRemoveValidStringSize() {
		osString.remove("test3");
		assertTrue(osString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing an invalid value on an ordered set of integers
	 */
	@Test
	public void testRemoveInvalidIntegerValue() {
		osInt.remove(7);
		assertTrue(osInt.get(0)==1 && osInt.get(1)==2 && osInt.get(2)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing an invalid value on an ordered set of integers
	 */
	@Test
	public void testRemoveInvalidIntegerSize() {
		osInt.remove(12);
		assertTrue(osInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing empty ordered set throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testReplaceEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyOSet.replace(0,new Object());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testReplaceNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osInt.replace(-1,4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing ordered set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testReplaceOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		osString.replace(5,"test5");
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on an ordered set of integers
	 */
	@Test
	public void testReplaceIntegerValues() {
		osInt.replace(0, 4);
		osInt.replace(2, 6);
		assertTrue(osInt.get(0)==4 && osInt.get(2)==6);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on an ordered set of integers
	 */
	@Test
	public void testReplaceIntegerSize() {
		osInt.replace(0, 4);
		osInt.replace(2, 6);
		assertTrue(osInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on an ordered set of integers
	 */
	@Test
	public void testReplaceStringSize() {
		osString.replace(0, "test0");
		osString.replace(1, "test1");
		assertTrue(osString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on an ordered set of strings
	 */
	@Test
	public void testReplaceStringValues() {
		osString.replace(0, "test0");
		osString.replace(1, "test1");
		assertTrue(osString.get(0).equals("test0") && osString.get(1).equals("test1"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#clear()}.
	 */
	@Test
	public void testClear() {
		// Empty ordered set
		emptyOSet.clear();
		assertTrue(emptyOSet.size()==0);
		// Int ordered set
		osInt.clear();
		assertTrue(osInt.size()==0);
		// String ordered set
		osString.clear();
		assertTrue(osString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing null ordered set assignment
	 */
	@Test
	public void testAssignNull() {
		emptyOSet.assign(null);
		assertTrue(emptyOSet.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty ordered set assignment
	 */
	@Test
	public void testAssignEmptySize() {
		IOrderedSet<Object> emptyOSet2 = AOFFactory.INSTANCE.createOrderedSet();
		emptyOSet.assign(emptyOSet2);
		assertTrue(emptyOSet.size()==emptyOSet2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of integer ordered set assignment
	 */
	@Test
	public void testAssignOSetIntegerValues() {
		IOrderedSet<Integer> osInt2 = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		osInt.assign(osInt2);
		assertTrue(osInt.get(osInt.size()-1)==osInt2.get(osInt2.size()-1) &&
				osInt.get(osInt.size()-2)==osInt2.get(osInt2.size()-2) &&
				osInt.get(osInt.size()-3)==osInt2.get(osInt2.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of integer ordered set assignment
	 */
	@Test
	public void testAssignOSetIntegerSize() {
		IOrderedSet<Integer> osInt2 = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		osInt.assign(osInt2);
		assertTrue(osInt.size()==osInt2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of string ordered set assignment
	 */
	@Test
	public void testAssignOSetStringValues() {
		IOrderedSet<String> osString2 = AOFFactory.INSTANCE.createOrderedSet("test");
		osString.assign(osString2);
		assertEquals(osString.get(osString.size()-1),osString2.get(osString2.size()-1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of string ordered set assignment
	 */
	@Test
	public void testAssignOSettringSize() {
		IOrderedSet<String> osString2 = AOFFactory.INSTANCE.createOrderedSet("test");
		osString.assign(osString2);
		assertTrue(osString.size()==osString2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of set to ordered set assignment
	 */
	@Test
	public void testAssignSetToOSetSize() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		osInt.assign(setInt);
		assertTrue(osInt.size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of set to ordered set assignment
	 */
	@Test
	public void testAssignSetToOSetValues() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		osInt.assign(setInt);
		assertTrue(osInt.get(osInt.size()-1)==setInt.get(setInt.size()-1) &&
				osInt.get(osInt.size()-2)==setInt.get(setInt.size()-2) &&
				osInt.get(osInt.size()-3)==setInt.get(setInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of bag to ordered set assignment
	 */
	@Test
	public void testAssignBagToOSetSize() {
		IBag<Integer> osetInt = AOFFactory.INSTANCE.createBag(4,5,6);
		osInt.assign(osetInt);
		assertTrue(osInt.size()==osetInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of bag to ordered set assignment
	 */
	@Test
	public void testAssignBagToOSetValues() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(4,5,6);
		osInt.assign(bagInt);
		assertTrue(osInt.get(osInt.size()-1)==bagInt.get(bagInt.size()-1) &&
				osInt.get(osInt.size()-2)==bagInt.get(bagInt.size()-2) &&
				osInt.get(osInt.size()-3)==bagInt.get(bagInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of sequence to ordered set assignment
	 */
	@Test
	public void testAssignSeqToOSetSize() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		osInt.assign(seqInt);
		assertTrue(osInt.size()==seqInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of sequence to ordered set assignment
	 */
	@Test
	public void testAssignSeqToOSetValues() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		osInt.assign(seqInt);
		assertTrue(osInt.get(osInt.size()-1)==seqInt.get(seqInt.size()-1) &&
				osInt.get(osInt.size()-2)==seqInt.get(seqInt.size()-2) &&
				osInt.get(osInt.size()-3)==seqInt.get(seqInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of one to ordered set assignment
	 */
	@Test
	public void testAssignOneToOsetSize() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		osInt.assign(oneInt);
		assertTrue(osInt.size()==oneInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of one to ordered set assignment
	 */
	@Test
	public void testAssignOneToOsetValues() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		osInt.assign(oneInt);
		assertTrue(osInt.get(osInt.size()-1)==oneInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty option to ordered set assignment
	 */
	@Test
	public void testAssignEmptyOptionToOSetSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption();
		osInt.assign(optionInt);
		assertTrue(osInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of option to ordered set assignment
	 */
	@Test
	public void testAssignOptionToOSetSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(6);
		osInt.assign(optionInt);
		assertTrue(osInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of option to ordered set assignment
	 */
	@Test
	public void testAssignOptionToOSetValues() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(8);
		osInt.assign(optionInt);
		assertTrue(osInt.get(osInt.size()-1)==optionInt.get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size of adding a new observer to an ordered set
	 */
	@Test
	public void testAddObserverSize() {
		int osIntObserversSize = osInt.getObservers().size();
		osInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(osInt.getObservers().size() == osIntObserversSize+1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when adding a new observer to an ordered set
	 */
	@Test
	public void testAddObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		osInt.addObserver(dov);
		assertTrue(osInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size when removing an observer from an ordered set
	 */
	@Test
	public void testRemoveObserverSize() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		osInt.addObserver(dov);
		int osIntObserversSize = osInt.getObservers().size();
		osInt.removeObserver(dov);
		assertTrue(osInt.getObservers().size() == osIntObserversSize-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when removing an observer from an ordered set
	 */
	@Test
	public void testRemoveObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		osInt.removeObserver(dov);
		assertFalse(osInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is empty
	 */
	@Test
	public void testGetEmptyObserversSize() {
		assertTrue(osInt.getObservers().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is not empty
	 */
	@Test
	public void testGetObserversSize() {
		osInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		osInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		osInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(osInt.getObservers().size()==3);
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
		osInt.addObserver(dov2);
		osInt.addObserver(dov1);
		osInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		osInt.addObserver(dov3);
		assertTrue(osInt.getObservers().contains(dov1) && osInt.getObservers().contains(dov2) && osInt.getObservers().contains(dov3));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#bind(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing size of the observers
	 */
	@Test
	public void testBindObserverSize() {
		//FIXME should we test with an empty option?
		IOrderedSet<String> osetString2 = AOFFactory.INSTANCE.createOrderedSet("testX","testE");
		osString.bind(osetString2);
		assertTrue(osetString2.getObservers().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#inspect(java.lang.String)}.
	 * Testing that inspect returns an object
	 */
	@Test
	public void testInspect() {
		assertNotNull(osInt.inspect("testing ordered set-> "));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#apply(org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testApply() {
		assertNotNull(osInt.apply(new IUnaryFunction<Integer,Integer>() {
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
		assertNotNull(osString.map(new IUnaryFunction<String,String>(){
			public String apply(String s){
				return s.toUpperCase();
			}
		}));
	}
}
