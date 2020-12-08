/*****************************************************************************
 * Copyright (c) 2019, 2020 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   Christian W. Damus - bug 569357
 *
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.greaterThanOrEqual;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.checkers.ElementTypesPluginCheckerService;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.constants.ElementTypesPluginValidationConstants;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * This class allows to test the profile plug-in validation.
 * This will check the markers resulting from a failing profile plug-in definition.
 */
public class ElementTypesPluginValidationTest extends AbstractPapyrusTest {

	/**
	 * The plug-in path to copy into the project fixture
	 */
	private static final String PLUGIN_PATH = "resources/org.eclipse.papyrus.toolsmiths.validation.elementtypes.example";//$NON-NLS-1$

	/**
	 * The project fixture to manage easily the project.
	 */
	@Rule
	public final ProjectFixture fixture = new ProjectFixture();

	/**
	 * This allows to copy the project into the fixture project.
	 */
	@Before
	public void init() {
		try {
			fixture.copyFolder(ElementTypesPluginValidationTest.class, PLUGIN_PATH);
		} catch (IOException e) {
			Assert.fail("Error while copying project"); //$NON-NLS-1$
		}
	}

	/**
	 * This allows to test the profile plug-in validation.
	 */
	@Test
	public void testProfilePluginValidation() {
		// First, run the validation
		ElementTypesPluginCheckerService.checkElementTypesPlugin(fixture.getProject(), new NullProgressMonitor());

		// Get the markers
		List<IMarker> markers = null;
		try {
			markers = Arrays.asList(fixture.getProject().findMarkers(ElementTypesPluginValidationConstants.ELEMENTTYPES_PLUGIN_VALIDATION_TYPE, true, IResource.DEPTH_INFINITE));
		} catch (CoreException e) {
			Assert.fail("Error with resource"); //$NON-NLS-1$
		}

		// Now check the markers

		// Check the elementtypesconfigurations file markers
		final List<IMarker> elementtypesFileMarkers = markers.stream().filter(marker -> marker.getResource().getFullPath().toString().endsWith("BookStore.elementtypesconfigurations")).collect(Collectors.toList()); //$NON-NLS-1$
		assertThat("The number of markers for elementtypesconfigurations file is not correct", elementtypesFileMarkers.size(), greaterThanOrEqual(2)); //$NON-NLS-1$
		assertThat("The severity of elementtypesconfigurations marker is not correct", elementtypesFileMarkers, everyItem(isMarkerSeverity(IMarker.SEVERITY_ERROR))); //$NON-NLS-1$

		// Check the dependencies markers
		final List<IMarker> dependenciesMarkers = markers.stream().filter(marker -> marker.getResource().getFullPath().toString().endsWith("MANIFEST.MF")).collect(Collectors.toList()); //$NON-NLS-1$
		assertThat("The number of markers for dependencies is not correct", dependenciesMarkers.size(), greaterThanOrEqual(5)); //$NON-NLS-1$
		assertThat("The number of warning markers for dependencies is not correct", dependenciesMarkers, hasAtLeast(2, isMarkerSeverity(IMarker.SEVERITY_WARNING))); //$NON-NLS-1$
		assertThat("The number of error markers for dependencies is not correct", dependenciesMarkers, hasAtLeast(3, isMarkerSeverity(IMarker.SEVERITY_ERROR))); //$NON-NLS-1$

		// Check the extensions markers
		final List<IMarker> extensionsMarkers = markers.stream().filter(marker -> marker.getResource().getFullPath().toString().endsWith("plugin.xml")).collect(Collectors.toList()); //$NON-NLS-1$
		assertThat("The number of markers for extensions is not correct", extensionsMarkers.size(), greaterThanOrEqual(1)); //$NON-NLS-1$
		assertThat("Missing extension should be a warning", extensionsMarkers, hasItem(isMarkerSeverity(IMarker.SEVERITY_WARNING))); //$NON-NLS-1$
	}

	/**
	 * Create a matcher for markers by severity.
	 *
	 * @param severity
	 *            the marker severity to match
	 * @return the marker matcher
	 */
	static Matcher<IMarker> isMarkerSeverity(final int severity) {
		return new FeatureMatcher<>(is(severity), "marker severity", "severity") { //$NON-NLS-1$//$NON-NLS-2$
			@Override
			protected Integer featureValueOf(IMarker actual) {
				return actual.getAttribute(IMarker.SEVERITY, -1);
			}
		};
	}

	/**
	 * Create a matcher for iterables to verify that some minimum number of items match some criterion.
	 *
	 * @param <T>
	 *            the iterable element type
	 * @param min
	 *            the minimum number of elements of the iterable to match
	 * @param elementMatcher
	 *            the matcher for elements
	 * @return a matcher for iterables that verifies a minimum number of element matches
	 */
	static <T> Matcher<Iterable<T>> hasAtLeast(int min, Matcher<? super T> elementMatcher) {
		return new TypeSafeDiagnosingMatcher<>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("has a least " + min + " items that "); //$NON-NLS-1$//$NON-NLS-2$
				description.appendDescriptionOf(elementMatcher);
			}

			@Override
			protected boolean matchesSafely(Iterable<T> item, Description mismatchDescription) {
				int satisfiedCount = 0;

				for (T next : item) {
					if (elementMatcher.matches(next)) {
						satisfiedCount = satisfiedCount + 1;
						if (satisfiedCount >= min) {
							break; // Needn't look any further
						}
					}
				}

				if (satisfiedCount < min) {
					mismatchDescription.appendText("has fewer than " + min + " items that "); //$NON-NLS-1$//$NON-NLS-2$
					mismatchDescription.appendDescriptionOf(elementMatcher);
				}

				return satisfiedCount >= min;
			}
		};
	}

}
