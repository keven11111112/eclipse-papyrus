/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.AndInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.OrInvariantRuleConfiguration;


public class DefaultInvariantElementMatcher implements IElementMatcher {


	InvariantTypeConfiguration configuration;

	public DefaultInvariantElementMatcher(InvariantTypeConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.IElementMatcher#matches(org.eclipse.emf.ecore.EObject)
	 *
	 * @param eObject
	 * @return
	 */
	@Override
	public boolean matches(EObject eObject) {
		InvariantRuleConfiguration invariantRuleConfiguration = configuration.getInvariantRuleConfiguration();

		return processInvariantRule(invariantRuleConfiguration, eObject);
	}

	/**
	 * @param invariantRuleConfiguration
	 * @param eObject
	 * @return
	 */
	protected boolean processInvariantRule(InvariantRuleConfiguration invariantRuleConfiguration, EObject eObject) {
		if (invariantRuleConfiguration instanceof CompositeInvariantRuleConfiguration) {
			return processCompositeRule((CompositeInvariantRuleConfiguration) invariantRuleConfiguration, eObject);
		} else if (invariantRuleConfiguration instanceof NotInvariantRuleConfiguration) {
			InvariantRuleConfiguration composedRule = ((NotInvariantRuleConfiguration) invariantRuleConfiguration).getComposedRule();
			return !processInvariantRule(composedRule, eObject);
		} else {
			return InvariantRuleConfigurationTypeRegistry.getInstance().getInvariantRule(invariantRuleConfiguration).matches(eObject);
		}
	}

	/**
	 * @param compositeRule
	 * @param eObject
	 * @return
	 */
	protected boolean processCompositeRule(CompositeInvariantRuleConfiguration compositeRule, EObject eObject) {
		Iterator<InvariantRuleConfiguration> iterator = compositeRule.getComposedRules().iterator();
		InvariantRuleConfiguration nextComposedRuleConfiguration = iterator.next();
		boolean result = processInvariantRule(nextComposedRuleConfiguration, eObject);

		while (iterator.hasNext()) {
			nextComposedRuleConfiguration = iterator.next();

			boolean resultNextComposedRuleConfiguration = processInvariantRule(nextComposedRuleConfiguration, eObject);

			if (compositeRule instanceof OrInvariantRuleConfiguration) {
				if (result == false && resultNextComposedRuleConfiguration) {
					result = true;
				}
			} else if (compositeRule instanceof AndInvariantRuleConfiguration) {
				if (result == true && !resultNextComposedRuleConfiguration) {
					result = false;
				}
			}
		}

		return result;
	}



}
