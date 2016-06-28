/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.requirements.sysml.assistant.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.requirements.common.Utils;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Package;
/**
 * Creates a requirement and adds a decomposition link from the selected
 * requirement to the new requirement. The names are based on the Papyrus for Requirements
 * preferences.
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
		Package owner = null;
		if (selectedElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
			owner = selectedElement.getNearestPackage();
			String id = Utils.getNewRequirementID((Class) selectedElement);
			Class requirement = owner.createOwnedClass(id, false);
			Stereotype reqStereotype = requirement.getApplicableStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
			requirement.applyStereotype(reqStereotype);
			requirement.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT, "");
			requirement.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT, id);
			DecomposeReqCommand decompositionReqCreateCommand = new DecomposeReqCommand(domain, requirement,
					(Class) selectedElement);
			decompositionReqCreateCommand.execute();
		}
	}

}