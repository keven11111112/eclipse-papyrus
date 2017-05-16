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

import java.util.Map;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.FeedbackHelper;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoGEFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultGraphicalNodeEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateExecutionSpecificationWithMessage;
import org.eclipse.papyrus.uml.diagram.sequence.command.DropDestructionOccurenceSpecification;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 *This class overload all creation of link between lifelines
 *pay attention : this editpolicy launch a display of event during the mouve of the mouse
 */
public class LifeLineGraphicalNodeEditPolicy extends DefaultGraphicalNodeEditPolicy implements IGrillingEditpolicy{

	/** manage only for FOUND message**/
	private GraphicalNodeEditPolicy graphicalNodeEditPolicy=null;
	private DisplayEvent displayEvent;



	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultGraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		displayEvent.addFigureEvent(getHostFigure(), request.getLocation());
		MessageEnd end=getPreviousEventFromPosition(request.getLocation());
		if( end!=null){
			Map<String, Object> extendedData = request.getExtendedData();
			extendedData.put(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.PREVIOUS_EVENT,end);
			request.setExtendedData(extendedData);
		}
		OccurrenceSpecification os = displayEvent.getActionExecutionSpecificationEvent(getHostFigure(), ((CreateRequest) request).getLocation());
		//add a param if we must replace an event of the execution specification
		if (os != null) {
			Map<String, Object> extendedData = request.getExtendedData();
			extendedData.put(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.MESSAGE_SENTEVENT_REPLACE_EXECUTIONEVENT, os);
			request.setExtendedData(extendedData);
		}
		return super.getConnectionCreateCommand(request);
	}
	/**
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#eraseTargetConnectionFeedback(org.eclipse.gef.requests.DropRequest)
	 *
	 * @param request
	 */
	@Override
	protected void eraseTargetConnectionFeedback(DropRequest request) {
		super.eraseTargetConnectionFeedback(request);
		displayEvent.removeFigureEvent(getHostFigure());
	}
	/**
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#eraseCreationFeedback(org.eclipse.gef.requests.CreateConnectionRequest)
	 *
	 * @param request
	 */
	@Override
	protected void eraseCreationFeedback(CreateConnectionRequest request) {
		super.eraseCreationFeedback(request);
		displayEvent= new DisplayEvent(getHost());
	}
	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#setHost(org.eclipse.gef.EditPart)
	 *
	 * @param host
	 */
	@Override
	public void setHost(EditPart host) {
		super.setHost(host);
		displayEvent= new DisplayEvent(getHost());
	}
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultGraphicalNodeEditPolicy#getConnectionAndRelationshipCompleteCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		displayEvent.addFigureEvent(getHostFigure(), request.getLocation());
		Command cmd= super.getConnectionAndRelationshipCompleteCommand(request);
		MessageEnd end=getPreviousEventFromPosition(request.getLocation());
		if( end!=null){
			Map<String, Object> extendedData = request.getExtendedData();
			extendedData.put(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.SECOND_PREVIOUS_EVENT,end);
			request.setExtendedData(extendedData);
		}
		//add a param if we must replace an event of the execution specification
		OccurrenceSpecification os = displayEvent.getActionExecutionSpecificationEvent(getHostFigure().getParent().getParent(), ((CreateRequest) request).getLocation());
		if (os != null) {
			Map<String, Object> extendedData = request.getExtendedData();
			extendedData.put(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.MESSAGE_RECEIVEEVENT_REPLACE_EXECUTIONEVENT, os);
			request.setExtendedData(extendedData);
		}
		//
		// in the case of a create message
		//  the target of the message is translated in Y to the position Y of the message
		if(request.getConnectionViewAndElementDescriptor().getSemanticHint().equals(UMLDIElementTypes.MESSAGE_CREATE_EDGE.getSemanticHint())){
			Rectangle relativePt=new Rectangle(0,request.getLocation().y,0,0);
			getHostFigure().getParent().translateToRelative(relativePt);
			NodeEditPart nodeEP=(NodeEditPart)request.getTargetEditPart();

			Bounds bounds=((Bounds)((Node)nodeEP.getModel()).getLayoutConstraint());

			SetBoundsCommand setBoundsCommand=new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update column", new EObjectAdapter( ((GraphicalEditPart)nodeEP).getNotationView()),
					new Point(bounds.getX(),relativePt.y ));
			CompoundCommand compoundCommand= new CompoundCommand();
			compoundCommand.add(cmd);
			compoundCommand.add(new GMFtoGEFCommandWrapper(setBoundsCommand));
			return compoundCommand;
		}
		if(request.getConnectionViewAndElementDescriptor().getSemanticHint().equals(UMLDIElementTypes.MESSAGE_DELETE_EDGE.getSemanticHint())){
			Rectangle relativePt=new Rectangle(request.getLocation().x,request.getLocation().y,0,0);
			getHostFigure().getParent().translateToRelative(relativePt);
			DropDestructionOccurenceSpecification dropDestructionOccurenceSpecification= new DropDestructionOccurenceSpecification(getDiagramEditPart(getHost()).getEditingDomain(), request, (NodeEditPart)request.getTargetEditPart(),relativePt.getTopLeft());
			CompoundCommand compoundCommand= new CompoundCommand();
			compoundCommand.add(cmd);
			compoundCommand.add(new EMFtoGEFCommandWrapper(dropDestructionOccurenceSpecification));
			return compoundCommand;
		}

		if(request.getConnectionViewAndElementDescriptor().getSemanticHint().equals(UMLDIElementTypes.MESSAGE_ASYNCH_EDGE.getSemanticHint()) ||
				request.getConnectionViewAndElementDescriptor().getSemanticHint().equals(UMLDIElementTypes.MESSAGE_SYNCH_EDGE.getSemanticHint())) {
			// in the case of messages of sort: synchCall, asynchCall or asynchSignal
			// an execution specification may be created at target
			DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
			GridManagementEditPolicy grid=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
			grid.setMoveAllLinesAtSamePosition(false);

			CreateExecutionSpecificationWithMessage createExecutionSpecificationwithMsg= new CreateExecutionSpecificationWithMessage(getDiagramEditPart(getHost()).getEditingDomain(), request, (NodeEditPart)request.getTargetEditPart());
			CompoundCommand compoundCommand= new CompoundCommand();
			compoundCommand.add(cmd);
			compoundCommand.add(new EMFtoGEFCommandWrapper(createExecutionSpecificationwithMsg));
			return compoundCommand;
		}

		if(request.getConnectionViewAndElementDescriptor().getSemanticHint().equals(UMLDIElementTypes.MESSAGE_FOUND_EDGE.getSemanticHint())){
			// in the case of the found message, because the serialization is very specific , we must call basic editpolicy of GMF
			// so we create an new instance of the GraphicalNode editpolicy and we delegate the operation.
			return getBasicGraphicalNodeEditPolicy().getCommand(request);
		}


		return cmd;
	}


	protected GraphicalNodeEditPolicy getBasicGraphicalNodeEditPolicy() {
		if( graphicalNodeEditPolicy==null){
			graphicalNodeEditPolicy =new GraphicalNodeEditPolicy();
			graphicalNodeEditPolicy.setHost(getHost());
		}
		return graphicalNodeEditPolicy;
	}

	protected Command getReconnectSourceCommand(final ReconnectRequest request) {
		return getBasicGraphicalNodeEditPolicy().getCommand(request);
	}


	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return getBasicGraphicalNodeEditPolicy().getCommand(request);
	}

	/**
	 * This method must look for event that are upper than the given position
	 * @param point
	 */
	public MessageEnd getPreviousEventFromPosition(Point point){
		DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
		MessageEnd previous= null;
		LifelineEditPart lifelineEditPart= (LifelineEditPart)getHost();
		Lifeline lifeline=(Lifeline) lifelineEditPart.resolveSemanticElement();
		try{
			GridManagementEditPolicy grilling=(GridManagementEditPolicy)diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRILLING_MANAGEMENT);
			if(grilling!=null) {
				for (DecorationNode row : grilling.rows) {
					Point currentPoint=GridManagementEditPolicy.getLocation(row);
					if( currentPoint.y<point.y){
						if( GridManagementEditPolicy.getRef(row)!=null){
							for ( EObject referedElement : GridManagementEditPolicy.getRef(row)) {
								if( referedElement instanceof View && ((View)referedElement).getElement() instanceof Message){
									Message message=(Message)((View)referedElement).getElement();
									MessageEnd receiveEvent=message.getReceiveEvent();
									if(lifeline.getCoveredBys().contains(receiveEvent) ){
										previous=receiveEvent;
									}
									MessageEnd sendEvent=message.getSendEvent();
									if(lifeline.getCoveredBys().contains(sendEvent) ){
										previous=sendEvent;
									}
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
		}
		return previous;
	}



	/**
	 * This method update the request in order to make the point at the correct position on the grill.
	 * @param request the request 
	 * @param wanted the position has we want in the serialization
	 */
	protected  void computeTargetPosition(CreateConnectionRequest request, PrecisionPoint wanted){

		ConnectionAnchor anchor = ((NodeEditPart)request.getTargetEditPart()).getTargetConnectionAnchor(request);
		if( anchor instanceof AnchorHelper.InnerPointAnchor){
			PrecisionPoint resultedPoint = BaseSlidableAnchor.parseTerminalString(((AnchorHelper.InnerPointAnchor)anchor).getTerminal());
			while (resultedPoint.getDistance(wanted)>2 ){
				Point original= request.getLocation().getCopy();
				PrecisionPoint diff=new PrecisionPoint(original.x-resultedPoint.x,original.y- resultedPoint.y);
				PrecisionRectangle ptOnScreen=new PrecisionRectangle( resultedPoint.x,  resultedPoint.y,0,0);
				SimpleSnapHelper.snapAPoint(ptOnScreen, getHost().getRoot());
				PrecisionPoint Result=new PrecisionPoint(ptOnScreen.x+diff.x, ptOnScreen.y+diff.y);
				request.setLocation(Result);
				anchor = ((NodeEditPart)request.getTargetEditPart()).getTargetConnectionAnchor(request);
				resultedPoint = BaseSlidableAnchor.parseTerminalString(((AnchorHelper.InnerPointAnchor)anchor).getTerminal());
			}
		}
	}


	/**
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getFeedbackHelper(org.eclipse.gef.requests.CreateConnectionRequest)
	 * This method is used in order to manage the snap to grid of LOST Message
	 */

	protected FeedbackHelper getFeedbackHelper(CreateConnectionRequest request) {
		if(request.getTargetEditPart() instanceof NodeEditPart ){
			ConnectionAnchor targetAnchor = ((NodeEditPart)request.getTargetEditPart()).getTargetConnectionAnchor(request);
			if(DiagramEditPartsUtil.isSnapToGridActive(getHost())){
				//This part is very peculiar for lost and found message because the anchor is not standard.
				if( targetAnchor instanceof AnchorHelper.InnerPointAnchor){
					PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(((AnchorHelper.InnerPointAnchor)targetAnchor).getTerminal());
					PrecisionRectangle ptOnScreen=new PrecisionRectangle(pt.x,  pt.y,0,0);
					SimpleSnapHelper.snapAPoint(ptOnScreen,getHost().getRoot());
					computeTargetPosition(request, new PrecisionPoint(ptOnScreen.x, ptOnScreen.y));
				}

			}
		}

		return super.getFeedbackHelper(request);
	}

}
