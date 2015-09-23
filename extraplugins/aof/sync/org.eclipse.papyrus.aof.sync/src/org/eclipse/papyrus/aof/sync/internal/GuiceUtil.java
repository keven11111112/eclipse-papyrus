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

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.inject.Qualifier;

import com.google.inject.BindingAnnotation;
import com.google.inject.Key;
import com.google.inject.ScopeAnnotation;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.util.Types;

/**
 * Utilities for working with Google Guice.
 */
public class GuiceUtil {

	/**
	 * Not instantiable by clients.
	 */
	private GuiceUtil() {
		super();
	}

	public static Annotation findQualifierAnnotation(AnnotatedElement annotated, TypeEncounter<?> encounter) {
		return findQualifierAnnotation(annotated, encounter::addError);
	}

	public static Annotation findQualifierAnnotation(AnnotatedElement annotated) {
		BiFunction<String, Object[], String> format = String::format;
		BiConsumer<String, Object[]> fail = (pattern, args) -> {
			throw new IllegalArgumentException(format.apply(pattern, args));
		};

		return findQualifierAnnotation(annotated, fail);
	}

	private static Annotation findQualifierAnnotation(AnnotatedElement annotated, BiConsumer<String, Object[]> errors) {
		Annotation result = null;

		for (Annotation next : annotated.getAnnotations()) {
			Class<? extends Annotation> type = next.annotationType();
			if (type.isAnnotationPresent(Qualifier.class) || type.isAnnotationPresent(BindingAnnotation.class)) {
				if (result != null) {
					errors.accept("Multiple binding annotations on %s", new Object[] { annotated });
					break;
				} else {
					result = next;
				}
			}
		}

		return result;
	}

	public static Annotation findScopeAnnotation(AnnotatedElement annotated, TypeEncounter<?> encounter) {
		return findScope(annotated, encounter::addError);
	}

	public static Annotation findScopeAnnotation(AnnotatedElement annotated) {
		BiFunction<String, Object[], String> format = String::format;
		BiConsumer<String, Object[]> fail = (pattern, args) -> {
			throw new IllegalArgumentException(format.apply(pattern, args));
		};

		return findScope(annotated, fail);
	}

	private static Annotation findScope(AnnotatedElement annotated, BiConsumer<String, Object[]> errors) {
		Annotation result = null;

		for (Annotation next : annotated.getAnnotations()) {
			Class<? extends Annotation> type = next.annotationType();
			if (type.isAnnotationPresent(javax.inject.Scope.class) || type.isAnnotationPresent(ScopeAnnotation.class)) {
				if (result != null) {
					errors.accept("Multiple scope annotations on %s", new Object[] { annotated });
					break;
				} else {
					result = next;
				}
			}
		}

		return result;
	}

	/**
	 * Create a key like the given {@code key}, having the same annotation details (if any)
	 * but the different new type.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Key<T> keyLike(Key<?> key, Type newType) {
		return (key.getAnnotation() != null)
				? (Key<T>) Key.get(newType, key.getAnnotation())
				: (key.getAnnotationType() != null)
						? (Key<T>) Key.get(newType, key.getAnnotationType())
						: (Key<T>) Key.get(newType);
	}

	/**
	 * Obtains a view of the specified {@code builder} that exposes only the {@link ScopedBindingBuilder}
	 * protocol, not also {@link LinkedBindingBuilder}.
	 * 
	 * @param builder
	 *            a scoped binding builder
	 * 
	 * @return only a scoped binding builder
	 */
	public static ScopedBindingBuilder scopedOnly(ScopedBindingBuilder builder) {
		return !(builder instanceof LinkedBindingBuilder<?>) ? builder : new ScopedBindingBuilderProxy(builder);
	}

	public static <T> AnnotatedBindingBuilder<T> nullBindingBuilder() {
		return NullBindingBuilder.getInstance();
	}

	/**
	 * Utility for construction of a type literal from a generic type signature.
	 * 
	 * @param baseType
	 *            the base type of the injected type signature
	 * @param arguments
	 *            optional sequence of types substituted for the generic type parameters of the {@code baseType}
	 * 
	 * @return the complex type literal
	 */
	@SuppressWarnings("unchecked")
	public static <T> TypeLiteral<T> getTypeLiteral(Class<?> baseType, Type... arguments) {
		if (arguments.length == 0) {
			return TypeLiteral.get((Class<T>) baseType);
		} else if (baseType.getDeclaringClass() != null) {
			return (TypeLiteral<T>) TypeLiteral.get(Types.newParameterizedTypeWithOwner(
					baseType.getDeclaringClass(), baseType, arguments));
		} else {
			return (TypeLiteral<T>) TypeLiteral.get(Types.newParameterizedType(baseType, arguments));
		}
	}

}
