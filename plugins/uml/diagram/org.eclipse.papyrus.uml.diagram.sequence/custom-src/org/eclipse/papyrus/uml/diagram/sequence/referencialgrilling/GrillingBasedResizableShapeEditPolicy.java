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
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.PapyrusResizableShapeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;

/**
 * @author Patrick Tessier
 *
 */
public class GrillingBasedResizableShapeEditPolicy extends PapyrusResizableShapeEditPolicy implements IGrillingEditpolicy{

	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		 super.showChangeBoundsFeedback(request);
//		IFigure feedback = getDragSourceFeedbackFigure();
//		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
//		getHostFigure().translateToAbsolute(rect);
//		Point left = rect.getLeft();
//		Point right = rect.getRight();
//		rect.translate(request.getMoveDelta());
//		rect.resize(request.getSizeDelta());
//		IFigure f = getHostFigure();
//		View row=null;
//		DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
//		try{
//			GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
//			if (grilling!=null){
//				row=grilling.getRowTolisten(((GraphicalEditPart)getHost()).resolveSemanticElement(), (Node)((GraphicalEditPart)getHost()).getNotationView());
//			}
//		}catch (NoGrillElementFound e) {
//			UMLDiagramEditorPlugin.log.error(e);
//		}
//		Location boundsRow=(Location)	((Node)row).getLayoutConstraint();
//		Point poisition = new Point(0,boundsRow.getY());
//		// IMapMode mmode = MapModeUtil.getMapMode(f);
//		// min.height = mmode.LPtoDP(min.height);
//		// min.width = mmode.LPtoDP(min.width);
//		// max.height = mmode.LPtoDP(max.height);
//		// max.width = mmode.LPtoDP(max.width);
//		getHostFigure().translateToAbsolute(poisition);
//		// In manual mode, there is no minimal width, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=383723
//		rect.y=poisition.y;
//		feedback.translateToRelative(rect);
//		feedback.setBounds(rect);
	}
}
