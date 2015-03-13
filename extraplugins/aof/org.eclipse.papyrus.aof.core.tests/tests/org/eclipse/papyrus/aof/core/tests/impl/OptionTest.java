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

public class OptionTest {

	public IOption<Integer> optionInt;
	public IOption<Object> emptyOption;
	public IOption<String> optionString;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		optionInt = AOFFactory.INSTANCE.createOption(7);
		emptyOption = AOFFactory.INSTANCE.createOption();
		optionString = AOFFactory.INSTANCE.createOption("test1");
	}

	@After
	public void tearDown() throws Exception {
		optionInt = null;
		emptyOption = null;
		optionString = null;
	}

	@Test
	public void testGetType() {
		assertEquals(optionInt.getType(),BoxType.OPTION);
		assertEquals(emptyOption.getType(),BoxType.OPTION);
		assertEquals(optionString.getType(),BoxType.OPTION);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(optionInt.isOptional());
		assertTrue(emptyOption.isOptional());
		assertTrue(optionString.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertTrue(optionInt.isSingleton());
		assertTrue(emptyOption.isSingleton());
		assertTrue(optionString.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertTrue(optionInt.isOrdered());
		assertTrue(emptyOption.isOrdered());
		assertTrue(optionString.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertTrue(optionInt.isUnique());
		assertTrue(emptyOption.isUnique());
		assertTrue(optionString.isUnique());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing empty option throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testGetEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		assertNotNull(emptyOption.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testGetNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionInt.get(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testGetOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionString.get(5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on an option of integers
	 */
	@Test
	public void testGetValidIntegerValue() {
		assertTrue(optionInt.get(0)==7);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on an option of strings
	 */
	@Test
	public void testGetValidStringValue() {
		assertEquals(optionString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(optionInt.size()==1);
		assertTrue(emptyOption.size()==0);
		assertTrue(optionString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing empty option
	 */
	@Test
	public void testIndexOfEmpty() {
		assertTrue(emptyOption.indexOf(new Object())==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for a valid value on an option of integers
	 */
	@Test
	public void testIndexOfValidIntegerValue() {
		assertTrue(optionInt.indexOf(7)==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for a valid value on an option of strings
	 */
	@Test
	public void testIndexOfValidStringValue() {
		assertTrue(optionString.indexOf("test1")==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for an invalid value on an option of integers
	 */
	@Test
	public void testIndexOfInvalidIntegerValue() {
		assertTrue(optionInt.indexOf(4)==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing value when looking for an invalid value on an option of strings
	 */
	@Test
	public void testIndexOfInvalidStringValue() {
		assertTrue(optionString.indexOf("test5")==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing value for empty option
	 */
	@Test
	public void testAddEmptyValue() {
		emptyOption.add(0,new Object());
		assertNotNull(emptyOption.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size for empty option
	 */
	@Test
	public void testAddEmptySize() {
		emptyOption.add(0,new Object());
		assertTrue(emptyOption.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testAddNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionInt.add(-1,5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testAddOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionString.add(1,"test5");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on an option of integers
	 */
	@Test
	public void testAddValidIntegerSize() {
		optionInt.add(0,6);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on an option of integers
	 */
	@Test
	public void testAddValidIntegerValue() {
		optionInt.add(0,4);
		assertTrue(optionInt.get(0)==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on an option of strings
	 */
	@Test
	public void testAddValidStringValue() {
		optionString.add(0,"test0");
		assertEquals(optionString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on an option of strings
	 */
	@Test
	public void testAddValidStringSize() {
		optionString.add(0,"test6");
		assertTrue(optionString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value already present on an option of integers
	 */
	@Test
	public void testAddExistingIntegerValue() {
		optionInt.add(0,7);
		assertTrue(optionInt.get(0)==7);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value already present on an option of integers
	 */
	@Test
	public void testAddExistingIntegerSize() {
		optionInt.add(0,7);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an empty one
	 */
	@Test
	public void testAppendEmpty() {
		emptyOption.append(new Object());
		assertTrue(emptyOption.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on an option of integers
	 */
	@Test
	public void testAppendIntegerValue() {
		optionInt.append(5);
		assertTrue(optionInt.get(0)==5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an option of integers
	 */
	@Test
	public void testAppendIntegerSize() {
		optionInt.append(8);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on an option of strings
	 */
	@Test
	public void testAppendStringValue() {
		optionString.append("test2");
		assertTrue(optionString.get(0).equals("test2"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an option of strings
	 */
	@Test
	public void testAppendStringSize() {
		optionString.append("test2");
		assertTrue(optionString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value already present on an option of integers
	 */
	@Test
	public void testAppendExistingIntegerValue() {
		optionInt.append(7);
		assertTrue(optionInt.get(0)==7);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value already present on an option of integers
	 */
	@Test
	public void testAppendExistingIntegerSize() {
		optionInt.append(7);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing empty option throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testRemoveAtEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyOption.removeAt(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testRemoveAtNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionInt.removeAt(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testRemoveAtOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionString.removeAt(5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on an option of integers
	 */
	@Test
	public void testRemoveAtValidIntegerSize() {
		optionInt.removeAt(0);
		assertTrue(optionInt.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing option should throw {@link java.lang.IndexOutOfBoundsException}} when removing a valid position
	 */
	@Test
	public void testRemoveAtValidIntegerValue() {
		optionInt.removeAt(0);
		thrown.expect(IndexOutOfBoundsException.class);
		optionInt.get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing option should throw {@link java.lang.IndexOutOfBoundsException}} when removing a valid position
	 */
	@Test
	public void testRemoveAtValidStringValue() {
		optionString.removeAt(0);
		thrown.expect(IndexOutOfBoundsException.class);
		optionString.get(0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on an option of strings
	 */
	@Test
	public void testRemoveAtValidStringSize() {
		optionString.removeAt(0);
		assertTrue(optionString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing default option
	 */
	@Test
	public void testRemoveEmpty() {
		// FIXME should remove on an empty cause an exception or we just ignore?
		emptyOption.remove(0);
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing option should throw {@link java.lang.IndexOutOfBoundsException}} when removing a valid integer
	 */
	@Test
	public void testRemoveValidIntegerValue() {
		optionInt.remove(7);
		thrown.expect(IndexOutOfBoundsException.class);
		optionInt.get(0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on an option of integers
	 */
	@Test
	public void testRemoveValidIntegerSize() {
		optionInt.remove(7);
		assertTrue(optionInt.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing option should throw {@link java.lang.IndexOutOfBoundsException}} when removing a valid string
	 */
	@Test
	public void testRemoveValidStringValue() {
		optionString.remove("test1");
		thrown.expect(IndexOutOfBoundsException.class);
		assertFalse(optionString.get(0).equals("test1"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on an option of strings
	 */
	@Test
	public void testRemoveValidStringSize() {
		optionString.remove("test1");
		assertTrue(optionString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing an invalid value on an option of integers
	 */
	@Test
	public void testRemoveInvalidIntegerValue() {
		optionInt.remove(1);
		assertTrue(optionInt.get(0)==7);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing an invalid value on an option of integers
	 */
	@Test
	public void testRemoveInvalidIntegerSize() {
		optionInt.remove(12);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing default option throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testReplaceEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptyOption.replace(0,new Object());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testReplaceNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionInt.replace(-1,4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing option throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testReplaceOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		optionString.replace(5,"test5");
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on an option of integers
	 */
	@Test
	public void testReplaceIntegerValues() {
		optionInt.replace(0, 4);
		assertTrue(optionInt.get(0)==4);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on an option of integers
	 */
	@Test
	public void testReplaceIntegerSize() {
		optionInt.replace(0, 4);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on an option of integers
	 */
	@Test
	public void testReplaceStringSize() {
		optionString.replace(0, "test0");
		assertTrue(optionString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on an option of strings
	 */
	@Test
	public void testReplaceStringValues() {
		optionString.replace(0, "test0");
		assertEquals(optionString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#clear()}.
	 */
	@Test
	public void testClear() {
		// Empty Option
		emptyOption.clear();
		assertTrue(emptyOption.size()==0);
		// Option Int
		optionInt.clear();
		assertTrue(optionInt.size()==0);
		// Option String
		optionString.clear();
		assertTrue(optionString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing null option assignment throws {@link java.lang.NullPointerException}}
	 */
	@Test
	public void testAssignNull() {
		thrown.expect(NullPointerException.class);
		emptyOption.assign(null);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty option assignment
	 */
	@Test
	public void testAssignEmptySize() {
		IOption<Object> emptyOption2 = AOFFactory.INSTANCE.createOption();
		emptyOption.assign(emptyOption2);
		assertTrue(emptyOption.size()==emptyOption2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of integer option assignment
	 */
	@Test
	public void testAssignOptionIntegerValues() {
		IOption<Integer> optionInt2 = AOFFactory.INSTANCE.createOption(8);
		optionInt.assign(optionInt2);
		assertTrue(optionInt.get(0)==optionInt2.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of integer option assignment
	 */
	@Test
	public void testAssignOptionIntegerSize() {
		IOption<Integer> optionInt2 = AOFFactory.INSTANCE.createOption(2);
		optionInt.assign(optionInt2);
		assertTrue(optionInt.size()==optionInt2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of string option assignment
	 */
	@Test
	public void testAssignOptionStringValues() {
		IOption<String> optionString2 = AOFFactory.INSTANCE.createOption("test");
		optionString.assign(optionString2);
		assertEquals(optionString.get(0),optionString2.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of string option assignment
	 */
	@Test
	public void testAssignOptionStringSize() {
		IOption<String> optionString2 = AOFFactory.INSTANCE.createOption("test");
		optionString.assign(optionString2);
		assertTrue(optionString.size()==optionString2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of set to option assignment
	 */
	@Test
	public void testAssignSetToOptionSize() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		optionInt.assign(setInt);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of set to option assignment
	 */
	@Test
	public void testAssignSetToOptionValues() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		optionInt.assign(setInt);
		assertTrue(optionInt.get(0)==setInt.get(2));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of ordered set to option assignment
	 */
	@Test
	public void testAssignOSetToOptionSize() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		optionInt.assign(osetInt);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of ordered set to option assignment
	 */
	@Test
	public void testAssignOSetToOptionValues() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		optionInt.assign(osetInt);
		assertTrue(optionInt.get(0)==osetInt.get(2));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of sequence to option assignment
	 */
	@Test
	public void testAssignSeqToOptionSize() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		optionInt.assign(seqInt);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of sequence to option assignment
	 */
	@Test
	public void testAssignSeqToOptionValues() {
		ISequence<Integer> seqInt = AOFFactory.INSTANCE.createSequence(4,5,6);
		optionInt.assign(seqInt);
		assertTrue(optionInt.get(0)==seqInt.get(2));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of bag to option assignment
	 */
	@Test
	public void testAssignBagToOptionSize() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(6,7);
		optionInt.assign(bagInt);
		assertTrue(optionInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of bag to option assignment
	 */
	@Test
	public void testAssignBagToOptionValues() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(6,7);
		optionInt.assign(bagInt);
		assertTrue(optionInt.get(0)==bagInt.get(1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of default one to option assignment
	 */
	@Test
	public void testAssignDefaultOneToOptionSize() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(null);
		optionInt.assign(oneInt);
		assertTrue(optionInt.size()==oneInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of one to option assignment
	 */
	@Test
	public void testAssignOneToOptionSize() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		optionInt.assign(oneInt);
		assertTrue(optionInt.size()==oneInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of one to option assignment
	 */
	@Test
	public void testAssignOneToOptionValues() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(8);
		optionInt.assign(oneInt);
		assertTrue(optionInt.get(0)==oneInt.get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size of adding a new observer to an option
	 */
	@Test
	public void testAddObserverSize() {
		int optionIntObserversSize = optionInt.getObservers().size();
		optionInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(optionInt.getObservers().size() == optionIntObserversSize+1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when adding a new observer to an option
	 */
	@Test
	public void testAddObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		optionInt.addObserver(dov);
		assertTrue(optionInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size when removing an observer from an option
	 */
	@Test
	public void testRemoveObserverSize() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		optionInt.addObserver(dov);
		int optionIntObserversSize = optionInt.getObservers().size();
		optionInt.removeObserver(dov);
		assertTrue(optionInt.getObservers().size() == optionIntObserversSize-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when removing an observer from an option
	 */
	@Test
	public void testRemoveObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		optionInt.removeObserver(dov);
		assertFalse(optionInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is empty
	 */
	@Test
	public void testGetEmptyObserversSize() {
		assertTrue(optionInt.getObservers().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is not empty
	 */
	@Test
	public void testGetObserversSize() {
		optionInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		optionInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		optionInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(optionInt.getObservers().size()==3);
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
		optionInt.addObserver(dov2);
		optionInt.addObserver(dov1);
		optionInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		optionInt.addObserver(dov3);
		assertTrue(optionInt.getObservers().contains(dov1) && optionInt.getObservers().contains(dov2) && optionInt.getObservers().contains(dov3));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#bind(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing size of the observers
	 */
	@Test
	public void testBindObserverSize() {
		//FIXME should we test with an empty option?
		IOption<String> optionString2 = AOFFactory.INSTANCE.createOption("testX");
		optionString.bind(optionString2);
		assertTrue(optionString2.getObservers().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#inspect(java.lang.String)}.
	 * Testing that inspect returns an object
	 */
	@Test
	public void testInspect() {
		assertNotNull(optionInt.inspect("testing option-> "));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#apply(org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testApply() {
		assertNotNull(optionInt.apply(new IUnaryFunction<Integer,Integer>() {
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
		assertNotNull(optionString.map(new IUnaryFunction<String,String>(){
			public String apply(String s){
				return s.toUpperCase();
			}
		}));
	}

}
