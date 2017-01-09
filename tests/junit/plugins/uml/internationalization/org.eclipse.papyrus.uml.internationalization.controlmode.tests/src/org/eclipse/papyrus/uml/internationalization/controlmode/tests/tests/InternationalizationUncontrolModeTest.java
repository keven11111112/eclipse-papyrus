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

package org.eclipse.papyrus.uml.internationalization.controlmode.tests.tests;

import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.junit.Test;

/**
 * This allows to test the internationalization during the uncontrol mode.
 */
@SuppressWarnings("nls")
@PluginResource({"resources/controlmode/internationalizationModel.di", "resources/controlmode/internationalizationModel_en_US.properties", "resources/controlmode/internationalizationModel_fr_FR.properties"})
public class InternationalizationUncontrolModeTest extends AbstractInternationalizationControlModeTest {

	/**
	 * Constructor.
	 */
	public InternationalizationUncontrolModeTest() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.internationalization.tests.tests.AbstractUMLInternationalizationTest#initTest()
	 */
	@Override
	public void initTest() throws Exception {
		super.initTest();

		control(modelClass, "Class1");
	}

	/**
	 * This allows to test the uncontrol of the class object.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testUncontrolClass() throws Exception {
		checkFrenchLabels();

		uncontrol(modelClass);
		checkFrenchLabels();

		undo();
		checkFrenchLabels();

		redo();
		checkFrenchLabels();
	}

	/**
	 * This allows to test the uncontrol of the class object with the language
	 * modification preference.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testUncontrolWithLanguageModificationTest() throws Exception {
		checkFrenchLabels();

		InternationalizationPreferencesUtils.setLanguagePreference(model, "en_US");
		uncontrol(modelClass);
		checkEnglishLabels();

		undo();
		checkEnglishLabels();

		redo();
		checkEnglishLabels();
	}

	/**
	 * This allows to test the uncontrol of the class object with the use
	 * internationalization preference.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testUncontrolWithUseInternationalizationModificationTest() throws Exception {
		checkFrenchLabels();

		InternationalizationPreferencesUtils.setInternationalizationPreference(modelClass, false);
		uncontrol(modelClass);
		checkNoLabels();

		undo();
		checkNoLabels();

		redo();
		checkNoLabels();
	}

}
