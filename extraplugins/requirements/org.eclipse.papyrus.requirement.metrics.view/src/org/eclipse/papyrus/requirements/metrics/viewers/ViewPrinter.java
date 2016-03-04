/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.metrics.viewers;

import java.util.ArrayList;

import org.eclipse.papyrus.metrics.extensionpoints.IPrinter;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.Result;
import org.eclipse.papyrus.metrics.view.MetricsView;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


public class ViewPrinter implements IPrinter {
	static final String viewId = "org.eclipse.papyrus.metrics.view.MetricsView"; //$NON-NLS-1$

	@Override
	public void print(ArrayList<Result> measuresResults) {
		
		try {
			IWorkbenchPage page =PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			
			// ensure the Papyrus perspective
			IPerspectiveDescriptor perspective = page.getWorkbenchWindow().getWorkbench().getPerspectiveRegistry().findPerspectiveWithId("org.eclipse.papyrus.infra.core.perspective");
			if (!perspective.getId().equals(page.getPerspective().getId())) {
				page.setPerspective(perspective);
			}
			// minimize the Welcome view
			for (IViewReference next : page.getViewReferences()) {
				if ("org.eclipse.ui.internal.introview".equals(next.getId())) {
					page.setPartState(next, IWorkbenchPage.STATE_MINIMIZED);
					break;
				}
			}
			// bring the View forward
			IViewPart myView = page.showView(viewId);
			page.activate(myView);
			page.setEditorAreaVisible(true);
			((MetricsView)myView).updateInformation(measuresResults);
			page.showView(viewId);
			page.bringToTop(myView);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}