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

import java.text.DecimalFormat;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.req.sysml.assistant.I_SysMLStereotype;
import org.eclipse.papyrus.req.sysml.preferences.Activator;
import org.eclipse.papyrus.req.sysml.preferences.PreferenceConstants;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Creates a requirement and adds a decomposition link from the selected
 * requirement to the new requirement. The names are based on the Papyrus Req
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
			concatenedString = concatenedString + "\n"
					+ selectedElement.getValue(stereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT);
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
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String prefix = store.getString(PreferenceConstants.REQUIREMENT_ID_PREFIX);// by
																					// default
																					// "REQ_"
		String separator = store.getString(PreferenceConstants.CHILD_REQUIREMENTS_SEPARATOR); // by
																								// default
																								// "_"

		String parentRequirementId = (String) parent.getValue(stereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT);
		String parentRequirementIdSuffix = parentRequirementId.replaceAll(prefix, "");
		int digit = store.getInt(PreferenceConstants.REQUIREMENT_ID_DIGIT);// by
																			// default
																			// 3
		int i = 0;
		DecimalFormat df = new DecimalFormat();
		df.setMinimumIntegerDigits(digit);
		String value = (df.format(i));
		boolean IDexist = true;
		while (IDexist) {
			IDexist = false;
			i++;
			value = (df.format(i));
			EList<Classifier> classifiers = parent.getNestedClassifiers();
			for (Iterator<Classifier> iterator = classifiers.iterator(); iterator.hasNext() && (!IDexist);) {
				Classifier classifier = (Classifier) iterator.next();
				// current element is a Req?
				Stereotype reqStereotype = classifier.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
				if (reqStereotype != null) {
					if (classifier.getValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT) != null) {
						String existedID = (String) classifier.getValue(reqStereotype,
								I_SysMLStereotype.REQUIREMENT_ID_ATT);
						String newID = prefix + parentRequirementIdSuffix + separator + value;
						// id already exists so increment suffix
						if (newID.equals(existedID)) {
							IDexist = true;
						}
					}
				}
			}

		}
		return prefix + parentRequirementIdSuffix + separator + value;
	}
}