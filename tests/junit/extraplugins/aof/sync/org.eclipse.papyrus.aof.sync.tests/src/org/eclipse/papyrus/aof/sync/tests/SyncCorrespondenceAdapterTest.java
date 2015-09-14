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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.inject.Inject;

import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.tests.runners.GuiceRunner;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

/**
 * Test cases for adaptation of synchronizing {@link ICorrespondenceResolver}s.
 */
@RunWith(GuiceRunner.class)
@InjectWith(SyncCorrespondenceAdapterTest.TestModule.class)
public class SyncCorrespondenceAdapterTest {

	@Inject
	private Injector injector;

	public SyncCorrespondenceAdapterTest() {
		super();
	}

	@Test
	public void syncAdapter() {
		class InjectField {
			@Inject
			ISyncCorrespondenceResolver<Integer, String> injectedField;
		}
		InjectField injectField = new InjectField();
		injector.injectMembers(injectField);

		assertInjection(injectField.injectedField, 17, "hello", 42);
	}

	@Test
	public void noAdapter() {
		class InjectMethod {
			private ICorrespondenceResolver<String, Integer, String> injectedByMethod;

			@Inject
			void setInjectedByMethod(ICorrespondenceResolver<String, Integer, String> correspondence) {
				this.injectedByMethod = correspondence;
			}
		}
		InjectMethod injectMethod = new InjectMethod();
		injector.injectMembers(injectMethod);

		assertInjection(injectMethod.injectedByMethod, "17", "hello", 42);
	}

	static class InjectConstructor {
		final ISyncCorrespondenceResolver<String, String> injectedField;

		@Inject
		InjectConstructor(ISyncCorrespondenceResolver<String, String> correspondence) {
			this.injectedField = correspondence;
		}
	}

	@Test
	public void syncNoAdapterNeeded() {
		InjectConstructor injectConstructor = injector.getInstance(InjectConstructor.class);

		assertInjection(injectConstructor.injectedField, "yes", "hello", "world");
	}

	//
	// Test framework
	//

	void basicAssertInjection(ICorrespondenceResolver<Integer, Integer, String> correspondence) {
		assertThat("Not injected", correspondence, notNullValue());
		assertThat("Not cached", correspondence.cached(), sameInstance(correspondence));
	}

	<F, T, C> void assertInjection(ICorrespondenceResolver<F, T, C> correspondence, F from, C context, T expected) {
		assertThat("Not injected", correspondence, notNullValue());

		T correspondent = correspondence.getCorrespondent(from, context);

		assertThat(correspondent, is(expected));
	}

	public static class TestModule extends MappingModule {

		public ICorrespondenceResolver<Integer, Integer, String> getCouldHaveBeenSyncCorrespondenceBinding() {
			return this::trivialIntCorrespondence;
		}

		public ICorrespondenceResolver<String, Integer, String> getNonSyncCorrespondenceBinding() {
			return this::trivialIntCorrespondence;
		}

		public ISyncCorrespondenceResolver<String, String> getSyncCorrespondenceBinding() {
			return this::trivialStringCorrespondence;
		}

		private <F, C> Integer trivialIntCorrespondence(F from, C context) {
			return 42;
		}

		private <F, C> String trivialStringCorrespondence(F from, C context) {
			return "world";
		}
	}
}
