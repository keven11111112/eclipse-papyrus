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

import java.util.Iterator;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.AndInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.OrInvariantRuleConfiguration;


public class DefaultInvariantEditHelperAdvice extends AbstractEditHelperAdvice {

	InvariantTypeConfiguration configuration;

	public DefaultInvariantEditHelperAdvice(InvariantTypeConfiguration configuration) {
		this.configuration = configuration;
	}

	protected boolean processCompositeRule(CompositeInvariantRuleConfiguration compositeRule, IEditCommandRequest request) {
		Iterator<InvariantRuleConfiguration> iterator = compositeRule.getComposedRules().iterator();
		InvariantRuleConfiguration nextComposedRuleConfiguration = iterator.next();
		boolean result = processInvariantRule(nextComposedRuleConfiguration, request);

		while (iterator.hasNext()) {
			nextComposedRuleConfiguration = iterator.next();

			boolean resultNextComposedRuleConfiguration = processInvariantRule(nextComposedRuleConfiguration, request);

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

	protected boolean processInvariantRule(InvariantRuleConfiguration invariantRuleConfiguration, IEditCommandRequest request) {
		if (invariantRuleConfiguration instanceof CompositeInvariantRuleConfiguration) {
			return processCompositeRule((CompositeInvariantRuleConfiguration) invariantRuleConfiguration, request);
		} else if (invariantRuleConfiguration instanceof NotInvariantRuleConfiguration) {
			InvariantRuleConfiguration composedRule = ((NotInvariantRuleConfiguration) invariantRuleConfiguration).getComposedRule();
			return !processInvariantRule(composedRule, request);
		} else {
			return InvariantRuleConfigurationTypeRegistry.getInstance().getInvariantRule(invariantRuleConfiguration).approveRequest(request);
		}
	}

	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		InvariantRuleConfiguration invariantRuleConfiguration = configuration.getInvariantRuleConfiguration();

		return processInvariantRule(invariantRuleConfiguration, request);
	}


}
