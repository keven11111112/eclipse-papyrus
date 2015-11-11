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

package org.eclipse.papyrus.aof.sync.gmf.internal;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.gmf.util.ViewUtil;
import org.eclipse.papyrus.aof.sync.emf.EMFSyncMapping;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle;

import com.google.inject.Inject;

/**
 * Abstract superclass of all notation-related mappings.
 */
public abstract class NotationMapping<E extends EObject> extends EMFSyncMapping<E> {

	@Inject
	private ViewUtil viewUtil;

	public NotationMapping(Object type, IFactory factory) {
		super(type, factory);
	}

	@Override
	protected final void mapProperties(IOne<E> from, IOne<E> to) {
		if (isEnabled(to.get())) {
			// Only do mappings if I am not disabled by synchronization styles
			doMapProperties(from, to);
		}
	}

	protected boolean isEnabled(EObject target) {
		boolean result = true;
		Shape shape = viewUtil.getAncestor(target, Shape.class);

		if (shape != null) {
			result = ((Collection<?>) shape.getStyles()).stream()
					.filter(SyncStyle.class::isInstance).map(SyncStyle.class::cast)
					.allMatch(style -> style.isEnabled(NotationMapping.this, getContext()));
		}

		return result;
	}

	protected abstract void doMapProperties(IOne<E> from, IOne<E> to);
}
