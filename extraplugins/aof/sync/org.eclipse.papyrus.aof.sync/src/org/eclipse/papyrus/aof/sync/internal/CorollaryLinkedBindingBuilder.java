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
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.papyrus.aof.sync.MappingModule;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;

/**
 * A linked binding builder that automatically determines corollary bindings that should
 * be established for each binding that a {@link MappingModule} makes.
 */
public class CorollaryLinkedBindingBuilder<T, B extends LinkedBindingBuilder<T>> implements LinkedBindingBuilder<T> {
	final Key<T> key;
	final B delegate;
	final BiFunction<Key<T>, TypeLiteral<?>, Stream<? extends ScopedBindingBuilder>> corollaryFunction;

	public CorollaryLinkedBindingBuilder(Key<T> key, B delegate, BiFunction<Key<T>, TypeLiteral<?>, Stream<? extends ScopedBindingBuilder>> corollaryFunction) {
		super();

		this.key = key;
		this.delegate = delegate;
		this.corollaryFunction = corollaryFunction;
	}

	protected Stream<LinkedBindingBuilder<T>> getLinkedCorollaries(Key<T> key, Class<?> implementation) {
		return getLinkedCorollaries(key, TypeLiteral.get(implementation));
	}

	@SuppressWarnings("unchecked")
	protected Stream<LinkedBindingBuilder<T>> getLinkedCorollaries(Key<T> key, TypeLiteral<?> implementation) {
		return corollaryFunction.apply(key, implementation)
				.filter(LinkedBindingBuilder.class::isInstance)
				.map(b -> (LinkedBindingBuilder<T>) b);
	}

	@Override
	public void toInstance(T instance) {
		delegate.toInstance(instance);

		Stream<LinkedBindingBuilder<T>> corollaries = getLinkedCorollaries(key, instance.getClass());
		corollaries.forEach(corollary -> corollary.toInstance(instance));
	}

	@Override
	public ScopedBindingBuilder to(Class<? extends T> implementation) {
		return delegate(getLinkedCorollaries(key, implementation), b -> b.to(implementation));
	}

	@Override
	public ScopedBindingBuilder to(TypeLiteral<? extends T> implementation) {
		return delegate(getLinkedCorollaries(key, implementation), b -> b.to(implementation));
	}

	@Override
	public ScopedBindingBuilder to(Key<? extends T> targetKey) {
		return delegate(getLinkedCorollaries(key, targetKey.getTypeLiteral()), b -> b.to(targetKey));
	}

	@Override
	public <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> constructor) {
		return delegate(getLinkedCorollaries(key, constructor.getDeclaringClass()), b -> b.toConstructor(constructor));
	}

	@Override
	public <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> constructor, TypeLiteral<? extends S> type) {
		return delegate(getLinkedCorollaries(key, type), b -> b.toConstructor(constructor));
	}

	protected ScopedBindingBuilder delegate(Stream<LinkedBindingBuilder<T>> corollaries, Function<LinkedBindingBuilder<T>, ScopedBindingBuilder> builderFunction) {
		ScopedBindingBuilder result;

		result = builderFunction.apply(delegate);

		List<ScopedBindingBuilder> delegates = corollaries.map(builderFunction).collect(Collectors.toList());

		if (!delegates.isEmpty()) {
			delegates.add(0, result);
			result = new MultiScopedBindingBuilder(delegates);
		}

		return result;
	}

	@Override
	public void in(Class<? extends Annotation> scopeAnnotation) {
		delegate.in(scopeAnnotation);
		// No corollaries apply because we are not binding an implementation
	}

	@Override
	public void in(Scope scope) {
		delegate.in(scope);
		// No corollaries apply because we are not binding an implementation
	}

	@Override
	public void asEagerSingleton() {
		delegate.asEagerSingleton();
		// No corollaries apply because we are not binding an implementation
	}

	@Override
	public ScopedBindingBuilder toProvider(Provider<? extends T> provider) {
		return delegate.toProvider(provider);
		// No corollaries apply because we are not binding an identifiable implementation
	}

	@Override
	public ScopedBindingBuilder toProvider(Class<? extends javax.inject.Provider<? extends T>> providerType) {
		return delegate.toProvider(providerType);
		// No corollaries apply because we are not binding an identifiable implementation
	}

	@Override
	public ScopedBindingBuilder toProvider(TypeLiteral<? extends javax.inject.Provider<? extends T>> providerType) {
		return delegate.toProvider(providerType);
		// No corollaries apply because we are not binding an identifiable implementation
	}

	@Override
	public ScopedBindingBuilder toProvider(Key<? extends javax.inject.Provider<? extends T>> providerKey) {
		return delegate.toProvider(providerKey);
		// No corollaries apply because we are not binding an identifiable implementation
	}
}
