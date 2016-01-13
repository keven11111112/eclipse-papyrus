/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation.internal;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.language.ILanguage;
import org.eclipse.papyrus.infra.core.language.ILanguageService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.validation.Activator;
import org.eclipse.papyrus.infra.services.validation.IPapyrusDiagnostician;

/**
 * A simple registry for language and diagnosticians pairs
 *
 */
public class ValidationRegistry {

	public static final String ID_DIAGNOSTICIANS = Activator.PLUGIN_ID + ".diagnosticians"; //$NON-NLS-1$

	/**
	 * Return a diagnostician for an element of a model.
	 * TODO: It is possible that multiple languages are registered with a model.
	 * This function currently returns the diagnostician for the first matching language.
	 * 
	 * @param element
	 *            an element of a model (that must be contained in an eResource)
	 * @return
	 */
	public static IPapyrusDiagnostician getDiagnostician(EObject element) {
		try {
			final ServicesRegistry serviceRegistry = ServiceUtilsForEObject.getInstance().getServiceRegistry(element);
			ILanguageService languageService = serviceRegistry.getService(ILanguageService.class);
			if (languageService != null) {
				Set<ILanguage> languages = languageService.getLanguages(element.eResource().getURI(), true);
				for (ILanguage language : languages) {
					IPapyrusDiagnostician diagnostician = getDiagnostician(language.getID());
					if (diagnostician != null) {
						return diagnostician;
					}
				}
			}
		} catch (ServiceException e) {
		}
		// fall back to ecore diagnostician
		return new EcoreDiagnostician();
	}

	/**
	 * Obtain a diagnostician for a given language
	 * 
	 * @param languageID
	 *            the id of the language for which we want to obtain the diagnostician
	 * @return the associated diagnostician
	 */
	public static IPapyrusDiagnostician getDiagnostician(String languageID) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(ID_DIAGNOSTICIANS);
		for (IConfigurationElement configElement : configElements) {
			try {
				final String iConfiguratorIDext = configElement.getAttribute("id"); //$NON-NLS-1$
				if ((iConfiguratorIDext != null) && iConfiguratorIDext.equals(languageID)) {
					final Object obj = configElement.createExecutableExtension("class"); //$NON-NLS-1$
					if (obj instanceof IPapyrusDiagnostician) {
						return (IPapyrusDiagnostician) obj;
					}
				}
			} catch (CoreException exception) {
				Activator.log.error(exception);
			}
		}
		return null;
	}
}
