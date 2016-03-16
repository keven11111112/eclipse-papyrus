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
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - add createAdviceBindingConfiguration method
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.types.core.factories.impl;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsFactory;

public class DefaultAdviceBindingFactory extends AbstractAdviceBindingFactory<AdviceBindingConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IEditHelperAdvice getEditHelperAdvice(final AdviceBindingConfiguration adviceConfiguration) {
		IEditHelperAdvice editHelperAdvice = ClassLoaderHelper.newInstance(adviceConfiguration.getEditHelperAdviceClassName(), IEditHelperAdvice.class);
		return editHelperAdvice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractAdviceBindingConfiguration createAdviceBindingConfiguration() {
		return ElementTypesConfigurationsFactory.eINSTANCE.createAdviceBindingConfiguration();
	}

}
