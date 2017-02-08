/**
 * Copyright (c) 2016, 2017 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.properties.ui.tests;

import org.eclipse.papyrus.infra.properties.ui.providers.tests.PropertiesHeaderLabelProviderTest;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The master test suite for the plug-in.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		PropertiesHeaderLabelProviderTest.class,
		EcorePropertyEditorFactoryTest.class,
})
public class AllTests {

	public AllTests() {
		super();
	}

}
