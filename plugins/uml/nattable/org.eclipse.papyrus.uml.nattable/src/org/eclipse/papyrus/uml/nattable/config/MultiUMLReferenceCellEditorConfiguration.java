/*****************************************************************************
 * Copyright (c) 2015, 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 517374
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.config;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.uml.nattable.converter.MultiUMLReferenceDisplayConverter;
import org.eclipse.papyrus.uml.nattable.editor.MultiReferenceCellEditor;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The cell editor configuration for the multi UML reference value.
 */
public class MultiUMLReferenceCellEditorConfiguration implements ICellAxisConfiguration {

	/**
	 * The id of this editor.
	 */
	public static final String ID = "org.eclipse.papyrus.uml.nattable.celleditor.configuration.MultiUMLReferenceCellEditorConfiguration.MultiEditor";//$NON-NLS-1$

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
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.nattable.configuration.IPapyrusNatTableConfiguration#getConfigurationDescription()
	 */
	@Override
	public String getConfigurationDescription() {
		return "This configuration provides a Text Editor for a multi UML reference value"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table, java.lang.Object)
	 */
	@Override
	public boolean handles(final Table table, final Object axisElement) {
		boolean result = false;
		Object object = AxisUtils.getRepresentedElement(axisElement);
		if (object instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) object;
			if (feature.isMany()) {
				EClassifier etype = feature.getEType();
				result = EMFHelper.isSuperType(UMLPackage.eINSTANCE.getElement(), etype);
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
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new TextPainter(), DisplayMode.EDIT, configLabel);

		final INattableModelManager modelManager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new MultiReferenceCellEditor(axis, modelManager.getTableAxisElementProvider()), DisplayMode.EDIT, configLabel);
		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new MultiUMLReferenceDisplayConverter(), DisplayMode.EDIT, configLabel);
	}

}
