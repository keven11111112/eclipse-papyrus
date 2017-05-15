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

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * this class is used to display event of messages or event of execution specifications
 *
 */
public class DisplayEvent {

	private EditPart editpart;
	/**
	 * Constructor.
	 *
	 */
	public DisplayEvent(EditPart editpart) {
		this.editpart= editpart;
	}
	public class EventFig extends Ellipse implements IEventFig{

	}
	/**
	 * if the position is the same a an event it return the event.
	 * @param container the figure container
	 * @param locationOntheScreen
	 * @return the event under the position
	 */
	public MessageOccurrenceSpecification getMessageEvent(IFigure container, Point locationOntheScreen){
		Point LocationAbsolute= locationOntheScreen.getCopy();
		IFigure editPartFigure=((GraphicalEditPart)editpart).getFigure();
		editPartFigure.getParent().translateToRelative(LocationAbsolute);
		Rectangle recLoacal=new Rectangle(50,200,100,100);

		IFigure fig=editPartFigure;
		Point ptOnscreen=recLoacal.getTopLeft().translate(fig.getBounds().getTopLeft());
		fig.getParent().translateToAbsolute(ptOnscreen);

		//display all events from messages
		Node node=(Node)editpart.getModel();
		@SuppressWarnings("unchecked")
		java.util.List<Edge> sourceEdge= node.getSourceEdges();
		for (Edge edge : sourceEdge) {
			MessageOccurrenceSpecification m=getMessageEvent((NodeEditPart)editpart, node, edge, LocationAbsolute);
			if(m!=null){
				return m;
			}
		}
		@SuppressWarnings("unchecked")
		java.util.List<Edge> targetEdge= node.getTargetEdges();
		for (Edge edge : targetEdge) {
			MessageOccurrenceSpecification m=getMessageEvent((NodeEditPart)editpart, node, edge, LocationAbsolute);
			if(m!=null){
				return m;
			}
		}

		return null;

	}
	/**
	 * if the position is the same a an event it return the event.
	 * @param container the figure container
	 * @param locationOntheScreen
	 * @return the event under the position
	 */
	public OccurrenceSpecification getActionExecutionSpecificationEvent(IFigure container, Point locationOntheScreen){
		Point LocationAbsolute= locationOntheScreen.getCopy();
		IFigure editPartFigure=((GraphicalEditPart)editpart).getFigure();
		editPartFigure.getParent().translateToRelative(LocationAbsolute);
		Rectangle recLoacal=new Rectangle(50,200,100,100);

		IFigure fig=editPartFigure;
		Point ptOnscreen=recLoacal.getTopLeft().translate(fig.getBounds().getTopLeft());
		fig.getParent().translateToAbsolute(ptOnscreen);

		//display all events from messages
		Node node=(Node)editpart.getModel();

		for (Object part : editpart.getChildren()) {
			if(part instanceof AbstractExecutionSpecificationEditPart) {
				OccurrenceSpecification occurrenceSpecification=getEventFromExecutionSpecification((NodeEditPart)editpart, (AbstractExecutionSpecificationEditPart)part, LocationAbsolute);
				if (occurrenceSpecification!=null) {
					return occurrenceSpecification;
				}
			}

		}
		return null;

	} 

	/**
	 * @param lifelinedEditPArt
	 * @param part the execution specification editpart
	 * @param locationAbsolute the position of the mouse
	 */
	protected OccurrenceSpecification getEventFromExecutionSpecification(NodeEditPart lifelineEditPart, AbstractExecutionSpecificationEditPart executionSpecEditPart, Point locationAbsolute) {
		Node executionNode=(Node)	executionSpecEditPart.getNotationView();
		ExecutionSpecification executionSpecification= (ExecutionSpecification)executionSpecEditPart.resolveSemanticElement();
		IFigure lifelineFigure= lifelineEditPart.getFigure();
		double y=((Bounds)executionNode.getLayoutConstraint()).getY();
		if(lifelineFigure.getBounds().y+(int)y-8<locationAbsolute.y() &&locationAbsolute.y()<lifelineFigure.getBounds().y+(int)y+8){
			return executionSpecification.getStart();
		}

		y=((Bounds)executionNode.getLayoutConstraint()).getY()+BoundForEditPart.getHeightFromView(executionNode);
		if(lifelineFigure.getBounds().y+(int)y-8<locationAbsolute.y() &&locationAbsolute.y()<lifelineFigure.getBounds().y+(int)y+8){
			return executionSpecification.getFinish();
		}
		return null;
	}

	/**
	 * 
	 * @param container the container edipart
	 * @param node the node where edge are connected
	 * @param edge the current edge
	 * @param currentPosition the position of the mouse
	 * @return
	 */
	protected MessageOccurrenceSpecification getMessageEvent(NodeEditPart container,Node node, Edge edge, Point currentPosition){
		IdentityAnchor anchor=null;
		if (edge.getSource().equals(node)){
			anchor=(IdentityAnchor)edge.getSourceAnchor();
		}
		else{
			anchor=(IdentityAnchor)edge.getTargetAnchor();
		}
		double yPercent=IdentityAnchorHelper.getYPercentage(anchor);

		//calculate  bounds from notation
		double height=BoundForEditPart.getHeightFromView(node);

		double posY=yPercent*height;
		IFigure lifelineFigure=((GraphicalEditPart)editpart).getFigure();
		if(lifelineFigure.getBounds().y+(int)posY-8<currentPosition.y() &&currentPosition.y()<lifelineFigure.getBounds().y+(int)posY+8){
			if( (edge.getElement() instanceof Message)){
				if (anchor==(IdentityAnchor)edge.getSourceAnchor()){
					return (MessageOccurrenceSpecification)((Message)edge.getElement()).getSendEvent();
				}
				else{
					return (MessageOccurrenceSpecification)((Message)edge.getElement()).getReceiveEvent();
				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @param container the figure container where we want display event
	 * @param location position on the screen
	 */
	public void  addFigureEvent(IFigure container, Point locationOntheScreen){
		Point LocationAbsolute= locationOntheScreen.getCopy();
		IFigure editPartFigure=((GraphicalEditPart)editpart).getFigure();
		editPartFigure.getParent().translateToRelative(LocationAbsolute);
		Rectangle recLoacal=new Rectangle(50,200,100,100);

		IFigure fig=editPartFigure;
		Point ptOnscreen=recLoacal.getTopLeft().translate(fig.getBounds().getTopLeft());
		fig.getParent().translateToAbsolute(ptOnscreen);

		//display all events from messages
		Node node=(Node)editpart.getModel();
		@SuppressWarnings("unchecked")
		java.util.List<Edge>  sourceEdge= node.getSourceEdges();
		for (Edge edge : sourceEdge) {
			displayEventFromMessages((NodeEditPart)editpart, node, edge, LocationAbsolute);
		}
		@SuppressWarnings("unchecked")
		java.util.List<Edge> targetEdge= node.getTargetEdges();
		for (Edge edge : targetEdge) {
			displayEventFromMessages((NodeEditPart)editpart, node, edge, LocationAbsolute);
		}

		for (Object part : editpart.getChildren()) {
			if(part instanceof AbstractExecutionSpecificationEditPart) {
				displayEventFromExecutionSpecification((NodeEditPart)editpart, (AbstractExecutionSpecificationEditPart)part, LocationAbsolute);
			}

		}

	}

	/**
	 * @param lifelineEditPart the lifeline editpart
	 * @param executionSpecEditPart the execution specification 
	 * @param locationAbsolute the position of the mouse
	 */
	protected void displayEventFromExecutionSpecification(NodeEditPart lifelineEditPart, AbstractExecutionSpecificationEditPart executionSpecEditPart, Point locationAbsolute) {
		Node executionNode=(Node)	executionSpecEditPart.getNotationView();
		double posY=((Bounds)executionNode.getLayoutConstraint()).getY();
		addAnEvent(lifelineEditPart.getFigure(), posY, ColorConstants.white, locationAbsolute);
		posY=((Bounds)executionNode.getLayoutConstraint()).getY()+BoundForEditPart.getHeightFromView(executionNode);
		addAnEvent(lifelineEditPart.getFigure(), posY, ColorConstants.white, locationAbsolute);
	}

	/**
	 * 
	 * @param container the container editpart
	 * @param node the node where is connected the edge
	 * @param edge the edge where want to display anchor
	 * @param CurrentPosition the position of the mouse
	 */
	protected void displayEventFromMessages(NodeEditPart container,Node node, Edge edge, Point currentPosition){
		IdentityAnchor anchor=null;
		if (edge.getSource().equals(node)){
			anchor=(IdentityAnchor)edge.getSourceAnchor();
		}
		else{
			anchor=(IdentityAnchor)edge.getTargetAnchor();
		}
		double yPercent=IdentityAnchorHelper.getYPercentage(anchor);

		//calculate  bounds from notation
		double height=0;
		height=BoundForEditPart.getHeightFromView(node);

		double posY=yPercent*height;
		addAnEvent(container.getFigure(), posY, ColorConstants.white, currentPosition);



	}

	/**
	 * @param container the figure container that will contain the event
	 * @param y the location to display the event
	 * @param color the color of the event 
	 * @param currentPosition the current position of the mouse to know if we display in green
	 */
	protected void addAnEvent(IFigure container, double y, Color color, Point currentPosition) {
		EventFig ellipseFigure= new EventFig();
		IFigure lifelineFigure=((GraphicalEditPart)editpart).getFigure();
		//code without grid

		//calculate position of the Event in the screen references
		PrecisionRectangle EventBoundsOnScreen= new PrecisionRectangle(lifelineFigure.getBounds().x+lifelineFigure.getBounds().width/2-8,lifelineFigure.getBounds().y+(int)y-8,16,16);
		if(lifelineFigure.getBounds().y+(int)y-8<currentPosition.y() &&currentPosition.y()<lifelineFigure.getBounds().y+(int)y+8){
			ellipseFigure.setBackgroundColor(ColorConstants.green);
		}
		else{
			ellipseFigure.setBackgroundColor(color);
		}
		ellipseFigure.setLineWidth(2);
		ellipseFigure.setBounds(EventBoundsOnScreen);
		container.add(ellipseFigure);
	}

	/**
	 * use to remove all event from the figures
	 * @param container the container figure
	 */
	public void  removeFigureEvent(IFigure container){
		ArrayList<IFigure> eventFigureList=new ArrayList<IFigure>();
		for (Object iFigure : container.getChildren()) {
			if( iFigure instanceof IEventFig){
				eventFigureList.add((IFigure)iFigure);
			}
		}
		for (Iterator<IFigure> iterator = eventFigureList.iterator(); iterator.hasNext();) {
			IFigure iFigure = iterator.next();
			container.remove(iFigure);
		}
	}

}
