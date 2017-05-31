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

package org.eclipse.papyrus.infra.nattable.comparator;

import java.text.Collator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.sort.ISortModel;
import org.eclipse.nebula.widgets.nattable.sort.SortDirectionEnum;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.manager.axis.ITreeItemAxisComparator;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TreeFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.nattable.utils.SortLabelProviderFullCellContextElementWrapper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;


/**
 * @author VL222926
 * 
 *         The comparator used to sort the rows selecting column header in case of a TreeTable
 *
 */
public class TreeTableCellLabelProviderComparator extends TableCellLabelProviderComparator {

	/**
	 * the comparator to use
	 */
	private ITreeItemAxisComparator comparator;

	/**
	 * Constructor.
	 *
	 * @param configRegistry
	 */
	public TreeTableCellLabelProviderComparator(IConfigRegistry configRegistry) {
		comparator = new ITreeItemAxisComparator(configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID));
	}

	/**
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 *
	 * @param o1
	 * @param o2
	 * @return
	 */
	@Override
	public int compare(SortLabelProviderFullCellContextElementWrapper sortWrapper1, SortLabelProviderFullCellContextElementWrapper sortWrapper2) {
		// get interesting fields and do required check about values

		final IConfigRegistry configRegistry = sortWrapper1.getConfigRegistry();

		ISortModel sortModel = configRegistry.getConfigAttribute(NattableConfigAttributes.ROW_SORT_MODEl, DisplayMode.NORMAL);
		// get and check the column index
		int selectedColumn = sortWrapper1.getColumnIndex();
		Assert.isTrue(selectedColumn == sortWrapper2.getColumnIndex());
		Object row1 = sortWrapper1.getRowObject();
		Object col1 = sortWrapper1.getColumnObject();

		Object row2 = sortWrapper2.getRowObject();
		Object col2 = sortWrapper2.getColumnObject();

		int colIndex1 = sortWrapper1.getColumnIndex();
		int colIndex2 = sortWrapper2.getColumnIndex();

		Assert.isTrue(colIndex1 == colIndex2);
		SortDirectionEnum direction = sortModel.getSortDirection(colIndex1);
		if (row1 == row2 && col1 == col2) {
			return 0;
		}

		// check required in case of TreeTable
		if (row1 instanceof ITreeItemAxis && row2 instanceof ITreeItemAxis) {
			ITreeItemAxis axis1 = (ITreeItemAxis) row1;
			ITreeItemAxis axis2 = (ITreeItemAxis) row2;
			Object rep1 = AxisUtils.getRepresentedElement(axis1);
			Object rep2 = AxisUtils.getRepresentedElement(axis2);

			// when the parent is not common between the 2 compared elements OR when at least one of the element is a TreeFillingConfiguration, we must not compare CellValue,
			// we must compare the location in the tree
			if ((axis1.getParent() != axis2.getParent()) || (rep1 instanceof TreeFillingConfiguration || rep2 instanceof TreeFillingConfiguration)) {
				// we must not compare cell values must location in the tree
				int res = comparator.compare(axis1, axis2);

				if (direction == SortDirectionEnum.DESC) {
					res = -res;// to preserve the order of the TreeFillingConfiguration declared in the model
				}
				return res;
			} else {
				LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, org.eclipse.nebula.widgets.nattable.style.DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);

				final String txt1 = serv.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT).getText(sortWrapper1);
				final String txt2 = serv.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT).getText(sortWrapper2);
				int res = -1;
				if (ICellManager.NOT_AVALAIBLE.equals(txt1) || ICellManager.NOT_AVALAIBLE.equals(txt2)) { // OR or AND ? I don't know 
					res = comparator.compare(axis1, axis2);
					if (direction == SortDirectionEnum.DESC) {
						res = -res;// to preserve the order of the TreeFillingConfiguration declared in the model and of the unsortable object
					}
				} else {
					res = Collator.getInstance().compare(txt1, txt2);
				}

				return res;

			}
		} else if (row1 instanceof ITreeItemAxis || row2 instanceof ITreeItemAxis) {
			throw new UnsupportedOperationException();
		}

		return super.compare(sortWrapper1, sortWrapper2);
	}
}