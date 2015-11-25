/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.tests.testcases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.command.CompleteArchitectureSnapshotCommand;
import org.eclipse.papyrus.adltool.designer.ReverseSettings;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.junit.Assert;
import org.junit.Test;

/**
 * This test case checks the static methods "getWorkspacePlugins" and
 * "getWorkspaceFeatures" of the ADL4EclipseUtils. It also checks if
 * the right exception is thrown when the list of plug-in or feature to
 * reverse is null or empty.
 */
public class TestEmptyWorkspace extends AbstractADLTest {

	@Test
	public void testNoPluginInWorkspace() {
		List<ReversibleProject> workspaceBundles = new ArrayList<>();
		workspaceBundles.addAll(ADL4EclipseUtils.getWorkspacePlugins());

		assertTrue("The workspace should be empty", workspaceBundles.isEmpty());
	}

	@Test
	public void testNoFeatureInWorkspace() {
		List<ReversibleProject> workspaceFeatures = new ArrayList<>();
		workspaceFeatures.addAll(ADL4EclipseUtils.getWorkspaceFeatures());

		assertTrue("The workspace should not have any feature", workspaceFeatures.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoProjectToReverse() {
		try {
			initModel();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		ReverseSettings reverseSettings = new ReverseSettings();

		RecordingCommand snapshotCommand = new CompleteArchitectureSnapshotCommand(domain, rootModel, new HashSet<ReversibleProject>(), reverseSettings);
		domain.getCommandStack().execute(snapshotCommand);
	}
}
