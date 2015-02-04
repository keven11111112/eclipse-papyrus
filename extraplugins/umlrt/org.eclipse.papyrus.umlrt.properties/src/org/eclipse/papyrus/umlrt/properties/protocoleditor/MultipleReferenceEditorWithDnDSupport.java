/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.properties.protocoleditor;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.umlrt.properties.Activator;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Operation;

/**
 * Multiple reference editor with drag and drop support for protocol editor.
 * 
 * @author ysroh
 *
 */
public class MultipleReferenceEditorWithDnDSupport extends
		MultipleReferenceEditor {

	/**
	 * Constructor
	 * 
	 * @param parent
	 * @param style
	 */
	public MultipleReferenceEditorWithDnDSupport(Composite parent, int style) {
		super(parent, style);
		addDnDSupport(treeViewer);

	}

	/**
	 * Add drag and drop support for viewer
	 * 
	 * @param viewer
	 */
	private void addDnDSupport(final TreeViewer viewer) {
		viewer.addDragSupport(DND.DROP_MOVE,
				new Transfer[] { LocalSelectionTransfer.getTransfer() },
				new DragSourceAdapter() {

					public void dragSetData(DragSourceEvent event) {
						final LocalSelectionTransfer transfer = LocalSelectionTransfer
								.getTransfer();
						if (transfer.isSupportedType(event.dataType)) {
							transfer.setSelection(viewer.getSelection());
							transfer.setSelectionSetTime(event.time & 0xFFFF);
						}
					}
				});
		viewer.addDropSupport(DND.DROP_MOVE,
				new Transfer[] { LocalSelectionTransfer.getTransfer() },
				new ViewerDropAdapter(viewer) {

					@Override
					public boolean performDrop(Object data) {
						final LocalSelectionTransfer transfer = LocalSelectionTransfer
								.getTransfer();
						final IStructuredSelection selection = (IStructuredSelection) transfer
								.getSelection();
						if (viewer.getSelection().equals(selection)) {
							return false;
						}
						if (selection.isEmpty()) {
							return false;
						}
						if (!(selection.getFirstElement() instanceof Operation)) {
							return false;
						}
						final EObject element = (EObject) selection
								.getFirstElement();
						if (!(viewer.getInput() instanceof IObservableList)) {
							return false;
						}
						final IObservableList observable = (IObservableList) viewer
								.getInput();
						TransactionalEditingDomain editingDomain = TransactionUtil
								.getEditingDomain(element);
						EMFCommandOperation command = new EMFCommandOperation(
								editingDomain, new RecordingCommand(
										editingDomain, "Move Element") { //$NON-NLS-1$

									@Override
									protected void doExecute() {
										observable.add(element);
									}
								});
						try {
							OperationHistoryFactory.getOperationHistory()
									.execute(command, null, null);
						} catch (ExecutionException e1) {
							Activator.log.error("Failed to move element", e1); //$NON-NLS-1$
						}
						return true;
					}

					@Override
					public boolean validateDrop(Object target, int operation,
							TransferData transferType) {
						final LocalSelectionTransfer transfer = LocalSelectionTransfer
								.getTransfer();
						final int location = getCurrentLocation();
						final boolean valid = (location == LOCATION_NONE || location == LOCATION_ON)
								&& transfer.isSupportedType(transferType);
						return valid;
					}
				});
	}
}
