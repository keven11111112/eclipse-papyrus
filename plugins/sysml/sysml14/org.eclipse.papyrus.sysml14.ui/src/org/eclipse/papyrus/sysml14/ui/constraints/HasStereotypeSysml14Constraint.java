/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.ui.constraints;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.sysml14.util.SysmlResource;
import org.eclipse.papyrus.uml.properties.constraints.HasStereotypeConstraint;
import org.eclipse.uml2.uml.Profile;

/**
 * A constraint to test if the given object is a UML Element and
 * has the given Stereotype and Sysml1.4 profile applied
 *
 * @author Benoit Maggi
 */
public class HasStereotypeSysml14Constraint extends HasStereotypeConstraint {

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#match(java.lang.Object)
	 * Check if the containing package has profilUri applied.
	 * @param selection
	 * @return
	 */
	@Override
	public boolean match(Object selection) {
		if (super.match(selection)){
			EList<Profile> allAppliedProfiles = umlElement.getNearestPackage().getAllAppliedProfiles();
			for (Profile profile : allAppliedProfiles) {
				String uri = profile.getURI();
				if (SysmlResource.PROFILE_URI.equals(uri)){
					return true;
				}
			}
		}
		return false; // always called even when not defined 
	}

	

	/**
	 * @see java.lang.Object#toString()
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return String.format("HasStereotypeSysml14 %s (%s)", stereotypeName, getDisplayUnit().getElementMultiplicity() == 1 ? "Single" : "Multiple"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#equivalent(org.eclipse.papyrus.infra.constraints.constraints.Constraint)
	 * 
	 * @param constraint
	 * @return
	 */
	@Override
	protected boolean equivalent(Constraint constraint) { 
		if (super.equivalent(constraint)) {
			return (constraint instanceof HasStereotypeSysml14Constraint);
		}
		return false;
	}
}
