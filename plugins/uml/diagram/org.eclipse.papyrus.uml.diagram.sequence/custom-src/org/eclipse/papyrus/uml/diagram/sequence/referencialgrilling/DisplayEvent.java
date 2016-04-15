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
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CLifeLineEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * @author PT202707
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
	 * @param container
	 * @param locationOntheScreen
	 * @return
	 */
	public MessageOccurrenceSpecification getMessageEvent(IFigure container, Point locationOntheScreen){
		Point LocationAbsolute= locationOntheScreen.getCopy();
		IFigure editPartFigure=((GraphicalEditPart)editpart).getFigure();
		editPartFigure.getParent().translateToRelative(LocationAbsolute);
		Point locationRelativeToLifleLine= locationOntheScreen.getCopy().translate(editPartFigure.getBounds().getTopLeft().negate());
		Rectangle recLoacal=new Rectangle(50,200,100,100);

		IFigure fig=editPartFigure;
		Point ptOnscreen=recLoacal.getTopLeft().translate(fig.getBounds().getTopLeft());
		fig.getParent().translateToAbsolute(ptOnscreen);

		//display all events from messages
		Node node=(Node)editpart.getModel();
		java.util.List<Edge> sourceEdge= node.getSourceEdges();
		for (Edge edge : sourceEdge) {
			MessageOccurrenceSpecification m=getMessageEvent((NodeEditPart)editpart, node, edge, LocationAbsolute);
			if(m!=null){
				return m;
			}
		}
		java.util.List<Edge> targetEdge= node.getTargetEdges();
		for (Edge edge : targetEdge) {
			MessageOccurrenceSpecification m=getMessageEvent((NodeEditPart)editpart, node, edge, LocationAbsolute);
			if(m!=null){
				return m;
			}
		}
		
		return null;

	} 

	public MessageOccurrenceSpecification getMessageEvent(NodeEditPart container,Node node, Edge edge, Point currentPosition){
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
		if(node.getLayoutConstraint() instanceof Bounds){
			height=((Bounds)node.getLayoutConstraint()).getHeight();
		}
		if( height==-1.0){
			//it is very bad , because this is a default valued given by the figure...
			if( editpart instanceof CLifeLineEditPart){
				height=CLifeLineEditPart.DEFAUT_HEIGHT;
			}
		}
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
	 * @param container
	 * @param location position on the screen
	 */
	public void  addFigureEvent(IFigure container, Point locationOntheScreen){
		Point LocationAbsolute= locationOntheScreen.getCopy();
		IFigure editPartFigure=((GraphicalEditPart)editpart).getFigure();
		editPartFigure.getParent().translateToRelative(LocationAbsolute);
		Point locationRelativeToLifleLine= locationOntheScreen.getCopy().translate(editPartFigure.getBounds().getTopLeft().negate());
		Rectangle recLoacal=new Rectangle(50,200,100,100);

		IFigure fig=editPartFigure;
		Point ptOnscreen=recLoacal.getTopLeft().translate(fig.getBounds().getTopLeft());
		System.out.println("Position: "+fig.getBounds()+":"+recLoacal.getTopLeft().translate(fig.getBounds().getTopLeft()));
		fig.getParent().translateToAbsolute(ptOnscreen);


		System.out.println("Shadow position:"+locationOntheScreen+" calulatedPostion (50,200) on screen"+ptOnscreen);

		//display all events from messages
		Node node=(Node)editpart.getModel();
		java.util.List<Edge> sourceEdge= node.getSourceEdges();
		for (Edge edge : sourceEdge) {
			displayEventFromMessages((NodeEditPart)editpart, node, edge, LocationAbsolute);
		}
		java.util.List<Edge> targetEdge= node.getTargetEdges();
		for (Edge edge : targetEdge) {
			displayEventFromMessages((NodeEditPart)editpart, node, edge, LocationAbsolute);
		}

	}

	public void displayEventFromMessages(NodeEditPart container,Node node, Edge edge, Point CurrentPosition){
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
		if(node.getLayoutConstraint() instanceof Bounds){
			height=((Bounds)node.getLayoutConstraint()).getHeight();
		}
		if( height==-1.0){
			//it is very bad , because this is a default valued given by the figure...
			if( editpart instanceof CLifeLineEditPart){
				height=CLifeLineEditPart.DEFAUT_HEIGHT;
			}
		}
		double posY=yPercent*height;
		addAnEvent(container.getFigure(), posY, ColorConstants.white, CurrentPosition);



	}

	/**
	 * @param container
	 * @param location
	 * @param containerBounds
	 * @param ellipseFigure
	 */
	private void addAnEvent(IFigure container, double y, Color color, Point currentPosition) {
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

	public void  removeFigureEvent(IFigure container){
		ArrayList<IFigure> eventFigureList=new ArrayList<IFigure>();
		for (Object iFigure : container.getChildren()) {
			if( iFigure instanceof IEventFig){
				eventFigureList.add((IFigure)iFigure);
			}
		}
		for (Iterator iterator = eventFigureList.iterator(); iterator.hasNext();) {
			IFigure iFigure = (IFigure) iterator.next();
			container.remove(iFigure);
		}
	}

}
