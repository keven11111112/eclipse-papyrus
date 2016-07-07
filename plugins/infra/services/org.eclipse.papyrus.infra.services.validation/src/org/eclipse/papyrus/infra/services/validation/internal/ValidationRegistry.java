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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.Activator;
import org.eclipse.papyrus.infra.services.validation.IPapyrusDiagnostician;
import org.eclipse.papyrus.infra.services.validation.IValidationFilter;
import org.eclipse.papyrus.infra.services.validation.IValidationHook;

/**
 * Provides access to the extensions diagnosticians and validationHooks
 */
public class ValidationRegistry {

	public static final String ID_DIAGNOSTICIANS = Activator.PLUGIN_ID + ".diagnosticians"; //$NON-NLS-1$

	public static final String ID_VALIDATION_HOOKS = Activator.PLUGIN_ID + ".validationHooks"; //$NON-NLS-1$

	/**
	 * Constants for tags in two extensions points
	 */
	public static final String DIAGNOSTICIAN = "diagnostician"; //$NON-NLS-1$

	public static final String VALIDATION_HOOK = "hook"; //$NON-NLS-1$

	public static final String FILTER = "filter"; //$NON-NLS-1$

	public enum HookType {
		BEFORE, AFTER
	};

	/**
	 * Return a diagnostician for an element of a model.
	 * 
	 * @param element
	 *            an element of a model (that must be contained in an eResource)
	 * @return
	 */
	public static IPapyrusDiagnostician getDiagnostician(EObject element) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(ID_DIAGNOSTICIANS);
		for (IConfigurationElement configElement : configElements) {
			try {
				final Object obj = configElement.createExecutableExtension(FILTER);
				if (obj instanceof IValidationFilter) {
					IValidationFilter filter = (IValidationFilter) obj;
					if (filter.isApplicable(element)) {
						final Object diagnostician = configElement.createExecutableExtension(DIAGNOSTICIAN);
						if (diagnostician instanceof IPapyrusDiagnostician) {
							return (IPapyrusDiagnostician) diagnostician;
						}
					}
				}
			} catch (CoreException exception) {
				Activator.log.error(exception);
			}
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
	
	/**
	 * Execute validation hooks
	 * 
	 * @param element
	 *            An element of the model we want to validate
	 * @param hookType
	 *            The hook type (currently before or after)
	 */
	public static void executeHooks(EObject element, HookType hookType) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(ID_VALIDATION_HOOKS);
		for (IConfigurationElement configElement : configElements) {
			try {
				final Object obj = configElement.createExecutableExtension(FILTER);
				if (obj instanceof IValidationFilter) {
					IValidationFilter filter = (IValidationFilter) obj;
					if (filter.isApplicable(element)) {
						final Object hookObj = configElement.createExecutableExtension(VALIDATION_HOOK);
						if (hookObj instanceof IValidationHook) {
							IValidationHook validationHook = (IValidationHook) hookObj;
							if (hookType == HookType.BEFORE) {
								validationHook.beforeValidation(element);
							} else if (hookType == HookType.AFTER) {
								validationHook.afterValidation(element);
							}
						}
					}
				}
			}
			catch (CoreException exception) {
				Activator.log.error(exception);
			}
		}
	}
}
