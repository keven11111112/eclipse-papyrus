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
import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.eclipse.papyrus.aof.sync.MappingModule;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;

/**
 * An annotated binding builder that automatically determines corollary bindings that should
 * be established for each binding that a {@link MappingModule} makes.
 */
public class CorollaryAnnotatedBindingBuilder<T, B extends AnnotatedBindingBuilder<T>> extends CorollaryLinkedBindingBuilder<T, B>implements AnnotatedBindingBuilder<T> {

	public CorollaryAnnotatedBindingBuilder(Class<T> class_, B delegate, BiFunction<Key<T>, TypeLiteral<?>, Stream<? extends ScopedBindingBuilder>> corollaryFunction) {
		super(Key.get(class_), delegate, corollaryFunction);
	}

	public CorollaryAnnotatedBindingBuilder(TypeLiteral<T> typeLiteral, B delegate, BiFunction<Key<T>, TypeLiteral<?>, Stream<? extends ScopedBindingBuilder>> corollaryFunction) {
		super(Key.get(typeLiteral), delegate, corollaryFunction);
	}

	@Override
	public LinkedBindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType) {
		return new CorollaryLinkedBindingBuilder<>(key, delegate.annotatedWith(annotationType), corollaryFunction);
	}

	@Override
	public LinkedBindingBuilder<T> annotatedWith(Annotation annotation) {
		return new CorollaryLinkedBindingBuilder<>(key, delegate.annotatedWith(annotation), corollaryFunction);
	}

}
