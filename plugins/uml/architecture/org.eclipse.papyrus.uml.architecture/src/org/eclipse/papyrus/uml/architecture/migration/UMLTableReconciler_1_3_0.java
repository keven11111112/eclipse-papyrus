/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	 Maged Elaasar - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.architecture.migration;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.nattable.representation.PapyrusSyncTable;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.nattable.common.reconciler.TableReconciler;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.uml.architecture.UMLArchitectureContextIds;

/**
 * UML Table Reconciler from 1.0.0 to 1.3.0 that replaces the old prototype value for tables
 * with ones based on table kinds
 */
public class UMLTableReconciler_1_3_0 extends TableReconciler {

	private static final String VIEW_TABLE = "View Table";
	private static final String GENERIC_TREE_TABLE = "Generic Tree Table";
	private static final String CLASS_TREE_TABLE = "ClassTreeTable";
	private static final String GENERIC_TABLE = "Generic Table";
	private static final String STEREO_DISPLAY_TREE_TABLE = "StereotypeDisplayTreeTable";

	@Override
	public ICommand getReconcileCommand(Table table) {
		if (table.getPrototype() instanceof org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView) {
			org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView oldTableKind =
				(org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView) table.getPrototype();
			
			RepresentationKind newTableKind = null;
			if (oldTableKind != null) {
				if (VIEW_TABLE.equals(oldTableKind.getName())) {
					newTableKind = getSyncTableKind(oldTableKind.getName(), table);
				} else if (GENERIC_TREE_TABLE.equals(oldTableKind.getName())) {
					newTableKind = getSyncTableKind(oldTableKind.getName(), table);
				} else if (CLASS_TREE_TABLE.equals(oldTableKind.getName())) {
					newTableKind = getSyncTableKind("Class Tree Table", table);
				} else if (GENERIC_TABLE.equals(oldTableKind.getName())) {
					newTableKind = getSyncTableKind(oldTableKind.getName(), table);
				} else if (STEREO_DISPLAY_TREE_TABLE.equals(oldTableKind.getName())) {
					newTableKind = getSyncTableKind("Stereotype Display Tree Table", table);
				} else if (oldTableKind.getName() == null) {
					newTableKind = getSyncTableKind(GENERIC_TABLE, table);
				}
			};
			
			if (newTableKind != null)
				return new ReplaceTablePrototypeCommand(table, newTableKind);
		}
		return null;
	}

	/**
	 * Get a sync table that matches the given name and that supports the given table
	 */
	protected PapyrusSyncTable getSyncTableKind(String name, Table table) {
		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		MergedArchitectureDescriptionLanguage context = (MergedArchitectureDescriptionLanguage) manager.getArchitectureContextById(UMLArchitectureContextIds.UML);
		for(RepresentationKind pKind : context.getRepresentationKinds()) {
			if (pKind.getName().equals(name)) {
				PapyrusSyncTable tKind = (PapyrusSyncTable) pKind;
				if (tKind.getModelRules().get(0).getElement().isInstance(table.getContext())) {
					return tKind;
				}
			}
		}
		return null;
	}

	/**
	 * A command to replace the old table prototype with the new representation kinds 
	 */
	protected class ReplaceTablePrototypeCommand extends AbstractCommand {

		private Table table;
		private RepresentationKind newKind;

		public ReplaceTablePrototypeCommand(Table table, RepresentationKind newKind) {
			super("Replace the papyrus view style from 1.0.0 to 1.3.0");
			this.table = table;
			this.newKind = newKind;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			table.setPrototype(newKind);
			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canUndo() {
			return false;
		}

		@Override
		public boolean canRedo() {
			return false;
		}

		@Override
		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canRedo false"); //$NON-NLS-1$
		}

		@Override
		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canUndo false"); //$NON-NLS-1$
		}
	}
}
