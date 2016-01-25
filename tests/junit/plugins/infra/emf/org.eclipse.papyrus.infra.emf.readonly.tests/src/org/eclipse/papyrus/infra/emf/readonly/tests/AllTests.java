/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA, Christian W. Damus, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus (CEA) - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly.tests;

import org.eclipse.papyrus.infra.emf.readonly.PapyrusROTransactionalEditingDomainTest;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManagerTest;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyTesterTest;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.junit.framework.runner.Headless;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Master test suite.
 */
@Headless
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		PapyrusROTransactionalEditingDomainTest.class, ReadOnlyManagerTest.class, ReadOnlyTesterTest.class
})
public class AllTests {

}
