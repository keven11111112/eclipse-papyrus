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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CLifeLineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;

/**
 * @author PT202707
 *
 */
public class ConnectExecutionNodeToGrillingEditPolicy extends GraphicalEditPolicyEx implements AutomaticNotationEditPolicy, NotificationListener, IGrillingEditpolicy {

	protected GrillingEditpart grillingCompartment=null;

	public static String CONNECT_TO_GRILLING_MANAGEMENT="CONNECT_TO_GRILLING_MANAGEMENT";

	protected View rowStart=null;
	protected View rowFinish=null;

	/**
	 * Constructor.
	 *
	 */
	public ConnectExecutionNodeToGrillingEditPolicy() {
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
		Bounds bounds=(Bounds)	((Node)((GraphicalEditPart)getHost()).getNotationView()).getLayoutConstraint();
		try{
			GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
			grilling.cleanUnusedRowAndColumn();
			ExecutionSpecification exec=(ExecutionSpecification) ((GraphicalEditPart)getHost()).resolveSemanticElement();
			if (grilling!=null){
				PrecisionRectangle p=NotationHelper.getAbsoluteBounds((Node)((GraphicalEditPart)getHost()).getNotationView());
				rowStart=grilling.getorCreateRowTolisten(p.y(), exec.getStart());
				getDiagramEventBroker().addNotificationListener(rowStart, this);
				if( bounds.getHeight()!=-1){
					rowFinish=grilling.getorCreateRowTolisten(p.y()+bounds.getHeight(), exec.getFinish());
				}
				else{
					rowFinish=grilling.getorCreateRowTolisten(p.y()+CustomActionExecutionSpecificationEditPart.DEFAULT_HEIGHT, exec.getFinish());
				}
				getDiagramEventBroker().addNotificationListener(rowStart, this);



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
		int displayImprecision=2;
		GrillingManagementEditPolicy grilling=null;
		getDiagramEventBroker().addNotificationListener(((EObject)getHost().getModel()), this);
		DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
		try{
			grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
		}catch (Exception e) {
		}

		Node nodeContainer=(Node)(((GraphicalEditPart)getHost()).getNotationView()).eContainer();
		if(nodeContainer==null){
			//during remove, Unset notification...
			return;
		}
		PrecisionRectangle originPosition= NotationHelper.getAbsoluteBounds(nodeContainer);
		Bounds bounds=(Bounds)	((Node)((GraphicalEditPart)getHost()).getNotationView()).getLayoutConstraint();


		//the ROW has changed
		if( notification.getEventType()==notification.SET && notification.getNotifier() instanceof Location && (((EObject)notification.getNotifier()).eContainer().equals(rowStart))){

			//The grill is in absolute
			Location boundsRow=(Location)	((Node)rowStart).getLayoutConstraint();
			execute(new GMFtoEMFCommandWrapper(new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update Row", new EObjectAdapter( ((GraphicalEditPart)getHost()).getNotationView()),
					new Point(bounds.getX(),boundsRow.getY()-originPosition.y()+displayImprecision ))));

		}

		//the size has change
		// we must update all links.
		if( notification.getEventType()==notification.SET && notification.getNotifier() instanceof Bounds && (((EObject)notification.getNotifier()).eContainer().equals(((EObject)getHost().getModel())))){
			PrecisionRectangle p=NotationHelper.getAbsoluteBounds((Node)((GraphicalEditPart)getHost()).getNotationView());


			if( notification.getFeature().equals(NotationPackage.eINSTANCE.getSize_Height())){
				grilling.setRespectMargin(true);
				int newPosition=p.y()+notification.getNewIntValue()-displayImprecision;
				grilling.updateYpositionForRow((DecorationNode) rowFinish, p.y()+notification.getNewIntValue()-displayImprecision);
				//				execute(new GMFtoEMFCommandWrapper(new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update Row finish", new EObjectAdapter( rowFinish),
				//						new Point(0,p.y()+notification.getNewIntValue()-displayImprecision))));
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
			if( notification.getFeature().equals(NotationPackage.eINSTANCE.getLocation_Y())){
				
				ExecutionSpecification exec=(ExecutionSpecification) ((GraphicalEditPart)getHost()).resolveSemanticElement();
				getDiagramEventBroker().removeNotificationListener(rowStart, this);
				grilling.dissociateViewToGrill(rowStart, exec.getStart());
				//Set the coordinate in absolute
				try {
					rowStart=grilling.getorCreateRowTolisten(p.y(), exec.getStart());
					getDiagramEventBroker().addNotificationListener(rowStart, this);
					grilling.updateYpositionForRow((DecorationNode) rowFinish, p.y()+p.height-displayImprecision);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				//execute( new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update row", new EObjectAdapter(rowStart), new Point(0,p.y()-displayImprecision)));

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

	}

	/**
	 * @param sourceEdge
	 * @param eObject
	 */
	private void updateAnchorFromHeight(Edge edge, Node node, int deltaHeight) {
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
		double oldSize=bounds.preciseHeight()-deltaHeight;
		if( oldSize==-1.0){
			//it is very bad , because this is a default valued given by the figure...
			if( getHost() instanceof CLifeLineEditPart){
				oldSize=CLifeLineEditPart.DEFAUT_HEIGHT;
			}
		}

		double newPercentY	= (yPercent*oldSize)/(bounds.preciseHeight());
		if (newPercentY <= 1 && newPercentY >= 0 && newPercentY <= 1 && newPercentY >= 0) {
			final String newIdValue = IdentityAnchorHelper.createNewAnchorIdValue(xPercent, newPercentY);
			execute(new SetCommand(getDiagramEditPart(getHost()).getEditingDomain(), anchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), newIdValue));
		}
	}
	/**
	 * @param sourceEdge
	 * @param eObject
	 */
	private void updateAnchorFromY(Edge edge, Node node, int oldY, int newY) {
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
			PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds(node);
			double height=bounds.preciseHeight();
			if( height==-1.0){
				//it is very bad , because this is a default valued given by the figure...
				if( getHost() instanceof CLifeLineEditPart){
					height=CLifeLineEditPart.DEFAUT_HEIGHT;
				}
			}

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
