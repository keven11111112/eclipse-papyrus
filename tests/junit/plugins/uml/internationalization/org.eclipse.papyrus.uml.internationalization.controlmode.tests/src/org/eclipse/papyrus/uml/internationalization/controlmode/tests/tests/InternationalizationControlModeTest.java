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

package org.eclipse.papyrus.uml.internationalization.controlmode.tests.tests;

import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.junit.Test;

/**
 * This allows to test the internationalization during the control mode.
 */
@SuppressWarnings("nls")
public class InternationalizationControlModeTest extends AbstractInternationalizationControlModeTest {

	/**
	 * Constructor.
	 */
	public InternationalizationControlModeTest() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.internationalization.tests.tests.AbstractUMLInternationalizationTest#getSourcePath()
	 */
	@Override
	protected String getSourcePath() {
		return "resources/controlmode/";
	}

	/**
	 * This allows to test the control of the class object.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testControlClass() throws Exception {
		checkFrenchLabels();

		control(modelClass, "Class1");
		checkFrenchLabels();

		undo();
		checkFrenchLabels();

		redo();
		checkFrenchLabels();
	}
	
	/**
	 * This allows to test the control of the class object with the language modification preference.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testControlWithLanguageModificationTest() throws Exception{
		checkFrenchLabels();
		
		control(modelClass, "Class1");
		checkFrenchLabels();
		
		InternationalizationPreferencesUtils.setLanguagePreference(modelClass, "en_US");
		checkEnglishLabels();
		
		undo();
		checkEnglishLabels();
		
		redo();
		checkEnglishLabels();
	}

	/**
	 * This allows to test the control of the class object with the use internationalization preference.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Test
	public void testControlWithUseInternationalizationModificationTest() throws Exception{
		checkFrenchLabels();
		
		control(modelClass, "Class1");
		checkFrenchLabels();
		
		InternationalizationPreferencesUtils.setInternationalizationPreference(modelClass, false);
		checkNoLabels();
		
		undo();
		checkNoLabels();
		
		redo();
		checkNoLabels();
	}
}
