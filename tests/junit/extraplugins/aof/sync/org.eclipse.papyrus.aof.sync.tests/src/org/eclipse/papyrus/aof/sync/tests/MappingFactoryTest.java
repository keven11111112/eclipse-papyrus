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
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.inject.Inject;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.MappingFactory;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.SyncMapping;
import org.junit.Test;

/**
 * Test cases for the {@link MappingFactory} class.
 */
public class MappingFactoryTest {

	public MappingFactoryTest() {
		super();
	}

	@Test
	public void getInstance() {
		assertInjected(number -> number.equals(42), Number.class, new MappingModule() {
			@Override
			protected void configure() {
				super.configure();

				bind(Number.class).toInstance(42);
			}
		});
	}

	@Test
	public void getInstance_parameterized() {
		assertInjected((Supplier<Number> supplier) -> supplier.get().equals(42), Supplier.class, Number.class, new MappingModule() {
			@Override
			protected void configure() {
				super.configure();

				bind(key(Supplier.class, Number.class)).toInstance((Supplier<Number>) () -> 42);
			}
		});
	}

	@Test
	public void getMapping() {
		assertMappingInjected(42, 21, Integer.class, new MappingModule() {
			@Override
			protected void configure() {
				super.configure();

				bind(key(IMapping.class, Integer.class, Integer.class)).to(IntMapping.class);
			}
		});
	}

	//
	// Test framework
	//

	<T> void assertInjected(Predicate<? super T> assertion, Class<T> type, MappingModule module) {
		MappingFactory factory = new MappingFactory(module);
		assertThat(assertion.test(factory.getInstance(type)), is(true));
	}

	<T> void assertInjected(Predicate<? super T> assertion, Class<?> baseType, Class<?> argType, MappingModule module) {
		MappingFactory factory = new MappingFactory(module);
		assertThat(assertion.test(factory.getInstance(baseType, argType)), is(true));
	}

	<T> void assertMappingInjected(T left, T right, Class<T> type, MappingModule module) {
		MappingFactory factory = new MappingFactory(module);
		ISyncMapping<T> mapping = factory.getSyncMapping(type);
		IPair<IBox<T>, IBox<T>> pair = mapping.map(left, right);
		assertThat(pair.getLeft().get(0), is(left));
		assertThat(pair.getRight().get(0), is(right));
	}

	//
	// Nested types
	//

	static class IntMapping extends SyncMapping<Integer> {
		@Inject
		IntMapping(IFactory factory) {
			super(Integer.class, factory);
		}

		@Override
		protected void mapProperties(IOne<Integer> from, IOne<Integer> to) {
			// Pass
		}
	}


}
