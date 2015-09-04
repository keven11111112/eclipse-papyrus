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
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.inject.Qualifier;

import com.google.inject.BindingAnnotation;
import com.google.inject.spi.TypeEncounter;

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

	public static Annotation findBindingAnnotation(AnnotatedElement annotated, TypeEncounter<?> encounter) {
		return findBindingAnnotation(annotated, encounter::addError);
	}

	public static Annotation findBindingAnnotation(AnnotatedElement annotated) {
		BiFunction<String, Object[], String> format = String::format;
		BiConsumer<String, Object[]> fail = (pattern, args) -> {
			throw new IllegalArgumentException(format.apply(pattern, args));
		};

		return findBindingAnnotation(annotated, fail);
	}

	private static Annotation findBindingAnnotation(AnnotatedElement annotated, BiConsumer<String, Object[]> errors) {
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
}
