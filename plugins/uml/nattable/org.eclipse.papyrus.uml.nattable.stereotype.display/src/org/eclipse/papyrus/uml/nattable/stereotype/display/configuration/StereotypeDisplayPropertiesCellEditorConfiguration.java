package org.eclipse.papyrus.uml.nattable.stereotype.display.configuration;

import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultBooleanDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.CheckBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.ComboBoxPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.painter.CustomCheckBoxPainter;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.nattable.stereotype.display.utils.StereotypeDisplayTreeTableConstants;

public class StereotypeDisplayPropertiesCellEditorConfiguration implements ICellAxisConfiguration {

	public StereotypeDisplayPropertiesCellEditorConfiguration() {

	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.configuration.IPapyrusNatTableConfiguration#getConfigurationId()
	 *
	 * @return
	 */
	@Override
	public String getConfigurationId() {

		return "PapyrusStereotypeDisplayTreeTable";
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.configuration.IPapyrusNatTableConfiguration#getConfigurationDescription()
	 *
	 * @return
	 */
	@Override
	public String getConfigurationDescription() {

		return "Cell configuration for Stereotype Tree Table"; // //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table, java.lang.Object)
	 *
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	public boolean handles(Table table, Object axisElement) {
		boolean handles = false;
		Object element = AxisUtils.getRepresentedElement(axisElement);
		if (element instanceof String) {
			handles = ((String) element).startsWith(StereotypeDisplayTreeTableConstants.PREFIX);
		}

		return handles;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration#configureCellEditor(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object, java.lang.String)
	 *
	 * @param configRegistry
	 * @param axis
	 * @param configLabel
	 */
	@Override
	public void configureCellEditor(IConfigRegistry configRegistry, Object axis, String configLabel) {

		if (AxisUtils.getRepresentedElement(axis) instanceof String) {
			String element = (String) AxisUtils.getRepresentedElement(axis);

			String suffixe = element.substring(StereotypeDisplayTreeTableConstants.PREFIX.length(), element.length());

			switch (suffixe) {
			case StereotypeDisplayTreeTableConstants.IS_DISPLAYED:
			case StereotypeDisplayTreeTableConstants.IN_BRACE:
			case StereotypeDisplayTreeTableConstants.IN_COMMENT:
			case StereotypeDisplayTreeTableConstants.IN_COMPARTMENT:

				configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new CustomCheckBoxPainter(), DisplayMode.NORMAL, configLabel);
				configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new CheckBoxCellEditor(), DisplayMode.NORMAL, configLabel);
				configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultBooleanDisplayConverter(), DisplayMode.NORMAL, configLabel);
				break;
			case StereotypeDisplayTreeTableConstants.NAME_DEPTH:
				Object representedElement = AxisUtils.getRepresentedElement(axis);

				// CEJ TODO create specific converter + Create specific EnumComboBoxDataProvider
				IDisplayConverter displayConverter = null; // new displayConverterForStereotypeDisplayTreeTable();

				configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new ComboBoxPainter(), DisplayMode.EDIT, configLabel);
				// configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new ComboBoxCellEditor(new EEnumComboBoxDataProvider(eenum)), DisplayMode.EDIT, configLabel);
				// configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, displayConverter, DisplayMode.EDIT, configLabel);
				break;
			default:
				break;
			}
		}


	}



}
