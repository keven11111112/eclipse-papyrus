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
import java.lang.reflect.Constructor;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;

/**
 * A full-API binding builder that does nothing.
 */
class NullBindingBuilder<T> implements AnnotatedBindingBuilder<T> {
	private static final NullBindingBuilder<Object> INSTANCE = new NullBindingBuilder<Object>();

	private NullBindingBuilder() {
		super();
	}

	@SuppressWarnings("unchecked")
	static <T> NullBindingBuilder<T> getInstance() {
		// The cast is sage because this immutable implementation does nothing with any input
		return (NullBindingBuilder<T>) INSTANCE;
	}

	@Override
	public ScopedBindingBuilder to(Class<? extends T> implementation) {
		return this;
	}

	@Override
	public ScopedBindingBuilder to(TypeLiteral<? extends T> implementation) {
		return this;
	}

	@Override
	public ScopedBindingBuilder to(Key<? extends T> targetKey) {
		return this;
	}

	@Override
	public void toInstance(T instance) {
		// Pass
	}

	@Override
	public ScopedBindingBuilder toProvider(Provider<? extends T> provider) {
		return this;
	}

	@Override
	public ScopedBindingBuilder toProvider(Class<? extends javax.inject.Provider<? extends T>> providerType) {
		return this;
	}

	@Override
	public ScopedBindingBuilder toProvider(TypeLiteral<? extends javax.inject.Provider<? extends T>> providerType) {
		return this;
	}

	@Override
	public ScopedBindingBuilder toProvider(Key<? extends javax.inject.Provider<? extends T>> providerKey) {
		return this;
	}

	@Override
	public <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> constructor) {
		return this;
	}

	@Override
	public <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> constructor, TypeLiteral<? extends S> type) {
		return this;
	}

	@Override
	public void in(Class<? extends Annotation> scopeAnnotation) {
		// Pass
	}

	@Override
	public void in(Scope scope) {
		// Pass
	}

	@Override
	public void asEagerSingleton() {
		// Pass
	}

	@Override
	public LinkedBindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType) {
		return this;
	}

	@Override
	public LinkedBindingBuilder<T> annotatedWith(Annotation annotation) {
		return this;
	}

}
