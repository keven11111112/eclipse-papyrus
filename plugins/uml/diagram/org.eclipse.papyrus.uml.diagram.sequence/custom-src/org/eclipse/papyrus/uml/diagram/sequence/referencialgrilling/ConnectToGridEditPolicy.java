/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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



import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.LogOptions;

/**
 * This class is  a class that contains method to set position to the grid
 *
 */
public abstract class ConnectToGridEditPolicy extends GraphicalEditPolicyEx implements AutomaticNotationEditPolicy, IGrillingEditpolicy {

	protected int displayImprecision=2;
	/**
	 * Update the position of the node that is displayed
	 * @param x the position X
	 * @param y the position Y
	 */
	protected void updateNodePositionOfControler(int x, int y) {
//		Bounds currentBounds=(Bounds)	((Node)((GraphicalEditPart)getHost()).getNotationView()).getLayoutConstraint();
//		if(x<currentBounds.getX()-displayImprecision||x>currentBounds.getX()+displayImprecision){
//			execute(new GMFtoEMFCommandWrapper(new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update notation from Column", new EObjectAdapter( ((GraphicalEditPart)getHost()).getNotationView()),
//					new Point(x,y))));
//		}
//		if(y<currentBounds.getY()-displayImprecision||y>currentBounds.getY()+displayImprecision){
//			execute(new GMFtoEMFCommandWrapper(new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update notation from Row", new EObjectAdapter( ((GraphicalEditPart)getHost()).getNotationView()),
//					new Point(x,y))));
//		}
	}
	/**
	 * Update the size of the Node from the given data
	 * @param width the width of the node
	 * @param height the height of the node
	 */
	protected void updateSizeOfControler(int width, int height) {
//		Bounds currentBounds=(Bounds)	((Node)((GraphicalEditPart)getHost()).getNotationView()).getLayoutConstraint();
//		if(width<currentBounds.getWidth()-displayImprecision||width>currentBounds.getWidth()+displayImprecision){
//			execute(new GMFtoEMFCommandWrapper(new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update notation from Column", new EObjectAdapter( ((GraphicalEditPart)getHost()).getNotationView()),
//					new Dimension(width,currentBounds.getHeight()))));
//		}
//		if(height<currentBounds.getHeight()-displayImprecision||height>currentBounds.getHeight()+displayImprecision){
//			execute(new GMFtoEMFCommandWrapper(new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update notation from Row", new EObjectAdapter( ((GraphicalEditPart)getHost()).getNotationView()),
//					new Dimension(currentBounds.getWidth(),height))));
//		}
	}
	/**
	 * update an axis of the grid from coordinate X or Y
	 * @param axis the axis to update
	 * @param x the coordinate x
	 * @param y the coordinate y
	 */
	protected void updatePositionGridAxis(DecorationNode axis, int x, int y) {
		Location currentBounds=(Location)	axis.getLayoutConstraint();
		if(x<currentBounds.getX()-displayImprecision||x>currentBounds.getX()+displayImprecision){
			UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG_REFERENCEGRID, "+---->ACTION: modifiy AXIS FINISH to  x=" + x);//$NON-NLS-1$
			execute( new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update Column", new EObjectAdapter(axis), new Point(x,y)));

		}
		if(y<currentBounds.getY()-displayImprecision||y>currentBounds.getY()+displayImprecision){
			UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG_REFERENCEGRID, "+---->ACTION: modifiy AXIS FINISH to  y=" + y);//$NON-NLS-1$
			execute( new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update row", new EObjectAdapter(axis), new Point(x,y)));
		}
	}

}