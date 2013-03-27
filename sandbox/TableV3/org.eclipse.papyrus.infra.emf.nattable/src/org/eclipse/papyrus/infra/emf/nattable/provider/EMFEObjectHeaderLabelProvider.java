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
package org.eclipse.papyrus.infra.emf.nattable.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;
import org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;

/**
 * The label provider used for header when they represents an {@link EObject} and NOT an {@link EStructuralFeature}
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EMFEObjectHeaderLabelProvider extends AbstractNattableCellLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final Object object = ((ILabelProviderContextElement)element).getObject();
			return object instanceof EObject && !(object instanceof EStructuralFeature);
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		ILabelProviderContextElement context = (ILabelProviderContextElement)element;
		final EObject object = (EObject)context.getObject();
		final IConfigRegistry configRegistry = context.getConfigRegistry();
		final LabelProviderService serv = getLabelProviderService(configRegistry);
		ILabelConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElement) {
			INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			LabelStack labels = ((LabelProviderCellContextElement)element).getCell().getConfigLabels();
			if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
				conf = manager.getColumnAxisConfiguration().getLabelConfiguration();
			} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
				conf = manager.getRowAxisConfiguration().getLabelConfiguration();
			}
		}
		if(conf instanceof EObjectLabelProviderConfiguration && !((EObjectLabelProviderConfiguration)conf).isDisplayLabel()) {
			return "";
		}
		return serv.getLabelProvider(object).getText(object);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public Image getImage(Object element) {
		final EObject object = (EObject)((ILabelProviderContextElement)element).getObject();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		final LabelProviderService serv = getLabelProviderService(configRegistry);
		ILabelConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElement) {
			INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			LabelStack labels = ((LabelProviderCellContextElement)element).getCell().getConfigLabels();
			if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
				conf = manager.getColumnAxisConfiguration().getLabelConfiguration();
			} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
				conf = manager.getRowAxisConfiguration().getLabelConfiguration();
			}

		}
		if(conf instanceof EObjectLabelProviderConfiguration && !((EObjectLabelProviderConfiguration)conf).isDisplayIcon()) {
			return null;
		}
		return serv.getLabelProvider(object).getImage(object);
	}
}
