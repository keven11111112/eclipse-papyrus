/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.tests.tests;

import org.junit.Test;

/**
 * This allows to test the labels of different objects and test the
 * internationalization.
 */
@SuppressWarnings("nls")
public class InternationalizationLabelProviderTest extends AbstractInternationalizationTest {

	/**
	 * Constructor.
	 */
	public InternationalizationLabelProviderTest() {
		super();
	}

	/**
	 * This allows to test the labels of different objects.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testLabels() throws Exception {
		checkFrenchLabels();
	}
}
