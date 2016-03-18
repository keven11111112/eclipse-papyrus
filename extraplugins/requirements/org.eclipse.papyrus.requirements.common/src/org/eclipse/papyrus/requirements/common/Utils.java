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

import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

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

}
