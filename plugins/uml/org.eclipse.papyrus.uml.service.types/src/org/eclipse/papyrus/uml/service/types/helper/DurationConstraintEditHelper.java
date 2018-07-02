/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.CreateRelationshipCommandEx;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class DurationConstraintEditHelper extends ConstraintEditHelper {

	@Override
	protected ValueSpecification createSpecification() {
		return UMLFactory.eINSTANCE.createDurationInterval();
	}

	/**
	 * <p>
	 * If the request is a {@link CreateRelationshipRequest}, configure it to indicate that
	 * the {@link DurationConstraint} should be created as an {@link Interaction#getOwnedRules() ownedRule} in the {@link Interaction}.
	 * </p>
	 */
	@Override
	public void configureRequest(IEditCommandRequest request) {
		super.configureRequest(request);

		if (request instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest req = (CreateRelationshipRequest) request;
			EObject container = req.getContainer();
			if (req.getSource() != null && req.getTarget() != null) {
				// Create in the interaction#ownedRules
				Interaction interaction = findInteraction(req.getSource());
				if (interaction != null) {
					container = interaction;
				}
				req.setContainer(container);
			}

		}
		super.configureRequest(request);
	}

	private Interaction findInteraction(EObject source) {
		if (source instanceof Element) {
			Element element = (Element) source;
			while (element != null) {
				if (element instanceof Interaction) {
					return (Interaction) element;
				}
				element = element.getOwner();
			}
		}
		return null;
	}

	/**
	 * <p>
	 * Unlike other constraints, a DurationConstraint is a Constraint between two elements; so we support
	 * creation as a Link. In the sequence diagram, this is currently (2018/07) the only supported way.
	 * In the future, we may add support for DurationConstraints targetting a single element (The UML
	 * spec supports that; the multiplicity is [1..2]).
	 * </p>
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		EObject source = req.getSource();
        EObject target = req.getTarget();

        boolean noSourceOrTarget = (source == null || target == null);
        boolean noSourceAndTarget = (source == null && target == null);

        if (noSourceOrTarget && !noSourceAndTarget) {
            // The request isn't complete yet. Return the identity command so
            // that the create relationship gesture is enabled.
            return IdentityCommand.INSTANCE;
        }

		return new CreateRelationshipCommandEx(req);
	}

}
