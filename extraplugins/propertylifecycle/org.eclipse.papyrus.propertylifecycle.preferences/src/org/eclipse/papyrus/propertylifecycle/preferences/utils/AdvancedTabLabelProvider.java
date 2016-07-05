/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.utils;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.papyrus.propertylifecycle.ElementContainer;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * Class used to specialize the label provider of the advanced tab viewers
 * 
 */
public class AdvancedTabLabelProvider extends AdapterFactoryLabelProvider {

	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 *            The factory used as a base
	 */
	public AdvancedTabLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
	 *
	 * @param object
	 *            The viewer element
	 * @return
	 * 		The labels to be displayed
	 */
	@Override
	public String getText(Object object) {
		StringBuilder label = new StringBuilder();

		if (object instanceof Resource) {
			return ((Resource) object).getURI().lastSegment();
		}
		if (object instanceof StrategyElement) {
			label.append(Messages.StrategyElement_Label);
			String elementType = ((StrategyElement) object).getBaseType();
			label.append(elementType);
			return label.toString();
		}
		if (object instanceof ElementProperty) {
			label.append(Messages.ElementProperty_Label);
			String featureLabel = ((ElementProperty) object).getFeatureLabel();
			label.append(featureLabel);
			return label.toString();
		}
		if (object instanceof ElementContainer) {
			label.append(Messages.ElementContainer_Label);
			String containerType = ((ElementContainer) object).getBaseType();
			label.append(containerType);
			return label.toString();
		}

		return super.getText(object);
	}

	/**
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getImage(java.lang.Object)
	 *
	 * @param object
	 *            The viewer element
	 * @return
	 * 		The image to be displayed
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof Resource) {
			return Activator.getDefault().getImage(Messages.Resource_IconPath);
		}
		if (object instanceof StrategySet) {
			return Activator.getDefault().getImage(Messages.StrategySet_IconPath);
		}
		if (object instanceof StrategyElement) {
			return Activator.getDefault().getImage(Messages.Strategy_IconPath);
		}
		if (object instanceof ElementProperty) {
			return Activator.getDefault().getImage(Messages.Property_IconPath);
		}
		if (object instanceof ElementContainer) {
			return Activator.getDefault().getImage(Messages.ElementContainer_IconPath);
		}

		return super.getDefaultImage(object);
	}

}
