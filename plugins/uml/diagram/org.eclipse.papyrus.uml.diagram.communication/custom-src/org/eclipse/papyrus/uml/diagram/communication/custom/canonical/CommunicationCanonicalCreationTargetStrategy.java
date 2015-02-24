/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.communication.custom.canonical;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.ICreationTargetStrategy;
import org.eclipse.uml2.uml.Message;

/**
 * Target edit part strategy for canonical view creation in communication diagrams.
 */
public class CommunicationCanonicalCreationTargetStrategy implements ICreationTargetStrategy {

	public CommunicationCanonicalCreationTargetStrategy() {
		super();
	}

	public EditPart getTargetEditPart(EditPart host, EObject element) {
		EditPart result = null;

		if (element instanceof Message) {
			// Get the nearest containing shape compartment. It can create the edge view
			for (EditPart candidate = host; (result == null) && (candidate != null); candidate = candidate.getParent()) {
				if (candidate instanceof IResizableCompartmentEditPart) {
					result = candidate;
				}
			}
		}

		return result;
	}
}
