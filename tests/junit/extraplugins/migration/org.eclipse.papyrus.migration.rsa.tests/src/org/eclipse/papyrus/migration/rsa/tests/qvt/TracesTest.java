/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.tests.qvt;


import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.migration.rsa.tests.Activator;
import org.junit.Test;

public class TracesTest extends AbstractTransformationTest {
	private static final String BASE_PATH = "resources/fragments/";

	@Test
	public void testTraces() throws Exception {

		String mainFile = BASE_PATH + "Blank Package.emx";

		String[] additionalFiles = new String[] {
				BASE_PATH + "Class3.efx",
				BASE_PATH + "Interface - Fragment.efx",
				BASE_PATH + "Package - Fragment.efx"
		};

		simpleImport(mainFile, additionalFiles);

		// Don't need to open the editor. The import succeeded
	}

	//
	// Test framework
	//

	@Override
	protected URI[] getAdditionalTransformations() {
		return new URI[] {
				URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/traces/asserttraces.qvto", true),
		};
	}
}
