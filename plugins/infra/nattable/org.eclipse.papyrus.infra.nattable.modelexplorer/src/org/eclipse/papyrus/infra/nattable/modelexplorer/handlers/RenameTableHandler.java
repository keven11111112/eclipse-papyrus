/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *  Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Bug 497289
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.modelexplorer.handlers;

import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.modelexplorer.messages.Messages;
import org.eclipse.papyrus.views.modelexplorer.DirectEditorEditingSupport;
import org.eclipse.swt.widgets.Display;

/**
 * This handler provides the method to rename a Table
 */
public class RenameTableHandler extends AbstractTableCommandHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand(IEvaluationContext context) {
		TransactionalEditingDomain editingDomain = getEditingDomain(context);
		List<Table> tables = getSelectedTables();
		if (editingDomain != null && tables.size() == 1) {

			final Table table = tables.get(0);
			final String currentName = table.getName();
			if (currentName != null) {

				AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "RenameTableCommand", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
						InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.RenameTableHandler_RenameAnExistingTable, Messages.RenameTableHandler_NewName, currentName, null);
						if (dialog.open() == Window.OK) {
							final String name = dialog.getValue();
							if (name != null && name.length() > 0) {
								table.setName(name);
							}
							return CommandResult.newOKCommandResult();
						} else {
							return CommandResult.newCancelledCommandResult();
						}
					}
				};
				return new GMFtoEMFCommandWrapper(cmd);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean computeEnabled(final IEvaluationContext context) {
		boolean computeEnabled = super.computeEnabled(context);
		if (computeEnabled) {
			List<EObject> selectedElements = getSelectedElements();
			EObject selection = selectedElements.get(0);
			computeEnabled = !EMFHelper.isReadOnly(selection) && !isHandledByDirectEditor(selection);
		}

		return computeEnabled;
	}

	/**
	 * Check whether the editing of an element is handled by a direct editor. In this case, we do
	 * not want to open the rename pop-up.
	 *
	 * @param element
	 *            an element that should be edited.
	 * @return true, if handled by a direct editor
	 */
	protected boolean isHandledByDirectEditor(final EObject element) {
		return null != DirectEditorEditingSupport.getConfiguration(element);
	}
}
