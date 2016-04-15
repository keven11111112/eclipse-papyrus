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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Element;

/**
 * this class is used to connect a node to the grid
 * X, Y, X+Width, Y+HEIGHT
 *
 */
public class ConnectNodeToGridEditPolicy extends ConnectToGridEditPolicy implements AutomaticNotationEditPolicy, NotificationListener, IGrillingEditpolicy {

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
	public ConnectNodeToGridEditPolicy() {
	}

	/**
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
			GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
			grilling.cleanUnusedRowAndColumn();
			Node nodeContainer=(Node)(((GraphicalEditPart)getHost()).getNotationView()).eContainer();
			PrecisionRectangle originPosition= NotationHelper.getAbsoluteBounds(nodeContainer);
			Element element=(Element) ((GraphicalEditPart)getHost()).resolveSemanticElement();
			if (grilling!=null){
				PrecisionRectangle p=NotationHelper.getAbsoluteBounds((Node)((GraphicalEditPart)getHost()).getNotationView());
				rowStart=grilling.getRowTolisten(originPosition.y+p.y(), element);
				columnStart=grilling.getColumnTolisten(originPosition.x+p.x(), element);
				getDiagramEventBroker().addNotificationListener(rowStart, this);
				getDiagramEventBroker().addNotificationListener(columnStart, this);
				rowFinish=grilling.getRowTolisten(originPosition.y+p.y()+BoundForEditPart.getHeightFromView(node), element);
				getDiagramEventBroker().addNotificationListener(rowFinish, this);
				columnFinish=grilling.getColumnTolisten(originPosition.x+p.x()+BoundForEditPart.getWidthFromView(node), element);
				getDiagramEventBroker().addNotificationListener(columnFinish, this);



			}
		}catch (NoGrillElementFound e) {
			UMLDiagramEditorPlugin.log.error(e);
		}

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
		super.deactivate();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void notifyChanged(Notification notification) {
		//Display imprecision
		Node nodeContainer=(Node)(((GraphicalEditPart)getHost()).getNotationView()).eContainer();
		PrecisionRectangle originPosition= NotationHelper.getAbsoluteBounds(nodeContainer);
		Bounds currentBounds=(Bounds)	((Node)((GraphicalEditPart)getHost()).getNotationView()).getLayoutConstraint();

		//the ROW has changed so we must update the position of the combined fragment
		if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(rowStart))){
			//The grill is in absolute
			//compute next position for View.bound.y	
			Location boundsRow=(Location)	((Node)rowStart).getLayoutConstraint();
			int newY=boundsRow.getY()-originPosition.y();
			updateNodePositionOfControler(currentBounds.getX(), newY);
		}
		//the COLUMN has changed so we must update the postion of the combined fragment
		if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(columnStart))){
			//The grill is in absolute
			Location boundsColumn=(Location)	((Node)columnStart).getLayoutConstraint();
			int newX=boundsColumn.getX()-originPosition.x();
			updateNodePositionOfControler(newX, currentBounds.getY());
			
		}
		if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(rowFinish))){
			//The grill is in absolute
			Location boundsColumn=(Location)	((Node)rowFinish).getLayoutConstraint();
			int newHeight=boundsColumn.getY()-originPosition.y()-currentBounds.getY();
			updateSizeOfControler(currentBounds.getWidth(), newHeight);
			
		}
		if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(columnFinish))){
			//The grill is in absolute
			Location boundsColumn=(Location)	((Node)columnFinish).getLayoutConstraint();
			int newX=boundsColumn.getX()-originPosition.x()-currentBounds.getX();
			updateSizeOfControler(newX, currentBounds.getHeight());
			
		}
		
		//UPDATE COLUM AND ROW of THE GRID
		if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Bounds && (((EObject)notification.getNotifier()).eContainer().equals(((EObject)getHost().getModel())))){
			PrecisionRectangle p=NotationHelper.getAbsoluteBounds((Node)((GraphicalEditPart)getHost()).getNotationView());

			if( notification.getFeature().equals(NotationPackage.eINSTANCE.getSize_Height())){
				int newY=p.y+p.height;
				updatePositionGridAxis(rowFinish, 0, newY);

			}
			if( notification.getFeature().equals(NotationPackage.eINSTANCE.getSize_Width())){
				int newX=p.x+p.width;
				updatePositionGridAxis(columnFinish, newX,0);

			}
			if( notification.getFeature().equals(NotationPackage.eINSTANCE.getLocation_Y())){
				//compute next position for RowStart
				int newY=notification.getNewIntValue()+originPosition.y();
				updatePositionGridAxis(rowStart, 0, newY);
					
			}
			if( notification.getFeature().equals(NotationPackage.eINSTANCE.getLocation_X())){
				//compute next position for RowStart
				int newX=notification.getNewIntValue()+originPosition.x();
				updatePositionGridAxis(columnStart, newX, 0);
					
			}
		}
	}
}
