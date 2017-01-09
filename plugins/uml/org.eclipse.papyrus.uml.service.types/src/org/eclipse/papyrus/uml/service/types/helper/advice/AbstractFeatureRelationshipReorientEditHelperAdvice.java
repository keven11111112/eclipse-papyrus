/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;
import org.eclipse.papyrus.infra.types.core.utils.ElementTypeRegistryUtils;

public abstract class AbstractFeatureRelationshipReorientEditHelperAdvice extends AbstractEditHelperAdvice {


	@Override
	protected ICommand getBeforeReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest request) {

		Object value = request.getParameters().get(DefaultSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE);

		if (value instanceof View) {

			try {
				IClientContext context = TypeContext.getContext();
				List<IElementType> elementTypes = ElementTypeRegistryUtils.getElementTypesBySemanticHint(((View) value).getType(), context.getId());

				for (IElementType iElementType : elementTypes) {
					List<ISpecializationType> subs = Arrays.asList(ElementTypeRegistry.getInstance().getSpecializationsOf(elementTypeIDToSpecialize()));
					if (subs.contains(iElementType)) {
						return getFeatureRelationshipReorientCommand(request);
					}
				}
			} catch (ServiceException e) {
				org.eclipse.papyrus.uml.service.types.Activator.log.error(e);
			}

		}

		return null;
	}

	/**
	 * @return
	 */
	protected abstract String elementTypeIDToSpecialize();

	protected abstract ICommand getFeatureRelationshipReorientCommand(ReorientReferenceRelationshipRequest request);


}
