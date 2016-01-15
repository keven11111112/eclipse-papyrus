/*****************************************************************************
 * Copyright (c) 2012, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *   Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 431618
 *   Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.ui.tests;

import org.eclipse.papyrus.infra.services.edit.ui.dialogs.tests.TestElementTypeValidator;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Main Test suite.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		TestElementTypeValidator.class,
})
public class AllTests {

}
