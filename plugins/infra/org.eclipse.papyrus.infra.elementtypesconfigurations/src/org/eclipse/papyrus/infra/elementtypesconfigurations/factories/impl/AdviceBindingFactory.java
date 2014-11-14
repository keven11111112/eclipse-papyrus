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
package org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl;

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ContainerConfigurationTypeRegistry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.MatcherConfigurationTypeRegistry;

public class AdviceBindingFactory extends AbstractEditHelperAdviceFactory<AdviceBindingConfiguration> {

	@Override
	protected String getTypeId(AdviceBindingConfiguration adviceConfiguration) {
		return adviceConfiguration.getTarget().getIdentifier();
	}

	@Override
	protected IContainerDescriptor getContainerDescriptor(AdviceBindingConfiguration adviceConfiguration) {
		ContainerConfiguration containerConfiguration = adviceConfiguration.getContainerConfiguration();
		if(containerConfiguration == null) {
			return null;
		}
		IContainerDescriptor containerDescriptor = ContainerConfigurationTypeRegistry.getInstance().getContainerDescriptor(containerConfiguration);
		return containerDescriptor;
	}

	@Override
	protected IElementMatcher getMatcher(AdviceBindingConfiguration adviceConfiguration) {
		MatcherConfiguration matcherConfiguration = adviceConfiguration.getMatcherConfiguration();
		if(matcherConfiguration == null) {
			return null;
		}
		IElementMatcher matcher = MatcherConfigurationTypeRegistry.getInstance().getMatcher(matcherConfiguration);
		return matcher;
	}
}
