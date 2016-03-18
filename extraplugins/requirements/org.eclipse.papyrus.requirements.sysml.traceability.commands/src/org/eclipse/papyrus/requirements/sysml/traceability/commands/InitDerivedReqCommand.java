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
 * 		Patrick Tessier (patrick.tessier@cea.fr) CEA LIST - Initial API and implementation
 *      Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Improvements
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.requirements.common.Utils;
import org.eclipse.papyrus.requirements.sysml.assistant.commands.PapyrusReqSysMLRequirementCreateCommand;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * 
 * Creates a derived requirement from a set of requirements with a concatened
 * text
 *
 */
public class InitDerivedReqCommand extends RecordingCommand {
	protected ArrayList<Element> selectedElements;
	TransactionalEditingDomain domain;

	public InitDerivedReqCommand(TransactionalEditingDomain domain, ArrayList<Element> selectedElements) {
		super(domain, "InitDerivedReqCommand");
		this.selectedElements = selectedElements;
		this.domain = domain;
	}
	
	@Override
	protected void doExecute() {
		String concatenedString = "";
		org.eclipse.uml2.uml.Package owner = null;
		for (Element currentElement : selectedElements) {
			if (currentElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
				Stereotype stereotype = currentElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
				concatenedString += "\n"
						+ currentElement.getValue(stereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT);
				owner = currentElement.getNearestPackage();
			}
		}
		// open Tree selection dialog in order to choose the owner of the new
		// requirement
		TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
		dialog.setContentProvider(
				new UMLContentProvider(Utils.getToPackage(owner), UMLPackage.eINSTANCE.getPackage_NestedPackage()));
		dialog.setLabelProvider(new UMLLabelProvider());
		dialog.setMessage("Choose the owner of the new derived requirement");
		dialog.setTitle("Choose the owner of the new derived requirement");
		dialog.create();
		dialog.setDescription("Choose the owner of the new derived requirement");
		if (dialog.open() == org.eclipse.jface.window.Window.OK) {
			Object[] result = dialog.getResult();
			owner = ((org.eclipse.uml2.uml.Package) result[0]);
		} else
			return;

		final Profile sysmlReqProfile = UMLUtil.getProfile(RequirementsPackage.eINSTANCE, owner);

		ArrayList<Profile> requiredProfiles = new ArrayList<Profile>(Arrays.asList(sysmlReqProfile));
		ArrayList<Profile> missingProfiles = Utils.getMissingRequiredProfileApplications(owner, requiredProfiles);

		if (missingProfiles.size() > 0) {
			Utils.applyMissingProfiles(owner, missingProfiles);
		}
		
		String ID = PapyrusReqSysMLRequirementCreateCommand.getNewIDReq(owner);
		Class req = owner.createOwnedClass(ID, false);
		final Stereotype reqStereotype = req.getApplicableStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
		req.applyStereotype(reqStereotype);
		req.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT, concatenedString);
		req.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT, ID);

		for (Element currentElement : selectedElements) {
			if (currentElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
				DerivationReqCreateCommand derivationReqCreateCommand = new DerivationReqCreateCommand(domain, req,
						(NamedElement) currentElement);
				derivationReqCreateCommand.execute();
			}
		}
	}

}
