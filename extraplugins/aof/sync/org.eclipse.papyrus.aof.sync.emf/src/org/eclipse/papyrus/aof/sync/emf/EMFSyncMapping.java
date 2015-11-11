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
import org.eclipse.papyrus.aof.sync.AutoDisableHook;
import org.eclipse.papyrus.aof.sync.SyncMapping;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingFactory;

import com.google.inject.Inject;

/**
 * The synchronizing mapping variant of the {@link EMFMapping}.
 */
public abstract class EMFSyncMapping<E extends EObject> extends SyncMapping<E> {

	/** Optional auto-disable hook for notation mappings of my kind. */
	@Inject(optional = true)
	@AutoDisableHook
	private BiConsumer<IBox<? extends E>, Object> autoDisableHook;

	public EMFSyncMapping(Object type, IFactory factory) {
		super(type, factory);
	}

	@Override
	protected InternalInstance<E, E> createMappingInstance(IOne<E> from, IOne<E> to) {
		MappingInstance<E, E> result = SyncMappingFactory.eINSTANCE.createMappingInstance();

		result.setType(this);
		result.setLeft(from);
		result.setRight(to);

		return result;
	}

	@Override
	protected BiConsumer<IBox<? extends E>, Object> getAutoDisableHook() {
		return autoDisableHook;
	}

	@Override
	protected boolean isSyncEnabled(IBox<? extends E> toBox, Object identifiedBy) {
		return EcoreAutoDisableHook.isSyncEnabled(toBox, identifiedBy, getAutoDisableHook());
	}
}
