/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
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

package org.eclipse.papyrus.infra.tools.util;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.Externalizable;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;

/**
 * Test cases for the {@link ClasspathHelper} class.
 */
public class ClasspathHelperTest {

	private static final String PROJECT1 = "org.eclipse.papyrus.test.project1";
	private static final String PROJECT2 = "org.eclipse.papyrus.test.project2";
	private static final String CLASS_A = "org.eclipse.papyrus.test.project1.A";
	private static final String CLASS_A_I = "org.eclipse.papyrus.test.project1.A$I";
	private static final String CLASS_B = "org.eclipse.papyrus.test.project2.B";

	private static final URI PROJECT1_CONTEXT = URI.createPlatformResourceURI(PROJECT1 + "/path/to/resource.xmi", true);
	private static final URI PROJECT2_CONTEXT = URI.createPlatformResourceURI(PROJECT2 + "/other/resource.xmi", true);


	private static IProject project1;
	private static IProject project2;

	@Test
	public void findClass_exists() {
		Object found = ClasspathHelper.INSTANCE.findClass(CLASS_A, null, null);
		assertThat(found, notNullValue());
	}

	@Test
	public void findClass_noneSuch() {
		Object found = ClasspathHelper.INSTANCE.findClass("org.eclipse.papyrus.bogus.nonesuch.A", null, null);
		assertThat(found, nullValue());
	}

	@Test
	public void findClass_exists_nested() {
		Object found = ClasspathHelper.INSTANCE.findClass(CLASS_A_I, null, null);
		assertThat(found, notNullValue());
	}

	@Test
	public void findClass_exists_withContext() {
		Object found = ClasspathHelper.INSTANCE.findClass(CLASS_A, PROJECT1_CONTEXT, null);
		assertThat(found, notNullValue());
	}

	@Test
	public void findClass_exists_withContext_fallback() {
		Object found = ClasspathHelper.INSTANCE.findClass(CLASS_B, PROJECT1_CONTEXT, null);
		assertThat(found, notNullValue());
	}

	@Test
	public void findClass_exists_withContext_referencedProject() {
		Object found = ClasspathHelper.INSTANCE.findClass(CLASS_A, PROJECT2_CONTEXT, null);
		assertThat(found, notNullValue());
	}

	@Test
	public void findClass_exists_constrained() {
		Object found = ClasspathHelper.INSTANCE.findClass(CLASS_B, PROJECT2_CONTEXT, Serializable.class);
		assertThat(found, notNullValue());
	}

	@Test
	public void findClass_exists_constrained_wrongType() {
		Object found = ClasspathHelper.INSTANCE.findClass(CLASS_B, PROJECT2_CONTEXT, Externalizable.class);
		assertThat(found, nullValue());
	}

	//
	// Test framework
	//

	@BeforeClass
	public static void importProjects() throws URISyntaxException, CoreException, IOException {
		project1 = importProject(PROJECT1);
		project2 = importProject(PROJECT2);
	}

	@AfterClass
	public static void destroyProjects() throws CoreException {
		project2.delete(false, true, null);
		project1.delete(false, true, null);
	}

	private static IProject importProject(String name) throws URISyntaxException, CoreException, IOException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject result = workspace.getRoot().getProject(name);

		IProjectDescription desc = workspace.newProjectDescription(name);
		URL url = FileLocator.find(FrameworkUtil.getBundle(ClasspathHelperTest.class), new Path("resources/projects/" + name));
		url = FileLocator.toFileURL(url);
		desc.setLocationURI(url.toURI());
		result.create(desc, null);
		result.open(null);

		return result;
	}

}
