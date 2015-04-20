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

package org.eclipse.papyrus.uml.diagram.profile.custom.canonical;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.ICreationTargetStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;

/**
 * Custom strategy for determination of the target edit part for canonical view creation commands in Profile Diagrams.
 */
public class ProfileDiagramCreationTargetStrategy implements ICreationTargetStrategy {

	public ProfileDiagramCreationTargetStrategy() {
		super();
	}

	public EditPart getTargetEditPart(EditPart host, EObject element) {
		EditPart result = null;

		if (host instanceof GraphicalEditPart) {
			GraphicalEditPart gep = (GraphicalEditPart) host;

			// Metaclass extensions and other connections must be dropped onto the containing diagram or package
			if ((element instanceof Element) && UMLUtil.isRelationship((Element) element)) {
				result = DiagramEditPartsUtil.getContainerEditPart(gep);
			}
		}

		return result;
	}

}
