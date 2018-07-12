/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;



import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

/**
 * Concrete handler to load column axis providers from the table's historic.
 *
 */
public class LoadColumnAxisProvidersHandler extends AbstractLoadAxisProvidersHandler {


	/**
	 * Get the EReference where the current column provider will be set.
	 *
	 */
	@Override
	public EReference getCurrentAxisProviderEFeature() {
		return NattablePackage.eINSTANCE.getTable_CurrentColumnAxisProvider();
	}

	/**
	 * Getter to obtain the current axis provider, in this case for columns.
	 *
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractLoadAxisProvidersHandler#getCurrentAxisProvider()
	 *
	 * @return
	 */
	@Override
	public AbstractAxisProvider getCurrentAxisProvider() {
		if (!this.getCurrentNattableModelManager().getTable().isInvertAxis()) {
			return this.getCurrentNattableModelManager().getTable().getCurrentColumnAxisProvider();
		} else {
			return this.getCurrentNattableModelManager().getTable().getCurrentRowAxisProvider();

		}
	}

	/**
	 * Getter to obtain the current axis provider, in this case for columns.
	 *
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractLoadAxisProvidersHandler#getAxisProvidersHistory()
	 *
	 * @return
	 */
	@Override
	public EList<AbstractAxisProvider> getAxisProvidersHistory() {
		if (!this.getCurrentNattableModelManager().getTable().isInvertAxis()) {
			return this.getCurrentNattableModelManager().getTable().getColumnAxisProvidersHistory();
		} else {
			return this.getCurrentNattableModelManager().getTable().getRowAxisProvidersHistory();
		}
	}

	/**
	 * This handler is enabled only if the concerned axis manager allows to save a configuration.
	 *
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		if (getCurrentNattableModelManager() != null && getCurrentNattableModelManager().getColumnAxisManager() != null) {
			IAxisManager columnAxisManager = this.getCurrentNattableModelManager().getColumnAxisManager();
			setBaseEnabled(columnAxisManager.canBeSavedAsConfig());
		} else {
			setBaseEnabled(false);
		}
	}
}
