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
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.AdviceBindingInheritance;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IConfiguredEditHelperAdviceDescriptor;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.IEditHelperAdviceFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfiguredEditHelperAdviceDescriptor;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;

@SuppressWarnings("restriction")
public abstract class AbstractEditHelperAdviceFactory<T extends AdviceConfiguration> implements IEditHelperAdviceFactory<T> {

	public IConfiguredEditHelperAdviceDescriptor<T> createEditHelperAdviceDescriptor(T adviceConfiguration) {
		return new ConfiguredEditHelperAdviceDescriptor<T>(getId(adviceConfiguration), getTypeId(adviceConfiguration), getMatcher(adviceConfiguration), getContainerDescriptor(adviceConfiguration), getEditHelperAdvice(adviceConfiguration),
				getInheritance(adviceConfiguration));
	}

	protected String getId(T adviceConfiguration) {
		return adviceConfiguration.getIdentifier();
	}

	abstract protected String getTypeId(T adviceConfiguration);

	abstract protected IElementMatcher getMatcher(T adviceConfiguration);

	abstract protected IContainerDescriptor getContainerDescriptor(T adviceConfiguration);

	protected IEditHelperAdvice getEditHelperAdvice(T adviceConfiguration) {
		IEditHelperAdvice editHelperAdvice = ClassLoaderHelper.newInstance(adviceConfiguration.getEditHelperAdviceClassName(), IEditHelperAdvice.class);
		return editHelperAdvice;
	}

	protected AdviceBindingInheritance getInheritance(T adviceConfiguration) {
		return AdviceBindingInheritance.getAdviceBindingInheritance(adviceConfiguration.getInheritance().getName());
	}
}
