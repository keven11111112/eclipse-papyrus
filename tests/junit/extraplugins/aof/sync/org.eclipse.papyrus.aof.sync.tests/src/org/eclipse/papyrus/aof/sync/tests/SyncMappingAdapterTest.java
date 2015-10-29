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

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers;
import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.IMappingInstance;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.SyncMapping;
import org.eclipse.papyrus.aof.sync.tests.runners.GuiceRunner;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

/**
 * Test cases for adaptation of synchronizing {@link IMapping}s.
 */
@RunWith(GuiceRunner.class)
@InjectWith(SyncMappingAdapterTest.TestModule.class)
public class SyncMappingAdapterTest {

	@Inject
	private Injector injector;

	public SyncMappingAdapterTest() {
		super();
	}

	@Test
	public void syncAdapter() {
		class InjectField {
			@Inject
			ISyncMapping<Integer> injectedField;
		}
		InjectField injectField = new InjectField();
		injector.injectMembers(injectField);

		assertInjection(injectField.injectedField, 42, 17);
	}

	@Test
	public void noAdapter() {
		class InjectMethod {
			private IMapping<Integer, String> injectedByMethod;

			@Inject
			void setInjectedByMethod(IMapping<Integer, String> mapping) {
				this.injectedByMethod = mapping;
			}
		}
		InjectMethod injectMethod = new InjectMethod();
		injector.injectMembers(injectMethod);

		assertInjection(injectMethod.injectedByMethod, 42, "hello");
	}

	static class InjectConstructor {
		final ISyncMapping<String> injectedField;

		@Inject
		InjectConstructor(ISyncMapping<String> mapping) {
			this.injectedField = mapping;
		}
	}

	@Test
	public void syncNoAdapterNeeded() {
		InjectConstructor injectConstructor = injector.getInstance(InjectConstructor.class);

		assertInjection(injectConstructor.injectedField, "hello", "world");
	}

	//
	// Test framework
	//

	void basicAssertInjection(ICorrespondenceResolver<Integer, Integer, String> correspondence) {
		assertThat("Not injected", correspondence, notNullValue());
		assertThat("Not cached", correspondence.cached(), sameInstance(correspondence));
	}

	<L, R> void assertInjection(IMapping<L, R> mapping, L left, R right) {
		assertThat("Not injected", mapping, notNullValue());

		IMappingInstance<L, R> instance = mapping.map(left, right);

		assertThat(instance.getLeft(), BoxMatchers.matches(IConstraints.ONE));
		assertThat(instance.getLeft().get(0), is(left));
		assertThat(instance.getRight(), BoxMatchers.matches(IConstraints.ONE));
		assertThat(instance.getRight().get(0), is(right));
	}

	public static class TestModule extends MappingModule {

		private static IFactory factory = AOFFactory.INSTANCE;

		public IMapping<Integer, Integer> getCouldHaveBeenSyncMappingBinding() {
			return trivialMapping(Integer.class, Integer.class);
		}

		public IMapping<Integer, String> getNonSyncMappingBinding() {
			return trivialMapping(Integer.class, String.class);
		}

		public ISyncMapping<String> getSyncMappingBinding() {
			return trivialMapping(String.class);
		}

		private <L, R> IMapping<L, R> trivialMapping(Class<L> left, Class<R> right) {
			return new AbstractMapping<L, R>(left, factory, right, factory) {
				@Override
				protected void mapProperties(IOne<L> from, IOne<R> to) {
					// Pass
				}
			};
		}

		private <T> ISyncMapping<T> trivialMapping(Class<T> type) {
			return new SyncMapping<T>(type, factory) {
				@Override
				protected void mapProperties(IOne<T> from, IOne<T> to) {
					// Pass
				}
			};
		}
	}
}
