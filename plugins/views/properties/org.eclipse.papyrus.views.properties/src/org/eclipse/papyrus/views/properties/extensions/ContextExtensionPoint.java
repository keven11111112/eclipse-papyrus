/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - adds isVisible implementation
 *  Christian W. Damus - bug 469188
 *  
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.extensions;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;

/**
 * Handles the extension point org.eclipse.papyrus.views.properties.context
 * Registers the given Context models to the Property View framework
 *
 * @author Camille Letavernier
 */
public class ContextExtensionPoint {


	/** The Constant IS_CUSTOMIZABLE. */
	private static final String IS_CUSTOMIZABLE = "isCustomizable";//$NON-NLS-1$

	/** The Constant IS_VISIBLE. */
	private static final String APPLIED_BY_DEFAULT = "appliedByDefault";//$NON-NLS-1$

	private static final String CONTEXT_MODEL = "contextModel"; //$NON-NLS-1$

	private static final String CONTEXT = "context"; //$NON-NLS-1$

	private static final String PREFPAGE_BINDING = "preferencePageBinding"; //$NON-NLS-1$

	private static final String PAGE = "page"; //$NON-NLS-1$

	/** The extension id. */
	private final String EXTENSION_ID = "org.eclipse.papyrus.views.properties.context"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public ContextExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for (IConfigurationElement e : config) {
			try {
				switch (e.getName()) {
				case CONTEXT:
					processContext(e);
					break;
				case PREFPAGE_BINDING:
					processPrefPageBinding(e);
					break;
				}

			} catch (IOException ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
	}

	private void processContext(IConfigurationElement e) throws IOException {
		final String contextResource = e.getAttribute(CONTEXT_MODEL);

		final boolean isCustomizable;
		if (Arrays.asList(e.getAttributeNames()).contains(IS_CUSTOMIZABLE)) {
			isCustomizable = Boolean.parseBoolean(e.getAttribute(IS_CUSTOMIZABLE));
		} else {
			isCustomizable = true; // Default value
		}

		final boolean appliedByDefault;
		if (Arrays.asList(e.getAttributeNames()).contains(APPLIED_BY_DEFAULT)) {
			appliedByDefault = Boolean.parseBoolean(e.getAttribute(APPLIED_BY_DEFAULT));
		} else {
			appliedByDefault = true; // Default value
		}

		URI uri = URI.createURI("ppe:/context/" + e.getContributor().getName() + "/" + contextResource); //$NON-NLS-1$ //$NON-NLS-2$

		ConfigurationManager.getInstance().addContext(uri, appliedByDefault, isCustomizable);
	}

	private void processPrefPageBinding(IConfigurationElement config) {
		boolean valid = true;

		String context = config.getAttribute(CONTEXT);
		if ((context == null) || context.isEmpty()) {
			valid = false;
			Activator.log.warn(String.format("Missing context name in preference page binding extension in plug-in %s", config.getContributor().getName()));
		}

		String page = config.getAttribute(PAGE);
		if ((page == null) || page.isEmpty()) {
			valid = false;
			Activator.log.warn(String.format("Missing page ID in preference page binding extension in plug-in %s", config.getContributor().getName()));
		}

		if (valid) {
			ConfigurationManager.getInstance().registerPreferencePageBinding(context, page);
		}
	}
}
