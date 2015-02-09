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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.extensionpoints.IElementTypeConfigurationTypeExtensionPoint;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.IElementTypeConfigurationFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.MetamodelTypeFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.SpecializationTypeFactory;

/**
 * Registry that manages all possible elementTypeConfigurationTypes
 */
public class ElementTypeConfigurationTypeRegistry {

	private static ElementTypeConfigurationTypeRegistry registry;

	protected Map<String, IElementTypeConfigurationFactory<? extends ElementTypeConfiguration>> elementTypeConfigurationTypeToFactory = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized ElementTypeConfigurationTypeRegistry getInstance() {
		if (registry == null) {
			registry = new ElementTypeConfigurationTypeRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		elementTypeConfigurationTypeToFactory = new HashMap<String, IElementTypeConfigurationFactory<? extends ElementTypeConfiguration>>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IElementTypeConfigurationTypeExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			String configurationClass = configurationElement.getAttribute(IElementTypeConfigurationTypeExtensionPoint.CONFIGURATION_CLASS);
			try {
				Object factoryClass = configurationElement.createExecutableExtension(IElementTypeConfigurationTypeExtensionPoint.FACTORY_CLASS);
				if (factoryClass instanceof IElementTypeConfigurationFactory) {
					elementTypeConfigurationTypeToFactory.put(configurationClass, (IElementTypeConfigurationFactory<?>) factoryClass);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
		// Register default interpretations
		elementTypeConfigurationTypeToFactory.put(ElementtypesconfigurationsPackage.eINSTANCE.getMetamodelTypeConfiguration().getInstanceTypeName(), new MetamodelTypeFactory());
		elementTypeConfigurationTypeToFactory.put(ElementtypesconfigurationsPackage.eINSTANCE.getSpecializationTypeConfiguration().getInstanceTypeName(), new SpecializationTypeFactory());
	}

	protected <T extends ElementTypeConfiguration> IElementTypeConfigurationFactory<T> getFactory(ElementTypeConfiguration elementTypeConfiguration) {
		String elementTypeConfigurationType = elementTypeConfiguration.eClass().getInstanceTypeName();
		// We assume here that the right factory is registered for the right ElementTypeConfiguration
		@SuppressWarnings("unchecked")
		IElementTypeConfigurationFactory<T> factory = (IElementTypeConfigurationFactory<T>) elementTypeConfigurationTypeToFactory.get(elementTypeConfigurationType);
		return factory;
	}

	public <T extends ElementTypeConfiguration> IElementType getElementType(T elementTypeConfiguration) {
		if (elementTypeConfiguration == null) {
			return null;
		} else {
			IElementTypeConfigurationFactory<T> factory = getFactory(elementTypeConfiguration);
			if (factory != null) {
				IHintedType elementType = factory.createElementType(elementTypeConfiguration);
				return elementType;
			}
		}
		return null;
	}
}
