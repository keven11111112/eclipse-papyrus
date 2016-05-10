/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import org.eclipse.emf.common.command.Command;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;

/**
 * A mix-in interface for {@linkplain EditPolicy edit-policies} that perform
 * automatic updates on the notation model in a similar fashion to the
 * {@link CanonicalEditPolicy} but that are not the Canonical Edit Policy.
 */
public interface AutomaticNotationEditPolicy extends EditPolicy {

	/**
	 * Executes a {@code command} in the context of the host edit-part, preferably
	 * with full undo/redo recording in the active read/write transaction, if there is
	 * one. Otherwise, just execute it as a stand-alone (or nested) unprotected write.
	 * So, in a sense, this is only potentially an "unsafe" execution.
	 * 
	 * @param command
	 *            a command to execute
	 */
	void execute(ICommand command);

	/**
	 * Executes a {@code command} in the context of the host edit-part, preferably
	 * with full undo/redo recording in the active read/write transaction, if there is
	 * one. Otherwise, just execute it as a stand-alone (or nested) unprotected write.
	 * So, in a sense, this is only potentially an "unsafe" execution.
	 * 
	 * @param command
	 *            a command to execute
	 */
	void execute(Command command);

	//
	// Nested types
	//

	/**
	 * A convenient superclass for automatic notation edit-policies that also provides
	 * static implementations of the interface methods for the convenience of their
	 * implementation in other kinds of edit-policies.
	 */
	abstract class Impl extends GraphicalEditPolicy implements AutomaticNotationEditPolicy {

		/**
		 * Executes a {@code command} in the context of an edit-part, preferably
		 * with full undo/redo recording in the active read/write transaction, if there is
		 * one. Otherwise, just execute it as a stand-alone (or nested) unprotected write.
		 * So, in a sense, this is only potentially an "unsafe" execution.
		 * 
		 * @param editPart
		 *            the contextual edit-part
		 * @param command
		 *            a command to execute
		 */
		public static void execute(EditPart editPart, ICommand command) {
			execute(editPart, GMFtoEMFCommandWrapper.wrap(command));
		}

		/**
		 * Executes a {@code command} in the context an edit-part, preferably
		 * with full undo/redo recording in the active read/write transaction, if there is
		 * one. Otherwise, just execute it as a stand-alone (or nested) unprotected write.
		 * So, in a sense, this is only potentially an "unsafe" execution.
		 * 
		 * @param editPart
		 *            the contextual edit-part
		 * @param command
		 *            a command to execute
		 */
		public static void execute(EditPart editPart, Command command) {
			IGraphicalEditPart context = TypeUtils.as(editPart, IGraphicalEditPart.class);

			if ((context != null) && !EditPartUtil.isWriteTransactionInProgress(context, true, false)) {
				// Have to go the unprotected route. Hopefully the context is an
				// edit-part refresh or something else that is not in a higher
				// recorded edit command scope that needs to be undoable
				try {
					GMFUnsafe.write(context.getEditingDomain(), command);
				} catch (Exception e) {
					// Failed to create the unprotected transaction or it rolled back
					Activator.log.error("Unprotected notation change failed.", e); //$NON-NLS-1$
				}
			} else {
				// There's a change recorder in progress or an unprotected write
				// that can't be overridden with a read/write transaction anyways,
				// or we're not an edit-part that provides editing domains,
				// so just roll with it
				if (command.canExecute()) {
					command.execute();
				}
			}
		}

		@Override
		public void execute(Command command) {
			execute(getHost(), command);
		}

		@Override
		public void execute(ICommand command) {
			execute(getHost(), command);
		}
	}
}
