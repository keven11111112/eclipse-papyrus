/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.dev.types.utils;

import java.util.Comparator;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class IElementTypeComparator implements Comparator<IElementType> {

	@Override
	public int compare(IElementType o1, IElementType o2) {
		return o1.getId().compareTo(o2.getId());
	}
}