/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bug 476683
 *
 *****************************************************************************/
package org.eclipse.papyrus.aof.emf.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A test suite for the '<em><b>AOF EMF</b></em>'.
 */
@RunWith(Suite.class)
@SuiteClasses({ EMFAttributesTest.class, EMFReferenceTest.class, EMFCollectBoxTest.class, EMFFactoryTest.class, EMFMetaClassTest.class })
public class AllTests {

}
