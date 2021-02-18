/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.codegen.dashboard;

import org.eclipse.papyrus.gmf.bridge.ui.dashboard.DashboardAction;
import org.eclipse.papyrus.gmf.bridge.ui.dashboard.DashboardFacade;
import org.eclipse.papyrus.gmf.bridge.ui.dashboard.DashboardState;
import org.eclipse.papyrus.gmf.internal.codegen.popup.actions.ExecuteTemplatesOperation;

/**
 * @author dstadnik
 */
public class GenerateDEAction implements DashboardAction {

	private DashboardFacade context;

	public void init(DashboardFacade context) {
		this.context = context;
	}

	public boolean isEnabled() {
		DashboardState state = context.getState();
		if (context.isStrict()) {
			if (state.getDM() == null || state.getDGM() == null) {
				return false;
			}
		}
		return state.getGM() != null;
	}

	public void run() {
		ExecuteTemplatesOperation op = new ExecuteTemplatesOperation();
		op.setGenModelURI(context.getState().getGM());
		op.run();
	}
}
