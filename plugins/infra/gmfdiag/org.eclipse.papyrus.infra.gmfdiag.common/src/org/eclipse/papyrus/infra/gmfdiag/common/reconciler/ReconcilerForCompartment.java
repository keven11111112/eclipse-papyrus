/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.reconciler;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Class Diagram Reconciler from 1.1.0 to 1.2.0. Migrates all compartments Views from DecorationNode to BasicCompartment.
 */
abstract public class ReconcilerForCompartment extends DiagramReconciler {


	/**
	 * Gets the reconcile command.
	 *
	 * @param diagram
	 *            the diagram
	 * @return the reconcile command
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler#getReconcileCommand(org.eclipse.gmf.runtime.notation.Diagram)
	 */
	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		return new UpdateCompartmentsCommand(diagram);
	}

	/** The copier util to copy a decorationNode as a compartment. */
	Copier copierAsCompartment = new Copier() {

		private static final long serialVersionUID = 1L;

		protected EObject createCopy(EObject eObject) {
			// Copier the decoration node as a compartment
			if (eObject instanceof DecorationNode && isCompartment((View) eObject)) {
				return EcoreUtil.create(NotationPackage.Literals.BASIC_COMPARTMENT);
			}

			EClass eClass = getTarget(eObject);
			return eClass == null ? null : EcoreUtil.create(eClass);
		}
	};


	/**
	 * Gets the compartments visual id which needs to migrate from DecorationNode to BasicCompartment.
	 *
	 * @return the compartments visual id
	 */
	abstract public List<String> getCompartmentsVisualID();


	/**
	 * The Class UpdateCompartmentsCommand.
	 */
	protected class UpdateCompartmentsCommand extends AbstractCommand {

		/** The diagram. */
		protected final Diagram diagram;

		/**
		 * Instantiates a new update compartments command.
		 *
		 * @param diagram
		 *            the diagram
		 */
		public UpdateCompartmentsCommand(Diagram diagram) {
			super("Update Compartment notation element");
			this.diagram = diagram;
		}

		/**
		 * Do execute with result.
		 *
		 * @param progressMonitor
		 *            the progress monitor
		 * @param info
		 *            the info
		 * @return the command result
		 * @throws ExecutionException
		 *             the execution exception
		 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

			TreeIterator<EObject> allContentIterator = diagram.eAllContents();

			while (allContentIterator.hasNext()) {
				EObject eObject = allContentIterator.next();

				if (eObject instanceof DecorationNode && isCompartment((View) eObject)) {
					BasicCompartment compartment = (BasicCompartment) copierAsCompartment.copy(eObject);
					EcoreUtil.replace(eObject, compartment);
				}
			}
			return CommandResult.newOKCommandResult();
		}

		/**
		 * Can undo.
		 *
		 * @return true, if successful
		 * @see org.eclipse.core.commands.operations.AbstractOperation#canUndo()
		 */
		@Override
		public boolean canUndo() {
			return false;
		}

		/**
		 * Can redo.
		 *
		 * @return true, if successful
		 * @see org.eclipse.core.commands.operations.AbstractOperation#canRedo()
		 */
		@Override
		public boolean canRedo() {
			return false;
		}

		/**
		 * Do redo with result.
		 *
		 * @param progressMonitor
		 *            the progress monitor
		 * @param info
		 *            the info
		 * @return the command result
		 * @throws ExecutionException
		 *             the execution exception
		 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canRedo false");
		}

		/**
		 * Do undo with result.
		 *
		 * @param progressMonitor
		 *            the progress monitor
		 * @param info
		 *            the info
		 * @return the command result
		 * @throws ExecutionException
		 *             the execution exception
		 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canUndo false");
		}
	}


	/**
	 * Checks if i's a compartment. to check that it verify on the list of compartment return by {@link getCompartmentsVisualID()}.
	 *
	 * @param view
	 *            the view
	 * @return true, if is compartment
	 */
	protected boolean isCompartment(View view) {
		boolean value = false;
		for (String compartment : getCompartmentsVisualID()) {
			value = compartment.equals(((View) view).getType());
			if (value == true)
				break;
		}
		return value;
	}

}
