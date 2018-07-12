/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.welcome.tests;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.greaterThan;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.editor.welcome.tests.AbstractWelcomePageTest;
import org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements.NotationObservable;
import org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements.NotationObservableProperty;
import org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements.WelcomeModelElement;
import org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements.WelcomeModelElementFactory;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link NotationObservableProperty} class specifically.
 */
@PluginResource(value = "resources/many_diagrams.di", bundle = "org.eclipse.papyrus.infra.editor.welcome.tests")
public class NotationObservablePropertyTest extends AbstractWelcomePageTest {

	private WelcomeModelElement fixture;

	public NotationObservablePropertyTest() {
		super();
	}

	@Test
	public void viewsPropertyExcludesPluginDeployedModels_bug493668() {
		IObservableList<NotationObservable> views = getNotationViews();

		// At least the six diagrams in this model
		int originalViewsCount = views.size();
		assertThat(originalViewsCount, greaterThan(5));

		// Load a plug-in deployed model into the resource set
		Resource deployedNotation = editor.getResourceSet().getResource(
				URI.createPlatformPluginURI("org.eclipse.papyrus.infra.editor.welcome.tests/resources/many_diagrams.notation", true),
				true);
		assertThat(deployedNotation.isLoaded(), is(true));
		assertThat(deployedNotation.getContents(), hasItem(anything()));

		// It did not add to the number of views despite that it has a bunch
		assertThat("Welcome page is showing deployed diagrams", views.size(), is(originalViewsCount));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() {
		fixture = (WelcomeModelElement) new WelcomeModelElementFactory().createFromSource(
				requireWelcome(), null); // The data-context isn't used by the factory
	}

	IObservableList<NotationObservable> getNotationViews() {
		@SuppressWarnings("unchecked")
		IObservableList<NotationObservable> result = (IObservableList<NotationObservable>) fixture.getObservable("views");
		return result;
	}
}
