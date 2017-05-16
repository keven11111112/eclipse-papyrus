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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;

/**
 * this editpolicy is used to manage messages by the grid
 */
public class ConnectMessageToGridEditPolicy extends GraphicalEditPolicyEx implements AutomaticNotationEditPolicy, NotificationListener, IGrillingEditpolicy {

	protected GrillingEditpart grillingCompartment=null;

	public static String CONNECT_TO_GRILLING_MANAGEMENT="CONNECT_TO_GRILLING_MANAGEMENT";
	protected int displayImprecision=2;


	private View rowSource;

	private View rowTarget;
	/**
	 * Constructor.
	 *
	 */
	public ConnectMessageToGridEditPolicy() {
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
			//System.out.println("+---->ACTION: modifiy AXIS to x="+x+" y="+y);
			execute( new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update Column", new EObjectAdapter(axis), new Point(x,y)));

		}
		if(y<currentBounds.getY()-displayImprecision||y>currentBounds.getY()+displayImprecision){
			//System.out.println("+---->ACTION: modifiy AXIS to x="+x+" y="+y);
			execute( new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update row", new EObjectAdapter(axis), new Point(x,y)));
		}
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
		try{
			GridManagementEditPolicy grilling=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
			if (grilling!=null){
				ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
				Edge edge=(Edge)connectionEditPart.getModel();
				IdentityAnchor sourceAnchor=(IdentityAnchor)edge.getSourceAnchor();
				IdentityAnchor targetAnchor=(IdentityAnchor)edge.getSourceAnchor();
				if( sourceAnchor!=null && targetAnchor!=null){


					//source
					if(sourceAnchor.getId()!=null&& !(sourceAnchor.getId().equals(""))){
						View viewsr=edge.getSource();
						Message m= (Message)connectionEditPart.resolveSemanticElement();
						double ypercent=IdentityAnchorHelper.getYPercentage(sourceAnchor);
						PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds((Node)viewsr);
						double localY=(bounds.preciseHeight()*ypercent);
						double absoluteY=localY+bounds.preciseY();
						if(m.getSendEvent()==null){
							rowSource=grilling.createRowTolisten((int)absoluteY,m);
						}else{
							rowSource=grilling.createRowTolisten((int)absoluteY,m.getSendEvent());
						}

						getDiagramEventBroker().addNotificationListener(rowSource, this);
					}
					//target
					if(targetAnchor.getId()!=null&& !(targetAnchor.getId().equals(""))){
						View viewtg=edge.getTarget();
						double ypercent=IdentityAnchorHelper.getYPercentage(targetAnchor);
						Message m= (Message)connectionEditPart.resolveSemanticElement();
						PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds((Node)viewtg);
						double localY=(bounds.preciseHeight()*ypercent);
						double absoluteY=localY+bounds.preciseY();
						if(m.getReceiveEvent()==null){
							rowTarget=grilling.createRowTolisten((int)absoluteY,m);}
						else{
							rowTarget=grilling.createRowTolisten((int)absoluteY,m.getReceiveEvent());
						}
						getDiagramEventBroker().addNotificationListener(rowTarget, this);
					}
				}

			}
		}catch (NoGrillElementFound e) {
			UMLDiagramEditorPlugin.log.error(e);
		}
	}

	/** Gets the diagram event broker from the editing domain.
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
		DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
		if( diagramEditPart!=null){
			//CREATION
			if( notification.getNotifier().equals(((EObject)getHost().getModel())) && NotationPackage.eINSTANCE.getEdge_SourceAnchor().equals(notification.getFeature())&& notification.getNewValue()!=null){
				//System.out.println("+ EVENT :CREATION add SourceAnchor "+notification.getNotifier());
				IdentityAnchor anchor=(IdentityAnchor)notification.getNewValue();
				if(anchor.getId()!=null&& !(anchor.getId().equals(""))){
					ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
					Message m= (Message)connectionEditPart.resolveSemanticElement();
					NamedElementEditPart sourceEditpart=(NamedElementEditPart)connectionEditPart.getSource();
					int anchorY=computeAnchorPositionNotation(anchor, sourceEditpart);
					try{
						GridManagementEditPolicy grilling=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
						if (grilling!=null){
							if( rowSource==null) {
								if(m.getSendEvent()==null){
									rowSource=grilling.createRowTolisten(anchorY,m);
								}else{
									rowSource=grilling.createRowTolisten(anchorY,m.getSendEvent());
								}
							}
							getDiagramEventBroker().addNotificationListener(rowSource, this);

						}
					}catch (NoGrillElementFound e) {
						UMLDiagramEditorPlugin.log.error(e);
					}
				}
			}

			//CREATION
			if( notification.getNotifier().equals(((EObject)getHost().getModel())) && NotationPackage.eINSTANCE.getEdge_TargetAnchor().equals(notification.getFeature()) && notification.getNewValue()!=null){
				//System.out.println("+ EVENT: CREATION add targetAnchor "+notification.getNotifier());
				IdentityAnchor anchor=(IdentityAnchor)notification.getNewValue();
				if(anchor.getId()!=null&& !(anchor.getId().equals(""))){
					ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
					NamedElementEditPart editpart=(NamedElementEditPart)connectionEditPart.getTarget();
					Message m= (Message)connectionEditPart.resolveSemanticElement();
					int anchorY=computeAnchorPositionNotation(anchor, editpart);
					try{
						GridManagementEditPolicy grilling=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
						if (grilling!=null){
							if( rowTarget==null) {
								if(m.getReceiveEvent()==null){
									rowTarget=grilling.createRowTolisten(anchorY, m);
								}
								else{
									rowTarget=grilling.createRowTolisten(anchorY, m.getReceiveEvent());
								}
							}
							getDiagramEventBroker().addNotificationListener(rowTarget, this);
						}
					}catch (NoGrillElementFound e) {
						UMLDiagramEditorPlugin.log.error(e);
					}
				}
			}
			//A move has been done by the user
			if( notification.getEventType()==Notification.SET&&  notification.getNotifier() instanceof IdentityAnchor ){
				//System.out.println("+EVENT IdentificationAnchor change "+notification.getNotifier());
				ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
				Edge edge= (Edge)connectionEditPart.getNotationView();
				if( notification.getNotifier().equals(edge.getSourceAnchor())&& rowSource!=null){
					IdentityAnchor anchor=(IdentityAnchor)edge.getSourceAnchor();
					NamedElementEditPart sourceEditpart=(NamedElementEditPart)connectionEditPart.getSource();
					int anchorY=computeAnchorPositionNotation(anchor, sourceEditpart);
					//System.out.println("+--> SOURCE change for "+((NamedElement)connectionEditPart.resolveSemanticElement()).getName()+" to "+anchorY+ " ");
					updatePositionGridAxis((DecorationNode)rowSource, 0, anchorY);
				}
				if( notification.getNotifier().equals(edge.getTargetAnchor())&& rowTarget!=null){
					IdentityAnchor anchor=(IdentityAnchor)edge.getTargetAnchor();
					NamedElementEditPart editpart=(NamedElementEditPart)connectionEditPart.getTarget();
					int anchorY=computeAnchorPositionNotation(anchor, editpart);
					//System.out.println("+-->TARGET change "+((NamedElement)connectionEditPart.resolveSemanticElement()).getName()+" to "+anchorY+ " ");
					updatePositionGridAxis((DecorationNode)rowTarget, 0, anchorY);
				}

			}


			//a ROW AXIS has changed at Source
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location &&(((EObject)notification.getNotifier()).eContainer().equals(rowSource)) ){
				//System.out.println("+ EVENT source Axis modified :" +notification);
				GridManagementEditPolicy grilling=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
				if (grilling!=null){
					if(Math.abs(notification.getOldIntValue()-notification.getNewIntValue())>grilling.threshold){
						ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost();
						Edge edge=(Edge)connectionEditPart.getModel();
						IdentityAnchor sourceAchor=(IdentityAnchor)edge.getSourceAnchor();
						View viewsr=edge.getSource();
						modifyAnchor(sourceAchor,(Node)viewsr,(DecorationNode) rowSource);
					}
				}
			}

			//a ROW has changed at target
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location &&(((EObject)notification.getNotifier()).eContainer().equals(rowTarget)) ){
			//	System.out.println("+ EVENT target axis modified:" +notification);
				GridManagementEditPolicy grilling=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
				if (grilling!=null){
					if(Math.abs(notification.getOldIntValue()-notification.getNewIntValue())>grilling.threshold){
						ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost();
						Edge edge=(Edge)connectionEditPart.getModel();
						IdentityAnchor targetAchor=(IdentityAnchor)edge.getTargetAnchor();
						View viewtg=edge.getTarget();
						modifyAnchor( targetAchor, (Node)viewtg,(DecorationNode)rowTarget);
					}
				}
			}
		}
	}

	protected void modifyAnchor( IdentityAnchor anchor, Node connectedView, DecorationNode axis) {
		double xpercent=IdentityAnchorHelper.getXPercentage(anchor);
		PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds(connectedView);
		bounds.height=BoundForEditPart.getHeightFromView(connectedView);
		Location boundsRow=(Location)	((Node)axis).getLayoutConstraint();
		Integer intergerY= new Integer(boundsRow.getY());
		double newY= intergerY.doubleValue();
		double localY=(newY-bounds.preciseY());

		double newPercentY	= localY/bounds.preciseHeight();
		double oldPercentY=IdentityAnchorHelper.getYPercentage(anchor);
		if( Math.abs(oldPercentY-newPercentY)>0.05) {
			if(newPercentY>1){
				newPercentY=0.99;
			}
			if(newPercentY<0){
				newPercentY=0.01;
			}
			if (newPercentY <= 1 && newPercentY >= 0 && newPercentY <= 1 && newPercentY >= 0) {
				final String newIdValue = IdentityAnchorHelper.createNewAnchorIdValue(xpercent, newPercentY);
				//System.out.println("+---->ACTION: modify anchor to precentY="+newPercentY);
				execute(new SetCommand(getDiagramEditPart(getHost()).getEditingDomain(), anchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), newIdValue));
			}
		}
	}

	public static int computeAnchorPositionNotation(IdentityAnchor anchor,GraphicalEditPart nodeEditPart){
		double yPercent=IdentityAnchorHelper.getYPercentage(anchor);
		Node node=(Node)nodeEditPart.getNotationView();
		PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds(node);
		double height=BoundForEditPart.getHeightFromView(node);
		int anchorY= (int) (height*yPercent)+bounds.y;
		return anchorY;
	} 
}