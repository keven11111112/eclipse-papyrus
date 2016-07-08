/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.provider.TableStructuredSelection;
import org.eclipse.papyrus.infra.nattable.utils.AbstractPasteInsertInTableHandler;
import org.eclipse.papyrus.infra.nattable.utils.PasteInsertUtil;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Insert Handler.
 */
public class InsertInTableHandler extends AbstractPasteInsertInTableHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		return PasteInsertUtil.insert(getCurrentNattableModelManager(), HandlerUtil.getCurrentSelection(event), event.getParameters());
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(final Object evaluationContext) {
		super.setEnabled(evaluationContext);
		if (isEnabled()) {
			// Recalculate if the enable is allowed because the user can select cells and try to insert by click on rows for example.
			boolean canEnable = false;
			final INattableModelManager currentNattableModelManager = getCurrentNattableModelManager();
			if (null != currentNattableModelManager) {
				final ISelection currentSelection = ((NattableModelManager) currentNattableModelManager).getSelectionInTable();
				if (null == currentSelection) {
					canEnable = true;
				} else if (currentSelection instanceof TableStructuredSelection) {
					TableSelectionWrapper tableSelectionWrapper = (TableSelectionWrapper) ((TableStructuredSelection) currentSelection).getAdapter(TableSelectionWrapper.class);
					if (null != tableSelectionWrapper) {
						if (tableSelectionWrapper.getSelectedCells().isEmpty()
								|| !tableSelectionWrapper.getFullySelectedRows().isEmpty() && tableSelectionWrapper.getFullySelectedColumns().isEmpty()) {
							canEnable = true;
						}
					}
				}
			}
			setBaseEnabled(canEnable);
		}
	}
}
