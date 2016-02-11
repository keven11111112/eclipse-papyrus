/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import static org.eclipse.papyrus.infra.extendedtypes.util.InternalUtils.loadClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

/**
 * Registry for all element matcher factories for element matcher based on {@link MatcherConfiguration}.
 */
public class ConfigurableElementMatcherFactoryRegistry {

	/** private singleton instance */
	private static ConfigurableElementMatcherFactoryRegistry registry;

	protected Map<String, IConfigurableElementMatcherFactory<MatcherConfiguration>> configurationTypeToMatcherFactory = null;

	protected List<String> configurationTypeFactoryExceptions = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized ConfigurableElementMatcherFactoryRegistry getInstance() {
		if (registry == null) {
			registry = new ConfigurableElementMatcherFactoryRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		configurationTypeToMatcherFactory = new HashMap<String, IConfigurableElementMatcherFactory<MatcherConfiguration>>();

	}

	/**
	 * Creates the {@link IElementMatcher} specific to the given rule configuration
	 *
	 * @param ruleConfiguration
	 *            the rule configuration that will configure the created matcher
	 * @return the {@link IElementMatcher} created or <code>null</code> if none could be created
	 */
	public IConfigurableElementMatcher<MatcherConfiguration> createElementMatcher(MatcherConfiguration matcherConfiguration) {
		String configurationType = matcherConfiguration.eClass().getInstanceTypeName();
		IConfigurableElementMatcherFactory<MatcherConfiguration> factory = configurationTypeToMatcherFactory.get(configurationType);
		// check factory is not on the exception table
		if (factory == null && isNotInFactoryExceptionList(configurationType)) {
			Class<IConfigurableElementMatcherFactory<MatcherConfiguration>> factoryClass = retrieveFactoryClassFromExtensionPoint(configurationType);
			if (factoryClass != null) {
				try {
					factory = factoryClass.newInstance();
				} catch (InstantiationException e) {
					if (configurationTypeFactoryExceptions == null) {
						configurationTypeFactoryExceptions = new ArrayList<String>();
					}
					configurationTypeFactoryExceptions.add(configurationType);
				} catch (IllegalAccessException e) {
					if (configurationTypeFactoryExceptions == null) {
						configurationTypeFactoryExceptions = new ArrayList<String>();
					}
					configurationTypeFactoryExceptions.add(configurationType);
				}
				configurationTypeToMatcherFactory.put(configurationType, factory);
			}
		}
		if (factory != null) {
			IConfigurableElementMatcher<MatcherConfiguration> elementMatcher = factory.createElementMatcher(matcherConfiguration);
			if (elementMatcher != null) {
				// elementMatcher.init(matcherConfiguration);
				return elementMatcher;
			}
		}
		return null;
	}

	/**
	 * check this configuration type has not already caused issues du
	 *
	 * @param configurationType
	 * @return
	 */
	protected boolean isNotInFactoryExceptionList(String configurationType) {
		if (configurationTypeFactoryExceptions == null) {
			return true;
		}
		// this is not null, check the configuration type is not in the list
		return !configurationTypeFactoryExceptions.contains(configurationType);
	}

	/**
	 * Returns the {@link IExtendedElementTypeFactory} class used to instantiate element type for the given configuration
	 *
	 * @return the {@link IExtendedElementTypeFactory} found or <code>null</code> if none was found
	 */
	@SuppressWarnings("unchecked")
	protected Class<IConfigurableElementMatcherFactory<MatcherConfiguration>> retrieveFactoryClassFromExtensionPoint(String configurationType) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IElementMatcherExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			String eCoreClassName = configurationElement.getAttribute(IElementMatcherExtensionPoint.MATCHER_CONFIGURATION_CLASS);
			if (configurationType.equals(eCoreClassName)) {
				// retrieve factory to load
				String factoryClassName = configurationElement.getAttribute(IElementMatcherExtensionPoint.MATCHER_FACTORY_CLASS);
				return (Class<IConfigurableElementMatcherFactory<MatcherConfiguration>>) loadClass(factoryClassName, configurationElement.getContributor().getName());
			}
		}
		return null;
	}
}
