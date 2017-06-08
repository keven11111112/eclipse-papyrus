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

package org.eclipse.papyrus.uml.nattable.config;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.uml.nattable.editor.MultiEnumCellEditor;

/**
 * The cell editor configuration for the multi enum value.
 */
public class MultiEEnumCellEditorConfiguration implements ICellAxisConfiguration {

	/**
	 * The id of this editor.
	 */
	public static final String ID = "org.eclipse.papyrus.uml.nattable.celleditor.configuration.MultiEEnumCellEditorConfiguration.MultiEditor";//$NON-NLS-1$


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.configuration.IPapyrusNatTableConfiguration#getConfigurationId()
	 */
	@Override
	public String getConfigurationId() {
		return ID;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.configuration.IPapyrusNatTableConfiguration#getConfigurationDescription()
	 *
	 * @return
	 */
	@Override
	public String getConfigurationDescription() {
		return "This configuration provides a multi editor for a multi EEnum type"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table, java.lang.Object)
	 */
	@Override
	public boolean handles(final Table table, final Object axisElement) {
		boolean result = false;
		Object representedElement = AxisUtils.getRepresentedElement(axisElement);
		if (representedElement instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) representedElement;
			if (feature.isMany()) {
				EClassifier eType = feature.getEType();
				result = eType instanceof EEnum;
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration#configureCellEditor(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object, java.lang.String)
	 */
	@Override
	public void configureCellEditor(final IConfigRegistry configRegistry, final Object axis, final String configLabel) {
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new TextPainter(), DisplayMode.NORMAL, configLabel);

		final INattableModelManager modelManager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new MultiEnumCellEditor(axis, modelManager.getTableAxisElementProvider()), DisplayMode.EDIT, configLabel);
	}
}
