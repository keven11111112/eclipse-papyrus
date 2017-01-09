/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.internationalization.tests.tests;

import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.junit.Test;

/**
 * This allows to test the internationalization preferences modification.
 */
@SuppressWarnings("nls")
@PluginResource({ "resources/internationalizationModel.di", "resources/internationalizationModel_en_US.properties", "resources/internationalizationModel_fr_FR.properties"})
public class UMLInternationalizationChangePreferencesTest extends AbstractUMLInternationalizationTest {

	/**
	 * Constructor.
	 */
	public UMLInternationalizationChangePreferencesTest() {
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

		InternationalizationPreferencesUtils.setInternationalizationPreference(model, false);
		checkNoLabels();

		InternationalizationPreferencesUtils.setInternationalizationPreference(model, true);
		checkFrenchLabels();
	}
}
