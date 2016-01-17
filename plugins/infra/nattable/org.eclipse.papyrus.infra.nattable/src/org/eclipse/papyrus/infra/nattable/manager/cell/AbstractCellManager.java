/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.manager.cell;

import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.ui.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.infra.ui.converter.ConvertedValueContainer;

/**
 * The abstract class for the cell manager
 *
 * @author Vincent Lorenzo
 *
 */
public abstract class AbstractCellManager implements ICellManager, IUnsetValueCellManager {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getValue(java.lang.Object, java.lang.Object, INattableModelManager)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 *         the value for the cell. The developer must override the method doGetValue
	 */
	@Override
	public final Object getValue(final Object columnElement, final Object rowElement, final INattableModelManager tableManager) {
		return doGetValue(columnElement, rowElement, tableManager);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getValue(java.lang.Object, java.lang.Object, INattableModelManager)
	 *
	 * @param columnElement
	 *            the column element
	 * @param rowElement
	 *            the row element
	 * @param tableManager
	 *            the table manager
	 * @return
	 */
	protected Object doGetValue(final Object columnElement, final Object rowElement, final INattableModelManager tableManager) {
		return null;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setValue(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.Object, INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 */
	@Override
	public void setValue(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager) {
		final Command cmd = getSetValueCommand(domain, columnElement, rowElement, newValue, tableManager);
		if (cmd != null && cmd.canExecute()) {
			domain.getCommandStack().execute(cmd);
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement) {
		return false;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, Object newValue, INattableModelManager tableManager) {
		return null;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetStringValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.String,
	 *      org.eclipse.papyrus.infra.ui.converter.IStringValueConverter, INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param valueSolver
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetStringValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, String newValue, AbstractStringValueConverter valueSolver, INattableModelManager tableManager) {
		return null;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getOrCreateStringValueConverterClass(INattableModelManager, Map, String)
	 *
	 * @return
	 */
	@Override
	public AbstractStringValueConverter getOrCreateStringValueConverterClass(INattableModelManager tableManager, Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters, String multiValueSeparator) {
		AbstractStringValueConverter converter = existingConverters.get(this.getClass());
		if (converter == null) {
			converter = new AbstractStringValueConverter() {

				@Override
				public void dispose() {
					// nothing to do
				}

				@Override
				protected ConvertedValueContainer<?> doDeduceValueFromString(Object type, String valueAsString) {
					// nothing to do
					return null;
				}
			};
			existingConverters.put(converter.getClass(), converter);
		}
		return converter;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object, java.util.Map)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param sharedMap
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement, final Map<?, ?> sharedMap) {
		return isCellEditable(columnElement, rowElement);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setStringValue(java.lang.Object, java.lang.Object, java.lang.String, org.eclipse.papyrus.infra.ui.converter.AbstractStringValueConverter,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager, java.util.Map)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param valueAsString
	 * @param valueConverter
	 * @param tableManager
	 * @param sharedMap
	 */
	@Override
	public void setStringValue(Object columnElement, Object rowElement, String valueAsString, AbstractStringValueConverter valueConverter, INattableModelManager tableManager, Map<?, ?> sharedMap) {
		// do nothing
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.IUnsetValueCellManager#unsetCellValue(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 */
	@Override
	public void unsetCellValue(TransactionalEditingDomain domain, Object columnElement, Object rowElement, INattableModelManager tableManager) {
		// nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.IUnsetValueCellManager#getUnsetCellValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getUnsetCellValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, INattableModelManager tableManager) {
		// nothing to do
		return null;
	}
	
}
