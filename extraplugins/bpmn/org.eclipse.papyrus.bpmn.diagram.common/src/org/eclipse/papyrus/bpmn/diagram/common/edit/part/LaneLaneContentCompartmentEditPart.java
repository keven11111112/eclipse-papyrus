/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy - arthur.daussy@atos.net - Bug 368932 - [ActivitiyDiagram] Prevent Compartment of Activity group to be selected
 *
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.diagram.common.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PasteEditPolicy;

/**
 * Set in order to have Generation Gap Pattern.
 *
 * @author arthur daussy
 *
 */
public class LaneLaneContentCompartmentEditPart extends ActivityPartitionActivityPartitionContentCompartmentEditPart{
	/**
	 * remove the bottom border, remove scrollbars
	 */
	@Override
	public IFigure createFigure() {
		IFigure figure = super.createFigure();
		figure.setBorder(null);
		return figure;
	}

	public LaneLaneContentCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	public String getCompartmentName() {
		return "LaneContentCompartment";
	}


}
