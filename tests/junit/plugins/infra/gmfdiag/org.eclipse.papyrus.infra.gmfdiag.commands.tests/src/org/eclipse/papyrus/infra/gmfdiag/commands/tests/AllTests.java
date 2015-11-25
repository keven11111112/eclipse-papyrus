/*
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus (CEA) - initial API and implementation
 *  Christian W. Damus - bug 459746
 *  Christian W. Damus - bug 433206
 */
package org.eclipse.papyrus.infra.gmfdiag.commands.tests;

import org.eclipse.papyrus.commands.NestingNotifyingWorkspaceCommandStackTest;
import org.eclipse.papyrus.commands.NotifyingWorkspaceCommandStackTest;
import org.eclipse.papyrus.commands.util.CommandTreeIteratorTest;
import org.junit.runner.RunWith;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Master test suite for this test fragment.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		// {oep.commands}
		NotifyingWorkspaceCommandStackTest.class, NestingNotifyingWorkspaceCommandStackTest.class,
		// {oep.commands.util}
		CommandTreeIteratorTest.class })
public class AllTests {

}
