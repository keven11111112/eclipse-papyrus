/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.junit.matchers;

import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.CombinableMatcher;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

/**
 * Some useful matchers that Hamcrest doesn't provide.
 */
public class MoreMatchers {

	private MoreMatchers() {
		super();
	}

	public static <N extends Number & Comparable<N>> Matcher<N> greaterThan(final N minimum) {
		return new BaseMatcher<N>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("greater than ").appendValue(minimum);
			}

			@Override
			@SuppressWarnings("unchecked")
			public boolean matches(Object item) {
				return ((N) item).compareTo(minimum) > 0;
			}
		};
	}

	public static <N extends Number & Comparable<N>> Matcher<N> lessThan(final N maximum) {
		return new BaseMatcher<N>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("less than ").appendValue(maximum);
			}

			@Override
			@SuppressWarnings("unchecked")
			public boolean matches(Object item) {
				return ((N) item).compareTo(maximum) < 0;
			}
		};
	}

	/**
	 * Match empty iterables of any kind.
	 * 
	 * @see #emptyIterable()
	 */
	public static Matcher<Iterable<?>> isEmpty() {
		return new BaseMatcher<Iterable<?>>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("is empty");
			}

			@Override
			public boolean matches(Object item) {
				return Iterables.isEmpty((Iterable<?>) item);
			}
		};
	}

	/**
	 * The {@link CombinableMatcher}s of Hamcrest require matching generic signatures,
	 * for which the wildcard of the {@link #isEmpty()} matcher doesn't work very well,
	 * so this equivalent matcher may be used instead in those cases.
	 * 
	 * @see #isEmpty()
	 */
	public static <E> Matcher<Iterable<E>> emptyIterable() {
		return new BaseMatcher<Iterable<E>>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("is empty");
			}

			@Override
			public boolean matches(Object item) {
				return Iterables.isEmpty((Iterable<?>) item);
			}
		};
	}

	public static Matcher<String> regexMatches(final String pattern) {
		return new BaseMatcher<String>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("matches /").appendText(pattern).appendText("/");
			}

			@Override
			public boolean matches(Object item) {
				String string = (String) item;
				return !Strings.isNullOrEmpty(string) && string.matches(pattern);
			}
		};
	}

	public static Matcher<String> regexContains(final String pattern) {
		final Pattern regex = Pattern.compile(pattern);

		return new BaseMatcher<String>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("contains /").appendText(pattern).appendText("/");
			}

			@Override
			public boolean matches(Object item) {
				String string = (String) item;
				return !Strings.isNullOrEmpty(string) && regex.matcher(string).find();
			}
		};
	}

	public static Matcher<IStatus> statusWithMessage(final Matcher<? super String> matcher) {
		return new BaseMatcher<IStatus>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("status with message ").appendDescriptionOf(matcher);
			}

			@Override
			public boolean matches(Object item) {
				boolean result = false;
				if (item instanceof IStatus) {
					IStatus status = (IStatus) item;
					result = matcher.matches(status.getMessage());
				}
				return result;
			}
		};
	}

	public static Matcher<IStatus> statusWithException(final Matcher<?> matcher) {
		return new BaseMatcher<IStatus>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("status with exception ").appendDescriptionOf(matcher);
			}

			@Override
			public boolean matches(Object item) {
				boolean result = false;
				if (item instanceof IStatus) {
					IStatus status = (IStatus) item;
					result = matcher.matches(status.getException());
				}
				return result;
			}
		};
	}
}
