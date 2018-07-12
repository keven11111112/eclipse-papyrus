/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	 Maged Elaasar - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.architecture.migration;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.nattable.common.reconciler.TableReconciler;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.representation.PapyrusTable;
import org.eclipse.papyrus.uml.architecture.UMLArchitectureContextIds;

/**
 * UML Table Reconciler from 1.0.0 to 1.3.0 that replaces the old prototype value for tables
 * with ones based on table kinds
 */
public class UMLTableReconciler_1_3_0 extends TableReconciler {

	private static final String VIEW_TABLE = "View Table";
	private static final String VIEW_TABLE_URI = "org.eclipse.papyrus.infra.nattable.views.config/resources/viewpageTable.configuration";
	private static final String GENERIC_TREE_TABLE = "Generic Tree Table";
	private static final String GENERIC_TREE_TABLE_URI = "org.eclipse.papyrus.uml.nattable/configs/genericTreeTable.configuration";
	private static final String CLASS_TREE_TABLE = "Class Tree Table";
	private static final String CLASS_TREE_TABLE_URI = "org.eclipse.papyrus.uml.nattable.clazz.config/configs/classTreeTable.configuration";
	private static final String GENERIC_TABLE = "Generic Table";
	private static final String GENERIC_TABLE_URI = "org.eclipse.papyrus.uml.nattable.generic.config/configs/genericTable.configuration";
	private static final String STEREO_DISPLAY_TREE_TABLE = "Stereotype Display Tree Table";
	private static final String STEREO_DISPLAY_TREE_TABLE_URI = "org.eclipse.papyrus.uml.nattable.stereotype.display/config/stereotypeDisplay.configuration";
	private static final String DEFAULT_URI = "org.eclipse.papyrus.infra.viewpoints.policy/builtin/default.configuration";
	
	@Override
	public ICommand getReconcileCommand(Table table) {
		RepresentationKind newTableKind = null;
		if (table.getPrototype() instanceof org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView) {
			org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView oldTableKind =
				(org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView) table.getPrototype();
			if (oldTableKind.eIsProxy()) {
				if (EcoreUtil.getURI(oldTableKind).toString().contains(VIEW_TABLE_URI)) {
					newTableKind = getTableKind(VIEW_TABLE, table);
				} else if (EcoreUtil.getURI(oldTableKind).toString().contains(GENERIC_TREE_TABLE_URI)) {
					newTableKind = getTableKind(GENERIC_TREE_TABLE, table);
				} else if (EcoreUtil.getURI(oldTableKind).toString().contains(CLASS_TREE_TABLE_URI)) {
					newTableKind = getTableKind(CLASS_TREE_TABLE, table);
				} else if (EcoreUtil.getURI(oldTableKind).toString().contains(GENERIC_TABLE_URI)) {
					newTableKind = getTableKind(GENERIC_TABLE, table);
				} else if (EcoreUtil.getURI(oldTableKind).toString().contains(STEREO_DISPLAY_TREE_TABLE_URI)) {
					newTableKind = getTableKind(STEREO_DISPLAY_TREE_TABLE, table);
				} else if (EcoreUtil.getURI(oldTableKind).toString().contains(DEFAULT_URI)) {
					newTableKind = getTableKind(GENERIC_TABLE, table);
				}
			}
		} else {
			newTableKind = getTableKind(GENERIC_TABLE, table);
		}
		if (newTableKind != null)
			return new ReplaceTablePrototypeCommand(table, newTableKind);
		return null;
	}

	/**
	 * Get a sync table that matches the given name and that supports the given table
	 */
	protected PapyrusTable getTableKind(String name, Table table) {
		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		MergedArchitectureDescriptionLanguage context = (MergedArchitectureDescriptionLanguage) manager.getArchitectureContextById(UMLArchitectureContextIds.UML);
		for(RepresentationKind pKind : context.getRepresentationKinds()) {
			if (pKind.getName().equals(name)) {
				PapyrusTable tKind = (PapyrusTable) pKind;
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
			table.setPrototype(null);
			table.setTableKindId(newKind.getId());
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
