/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.toolsmiths.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.views.properties.toolsmiths.ui.CustomizationDialog;
import org.eclipse.papyrus.views.properties.toolsmiths.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * A Handler for the "OpenCustomization" Action.
 * Opens the {@link CustomizationDialog}
 *
 * @author Camille Letavernier
 */
public class OpenCustomization extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell shell = HandlerUtil.getActiveShellChecked(event);

		// The first opening might take some time, as the Property view ConfigurationManager may not be initialized yet

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		try {
			dialog.run(false, false, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Opening the property view customization page", IProgressMonitor.UNKNOWN);
					runOpenCustomizationDialog(shell);
					monitor.done();
				}

			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return null;
	}

	protected void runOpenCustomizationDialog(Shell shell) {
		Dialog dialog = new CustomizationDialog(shell);
		dialog.setBlockOnOpen(false);
		dialog.open();
	}

}
