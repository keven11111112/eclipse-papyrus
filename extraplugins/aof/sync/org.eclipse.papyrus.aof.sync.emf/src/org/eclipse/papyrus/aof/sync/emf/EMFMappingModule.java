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

package org.eclipse.papyrus.aof.sync.emf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Provider;
import javax.inject.Singleton;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.sync.AutoDisableHook;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.IMappingContext;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.MappingModule;

import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;

/**
 * Guice configuration for mappings in the EMF domain, providing at least
 * <ul>
 * <li>the {@link EMFFactory} instance for the {@link IFactory} binding</li>
 * <li>an optional {@link EditingDomain} (also as a {@link TransactionalEditingDomain} if that is what is provided)</li>
 * </ul>
 */
public abstract class EMFMappingModule extends MappingModule {
	public EMFMappingModule() {
		super();
	}

	@Override
	protected IFactory getDefaultFactory() {
		return EMFFactory.INSTANCE;
	}

	@Override
	protected void configure() {
		super.configure();

		// Compute the explicit bindings that we have for auto-disable hooks
		Set<java.lang.Class<?>> autoDisableHooks = Stream.of(getClass().getMethods())
				.filter(m -> m.isAnnotationPresent(AutoDisableHook.class))
				.map(Method::getGenericReturnType)
				.map(this::getAutoDisableHookType)
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());

		// Automatically add auto-disable hooks for all other compatible bindings
		Stream.of(getClass().getMethods())
				.map(Method::getGenericReturnType)
				.map(this::getMappedType)
				.filter(Objects::nonNull)
				.filter(t -> !autoDisableHooks.contains(t))
				.filter(EModelElement.class::isAssignableFrom)
				.forEach(this::bindAutoDisableHook);
	}

	private java.lang.Class<?> getAutoDisableHookType(java.lang.reflect.Type type) {
		java.lang.Class<?> result = null;

		// Look for the hook type X in any type like
		// - BiConsumer<IBox<? extends X>, ?>
		// - BiConsumer<IBox<X>, ?>
		java.lang.reflect.Type bound = unwrapBoundType(type);
		if (bound instanceof ParameterizedType) {
			// Look for BiConsumer
			ParameterizedType generic = (ParameterizedType) type;
			if (generic.getRawType() == BiConsumer.class) {
				type = unwrapWildcardType(generic.getActualTypeArguments()[0]);
			} else {
				type = null;
			}

			// And the IBox type
			if (type instanceof ParameterizedType) {
				generic = (ParameterizedType) type;

				if (generic.getRawType() == IBox.class) {
					type = unwrapWildcardType(generic.getActualTypeArguments()[0]);

					if (type instanceof java.lang.Class<?>) {
						result = (java.lang.Class<?>) type;
					}
				}
			}
		}

		return result;
	}

	/**
	 * Unwrap any {@literal Class<?>}, {@literal Provider<?>}, or {@literal Constructor<?>}
	 * to obtain the core type. If that type is a wildcard, then its upper bound is
	 * returned.
	 */
	protected java.lang.reflect.Type unwrapBoundType(java.lang.reflect.Type type) {
		java.lang.reflect.Type result = type;

		if (type instanceof ParameterizedType) {
			ParameterizedType generic = (ParameterizedType) type;
			java.lang.reflect.Type raw = generic.getRawType();
			if ((raw == java.lang.Class.class)
					|| (raw == Provider.class)
					|| (raw == com.google.inject.Provider.class)
					|| (raw == Constructor.class)) {

				result = unwrapWildcardType(generic.getActualTypeArguments()[0]);
			}
		}

		return result;
	}

	/**
	 * Unwraps a possible wildcard type: returns the upper bound {@code X} if {@code type} is
	 * like {@code ? extends X}, otherwise just the original {@code type}.
	 */
	protected java.lang.reflect.Type unwrapWildcardType(java.lang.reflect.Type type) {
		java.lang.reflect.Type result = type;

		if (type instanceof WildcardType) {
			WildcardType wildcard = (WildcardType) type;
			java.lang.reflect.Type[] bound = wildcard.getUpperBounds();
			if (bound.length == 1) {
				result = bound[0];
			}
		}

		return result;
	}

	private java.lang.Class<?> getMappedType(java.lang.reflect.Type type) {
		java.lang.Class<?> result = null;

		// Look for the mapped X type in any type like
		// - IMapping<?, X>
		// - ISyncMapping<X>
		java.lang.reflect.Type bound = unwrapBoundType(type);
		if (bound instanceof ParameterizedType) {
			// Look for IMapping/ISyncMapping
			ParameterizedType generic = (ParameterizedType) bound;
			if (generic.getRawType() == ISyncMapping.class) {
				type = unwrapWildcardType(generic.getActualTypeArguments()[0]);
			} else if (generic.getRawType() == IMapping.class) {
				type = unwrapWildcardType(generic.getActualTypeArguments()[1]);
			} else {
				type = null;
			}

			if (type instanceof java.lang.Class<?>) {
				result = (java.lang.Class<?>) type;
			}
		}

		return result;
	}

	private void bindAutoDisableHook(java.lang.Class<?> type) {
		ParameterizedType hookType = Types.newParameterizedType(
				BiConsumer.class,
				Types.newParameterizedType(IBox.class,
						Types.subtypeOf(type)),
				Object.class);

		@SuppressWarnings("unchecked")
		TypeLiteral<BiConsumer<IBox<? extends EModelElement>, Object>> key = (TypeLiteral<BiConsumer<IBox<? extends EModelElement>, Object>>) TypeLiteral.get(hookType);
		@SuppressWarnings("unchecked")
		TypeLiteral<? extends BiConsumer<IBox<? extends EModelElement>, Object>> binding = (TypeLiteral<? extends BiConsumer<IBox<? extends EModelElement>, Object>>) TypeLiteral.get(EcoreAutoDisableHook.class);

		bind(Key.get(key, AutoDisableHook.class)).to(binding);
	}

	protected Provider<? extends EditingDomain> getEditingDomainBinding() {
		return () -> null;
	}

	@Provides
	public TransactionalEditingDomain provideTransactionalEditingDomain(EditingDomain domain) {
		return (domain instanceof TransactionalEditingDomain) ? (TransactionalEditingDomain) domain : null;
	}

	@Singleton
	public Class<? extends IMappingContext> getMappingContextBinding() {
		return EMFMappingContext.class;
	}
}
