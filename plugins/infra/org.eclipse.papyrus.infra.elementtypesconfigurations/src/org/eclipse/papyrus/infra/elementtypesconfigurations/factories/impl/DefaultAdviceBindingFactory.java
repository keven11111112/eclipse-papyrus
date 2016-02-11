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

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;

public class DefaultAdviceBindingFactory extends AbstractAdviceBindingFactory<AdviceBindingConfiguration> {

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.AbstractAdviceFactory#getEditHelperAdvice(org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration)
	 *
	 * @param adviceConfiguration
	 * @return
	 */
	@Override
	protected IEditHelperAdvice getEditHelperAdvice(AdviceBindingConfiguration adviceConfiguration) {
		IEditHelperAdvice editHelperAdvice = ClassLoaderHelper.newInstance(adviceConfiguration.getEditHelperAdviceClassName(), IEditHelperAdvice.class);
		return editHelperAdvice;
	}

}
