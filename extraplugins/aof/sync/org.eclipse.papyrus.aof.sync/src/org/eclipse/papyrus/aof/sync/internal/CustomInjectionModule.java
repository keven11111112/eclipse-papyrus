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

import static org.eclipse.papyrus.aof.sync.internal.GuiceUtil.findBindingAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;

import org.eclipse.papyrus.aof.sync.CacheProvider;
import org.eclipse.papyrus.aof.sync.InjectCached;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

/**
 * A Guice module that configures the injector for custom injection of {@link InjectCached @InjectCached}
 * injection points.
 */
public class CustomInjectionModule extends AbstractModule {

	public CustomInjectionModule() {
		super();
	}

	@Override
	protected void configure() {
		bindListener(Matchers.any(), new CacheInjectionListener());
	}

	//
	// Nested types
	//

	private static class CacheInjectionListener implements TypeListener {

		@Override
		public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
			for (Class<?> class_ = type.getRawType(); class_ != null; class_ = class_.getSuperclass()) {
				for (Field field : class_.getDeclaredFields()) {
					if (field.isAnnotationPresent(InjectCached.class)) {
						Method cacheMethod = getCacheMethod(field.getType());
						if (cacheMethod != null) {
							Annotation annotation = findBindingAnnotation(field, encounter);
							Key<?> key = (annotation == null) ? Key.get(field.getGenericType()) : Key.get(field.getGenericType(), annotation);
							encounter.register(new CachingFieldInjector<I>(field, encounter.getProvider(key), cacheMethod));
						} else {
							encounter.addError("Injected type %s does not support caching in field %s.%s", field.getType().getName(), class_.getSimpleName(), field.getName());
						}
					}
				}

				for (Method method : class_.getDeclaredMethods()) {
					if (method.isAnnotationPresent(InjectCached.class)) {
						if (method.getParameterCount() != 1) {
							encounter.addError("Cached injection not supported for method %s.%s having not exactly one parameter", class_.getSimpleName(), method.getName());
						} else {
							Class<?> checked = getCheckedException(method);
							if (checked != null) {
								encounter.addError("Cached injection not supported for method %s.%s throwing checked exception %s", class_.getSimpleName(), method.getName(), checked.getSimpleName());
							} else {
								Parameter param = method.getParameters()[0];
								Method cacheMethod = getCacheMethod(param.getType());
								if (cacheMethod != null) {
									Annotation annotation = findBindingAnnotation(param, encounter);
									Key<?> key = (annotation == null) ? Key.get(param.getParameterizedType()) : Key.get(param.getParameterizedType(), annotation);
									encounter.register(new CachingMethodInjector<I>(method, encounter.getProvider(key), cacheMethod));
								} else {
									encounter.addError("Injected type %s does not support caching in method %s.%s", param.getType().getName(), class_.getSimpleName(), method.getName());
								}
							}
						}
					}
				}
			}
		}

		Method getCacheMethod(Class<?> type) {
			return Arrays.asList(type.getMethods()).stream()
					.filter(m -> m.isAnnotationPresent(CacheProvider.class))
					.findFirst().orElse(null);
		}

		Class<?> getCheckedException(Method m) {
			Class<?> result = null;

			for (Class<?> exception : m.getExceptionTypes()) {
				if (!RuntimeException.class.isAssignableFrom(exception) && !Error.class.isAssignableFrom(exception)) {
					result = exception;
					break;
				}
			}

			return result;
		}
	}

	private static abstract class CachingMembersInjector<T> implements MembersInjector<T> {
		private static final Object NULL = new Object();

		private final Provider<?> provider;
		private final Method cacheMethod;

		private Object injectedInstance;

		CachingMembersInjector(Provider<?> provider, Method cacheMethod) {
			super();

			this.provider = provider;
			this.cacheMethod = cacheMethod;
		}

		Object getInjectedInstance() {
			Object result = injectedInstance;

			if (result == NULL) {
				result = null;
			} else if (result == null) {
				try {
					result = cacheMethod.invoke(provider.get());
				} catch (IllegalAccessException e) {
					throw new AssertionError(e); // Nothing we can do about this
				} catch (InvocationTargetException e) {
					Throwable cause = (e.getTargetException() == null) ? e : e.getTargetException();
					if (cause instanceof Error) {
						throw (Error) cause;
					} else if (cause instanceof RuntimeException) {
						throw (RuntimeException) cause;
					} else {
						throw new UndeclaredThrowableException(cause);
					}
				}

				if (result == null) {
					injectedInstance = NULL;
				} else {
					injectedInstance = result;
				}
			}

			return result;
		}
	}

	private static class CachingFieldInjector<T> extends CachingMembersInjector<T> {
		private final Field field;

		CachingFieldInjector(Field field, Provider<?> provider, Method cacheMethod) {
			super(provider, cacheMethod);

			this.field = field;

			field.setAccessible(true);
		}

		@Override
		public void injectMembers(T instance) {
			try {
				Object value = getInjectedInstance();
				field.set(instance, value);
			} catch (IllegalAccessException e) {
				throw new AssertionError(e); // Nothing we can do about this
			}
		}

	}

	private static class CachingMethodInjector<T> extends CachingMembersInjector<T> {
		private final Method method;

		CachingMethodInjector(Method method, Provider<?> provider, Method cacheMethod) {
			super(provider, cacheMethod);

			this.method = method;

			method.setAccessible(true);
		}

		@Override
		public void injectMembers(T instance) {
			try {
				Object value = getInjectedInstance();
				method.invoke(instance, value);
			} catch (IllegalAccessException e) {
				throw new AssertionError(e); // Nothing we can do about this
			} catch (InvocationTargetException e) {
				Throwable cause = (e.getTargetException() == null) ? e : e.getTargetException();
				if (cause instanceof Error) {
					throw (Error) cause;
				} else if (cause instanceof RuntimeException) {
					throw (RuntimeException) cause;
				} else {
					throw new UndeclaredThrowableException(cause);
				}
			}
		}

	}
}
