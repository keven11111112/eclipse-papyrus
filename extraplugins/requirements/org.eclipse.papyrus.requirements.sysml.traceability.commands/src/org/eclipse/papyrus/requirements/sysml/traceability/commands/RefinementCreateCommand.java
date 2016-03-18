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
 * 		Patrick Tessier (patrick.tessier@cea.fr) CEA LIST - Initial API and implementation
 *      Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Improvements
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.requirements.common.Utils;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.util.UMLUtil;



/**
 * Used to create a link "Refine" between requirement and a Model Element
 *
 */
public class RefinementCreateCommand extends RecordingCommand {
	private NamedElement source;
	private NamedElement target;

	/**
	 * Makes an abstraction
	 * 
	 * @param domain
	 *            the domain to execute a transaction
	 * @param source
	 *            the source of the abstraction (the more concrete element) - client. For example, a Use Case
	 * @param target
	 *            the target of the abstraction (the more abstract element) - supplier. For example, a Requirement
	 */
	public RefinementCreateCommand(TransactionalEditingDomain domain, NamedElement source, NamedElement target) {
		super(domain, "Create an Abstraction");
		this.source = source;
		this.target = target;
	}

	@Override
	protected void doExecute() {
		Abstraction theAbstraction = UMLFactory.eINSTANCE.createAbstraction();
		source.getNearestPackage().getPackagedElements().add(theAbstraction);
		theAbstraction.getSuppliers().add(target);
		theAbstraction.getClients().add(source);
		theAbstraction.setName("Refines_" + this.target.getName());

		Profile standardProfile = UMLUtil.getProfile(StandardPackage.eINSTANCE, source.getNearestPackage());

		ArrayList<Profile> requiredProfiles = new ArrayList<Profile>(Arrays.asList(standardProfile));

		ArrayList<Profile> missingProfiles = Utils.getMissingRequiredProfileApplications(source.getNearestPackage(), requiredProfiles);

		if (missingProfiles.size() > 0) {
			Utils.applyMissingProfiles(source.getNearestPackage(), missingProfiles);
		}
		Stereotype refineStereotype = theAbstraction.getApplicableStereotype("StandardProfile::Refine");
		theAbstraction.applyStereotype(refineStereotype);
	}
}
