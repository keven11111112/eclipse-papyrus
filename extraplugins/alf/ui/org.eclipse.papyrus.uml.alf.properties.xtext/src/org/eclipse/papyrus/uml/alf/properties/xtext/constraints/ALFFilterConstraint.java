/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.properties.xtext.constraints;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Extension;

/**
 * This class implements the opening constraints for the ALF editor
 */
public class ALFFilterConstraint {

	private ALFFilterConstraint() {
	}

	/**
	 * Checks if an association can edited using ALF
	 * 
	 * @param association
	 *            the association evaluated against the constraints
	 * 
	 * @return conforms
	 *         true if the association respects the constraints
	 */
	public static boolean conforms(Association association) {
		boolean conforms = true;
		/* The editor can only be opened for associations owning all of their ends */
		if (association != null && isStrictAssociation(association)) {
			conforms = association.getOwnedEnds().size() == association.getMemberEnds().size();
		}
		return conforms;
	}

	/**
	 * Checks if a given association is strictly an Association and not an instance of one of the sub-classes
	 * 
	 * @param association
	 *            the association for which we verifies that it is not a sub-class instance
	 * 
	 * @return true if the association is only an instance of Association, false otherwise
	 */
	private static boolean isStrictAssociation(Association association) {
		return !(association instanceof AssociationClass) &&
				!(association instanceof CommunicationPath) &&
				!(association instanceof Extension);
	}

}
