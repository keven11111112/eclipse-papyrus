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

public class SeqTest {

	public ISequence<Integer> seqInt;
	public ISequence<Object> emptySeq;
	public ISequence<String> seqString;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		seqInt = AOFFactory.INSTANCE.createSequence(1,2,3);
		emptySeq = AOFFactory.INSTANCE.createSequence();
		seqString = AOFFactory.INSTANCE.createSequence("test1","test3");
	}

	@After
	public void tearDown() throws Exception {
		seqInt = null;
		emptySeq = null;
		seqString = null;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Set#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(seqInt.getType(),BoxType.SEQUENCE);
		assertEquals(emptySeq.getType(),BoxType.SEQUENCE);
		assertEquals(seqString.getType(),BoxType.SEQUENCE);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOptional()}.
	 */
	@Test
	public void testIsOptional() {
		assertTrue(seqInt.isOptional());
		assertTrue(emptySeq.isOptional());
		assertTrue(seqString.isOptional());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isSingleton()}.
	 */
	@Test
	public void testIsSingleton() {
		assertFalse(seqInt.isSingleton());
		assertFalse(emptySeq.isSingleton());
		assertFalse(seqString.isSingleton());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isOrdered()}.
	 */
	@Test
	public void testIsOrdered() {
		assertTrue(seqInt.isOrdered());
		assertTrue(emptySeq.isOrdered());
		assertTrue(seqString.isOrdered());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#isUnique()}.
	 */
	@Test
	public void testIsUnique() {
		assertFalse(seqInt.isUnique());
		assertFalse(emptySeq.isUnique());
		assertFalse(seqString.isUnique());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing empty sequence throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testGetEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptySeq.get(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testGetNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqInt.get(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testGetOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqString.get(5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a sequence of integers
	 */
	@Test
	public void testGetValidIntegerValue() {
		assertTrue(seqInt.get(2)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#get(int)}.
	 * Testing values when getting a valid position on a sequence of strings
	 */
	@Test
	public void testGetValidStringValue() {
		assertEquals(seqString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(seqInt.size()==3);
		assertTrue(emptySeq.size()==0);
		assertTrue(seqString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing empty sequence
	 */
	@Test
	public void testIndexOfEmpty() {
		assertTrue(emptySeq.indexOf(new Object())==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on a sequence of integers
	 */
	@Test
	public void testIndexOfValidIntegerValue() {
		assertTrue(seqInt.indexOf(1)==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for a valid value on a sequence of strings
	 */
	@Test
	public void testIndexOfValidStringValue() {
		assertTrue(seqString.indexOf("test3")==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on a sequence of integers
	 */
	@Test
	public void testIndexOfInvalidIntegerValue() {
		assertTrue(seqInt.indexOf(4)==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#indexOf(java.lang.Object)}.
	 * Testing values when looking for an invalid value on a sequence of strings
	 */
	@Test
	public void testIndexOfInvalidStringValue() {
		assertTrue(seqString.indexOf("test5")==-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing value for empty sequence
	 */
	@Test
	public void testAddEmptyValue() {
		emptySeq.add(0,new Object());
		assertNotNull(emptySeq.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size for empty sequence
	 */
	@Test
	public void testAddEmptySize() {
		emptySeq.add(0,new Object());
		assertTrue(emptySeq.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testAddNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqInt.add(-1,5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testAddOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqString.add(5,"test5");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a sequence of integers
	 */
	@Test
	public void testAddValidIntegerSize() {
		seqInt.add(2,4);
		seqInt.add(1,6);
		assertTrue(seqInt.size()==5);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a sequence of integers
	 */
	@Test
	public void testAddValidIntegerValue() {
		seqInt.add(2,4);
		assertTrue(seqInt.get(2)==4 && seqInt.get(3)==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value in a valid position on a sequence of strings
	 */
	@Test
	public void testAddValidStringValue() {
		seqString.add(0,"test0");
		assertEquals(seqString.get(0),"test0");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value in a valid position on a sequence of strings
	 */
	@Test
	public void testAddValidStringSize() {
		seqString.add(1,"test6");
		assertTrue(seqString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing values when adding a value already present on a sequence of integers
	 */
	@Test
	public void testAddExistingIntegerValue() {
		seqInt.add(0,1);
		assertTrue(seqInt.get(0)==1 && seqInt.get(1)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#add(int, java.lang.Object)}.
	 * Testing size when adding a value already present on a sequence of integers
	 */
	@Test
	public void testAddExistingIntegerSize() {
		seqInt.add(1,2);
		assertTrue(seqInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on an empty sequence
	 */
	@Test
	public void testAppendEmpty() {
		emptySeq.append(new Object());
		assertTrue(emptySeq.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a sequence of integers
	 */
	@Test
	public void testAppendIntegerValue() {
		seqInt.append(5);
		assertTrue(seqInt.get(seqInt.size()-1)==5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a sequence of integers
	 */
	@Test
	public void testAppendIntegerSize() {
		seqInt.append(8);
		assertTrue(seqInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value on a sequence of strings
	 */
	@Test
	public void testAppendStringValue() {
		seqString.append("test2");
		assertTrue(seqString.get(seqString.size()-1).equals("test2"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value on a sequence of strings
	 */
	@Test
	public void testAppendStringSize() {
		seqString.append("test2");
		assertTrue(seqString.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing values when appending a value already present on a sequence of integers
	 */
	@Test
	public void testAppendExistingIntegerValue() {
		seqInt.append(1);
		assertTrue(seqInt.get(seqInt.size()-1)==1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#append(java.lang.Object)}.
	 * Testing size when appending a value already present on a sequence of integers
	 */
	@Test
	public void testAppendExistingIntegerSize() {
		seqInt.append(1);
		assertTrue(seqInt.size()==4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing empty sequence throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testRemoveAtEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptySeq.removeAt(0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testRemoveAtNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqInt.removeAt(-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testRemoveAtOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqString.removeAt(5);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a sequence of integers
	 */
	@Test
	public void testRemoveAtValidIntegerSize() {
		seqInt.removeAt(2);
		seqInt.removeAt(1);
		assertTrue(seqInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on a sequence of integers
	 */
	@Test
	public void testRemoveAtValidIntegerValue() {
		seqInt.removeAt(2);
		assertTrue(seqInt.get(0)==1 && seqInt.get(1)==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing values when removing a valid position on a sequence of strings
	 */
	@Test
	public void testRemoveAtValidStringValue() {
		seqString.removeAt(0);
		assertEquals(seqString.get(0),"test3");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeAt(int)}.
	 * Testing size when removing a valid position on a sequence of strings
	 */
	@Test
	public void testRemoveAtValidStringSize() {
		seqString.removeAt(1);
		assertTrue(seqString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing empty sequence
	 */
	@Test
	public void testRemoveEmpty() {
		// FIXME should remove on an empty cause an exception or we just ignore?
		emptySeq.remove(0);
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on a sequence of integers
	 */
	@Test
	public void testRemoveValidIntegerValue() {
		seqInt.remove(2);
		assertTrue(seqInt.get(0)==1 && seqInt.get(1)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a sequence of integers
	 */
	@Test
	public void testRemoveValidIntegerSize() {
		seqInt.remove(2);
		seqInt.remove(3);
		assertTrue(seqInt.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing a valid value on a sequence of strings
	 */
	@Test
	public void testRemoveValidStringValue() {
		seqString.remove("test3");
		assertEquals(seqString.get(0),"test1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing a valid value on a sequence of strings
	 */
	@Test
	public void testRemoveValidStringSize() {
		seqString.remove("test3");
		assertTrue(seqString.size()==1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing values when removing an invalid value on a sequence of integers
	 */
	@Test
	public void testRemoveInvalidIntegerValue() {
		seqInt.remove(7);
		assertTrue(seqInt.get(0)==1 && seqInt.get(1)==2 && seqInt.get(2)==3);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#remove(java.lang.Object)}.
	 * Testing size when removing an invalid value on a sequence of integers
	 */
	@Test
	public void testRemoveInvalidIntegerSize() {
		seqInt.remove(12);
		assertTrue(seqInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing empty sequence throws {@link java.lang.IndexOutOfBoundsException}}
	 */
	@Test
	public void testReplaceEmpty() {
		thrown.expect(IndexOutOfBoundsException.class);
		emptySeq.replace(0,new Object());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a negative index
	 */
	@Test
	public void testReplaceNegativeIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqInt.replace(-1,4);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing sequence throws {@link java.lang.IndexOutOfBoundsException}} for a invalid index
	 */
	@Test
	public void testReplaceOutOfBoundsIndex() {
		thrown.expect(IndexOutOfBoundsException.class);
		seqString.replace(5,"test5");
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a sequence of integers
	 */
	@Test
	public void testReplaceIntegerValues() {
		seqInt.replace(0, 4);
		seqInt.replace(2, 6);
		assertTrue(seqInt.get(0)==4 && seqInt.get(2)==6);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a sequence of integers
	 */
	@Test
	public void testReplaceIntegerSize() {
		seqInt.replace(0, 4);
		seqInt.replace(2, 6);
		assertTrue(seqInt.size()==3);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing size on a sequence of integers
	 */
	@Test
	public void testReplaceStringSize() {
		seqString.replace(0, "test0");
		seqString.replace(1, "test1");
		assertTrue(seqString.size()==2);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#replace(int, java.lang.Object)}.
	 * Testing values on a sequence of strings
	 */
	@Test
	public void testReplaceStringValues() {
		seqString.replace(0, "test0");
		seqString.replace(1, "test1");
		assertTrue(seqString.get(0).equals("test0") && seqString.get(1).equals("test1"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#clear()}.
	 */
	@Test
	public void testClear() {
		// Empty sequence
		emptySeq.clear();
		assertTrue(emptySeq.size()==0);
		// Int sequence
		seqInt.clear();
		assertTrue(seqInt.size()==0);
		// String sequence
		seqString.clear();
		assertTrue(seqString.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing null sequence assignment
	 */
	@Test
	public void testAssignNull() {
		emptySeq.assign(null);
		assertTrue(emptySeq.size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty sequence assignment
	 */
	@Test
	public void testAssignEmptySize() {
		ISequence<Object> emptySeq2 = AOFFactory.INSTANCE.createSequence();
		emptySeq.assign(emptySeq2);
		assertTrue(emptySeq.size()==emptySeq2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of integer sequence assignment
	 */
	@Test
	public void testAssignSetIntegerValues() {
		ISequence<Integer> seqInt2 = AOFFactory.INSTANCE.createSequence(4,5,6);
		seqInt.assign(seqInt2);
		assertTrue(seqInt.get(seqInt.size()-1)==seqInt2.get(seqInt2.size()-1) &&
				seqInt.get(seqInt.size()-2)==seqInt2.get(seqInt2.size()-2) &&
				seqInt.get(seqInt.size()-3)==seqInt2.get(seqInt2.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of integer sequence assignment
	 */
	@Test
	public void testAssignSetIntegerSize() {
		ISequence<Integer> seqInt2 = AOFFactory.INSTANCE.createSequence(4,5,6);
		seqInt.assign(seqInt2);
		assertTrue(seqInt.size()==seqInt2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of string sequence assignment
	 */
	@Test
	public void testAssignSetStringValues() {
		ISequence<String> seqString2 = AOFFactory.INSTANCE.createSequence("test");
		seqString.assign(seqString2);
		assertEquals(seqString.get(seqString.size()-1),seqString2.get(seqString2.size()-1));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of string sequence assignment
	 */
	@Test
	public void testAssignSettringSize() {
		ISequence<String> seqString2 = AOFFactory.INSTANCE.createSequence("test");
		seqString.assign(seqString2);
		assertTrue(seqString.size()==seqString2.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of ordered set to sequence assignment
	 */
	@Test
	public void testAssignOSetToSeqSize() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		seqInt.assign(osetInt);
		assertTrue(seqInt.size()==osetInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of ordered set to sequence assignment
	 */
	@Test
	public void testAssignOSetToSeqValues() {
		IOrderedSet<Integer> osetInt = AOFFactory.INSTANCE.createOrderedSet(4,5,6);
		seqInt.assign(osetInt);
		assertTrue(seqInt.get(seqInt.size()-1)==osetInt.get(osetInt.size()-1) &&
				seqInt.get(seqInt.size()-2)==osetInt.get(osetInt.size()-2) &&
				seqInt.get(seqInt.size()-3)==osetInt.get(osetInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of bag to sequence assignment
	 */
	@Test
	public void testAssignBagToSetSize() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(4,5,6);
		seqInt.assign(bagInt);
		assertTrue(seqInt.size()==bagInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of bag to sequence assignment
	 */
	@Test
	public void testAssignBagToSetValues() {
		IBag<Integer> bagInt = AOFFactory.INSTANCE.createBag(4,5,6);
		seqInt.assign(bagInt);
		assertTrue(seqInt.get(seqInt.size()-1)==bagInt.get(bagInt.size()-1) &&
				seqInt.get(seqInt.size()-2)==bagInt.get(bagInt.size()-2) &&
				seqInt.get(seqInt.size()-3)==bagInt.get(bagInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of set to sequence assignment
	 */
	@Test
	public void testAssignSetToSeqSize() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		seqInt.assign(setInt);
		assertTrue(seqInt.size()==setInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of set to sequence assignment
	 */
	@Test
	public void testAssignSetToSeqValues() {
		ISet<Integer> setInt = AOFFactory.INSTANCE.createSet(4,5,6);
		seqInt.assign(setInt);
		assertTrue(seqInt.get(seqInt.size()-1)==setInt.get(setInt.size()-1) &&
				seqInt.get(seqInt.size()-2)==setInt.get(setInt.size()-2) &&
				seqInt.get(seqInt.size()-3)==setInt.get(setInt.size()-3));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of one to sequence assignment
	 */
	@Test
	public void testAssignOneToSetSize() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		seqInt.assign(oneInt);
		assertTrue(seqInt.size()==oneInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of one to sequence assignment
	 */
	@Test
	public void testAssignOneToSetValues() {
		IOne<Integer> oneInt = AOFFactory.INSTANCE.createOne(6);
		seqInt.assign(oneInt);
		assertTrue(seqInt.get(seqInt.size()-1)==oneInt.get(0));
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of empty option to sequence assignment
	 */
	@Test
	public void testAssignEmptyOptionToSetSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption();
		seqInt.assign(optionInt);
		assertTrue(seqInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing size of option to sequence assignment
	 */
	@Test
	public void testAssignOptionToSetSize() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(6);
		seqInt.assign(optionInt);
		assertTrue(seqInt.size()==optionInt.size());
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#assign(java.lang.Iterable)}.
	 * Testing values of option to sequence assignment
	 */
	@Test
	public void testAssignOptionToSetValues() {
		IOption<Integer> optionInt = AOFFactory.INSTANCE.createOption(8);
		seqInt.assign(optionInt);
		assertTrue(seqInt.get(seqInt.size()-1)==optionInt.get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size of adding a new observer to a sequence
	 */
	@Test
	public void testAddObserverSize() {
		int seqIntObserversSize = seqInt.getObservers().size();
		seqInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(seqInt.getObservers().size() == seqIntObserversSize+1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when adding a new observer to a sequence
	 */
	@Test
	public void testAddObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		seqInt.addObserver(dov);
		assertTrue(seqInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#removeObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing size when removing an observer from a sequence
	 */
	@Test
	public void testRemoveObserverSize() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		seqInt.addObserver(dov);
		int seqIntObserversSize = seqInt.getObservers().size();
		seqInt.removeObserver(dov);
		assertTrue(seqInt.getObservers().size() == seqIntObserversSize-1);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#addObserver(org.eclipse.papyrus.aof.core.IObserver)}.
	 * Testing observer when removing an observer from a sequence
	 */
	@Test
	public void testRemoveObserverValue() {
		DefaultObserver<Integer> dov = new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		}; 
		seqInt.removeObserver(dov);
		assertFalse(seqInt.getObservers().contains(dov));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is empty
	 */
	@Test
	public void testGetEmptyObserversSize() {
		assertTrue(seqInt.getObservers().size()==0);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#getObservers()}.
	 * Testing size when getting observers when the list is not empty
	 */
	@Test
	public void testGetObserversSize() {
		seqInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		seqInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		seqInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		assertTrue(seqInt.getObservers().size()==3);
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
		seqInt.addObserver(dov2);
		seqInt.addObserver(dov1);
		seqInt.addObserver(new DefaultObserver<Integer>(){
			public void created(Iterable<Integer> elements) {
			}
		});
		seqInt.addObserver(dov3);
		assertTrue(seqInt.getObservers().contains(dov1) && seqInt.getObservers().contains(dov2) && seqInt.getObservers().contains(dov3));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#bind(org.eclipse.papyrus.aof.core.IBox)}.
	 * Testing size of the observers
	 */
	@Test
	public void testBindObserverSize() {
		//FIXME should we test with an empty option?
		ISequence<String> oseqString2 = AOFFactory.INSTANCE.createSequence("testX","testE");
		seqString.bind(oseqString2);
		assertTrue(oseqString2.getObservers().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#inspect(java.lang.String)}.
	 * Testing that inspect returns an object
	 */
	@Test
	public void testInspect() {
		assertNotNull(seqInt.inspect("testing sequence-> "));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.core.impl.Box#apply(org.eclipse.papyrus.aof.core.IUnaryFunction)}.
	 */
	@Test
	public void testApply() {
		assertNotNull(seqInt.apply(new IUnaryFunction<Integer,Integer>() {
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
		assertNotNull(seqString.map(new IUnaryFunction<String,String>(){
			public String apply(String s){
				return s.toUpperCase();
			}
		}));
	}
}
