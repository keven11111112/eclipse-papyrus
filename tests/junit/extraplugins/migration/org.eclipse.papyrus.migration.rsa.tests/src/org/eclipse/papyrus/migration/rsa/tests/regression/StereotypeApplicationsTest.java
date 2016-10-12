/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

import static java.util.Spliterators.spliteratorUnknownSize;
import static org.eclipse.papyrus.junit.matchers.MoreMatchers.lessThan;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.migration.rsa.concurrent.ExecutorsPool;
import org.eclipse.papyrus.migration.rsa.internal.extension.TransformationExtension;
import org.eclipse.papyrus.migration.rsa.tests.regression.AbstractMigrationRegressionTest.TransformationExtensionClass;
import org.eclipse.papyrus.migration.rsa.tests.regression.StereotypeApplicationsTest.MigrationTracker;
import org.eclipse.papyrus.migration.rsa.transformation.ImportTransformation;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.junit.Test;

/**
 * Specific regression tests for bugs in access to stereotype applications
 * in the context of transformation extensions.
 */
@TransformationExtensionClass(MigrationTracker.class)
public class StereotypeApplicationsTest extends AbstractMigrationRegressionTest {

	/**
	 * Initializes me.
	 */
	public StereotypeApplicationsTest() {
		super();
	}

	/**
	 * Verifies that transformation extensions have access to stereotype applications
	 * in the before and after phases, before dependency fixing and stereotype repair,
	 * as long as the RSA profile has already been imported to Papyrus at the same
	 * location.
	 * 
	 * @see <a href="http://eclip.se/505330">bug 505330</a>
	 */
	@Test
	@PluginResource({ "bug505330/first.emx", "bug505330/today.profile.uml" })
	@BatchMigration // because the batch launcher sets up the dependency analysis helper
	public void extensionsFindAppliedStereotypes() throws Exception {
		assertThat(MigrationTracker.foundBeforeMainMigration, not(lessThan(2L)));
		assertThat(MigrationTracker.foundAfterMainMigration, not(lessThan(2L)));
	}

	//
	// Test framework
	//

	public static class MigrationTracker implements TransformationExtension {

		public static boolean isEnabled = false;

		static long foundBeforeMainMigration;
		static long foundAfterMainMigration;

		private ImportTransformation transformation;

		@Override
		public Set<EPackage> getAdditionalSourceEPackages() {
			return Collections.emptySet();
		}

		@Override
		public void setResourceSet(ResourceSet resourceSet) {
			// Pass
		}

		@Override
		public void setExecutorsPool(ExecutorsPool executorsPool) {
			// Pass
		}

		@Override
		public void setTransformation(ImportTransformation importTransformation) {
			// Re-initialize counts for this test
			foundBeforeMainMigration = 0L;
			foundAfterMainMigration = 0L;

			this.transformation = importTransformation;
		}

		@Override
		public IStatus executeBefore(ExecutionContext context, IProgressMonitor monitor) {
			if (isEnabled) {
				foundBeforeMainMigration = countStereotypes();
				monitor.worked(1);
			}
			return Status.OK_STATUS;
		}

		@Override
		public IStatus executeAfter(ExecutionContext context, IProgressMonitor monitor) {
			if (isEnabled) {
				foundAfterMainMigration = countStereotypes();
				monitor.worked(1);
			}
			return Status.OK_STATUS;
		}

		long countStereotypes() {
			List<EObject> models = transformation.getInOutUMLModel().getContents();
			Stream<EObject> all = StreamSupport.stream(spliteratorUnknownSize(EcoreUtil.getAllContents(models, true),
					Spliterator.DISTINCT | Spliterator.IMMUTABLE | Spliterator.NONNULL | Spliterator.ORDERED),
					false);

			return all.filter(Classifier.class::isInstance).map(Classifier.class::cast)
					.filter(this::hasStereotype)
					.count();
		}

		boolean hasStereotype(Element element) {
			return (element.getAppliedStereotype("today::Foo") != null)
					|| (element.getAppliedStereotype("today::Bar") != null);
		}

		@Override
		public int getNumberOfSteps() {
			return isEnabled ? 2 : 0;
		}

	}
}
