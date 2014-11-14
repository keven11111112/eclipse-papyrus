/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
package org.eclipse.papyrus.infra.elementtypesconfigurations.registries;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.extensionpoints.IMatcherConfigurationTypeExtensionPoint;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.IMatcherFactory;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;

public class MatcherConfigurationTypeRegistry {

	private static MatcherConfigurationTypeRegistry registry;

	protected Map<String, IMatcherFactory<? extends MatcherConfiguration>> matcherConfigurationTypeToFactory = null;

	public static synchronized MatcherConfigurationTypeRegistry getInstance() {
		if (registry == null) {
			registry = new MatcherConfigurationTypeRegistry();
			registry.init();
		}
		return registry;
	}

	protected void init() {
		matcherConfigurationTypeToFactory = new HashMap<String, IMatcherFactory<? extends MatcherConfiguration>>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IMatcherConfigurationTypeExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			String configurationClass = configurationElement.getAttribute(IMatcherConfigurationTypeExtensionPoint.CONFIGURATION_CLASS);
			try {
				Object factoryClass = configurationElement.createExecutableExtension(IMatcherConfigurationTypeExtensionPoint.FACTORY_CLASS);
				if (factoryClass instanceof IMatcherFactory) {
					matcherConfigurationTypeToFactory.put(configurationClass, (IMatcherFactory<?>) factoryClass);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
	}

	protected <T extends MatcherConfiguration> IMatcherFactory<T> getFactory(T matcherConfiguration) {
		String matcherConfigurationType = matcherConfiguration.eClass().getInstanceTypeName();
		// We assume here that the right factory is registered for the right MatcherConfiguration
		@SuppressWarnings("unchecked")
		IMatcherFactory<T> factory = (IMatcherFactory<T>) matcherConfigurationTypeToFactory.get(matcherConfigurationType);
		return factory;
	}

	public <T extends MatcherConfiguration> IElementMatcher getMatcher(T matcherConfiguration) {
		if (matcherConfiguration == null) {
			return null;
		} else {
			IMatcherFactory<T> factory = getFactory(matcherConfiguration);
			if (factory == null) {
				// Try to provide default interpretation
				String matcherClassName = matcherConfiguration.getMatcherClassName();
				IElementMatcher matcher = ClassLoaderHelper.newInstance(matcherClassName, IElementMatcher.class);
				return matcher;
			} else {
				IElementMatcher matcher = factory.createElementMatcher(matcherConfiguration);
				return matcher;
			}
		}
	}
}
