/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.sort.SortConfigAttributes;
import org.eclipse.papyrus.infra.nattable.comparator.TreeTableCellLabelProviderComparator;

/**
 * @author Vincent Lorenzo
 *         Configuration used for the sort for a tree table
 */
public class TreeTableClickSortConfiguration extends PapyrusClickSortConfiguration {


	/**
	 * @see org.eclipse.nebula.widgets.nattable.sort.config.DefaultSortConfiguration#configureRegistry(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 *
	 * @param configRegistry
	 */
	@Override
	public void configureRegistry(IConfigRegistry configRegistry) {
		super.configureRegistry(configRegistry);
		configRegistry.registerConfigAttribute(SortConfigAttributes.SORT_COMPARATOR, new TreeTableCellLabelProviderComparator(configRegistry));
	}

}
