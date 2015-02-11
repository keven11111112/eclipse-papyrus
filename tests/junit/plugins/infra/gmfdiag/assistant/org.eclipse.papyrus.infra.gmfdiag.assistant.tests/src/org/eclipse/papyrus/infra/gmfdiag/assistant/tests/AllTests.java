/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.assistant.tests;

import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The master test suite for the plug-in.
 */
@RunWith(Suite.class)
@SuiteClasses({ AssistantAllTests.class, //
		GenericModelingAssistantIntegrationTest.class, DiagramSpecificModelingAssistantIntegrationTest.class })
public class AllTests {
	@BeforeClass
	public static void ensureElementTypesRegistry() {
		ElementTypeSetConfigurationRegistry.getInstance();
	}

	@AfterClass
	public static void disposeElementTypesRegistry() {
		ElementTypeSetConfigurationRegistry.getInstance().dispose();
	}
}