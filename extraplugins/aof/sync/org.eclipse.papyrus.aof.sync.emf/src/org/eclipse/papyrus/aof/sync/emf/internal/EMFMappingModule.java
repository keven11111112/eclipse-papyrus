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

import static org.eclipse.papyrus.aof.sync.internal.GuiceUtil.scopedOnly;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.emf.MappingCommand;
import org.eclipse.papyrus.aof.sync.internal.GuiceUtil;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.ScopedBindingBuilder;
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
	protected IFactory getDefaultFactory() {
		return EMFFactory.INSTANCE;
	}

	@Override
	protected <T> Stream<? extends ScopedBindingBuilder> getCorollaries(Key<T> key, TypeLiteral<?> implementation) {
		Stream<? extends ScopedBindingBuilder> basic = super.getCorollaries(key, implementation);

		return Stream.concat(basic, getMappingFactories(key));
	}

	protected <F extends EObject, T extends EObject> Stream<? extends ScopedBindingBuilder> getMappingFactories(Key<?> key) {
		Stream<ScopedBindingBuilder> result;

		// If the key is a mapping type, bind the corresponding command factory
		if (key.getTypeLiteral().getRawType() != IMapping.class) {
			result = Stream.empty();
		} else {
			ParameterizedType mappingType = (ParameterizedType) key.getTypeLiteral().getType();
			Type fromType = mappingType.getActualTypeArguments()[0];
			Type toType = mappingType.getActualTypeArguments()[1];
			Type factoryType = Types.newParameterizedTypeWithOwner(MappingCommand.class, MappingCommand.Factory.class, fromType, toType);
			Type implementationType = Types.newParameterizedType(MappingCommandFactory.class, fromType, toType);

			Key<MappingCommand.Factory<F, T>> factoryKey = GuiceUtil.keyLike(key, factoryType);

			@SuppressWarnings("unchecked")
			Key<MappingCommandFactory<F, T>> implementationKey = (Key<MappingCommandFactory<F, T>>) Key.get(implementationType);

			result = Stream.of(scopedOnly(basicBind(factoryKey).to(implementationKey)));
		}

		return result;
	}
}
