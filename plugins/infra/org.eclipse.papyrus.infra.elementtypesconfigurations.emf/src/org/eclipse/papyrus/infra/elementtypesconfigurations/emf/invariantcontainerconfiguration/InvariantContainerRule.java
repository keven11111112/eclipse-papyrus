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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerconfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration.AbstractInvariantRule;

public class InvariantContainerRule extends AbstractInvariantRule<InvariantContainerRuleConfiguration> {

	protected boolean isValid(IElementType typeToAdd, boolean baseIsValid) {
		boolean isValid = baseIsValid;
		for (HierarchyPermission permission : invariantRuleConfiguration.getPermissions()) {
			boolean isPermitted = permission.isIsPermitted();
			String childType = permission.getChildType();
			boolean isStrict = permission.isIsStrict();
			IElementType type = ElementTypeRegistry.getInstance().getType(childType);
			if (type != null) {
				if (isStrict) {
					if (typeToAdd.equals(type)) {
						if (isPermitted) {
							isValid = true;
						}
					} else if (!isPermitted) {
						isValid = false;
					}
				} else {
					// not strict. The super types of typeToCreate should contain the permission type if permitted, or not contain the permission type if not permitted
					List<IElementType> allTypes = Arrays.asList(typeToAdd.getAllSuperTypes());
					allTypes.add(typeToAdd);
					if (allTypes.contains(type)) {
						if (isPermitted) {
							isValid = true;
						}
					} else if (!isPermitted) {
						isValid = false;
					}
				}
			}
		}
		return isValid;
	}


	protected boolean canContain(SetRequest request) {

		List<Object> toEvaluate;
		// multivalue or simple value ?
		if (request.getValue() instanceof List<?>) {
			toEvaluate = (List<Object>) request.getValue();

		} else {
			toEvaluate = new ArrayList<Object>();
			toEvaluate.add(request.getValue());
		}

		for (Object value : toEvaluate) {
			if (value instanceof EObject) {
				IElementType type = ElementTypeRegistry.getInstance().getElementType((EObject) value, request.getClientContext());
				if (type != null) {
					if (!isValid(type, false)) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		if (request instanceof SetRequest) {
			SetRequest setRequest = ((SetRequest) request);
			EStructuralFeature structuralFeature = setRequest.getFeature();
			if (structuralFeature instanceof EReference) {
				EReference reference = ((EReference) structuralFeature);
				if (reference.isContainment() && setRequest.getValue() != null) {
					// check new value
					return canContain(setRequest);
				}
			}
		} else if (request instanceof CreateElementRequest) {
			CreateElementRequest createElementRequest = ((CreateElementRequest) request);
			IElementType typeToCreate = createElementRequest.getElementType();
			return isValid(typeToCreate, false);
		}
		return true;
	}

}
