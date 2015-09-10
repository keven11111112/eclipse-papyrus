/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.generation.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.adl4eclipse.generation.generator.FeatureGenerator;
import org.eclipse.papyrus.adl4eclipse.generation.generator.Generator;
import org.eclipse.papyrus.adl4eclipse.generation.generator.PluginGenerator;
import org.eclipse.papyrus.adl4eclipse.generation.generator.BundleGenerator;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Component;

public class GenerateSelected extends AbstractHandler {

	private final String DIALOG_WARNING_TITLE = "Warning";

	private IWorkbenchWindow window;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		window = HandlerUtil.getActiveWorkbenchWindow(event);
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator<?> iterator = structuredSelection.iterator();
			List<Generator> generators = new ArrayList<>();

			while (iterator.hasNext()) {
				Object element = iterator.next();

				if (element instanceof IAdaptable) {
					Component adapter = ((IAdaptable) element).getAdapter(Component.class);

					if (adapter != null) {
						if (adapter.getAppliedStereotypes().size() == 0) {
							displayWarning("Can not generate the selected component: " + adapter.getName());
						}

						if (adapter.getAppliedStereotype(OSGIStereotypes.BUNDLE) != null) {
							generators.add(new BundleGenerator(adapter));
						}

						if (adapter.getAppliedStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE) != null) {
							generators.add(new PluginGenerator(adapter));
						}

						if (adapter.getAppliedStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE) != null) {
							generators.add(new FeatureGenerator(adapter));
						}
					}
				}
			}

			for (Generator generator : generators) {
				try {
					generator.generate();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	private void displayWarning(String message) {
		MessageDialog.openInformation(window.getShell(), DIALOG_WARNING_TITLE, message);
	}

}
