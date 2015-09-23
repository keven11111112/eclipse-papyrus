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

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.emf.EMFSyncMapping;

/**
 * Mapping of size layout constraints on nodes.
 */
@Singleton
public class SizeMapping extends EMFSyncMapping<Size> {
	@Inject
	public SizeMapping(IFactory factory) {
		super(NotationPackage.Literals.SIZE, factory);
	}

	@Override
	protected void mapProperties(IOne<Size> from, IOne<Size> to) {
		bindProperty(from, to, NotationPackage.Literals.SIZE__WIDTH);
		bindProperty(from, to, NotationPackage.Literals.SIZE__HEIGHT);
	}

}
