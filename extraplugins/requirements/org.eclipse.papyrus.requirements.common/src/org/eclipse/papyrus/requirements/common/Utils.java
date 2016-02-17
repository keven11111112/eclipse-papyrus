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

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class Utils {
	/**
	 * @param elem UML model element
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
	 *            the profiles that will be verified
	 * @return the list of missing profiles
	 */
	public static ArrayList<String> getMissingRequiredProfileApplications(org.eclipse.uml2.uml.Package element,
			ArrayList<String> requiredProfiles) {
		ArrayList<String> missingProfiles = new ArrayList<String>();
		for (String profileQN : requiredProfiles) {
			if (element.getAppliedProfile(profileQN) == null) {
				missingProfiles.add(profileQN);
			}
		}
		return missingProfiles;
	}
}
