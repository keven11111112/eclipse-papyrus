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
package org.eclipse.papyrus.infra.elementtypesconfigurations.internal.ui.advice;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.AdviceBindingFactory;

public class RuntimeValuesEditionAdviceEditHelperAdviceFactory extends AdviceBindingFactory {

	@Override
	protected IEditHelperAdvice getEditHelperAdvice(AdviceBindingConfiguration adviceConfiguration) {
		if (adviceConfiguration instanceof RuntimeValuesEditionAdviceConfiguration) {
			IEditHelperAdvice editHelperAdvice = new RuntimeValuesEditionAdviceEditHelperAdvice((RuntimeValuesEditionAdviceConfiguration) adviceConfiguration);
			return editHelperAdvice;
		}
		return super.getEditHelperAdvice(adviceConfiguration);
	}
}
