/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tests;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.uml.properties.modelelement.tests.UMLModelElementTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for the UML Properties bundle.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		UMLModelElementTest.class,
})
public class AllTests {
	// Everything is specified in class annotations
}
