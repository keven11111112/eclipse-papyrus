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

package org.eclipse.papyrus.junit.framework.classification;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;

/**
 * A specialized Test {@linkplain Suite Suite} runner that recognizes the Papyrus-specific
 * {@link ClassificationConfig classification} annotations on the suite as a whole. It also
 * supports a dynamic specification of test suites to include via the {@literal @}{@link DynamicClasses}
 * annotation, especially useful for generated tests that may or may not have been generated at
 * the time of test execution (or at least of compilation of the test suite class).
 */
public class ClassificationSuite extends Suite {

	public ClassificationSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
		this(builder, klass, getAnnotatedClasses(klass));
	}

	public ClassificationSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(klass, withDynamicSuites(klass, suiteClasses));
	}

	public ClassificationSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(builder, klass, withDynamicSuites(klass, suiteClasses));
	}

	private static Class<?>[] getAnnotatedClasses(Class<?> class_) throws InitializationError {
		SuiteClasses annotation = class_.getAnnotation(SuiteClasses.class);
		if (annotation == null) {
			throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", class_.getName()));
		}
		return annotation.value();
	}

	private static Class<?>[] withDynamicSuites(Class<?> suiteClass, Class<?>[] staticSuites) {
		Class<?>[] result = staticSuites;

		Class<?>[] dynamicSuites = getDynamicSuites(suiteClass);
		if (dynamicSuites.length > 0) {
			result = ObjectArrays.concat(staticSuites, dynamicSuites, Class.class);
		}

		return result;
	}

	private static Class<?>[] getDynamicSuites(Class<?> suiteClass) {
		List<Class<?>> result;

		DynamicClasses dynclasses = suiteClass.getAnnotation(DynamicClasses.class);
		if (dynclasses == null) {
			result = Collections.emptyList();
		} else {
			result = Lists.newArrayListWithCapacity(dynclasses.value().length);
			for (String classname : dynclasses.value()) {
				try {
					result.add(suiteClass.getClassLoader().loadClass(classname));
				} catch (Exception e) {
					// OK. It's not there, so we just ignore it
				}
			}
		}

		return Iterables.toArray(result, Class.class);
	}

	@Override
	protected List<Runner> getChildren() {
		// If I don't match the current configuration, none of my tests will run, so don't even provide them
		// because they just inflate the size of the progress meter
		if (ClassificationConfig.shouldRun(getRunnerAnnotations())) {
			return super.getChildren();
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public void run(RunNotifier notifier) {
		// If I don't match the current configuration, none of my tests should be run
		if (ClassificationConfig.shouldRun(getRunnerAnnotations())) {
			super.run(notifier);
		} else {
			Description description = getDescription();
			notifier.fireTestIgnored(description);
		}
	}

	//
	// Nested types
	//

	/**
	 * An annotation like the {@literal @}{@link SuiteClasses} that specifies, by name, test suite classes
	 * to find and include dynamically. Any that are not available are simply ignored.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface DynamicClasses {
		/**
		 * Names of test suite classes to optionally include in the test suite.
		 */
		String[]value();
	}
}
