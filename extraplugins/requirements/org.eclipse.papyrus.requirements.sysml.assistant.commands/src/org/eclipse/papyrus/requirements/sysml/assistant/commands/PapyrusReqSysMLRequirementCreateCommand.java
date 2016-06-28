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
*     CEA LIST. - initial API and implementation
*     Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Modifications and improvements
*     
*******************************************************************************/
package org.eclipse.papyrus.requirements.sysml.assistant.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.requirements.common.Utils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Class;

/**
 * Creates a new SysML requirement based on the options chosen in the Papyrus for Requirements preferences page.
 *
 */
public class PapyrusReqSysMLRequirementCreateCommand extends RecordingCommand {
	protected Element selectedElement;

	public PapyrusReqSysMLRequirementCreateCommand(TransactionalEditingDomain domain, Element selectedElements) {
		super(domain, "PapyrusReqSysMLRequirementCreateCommand");
		this.selectedElement = selectedElements;
	}

	protected void createRequirement(Package owner, String id, String text) {
		Class requirement = owner.createOwnedClass(id, false);
		Stereotype reqStereotype = requirement.getApplicableStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
		requirement.applyStereotype(reqStereotype);
		requirement.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT, text);
		requirement.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT, id);
	}

	@Override
	protected void doExecute() {
		if (selectedElement.getNearestPackage() != null) {
			Package owner = selectedElement.getNearestPackage();
			String id = Utils.getNewRequirementID(owner);
			createRequirement(owner, id, "");
		}
	}
}