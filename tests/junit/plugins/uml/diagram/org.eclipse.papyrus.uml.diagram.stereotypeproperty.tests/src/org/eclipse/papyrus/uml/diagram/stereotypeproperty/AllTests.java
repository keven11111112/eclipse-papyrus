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

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.asbrace.TestDisplayAsBrace;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.asbrace.TestReopenAsBrace;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.ascomment.TestDisplayAsComment;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.ascomment.TestReopenAsComment;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.ascompartment.TestDisplayAsCompartment;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.ascompartment.TestReopenAsCompartment;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.displayname.Test2StereotypeApplications;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.displayname.TestStereotypeApplication;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.displayname.TestStereotypeApplicationQualifiedName;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.layout.TestLayoutWithStereotype;
import org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.layout.TestLayoutWithStereotypeOnEclipseHIPPInstance;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		TestBadUnapplyProfile2ClosedDiagComment.class,
		TestDropStereotypedClass.class,
		TestProfileApplication.class,
		TestDisplayAsBrace.class,
		TestReopenAsBrace.class,
		TestDisplayAsComment.class,
		TestReopenAsComment.class,
		TestDisplayAsCompartment.class,
		TestReopenAsCompartment.class,
		Test2StereotypeApplications.class,
		TestStereotypeApplication.class,
		TestStereotypeApplicationQualifiedName.class,
		TestLayoutWithStereotype.class,
		TestLayoutWithStereotypeOnEclipseHIPPInstance.class,

})
public class AllTests {

}
