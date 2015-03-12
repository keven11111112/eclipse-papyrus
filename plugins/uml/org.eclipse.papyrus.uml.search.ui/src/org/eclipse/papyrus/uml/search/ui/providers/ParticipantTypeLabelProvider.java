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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Stereotype;

import com.swtdesigner.ResourceManager;

public class ParticipantTypeLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object object) {
		if (object instanceof ParticipantTypeElement) {
			EObject eObject = ((ParticipantTypeElement) object).getElement();
			if (eObject instanceof ENamedElement) {
				String imagePath = "/icons/full/obj16/" + ((ENamedElement) eObject).getName() + ".gif"; //$NON-NLS-1$ //$NON-NLS-2$
				return ResourceManager.getPluginImage("org.eclipse.uml2.uml.edit", imagePath); //$NON-NLS-1$
			} else if (eObject instanceof Stereotype) {
				// TODO search or register image in registry of shared instance of plugin
				EList<org.eclipse.uml2.uml.Image> icons = StereotypeUtil.getIcons((Stereotype) eObject);
				
				if (icons.size() > 0) {
					org.eclipse.uml2.uml.Image icon = icons.get(icons.size() - 1);
					
					// Get image id for registr
					Image image = null;

					try {
						// Try to retrieve image from UML Image content property
						image = ImageUtil.getContent(icon);
					} catch (Exception e) {
						// Activator.log.error(e);
					}

					// If no image was found in Content
					// Try to retrieve image from UML Image location property
					if (image == null) {
						image = ImageUtil.getImageFromLocation(icon);
					}
					
					return image;
				} else {
					LabelProviderService service = new LabelProviderServiceImpl();
					try {
						service.startService();
						return service.getLabelProvider().getImage(eObject);
					} catch (ServiceException e) {
						Activator.log.warn(Messages.FilterTypeLabelProvider_0 + eObject);
						return null;
					}					
				}
			}
		}

		return null;
	}

	@Override
	public String getText(Object object) {

		if (object instanceof ParticipantTypeElement) {
			return ((ParticipantTypeElement) object).getText();
		}

		return ""; //$NON-NLS-1$
		//
	}

}
