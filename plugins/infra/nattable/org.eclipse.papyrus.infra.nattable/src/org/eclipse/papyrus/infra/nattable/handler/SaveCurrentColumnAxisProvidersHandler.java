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
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

/**
 * Concrete handler to save the current axis provider, in this case for columns.
 *
 */
public class SaveCurrentColumnAxisProvidersHandler extends AbstractSaveCurrentAxisProvidersHandler {

	@Override
	public void setEnabled(Object evaluationContext) {
		INattableModelManager manager = this.getCurrentNattableModelManager();
		if (manager == null) {
			setBaseEnabled(false);
			return;
		}

		IAxisManager columnAxisManager = manager.getColumnAxisManager();
		if (columnAxisManager == null) {
			setBaseEnabled(false);
			return;
		}
		setBaseEnabled(columnAxisManager.canBeSavedAsConfig());
	}

	@Override
	public AbstractAxisProvider getAxisProvider() {
		return this.getCurrentNattableModelManager().getVerticalAxisProvider();
	}

	@Override
	public EList<AbstractAxisProvider> getAxisProviderHistory() {
		return this.getCurrentNattableModelManager().getTable().getColumnAxisProvidersHistory();
	}

	@Override
	public EReference getAxisProviderHistoryEReference() {
		return NattablePackage.eINSTANCE.getTable_ColumnAxisProvidersHistory();
	}



}
