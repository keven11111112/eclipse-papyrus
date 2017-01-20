/*****************************************************************************
 * Copyright (c) 2016, 2017 Christian W. Damus and others.
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

import static org.junit.Assert.fail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.papyrus.junit.utils.JUnitUtils;
import org.eclipse.papyrus.junit.utils.rules.AnnotationRule;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.migration.rsa.internal.extension.TransformationExtension;
import org.eclipse.papyrus.migration.rsa.tests.qvt.AbstractTransformationTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.google.common.collect.Lists;

/**
 * Common framework for regression tests in RSA migration.
 */
public abstract class AbstractMigrationRegressionTest extends AbstractTransformationTest {

	@Rule
	public final TestName name = new TestName();

	@Rule
	public final AnnotationRule<String[]> testModel = AnnotationRule.create(PluginResource.class);

	@Rule
	public final AnnotationRule<Boolean> batchMode = AnnotationRule.create(BatchMigration.class);

	@Rule
	public final TestRule transformationExtensions = new TransformationRule();

	/**
	 * Initializes me.
	 */
	protected AbstractMigrationRegressionTest() {
		super();
	}

	@Before
	public void importAndOpen() throws Exception {
		List<String> resourcePaths = Lists.newArrayList(testModel.get());

		Matcher bugMatcher = Pattern.compile("^(bug\\d+)/").matcher("");

		resourcePaths.replaceAll(p -> {
			String bug;

			bugMatcher.reset(p);

			if (bugMatcher.find()) {
				bug = bugMatcher.group(1);

				// Don't be redundant
				p = p.substring(bugMatcher.end());
			} else {
				bug = name.getMethodName();
				bug = bug.substring(bug.lastIndexOf('_') + 1);
			}

			return String.format("resources/%s/%s", bug, p);
		});

		simpleImport(resourcePaths.get(0),
				resourcePaths.stream().skip(1).toArray(String[]::new),
				batchMode.get());

		openEditor();
	}

	//
	// Nested types
	//

	/**
	 * Annotates a test or suite with the transformation extensions that
	 * it should enable for the duration of the test.
	 */
	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface TransformationExtensionClass {
		/** The transformation extension classes to enable. */
		java.lang.Class<? extends TransformationExtension>[] value();
	}

	/**
	 * Annotates a test or suite to indicate whether batch import is needed.
	 */
	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface BatchMigration {
		/** Migrate in batch? */
		boolean value() default true;
	}

	private static final class TransformationRule extends TestWatcher {
		/**
		 * Enable the test transformations.
		 */
		@Override
		protected void starting(Description description) {
			TransformationExtensionClass ext = JUnitUtils.getAnnotation(description, TransformationExtensionClass.class);
			if (ext != null) {
				Arrays.asList(ext.value()).forEach(e -> setEnabled(e, true));
			}
		}

		/**
		 * Disable the test transformations.
		 */
		@Override
		protected void finished(Description description) {
			TransformationExtensionClass ext = JUnitUtils.getAnnotation(description, TransformationExtensionClass.class);
			if (ext != null) {
				Arrays.asList(ext.value()).forEach(e -> setEnabled(e, false));
			}
		}

		private void setEnabled(java.lang.Class<? extends TransformationExtension> ext, boolean enabled) {
			try {
				ext.getDeclaredField("isEnabled").set(null, enabled);
			} catch (Exception e) {
				e.printStackTrace();
				fail("Failed to enable or disable transformation extension");
			}
		}
	}
}
