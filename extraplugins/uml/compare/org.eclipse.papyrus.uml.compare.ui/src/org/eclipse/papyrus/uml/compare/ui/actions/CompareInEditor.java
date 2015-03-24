/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Shuai Li - shuai.li@cea.fr
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.compare.ui.actions;

import java.util.Iterator;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareUI;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.ide.ui.internal.EMFCompareIDEUIMessages;
import org.eclipse.emf.compare.ide.ui.internal.handler.AbstractCompareHandler;
import org.eclipse.emf.compare.ide.ui.internal.handler.SelectAncestorDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class CompareInEditor extends AbstractCompareHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		final IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		final ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			Iterator<?> selectionIterator = ((IStructuredSelection) selection).iterator();
			Notifier left = null;
			Notifier right = null;
			Notifier origin = null;

			left = (Notifier) EMFHelper.getEObject(selectionIterator.next());
			if (selectionIterator.hasNext()) {
				right = (Notifier) EMFHelper.getEObject(selectionIterator.next());
			}
			if (selectionIterator.hasNext()) {
				origin = (Notifier) EMFHelper.getEObject(selectionIterator.next());
			}

			if (origin != null) {
				Shell shell = HandlerUtil.getActiveShell(event);
				SelectAncestorDialog dialog = new SelectAncestorDialog(shell, adapterFactory, new Notifier[] {left, right, origin});
				if (dialog.open() == Window.CANCEL) {
					return null;
				} else {
//					left = dialog.leftNotifier;
//					right = dialog.rightNotifier;
//					origin = dialog.originNotifier;
					// TODO
				}
			}

			// Do not compare an object with its ancestor (e.g. operation with its owner class).
			if (left instanceof EObject
					&& right instanceof EObject
					&& (EcoreUtil.isAncestor((EObject) left, (EObject) right) || EcoreUtil.isAncestor((EObject) right, (EObject) left))) {
				MessageDialog.openInformation(activePart.getSite().getShell(), "EMF Compare", EMFCompareIDEUIMessages.getString("CompareSelfWithAncestor"));
			} else {
				final CompareEditorInput input = createCompareEditorInput(activePart, adapterFactory, left, right, origin);
				CompareUI.openCompareEditor(input);
			}
		}
		
		return null;
	}
}
