/*****************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
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

package org.eclipse.papyrus.migration.rsa.tests.regression;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.greaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Objects;
import java.util.stream.StreamSupport;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.migration.rsa.tests.PostProcessor;
import org.eclipse.papyrus.migration.rsa.tests.regression.AbstractMigrationRegressionTest.BatchMigration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.junit.Test;

/**
 * Specific regression tests for bugs in the post-processing phase of import.
 */
@BatchMigration
@PluginResource({ "fragments/Blank Package.emx", "fragments/Class3.efx",
		"fragments/Interface - Fragment.efx", "fragments/Package - Fragment.efx" })
public class PostProcessingExtensionTest extends AbstractMigrationRegressionTest {

	/**
	 * Initializes me.
	 */
	public PostProcessingExtensionTest() {
		super();
	}

	/**
	 * @see <a href="http://eclip.se/505330">bug 505330</a>
	 */
	@TransformationExtensionClass(PostProcessor.class)
	@Test
	public void postProcessExtensionsInvoked_bug505330() throws Exception {
		assertThat(rootPackage.getName(), is("123 Blank Package"));

		Package fragment = rootPackage.getNestedPackage("123 Package - Fragment");
		assertThat("Fragment package not renamed", fragment, notNullValue());

		Type interface_ = fragment.getOwnedType("123 Interface2");
		assertThat("Interface in fragment not renamed", interface_, notNullValue());

		Type class_ = fragment.getOwnedType("123 Class2");
		assertThat("Class in fragment not renamed", class_, notNullValue());
	}

	/**
	 * @see <a href="http://eclip.se/505330">bug 505330</a>
	 */
	@TransformationExtensionClass(PostProcessor.WithQVTo.class)
	@Test
	public void postProcessExtensionWithQVTo_bug505330() throws Exception {
		assertThat(rootPackage.getName(), is("123 Blank Package"));

		Package fragment = rootPackage.getNestedPackage("123 Package - Fragment");
		assertThat("Fragment package not renamed", fragment, notNullValue());

		Type interface_ = fragment.getOwnedType("123 Interface2");
		assertThat("Interface in fragment not renamed", interface_, notNullValue());

		Type class_ = fragment.getOwnedType("123 Class2");
		assertThat("Class in fragment not renamed", class_, notNullValue());

		ModelSet modelSet = ServiceUtils.getInstance().getModelSet(editor.getServicesRegistry());
		long count = StreamSupport.stream(NotationUtils.getAllNotations(modelSet).spliterator(), false)
				.filter(Diagram.class::isInstance).map(Diagram.class::cast)
				.map(Diagram::getName)
				.filter(Objects::nonNull)
				.peek(name -> assertThat("Diagram not renamed", name, startsWith("123 ")))
				.count();
		assertThat("No diagrams to assert", count, greaterThan(0L));
	}

}
