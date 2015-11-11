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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.aof.sync.internal.CustomInjectionModule;
import org.eclipse.papyrus.aof.sync.internal.GuiceUtil;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * A factory of {@linkplain IMapping mappings} for some domain. It uses Google Guice
 * to configure the {@linkplain IMapping mapping rules}, {@linkplain ICorrespondenceResolver correspondences},
 * and other parameters.
 */
public class MappingFactory implements IMappingProvider {
	private final Injector guice;

	public MappingFactory() {
		this(new MappingModule());
	}

	public MappingFactory(Module module, Module... more) {
		super();

		List<Module> myModules = Arrays.asList(new CustomInjectionModule(), new AbstractModule() {

			@Override
			protected void configure() {
				// Make myself available for injection
				bind(MappingFactory.class).toInstance(MappingFactory.this);
				bind(IMappingProvider.class).toInstance(MappingFactory.this);
			}
		});

		List<Module> userModules = new ArrayList<>(1 + more.length);
		userModules.add(module);
		Collections.addAll(userModules, more);

		guice = Guice.createInjector(Modules.override(userModules).with(myModules));
	}

	@Override
	public final <F, T> IMapping<F, T> getMapping(Type fromType, Type toType) {
		return getInstance(IMapping.class, fromType, toType);
	}

	@Override
	public final boolean hasMapping(Type fromType, Type toType) {
		return !guice.findBindingsByType(GuiceUtil.getTypeLiteral(IMapping.class, fromType, toType)).isEmpty();
	}

	/**
	 * Obtains a simple mapping relation between objects of the specified {@code type}.
	 * 
	 * @param type
	 *            the mapping type
	 * 
	 * @return the mapping
	 */
	public final <E> ISyncMapping<E> getSyncMapping(Type type) {
		return getInstance(ISyncMapping.class, type);
	}

	/**
	 * Obtains the Guice-supplied binding for the specified {@code key}.
	 * 
	 * @param key
	 *            a binding key
	 * 
	 * @return the bound object
	 */
	public final <T> T getInstance(Key<T> key) {
		return guice.getInstance(key);
	}

	/**
	 * Obtains a Guice-supplied binding for a {@link Key} specified by the given type signature.
	 * 
	 * @param baseType
	 *            the base type of the injected type signature
	 * @param arguments
	 *            optional sequence of types substituted for the generic type parameters of the {@code baseType}
	 * 
	 * @return the bound object
	 */
	public final <T> T getInstance(Class<?> baseType, Type... arguments) {
		return getInstance(MappingModule.key(baseType, arguments));
	}
}
