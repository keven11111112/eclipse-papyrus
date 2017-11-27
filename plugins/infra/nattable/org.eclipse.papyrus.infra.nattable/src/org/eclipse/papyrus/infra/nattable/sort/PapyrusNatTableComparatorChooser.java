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

package org.eclipse.papyrus.infra.nattable.sort;

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

}
