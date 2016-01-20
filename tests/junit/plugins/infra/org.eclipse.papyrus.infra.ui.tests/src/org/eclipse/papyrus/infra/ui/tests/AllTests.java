/*
 * Copyright (c) 2014, 2016 CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *
 */
package org.eclipse.papyrus.infra.ui.tests;

import org.eclipse.papyrus.infra.ui.contentoutline.NestedEditorDelegatedOutlinePageTest;
import org.eclipse.papyrus.infra.ui.lifecycleevents.LifeCycleEventsProviderTest;
import org.eclipse.papyrus.infra.ui.lifecycleevents.SaveAndDirtyServiceTest;
import org.eclipse.papyrus.infra.ui.providers.DelegatingPapyrusContentProviderTest;
import org.eclipse.papyrus.infra.ui.providers.SemanticContentProviderFactoryTest;
import org.eclipse.papyrus.infra.ui.util.UIUtilTest;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The master test suite for the plug-in.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({ UIUtilTest.class,
		SaveAndDirtyServiceTest.class,
		LifeCycleEventsProviderTest.class,
		NestedEditorDelegatedOutlinePageTest.class,
		DelegatingPapyrusContentProviderTest.class,
		SemanticContentProviderFactoryTest.class,
})
public class AllTests {

	public AllTests() {
		super();
	}

}
