/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 464647
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.test;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite.DynamicClasses;
import org.eclipse.papyrus.uml.diagram.composite.test.canonical.AllCanonicalTests;
import org.eclipse.papyrus.uml.diagram.composite.test.model.AllModelTests;
import org.eclipse.papyrus.uml.diagram.composite.test.resources.ModelValidationTest;
import org.eclipse.papyrus.uml.diagram.composite.tests.copyPaste.ConstraintCopyPasteTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		// canonical
		AllCanonicalTests.class,
		RoundedCompartmentTest.class,
		AllModelTests.class,
		ConstraintCopyPasteTest.class,
		ModelValidationTest.class
})
@DynamicClasses("org.eclipse.papyrus.uml.diagram.composite.test.AllGenTests")
public class AllTests {
}
