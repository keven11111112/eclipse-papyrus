/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.aof.core.tests;


import org.eclipse.papyrus.aof.core.tests.operation.AOFCollectBoxTest;
import org.eclipse.papyrus.aof.core.tests.operation.AsBoxTest;
import org.eclipse.papyrus.aof.core.tests.operation.BindTest;
import org.eclipse.papyrus.aof.core.tests.operation.CollectTest;
import org.eclipse.papyrus.aof.core.tests.operation.CollectToTest;
import org.eclipse.papyrus.aof.core.tests.operation.ConcatTest;
import org.eclipse.papyrus.aof.core.tests.operation.DistinctTest;
import org.eclipse.papyrus.aof.core.tests.operation.InspectTest;
import org.eclipse.papyrus.aof.core.tests.operation.SelectWithMutablePredicateTest;
import org.eclipse.papyrus.aof.core.tests.operation.SelectWithPredicateTest;
import org.eclipse.papyrus.aof.core.tests.operation.SelectWithPresenceTest;
import org.eclipse.papyrus.aof.core.tests.operation.SizeTest;
import org.eclipse.papyrus.aof.core.tests.operation.SwitchCollectTest;
import org.eclipse.papyrus.aof.core.tests.operation.ZipWithTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A test suite for the '<em><b>AOF Core</b></em>'.
 */
@RunWith(Suite.class)
@SuiteClasses({ AOFCollectBoxTest.class, AOFFactoryTest.class, AOFMetaClassTest.class, AsBoxTest.class, BindTest.class, BoxTest.class, CollectTest.class, CollectToTest.class, ConcatTest.class, ConstraintsTest.class, DistinctTest.class,
		InspectTest.class, ObserverTest.class, ReadableTest.class, SelectWithMutablePredicateTest.class, SelectWithPredicateTest.class, SelectWithPresenceTest.class, SizeTest.class, SwitchCollectTest.class, WritableTest.class, ZipWithTest.class })
public class AllTests {

}
