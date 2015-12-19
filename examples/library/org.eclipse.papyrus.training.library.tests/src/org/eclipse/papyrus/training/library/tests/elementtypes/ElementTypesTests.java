/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.training.library.tests.elementtypes;

import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.junit.utils.tests.AbstractEMFResourceTest;
import org.junit.Test;

/**
 * Test the element types model :
 * - validate the model
 */
public class ElementTypesTests extends AbstractEMFResourceTest {

	public static final String PATH = org.eclipse.papyrus.training.library.elementtypes.Activator.PLUGIN_ID + "/model/extLibrary.elementtypesconfigurations"; // $NON-NLS-0$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFileUri() {
		return PATH;
	}

	@Test
	@FailingTest
	public void validateResource() {
		doValidateResource();
	}

}