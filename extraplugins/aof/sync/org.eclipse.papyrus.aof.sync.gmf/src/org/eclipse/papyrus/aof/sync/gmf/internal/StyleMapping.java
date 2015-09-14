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
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.SyncMapping;

/**
 * Mapping of a discrete style attached to a view.
 */
@Singleton
public class StyleMapping extends SyncMapping<Style> {
	@Inject
	public StyleMapping(IFactory factory) {
		super(NotationPackage.Literals.STYLE, factory);
	}

	@Override
	protected void mapProperties(IOne<Style> from, IOne<Style> to) {
		from.get().eClass().getEAllAttributes().stream().forEach(attr -> bindProperty(from, to, attr));
	}

}
