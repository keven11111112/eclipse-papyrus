/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *	Thomas Daniellou (CEA LIST) - Refactoring and cleanup
 *****************************************************************************/
package org.eclipse.papyrus.adltool.command;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.adltool.designer.ArchitectureSnapshotDesigner;
import org.eclipse.papyrus.adltool.designer.ReverseSettings;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.uml2.uml.Package;

/**
 * This purpose of this command is to import all the architecture from the current workspace
 */
public class CompleteArchitectureSnapshotCommand extends RecordingCommand {

	private Package model;

	private Set<ReversibleProject> selectedProjects;

	private ReverseSettings settings;

	/**
	 * Constructor.
	 *
	 * @param domain
	 *            the domain mandatory to launch the command
	 * @param model
	 *            the root package in which the sub-packages will be created
	 * @param selectedProjects
	 *            the list of bundle for the reverse engineering
	 * @param depth
	 * 			  the depth of the reverse
	 */
	public CompleteArchitectureSnapshotCommand(TransactionalEditingDomain domain, Package model, Set<ReversibleProject> selectedProjects, ReverseSettings settings) {
		super(domain, "Import Bundles", "Model architecture from current workspace");

		this.model = model;
		this.settings = settings;
		this.selectedProjects = selectedProjects;
	}

	public CompleteArchitectureSnapshotCommand(TransactionalEditingDomain domain, Package model, ReversibleProject reversibleProject, ReverseSettings settings) {
		super(domain, "Import Bundles", "Model architecture from current workspace");

		this.model = model;
		this.settings = settings;

		selectedProjects = new HashSet<>();
		selectedProjects.add(reversibleProject);
	}

	@Override
	protected void doExecute() {
		ArchitectureSnapshotDesigner snapshotDesigner = new ArchitectureSnapshotDesigner(model, selectedProjects, settings);
		snapshotDesigner.runImportBundles();
	}
}
