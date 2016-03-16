/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.utils.CreatePaletteItemUtil;

/**
 * Custom item provider for PaletteConfiguration.
 *
 */
public class CustomPaletteConfigurationItemProvider extends PaletteConfigurationItemProvider {

	/**
	 * Constructor.
	 */
	public CustomPaletteConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		// Only gets the drawer, no the icon
		return ((PaletteConfiguration) object).getDrawerConfigurations();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {

		super.notifyChanged(notification);

		switch (notification.getFeatureID(PaletteConfiguration.class)) {
		case PaletteconfigurationPackage.PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS:
			fireNotifyChanged(new ViewerNotification(notification, null, true, false));
			return;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getImage(Object object) {
		Object result = null;

		if (object instanceof Configuration) {
			result = overlayImage(object, CreatePaletteItemUtil.iconDescriptorToImage(((Configuration) object).getIcon()));
		}

		return result != null ? result : super.getImage(object);
	}

}
