/*****************************************************************************
 * Copyright (c) 2015, 2020 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 562619
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.sort;

import java.util.Comparator;

import org.eclipse.papyrus.infra.nattable.sort.copy.NatTableComparatorChooser;

import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.gui.TableFormat;

/**
 * @author Vincent Lorenzo
 *
 */
public class PapyrusNatTableComparatorChooser extends NatTableComparatorChooser<Object> {

	/**
	 * Constructor.
	 *
	 * @param sortedList
	 * @param tableFormat
	 */
	public PapyrusNatTableComparatorChooser(SortedList<Object> sortedList, TableFormat<Object> tableFormat) {
		super(sortedList, tableFormat);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.glazedlists.copy.AbstractTableComparatorChooser#rebuildComparator()
	 * @since 6.7
	 *
	 */
	@Override
	protected void rebuildComparator() {
		final Comparator<?> newComparator = sortingState.buildComparator();
		final Comparator<?> previousComparator = sortedList.getComparator();
		if (newComparator != null || previousComparator != null) {
			// bug 562619
			// in other cases, we do nothing to avoid useless notification from the event list
			super.rebuildComparator();
		}

	}
}
