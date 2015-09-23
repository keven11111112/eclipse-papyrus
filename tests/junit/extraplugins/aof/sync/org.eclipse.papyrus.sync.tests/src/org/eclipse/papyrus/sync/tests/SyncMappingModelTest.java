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

package org.eclipse.papyrus.sync.tests;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.ServiceRegistryModelSetFixture;
import org.eclipse.papyrus.sync.ISyncMappingModel;
import org.eclipse.papyrus.sync.internal.SyncMappingModel;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the {@link SyncMappingModel} class.
 */
@JavaResource("capsules-with-machines.di")
public class SyncMappingModelTest extends AbstractPapyrusTest {

	@Rule
	public final ModelSetFixture model = new ServiceRegistryModelSetFixture();

	private ISyncMappingModel fixture;

	public SyncMappingModelTest() {
		super();
	}

	@Test
	public void getMappingModel() {
		assertThat("No mapping model", fixture, notNullValue());

		// The model exists but is initially empty
		assertThat(fixture.getMappingModel(), notNullValue());
		assertThat(fixture.getMappingModel().getMappings(), not(hasItem(anything())));
	}

	@Test
	public void mappingResource() throws IOException {
		assumeThat("No mapping model", fixture, notNullValue());

		Resource resource = ((AbstractBaseModel) fixture).getResource();
		assertThat("No mapping resource", resource, notNullValue());
		URIConverter uriConv = resource.getResourceSet().getURIConverter();
		assertThat(uriConv.exists(resource.getURI(), null), is(false));

		// Not actually saveable
		fixture.saveModel();
		assertThat(uriConv.exists(resource.getURI(), null), is(false));
	}

	//
	// Test framework
	//

	@Before
	public void initServiceRegistry() throws ServiceException {
		fixture = ISyncMappingModel.getInstance(model.getResourceSet());
	}
}
