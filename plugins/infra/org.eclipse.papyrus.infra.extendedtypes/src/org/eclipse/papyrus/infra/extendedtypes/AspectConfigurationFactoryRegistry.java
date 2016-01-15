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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;

/**
 * Registry that manages all possible pre/post action configurations
 */
public class AspectConfigurationFactoryRegistry {

	/** private singleton instance */
	private static AspectConfigurationFactoryRegistry registry;

	/** map configuration type to matcher descriptor */
	protected Map<String, ConfigurableClassDescriptor> configurationTypeToClassDescriptor = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized AspectConfigurationFactoryRegistry getInstance() {
		if (registry == null) {
			registry = new AspectConfigurationFactoryRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		configurationTypeToClassDescriptor = new HashMap<String, AspectConfigurationFactoryRegistry.ConfigurableClassDescriptor>();
		// read invariant rule configuration etension point
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IAspectTypeExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element
		for (IConfigurationElement configurationElement : elements) {
			// contributor will always be the same, but implementation could be different.
			String contributorName = configurationElement.getContributor().getName();

			String configurationClass = configurationElement.getAttribute(IAspectTypeExtensionPoint.CONFIGURATION_CLASS);

			String editHelperAdviceClassName = configurationElement.getAttribute(IAspectTypeExtensionPoint.EDIT_HELPER_ADVICE_CLASS);
			String containerDescriptorClassName = configurationElement.getAttribute(IAspectTypeExtensionPoint.CONTAINER_DESCRIPTOR_CLASS);
			String creationElementValidatorClassName = configurationElement.getAttribute(IAspectTypeExtensionPoint.CREATION_ELEMENT_VALIDATOR_CLASS);

			ConfigurableClassDescriptor configurableClassDescriptor = new ConfigurableClassDescriptor(contributorName, editHelperAdviceClassName, contributorName, containerDescriptorClassName, contributorName, creationElementValidatorClassName);
			configurationTypeToClassDescriptor.put(configurationClass, configurableClassDescriptor);
		}

	}

	/**
	 * @param ruleConfiguration
	 * @return
	 */
	public IContainerDescriptor createContainerDescriptor(ActionConfiguration ruleConfiguration) {
		Class<IActionContainerDescriptor<ActionConfiguration>> containerDescriptorClass = getContainerDescriptorClass(ruleConfiguration);
		if (containerDescriptorClass == null) {
			return null;
		}
		try {
			IActionContainerDescriptor<ActionConfiguration> containerDescriptor = containerDescriptorClass.newInstance();
			if (containerDescriptor != null) {
				containerDescriptor.init(ruleConfiguration);
			}
			return containerDescriptor;
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * @param actionConfiguration
	 * @return
	 */
	public IEditHelperAdvice createEditHelperAdvice(ActionConfiguration actionConfiguration) {
		Class<IActionEditHelperAdvice<ActionConfiguration>> editHelperAdviceClass = getEditHelperAdviceClass(actionConfiguration);
		if (editHelperAdviceClass == null) {
			Activator.log.error("impossible to find the edit helper advice implementation for configuration type : " + ((actionConfiguration != null) ? actionConfiguration.eClass().getName() : "null"), null);
			return null;
		}
		try {
			IActionEditHelperAdvice<ActionConfiguration> editHelperAdvice = editHelperAdviceClass.newInstance();
			if (editHelperAdvice != null) {
				editHelperAdvice.init(actionConfiguration);
			}
			return editHelperAdvice;
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * @param ruleConfiguration
	 * @return
	 */
	public ICreationElementValidator createCreationElementValidator(ActionConfiguration actionConfiguration) {
		Class<IActionCreationElementValidator<ActionConfiguration>> creationElementValidatorClass = getCreationElementValidatorClass(actionConfiguration);
		if (creationElementValidatorClass == null) {
			Activator.log.error("impossible to find the Creation Element Validator for configuration type : " + ((actionConfiguration != null) ? actionConfiguration.eClass().getName() : "null"), null);
			return null;
		}
		try {
			IActionCreationElementValidator<ActionConfiguration> creationElementValidator = creationElementValidatorClass.newInstance();
			if (creationElementValidator != null) {
				creationElementValidator.init(actionConfiguration);
			}
			return creationElementValidator;
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return null;
	}


	/**
	 * @param ruleConfiguration
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IActionCreationElementValidator<ActionConfiguration>> getCreationElementValidatorClass(ActionConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getCreationElementValidatorClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getCreationElementValidatorContributorName();
		// look in the list of registered matcher for the right one
		if (className == null) {
			Activator.log.error("There should be an implementation class for the configuration " + configurationType + " from contributor " + contributorName, null);
		} else if (contributorName != null) {
			return (Class<IActionCreationElementValidator<ActionConfiguration>>) loadClass(className, contributorName);
		}
		return null;
	}

	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IActionEditHelperAdvice<ActionConfiguration>> getEditHelperAdviceClass(ActionConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getEditHelperAdviceClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getEditHelperAdviceContributorName();

		// look in the list of registered edit helper advices for the right one
		return (Class<IActionEditHelperAdvice<ActionConfiguration>>) loadClass(className, contributorName);
	}

	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IActionContainerDescriptor<ActionConfiguration>> getContainerDescriptorClass(ActionConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getContainerDescriptorClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getContainerDescriptorContributorName();


		// look in the list of registered edit helper advices for the right one
		if (className != null && contributorName != null) {
			return (Class<IActionContainerDescriptor<ActionConfiguration>>) loadClass(className, contributorName);
		}
		return null;
	}

	protected static class ConfigurableClassDescriptor {

		/**
		 * @param editHelperAdviceContributorName
		 * @param editHelperAdviceClassName
		 * @param containerDescriptorContributorName
		 * @param containerDescriptorClassName
		 */
		public ConfigurableClassDescriptor(String editHelperAdviceContributorName, String editHelperAdviceClassName, String containerDescriptorContributorName, String containerDescriptorClassName, String creationElementValidatorContributorName,
				String creationElementValidatorClassName) {
			this.editHelperAdviceContributorName = editHelperAdviceContributorName;
			this.editHelperAdviceClassName = editHelperAdviceClassName;
			this.containerDescriptorContributorName = containerDescriptorContributorName;
			this.containerDescriptorClassName = containerDescriptorClassName;
			this.creationElementValidatorContributorName = creationElementValidatorContributorName;
			this.creationElementValidatorClassName = creationElementValidatorClassName;
		}

		private final String editHelperAdviceContributorName;

		private final String editHelperAdviceClassName;

		private final String containerDescriptorContributorName;

		private final String containerDescriptorClassName;

		private final String creationElementValidatorContributorName;

		private final String creationElementValidatorClassName;

		/**
		 * @return
		 */
		public String getCreationElementValidatorContributorName() {
			return creationElementValidatorContributorName;
		}

		/**
		 * @return
		 */
		public String getCreationElementValidatorClassName() {
			return creationElementValidatorClassName;
		}

		/**
		 * @return the editHelperAdviceContributorName
		 */
		public String getEditHelperAdviceContributorName() {
			return editHelperAdviceContributorName;
		}


		/**
		 * @return the editHelperAdviceClassName
		 */
		public String getEditHelperAdviceClassName() {
			return editHelperAdviceClassName;
		}


		/**
		 * @return the containerDescriptorContributorName
		 */
		public String getContainerDescriptorContributorName() {
			return containerDescriptorContributorName;
		}


		/**
		 * @return the containerDescriptorClassName
		 */
		public String getContainerDescriptorClassName() {
			return containerDescriptorClassName;
		}

	}

}
