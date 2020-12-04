/*******************************************************************************
* Copyright (c) 2013, 2020 Montages A.G., CEA LIST, Artal
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License 2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*  	Guillaume Hillairet (Montages A.G.) : initial implementation
*    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
*****************************************************************************/
package org.eclipse.papyrus.gmf.codegen.xtend.ui.handlers;

import org.eclipse.papyrus.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.papyrus.gmf.codegen.util.GeneratorWithXtend2;
import org.eclipse.papyrus.gmf.internal.codegen.popup.actions.ExecuteTemplatesOperation;

public class ExecuteTemplatesOperationWithXtend2 extends ExecuteTemplatesOperation {

	@Override
	protected GeneratorBase createGenerator() {
		return new GeneratorWithXtend2(getGenModel());
	}
}
