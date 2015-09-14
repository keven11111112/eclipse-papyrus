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

package org.eclipse.papyrus.aof.sync;

import static org.eclipse.papyrus.aof.sync.internal.GuiceUtil.nullBindingBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.inject.Named;
import javax.inject.Qualifier;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.sync.internal.BasicCorollaries;
import org.eclipse.papyrus.aof.sync.internal.BinderProxy;
import org.eclipse.papyrus.aof.sync.internal.CorollaryAnnotatedBindingBuilder;
import org.eclipse.papyrus.aof.sync.internal.CorollaryLinkedBindingBuilder;
import org.eclipse.papyrus.aof.sync.internal.GuiceUtil;

import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.util.Types;

/**
 * A partial implementation (meant to be subclassed) of a Guice module for configuration
 * of mappings in a {@link MappingFactory}. It provides a few convenient services, as
 * described in the {@link #configure()} method.
 */
public class MappingModule extends AbstractModule {
	// To support recursive corollaries
	private final Set<Key<?>> exclude = new HashSet<>();

	private final BinderProxy proxy = createBinderProxy();

	/**
	 * <p>
	 * Automatically discovers and registers bindings from methods of the form
	 * </p>
	 * <blockquote>
	 * [{@literal @}<i>Q</i>]
	 * public {@link Class}{@literal <}? extends <i>T</i>{@literal >} get<i>Xyz</i>Binding();
	 * </blockquote>
	 * <p>
	 * where
	 * </p>
	 * <ul>
	 * <li><i>Q</i> is an optional {@linkplain Qualifier qualifier} annotation for the binding (e.g., {@link Named @Named})</li>
	 * <li><i>T</i> is the (generic) type for which the binding is to be registered</li>
	 * <li><i>Xyz</i> is just a generic name of the binding, to distinguish it from other binding methods</li>
	 * </ul>
	 * <p>
	 * Also, for any {@link ISyncMapping}/{@link IMapping} or
	 * {@link ISyncCorrespondenceResolver}/{@link ICorrespondenceResolver} implementation
	 * that is bound by instance-, linked-, or constructor-binding to either
	 * {@code IMapping}/{@code ISyncMapping} or
	 * {@code ICorrespondenceResolver}/{@code ISyncCorrespondenceResolver} respectively, the
	 * other compatible binding is automatically registered, for injection of the more
	 * specific/general type. Provider bindings are not supported.
	 * </p>
	 */
	@Override
	protected void configure() {
		// Process polymorphic binding methods
		Stream.of(getClass().getMethods())
				.filter(MappingModule::isBindingDeclaration)
				.forEach(this::bindReflective);
	}

	/**
	 * Provider method for the AOF factory appropriate for the source domain of the mappings.
	 * 
	 * @return the source AOF factory
	 * 
	 * @see #getDefaultFactory()
	 */
	@Provides
	@From
	public IFactory provideFromFactory() {
		return getDefaultFactory();
	}

	/**
	 * Provider method for the AOF factory appropriate for the target domain of the mappings.
	 * 
	 * @return the target AOF factory
	 * 
	 * @see #getDefaultFactory()
	 */
	@Provides
	@To
	public IFactory provideToFactory() {
		return getDefaultFactory();
	}

	/**
	 * Provider method for the default AOF factory appropriate for {@link ISyncMapping}s,
	 * which is the domain of both the source and target.
	 * 
	 * @return the default AOF factory
	 * 
	 * @see #getDefaultFactory()
	 */
	@Provides
	public final IFactory provideDefaultFactory() {
		return getDefaultFactory();
	}

	/**
	 * Most mappings, even if they are between different types, are defined within
	 * a single domain on the source and target side. This obtains the AOF factory
	 * of that domain.
	 * 
	 * @return the default AOF domain factory
	 */
	protected IFactory getDefaultFactory() {
		return AOFFactory.INSTANCE;
	}

	/**
	 * Utility for construction of a binding key from a generic type signature.
	 * 
	 * @param baseType
	 *            the base type of the injected type signature
	 * @param arguments
	 *            optional sequence of types substituted for the generic type parameters of the {@code baseType}
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Key<T> key(java.lang.Class<?> baseType, Type... arguments) {
		if (arguments.length == 0) {
			return Key.get((Class<T>) baseType);
		} else if (baseType.getDeclaringClass() != null) {
			return (Key<T>) Key.get(Types.newParameterizedTypeWithOwner(
					baseType.getDeclaringClass(), baseType, arguments));
		} else {
			return (Key<T>) Key.get(Types.newParameterizedType(baseType, arguments));
		}
	}

	/**
	 * Utility for construction of an annotated binding key from a generic type signature.
	 * 
	 * @param annotaion
	 *            the {@linkplain BindingAnnotation binding annotation} to bind to
	 * @param baseType
	 *            the base type of the injected type signature
	 * @param arguments
	 *            optional sequence of types substituted for the generic type parameters of the {@code baseType}
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Key<T> key(Annotation annotation, java.lang.Class<?> baseType, Type... arguments) {
		if (arguments.length == 0) {
			return Key.get((Class<T>) baseType, annotation);
		} else {
			return (Key<T>) Key.get(Types.newParameterizedType(baseType, arguments), annotation);
		}
	}

	/**
	 * Obtains a provider of correspondence relations for specific element types from the injector.
	 * 
	 * @param fromType
	 *            the source type of elements for which to query correspondence
	 * @param toType
	 *            the target type of elements for which to query correspondence
	 * @param contextType
	 *            the type of context object in which to search for or create corresponding elements
	 * 
	 * @return the bound correspondence relation
	 */
	protected <F, T, C> Provider<ICorrespondenceResolver<F, T, C>> getCorrespondenceResolver(java.lang.Class<F> sourceType, java.lang.Class<T> targetType, java.lang.Class<C> contextType) {
		return getProvider(key(ICorrespondenceResolver.class, sourceType, targetType, contextType));
	}

	/**
	 * Obtains a provider of correspondence relations for specific element types from the injector.
	 * 
	 * @param type
	 *            the source and target type of elements for which to query correspondence
	 * @param contextType
	 *            the type of context object in which to search for or create corresponding elements
	 * 
	 * @return the bound correspondence relation
	 */
	protected <E, C> Provider<ICorrespondenceResolver<E, E, C>> getCorrespondenceResolver(java.lang.Class<E> type, java.lang.Class<C> contextType) {
		return getCorrespondenceResolver(type, type, contextType);
	}

	/**
	 * Obtains a provider of correspondence relations for specific element types from the injector.
	 * 
	 * @param type
	 *            the source and target type of elements for which to query correspondence
	 * @param contextType
	 *            the type of context object in which to search for or create corresponding elements
	 * 
	 * @return the bound correspondence relation
	 */
	protected <E, C> Provider<ISyncCorrespondenceResolver<E, C>> getSyncCorrespondenceResolver(java.lang.Class<E> type, java.lang.Class<C> contextType) {
		return getProvider(key(ISyncCorrespondenceResolver.class, type, contextType));
	}

	private static boolean isBindingKey(Type type) {
		boolean result = false;

		if (type instanceof ParameterizedType) {
			ParameterizedType generic = (ParameterizedType) type;
			ParameterizedType simplified = getSimplifiedType(generic);
			result = simplified != null;
		} else {
			result = (type instanceof Class<?>);
		}

		return result;
	}

	private static ParameterizedType getSimplifiedType(ParameterizedType type) {
		ParameterizedType result = null;

		// Cannot be based on a type parameter
		out: if (type.getRawType() instanceof Class<?>) {
			Type[] args = type.getActualTypeArguments();
			Type[] simplifiedArgs = new Type[args.length];

			for (int i = 0; i < args.length; i++) {
				Type next = getSimplifiedType(args[i]);
				if (next == null) {
					break out;
				}
				simplifiedArgs[i] = next;
			}

			if (type.getOwnerType() != null) {
				result = Types.newParameterizedTypeWithOwner(type.getOwnerType(), type.getRawType(), simplifiedArgs);
			} else {
				result = Types.newParameterizedType(type.getRawType(), simplifiedArgs);
			}
		}

		return result;
	}

	private static Type getSimplifiedType(Type type) {
		Type result = null;

		if (type instanceof Class<?>) {
			result = type;
		} else if (type instanceof ParameterizedType) {
			result = getSimplifiedType((ParameterizedType) type);
		} else if (type instanceof WildcardType) {
			WildcardType wildcard = (WildcardType) type;

			// Can't use a lower-bounded wildcard for bindings
			if (wildcard.getLowerBounds().length == 0) {
				Type[] bounds = wildcard.getUpperBounds();
				if (bounds.length == 0) {
					result = Object.class;
				} else {
					result = bounds[0];
				}
			}
		} // Can't use type variables for bindings

		return result;
	}

	@SuppressWarnings("unchecked")
	private void bindReflective(Method bindingMethod) {
		Annotation annotation = GuiceUtil.findBindingAnnotation(bindingMethod);

		Type type = getSimplifiedType((ParameterizedType) bindingMethod.getGenericReturnType());

		try {
			Object binding = bindingMethod.invoke(this);

			if (type instanceof Class<?>) {
				// Instance binding
				Key<?> key = (annotation == null) ? Key.get(type) : Key.get(type, annotation);
				bind((Key<Object>) key).toInstance(binding);
			} else if (type instanceof ParameterizedType) {
				ParameterizedType typeSignature = (ParameterizedType) type;
				if (typeSignature.getRawType() == Class.class) {
					// Linked binding
					Type boundType = ((ParameterizedType) type).getActualTypeArguments()[0];
					Key<?> key = (annotation == null) ? Key.get(boundType) : Key.get(boundType, annotation);
					bind((Key<Object>) key).to((Class<Object>) binding);
				} else {
					// Instance binding
					Key<?> key = (annotation == null) ? Key.get(type) : Key.get(type, annotation);
					bind((Key<Object>) key).toInstance(binding);
				}
			}
		} catch (IllegalAccessException e) {
			throw new AssertionError(e.getMessage()); // Nothing we can do about this
		} catch (InvocationTargetException e) {
			// This really shouldn't happen
			Throwable cause = e.getTargetException();
			if (cause instanceof Error) {
				throw (Error) cause;
			} else {
				throw (RuntimeException) cause;
			}
		}
	}

	private static boolean isBindingDeclaration(Method method) {
		String name = method.getName();
		return name.startsWith("get") && name.endsWith("Binding")
				&& (method.getParameterCount() == 0)
				&& isBindingKey(method.getGenericReturnType());
	}

	protected <T> Stream<? extends ScopedBindingBuilder> getCorollaries(Key<T> key, TypeLiteral<?> implementation) {
		return BasicCorollaries.getCorollaries(key, implementation, proxy);
	}

	@Override
	protected final <T> AnnotatedBindingBuilder<T> bind(Class<T> clazz) {
		return exclude.add(Key.get(clazz))
				? new CorollaryAnnotatedBindingBuilder<>(clazz, basicBind(clazz), this::getCorollaries)
				: nullBindingBuilder();
	}

	protected <T> AnnotatedBindingBuilder<T> basicBind(Class<T> clazz) {
		return super.bind(clazz);
	}

	@Override
	protected final <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral) {
		return exclude.add(Key.get(typeLiteral))
				? new CorollaryAnnotatedBindingBuilder<>(typeLiteral, basicBind(typeLiteral), this::getCorollaries)
				: nullBindingBuilder();
	}

	protected <T> AnnotatedBindingBuilder<T> basicBind(TypeLiteral<T> typeLiteral) {
		return super.bind(typeLiteral);
	}

	@Override
	protected final <T> LinkedBindingBuilder<T> bind(Key<T> key) {
		return exclude.add(key)
				? new CorollaryLinkedBindingBuilder<>(key, basicBind(key), this::getCorollaries)
				: nullBindingBuilder();
	}

	protected <T> LinkedBindingBuilder<T> basicBind(Key<T> key) {
		return super.bind(key);
	}

	private BinderProxy createBinderProxy() {
		return new BinderProxy() {
			@Override
			public <T> AnnotatedBindingBuilder<T> bind(Class<T> clazz) {
				return MappingModule.this.bind(clazz);
			}

			@Override
			public <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral) {
				return MappingModule.this.bind(typeLiteral);
			}

			@Override
			public <T> LinkedBindingBuilder<T> bind(Key<T> key) {
				return MappingModule.this.bind(key);
			}
		};
	}
}
