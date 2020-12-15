/*****************************************************************************
 * Copyright (c) 2020 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.validation.common.tests;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.regexMatches;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.junit.matchers.MoreMatchers;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.ModelDependenciesChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.tests.rules.Build;
import org.eclipse.papyrus.toolsmiths.validation.common.tests.rules.TestProject;
import org.eclipse.papyrus.toolsmiths.validation.common.tests.rules.TestProjectFixture;
import org.junit.Rule;
import org.junit.Test;

/**
 * Specific test cases for the {@link ModelDependenciesChecker} class.
 */
@TestProject("org.eclipse.papyrus.toolsmiths.validation.common.example")
@Build(false)
public class ModelDependenciesCheckerTest {

	private static final String BOOKSTORE_PROFILE = "resources/BookStore.profile.uml"; //$NON-NLS-1$

	@Rule
	public final TestProjectFixture project = new TestProjectFixture();

	/**
	 * Verify that a dynamic profile definition does not induce spurious problem reports
	 * of the empty URI (from the EPackage::eFactoryInstance reference) and EPackages
	 * referenced by namespace URI instead of location URI.
	 */
	@Test
	public void noSpuriousDependencyProblemsFromDynamicProfileDefinition() {
		Resource profile = project.loadModelResource(BOOKSTORE_PROFILE);
		ModelDependenciesChecker checker = new ModelDependenciesChecker(project.getProject(), project.getFile(BOOKSTORE_PROFILE), profile);

		BasicDiagnostic diagnostics = new BasicDiagnostic();
		checker.check(diagnostics, null);

		assertThat(diagnostics.getChildren(), not(hasItem(MoreMatchers.diagnosticWithMessage(containsString("must be declared as required plug-in"))))); //$NON-NLS-1$
		assertThat(diagnostics.getChildren(), not(hasItem(MoreMatchers.diagnosticWithMessage(containsString("Cross-document reference by file URI"))))); //$NON-NLS-1$
		assertThat(diagnostics.getChildren(), not(hasItem(MoreMatchers.diagnosticWithMessage(regexMatches("The URI .* cannot be resolved"))))); //$NON-NLS-1$
	}

}
