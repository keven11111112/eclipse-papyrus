/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.modelexplorer.directeditor;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * Specific Parser for the Table.
 */
public class TableDirectEditorParser implements IParser {

	/**
	 * Name of the current Table.
	 */
	private String textToEdit;

	/**
	 * Constructor.
	 *
	 */
	public TableDirectEditorParser(final String textToEdit) {
		this.textToEdit = textToEdit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEditString(final IAdaptable element, final int flags) {
		return this.textToEdit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICommand getParseCommand(final IAdaptable element, final String newString, final int flags) {
		CompositeCommand result = new CompositeCommand("Rename"); //$NON-NLS-1$

		EObject eObjectElement = element.getAdapter(EObject.class);

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(eObjectElement);

		AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "RenameCommand", null) { //$NON-NLS-1$

			/**
			 *
			 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
			 *
			 * @param monitor
			 * @param info
			 * @return
			 * @throws ExecutionException
			 */
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				if (eObjectElement instanceof Table) {
					if (null != newString && !newString.isEmpty()) {
						((Table) eObjectElement).setName(newString);
						return CommandResult.newOKCommandResult();
					}
				}

				return CommandResult.newCancelledCommandResult();
			}
		};

		result.add(cmd);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(final IAdaptable element, final int flags) {
		return this.textToEdit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAffectingEvent(final Object event, final int flags) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
		// Not used
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IParserEditStatus isValidEditString(final IAdaptable element, final String editString) {
		// Not used
		return null;
	}
}
