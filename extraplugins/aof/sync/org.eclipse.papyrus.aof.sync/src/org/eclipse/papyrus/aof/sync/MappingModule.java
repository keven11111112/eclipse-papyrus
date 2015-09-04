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

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.stream.Stream;

import javax.inject.Qualifier;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.sync.internal.GuiceUtil;

import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.util.Types;

/**
 * A partial implementation (meant to be subclasses) of a Guice module for configuration
 * of mappings in a {@link MappingFactory}.
 */
public class MappingModule extends AbstractModule {
	/**
	 * <p>
	 * Automatically discovers and registers bindings from methods of the form
	 * </p>
	 * <blockquote>
	 * [{@literal @}<i>Q</i>]
	 * public {@link Class}{@literal <}? extends <i>T</i>{@literal >} get<i>Xyz</i>Mapping();
	 * </blockquote>
	 * <p>
	 * where
	 * </p>
	 * <ul>
	 * <li><i>Q</i> is an optional {@linkplain Qualifier qualifier} annotation for the binding (e.g., {@link Named @Named})</li>
	 * <li><i>T</i> is the (generic) type for which the binding is to be registered</li>
	 * <li><i>Xyz</i> is just a generic name of the binding, to distinguish it from other binding methods</li>
	 * </ul>
	 */
	@Override
	protected void configure() {
		// Process polymorphic binding methods
		Stream.of(getClass().getMethods())
				.filter(MappingModule::isBindingDeclaration)
				.forEach(this::bindReflective);
	}

	/**
	 * Provider method for the AOF factory appropriate for the domain of the mappings.
	 * 
	 * @return the AOF factory
	 */
	@Provides
	public IFactory provideFactory() {
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
	 * @param elementType
	 *            the type of elements for which to query correspondence
	 * @param contextType
	 *            the type of context object in which to search for or create corresponding elements
	 * 
	 * @return the bound correspondence relation
	 */
	protected <E, C> Provider<ICorrespondenceResolver<E, C>> getCorrespondenceResolver(java.lang.Class<E> elementType, java.lang.Class<C> contextType) {
		return getProvider(key(ICorrespondenceResolver.class, elementType, contextType));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void bindReflective(Method bindingMethod) {
		ParameterizedType typeSignature = (ParameterizedType) bindingMethod.getGenericReturnType();
		Type type = typeSignature.getActualTypeArguments()[0];
		if (type instanceof WildcardType) {
			WildcardType wildcard = (WildcardType) type;
			type = wildcard.getUpperBounds()[0];
		}

		Annotation annotation = GuiceUtil.findBindingAnnotation(bindingMethod);
		Key<?> key = (annotation == null) ? Key.get(type) : Key.get(type, annotation);

		try {
			bind(key).to((Class) bindingMethod.invoke(this));
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
		boolean result = false;

		String name = method.getName();
		if (name.startsWith("get") && name.endsWith("Binding")) {
			Type returnType = method.getGenericReturnType();
			if (returnType instanceof ParameterizedType) {
				ParameterizedType type = (ParameterizedType) returnType;
				result = type.getRawType() == Class.class;
			}
		}

		return result;
	}
}
