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
package org.eclipse.papyrus.requirements.sysml.verfication.rules;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;

public class AllRequirementsMustBeSatisfied extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
		Class clazz = (Class) context.getTarget();
		EMFEventType eType = context.getEventType();
		// In the case of batch mode
		if (eType == EMFEventType.NULL) {
			if (clazz.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
				Stereotype reqStereotype = clazz.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
				Object listOfObjectsThatSatisfyRequirement = clazz.getValue(reqStereotype, "satisfiedBy");

				if (listOfObjectsThatSatisfyRequirement instanceof EList<?>) {
					@SuppressWarnings("unchecked")
					EList<EObject> list = (EList<EObject>) listOfObjectsThatSatisfyRequirement;
					if (list.isEmpty()) {
						return context.createFailureStatus(clazz.getName() + " must by satisfied.");
					}
				}
			}
		}
		return context.createSuccessStatus();
	}
}
