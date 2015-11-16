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
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.req.domainModel2Profile.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.req.domainModel2Profile.generator.ProfileGenerator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * 
 * Generates an UML profile based on a UML domain model
 *
 */

public class CreateProfileFromDomainModelCommand extends RecordingCommand {
	protected Element selectedElement;

	public CreateProfileFromDomainModelCommand(TransactionalEditingDomain domain, Element selectedElement) {
		super(domain, "CreateProfileFromDomainModelCommand");
		this.selectedElement = selectedElement;
	}

	protected void createProfile(org.eclipse.uml2.uml.Package selectedPackage) {
		ProfileGenerator profileGenerator = new ProfileGenerator(selectedPackage);
		profileGenerator.generate();
	}

	@Override
	protected void doExecute() {
		if (selectedElement instanceof Package) {
			createProfile((Package) selectedElement);
		}
	}
}