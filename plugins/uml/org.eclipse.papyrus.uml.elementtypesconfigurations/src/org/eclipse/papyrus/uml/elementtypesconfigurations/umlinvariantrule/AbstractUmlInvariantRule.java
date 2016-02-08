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
package org.eclipse.papyrus.uml.elementtypesconfigurations.umlinvariantrule;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfiguredHintedSpecializationElementType;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration.AbstractInvariantRule;
import org.eclipse.papyrus.uml.elementtypesconfigurations.requests.ApplyProfileRequest;
import org.eclipse.papyrus.uml.elementtypesconfigurations.requests.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.elementtypesconfigurations.requests.SetStereotypeValueRequest;
import org.eclipse.papyrus.uml.elementtypesconfigurations.requests.UnapplyProfileRequest;
import org.eclipse.papyrus.uml.elementtypesconfigurations.requests.UnapplyStereotypeRequest;

public abstract class AbstractUmlInvariantRule<T extends InvariantRuleConfiguration> extends AbstractInvariantRule<T> {
	protected T invariantRuleConfiguration;

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration.AbstractInvariantRule#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {

		List<?> elementsToEdit = request.getElementsToEdit();
		for (Object elementToEdit : elementsToEdit) {
			if (elementToEdit instanceof EObject) {
				IElementType[] types = ElementTypeRegistry.getInstance().getAllTypesMatching((EObject) elementToEdit, request.getClientContext());

				for (IElementType type : types) {
					if (type instanceof ConfiguredHintedSpecializationElementType) {
						ConfiguredHintedSpecializationElementType configuredHintedSpecializationElementType = (ConfiguredHintedSpecializationElementType) type;
						if (request instanceof ApplyStereotypeRequest) {
							if (!approveApplyStereotypeRequest(configuredHintedSpecializationElementType, (ApplyStereotypeRequest) request)) {
								return false;
							}
						} else if (request instanceof UnapplyStereotypeRequest) {
							if (!approveUnapplyStereotypeRequest(configuredHintedSpecializationElementType, (UnapplyStereotypeRequest) request)) {
								return false;
							}
						} else if (request instanceof ApplyProfileRequest) {
							if (!approveApplyProfileRequest(configuredHintedSpecializationElementType, (ApplyProfileRequest) request)) {
								return false;
							}
						} else if (request instanceof UnapplyProfileRequest) {
							if (!approveUnapplyProfileRequest(configuredHintedSpecializationElementType, (UnapplyProfileRequest) request)) {
								return false;
							}
						} else if (request instanceof SetStereotypeValueRequest) {
							if (!approveSetStereotypeValueRequest(configuredHintedSpecializationElementType, (SetStereotypeValueRequest) request)) {
								return false;
							}
						}
					}
				}
			}
		}

		return super.approveRequest(request);
	}

	abstract protected boolean approveApplyStereotypeRequest(ConfiguredHintedSpecializationElementType type, ApplyStereotypeRequest request);

	abstract protected boolean approveUnapplyStereotypeRequest(ConfiguredHintedSpecializationElementType type, UnapplyStereotypeRequest request);

	abstract protected boolean approveApplyProfileRequest(ConfiguredHintedSpecializationElementType type, ApplyProfileRequest request);

	abstract protected boolean approveUnapplyProfileRequest(ConfiguredHintedSpecializationElementType type, UnapplyProfileRequest request);

	abstract protected boolean approveSetStereotypeValueRequest(ConfiguredHintedSpecializationElementType type, SetStereotypeValueRequest request);

	@Override
	public void init(T invariantRuleConfiguration) {
		this.invariantRuleConfiguration = invariantRuleConfiguration;
	}
}
