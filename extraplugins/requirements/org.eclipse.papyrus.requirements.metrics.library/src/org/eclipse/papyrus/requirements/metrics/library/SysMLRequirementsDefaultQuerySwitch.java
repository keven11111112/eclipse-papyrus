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
package org.eclipse.papyrus.requirements.metrics.library;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IDefaultQuerySwitch;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class SysMLRequirementsDefaultQuerySwitch implements IDefaultQuerySwitch{

	@Override
	public Object calculateValue(String operationName, Element element) {
		switch (operationName) {
		case I_Requirements_Operations.N_REQS:
			return countRequirementsInAllOwnedElements(element);

		case I_Requirements_Operations.N_UNSAT_REQS:
			return countUnsatisfiedRequirementsInAllOwnedElements(element);

		case I_Requirements_Operations.N_SAT_REQS:
			return countSatisfiedRequirementsInAllOwnedElements(element);
		}
		return null;
	}

	public static Integer countSatisfiedRequirementsInAllOwnedElements(Element element) {
		return countRequirementsInAllOwnedElements(element) - countUnsatisfiedRequirementsInAllOwnedElements(element);
	}

	public static Integer countRequirementsInAllOwnedElements(Element element) {
		int numberOfRequirements = 0;
		for (Element e : element.allOwnedElements()) {
			if (e.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null)
				numberOfRequirements++;
		}
		return numberOfRequirements;
	}

	public static Integer countUnsatisfiedRequirementsInAllOwnedElements(Element element) {
		int numberOfUnsatisfiedRequirements = 0;
		for (Element e : element.allOwnedElements()) {
			if (e.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
				Stereotype reqStereotype = e.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
				Object listOfObjectsThatSatisfyRequirement = e.getValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_SATISFIEDBY_ATT);
				if (listOfObjectsThatSatisfyRequirement instanceof EList<?>) {
					@SuppressWarnings("unchecked")
					EList<EObject> list = (EList<EObject>) listOfObjectsThatSatisfyRequirement;
					if (list.isEmpty()) {
						numberOfUnsatisfiedRequirements++;
					}
				}
			}
		}
		return numberOfUnsatisfiedRequirements;
	}
}
