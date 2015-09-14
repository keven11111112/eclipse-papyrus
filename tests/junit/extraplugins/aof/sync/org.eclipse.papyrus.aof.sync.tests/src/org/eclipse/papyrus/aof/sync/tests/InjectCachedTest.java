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

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.annotation.Retention;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.inject.Qualifier;

import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.InjectCached;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.internal.CustomInjectionModule;
import org.eclipse.papyrus.aof.sync.tests.runners.GuiceRunner;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.BindingAnnotation;
import com.google.inject.ConfigurationException;
import com.google.inject.Injector;

/**
 * Test cases for custom injection via the {@link InjectCached @InjectCached} annotation.
 */
@RunWith(GuiceRunner.class)
@InjectWith(InjectCachedTest.TestModule.class)
public class InjectCachedTest {

	@Inject
	private Injector injector;

	public InjectCachedTest() {
		super();
	}

	@Test
	public void injectField() {
		class InjectField {
			@InjectCached
			ISyncCorrespondenceResolver<Integer, String> injectedField;
		}
		InjectField injectField = new InjectField();
		injector.injectMembers(injectField);

		assertInjection(injectField.injectedField);
	}

	@Test
	public void injectMethod() {
		class InjectMethod {
			private ICorrespondenceResolver<Integer, Integer, String> injectedByMethod;

			@InjectCached
			void setInjectedByMethod(ICorrespondenceResolver<Integer, Integer, String> correspondence) {
				this.injectedByMethod = correspondence;
			}
		}
		InjectMethod injectMethod = new InjectMethod();
		injector.injectMembers(injectMethod);

		assertInjection(injectMethod.injectedByMethod);
	}

	@Test(expected = ConfigurationException.class)
	public void injectNonCacheableField() {
		Object injectee = new Object() {
			@InjectCached
			Date now;
		};

		injector.injectMembers(injectee);
	}

	@Test(expected = ConfigurationException.class)
	public void injectNonCacheableMethod() {
		Object injectee = new Object() {
			@InjectCached
			void setNow(Date now) {
				// Pass
			}
		};

		injector.injectMembers(injectee);
	}

	@Test(expected = ConfigurationException.class)
	public void injectMultiParametersMethod() {
		Object injectee = new Object() {
			@InjectCached
			void setNow(ISyncCorrespondenceResolver<Integer, String> correspondence, String bogus) {
				// Pass
			}
		};

		injector.injectMembers(injectee);
	}

	@Test
	public void injectQualifiedField() {
		class InjectField {
			@InjectCached
			@Special
			ISyncCorrespondenceResolver<Integer, String> injectedField;
		}
		InjectField injectField = new InjectField();
		injector.injectMembers(injectField);

		assertSpecialInjection(injectField.injectedField);
	}

	@Test
	public void injectAnnotatedField() {
		class InjectField {
			@InjectCached
			@Guicy
			ICorrespondenceResolver<Integer, Integer, String> injectedField;
		}
		InjectField injectField = new InjectField();
		injector.injectMembers(injectField);

		assertGuicyInjection(injectField.injectedField);
	}

	@Test
	public void injectQualifiedMethod() {
		class InjectMethod {
			private ICorrespondenceResolver<Integer, Integer, String> injectedByMethod;

			@InjectCached
			void setInjectedByMethod(@Special ICorrespondenceResolver<Integer, Integer, String> correspondence) {
				this.injectedByMethod = correspondence;
			}
		}
		InjectMethod injectMethod = new InjectMethod();
		injector.injectMembers(injectMethod);

		assertSpecialInjection(injectMethod.injectedByMethod);
	}

	@Test
	public void injectAnnotatedMethod() {
		class InjectMethod {
			private ISyncCorrespondenceResolver<Integer, String> injectedByMethod;

			@InjectCached
			void setInjectedByMethod(@Guicy ISyncCorrespondenceResolver<Integer, String> correspondence) {
				this.injectedByMethod = correspondence;
			}
		}
		InjectMethod injectMethod = new InjectMethod();
		injector.injectMembers(injectMethod);

		assertGuicyInjection(injectMethod.injectedByMethod);
	}

	@Test(expected = ConfigurationException.class)
	public void injectThrowsCheckedMethod() {
		Object injectee = new Object() {
			@InjectCached
			void setNow(ICorrespondenceResolver<Integer, Integer, String> correspondence) throws ExecutionException {
				// Pass
			}
		};

		injector.injectMembers(injectee);
	}

	@Test(expected = ConfigurationException.class)
	public void injectOverqualifiedField() {
		class InjectField {
			@InjectCached
			@Special
			@Guicy
			ISyncCorrespondenceResolver<Integer, String> injectedField;
		}
		InjectField injectField = new InjectField();
		injector.injectMembers(injectField);
	}

	@Test(expected = ConfigurationException.class)
	public void injectOverqualifiedMethod() {
		class InjectMethod {
			@InjectCached
			void setInjectedByMethod(@Special @Guicy ICorrespondenceResolver<Integer, Integer, String> correspondence) {
				// Pass
			}
		}
		InjectMethod injectMethod = new InjectMethod();
		injector.injectMembers(injectMethod);
	}

	//
	// Test framework
	//

	void basicAssertInjection(ICorrespondenceResolver<Integer, Integer, String> correspondence) {
		assertThat("Not injected", correspondence, notNullValue());
		assertThat("Not cached", correspondence.cached(), sameInstance(correspondence));
	}

	void assertInjection(ICorrespondenceResolver<Integer, Integer, String> correspondence) {
		basicAssertInjection(correspondence);
		assertThat("Wrong instance injected", correspondence.getCorrespondent(1, "hello"), is((int) 'e'));
	}

	void assertSpecialInjection(ICorrespondenceResolver<Integer, Integer, String> correspondence) {
		basicAssertInjection(correspondence);
		assertThat("Wrong instance injected", correspondence.getCorrespondent(1, "hello"), is(-(int) 'e'));
	}

	void assertGuicyInjection(ICorrespondenceResolver<Integer, Integer, String> correspondence) {
		basicAssertInjection(correspondence);
		assertThat("Wrong instance injected", correspondence.getCorrespondent(1, "hello"), is(5));
	}

	public static class TestModule extends MappingModule {
		@Override
		protected void configure() {
			super.configure();

			binder().install(new CustomInjectionModule());
		}

		public ISyncCorrespondenceResolver<Integer, String> getBasicBinding() {
			return (element, context) -> context.codePointAt(element);
		}

		@Special
		public ISyncCorrespondenceResolver<Integer, String> getSpecialBinding() {
			return (element, context) -> -context.codePointAt(element);
		}

		@Guicy
		public ISyncCorrespondenceResolver<Integer, String> getGuicyBinding() {
			return (element, context) -> context.length();
		}
	}

	@Retention(RUNTIME)
	@Qualifier
	public @interface Special {
		// Pass
	}

	@Retention(RUNTIME)
	@BindingAnnotation
	public @interface Guicy {
		// Pass
	}
}
