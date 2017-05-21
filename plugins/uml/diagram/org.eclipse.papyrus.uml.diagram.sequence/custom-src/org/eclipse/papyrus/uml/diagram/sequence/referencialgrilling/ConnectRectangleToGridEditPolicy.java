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

import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Element;

/**
 * this class is used to connect a node to the grid
 * X, Y, X+Width, Y+HEIGHT
 *
 */
public class ConnectRectangleToGridEditPolicy extends ConnectToGridEditPolicy implements AutomaticNotationEditPolicy, NotificationListener, IGrillingEditpolicy {

	protected GrillingEditpart grillingCompartment=null;

	public static String CONNECT_TO_GRILLING_MANAGEMENT="CONNECT_TO_GRILLING_MANAGEMENT";

	protected DecorationNode rowStart=null;
	protected DecorationNode rowFinish=null;
	protected DecorationNode columnStart=null;
	protected DecorationNode columnFinish=null;

	/**
	 * Constructor.
	 *
	 */
	public ConnectRectangleToGridEditPolicy() {
	}

	/**
	 * avoid to modify it directly, try to modify call of sub-methods: initListeningXXX
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
		getDiagramEventBroker().addNotificationListener(((EObject)getHost().getModel()), this);
		DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
		Node node=((Node)((GraphicalEditPart)getHost()).getNotationView());
		try{
			GridManagementEditPolicy grilling=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
			//grilling.cleanUnusedRowAndColumn();
			Node nodeContainer=(Node)(((GraphicalEditPart)getHost()).getNotationView()).eContainer();
			Element element=(Element) ((GraphicalEditPart)getHost()).resolveSemanticElement();
			if (grilling!=null){
				PrecisionRectangle p=NotationHelper.getAbsoluteBounds((Node)((GraphicalEditPart)getHost()).getNotationView());
				initListeningRowStart(grilling,element, p);
				initListeningColumnStart(grilling, element, p);
				initListeningRowFinish(node, grilling, element, p);
				initListeningColumnFinish(node, grilling, element, p);
			}
		}catch (NoGrillElementFound e) {
			UMLDiagramEditorPlugin.log.error(e);
		}

	}
	/**
	 * this method is called during the activate
	 * It initialize a columnFinish and listen it
	 * @param grilling the grid manager that allow creating rows
	 * @param element the semantic element
	 * @param bounds the absolute position of the current node (the origin of the referencial is the diagram)
	 * @throws NoGrillElementFound
	 */
	protected void initListeningColumnFinish(Node node, GridManagementEditPolicy grilling, Element element, PrecisionRectangle bounds) throws NoGrillElementFound {
		columnFinish=grilling.createColumnTolisten(bounds.x+BoundForEditPart.getWidthFromView(node), element);
		getDiagramEventBroker().addNotificationListener(columnFinish, this);
	}

	/**
	 * this method is called during the activate
	 * It initialize a rowFinish and listen it
	 * @param grilling the grid manager that allow creating rows
	 * @param element the semantic element
	 * @param bounds the absolute position of the current node (the origin of the referential is the diagram)
	 * @throws NoGrillElementFound
	 */
	protected void initListeningRowFinish(Node node, GridManagementEditPolicy grilling, Element element, PrecisionRectangle bounds) throws NoGrillElementFound {
		rowFinish=grilling.createRowTolisten(bounds.y+BoundForEditPart.getHeightFromView(node), element);
		getDiagramEventBroker().addNotificationListener(rowFinish, this);
	}

	/**
	 * this method is called during the activate
	 * It initialize a ColumnStart and listen it
	 * @param grilling the grid manager that allow creating rows
	 * @param element the semantic element
	 * @param bounds the absolute position of the current node ( the origin of the referential is the diagram)
	 * @throws NoGrillElementFound
	 */
	protected void initListeningColumnStart(GridManagementEditPolicy grilling, Element element, PrecisionRectangle bounds) throws NoGrillElementFound {
		columnStart=grilling.createColumnTolisten(bounds.x(), element);	
		getDiagramEventBroker().addNotificationListener(columnStart, this);
	}

	/**
	 * this method is called during the activate
	 * It initialize a rowStart and listen it
	 * @param grilling the grid manager that allow creating rows
	 * @param element the semantic element
	 * @param bounds position of the current node in absolute ( the origin is the diagram)
	 * @throws NoGrillElementFound
	 */
	protected void initListeningRowStart(GridManagementEditPolicy grid, Element element, PrecisionRectangle bounds) throws NoGrillElementFound {
		rowStart=grid.createRowTolisten(bounds.y, element);
		getDiagramEventBroker().addNotificationListener(rowStart, this);
	}

	/* Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (null != theEditingDomain) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}


	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 *
	 */
	@Override
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(((EObject)getHost().getModel()), this);
		if(rowStart!=null){
			getDiagramEventBroker().removeNotificationListener(rowStart, this);
		}
		if(columnStart!=null){
			getDiagramEventBroker().removeNotificationListener(columnStart, this);
		}
		if(rowFinish!=null){
			getDiagramEventBroker().removeNotificationListener(rowFinish, this);
		}
		if(columnFinish!=null){
			getDiagramEventBroker().removeNotificationListener(columnFinish, this);
		}
		super.deactivate();
	}

	/**
	 * avoid to modify it directly, try to modify call of sub-methods: updateXXX
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void notifyChanged(Notification notification) {
		//Display imprecision
		if(notification.getEventType()==Notification.REMOVE){
			return;
		}
		Node nodeContainer=(Node)(((GraphicalEditPart)getHost()).getNotationView()).eContainer();
		if( nodeContainer!=null){
			PrecisionRectangle originPosition= NotationHelper.getAbsoluteBounds(nodeContainer);
			Bounds currentBounds=(Bounds)	((Node)((GraphicalEditPart)getHost()).getNotationView()).getLayoutConstraint();

			//the ROW has changed so we must update the position of the combined fragment
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(rowStart))){
				//The grid is in absolute
				//compute next position for View.bound.y	
				updateYFromAxisNotification(originPosition, currentBounds);
			}
			//the COLUMN has changed so we must update the postion of the combined fragment
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(columnStart))){
				//The grill is in absolute
				updateXFromAxisNotification(originPosition, currentBounds);

			}
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(rowFinish))){
				//The grill is in absolute
				updateHeightFromAxisNotification(originPosition, currentBounds);

			}
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(columnFinish))){
				//The grill is in absolute
				updateWidthFromAxisNotification(originPosition, currentBounds);

			}

			//UPDATE COLUM AND ROW of THE GRID
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Bounds){
				PrecisionRectangle bounds=NotationHelper.getAbsoluteBounds((Node)((GraphicalEditPart)getHost()).getNotationView());
				UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+ EVENT: BOUNDS change " +notification.getNewValue());//$NON-NLS-1$
				
				if( notification.getFeature().equals(NotationPackage.eINSTANCE.getSize_Height())){
					updateRowFinishFromHeightNotification(bounds);
					//update acnchors
					if( (((EObject)notification.getNotifier()).eContainer().equals(((EObject)getHost().getModel())))){
						Node node=(Node)this.getHost().getModel();
						java.util.List<Edge> sourceEdge= node.getSourceEdges();
						for (Edge edge : sourceEdge) {
							updateAnchorFromHeight(edge,((Node)getHost().getModel()),notification.getNewIntValue()- notification.getOldIntValue());
						}
						java.util.List<Edge> targetEdge= node.getTargetEdges();
						for (Edge edge : targetEdge) {
							updateAnchorFromHeight(edge,((Node)getHost().getModel()),notification.getNewIntValue()- notification.getOldIntValue());
						}
					}
				}
				if( notification.getFeature().equals(NotationPackage.eINSTANCE.getSize_Width())){
					updateColumFinishFromWitdhNotification(bounds);
				}
				if( notification.getFeature().equals(NotationPackage.eINSTANCE.getLocation_Y())){
					//compute next position for RowStart
					updateRowStartFromYNotification(bounds);
					//updateAnchors
					if (((EObject)notification.getNotifier()).eContainer().equals(((EObject)getHost().getModel()))){
						Node node=(Node)this.getHost().getModel();
						java.util.List<Edge> sourceEdge= node.getSourceEdges();
						for (Edge edge : sourceEdge) {
							updateAnchorFromY(edge,((Node)getHost().getModel()),notification.getOldIntValue(),notification.getNewIntValue());
						}
						java.util.List<Edge> targetEdge= node.getTargetEdges();
						for (Edge edge : targetEdge) {
							updateAnchorFromY(edge,((Node)getHost().getModel()),notification.getOldIntValue(),notification.getNewIntValue());
						}
					}
				}
				if( notification.getFeature().equals(NotationPackage.eINSTANCE.getLocation_X())){
					//compute next position for RowStart
					updateColumnStartFromXNotification(bounds);
				}
			}
		}
	}

	/**
	 * When the bounds of the notation has change the axis must change
	 * In this case this is the height that has change so rowFinish must change
	 * @param originPosition the position of the node is the relative position ( relative to the container) 
	 */
	protected void updateRowFinishFromHeightNotification(PrecisionRectangle p) {
		int newY=p.y+p.height;
		updatePositionGridAxis(rowFinish, 0, newY);
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+---->ACTION: modifiy AXIS FINISH to  y=" + newY);//$NON-NLS-1$
		
		
	}

	/**
	 * When the bounds of the notation has change the axis must change
	 * In this case this is the width that has changed so ColumnFinish must change
	 * @param notationBound the position of the node is the absolute position ( the origin to the referential is the diagram) 
	 */
	protected void updateColumFinishFromWitdhNotification(PrecisionRectangle notationBound) {
		int newX=notationBound.x+notationBound.width;
		updatePositionGridAxis(columnFinish, newX,0);
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+---->ACTION: modifiy AXIS to  x=" + newX);//$NON-NLS-1$
		
	}

	/**
	 * When the bounds of the notation has change the axis must change
	 * In this case this is the position Y that has change so RowStart must change
	 * @param bounds the position of the node is the absolute position ( the origin to the referential is the diagram) 
	 */
	protected void updateRowStartFromYNotification(PrecisionRectangle bounds) {
		
		int newY=bounds.y();
		updatePositionGridAxis(rowStart, 0, newY);
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+---->ACTION: modifiy AXIS START to  y=" + newY);//$NON-NLS-1$
		
		if(rowFinish!=null) {
			newY=bounds.y+bounds.height;
			updatePositionGridAxis(rowFinish, 0, newY);
			UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+---->ACTION: modifiy AXIS FINISH to  y=" + newY);//$NON-NLS-1$
		}
	}

	/**
	 * When the bounds of the notation has change the axis must change
	 * In this case this is the position X that has change so ColumnStart must change
	@param bounds the position of the node is the absolute position ( the origin to the referential is the diagram) 
	 */
	protected void updateColumnStartFromXNotification(PrecisionRectangle bounds) {
		int newX=bounds.x();
		updatePositionGridAxis(columnStart, newX, 0);
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+---->ACTION: modifiy AXIS START to  x=" + newX);//$NON-NLS-1$
		
	}
	/**
	 * When  the axis columnFinish has changed , the width of the controler has to change
	 * @param originPosition the position of the container in absolute (origin the diagram)
	 * @param currentBounds the current position of the node (relative to the container)
	 */
	protected void updateWidthFromAxisNotification(PrecisionRectangle originPosition, Bounds currentBounds) {
		Location boundsColumn=(Location)	((Node)columnFinish).getLayoutConstraint();
		int newX=boundsColumn.getX()-originPosition.x()-currentBounds.getX();
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+ EVENT: AXIS ROW FINISH change " +newX);//$NON-NLS-1$
		
		updateSizeOfControler(newX, currentBounds.getHeight());
	}
	/**
	 * When  the axis rowFinish has changed , the height of the controler has to change
	 * @param originPosition the position of the container in absolute (origin the diagram)
	 * @param currentBounds the current position of the node (relative to the container)
	 */
	protected void updateHeightFromAxisNotification(PrecisionRectangle originPosition, Bounds currentBounds) {
		Location boundsColumn=(Location)	((Node)rowFinish).getLayoutConstraint();
		int newHeight=boundsColumn.getY()-originPosition.y()-currentBounds.getY();
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+ EVENT: AXIS ROW FINISH change " +newHeight);//$NON-NLS-1$
		
		updateSizeOfControler(currentBounds.getWidth(), newHeight);
	}
	/**
	 * When  the axis columnStart has changed , the position X of the controler has to change
	 * @param originPosition the position of the container in absolute (origin the diagram)
	 * @param currentBounds the current position of the node (relative to the container)
	 */
	protected void updateXFromAxisNotification(PrecisionRectangle originPosition, Bounds currentBounds) {
		Location boundsColumn=(Location)	((Node)columnStart).getLayoutConstraint();
		int newX=boundsColumn.getX()-originPosition.x();
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+ EVENT: AXIS COLUMN START change " +newX);//$NON-NLS-1$
		
		updateNodePositionOfControler(newX, currentBounds.getY());
	}

	/**
	 * When  the axis rowStart has changed , the position Y of the controler has to change
	 * @param originPosition the position of the container in absolute (origin the diagram)
	 * @param currentBounds the current position of the node (relative to the container)
	 */
	protected void updateYFromAxisNotification(PrecisionRectangle originPosition, Bounds currentBounds) {
		Location boundsRow=(Location)	((Node)rowStart).getLayoutConstraint();
		int newY=boundsRow.getY()-originPosition.y();
		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "+ EVENT: AXIS ROW START change " +newY);//$NON-NLS-1$
		updateNodePositionOfControler(currentBounds.getX(), newY);
		
	}


	/**
	 * this class update the position of anchor after the resize
	 * @param sourceEdge
	 * @param eObject
	 */
	protected void updateAnchorFromHeight(Edge edge, Node node, int deltaHeight) {
		IdentityAnchor anchor=null;
		if (edge.getSource().equals(node)){
			anchor=(IdentityAnchor)edge.getSourceAnchor();
		}
		else{
			anchor=(IdentityAnchor)edge.getTargetAnchor();
		}
		double yPercent=IdentityAnchorHelper.getYPercentage(anchor);
		double xPercent=IdentityAnchorHelper.getXPercentage(anchor);

		//calculate  bounds from notation
		PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds(node);
		double oldHeight=BoundForEditPart.getHeightFromView(node)-deltaHeight;

		double newPercentY	= (yPercent*oldHeight)/(bounds.preciseHeight());
		if (newPercentY <= 1 && newPercentY >= 0 && newPercentY <= 1 && newPercentY >= 0) {
			final String newIdValue = IdentityAnchorHelper.createNewAnchorIdValue(xPercent, newPercentY);
			execute(new SetCommand(getDiagramEditPart(getHost()).getEditingDomain(), anchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), newIdValue));
		}
	}
	/**
	 * /**
	 * this class update the position of anchor after the move
	 * @param sourceEdge
	 * @param eObject
	 */
	protected void updateAnchorFromY(Edge edge, Node node, int oldY, int newY) {
		IdentityAnchor anchor=null;
		if (edge.getSource().equals(node)){
			anchor=(IdentityAnchor)edge.getSourceAnchor();
		}
		else{
			anchor=(IdentityAnchor)edge.getTargetAnchor();
		}
		if(!anchor.getId().trim().equals("")){
			double yPercent=IdentityAnchorHelper.getYPercentage(anchor);
			double xPercent=IdentityAnchorHelper.getXPercentage(anchor);

			//calculate  bounds from notation
			double height=BoundForEditPart.getHeightFromView(node);

			double newPercentY	= (oldY-newY)/(height)+yPercent;
			if(newPercentY<0){
				newPercentY=0.1;
			}
			if(newPercentY>1){
				newPercentY=0.9;
			}
			if (newPercentY <= 1 && newPercentY >= 0 && newPercentY <= 1 && newPercentY >= 0) {
				final String newIdValue = IdentityAnchorHelper.createNewAnchorIdValue(xPercent, newPercentY);
				execute(new SetCommand(getDiagramEditPart(getHost()).getEditingDomain(), anchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), newIdValue));
			}
		}
	}

}
