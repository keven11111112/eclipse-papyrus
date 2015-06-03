package org.eclipse.papyrus.uml.nattable.stereotype.display.manager.cell;

import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.uml.nattable.stereotype.display.utils.StereotypeDisplayTreeTableConstants;
import org.eclipse.papyrus.uml.nattable.stereotype.display.utils.StereotypeDisplayTreeTableHelper;

public class StereotypeDisplayTreeTableCellManager implements ICellManager {


	private StereotypeDisplayTreeTableHelper helper = StereotypeDisplayTreeTableHelper.getInstance();

	@Override
	public boolean handles(Object columnElement, Object rowElement) {
		boolean handles = false;
		Object element = AxisUtils.getRepresentedElement(columnElement);
		if (element instanceof String) {
			handles = ((String) element).startsWith(StereotypeDisplayTreeTableConstants.PREFIX);
		}

		return handles;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getValue(java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	public Object getValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {

		Object element = AxisUtils.getRepresentedElement(columnElement);

		if (element instanceof String) {
			String shortElement = StereotypeDisplayTreeTableHelper.getInstance().getShortValue(element);
			switch (shortElement) {
			case StereotypeDisplayTreeTableConstants.IS_DISPLAYED:
				return Boolean.TRUE;
			case StereotypeDisplayTreeTableConstants.IN_BRACE:
				return helper.getBraceValue(rowElement);
			case StereotypeDisplayTreeTableConstants.IN_COMMENT:
			case StereotypeDisplayTreeTableConstants.IN_COMPARTMENT:
				return Boolean.TRUE;
			case StereotypeDisplayTreeTableConstants.NAME_DEPTH:

				return "full";

			default:
				return "tadaaaaa";

			}
		}
		return null;


	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setValue(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 */
	@Override
	public void setValue(TransactionalEditingDomain domain, Object columnElement, Object rowElement, Object newValue, INattableModelManager tableManager) {
		Object element = AxisUtils.getRepresentedElement(columnElement);

		if (element instanceof String) {
			String shortElement = StereotypeDisplayTreeTableHelper.getInstance().getShortValue(element);
			switch (shortElement) {
			case StereotypeDisplayTreeTableConstants.IS_DISPLAYED:
			case StereotypeDisplayTreeTableConstants.IN_BRACE:
				helper.setBraceValue(domain, rowElement, newValue);
			case StereotypeDisplayTreeTableConstants.IN_COMMENT:
			case StereotypeDisplayTreeTableConstants.IN_COMPARTMENT:
			case StereotypeDisplayTreeTableConstants.NAME_DEPTH:
				break;

			default:
				break;

			}
		}



	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(Object columnElement, Object rowElement) {

		return true;
	}

	/**
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetStringValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.String,
	 *      org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param valueConverter
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetStringValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, String newValue, AbstractStringValueConverter valueConverter, INattableModelManager tableManager) {

		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getOrCreateStringValueConverterClass(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager, java.util.Map, java.lang.String)
	 *
	 * @param tableManager
	 * @param existingConverters
	 * @param multiValueSeparator
	 * @return
	 */
	@Override
	public AbstractStringValueConverter getOrCreateStringValueConverterClass(INattableModelManager tableManager, Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters, String multiValueSeparator) {

		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object, java.util.Map)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param sharedMap
	 * @return
	 */
	@Override
	public boolean isCellEditable(Object columnElement, Object rowElement, Map<?, ?> sharedMap) {

		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setStringValue(java.lang.Object, java.lang.Object, java.lang.String, org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter,
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
		// Nothing to do

	}

}
