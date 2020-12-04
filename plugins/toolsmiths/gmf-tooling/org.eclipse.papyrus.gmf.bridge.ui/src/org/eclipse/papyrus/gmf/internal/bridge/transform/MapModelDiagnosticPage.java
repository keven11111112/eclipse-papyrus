/*******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Alexander Fedorov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.transform;

import org.eclipse.emf.common.util.Diagnostic;


class MapModelDiagnosticPage extends ModelDiagnosticPage {
	
	MapModelDiagnosticPage(String pageName) {
		super(pageName);
		setTitle(Messages.TransformToGenModelWizard_title_mapdiagnostic);
		setDescription(Messages.TransformToGenModelWizard_descr_mapdiagnostic);
	}

	@Override
	protected boolean getIgnoreOption() {
		return getOperation().getOptions().getIgnoreMapModelValidation();
	}

	@Override
	protected Diagnostic getValidationResult() {
		return getOperation().getMapmodelValidationResult();
	}

	@Override
	protected void setIgnoreOption(boolean ignore) {
		getOperation().getOptions().setIgnoreMapModelValidation(ignore);
	}

}
