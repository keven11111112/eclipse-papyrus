/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.decoratormodel.tests;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.tools.helper.IProfileApplicationDelegate;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Test;

/**
 * Tests regressions in specific bugs.
 */
public class RegressionTest extends AbstractProfileExternalizationTest {
	public RegressionTest() {
		super();
	}

	@Test
	@PluginResource("/resources/regression/bug481302/model.di")
	public void migrateProfileExtendingDynamic_bug481302() throws Exception {
		doTestMigrateProfileExtendingOther_bug481302("p2", new MigrateFunctionImpl());
	}

	protected void doTestMigrateProfileExtendingOther_bug481302(String profileName,
			final MigrateFunction migrator) throws Exception {

		final Package model = modelSet.getModel();
		final org.eclipse.uml2.uml.Class req1 = (org.eclipse.uml2.uml.Class) model.getOwnedType("Requirement1");
		final Profile profile = modelSet.getModel().getAllAppliedProfiles().get(0);
		final Stereotype myReq = req1.getAppliedStereotype(profileName + "::MyRequirement");

		// Initial conditions check
		assumeThat((String) req1.getValue(myReq, "id"), is("R1"));

		execute(new Runnable() {
			@Override
			public void run() {
				migrator.migrate(model, profile);
			}
		});

		// Verify that no data lost and new attribute is available
		assertThat((String) req1.getValue(myReq, "id"), is("R1"));
		execute(new Runnable() {
			@Override
			public void run() {
				req1.setValue(myReq, "tag", asList("red", "high"));
			}
		});
		String tag = (String) req1.getValue(myReq, "tag[1]");
		assertThat(tag, is("high"));
	}

	@Test
	@PluginResource("/resources/regression/bug481302/model2.di")
	public void migrateProfileExtendingStatic_bug481302() throws Exception {
		doTestMigrateProfileExtendingOther_bug481302("myreq", new MigrateFunctionImpl());
	}

	@Test
	@FailingTest("Use case not supported by UML2: bug 481712")
	@PluginResource("/resources/regression/bug481302/model2.di")
	public void basicUMLMigrateProfileExtendingStatic_bug481302() throws Exception {
		doTestMigrateProfileExtendingOther_bug481302("myreq", new MigrateFunction() {
			@Override
			public void migrate(Package package_, Profile profile) {
				package_.applyProfile(profile);
			};
		});
	}

	//
	// Test framework
	//

	private class MigrateFunctionImpl implements MigrateFunction {

		@Override
		public void migrate(Package package_, Profile profile) {
			@SuppressWarnings("restriction")
			IProfileApplicationDelegate delegate = new org.eclipse.papyrus.uml.decoratormodel.internal.providers.ExternalizedProfileApplicationDelegate();

			delegate.reapplyProfile(package_, profile, null);
		}
	}

	private interface MigrateFunction {
		public void migrate(Package package_, Profile profile);
	}
}
