/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr 
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.richtext.celleditor.config;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.extension.nebula.richtext.RichTextCellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.BackgroundPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.PaddingDecorator;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.nattable.richtext.celleditor.RichTextCellEditorWithUMLReferences;
import org.eclipse.papyrus.uml.nattable.richtext.celleditor.config.messages.Messages;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class provides the configuration to use to display and edit richtext in the table.
 */
public class RichTextCellEditorConfiguration implements ICellAxisConfiguration {

	/**
	 * the id of this editor.
	 */
	private static final String ID = "org.eclipse.papyrus.infra.nattable.richtext.cell.editor.axis.configuration";//$NON-NLS-1$

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
		return Messages.RichTextCellEditorConfiguration_Description;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table, java.lang.Object)
	 */
	@Override
	public boolean handles(final Table table, final Object axisElement) {
		boolean result = false;
		final Object object = AxisUtils.getRepresentedElement(axisElement);
		if (object instanceof EStructuralFeature) {
			final EStructuralFeature feature = (EStructuralFeature) object;
			result = UMLPackage.eINSTANCE.getComment_Body().equals(feature);
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
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new BackgroundPainter(new PaddingDecorator(new RichTextCellPainter(), 2, 5, 2, 5)), DisplayMode.NORMAL, configLabel);
		configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new RichTextCellEditorWithUMLReferences(), DisplayMode.NORMAL, configLabel);
	}

}