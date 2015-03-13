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

public class SetTest {

	public ISet<Integer> setInt;
	public ISet<Object> emptySet;
	public ISet<String> setString;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		setInt = AOFFactory.INSTANCE.createSet(1,2,3);
		emptySet = AOFFactory.INSTANCE.createSet();
		setString = AOFFactory.INSTANCE.createSet("test1","test3");
	}

	@After
	public void tearDown() throws Exception {
		setInt = null;
		emptySet = null;
		setString = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Set#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(setInt.getType(),BoxType.SET);
		assertEquals(emptySet.getType(),BoxType.SET);
		assertEquals(setString.getType(),BoxType.SET);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(setInt.isOptional());
		assertTrue(emptySet.isOptional());
		assertTrue(setString.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(setInt.isSingleton());
		assertFalse(emptySet.isSingleton());
		assertFalse(setString.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertFalse(setInt.isOrdered());
		assertFalse(emptySet.isOrdered());
		assertFalse(setString.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(setInt.isUnique());
		assertTrue(emptySet.isUnique());
		assertTrue(setString.isUnique());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing empty set throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testGetEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptySet.get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testGetNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setInt.get(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testGetOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setString.get(5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a set of integers
	 */
	@Test
	public void testGetValidIntegerValue() {
		assertTrue(setInt.get(2)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a set of strings
	 */
	@Test
	public void testGetValidStringValue() {
		assertEquals(setString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(setInt.size()==3);
		assertTrue(emptySet.size()==0);
		assertTrue(setString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing empty set
	 */
	@Test
	public void testIndexOfEmpty() {
		assertTrue(emptySet.indexOf(new Object())==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on a set of integers
	 */
	@Test
	public void testIndexOfValidIntegerValue() {
		assertTrue(setInt.indexOf(1)==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on a set of strings
	 */
	@Test
	public void testIndexOfValidStringValue() {
		assertTrue(setString.indexOf("test3")==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on a set of integers
	 */
	@Test
	public void testIndexOfInvalidIntegerValue() {
		assertTrue(setInt.indexOf(4)==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on a set of strings
	 */
	@Test
	public void testIndexOfInvalidStringValue() {
		assertTrue(setString.indexOf("test5")==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing value for empty set
	 */
	@Test
	public void testAddEmptyValue() {
		emptySet.add(0,new Object());
		assertNotNull(emptySet.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size for empty set
	 */
	@Test
	public void testAddEmptySize() {
		emptySet.add(0,new Object());
		assertTrue(emptySet.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testAddNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setInt.add(-1,5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testAddOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setString.add(5,"test5");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a set of integers
	 */
	@Test
	public void testAddValidIntegerSize() {
		setInt.add(2,4);
		setInt.add(1,6);
		assertTrue(setInt.size()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a set of integers
	 */
	@Test
	public void testAddValidIntegerValue() {
		setInt.add(2,4);
		assertTrue(setInt.get(2)==4 && setInt.get(3)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a set of strings
	 */
	@Test
	public void testAddValidStringValue() {
		setString.add(0,"test0");
		assertEquals(setString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a set of strings
	 */
	@Test
	public void testAddValidStringSize() {
		setString.add(1,"test6");
		assertTrue(setString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value already present on a set of integers
	 */
	@Test
	public void testAddExistingIntegerValue() {
		setInt.add(0,1);
		assertTrue(setInt.get(0)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value already present on a set of integers
	 */
	@Test
	public void testAddExistingIntegerSize() {
		setInt.add(1,2);
		assertTrue(setInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an empty set
	 */
	@Test
	public void testAppendEmpty() {
		emptySet.append(new Object());
		assertTrue(emptySet.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a set of integers
	 */
	@Test
	public void testAppendIntegerValue() {
		setInt.append(5);
		assertTrue(setInt.get(setInt.size()-1)==5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a set of integers
	 */
	@Test
	public void testAppendIntegerSize() {
		setInt.append(8);
		assertTrue(setInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a set of strings
	 */
	@Test
	public void testAppendStringValue() {
		setString.append("test2");
		assertTrue(setString.get(setString.size()-1).equals("test2"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a set of strings
	 */
	@Test
	public void testAppendStringSize() {
		setString.append("test2");
		assertTrue(setString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value already present on a set of integers
	 */
	@Test
	public void testAppendExistingIntegerValue() {
		setInt.append(1);
		assertFalse(setInt.get(setInt.size()-1)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value already present on a set of integers
	 */
	@Test
	public void testAppendExistingIntegerSize() {
		setInt.append(1);
		assertTrue(setInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing empty set throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testRemoveAtEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptySet.removeAt(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testRemoveAtNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setInt.removeAt(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testRemoveAtOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setString.removeAt(5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a set of integers
	 */
	@Test
	public void testRemoveAtValidIntegerSize() {
		setInt.removeAt(2);
		setInt.removeAt(1);
		assertTrue(setInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on a set of integers
	 */
	@Test
	public void testRemoveAtValidIntegerValue() {
		setInt.removeAt(2);
		assertTrue(setInt.get(0)==1 && setInt.get(1)==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on a set of strings
	 */
	@Test
	public void testRemoveAtValidStringValue() {
		setString.removeAt(0);
		assertEquals(setString.get(0),"test3");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a set of strings
	 */
	@Test
	public void testRemoveAtValidStringSize() {
		setString.removeAt(1);
		assertTrue(setString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing empty set
	 */
	@Test
	public void testRemoveEmpty() {
		// FIXME should remove on an empty cause an exception or we just ignore?
		emptySet.remove(0);
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on a set of integers
	 */
	@Test
	public void testRemoveValidIntegerValue() {
		setInt.remove(2);
		assertTrue(setInt.get(0)==1 && setInt.get(1)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a set of integers
	 */
	@Test
	public void testRemoveValidIntegerSize() {
		setInt.remove(2);
		setInt.remove(3);
		assertTrue(setInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on a set of strings
	 */
	@Test
	public void testRemoveValidStringValue() {
		setString.remove("test3");
		assertEquals(setString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a set of strings
	 */
	@Test
	public void testRemoveValidStringSize() {
		setString.remove("test3");
		assertTrue(setString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing an invalid value on a set of integers
	 */
	@Test
	public void testRemoveInvalidIntegerValue() {
		setInt.remove(7);
		assertTrue(setInt.get(0)==1 && setInt.get(1)==2 && setInt.get(2)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing an invalid value on a set of integers
	 */
	@Test
	public void testRemoveInvalidIntegerSize() {
		setInt.remove(12);
		assertTrue(setInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing empty set throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testReplaceEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptySet.replace(0,new Object());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testReplaceNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setInt.replace(-1,4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing set throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testReplaceOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		setString.replace(5,"test5");
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a set of integers
	 */
	@Test
	public void testReplaceIntegerValues() {
		setInt.replace(0, 4);
		setInt.replace(2, 6);
		assertTrue(setInt.get(0)==4 && setInt.get(2)==6);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a set of integers
	 */
	@Test
	public void testReplaceIntegerSize() {
		setInt.replace(0, 4);
		setInt.replace(2, 6);
		assertTrue(setInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a set of integers
	 */
	@Test
	public void testReplaceStringSize() {
		setString.replace(0, "test0");
		setString.replace(1, "test1");
		assertTrue(setString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a set of strings
	 */
	@Test
	public void testReplaceStringValues() {
		setString.replace(0, "test0");
		setString.replace(1, "test1");
		assertTrue(setString.get(0).equals("test0") && setString.get(1).equals("test1"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#clear()}.
	 */
	@Test
	public void testClear() {
		// Empty set
		emptySet.clear();
		assertTrue(emptySet.size()==0);
		// Int set
		setInt.clear();
		assertTrue(setInt.size()==0);
		// String set
		setString.clear();
		assertTrue(setString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing null set assignment
	 */
	@Test
	public void testAssignNull() {
		emptySet.assign(null);
		assertTrue(emptySet.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty set assignment
	 */
	@Test
	public void testAssignEmptySize() {
		ISet<Object> emptySet2 = AOFFactory.INSTANCE.createSet();
		emptySet.assign(emptySet2);
		assertTrue(emptySet.size()==emptySet2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of integer set assignment
	 */
	@Test
	public void testAssignSetIntegerValues() {
		ISet<Integer> setInt2 = AOFFactory.INSTANCE.createSet(4,5,6);
		setInt.assign(setInt2);
		assertTrue(setInt.get(setInt.size()-1)==setInt2.get(setInt2.size()-1) &&
				setInt.get(setInt.size()-2)==setInt2.get(setInt2.size()-2) &&
				setInt.get(setInt.size()-3)==setInt2.get(setInt2.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of integer set assignment
	 */
	@Test
	public void testAssignSetIntegerSize() {
		ISet<Integer> setInt2 = AOFFactory.INSTANCE.createSet(4,5,6);
		setInt.assign(setInt2);
		assertTrue(setInt.size()==setInt2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of string set assignment
	 */
	@Test
	public void testAssignSetStringValues() {
		ISet<String> setString2 = AOFFactory.INSTANCE.createSet("test");
		setString.assign(setString2);
		assertEquals(setString.get(setString.size()-1),setString2.get(setString2.size()-1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of string set assignment
	 */
	@Test
	public void testAssignSettringSize() {
		ISet<String> setString2 = AOFFactory.INSTANCE.createSet("test");
		setString.assign(setString2);
		assertTrue(setString.size()==setString2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of ordered set to set assignment
	 */
	@Test
	public void testAssignOSetToSetSize() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		setInt.assign(osetInt);
		assertTrue(setInt.size()==osetInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of ordered set to set assignment
	 */
	@Test
	public void testAssignOSetToSetValues() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		setInt.assign(osetInt);
		assertTrue(setInt.get(setInt.size()-1)==osetInt.get(osetInt.size()-1) &&
				setInt.get(setInt.size()-2)==osetInt.get(osetInt.size()-2) &&
				setInt.get(setInt.size()-3)==osetInt.get(osetInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of bag to set assignment
	 */
	@Test
	public void testAssignBagToSetSize() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(4,5,6);
		setInt.assign(bagInt);
		assertTrue(setInt.size()==bagInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of bag to set assignment
	 */
	@Test
	public void testAssignBagToSetValues() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(4,5,6);
		setInt.assign(bagInt);
		assertTrue(setInt.get(setInt.size()-1)==bagInt.get(bagInt.size()-1) &&
				setInt.get(setInt.size()-2)==bagInt.get(bagInt.size()-2) &&
				setInt.get(setInt.size()-3)==bagInt.get(bagInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of sequence to set assignment
	 */
	@Test
	public void testAssignSeqToSetSize() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		setInt.assign(seqInt);
		assertTrue(setInt.size()==seqInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of sequence to set assignment
	 */
	@Test
	public void testAssignSeqToSetValues() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		setInt.assign(seqInt);
		assertTrue(setInt.get(setInt.size()-1)==seqInt.get(seqInt.size()-1) &&
				setInt.get(setInt.size()-2)==seqInt.get(seqInt.size()-2) &&
				setInt.get(setInt.size()-3)==seqInt.get(seqInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of one to set assignment
	 */
	@Test
	public void testAssignOneToSetSize() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		setInt.assign(oneInt);
		assertTrue(setInt.size()==oneInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of one to set assignment
	 */
	@Test
	public void testAssignOneToSetValues() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		setInt.assign(oneInt);
		assertTrue(setInt.get(setInt.size()-1)==oneInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty option to set assignment
	 */
	@Test
	public void testAssignEmptyOptionToSetSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption();
		setInt.assign(optionInt);
		assertTrue(setInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of option to set assignment
	 */
	@Test
	public void testAssignOptionToSetSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(6);
		setInt.assign(optionInt);
		assertTrue(setInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of option to set assignment
	 */
	@Test
	public void testAssignOptionToSetValues() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(8);
		setInt.assign(optionInt);
		assertTrue(setInt.get(setInt.size()-1)==optionInt.get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size of adding a new observer to a set
	 */
	@Test
	public void testAddObserverSize() {
		int setIntObserversSize = setInt.getObservers().size();
		setInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(setInt.getObservers().size() == setIntObserversSize+1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when adding a new observer to a set
	 */
	@Test
	public void testAddObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		setInt.addObserver(dov);
		assertTrue(setInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size when removing an observer from a set
	 */
	@Test
	public void testRemoveObserverSize() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		setInt.addObserver(dov);
		int setIntObserversSize = setInt.getObservers().size();
		setInt.removeObserver(dov);
		assertTrue(setInt.getObservers().size() == setIntObserversSize-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when removing an observer from a set
	 */
	@Test
	public void testRemoveObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		setInt.removeObserver(dov);
		assertFalse(setInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is empty
	 */
	@Test
	public void testGetEmptyObserversSize() {
		assertTrue(setInt.getObservers().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is not empty
	 */
	@Test
	public void testGetObserversSize() {
		setInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		setInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		setInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(setInt.getObservers().size()==3);
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
		setInt.addObserver(dov2);
		setInt.addObserver(dov1);
		setInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		setInt.addObserver(dov3);
		assertTrue(setInt.getObservers().contains(dov1) && setInt.getObservers().contains(dov2) && setInt.getObservers().contains(dov3));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#bind(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing size of the observers
	 */
	@Test
	public void testBindObserverSize() {
		//FIXME should we test with an empty option?
		ISet<String> osetString2 = AOFFactory.INSTANCE.createSet("testX","testE");
		setString.bind(osetString2);
		assertTrue(osetString2.getObservers().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#inspect(java.lang.String)}.
	 * Testing that inspect returns an object
	 */
	@Test
	public void testInspect() {
		assertNotNull(setInt.inspect("testing set-> "));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#apply(org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testApply() {
		assertNotNull(setInt.apply(new IUnaryFunction<Integer,Integer>() {
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
		assertNotNull(setString.map(new IUnaryFunction<String,String>(){
			public String apply(String s){
				return s.toUpperCase();
			}
		}));
	}
}
