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

package org.eclipse.papyrus.aof.sync.emf;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.AutoDisableHook;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingFactory;

import com.google.inject.Inject;

/**
 * Partial implementation of a mapping for EMF models, which produces
 * mapping instances that are {@linkplain MappingInstance modeled} and attachable to a
 * {@link MappingModel}.
 */
public abstract class EMFMapping<F extends EObject, T extends EObject> extends AbstractMapping<F, T> {

	/** Optional auto-disable hook for notation mappings of my kind. */
	@Inject(optional = true)
	@AutoDisableHook
	private BiConsumer<IBox<? extends T>, Object> autoDisableHook;

	public EMFMapping(Object fromType, IFactory fromFactory, Object toType, IFactory toFactory) {
		super(fromType, fromFactory, toType, toFactory);
	}

	@Override
	protected InternalInstance<F, T> createMappingInstance(IOne<F> from, IOne<T> to) {
		MappingInstance<F, T> result = SyncMappingFactory.eINSTANCE.createMappingInstance();

		result.setType(this);
		result.setLeft(from);
		result.setRight(to);

		return result;
	}

	@Override
	protected BiConsumer<IBox<? extends T>, Object> getAutoDisableHook() {
		return autoDisableHook;
	}

	@Override
	protected boolean isSyncEnabled(IBox<? extends T> toBox, Object identifiedBy) {
		return EcoreAutoDisableHook.isSyncEnabled(toBox, identifiedBy, getAutoDisableHook());
	}

}
