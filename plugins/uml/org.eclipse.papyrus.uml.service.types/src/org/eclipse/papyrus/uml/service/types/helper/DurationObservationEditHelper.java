/*****************************************************************************
 * Copyright (c) 2018 CEA LIST, EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.CreateRelationshipCommandEx;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class DurationObservationEditHelper extends ElementEditHelper {

	/**
	 * <p>
	 * If the request is a {@link CreateRelationshipRequest}, configure it to indicate that
	 * the {@link DurationObservation} should be created as a {@link Package#getPackagedElements() packagedElement} in the nearest {@link Package}.
	 * </p>
	 */
	@Override
	public void configureRequest(IEditCommandRequest request) {
		super.configureRequest(request);

		if (request instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest req = (CreateRelationshipRequest) request;
			EObject container = req.getContainer();
			if (req.getSource() != null && req.getTarget() != null) {
				// Create in the package#packagedElement
				Package pkg = findPackage(req.getSource());
				if (pkg != null) {
					container = pkg;
				}
				req.setContainer(container);
			}

		}
		super.configureRequest(request);
	}

	private Package findPackage(EObject source) {
		if (source instanceof Element) {
			Element element = (Element) source;
			return element.getNearestPackage();
		}
		return null;
	}

	/**
	 * <p>
	 * A DurationObservation is an Observation between two named elements; so we support
	 * creation as a Link. In the sequence diagram, this is currently (2018/07) the only supported way.
	 * In the future, we may add support for DurationObservations targetting a single named element (The UML
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
