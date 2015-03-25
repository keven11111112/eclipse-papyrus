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
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;

public class InvariantRuleConfigurationTypeRegistry {

	/** private singleton instance */
	private static InvariantRuleConfigurationTypeRegistry registry;

	/** map configuration type to invariantRule */
	protected Map<String, IInvariantRule<? extends InvariantRuleConfiguration>> invariantRuleConfigurationTypeToInvariantRule = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized InvariantRuleConfigurationTypeRegistry getInstance() {
		if (registry == null) {
			registry = new InvariantRuleConfigurationTypeRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		invariantRuleConfigurationTypeToInvariantRule = new HashMap<String, IInvariantRule<? extends InvariantRuleConfiguration>>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IInvariantRuleExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			String configurationClass = configurationElement.getAttribute(IInvariantRuleExtensionPoint.CONFIGURATION_CLASS);

			try {
				Object invariantRuleClass = configurationElement.createExecutableExtension(IInvariantRuleExtensionPoint.INVARIANT_RULE_CLASS);
				if (invariantRuleClass instanceof IInvariantRule) {
					invariantRuleConfigurationTypeToInvariantRule.put(configurationClass, (IInvariantRule<?>) invariantRuleClass);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
	}

	public <T extends InvariantRuleConfiguration> IInvariantRule<? extends InvariantRuleConfiguration> getInvariantRule(T invariantRuleConfiguration) {
		String invariantRuleConfigurationType = invariantRuleConfiguration.eClass().getInstanceTypeName();
		// We assume here that the right invariantType is registered for the right InvariantRuleConfiguration
		@SuppressWarnings("unchecked")
		IInvariantRule<T> invariantRule = (IInvariantRule<T>) invariantRuleConfigurationTypeToInvariantRule.get(invariantRuleConfigurationType);
		if (invariantRule != null) {
			invariantRule.init(invariantRuleConfiguration);
			return invariantRule;
		} else {
			return new DefaultInvariantRule();
		}
	}
}
