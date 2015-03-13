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

public class OneTest {

	public IOne<Integer> oneInt;
	public IOne<Object> defaultOne;
	public IOne<String> oneString;
	public Object o;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		o = new Object();
		oneInt = AOFFactory.INSTANCE.createOne(7);
		defaultOne = AOFFactory.INSTANCE.createOne(o);
		oneString = AOFFactory.INSTANCE.createOne("test1");
	}

	@After
	public void tearDown() throws Exception {
		oneInt = null;
		defaultOne = null;
		oneString = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.One#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(oneInt.getType(),BoxType.ONE);
		assertEquals(defaultOne.getType(),BoxType.ONE);
		assertEquals(oneString.getType(),BoxType.ONE);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertFalse(oneInt.isOptional());
		assertFalse(defaultOne.isOptional());
		assertFalse(oneString.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertTrue(oneInt.isSingleton());
		assertTrue(defaultOne.isSingleton());
		assertTrue(oneString.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertTrue(oneInt.isOrdered());
		assertTrue(defaultOne.isOrdered());
		assertTrue(oneString.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(oneInt.isUnique());
		assertTrue(defaultOne.isUnique());
		assertTrue(oneString.isUnique());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing empty one returns a default value
	 */
	@Test
	public void testGetEmpty() {
		assertNotNull(defaultOne.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testGetNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneInt.get(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testGetOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneString.get(5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a one of integers
	 */
	@Test
	public void testGetValidIntegerValue() {
		assertTrue(oneInt.get(0)==7);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a one of strings
	 */
	@Test
	public void testGetValidStringValue() {
		assertEquals(oneString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(oneInt.size()==1);
		assertTrue(defaultOne.size()==1);
		assertTrue(oneString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing empty one
	 */
	@Test
	public void testIndexOfEmpty() {
		assertTrue(defaultOne.indexOf(new Object())==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for a valid value on a one of integers
	 */
	@Test
	public void testIndexOfValidIntegerValue() {
		assertTrue(oneInt.indexOf(7)==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for a valid value on a one of strings
	 */
	@Test
	public void testIndexOfValidStringValue() {
		assertTrue(oneString.indexOf("test1")==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for an invalid value on a one of integers
	 */
	@Test
	public void testIndexOfInvalidIntegerValue() {
		assertTrue(oneInt.indexOf(4)==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for an invalid value on a one of strings
	 */
	@Test
	public void testIndexOfInvalidStringValue() {
		assertTrue(oneString.indexOf("test5")==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing value for empty one
	 */
	@Test
	public void testAddEmptyValue() {
		defaultOne.add(0,new Object());
		assertNotNull(defaultOne.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size for empty one
	 */
	@Test
	public void testAddEmptySize() {
		defaultOne.add(0,new Object());
		assertTrue(defaultOne.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testAddNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneInt.add(-1,5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testAddOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneString.add(1,"test5");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a one of integers
	 */
	@Test
	public void testAddValidIntegerSize() {
		oneInt.add(0,6);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a one of integers
	 */
	@Test
	public void testAddValidIntegerValue() {
		oneInt.add(0,4);
		assertTrue(oneInt.get(0)==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a one of strings
	 */
	@Test
	public void testAddValidStringValue() {
		oneString.add(0,"test0");
		assertEquals(oneString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a one of strings
	 */
	@Test
	public void testAddValidStringSize() {
		oneString.add(0,"test6");
		assertTrue(oneString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value already present on a one of integers
	 */
	@Test
	public void testAddExistingIntegerValue() {
		oneInt.add(0,7);
		assertTrue(oneInt.get(0)==7);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value already present on a one of integers
	 */
	@Test
	public void testAddExistingIntegerSize() {
		oneInt.add(0,7);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an empty one
	 */
	@Test
	public void testAppendEmpty() {
		defaultOne.append(new Object());
		assertTrue(defaultOne.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a one of integers
	 */
	@Test
	public void testAppendIntegerValue() {
		oneInt.append(5);
		assertTrue(oneInt.get(0)==5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a one of integers
	 */
	@Test
	public void testAppendIntegerSize() {
		oneInt.append(8);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a one of strings
	 */
	@Test
	public void testAppendStringValue() {
		oneString.append("test2");
		assertTrue(oneString.get(0).equals("test2"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a one of strings
	 */
	@Test
	public void testAppendStringSize() {
		oneString.append("test2");
		assertTrue(oneString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value already present on a one of integers
	 */
	@Test
	public void testAppendExistingIntegerValue() {
		oneInt.append(7);
		assertTrue(oneInt.get(0)==7);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value already present on a one of integers
	 */
	@Test
	public void testAppendExistingIntegerSize() {
		oneInt.append(7);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing empty one
	 */
	@Test
	public void testRemoveAtEmpty() {
		defaultOne.removeAt(0);
		assertTrue(defaultOne.get(0).equals(o));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testRemoveAtNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneInt.removeAt(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testRemoveAtOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneString.removeAt(5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a one of integers
	 */
	@Test
	public void testRemoveAtValidIntegerSize() {
		oneInt.removeAt(0);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing one value when removing a valid position
	 */
	@Test
	public void testRemoveAtValidIntegerValue() {
		oneInt.removeAt(0);
		assertTrue(oneInt.get(0)==7);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing one value when removing a valid position
	 */
	@Test
	public void testRemoveAtValidStringValue() {
		oneString.removeAt(0);
		assertEquals(oneString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a one of strings
	 */
	@Test
	public void testRemoveAtValidStringSize() {
		oneString.removeAt(0);
		assertTrue(oneString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing default one
	 */
	@Test
	public void testRemoveEmpty() {
		defaultOne.remove(0);
		assertTrue(defaultOne.get(0).equals(defaultOne.getDefaultElement()));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing one value when removing a valid integer
	 */
	@Test
	public void testRemoveValidIntegerValue() {
		oneInt.remove(7);
		assertTrue(oneInt.get(0)==7);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a one of integers - should get the default value
	 */
	@Test
	public void testRemoveValidIntegerSize() {
		oneInt.remove(7);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing one value when removing a valid string
	 */
	@Test
	public void testRemoveValidStringValue() {
		oneString.remove("test1");
		assertTrue(oneString.get(0).equals("test1"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a one of strings - should get the default value
	 */
	@Test
	public void testRemoveValidStringSize() {
		oneString.remove("test1");
		assertTrue(oneString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing an invalid value on a one of integers
	 */
	@Test
	public void testRemoveInvalidIntegerValue() {
		oneInt.remove(1);
		assertTrue(oneInt.get(0)==7);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing an invalid value on a one of integers
	 */
	@Test
	public void testRemoveInvalidIntegerSize() {
		oneInt.remove(12);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing default one value
	 */
	@Test
	public void testReplaceEmpty() {
		Object o = new Object();
		defaultOne.replace(0,o);
		assertTrue(defaultOne.get(0).equals(o));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testReplaceNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneInt.replace(-1,4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing one throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testReplaceOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		oneString.replace(5,"test5");
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a one of integers
	 */
	@Test
	public void testReplaceIntegerValues() {
		oneInt.replace(0, 4);
		assertTrue(oneInt.get(0)==4);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a one of integers
	 */
	@Test
	public void testReplaceIntegerSize() {
		oneInt.replace(0, 4);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a one of integers
	 */
	@Test
	public void testReplaceStringSize() {
		oneString.replace(0, "test0");
		assertTrue(oneString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a one of strings
	 */
	@Test
	public void testReplaceStringValues() {
		oneString.replace(0, "test0");
		assertEquals(oneString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#clear()}.
	 */
	@Test
	public void testClear() {
		// Empty One
		defaultOne.clear();
		assertTrue(defaultOne.size()==0);
		// One Int
		oneInt.clear();
		assertTrue(oneInt.size()==0);
		// One String
		oneString.clear();
		assertTrue(oneString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing null one assignment throws {@link java.lang.NullPointerException}}
	 */
	@Test
	public void testAssignNull() {
		thrown.expect(NullPointerException.class);
		defaultOne.assign(null);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty one assignment
	 */
	@Test
	public void testAssignEmptySize() {
		IOne<Object> defaultOne2 = AOFFactory.INSTANCE.createOne(null);
		defaultOne.assign(defaultOne2);
		assertTrue(defaultOne.size()==defaultOne2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of integer one assignment
	 */
	@Test
	public void testAssignOneIntegerValues() {
		IOne<Integer> oneInt2 = AOFFactory.INSTANCE.createOne(8);
		oneInt.assign(oneInt2);
		assertTrue(oneInt.get(0)==oneInt2.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of integer one assignment
	 */
	@Test
	public void testAssignOneIntegerSize() {
		IOne<Integer> oneInt2 = AOFFactory.INSTANCE.createOne(2);
		oneInt.assign(oneInt2);
		assertTrue(oneInt.size()==oneInt2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of string one assignment
	 */
	@Test
	public void testAssignOneStringValues() {
		IOne<String> oneString2 = AOFFactory.INSTANCE.createOne("test");
		oneString.assign(oneString2);
		assertEquals(oneString.get(0),oneString2.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of string one assignment
	 */
	@Test
	public void testAssignOneStringSize() {
		IOne<String> oneString2 = AOFFactory.INSTANCE.createOne("test");
		oneString.assign(oneString2);
		assertTrue(oneString.size()==oneString2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of set to one assignment
	 */
	@Test
	public void testAssignSetToOneSize() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		oneInt.assign(setInt);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of set to one assignment
	 */
	@Test
	public void testAssignSetToOneValues() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		oneInt.assign(setInt);
		assertTrue(oneInt.get(0)==setInt.get(2));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of ordered set to one assignment
	 */
	@Test
	public void testAssignOSetToOneSize() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		oneInt.assign(osetInt);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of ordered set to one assignment
	 */
	@Test
	public void testAssignOSetToOneValues() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		oneInt.assign(osetInt);
		assertTrue(oneInt.get(0)==osetInt.get(2));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of sequence to one assignment
	 */
	@Test
	public void testAssignSeqToOneSize() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		oneInt.assign(seqInt);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of sequence to one assignment
	 */
	@Test
	public void testAssignSeqToOneValues() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		oneInt.assign(seqInt);
		assertTrue(oneInt.get(0)==seqInt.get(2));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of bag to one assignment
	 */
	@Test
	public void testAssignBagToOneSize() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(6,7);
		oneInt.assign(bagInt);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of bag to one assignment
	 */
	@Test
	public void testAssignBagToOneValues() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(6,7);
		oneInt.assign(bagInt);
		assertTrue(oneInt.get(0)==bagInt.get(1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty option to one assignment
	 */
	@Test
	public void testAssignEmptyOptionToOneSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption();
		oneInt.assign(optionInt);
		assertTrue(oneInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing value of empty option to one assignment
	 */
	@Test
	public void testAssignEmptyOptionToOneValue() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption();
		oneInt.assign(optionInt);
		assertTrue(oneInt.get(0)==7);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of option to one assignment
	 */
	@Test
	public void testAssignOptionToOneSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(6);
		oneInt.assign(optionInt);
		assertTrue(oneInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of option to one assignment
	 */
	@Test
	public void testAssignOptionToOneValues() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(8);
		oneInt.assign(optionInt);
		assertTrue(oneInt.get(0)==optionInt.get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size of adding a new observer to a one
	 */
	@Test
	public void testAddObserverSize() {
		int oneIntObserversSize = oneInt.getObservers().size();
		oneInt.addObserver(new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(oneInt.getObservers().size() == oneIntObserversSize+1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when adding a new observer to a one
	 */
	@Test
	public void testAddObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>() {
			public void created(Iterable<Integer> elements) {
			}
		}; 
		oneInt.addObserver(dov);
		assertTrue(oneInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size when removing an observer from a one
	 */
	@Test
	public void testRemoveObserverSize() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		};
		oneInt.addObserver(dov);
		int oneIntObserversSize = oneInt.getObservers().size();
		oneInt.removeObserver(dov);
		assertTrue(oneInt.getObservers().size() == oneIntObserversSize-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when removing an observer from a one
	 */
	@Test
	public void testRemoveObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		};
		oneInt.removeObserver(dov);
		assertFalse(oneInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is empty
	 */
	@Test
	public void testGetEmptyObserversSize() {
		assertTrue(oneInt.getObservers().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is not empty
	 */
	@Test
	public void testGetObserversSize() {
		oneInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		oneInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		oneInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(oneInt.getObservers().size()==3);
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
		oneInt.addObserver(dov2);
		oneInt.addObserver(dov1);
		oneInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		oneInt.addObserver(dov3);
		assertTrue(oneInt.getObservers().contains(dov1) && oneInt.getObservers().contains(dov2) && oneInt.getObservers().contains(dov3));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#bind(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing size of the observers
	 */
	@Test
	public void testBindObserverSize() {
		IOne<String> oneString2 = AOFFactory.INSTANCE.createOne("testX");
		oneString.bind(oneString2);
		assertTrue(oneString2.getObservers().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#inspect(java.lang.String)}.
	 * Testing that inspect returns an object
	 */
	@Test
	public void testInspect() {
		assertNotNull(oneInt.inspect("testing one-> "));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#apply(org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testApply() {
		assertNotNull(oneInt.apply(new IUnaryFunction<Integer,Integer>() {
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
		assertNotNull(oneString.map(new IUnaryFunction<String,String>(){
			public String apply(String s){
				return s.toUpperCase();
			}
		}));
	}
}
