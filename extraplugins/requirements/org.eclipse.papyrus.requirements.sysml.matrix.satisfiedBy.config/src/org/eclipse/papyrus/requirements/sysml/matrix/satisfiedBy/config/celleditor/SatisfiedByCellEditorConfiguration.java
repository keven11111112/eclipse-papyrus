/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.requirements.sysml.matrix.satisfiedBy.config.celleditor;

import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultBooleanDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.CheckBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.painter.CustomCheckBoxPainter;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class SatisfiedByCellEditorConfiguration implements ICellAxisConfiguration {
	/**
	 * the id of this editor
	 */
	private static final String ID = "org.eclipse.papyrus.requirements.sysml.matrix.satisfiedBy.config.celleditor.SatisfyByCellEditorConfiguration.CheckBox";//$NON-NLS-1$
	
	
	/**
	 * @see org.eclipse.papyrus.infra.nattable.configuration.IPapyrusNatTableConfiguration#getConfigurationId()
	 *
	 * @return
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
		// TODO Auto-generated method stub
		return "This configuration provides a CheckBox editor for a single Boolean that is not necessarily a EStructuralFeature as in SingleBooleanCellEditorConfiguration";//$NON-NLS-1$
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
		if(table.getTableConfiguration().getType().equals("SatisfyMatrix")){
			Object repElement = AxisUtils.getRepresentedElement(axisElement);
			Element colUMLElement = (Element) repElement;
			if (UMLUtil.getStereotypeApplication(colUMLElement, Requirement.class) != null) {
				Stereotype reqStereotype = colUMLElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
				if(reqStereotype!=null){
					return true;
				}
			}
		}
		return false;
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
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new CustomCheckBoxPainter(), DisplayMode.NORMAL, configLabel);
		configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new CheckBoxCellEditor(), DisplayMode.NORMAL, configLabel);
		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultBooleanDisplayConverter(), DisplayMode.EDIT, configLabel);
	}

	

}
