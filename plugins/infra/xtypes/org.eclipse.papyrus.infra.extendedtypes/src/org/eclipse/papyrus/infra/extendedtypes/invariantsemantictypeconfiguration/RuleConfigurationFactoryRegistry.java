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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import static org.eclipse.papyrus.infra.extendedtypes.util.InternalUtils.loadClass;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.extendedtypes.Activator;

/**
 * Registry for all matcher factories.
 */
public class RuleConfigurationFactoryRegistry {

	/** private singleton instance */
	private static RuleConfigurationFactoryRegistry registry;

	/** map configuration type to matcher descriptor */
	protected Map<String, ConfigurableClassDescriptor> configurationTypeToClassDescriptor = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized RuleConfigurationFactoryRegistry getInstance() {
		if (registry == null) {
			registry = new RuleConfigurationFactoryRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		configurationTypeToClassDescriptor = new HashMap<String, RuleConfigurationFactoryRegistry.ConfigurableClassDescriptor>();
		// read invariant rule configuration etension point
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IInvariantRuleExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element
		for (IConfigurationElement configurationElement : elements) {
			// contributor will always be the same, but implementation could be different.
			String contributorName = configurationElement.getContributor().getName();

			String configurationClass = configurationElement.getAttribute(IInvariantRuleExtensionPoint.RULE_CONFIGURATION_CLASS);

			String matcherClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.ELEMENT_MATCHER_CLASS);
			String editHelperAdviceClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.EDIT_HELPER_ADVICE_CLASS);
			String containerDescriptorClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.CONTAINER_DESCRIPTOR_CLASS);
			String creationElementValidatorClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.CREATION_ELEMENT_VALIDATOR_CLASS);

			ConfigurableClassDescriptor configurableClassDescriptor = new ConfigurableClassDescriptor(contributorName, matcherClassName, contributorName, editHelperAdviceClassName, contributorName, containerDescriptorClassName, contributorName,
					creationElementValidatorClassName);
			configurationTypeToClassDescriptor.put(configurationClass, configurableClassDescriptor);
		}

	}

	/**
	 * Creates the {@link IElementMatcher} specific to the given rule configuration
	 *
	 * @param ruleConfiguration
	 *            the rule configuration that will configure the created matcher
	 * @return the {@link IElementMatcher} created or <code>null</code> if none could be created
	 */
	public IInvariantElementMatcher<InvariantRuleConfiguration> createMatcher(InvariantRuleConfiguration ruleConfiguration) {
		// creates the matcher from the extension points
		Class<IInvariantElementMatcher<InvariantRuleConfiguration>> elementMatcherClass = getMatcherClass(ruleConfiguration);
		if (elementMatcherClass == null) {
			return null;
		}
		try {
			IInvariantElementMatcher<InvariantRuleConfiguration> matcher = elementMatcherClass.newInstance();
			if (matcher != null) {
				matcher.init(ruleConfiguration);
			}
			return matcher;
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
	public IInvariantContainerDescriptor<InvariantRuleConfiguration> createContainerDescriptor(InvariantRuleConfiguration ruleConfiguration) {
		Class<IInvariantContainerDescriptor<InvariantRuleConfiguration>> containerDescriptorClass = getContainerDescriptorClass(ruleConfiguration);
		if (containerDescriptorClass == null) {
			return null;
		}
		try {
			IInvariantContainerDescriptor<InvariantRuleConfiguration> containerDescriptor = containerDescriptorClass.newInstance();
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
	 * @param ruleConfiguration
	 * @return
	 */
	public IInvariantEditHelperAdvice<InvariantRuleConfiguration> createEditHelperAdvice(InvariantRuleConfiguration ruleConfiguration) {
		Class<IInvariantEditHelperAdvice<InvariantRuleConfiguration>> editHelperAdviceClass = getEditHelperAdviceClass(ruleConfiguration);
		if (editHelperAdviceClass == null) {
			Activator.log.error("impossible to find the edit helper advice implementation for configuration type : " + ((ruleConfiguration != null) ? ruleConfiguration.eClass().getName() : "null"), null);
			return null;
		}
		try {
			IInvariantEditHelperAdvice<InvariantRuleConfiguration> editHelperAdvice = editHelperAdviceClass.newInstance();
			if (editHelperAdvice != null) {
				editHelperAdvice.init(ruleConfiguration);
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
	public IInvariantCreationElementValidator<InvariantRuleConfiguration> createCreationElementValidator(InvariantRuleConfiguration ruleConfiguration) {
		Class<IInvariantCreationElementValidator<InvariantRuleConfiguration>> creationElementValidatorClass = getCreationElementValidatorClass(ruleConfiguration);
		if (creationElementValidatorClass == null) {
			// Activator.log.error("impossible to find the Creation Element Validator for configuration type : " + ((ruleConfiguration!=null) ? ruleConfiguration.eClass().getName() : "null"), null);
			return null;
		}
		try {
			IInvariantCreationElementValidator<InvariantRuleConfiguration> creationElementValidator = creationElementValidatorClass.newInstance();
			if (creationElementValidator != null) {
				creationElementValidator.init(ruleConfiguration);
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
	protected Class<IInvariantCreationElementValidator<InvariantRuleConfiguration>> getCreationElementValidatorClass(InvariantRuleConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getCreationElementValidatorClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getCreationElementValidatorContributorName();

		// look in the list of registered matcher for the right one
		if (className == null) {
			// Activator.log.error("There should be an implementation class for the configuration "+configurationType+ " from contributor "+contributorName, null);
		} else if (contributorName != null) {
			return (Class<IInvariantCreationElementValidator<InvariantRuleConfiguration>>) loadClass(className, contributorName);
		}
		return null;
	}

	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IInvariantElementMatcher<InvariantRuleConfiguration>> getMatcherClass(InvariantRuleConfiguration configuration) {

		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getElementMatcherClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getElementMatcherContributorName();

		// look in the list of registered matcher for the right one
		if (className != null && contributorName != null) {
			return (Class<IInvariantElementMatcher<InvariantRuleConfiguration>>) loadClass(className, contributorName);
		}
		return null;
	}

	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IInvariantEditHelperAdvice<InvariantRuleConfiguration>> getEditHelperAdviceClass(InvariantRuleConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getEditHelperAdviceClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getEditHelperAdviceContributorName();

		// look in the list of registered edit helper advices for the right one
		return (Class<IInvariantEditHelperAdvice<InvariantRuleConfiguration>>) loadClass(className, contributorName);
	}

	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IInvariantContainerDescriptor<InvariantRuleConfiguration>> getContainerDescriptorClass(InvariantRuleConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getContainerDescriptorClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getContainerDescriptorContributorName();


		// look in the list of registered edit helper advices for the right one
		if (className != null && contributorName != null) {
			return (Class<IInvariantContainerDescriptor<InvariantRuleConfiguration>>) loadClass(className, contributorName);
		}
		return null;
	}

	protected static class ConfigurableClassDescriptor {

		/**
		 * @param elementMatcherContributorName
		 * @param elementMatcherClassName
		 * @param editHelperAdviceContributorName
		 * @param editHelperAdviceClassName
		 * @param containerDescriptorContributorName
		 * @param containerDescriptorClassName
		 */
		public ConfigurableClassDescriptor(String elementMatcherContributorName, String elementMatcherClassName, String editHelperAdviceContributorName, String editHelperAdviceClassName, String containerDescriptorContributorName,
				String containerDescriptorClassName, String creationElementValidatorContributorName, String creationElementValidatorClassName) {
			this.elementMatcherContributorName = elementMatcherContributorName;
			this.elementMatcherClassName = elementMatcherClassName;
			this.editHelperAdviceContributorName = editHelperAdviceContributorName;
			this.editHelperAdviceClassName = editHelperAdviceClassName;
			this.containerDescriptorContributorName = containerDescriptorContributorName;
			this.containerDescriptorClassName = containerDescriptorClassName;
			this.creationElementValidatorContributorName = creationElementValidatorContributorName;
			this.creationElementValidatorClassName = creationElementValidatorClassName;
		}

		private final String elementMatcherContributorName;

		private final String elementMatcherClassName;

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
		 * @return the elementMatcherContributorName
		 */
		public String getElementMatcherContributorName() {
			return elementMatcherContributorName;
		}


		/**
		 * @return the elementMatcherClassName
		 */
		public String getElementMatcherClassName() {
			return elementMatcherClassName;
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

	// /////////////////////////////////////////////////////////////////////////
	// loading resource
	// /////////////////////////////////////////////////////////////////////////
}
