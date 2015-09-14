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

package org.eclipse.papyrus.aof.sync.internal;

import static org.eclipse.papyrus.aof.sync.internal.GuiceUtil.scopedOnly;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.Pair;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.util.Types;

/**
 * Utility methods for computing the corollaries of known binding types.
 */
public class BasicCorollaries {

	private static final Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, TypeLiteral<?>>> COROLLARY_KEYS = new HashMap<>();
	private static final Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, IPair<TypeLiteral<?>, TypeLiteral<?>>>> COROLLARY_IMPLEMENTATIONS = new HashMap<>();

	// These corollary keys aren't actually on the same type but they
	// should make safe bindings because we only compute keys for which
	// this implementation class is actually compatible
	static {
		configureMapping(COROLLARY_KEYS);
		configureCorrespondenceResolver(COROLLARY_KEYS);
		configureSyncMapping(COROLLARY_KEYS);
		configureSyncCorrespondenceResolver(COROLLARY_KEYS);

		configureMappingAdapter(COROLLARY_IMPLEMENTATIONS);
		configureCorrespondenceResolverAdapter(COROLLARY_IMPLEMENTATIONS);
	}

	/**
	 * Not instantiable by clients.
	 */
	private BasicCorollaries() {
		super();
	}

	public static <T> Stream<? extends ScopedBindingBuilder> getCorollaries(Key<T> key, TypeLiteral<?> implementation, BinderProxy binder) {
		Stream<? extends ScopedBindingBuilder> keys = COROLLARY_KEYS.entrySet().stream()
				.filter(entry -> entry.getKey().test(key, implementation))
				.map(entry -> entry.getValue().apply(key.getTypeLiteral()))
				.map(corollary -> binder.bind(GuiceUtil.<T> keyLike(key, corollary.getType())));

		// These must be ScopedBindingBuilders that are *not* LinkedBindingBuilders,
		// which the default Guice implementation of ScopedBindingBuilders are
		@SuppressWarnings("unchecked")
		Stream<? extends ScopedBindingBuilder> implementations = COROLLARY_IMPLEMENTATIONS.entrySet().stream()
				.filter(entry -> entry.getKey().test(key, implementation))
				.map(entry -> entry.getValue().apply(key.getTypeLiteral()))
				.map(corollary -> scopedOnly(binder.bind(GuiceUtil.<T> keyLike(key, corollary.getLeft().getType())).to((TypeLiteral<T>) corollary.getRight())));

		return Stream.concat(keys, implementations);
	}

	private static BiPredicate<Key<?>, TypeLiteral<?>> match(Class<?> bindingRaw, Class<?> implementationRaw) {
		return new BiPredicate<Key<?>, TypeLiteral<?>>() {
			@Override
			public boolean test(Key<?> t, TypeLiteral<?> u) {
				TypeLiteral<?> binding = t.getTypeLiteral();
				TypeLiteral<?> implementation = u;

				return (binding.getRawType() == bindingRaw) && implementationRaw.isAssignableFrom(implementation.getRawType());
			}
		};
	}

	/**
	 * Matches an implementation that implements the general interface and not the {@code specific}
	 * but could have implemented the {@code specific} because its first {@code count} type parameters
	 * are the same.
	 * 
	 * @param count
	 *            how many of the first type parameters are the same in a match
	 * @param specific
	 *            the specific interface to <em>not</em> match on the implementation
	 * 
	 * @return the predicate
	 */
	private static BiPredicate<Key<?>, TypeLiteral<?>> equalParameters(int count, Class<?> specific) {
		return new BiPredicate<Key<?>, TypeLiteral<?>>() {
			@Override
			public boolean test(Key<?> t, TypeLiteral<?> u) {
				boolean result = false;
				TypeLiteral<?> binding = t.getTypeLiteral();
				Class<?> implementation = u.getRawType();

				if (!specific.isAssignableFrom(implementation) && (binding.getType() instanceof ParameterizedType)) {
					ParameterizedType generic = (ParameterizedType) binding.getType();
					Type[] args = generic.getActualTypeArguments();
					if (args.length >= count) {
						result = true;
						Type first = args[0];
						for (int i = 1; result && (i < count); i++) {
							result = args[i].equals(first);
						}
					}
				}

				return result;
			}
		};
	}

	private static void configureMapping(Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, TypeLiteral<?>>> corollaries) {
		corollaries.put(match(IMapping.class, ISyncMapping.class), mapping -> {
			// Must be a parameterized type for IMapping key
			ParameterizedType generic = (ParameterizedType) mapping.getType();
			Type[] args = generic.getActualTypeArguments();

			assert args[0].equals(args[1]) : "Mismatched type arguments in mapping key";

			return TypeLiteral.get(Types.newParameterizedType(ISyncMapping.class, args[0]));
		});
	}

	private static void configureSyncMapping(Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, TypeLiteral<?>>> corollaries) {
		corollaries.put(match(ISyncMapping.class, ISyncMapping.class), syncMapping -> {
			// Must be a parameterized type for ISyncMapping key
			ParameterizedType generic = (ParameterizedType) syncMapping.getType();
			Type[] args = generic.getActualTypeArguments();

			return TypeLiteral.get(Types.newParameterizedType(IMapping.class, args[0], args[0]));
		});
	}

	private static void configureCorrespondenceResolver(Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, TypeLiteral<?>>> corollaries) {
		corollaries.put(match(ICorrespondenceResolver.class, ISyncCorrespondenceResolver.class), mapping -> {
			// Must be a parameterized type for ICorrespondenceResolver key
			ParameterizedType generic = (ParameterizedType) mapping.getType();
			Type[] args = generic.getActualTypeArguments();

			assert args[0].equals(args[1]) : "Mismatched type arguments in correspondence resolver key";

			return TypeLiteral.get(Types.newParameterizedType(ISyncCorrespondenceResolver.class, args[0], args[2]));
		});
	}

	private static void configureSyncCorrespondenceResolver(Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, TypeLiteral<?>>> corollaries) {
		corollaries.put(match(ISyncCorrespondenceResolver.class, ISyncCorrespondenceResolver.class), syncMapping -> {
			// Must be a parameterized type for ISyncMapping key
			ParameterizedType generic = (ParameterizedType) syncMapping.getType();
			Type[] args = generic.getActualTypeArguments();

			return TypeLiteral.get(Types.newParameterizedType(ICorrespondenceResolver.class, args[0], args[0], args[1]));
		});
	}

	private static void configureMappingAdapter(Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, IPair<TypeLiteral<?>, TypeLiteral<?>>>> corollaries) {
		corollaries.put(match(IMapping.class, IMapping.class).and(equalParameters(2, ISyncMapping.class)),
				mapping -> {
					// Must be a parameterized type for IMapping key
					ParameterizedType generic = (ParameterizedType) mapping.getType();
					Type[] args = generic.getActualTypeArguments();

					Type syncBinding = Types.newParameterizedType(ISyncMapping.class, args[0]);
					Type syncAdapter = Types.newParameterizedType(SyncMappingAdapter.class, args[0]);
					return Pair.of(TypeLiteral.get(syncBinding), TypeLiteral.get(syncAdapter));
				});
	}

	private static void configureCorrespondenceResolverAdapter(Map<BiPredicate<Key<?>, TypeLiteral<?>>, Function<TypeLiteral<?>, IPair<TypeLiteral<?>, TypeLiteral<?>>>> corollaries) {
		corollaries.put(match(ICorrespondenceResolver.class, ICorrespondenceResolver.class).and(equalParameters(2, ISyncCorrespondenceResolver.class)),
				mapping -> {
					// Must be a parameterized type for ICorrespondenceResolver key
					ParameterizedType generic = (ParameterizedType) mapping.getType();
					Type[] args = generic.getActualTypeArguments();

					Type syncBinding = Types.newParameterizedType(ISyncCorrespondenceResolver.class, args[0], args[2]);
					Type syncAdapter = Types.newParameterizedType(SyncCorrespondenceResolverAdapter.class, args[0], args[2]);
					return Pair.of(TypeLiteral.get(syncBinding), TypeLiteral.get(syncAdapter));
				});
	}

}
