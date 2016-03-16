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
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Add createAdviceBindingConfiguration method.
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.types.core.advices.settype;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.core.factories.impl.AbstractAdviceBindingFactory;
import org.eclipse.papyrus.infra.types.core.impl.NullEditHelperAdvice;


public class SetTypeAdviceFactory extends AbstractAdviceBindingFactory<AbstractAdviceBindingConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IEditHelperAdvice getEditHelperAdvice(AbstractAdviceBindingConfiguration adviceConfiguration) {
		if (adviceConfiguration instanceof SetTypeAdviceConfiguration) {
			IEditHelperAdvice editHelperAdvice = new SetTypeAdviceEditHelperAdvice((SetTypeAdviceConfiguration) adviceConfiguration);
			return editHelperAdvice;
		}
		return NullEditHelperAdvice.getInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractAdviceBindingConfiguration createAdviceBindingConfiguration() {
		return SetTypeAdviceConfigurationFactory.eINSTANCE.createSetTypeAdviceConfiguration();
	}


}
