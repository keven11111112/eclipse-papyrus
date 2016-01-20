/*****************************************************************************
 * Copyright (c) 2015, 2016 Christian W. Damus and others.
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

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;

import org.eclipse.papyrus.infra.core.internal.language.LanguageModelRegistry;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.junit.utils.resources.EcoreModel;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.junit.utils.rules.ServiceRegistryModelSetFixture;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * Tests the Papyrus Language Service.
 */
@PluginResource({ "resources/My.ecore", "resources/My.genmodel" })
public class LanguageServiceTest {
	private static final String ECORE_LANGUAGE_ID = "org.eclipse.papyrus.infra.core.tests.language.ecore"; //$NON-NLS-1$
	private static final String ECORE_LANGUAGE_VERSION = "2.11"; //$NON-NLS-1$
	private static final String ECORE_LANGUAGE_NAME = "Ecore"; //$NON-NLS-1$

	private static final String GENMODEL_LANGUAGE_ID = "org.eclipse.papyrus.infra.core.tests.language.genmodel"; //$NON-NLS-1$
	private static final String GENMODEL_LANGUAGE_VERSION = "2.11.0.v20150518-0831"; //$NON-NLS-1$
	private static final String GENMODEL_LANGUAGE_NAME = "Genmodel"; //$NON-NLS-1$

	@ClassRule
	public static final ModelSetFixture modelSet = new ServiceRegistryModelSetFixture();

	private static IModel ecoreModel;

	public LanguageServiceTest() {
		super();
	}

	@Test
	public void contentTypeBasedLanguages() throws ServiceException {
		ILanguageService service = modelSet.requireService(ILanguageService.class);

		ILanguage ecore = null;
		ILanguage genmodel = null;
		for (ILanguage next : service.getLanguages(modelSet.getProject().getURI("My.ecore"), true)) {
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
		ILanguageService service = modelSet.requireService(ILanguageService.class);

		ILanguage ecore = null;
		ILanguage genmodel = null;
		for (ILanguage next : service.getLanguages(modelSet.getProject().getURI("My"), false)) {
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

	@Test
	public void languageBindings() {
		Collection<IModel> models = ILanguageService.getLanguageModels(modelSet.getResourceSet());

		assertThat(models, hasItem(ecoreModel));
	}

	//
	// Test framework
	//

	@BeforeClass
	public static void registerEcoreModel() {
		ecoreModel = new EcoreModel();
		LanguageModelRegistry.INSTANCE.bind(ECORE_LANGUAGE_ID, ecoreModel.getIdentifier());

		modelSet.getResourceSet().getInternal().registerModel(ecoreModel, false);
	}

	@AfterClass
	public static void unregisterEcoreModel() {
		LanguageModelRegistry.INSTANCE.bind(ECORE_LANGUAGE_ID, ecoreModel.getIdentifier());
		ecoreModel = null;
	}
}
