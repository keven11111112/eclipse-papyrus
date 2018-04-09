/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Pauline DEVILLE (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.profilemigration.internal.handler;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.toolsmiths.profilemigration.MigratorProfileApplication;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * Command to reapply the profile using the Profile migration tool
 */
public class ReapplyProfileCommand extends RecordingCommand {

	private Package umlPackage;
	private Profile profile;

	/**
	 * Constructor.
	 *
	 * @param umlPackage
	 *            the package owning the profile application
	 * @param profile
	 *            the profile to reapply
	 * @param domain
	 *            the current transactional domain
	 */
	public ReapplyProfileCommand(Package umlPackage, Profile profile, TransactionalEditingDomain domain) {
		super(domain);
		this.umlPackage = umlPackage;
		this.profile = profile;
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		MigratorProfileApplication migratorProfileApplication = new MigratorProfileApplication();
		migratorProfileApplication.reapplyProfile(umlPackage, profile);
	}

}
