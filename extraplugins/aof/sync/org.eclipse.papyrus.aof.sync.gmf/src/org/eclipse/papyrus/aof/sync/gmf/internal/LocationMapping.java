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

import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;

/**
 * Mapping of location layout constraints on nodes.
 */
@Singleton
public class LocationMapping extends NotationMapping<Location> {
	@Inject
	public LocationMapping(IFactory factory) {
		super(NotationPackage.Literals.LOCATION, factory);
	}

	@Override
	protected void doMapProperties(IOne<Location> from, IOne<Location> to) {
		bindProperty(from, to, NotationPackage.Literals.LOCATION__X);
		bindProperty(from, to, NotationPackage.Literals.LOCATION__Y);
	}

}
