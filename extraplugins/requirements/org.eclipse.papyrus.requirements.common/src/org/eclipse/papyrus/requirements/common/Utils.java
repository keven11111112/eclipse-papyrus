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
package org.eclipse.papyrus.requirements.common;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.requirements.preferences.PreferenceConstants;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.Class;

public class Utils {

	private Utils() {
	}

	/**
	 * @param elem
	 *            UML model element
	 * @return the highest level Package of the element
	 */
	public static Package getToPackage(Element elememt) {
		Package tmp = elememt.getNearestPackage();
		while (tmp.getOwner() != null && (tmp.getOwner() instanceof Package)) {
			tmp = (Package) tmp.getOwner();
		}
		return tmp;
	}

	/**
	 * Verifies if an element applies a list of profiles
	 * 
	 * @param element
	 *            the model element that can apply profiles
	 * @param requiredProfiles
	 *            the qualified names of the profiles that will be verified
	 * @return the list of missing profiles
	 */
	public static ArrayList<Profile> getMissingRequiredProfileApplications(org.eclipse.uml2.uml.Package element,
			ArrayList<Profile> requiredProfiles) {
		ArrayList<Profile> missingProfiles = new ArrayList<Profile>();
		for (Profile profile : requiredProfiles) {
			if (!element.isProfileApplied(profile)) {
				missingProfiles.add(profile);
			}
		}
		return missingProfiles;
	}

	/**
	 * Prints a list of missing profiles
	 * 
	 * @param missingProfiles
	 */
	public static void applyMissingProfiles(Package thePackage, ArrayList<Profile> missingProfiles) {
		for (Profile missingProfile : Utils
				.getMissingRequiredProfileApplications(thePackage, missingProfiles)) {
			thePackage.applyProfile(missingProfile);
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Applying missing profile",
					"The profile " + missingProfile.getQualifiedName() + " was applied to "
							+ thePackage.getName());
		}
	}

	/**
	 * Get a new id and name for a Papyrus SysML requirement based on the Papyrus for Requirements preferences page.
	 * Also, if the parent is a requirement, the name and id will depend on the parent requirement's id and name.
	 * 
	 * @param parent
	 *            the parent requirement
	 * @return the name for a potential requirement
	 */
	public static String getNewRequirementID(Element parent) {
		IPreferenceStore store = org.eclipse.papyrus.requirements.preferences.Activator.getDefault().getPreferenceStore();

		String prefix = store.getString(PreferenceConstants.REQUIREMENT_ID_PREFIX);// by
																					// default
																					// "R-"
		String separator = store.getString(PreferenceConstants.CHILD_REQUIREMENTS_SEPARATOR); // by
																								// default
																								// "-"
		boolean idUniqueInModel = store.getBoolean(PreferenceConstants.REQUIREMENT_ID_UNIQUE_IN_ENTIRE_MODEL); // by default true
		String parentRequirementId = "";
		String parentRequirementIdSuffix = "";
		if (parent instanceof Class) {
			if (null != UMLUtil.getStereotypeApplication((Class) parent, Requirement.class)) {
				// Parent is a requirement
				parentRequirementId = (String) UMLUtil.getTaggedValue((Class) parent, I_SysMLStereotype.REQUIREMENT_STEREOTYPE, I_SysMLStereotype.REQUIREMENT_ID_ATT);
				parentRequirementIdSuffix = parentRequirementId.replaceAll(prefix, "");
			}
		} else
			separator = "";// we are not dealing with a child requirement, so the separator must be empty.


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
