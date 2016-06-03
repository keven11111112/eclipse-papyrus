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

import java.text.DecimalFormat;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.requirements.preferences.PreferenceConstants;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

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
		String concatenedString = "";
		org.eclipse.uml2.uml.Package owner = null;
		if (selectedElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
			Stereotype stereotype = selectedElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
			concatenedString = concatenedString + selectedElement.getValue(stereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT);
			owner = selectedElement.getNearestPackage();
			String id = getNewIDReq((Class) selectedElement, stereotype);
			Class req = owner.createOwnedClass(id, false);
			Stereotype reqStereotype = req.getApplicableStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
			req.applyStereotype(reqStereotype);
			req.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT, concatenedString);
			req.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT, id);
			DecomposeReqCommand decompositionReqCreateCommand = new DecomposeReqCommand(domain, req,
					(Class) selectedElement);
			decompositionReqCreateCommand.execute();
		}
	}

	/**
	 * get a new name of a Papyrus SysML child requirement based on the Papyrus
	 * req preferences and the Id of the parent Requirement
	 * 
	 * @param parent
	 *            the parent requirement
	 * @return the name for a potential requirement
	 */
	public static String getNewIDReq(org.eclipse.uml2.uml.Class parent, Stereotype stereotype) {
		IPreferenceStore store = org.eclipse.papyrus.requirements.preferences.Activator.getDefault().getPreferenceStore();

		String prefix = store.getString(PreferenceConstants.REQUIREMENT_ID_PREFIX);// by
																					// default
																					// "R-"
		String separator = store.getString(PreferenceConstants.CHILD_REQUIREMENTS_SEPARATOR); // by
																								// default
																								// "-"
		boolean idUniqueInModel = store.getBoolean(PreferenceConstants.REQUIREMENT_ID_UNIQUE_IN_ENTIRE_MODEL); // by default true

		String parentRequirementId = (String) parent.getValue(stereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT);

		String parentRequirementIdSuffix = parentRequirementId.replaceAll(prefix, "");
		int digit = store.getInt(PreferenceConstants.REQUIREMENT_ID_DIGIT);// by
																			// default 2
		int i = 0;
		DecimalFormat df = new DecimalFormat();
		df.setMinimumIntegerDigits(digit);
		String value = (df.format(i));
		boolean IDexist = true;
		while (IDexist) {
			IDexist = false;
			i++;
			value = (df.format(i));
			EList<Element> elements = null;
			if (idUniqueInModel) {
				elements = parent.getModel().allOwnedElements();
			} else {
				elements = parent.allOwnedElements();
			}
			for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext() && (!IDexist);) {
				Element element = (Element) iterator.next();
				Object reqIdObject = UMLUtil.getTaggedValue(element, I_SysMLStereotype.REQUIREMENT_STEREOTYPE, I_SysMLStereotype.REQUIREMENT_ID_ATT);
				if (reqIdObject != null) {
					String existedID = (String) reqIdObject;
					String newID = prefix + parentRequirementIdSuffix + separator + value;
					// id already exists so increment suffix
					if (newID.equals(existedID)) {
						IDexist = true;
					}
				}
			}
		}
		return prefix + parentRequirementIdSuffix + separator + value;
	}
}