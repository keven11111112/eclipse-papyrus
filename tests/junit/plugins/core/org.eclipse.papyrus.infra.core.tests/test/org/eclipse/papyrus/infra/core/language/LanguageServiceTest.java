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

package org.eclipse.papyrus.infra.core.language;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * Tests the Papyrus Language Service.
 */
public class LanguageServiceTest {
	private static final String ECORE_LANGUAGE_ID = "org.eclipse.papyrus.infra.core.tests.language.ecore"; //$NON-NLS-1$
	private static final String ECORE_LANGUAGE_VERSION = "2.11"; //$NON-NLS-1$
	private static final String ECORE_LANGUAGE_NAME = "Ecore"; //$NON-NLS-1$

	private static final String GENMODEL_LANGUAGE_ID = "org.eclipse.papyrus.infra.core.tests.language.genmodel"; //$NON-NLS-1$
	private static final String GENMODEL_LANGUAGE_VERSION = "2.11.0.v20150518-0831"; //$NON-NLS-1$
	private static final String GENMODEL_LANGUAGE_NAME = "Genmodel"; //$NON-NLS-1$

	@ClassRule
	public static final ProjectFixture project = new ProjectFixture();

	static ServicesRegistry registry;

	public LanguageServiceTest() {
		super();
	}

	@Test
	public void contentTypeBasedLanguages() throws ServiceException {
		ILanguageService service = registry.getService(ILanguageService.class);

		ILanguage ecore = null;
		ILanguage genmodel = null;
		for (ILanguage next : service.getLanguages(project.getURI("My.ecore"), true)) {
			if (ECORE_LANGUAGE_ID.equals(next.getID())) {
				ecore = next;
			} else if (GENMODEL_LANGUAGE_ID.equals(next.getID())) {
				genmodel = next;
			}
		}

		assertThat(genmodel, nullValue()); // Asked only about the *.ecore resource

		assertThat(ecore, notNullValue());
		assertThat(ecore.getVersion(), is(new Version(ECORE_LANGUAGE_VERSION)));
		assertThat(ecore.getName(), is(ECORE_LANGUAGE_NAME));
	}

	@Test
	public void contentTypeBasedLanguages_uriWithoutExtension() throws ServiceException {
		ILanguageService service = registry.getService(ILanguageService.class);

		ILanguage ecore = null;
		ILanguage genmodel = null;
		for (ILanguage next : service.getLanguages(project.getURI("My"), false)) {
			if (ECORE_LANGUAGE_ID.equals(next.getID())) {
				ecore = next;
			} else if (GENMODEL_LANGUAGE_ID.equals(next.getID())) {
				genmodel = next;
			}
		}

		assertThat(ecore, notNullValue());
		assertThat(ecore.getVersion(), is(new Version(ECORE_LANGUAGE_VERSION)));
		assertThat(ecore.getName(), is(ECORE_LANGUAGE_NAME));

		assertThat(genmodel, notNullValue());
		assertThat(genmodel.getVersion(), is(new Version(GENMODEL_LANGUAGE_VERSION)));
		assertThat(genmodel.getName(), is(GENMODEL_LANGUAGE_NAME));
	}

	//
	// Test framework
	//

	@BeforeClass
	public static void createResources() throws IOException {
		project.createFile(LanguageServiceTest.class, "resources/My.ecore");
		project.createFile(LanguageServiceTest.class, "resources/My.genmodel");
	}

	@BeforeClass
	public static void createRegistry() throws Exception {
		registry = new ServicesRegistry();
		registry.add(ILanguageService.class, 1, new org.eclipse.papyrus.infra.core.internal.language.LanguageService());
		registry.startRegistry();
	}

	@AfterClass
	public static void destroyRegistry() throws Exception {
		if (registry != null) {
			registry.disposeRegistry();
		}
		registry = null;
	}



}
