/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * 
 * 		Mauricio Alférez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.req.sysml.assistant.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.req.sysml.assistant.I_SysMLStereotype;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * This command is used to create a requirement and add a decompositon link from
 * the selected requirement to the new requirement. The names are based on the Papyrus Req preferences
 *
 */

public class InitDecomposeReqCommand extends RecordingCommand {
	protected Element selectedElement;
	TransactionalEditingDomain domain;

	public InitDecomposeReqCommand(TransactionalEditingDomain domain, Element selectedElement) {
		super(domain, "DecomposeReqCommand");
		this.selectedElement = selectedElement;
		this.domain = domain;
	}

	@Override
	protected void doExecute() {
		String concatenedString = "";
		org.eclipse.uml2.uml.Package owner = null;
		if (selectedElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
			Stereotype stereotype = selectedElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
			concatenedString = concatenedString + "\n"
					+ selectedElement.getValue(stereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT);
			owner = selectedElement.getNearestPackage();
			String ID = PapyrusReqSysMLRequirementCreateCommand.getNewIDReq(owner);
			Class req = owner.createOwnedClass(ID, false);
			Stereotype reqStereotype = req.getApplicableStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
			req.applyStereotype(reqStereotype);
			req.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT, concatenedString);
			req.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT, ID);
			DecomposeReqCommand decompositionReqCreateCommand = new DecomposeReqCommand(domain, req,
					(Class)selectedElement);
			decompositionReqCreateCommand.execute();
		}
	}

}