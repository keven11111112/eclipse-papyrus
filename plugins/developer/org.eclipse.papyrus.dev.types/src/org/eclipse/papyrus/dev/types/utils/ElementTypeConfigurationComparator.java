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

import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;

public class ElementTypeConfigurationComparator implements Comparator<ElementTypeConfiguration> {

	@Override
	public int compare(ElementTypeConfiguration o1, ElementTypeConfiguration o2) {
		return o1.getName().compareTo(o2.getName());
	}
}