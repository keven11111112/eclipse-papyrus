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
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.IEditHelperAdviceDescriptor;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IConfiguredEditHelperAdviceDescriptor;
import org.eclipse.papyrus.infra.elementtypesconfigurations.extensionpoints.IAdviceConfigurationTypeExtensionPoint;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.IEditHelperAdviceFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.AdviceBindingFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.EditHelperAdviceFactory;

@SuppressWarnings("restriction")
public class AdviceConfigurationTypeRegistry {

	private static AdviceConfigurationTypeRegistry registry;

	protected Map<String, IEditHelperAdviceFactory<? extends AdviceConfiguration>> adviceConfigurationTypeToFactory = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized AdviceConfigurationTypeRegistry getInstance() {
		if (registry == null) {
			registry = new AdviceConfigurationTypeRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		adviceConfigurationTypeToFactory = new HashMap<String, IEditHelperAdviceFactory<? extends AdviceConfiguration>>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IAdviceConfigurationTypeExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			String configurationClass = configurationElement.getAttribute(IAdviceConfigurationTypeExtensionPoint.CONFIGURATION_CLASS);
			try {
				Object factoryClass = configurationElement.createExecutableExtension(IAdviceConfigurationTypeExtensionPoint.FACTORY_CLASS);
				if (factoryClass instanceof IEditHelperAdviceFactory) {
					adviceConfigurationTypeToFactory.put(configurationClass, (IEditHelperAdviceFactory<?>) factoryClass);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
		// Register default interpretations
		adviceConfigurationTypeToFactory.put(ElementtypesconfigurationsPackage.eINSTANCE.getEditHelperAdviceConfiguration().getInstanceTypeName(), new EditHelperAdviceFactory());
		adviceConfigurationTypeToFactory.put(ElementtypesconfigurationsPackage.eINSTANCE.getAdviceBindingConfiguration().getInstanceTypeName(), new AdviceBindingFactory());
	}

	protected <T extends AdviceConfiguration> IEditHelperAdviceFactory<T> getFactory(AdviceConfiguration adviceConfiguration) {
		String adviceConfigurationType = adviceConfiguration.eClass().getInstanceTypeName();
		// We assume here that the right factory is registered for the right AdviceConfiguration
		@SuppressWarnings("unchecked")
		IEditHelperAdviceFactory<T> factory = (IEditHelperAdviceFactory<T>) adviceConfigurationTypeToFactory.get(adviceConfigurationType);
		return factory;
	}

	public <T extends AdviceConfiguration> IEditHelperAdviceDescriptor getEditHelperAdviceDecriptor(T adviceConfiguration) {
		if (adviceConfiguration == null) {
			return null;
		} else {
			IEditHelperAdviceFactory<T> factory = getFactory(adviceConfiguration);
			if (factory != null) {
				IConfiguredEditHelperAdviceDescriptor<T> editHelperAdvice = factory.createEditHelperAdviceDescriptor(adviceConfiguration);
				editHelperAdvice.init(adviceConfiguration);
				return editHelperAdvice;
			}
		}
		return null;
	}
}
