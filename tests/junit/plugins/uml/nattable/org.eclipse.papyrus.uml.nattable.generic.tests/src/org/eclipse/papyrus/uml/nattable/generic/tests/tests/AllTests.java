/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.generic.tests.tests;

import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.AddElementsOnConnectedTableTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.AxisChangeIndexWithConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.AxisChangeIndexWithoutConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.InvertedAxisChangeIndexWithConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.InvertedAxisChangeIndexWithoutConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.OpenAndDeleteTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.StereotypeInheritDisplayTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
		SortAxisGenericTableTest.class,
		InvertAxisGenericTableTest.class,
		EditAxisGenericTableTest.class,
		OpenAndDeleteTest.class,
		AddElementsOnConnectedTableTest.class,
		Bug458492_Edition_Enumeration.class,
		AxisChangeIndexWithConfigurationTest.class,
		AxisChangeIndexWithoutConfigurationTest.class,
		InvertedAxisChangeIndexWithConfigurationTest.class,
		InvertedAxisChangeIndexWithoutConfigurationTest.class,
		RevealGenericTableTest.class,
		FilterStringMatcherTest.class,
		FilterEEnumMatcherTest.class,
		FilterNumericMatcherTest.class,
		FilterUMLEnumerationMatcherTest.class,
		
		// Stereotype inherited properties
		StereotypeInheritDisplayTest.class,
})
public class AllTests {
	// JUnit 4 test suite
}
