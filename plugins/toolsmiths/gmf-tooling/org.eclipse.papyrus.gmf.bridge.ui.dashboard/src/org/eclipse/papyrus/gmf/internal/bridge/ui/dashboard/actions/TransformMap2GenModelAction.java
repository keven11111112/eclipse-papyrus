/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal and others
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
package org.eclipse.papyrus.gmf.internal.bridge.ui.dashboard.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.papyrus.gmf.bridge.ui.dashboard.DashboardAction;
import org.eclipse.papyrus.gmf.bridge.ui.dashboard.DashboardFacade;
import org.eclipse.papyrus.gmf.bridge.ui.dashboard.DashboardState;
import org.eclipse.papyrus.gmf.internal.bridge.transform.TransformOptions;
import org.eclipse.papyrus.gmf.internal.bridge.transform.TransformToGenModelOperation;

/**
 * @author dstadnik
 */
public class TransformMap2GenModelAction implements DashboardAction {

	private DashboardFacade context;

	public void init(DashboardFacade context) {
		this.context = context;
	}

	public boolean isEnabled() {
		DashboardState state = context.getState();
		if (context.isStrict()) {
			if (state.getDM() == null || state.getDGM() == null || state.getTDM() == null) {
				return false;
			}
		}
		return state.getMM() != null;
	}

	public void run() {
		DashboardState state = context.getState();
		URI mm = state.getMM();
		URI gm = state.getGM();
		if (gm == null) {
			gm = mm.trimFileExtension().appendFileExtension("gmfgen"); //$NON-NLS-1$
			state.setGM(gm);
		}
		IStatus result = Status.OK_STATUS;
		try {
			final ResourceSet rs = new ResourceSetImpl();
			TransformToGenModelOperation op = new TransformToGenModelOperation(rs);
			configureOptions(op.getOptions());
			op.loadMappingModel(mm, new NullProgressMonitor());
			op.loadGenModel(state.getDGM(), new NullProgressMonitor());
			op.setGenURI(gm);
			result = op.executeTransformation(new NullProgressMonitor());
		} catch (CoreException ce) {
			result = ce.getStatus();
		} finally {
			context.updateStatus();
		}
		ErrorDialog.openError(context.getShell(), null, null, result, IStatus.ERROR | IStatus.WARNING);
	}

	protected void configureOptions(TransformOptions options) {
		options.setUseRuntimeFigures(true);
		options.setUseMapMode(true);
		options.setGenerateRCP(context.getState().getOption(DashboardFacade.OPTION_RCP));
	}
}
