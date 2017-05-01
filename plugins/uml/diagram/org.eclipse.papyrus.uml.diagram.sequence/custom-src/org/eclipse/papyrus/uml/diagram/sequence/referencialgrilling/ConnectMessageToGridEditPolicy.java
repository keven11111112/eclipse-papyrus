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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
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
 *
 */
public class ConnectMessageToGridEditPolicy extends GraphicalEditPolicyEx implements AutomaticNotationEditPolicy, NotificationListener, IGrillingEditpolicy {

	protected GrillingEditpart grillingCompartment=null;

	public static String CONNECT_TO_GRILLING_MANAGEMENT="CONNECT_TO_GRILLING_MANAGEMENT";


	private View rowSource;

	private View rowTarget;
	private boolean canUpdateGrill=true;
	/**
	 * Constructor.
	 *
	 */
	public ConnectMessageToGridEditPolicy() {
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
			GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
			if (grilling!=null){
				ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
				Edge edge=(Edge)connectionEditPart.getModel();
				IdentityAnchor sourceAnchor=(IdentityAnchor)edge.getSourceAnchor();
				IdentityAnchor targetAnchor=(IdentityAnchor)edge.getSourceAnchor();
				if( sourceAnchor!=null && targetAnchor!=null){

					//source
					View viewsr=edge.getSource();
					Message m= (Message)connectionEditPart.resolveSemanticElement();
					double ypercent=IdentityAnchorHelper.getYPercentage(sourceAnchor);
					PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds((Node)viewsr);
					double localY=(bounds.preciseHeight()*ypercent);
					double absoluteY=localY+bounds.preciseY();
					if(m.getSendEvent()==null){
						rowSource=grilling.getorCreateRowTolisten((int)absoluteY,m);
					}else{
						rowSource=grilling.getorCreateRowTolisten((int)absoluteY,m.getSendEvent());
					}
					getDiagramEventBroker().addNotificationListener(rowTarget, this);

					//target
					View viewtg=edge.getTarget();
					ypercent=IdentityAnchorHelper.getYPercentage(targetAnchor);
					bounds= NotationHelper.getAbsoluteBounds((Node)viewtg);
					localY=(bounds.preciseHeight()*ypercent);
					absoluteY=localY+bounds.preciseY();
					if(m.getReceiveEvent()==null){
					rowTarget=grilling.getorCreateRowTolisten((int)absoluteY,m);}
					else{
						rowTarget=grilling.getorCreateRowTolisten((int)absoluteY,m.getReceiveEvent());
					}
					getDiagramEventBroker().addNotificationListener(rowTarget, this);
				}

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
		DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
		if( diagramEditPart!=null){
			//CREATION
			if( notification.getNotifier().equals(((EObject)getHost().getModel())) && NotationPackage.eINSTANCE.getEdge_SourceAnchor().equals(notification.getFeature())&& notification.getNewValue()!=null){
				IdentityAnchor anchor=(IdentityAnchor)notification.getNewValue();
				ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
				Message m= (Message)connectionEditPart.resolveSemanticElement();
				NamedElementEditPart sourceEditpart=(NamedElementEditPart)connectionEditPart.getSource();
				int anchorY=computeAnchorPositionNotation(anchor, sourceEditpart);
				try{
					GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
					if (grilling!=null){
						if(m.getSendEvent()==null){
							rowSource=grilling.getorCreateRowTolisten(anchorY,m);
						}else{
							rowSource=grilling.getorCreateRowTolisten(anchorY,m.getSendEvent());
						}
						getDiagramEventBroker().addNotificationListener(rowSource, this);

					}
				}catch (NoGrillElementFound e) {
					UMLDiagramEditorPlugin.log.error(e);
				}
			}

			//CREATION
			if( notification.getNotifier().equals(((EObject)getHost().getModel())) && NotationPackage.eINSTANCE.getEdge_TargetAnchor().equals(notification.getFeature()) && notification.getNewValue()!=null){
				IdentityAnchor anchor=(IdentityAnchor)notification.getNewValue();
				ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
				NamedElementEditPart editpart=(NamedElementEditPart)connectionEditPart.getTarget();
				Message m= (Message)connectionEditPart.resolveSemanticElement();
				int anchorY=computeAnchorPositionNotation(anchor, editpart);
				try{
					GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
					if (grilling!=null){
						if(m.getReceiveEvent()==null){
							rowTarget=grilling.getorCreateRowTolisten(anchorY, m);
						}
						else{
						rowTarget=grilling.getorCreateRowTolisten(anchorY, m.getReceiveEvent());
						}
						getDiagramEventBroker().addNotificationListener(rowTarget, this);
					}
				}catch (NoGrillElementFound e) {
					UMLDiagramEditorPlugin.log.error(e);
				}
			}
			//A move has been done by the user
			if( notification.getEventType()==Notification.SET&&  notification.getNotifier() instanceof IdentityAnchor ){
				ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost(); 
				Edge edge= (Edge)connectionEditPart.getNotationView();
				if( notification.getNotifier().equals(edge.getSourceAnchor())&& rowSource!=null){
					IdentityAnchor anchor=(IdentityAnchor)edge.getSourceAnchor();
					NamedElementEditPart sourceEditpart=(NamedElementEditPart)connectionEditPart.getSource();
					int anchorY=computeAnchorPositionNotation(anchor, sourceEditpart);
					/////////////////////////////////////////////////////						
					System.out.println("A mouve done for "+((NamedElement)connectionEditPart.resolveSemanticElement()).getName()+" by the user to source "+anchorY);
					/////////////////////////////////////////////////////					
					GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
					if (grilling!=null){
						grilling.updateYpositionForRow((DecorationNode)rowSource, anchorY);
					}
				}
				if( notification.getNotifier().equals(edge.getTargetAnchor())&& rowTarget!=null){
					IdentityAnchor anchor=(IdentityAnchor)edge.getTargetAnchor();
					NamedElementEditPart editpart=(NamedElementEditPart)connectionEditPart.getTarget();
					int anchorY=computeAnchorPositionNotation(anchor, editpart);
					/////////////////////////////////////////////////////						
					System.out.println("A mouve done for "+((NamedElement)connectionEditPart.resolveSemanticElement()).getName()+" by the user to target "+anchorY);
					/////////////////////////////////////////////////////	
					GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
					if (grilling!=null){
						grilling.updateYpositionForRow((DecorationNode)rowTarget, anchorY);
					}
				}

			}


			//a ROW has changed at Source
			if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location &&(((EObject)notification.getNotifier()).eContainer().equals(rowSource)) ){

				GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
				if (grilling!=null){
					if(Math.abs(notification.getOldIntValue()-notification.getNewIntValue())>grilling.threshold){
						ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost();

						Edge edge=(Edge)connectionEditPart.getModel();
						IdentityAnchor sourceAchor=(IdentityAnchor)edge.getSourceAnchor();
						View viewsr=edge.getSource();
						double xpercent=IdentityAnchorHelper.getXPercentage(sourceAchor);

						//calculate  bounds from notation
						PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds((Node)viewsr);
						bounds.height=BoundForEditPart.getHeightFromView((Node)viewsr);
						Location boundsRow=(Location)	((Node)rowSource).getLayoutConstraint();

						Integer intergerY= new Integer(boundsRow.getY());
						double newY= intergerY.doubleValue();
						double localY=(newY-bounds.preciseY());

						double newPercentY	= localY/bounds.preciseHeight();

						///////////////////////////////////////////////////////////
						System.out.println("A row change done for the source"+((NamedElement)connectionEditPart.resolveSemanticElement()).getName()+" by the user to "+newY+"-->"+localY+" percent : old: "+ sourceAchor+" new "+newPercentY);
						/////////////////////////////////////////////////////////////////////////////////////////	
						if(newPercentY>1){
							newPercentY=0.99;
						}
						if(newPercentY<0){
							newPercentY=0.01;
						}
						if (newPercentY <= 1 && newPercentY >= 0 && newPercentY <= 1 && newPercentY >= 0) {
							final String newIdValue = IdentityAnchorHelper.createNewAnchorIdValue(xpercent, newPercentY);
							execute(new SetCommand(getDiagramEditPart(getHost()).getEditingDomain(), sourceAchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), newIdValue));
						}
					}
				}
			}
		}
		//a ROW has changed at target
		if( notification.getEventType()==Notification.SET && notification.getNotifier() instanceof Location &&(((EObject)notification.getNotifier()).eContainer().equals(rowTarget)) ){
			GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
			if (grilling!=null){
				if(Math.abs(notification.getOldIntValue()-notification.getNewIntValue())>grilling.threshold){
					ConnectionEditPart connectionEditPart= (ConnectionEditPart)getHost();
					Edge edge=(Edge)connectionEditPart.getModel();
					IdentityAnchor targetAchor=(IdentityAnchor)edge.getTargetAnchor();
					View viewtg=edge.getTarget();
					double xpercent=IdentityAnchorHelper.getXPercentage(targetAchor);
					//margin calculus
					PrecisionRectangle bounds= NotationHelper.getAbsoluteBounds((Node)viewtg);
					bounds.height=BoundForEditPart.getHeightFromView((Node)viewtg);
					Location boundsRow=(Location)	((Node)rowTarget).getLayoutConstraint();

					Integer intergerY= new Integer(boundsRow.getY());
					double newY= intergerY.doubleValue();
					double localY=(newY-bounds.preciseY());
					double newPercentY	= localY/bounds.preciseHeight();
					///////////////////////////////////////////////////////////
					System.out.println("A row change done for the target"+((NamedElement)connectionEditPart.resolveSemanticElement()).getName()+" by the user to "+newY+"-->"+localY+" percent : old: "+ targetAchor+" new "+newPercentY);
					/////////////////////////////////////////////////////////////////////////////////////////	

					if(newPercentY>1){
						newPercentY=0.99;
					}
					if(newPercentY<0){
						newPercentY=0.01;
					}
					if (newPercentY <= 1 && newPercentY >= 0 && newPercentY <= 1 && newPercentY >= 0) {
						final String newIdValue = IdentityAnchorHelper.createNewAnchorIdValue(xpercent, newPercentY);
						execute(new SetCommand(getDiagramEditPart(getHost()).getEditingDomain(), targetAchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), newIdValue));
					}
				}
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