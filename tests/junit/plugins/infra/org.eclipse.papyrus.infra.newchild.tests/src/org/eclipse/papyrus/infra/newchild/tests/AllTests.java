/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.newchild.tests;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(ClassificationSuite.class)
@SuiteClasses({
		DeployUndeployTests.class,
		NewChildExtensionPointTests.class,
})
public class AllTests {
	// Noting to do
}
