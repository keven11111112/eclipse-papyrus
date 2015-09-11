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

package org.eclipse.papyrus.aof.sync.emf.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.emf.MappingCommand;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.util.Types;

/**
 * Guice configuration for mappings in the EMF domain, providing at least
 * <ul>
 * <li>a {@linkplain MappingCommand.Factory factory} for mapping commands</li>
 * </ul>
 */
public class EMFMappingModule extends MappingModule {

	public EMFMappingModule() {
		super();
	}

	@Override
	public IFactory provideFactory() {
		return EMFFactory.INSTANCE;
	}

	/**
	 * Overridden to intercept mapping bindings to auto-discover the mappings
	 * for which we may need command factories.
	 */
	@Override
	protected <T> LinkedBindingBuilder<T> bind(Key<T> key) {
		LinkedBindingBuilder<T> result = super.bind(key);

		// If the key is a mapping type, bind the corresponding command factory
		if (key.getTypeLiteral().getRawType() == IMapping.class) {
			bindMappingCommandFactory(key);
		}

		return result;
	}

	/**
	 * Overridden to intercept mapping bindings to auto-discover the mappings
	 * for which we may need command factories.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> type) {
		AnnotatedBindingBuilder<T> result = super.bind(type);

		// If the key is a mapping type, bind the corresponding command factory
		if (type.getRawType() == IMapping.class) {
			AnnotatedBindingBuilder<T> delegate = result;
			result = (AnnotatedBindingBuilder<T>) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[] { AnnotatedBindingBuilder.class }, new InvocationHandler() {

				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					Object result = method.invoke(delegate, args);

					if (method.getDeclaringClass() == AnnotatedBindingBuilder.class) {
						Object annotation = args[0];
						Key<?> key = (annotation instanceof Annotation)
								? Key.get(type, (Annotation) annotation)
								: Key.get(type, (Class<? extends Annotation>) annotation);

						bindMappingCommandFactory(key);
					} else {
						bindMappingCommandFactory(Key.get(type));
					}

					return result;
				}
			});
		}

		return result;
	}

	/**
	 * Binds the mapping command factory for the specified mapping key.
	 * 
	 * @param mappingKey
	 *            an <tt>{@literal IMapping<E>}</tt> key
	 */
	protected <T, E extends EObject> void bindMappingCommandFactory(Key<T> mappingKey) {
		ParameterizedType mappingType = (ParameterizedType) mappingKey.getTypeLiteral().getType();
		Type elementType = mappingType.getActualTypeArguments()[0];
		Type factoryType = Types.newParameterizedTypeWithOwner(MappingCommand.class, MappingCommand.Factory.class, elementType);
		Type implementationType = Types.newParameterizedType(MappingCommandFactory.class, elementType);

		@SuppressWarnings("unchecked")
		Key<MappingCommand.Factory<E>> factoryKey = (Key<MappingCommand.Factory<E>>) //
		((mappingKey.getAnnotation() != null) ? Key.get(factoryType, mappingKey.getAnnotation())
				: (mappingKey.getAnnotationType() != null) ? Key.get(factoryType, mappingKey.getAnnotationType())
						: Key.get(factoryType));

		@SuppressWarnings("unchecked")
		Key<MappingCommandFactory<E>> implementationKey = (Key<MappingCommandFactory<E>>) Key.get(implementationType);

		bind(factoryKey).to(implementationKey);
	}
}
