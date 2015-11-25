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

package org.eclipse.papyrus.junit.utils;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.junit.rules.TestRule;
import org.junit.runner.Description;

import com.google.common.collect.Maps;

/**
 * Utilities for working with the JUnit data model and execution environment.
 */
public class JUnitUtils {

	/**
	 * Not instantiable by clients.
	 */
	private JUnitUtils() {
		super();
	}

	/**
	 * Obtains the test class implied by a {@code description} that is supplied to a {@link TestRule}.
	 * 
	 * @param description
	 *            a rule's owning description, which generally would be a test method or a test class
	 *            (as these are the contexts in which rules are invoked)
	 * 
	 * @return the test class, or {@code null} in the unlikely event that none can be found
	 */
	public static Class<?> getTestClass(Description description) {
		Class<?> result = description.getTestClass();

		if (result == null) {
			for (Description child : description.getChildren()) {
				result = getTestClass(child);
				if (result != null) {
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Obtains the annotations applied to a {@code description} that is supplied to a {@link TestRule}.
	 * If the description is for a test method, the annotations of its owning class are included,
	 * excepting annotations of the same type applied to the method.
	 * 
	 * @param description
	 *            a rule's owning description, which generally would be a test method or a test class
	 *            (as these are the contexts in which rules are invoked)
	 * 
	 * @return all of the annotations applied to the test description
	 */
	public static Iterable<Annotation> getAnnotations(Description description) {
		Map<Class<? extends Annotation>, Annotation> result = Maps.newLinkedHashMap();

		for (Annotation next : description.getAnnotations()) {
			result.put(next.annotationType(), next);
		}

		if (description.getTestClass() != null) {
			for (Annotation next : description.getTestClass().getAnnotations()) {
				if (!result.containsKey(next.annotationType())) {
					result.put(next.annotationType(), next);
				}
			}
		}

		return result.values();
	}

	/**
	 * Obtains the annotation of the specified {@code type} applicable to a {@code description} that is supplied to a {@link TestRule}.
	 * If the description is for a test method, then if that method doesn't have the requested annotation, its owning class is searched
	 * for the annotation.
	 * 
	 * @param description
	 *            a rule's owning description, which generally would be a test method or a test class
	 *            (as these are the contexts in which rules are invoked)
	 * @param type
	 *            the annotation type to look for
	 * 
	 * @return the requested annotation, or {@code null} if none was found
	 */
	public static <A extends Annotation> A getAnnotation(Description description, Class<A> type) {
		A result = description.getAnnotation(type);

		if ((result == null) && (description.getTestClass() != null)) {
			result = description.getTestClass().getAnnotation(type);
		}

		return result;
	}

	/**
	 * Obtains the annotation of any one of the specified {@code types} applicable to a {@code description} that is supplied to a {@link TestRule}.
	 * If the description is for a test method, then if that method doesn't have any of the requested annotations, its owning class is searched
	 * for the annotations.
	 * 
	 * @param description
	 *            a rule's owning description, which generally would be a test method or a test class
	 *            (as these are the contexts in which rules are invoked)
	 * @param types
	 *            the annotation types to look for
	 * 
	 * @return the first available of the requested annotations, or {@code null} if none was found
	 */
	@SafeVarargs
	public static Annotation getAnyAnnotation(Description description, final Class<? extends Annotation>... types) {
		Annotation result = null;

		for (Class<? extends Annotation> next : types) {
			result = description.getAnnotation(next);
			if (result != null) {
				break;
			}
		}

		if (result == null) {
			out: for (Class<?> testClass = description.getTestClass(); testClass != null; testClass = testClass.getSuperclass()) {
				for (Class<? extends Annotation> next : types) {
					result = testClass.getAnnotation(next);
					if (result != null) {
						break out;
					}
				}
			}
		}

		return result;
	}

	/**
	 * Queries whether the current JUnit test execution is running in the automated build environment
	 * (whether actually on the build server or not; users can run local builds on their development systems, too).
	 * 
	 * @return whether the tests are running in the automated build environment
	 */
	public static boolean isAutomatedBuildExecution() {
		return Activator.getDefault().getRunningApplicationID().startsWith("org.eclipse.tycho."); //$NON-NLS-1$
	}
}
