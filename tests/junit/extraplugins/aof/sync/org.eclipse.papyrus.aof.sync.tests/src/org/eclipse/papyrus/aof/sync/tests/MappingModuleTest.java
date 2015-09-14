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

package org.eclipse.papyrus.aof.sync.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

/**
 * Test cases for the {@link MappingModule} class.
 */
public class MappingModuleTest {

	public MappingModuleTest() {
		super();
	}

	/**
	 * Test binding a provider.
	 */
	@Test
	public void testGetCorrespondenceResolver() {
		int methodCount = MappingModuleTest.class.getMethods().length;
		ISyncCorrespondenceResolver<MutableInteger, MappingModuleTest> resolver = (value, test) -> {
			return new MutableInteger(value.intValue() + test.getClass().getMethods().length);
		};

		assertInjected(new MutableInteger(42 + methodCount), Number.class, new MappingModule() {
			@Override
			protected void configure() {
				Provider<ICorrespondenceResolver<MutableInteger, MutableInteger, MappingModuleTest>> provider = getCorrespondenceResolver(MutableInteger.class, MappingModuleTest.class);

				bind(key(ICorrespondenceResolver.class, MutableInteger.class, MutableInteger.class, MappingModuleTest.class)).toInstance(resolver);

				bind(Number.class).toProvider((Provider<Number>) () -> {
					return provider.get().getCorrespondent(new MutableInteger(42), MappingModuleTest.this);
				});
			}
		});
	}

	//
	// Test framework
	//

	<T> void assertInjected(T expected, Class<T> type, MappingModule module) {
		assertInjected(expected, Key.get(type), module);
	}

	<T> void assertInjected(T expected, TypeLiteral<T> type, MappingModule module) {
		assertInjected(expected, Key.get(type), module);
	}

	<T> void assertInjected(T expected, Key<T> key, MappingModule module) {
		Injector injector = Guice.createInjector(module);
		T actual = injector.getInstance(key);
		assertThat(actual, is(expected));
	}

	<T> void assertAnnotated(T expected, Class<? super T> expectedType, MappingModule module) {
		class Injectee {
			@Inject
			@Named("answer")
			Number theAnswer;
		}

		Injectee injectee = new Injectee();

		Injector injector = Guice.createInjector(module);
		injector.injectMembers(injectee);
		assertThat(injectee.theAnswer, instanceOf(expectedType));
		assertThat(expectedType.cast(injectee.theAnswer), is(expected));
	}

	//
	// Nested types
	//

	static final class MutableInteger extends Number {
		private static final long serialVersionUID = 1L;

		private int intValue;

		public MutableInteger() {
			this(0);
		}

		public MutableInteger(int intValue) {
			super();

			set(intValue);
		}

		public void set(int intValue) {
			this.intValue = intValue;
		}

		@Override
		public int intValue() {
			return intValue;
		}

		@Override
		public long longValue() {
			return intValue;
		}

		@Override
		public float floatValue() {
			return intValue;
		}

		@Override
		public double doubleValue() {
			return intValue;
		}

		@Override
		public int hashCode() {
			return intValue;
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof Number) && (((Number) obj).intValue() == intValue());
		}
	}

}
