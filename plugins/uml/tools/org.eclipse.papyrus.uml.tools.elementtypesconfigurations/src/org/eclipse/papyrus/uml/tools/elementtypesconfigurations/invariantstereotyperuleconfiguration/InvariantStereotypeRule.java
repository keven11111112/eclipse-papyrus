/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration.AbstractInvariantRule;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

public class InvariantStereotypeRule extends AbstractInvariantRule<InvariantStereotypeRuleConfiguration> {

	public boolean approveRequest(IEditCommandRequest request) {
		if (request instanceof CreateElementRequest)
		{
			String stereotypeQualifiedName = invariantRuleConfiguration.getStereotypeQualifiedName();
			String requiredProfile = invariantRuleConfiguration.getRequiredProfile();

			if (requiredProfile == null) {
				// try to find the profile qualified name from the qualified stereotype name
				requiredProfile = stereotypeQualifiedName.substring(stereotypeQualifiedName.lastIndexOf(NamedElement.SEPARATOR));
			}
			// check container is a UML element
			EObject container = ((CreateElementRequest) request).getContainer();
			if (!(container instanceof Element)) {
				return false;
			}

			Package nearestPackage = ((Element) container).getNearestPackage();
			if (nearestPackage == null) {
				// impossible to check the applied profiles for the container
				return false;
			}

			Profile appliedProfile = nearestPackage.getAppliedProfile(requiredProfile, true);
			if (appliedProfile == null) {
				return false;
			}

			// check for stereotype application.
			// FIXME : Possible in the request system ?
		}

		return true;
	}

}
