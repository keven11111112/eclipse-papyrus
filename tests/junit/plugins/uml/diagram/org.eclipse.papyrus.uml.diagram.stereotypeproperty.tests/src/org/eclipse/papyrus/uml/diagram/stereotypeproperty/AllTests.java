/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotypeproperty;

import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.creation.TestCreationReopen2Comment;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(Suite.class)
@SuiteClasses({
	// canonical
	TestProfileApplication.class,
	TestStereotypeApplication.class,
	TestLayoutWithStereotype.class,
	TestUnapplyProfile2ClosedDiagComment.class,
	TestUnapplyProfile2Comment.class,
	TestLayoutWithStereotypeOnEclipseHIPPInstance.class,
	TestUnapplyStereotypeComment.class,
	TestBadUnapplyProfile2ClosedDiagComment.class,
	TestCreationReopen2Comment.class
})
public class AllTests {

}
