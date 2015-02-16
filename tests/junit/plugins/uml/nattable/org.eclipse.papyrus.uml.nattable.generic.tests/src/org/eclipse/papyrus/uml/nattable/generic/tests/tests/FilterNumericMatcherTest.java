/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.generic.tests.tests;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

/**
 * This class provides tests for numeric value (integer)
 *
 */
public class FilterNumericMatcherTest extends AbstractFilterMatcherTest {

	private static final int nbElement = 9;
	
	/**
	 * @see org.eclipse.papyrus.uml.nattable.generic.tests.tests.AbstractFilterMatcherTest#initModel()
	 *
	 * @throws Exception
	 */
	@Before
	@Override
	public void initModel() throws Exception {
		Collection<String> additionalModels = new ArrayList<String>();
		additionalModels.add("FilterNumericMatcherTestProfile.profile"); //$NON-NLS-1$
		initModelWithAdditionalModels(additionalModels);
	}
	
	@Test
	public void test1() throws Exception{
		checkFilter("1", 2, 2, nbElement, 1); //$NON-NLS-1$
	}
	
	@Test
	public void test2() throws Exception{
		checkFilter("-1", 2, 2, nbElement, 1); //$NON-NLS-1$
	}
	
	@Test
	public void test3() throws Exception{
		checkFilter(">1", 2, 2, nbElement, 3); //$NON-NLS-1$
	}
	@Test
	public void test4() throws Exception{
		checkFilter(">=1", 2, 2, nbElement, 4); //$NON-NLS-1$
	}
	
	@Test
	public void test5() throws Exception{
		checkFilter("<0", 2, 2, nbElement, 3); //$NON-NLS-1$
	}
	
	@Test
	public void test6() throws Exception{
		checkFilter("<=0", 2, 2, nbElement, 4); //$NON-NLS-1$
	}
	
	@Test
	public void test7() throws Exception{
		checkFilter("=0", 2, 2, nbElement, 1); //$NON-NLS-1$
	}

	@Test
	public void test8() throws Exception{
		checkFilter("<>0", 2, 2, nbElement, 7); //$NON-NLS-1$
	}

}
