/*
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus (CEA) - initial API and implementation
 *  Christian W. Damus - bugs 465416, 474467
 */
package org.eclipse.papyrus.infra.gmfdiag.common.tests;

import org.eclipse.papyrus.infra.gmfdiag.common.providers.tests.NotationLabelProviderTest;
import org.eclipse.papyrus.infra.gmfdiag.common.sync.tests.SyncTests;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafeTest;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Master test suite for this test fragment.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		// {oep.commands}
		LoadExpansionModel.class,
		ExpansionAddCompartment.class,
		ExpansionAddChildLabel.class,
		ExpansionAddBorderItem.class,
		ExpansionAddCompartmentWithKind.class,
		ExpansionAddLink.class,
		ExpansionDropElements.class,
		AssistantUsage.class,
		GMFUnsafeTest.class,
		SyncTests.class,
		NotationLabelProviderTest.class,
})
public class AllTests {

}
