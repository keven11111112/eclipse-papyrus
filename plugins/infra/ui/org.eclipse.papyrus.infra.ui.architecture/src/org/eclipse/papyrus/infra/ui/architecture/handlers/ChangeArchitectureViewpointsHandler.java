/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.ui.architecture.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.architecture.ArchitectureDescriptionUtils;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

/**
 * A command handler for changing architecture viewpoints in a model set
 *
 * @since 1.0
 */
public class ChangeArchitectureViewpointsHandler extends CompoundContributionItem {

	// the label provider for architecture viewpoints
	private ILabelProvider provider;
	
	public ChangeArchitectureViewpointsHandler() {
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		provider = new AdapterFactoryLabelProvider(composedAdapterFactory);
	}
	
	@Override
	protected IContributionItem[] getContributionItems() {
		final EObject selection = getSelection();
		if (selection == null)
			return new IContributionItem[0];
		ResourceSet resourceSet = selection.eResource().getResourceSet();
		if (!(resourceSet instanceof ModelSet))
			return new IContributionItem[0];
		final ArchitectureDescriptionUtils helper = new ArchitectureDescriptionUtils((ModelSet)resourceSet);
		MergedArchitectureContext context = helper.getArchitectureContext();
		final Set<String> viewpointIds = new HashSet<String>(helper.getArchitectureViewpointIds());

		List<IContributionItem> items = new ArrayList<IContributionItem>();
		for (MergedArchitectureViewpoint viewpoint : context.getViewpoints()) {
			Object imageObject = viewpoint.getImageObject();
			ImageDescriptor desc = ExtendedImageRegistry.getInstance().getImageDescriptor(provider.getImage(imageObject));
			items.add(new ActionContributionItem(new Action(viewpoint.getName(), desc) {
				{
					setChecked(viewpointIds.contains(viewpoint.getId()));
				}
				@Override
				public void run() {
					if (!isChecked())
						viewpointIds.remove(viewpoint.getId());
					else
						viewpointIds.add(viewpoint.getId());
					TransactionalEditingDomain ted = helper.getModelSet().getTransactionalEditingDomain();
					Command cmd = helper.switchArchitectureViewpointIds(viewpointIds.toArray(new String[0]));
					ted.getCommandStack().execute(cmd);
				}
			}));
		}
		return items.toArray(new IContributionItem[0]);
	}

	/**
	 * Gets the current selection as an EObject
	 *
	 * @return The current selection, or <code>null</code> if it is not an EObject
	 */
	protected EObject getSelection() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return null;
		}
		ISelection selection = window.getSelectionService().getSelection();
		if (selection == null) {
			return null;
		}
		if (selection.isEmpty()) {
			return null;
		}
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection struct = (IStructuredSelection) selection;
			Object obj = struct.getFirstElement();
			return EMFHelper.getEObject(obj);
		}
		return null;
	}
}
