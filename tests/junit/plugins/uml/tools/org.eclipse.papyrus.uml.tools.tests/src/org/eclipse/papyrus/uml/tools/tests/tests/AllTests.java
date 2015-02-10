/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 440108
 *  Christian W. Damus - bug 458197
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.tests.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContentProviderTest.class, UMLStereotypePropertyContentProviderTest.class, DependencyManagementTest.class,
		NamedElementValidatorTest.class, StereotypeElementListenerTest.class, ProfileApplicationListenerTest.class

})
public class AllTests {
	// Test suite
}
