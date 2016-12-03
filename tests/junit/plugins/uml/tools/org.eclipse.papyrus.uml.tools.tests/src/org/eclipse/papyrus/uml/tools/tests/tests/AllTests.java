/*****************************************************************************
 * Copyright (c) 2012, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 440108
 *  Christian W. Damus - bugs 458197, 468030, 485220, 502461, 508629
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.tests.tests;


import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.junit.framework.runner.Headless;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@Headless
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		ContentProviderTest.class,
		UMLStereotypePropertyContentProviderTest.class,
		DependencyManagementTest.class,
		NamedElementValidatorTest.class,
		StereotypeElementListenerTest.class,
		ProfileApplicationListenerTest.class,
		UMLReferenceConverterTest.class,
		UMLReferenceConverterCompletionTest.class,
		UMLLanguageProvidersTest.class,
		IconsStereotypesTest.class,
		CustomizableDelegatingItemLabelProviderTest.class,
		DelegatingItemLabelProviderTest.class,
		UMLCopyTest.class,
})
public class AllTests {
	// Test suite
}
