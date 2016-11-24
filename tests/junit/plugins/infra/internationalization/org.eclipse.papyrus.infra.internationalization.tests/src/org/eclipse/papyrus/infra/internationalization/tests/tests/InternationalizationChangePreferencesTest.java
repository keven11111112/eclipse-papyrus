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

import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.junit.Test;

/**
 * This allows to test the internationalization preferences modification.
 */
@SuppressWarnings("nls")
public class InternationalizationChangePreferencesTest extends AbstractInternationalizationTest {

	/**
	 * Constructor.
	 */
	public InternationalizationChangePreferencesTest() {
		super();
	}

	/**
	 * This allows to test the use internationalization preference modification.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testUseInternationalizationModification() throws Exception {
		checkFrenchLabels();
		
		InternationalizationPreferencesUtils.setInternationalizationPreference(diagram, false);
		checkNoLabels();
		
		InternationalizationPreferencesUtils.setInternationalizationPreference(diagram, true);
		checkFrenchLabels();
	}

	/**
	 * This allows to test the language preference modification.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testLanguageModification() throws Exception {
		checkFrenchLabels();
		
		InternationalizationPreferencesUtils.setLanguagePreference(diagram, "en_US");
		checkEnglishLabels();
		
		InternationalizationPreferencesUtils.setLanguagePreference(diagram, "es_ES");
		checkNoLabels();
	}
}
