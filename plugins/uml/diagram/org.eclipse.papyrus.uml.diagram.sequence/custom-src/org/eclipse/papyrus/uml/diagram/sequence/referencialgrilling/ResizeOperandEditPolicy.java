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

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.command.SetLocationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.SetResizeAndLocationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.SetResizeCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CCombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CInteractionOperandEditPart;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;


/**
 * This class is used to allow the resize and adding of children of the combined Fragment
 *
 */
public class ResizeOperandEditPolicy extends GraphicalEditPolicy  implements AutomaticNotationEditPolicy, NotificationListener{
	

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
		getDiagramEventBroker().addNotificationListener(((EObject)getHost().getModel()), this);
	}
	
	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(((EObject)getHost().getModel()), this);
		super.activate();
	}
	/* Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = getEditingDomain();
		if (null != theEditingDomain) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}
	/**
	 * Factors incoming requests into various specific methods.
	 * 
	 * @see org.eclipse.gef.EditPolicy#getCommand(Request)
	 */
	public Command getCommand(Request request) {
		if( request instanceof CreateViewAndElementRequest){
			CreateViewAndElementRequest req=(CreateViewAndElementRequest)request;
			ViewAndElementDescriptor descriptor=(req).getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.INTERACTION_OPERAND_SHAPE)){
				Node combinedFragmentNode = (Node)((GraphicalEditPart)(getHost().getParent())).getNotationView();
				//we add a new Operand so we add the default height
				int height=((Bounds)combinedFragmentNode.getLayoutConstraint()).getHeight();
				if( getHost().getChildren().size()>0) {
				int newHeight = height+CInteractionOperandEditPart.DEFAULT_HEIGHT;
				
				return new ICommandProxy(new SetResizeCommand(getEditingDomain(), "set dimension", new EObjectAdapter(combinedFragmentNode), new Dimension(BoundForEditPart.getWidthFromView(combinedFragmentNode), (int)newHeight)));
				}
			}
		}
		if( RequestConstants.REQ_RESIZE_CHILDREN.equals(request.getType())){
			CompositeCommand compositeCommand= new CompositeCommand("Resize Operands");
			ChangeBoundsRequest changeBoundsRequest=(ChangeBoundsRequest)request;
			List<?> editParts =changeBoundsRequest.getEditParts();
			// the user can resize only one InteractionOperand
			if( editParts.size()>1){
				return null;
			}

			TransactionalEditingDomain editingDomain = getEditingDomain();

			Object currentEditPart= editParts.get(0);
			if(changeBoundsRequest.getMoveDelta().y==0){
				if( currentEditPart instanceof GraphicalEditPart){
					if( istheFirstDisplayedOperand((GraphicalEditPart)currentEditPart)){
						compositeCommand.add( new SetLocationCommand(editingDomain, "Set Position of the first operand", new EObjectAdapter(((GraphicalEditPart) currentEditPart).getNotationView()), new Point(0,0)));
					}
					//update the current Node
					updateCurrentChildSize(compositeCommand, changeBoundsRequest, editingDomain, currentEditPart);

					//update the combinedfragment if this the last
					if( istheLastDisplayedOperand((GraphicalEditPart)currentEditPart)){
						compositeCommand.add(getResizeCompartmentCommand(changeBoundsRequest));
					}
					else{
						//update the next view if this is not the last
						View nextView=getNextView((GraphicalEditPart)currentEditPart);
						Dimension size= new Dimension(BoundForEditPart.getWidthFromView((Node)nextView), BoundForEditPart.getHeightFromView((Node)nextView));
						size.expand(changeBoundsRequest.getSizeDelta().width*-1, changeBoundsRequest.getSizeDelta().height*-1);
						Point locationNext=new Point(((Bounds)((Node)nextView).getLayoutConstraint()).getX(),((Bounds)((Node)nextView).getLayoutConstraint()).getY());
						locationNext.y=locationNext.y+ changeBoundsRequest.getSizeDelta().height;
						ICommand setBoundsCommand= new SetResizeAndLocationCommand(editingDomain, "Resize Operands", new EObjectAdapter(nextView), new Rectangle (locationNext,size));
						compositeCommand.add(setBoundsCommand);
					}
				}
			}
			else if(changeBoundsRequest.getMoveDelta().y!=0){
				if( currentEditPart instanceof GraphicalEditPart){
					updateCurrentChildSize(compositeCommand, changeBoundsRequest, editingDomain, currentEditPart);
				}
				if( istheFirstDisplayedOperand((GraphicalEditPart)currentEditPart)){
					compositeCommand.add(getMoveCompartmentCommand(changeBoundsRequest));
					compositeCommand.add( new SetLocationCommand(editingDomain, "Resize Operands", new EObjectAdapter(((GraphicalEditPart) currentEditPart).getNotationView()), new Point(0,0)));
					for(int i=1;i<getHost().getChildren().size();i++) {
						GraphicalEditPart graphicalEditPart= (GraphicalEditPart)getHost().getChildren().get(i);
						int y=((Bounds)((Node)graphicalEditPart.getNotationView()).getLayoutConstraint()).getY()-changeBoundsRequest.getMoveDelta().y;
						compositeCommand.add( new SetLocationCommand(editingDomain, "Resize Operands", new EObjectAdapter(((Node)graphicalEditPart.getNotationView())), new Point(0,y)));
					}
					
				}
				else{
					//update the previous view if this is not the last
					View previousView=getPreviousView((GraphicalEditPart)currentEditPart);
					Dimension size= new Dimension(BoundForEditPart.getWidthFromView((Node)previousView), BoundForEditPart.getHeightFromView((Node)previousView));
					size.expand(changeBoundsRequest.getSizeDelta().width*-1, changeBoundsRequest.getSizeDelta().height*-1);
					ICommand setBoundsCommand= new SetResizeCommand(editingDomain, "Resize Operands", new EObjectAdapter(previousView), size);
					compositeCommand.add(setBoundsCommand);
				}
			}
			return new ICommandProxy(compositeCommand);
		}
		return null;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return editingDomain;
	}

	private void updateCurrentChildSize(CompositeCommand compositeCommand, ChangeBoundsRequest changeBoundsRequest, TransactionalEditingDomain editingDomain, Object currentEditPart) {
		Node shapeView=(Node)((GraphicalEditPart)currentEditPart).getNotationView();
		Dimension size= new Dimension(BoundForEditPart.getWidthFromView(shapeView), BoundForEditPart.getHeightFromView(shapeView));
		size.expand(changeBoundsRequest.getSizeDelta().width, changeBoundsRequest.getSizeDelta().height);
		Point location= new Point(0,((Bounds)shapeView.getLayoutConstraint()).getY()+changeBoundsRequest.getMoveDelta().y);
		Rectangle rect= new Rectangle(location, size);
		ICommand setBoundsCommand= new SetResizeAndLocationCommand(editingDomain, "Resize Operands", new EObjectAdapter(shapeView), rect);
		compositeCommand.add(setBoundsCommand);
	}

	/**
	 * 
	 * @param operandEditPart
	 * @return true if this the last children of the compartment.
	 */
	protected boolean istheLastDisplayedOperand(GraphicalEditPart operandEditPart){
		View operandView=operandEditPart.getNotationView();
		int index=((View)operandView.eContainer()).getChildren().indexOf(operandView);
		int listSize=((View)operandView.eContainer()).getChildren().size();
		return index==listSize-1;
	}
	/**
	 * 
	 * @param operandEditPart
	 * @return true if this the first children of the compartment.
	 */
	protected boolean istheFirstDisplayedOperand(GraphicalEditPart operandEditPart){
		View operandView=operandEditPart.getNotationView();
		int index=((View)operandView.eContainer()).getChildren().indexOf(operandView);
		return index==0;
	}

	/** get the next view at the same level at the current editPart
	 * 
	 * @param operandEditPart
	 * @return can return null if this the last;
	 */
	protected View getNextView(GraphicalEditPart operandEditPart){
		View operandView=operandEditPart.getNotationView();
		int index=((View)operandView.eContainer()).getChildren().indexOf(operandView);
		int listSize=((View)operandView.eContainer()).getChildren().size();
		if( index+1<listSize){
			return 	(View)	((View)operandView.eContainer()).getChildren().get(index+1);
		}
		return null;
	}

	/** get the previous view at the same level at the current editPart
	 * 
	 * @param operandEditPart
	 * @return can return null if this the last;
	 */
	protected View getPreviousView(GraphicalEditPart operandEditPart){
		View operandView=operandEditPart.getNotationView();
		int index=((View)operandView.eContainer()).getChildren().indexOf(operandView);
		if( index-1>=0){
			return 	(View)	((View)operandView.eContainer()).getChildren().get(index-1);
		}
		return null;
	}
	/**
	 * the border effect is to resize the combined fragment
	 * @param changeBoundsRequest
	 * @return a command to to resize the combinedfragment
	 */
	protected ICommand getResizeCompartmentCommand(ChangeBoundsRequest changeBoundsRequest){
		TransactionalEditingDomain editingDomain = getEditingDomain();
		Node combinedFragmentNode = (Node)((GraphicalEditPart)(getHost().getParent())).getNotationView();
		int combinedFragmentHeight=BoundForEditPart.getHeightFromView(combinedFragmentNode);
		int newHeight = getComputedCombinedFragmentHeight()+changeBoundsRequest.getSizeDelta().height;
		if(newHeight!=combinedFragmentHeight){
			return new SetResizeCommand(editingDomain, "Resize Operands", new EObjectAdapter(combinedFragmentNode), new Dimension(BoundForEditPart.getWidthFromView(combinedFragmentNode), (int)newHeight));
		}
		return IdentityCommand.INSTANCE;
	}
	
	/**
	 * the border effect is to move the combined fragment
	 * @param changeBoundsRequest
	 * @return a command to to resize the combinedfragment
	 */
	protected ICommand getMoveCompartmentCommand(ChangeBoundsRequest changeBoundsRequest){
		TransactionalEditingDomain editingDomain = getEditingDomain();
		//1 get all children size  
		Node combinedFragmentNode = (Node)((GraphicalEditPart)(getHost().getParent())).getNotationView();
		int newHeight = getComputedCombinedFragmentHeight()+changeBoundsRequest.getSizeDelta().height;
		
		int combinedFragmentHeight=BoundForEditPart.getHeightFromView(combinedFragmentNode);
		Bounds combinedFragmentBound=BoundForEditPart.getBounds(combinedFragmentNode);
		int newY= combinedFragmentBound.getY()+changeBoundsRequest.getMoveDelta().y;
		
		if(newHeight!=combinedFragmentHeight){
			return new SetResizeAndLocationCommand(editingDomain, "Resize Operands", new EObjectAdapter(combinedFragmentNode), new Rectangle( combinedFragmentBound.getX(),newY,BoundForEditPart.getWidthFromView(combinedFragmentNode), (int)newHeight));
		}
		return IdentityCommand.INSTANCE;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void notifyChanged(Notification notification) {
		if( notification.getEventType()==Notification.REMOVE && (notification.getNotifier().equals(getHost().getModel()))){
			//1 get all children size  
			Node combinedFragmentNode = (Node)((GraphicalEditPart)(getHost().getParent())).getNotationView();
			int newHeight = getComputedCombinedFragmentHeight();
			int combinedFragmentHeight=BoundForEditPart.getHeightFromView(combinedFragmentNode);
			if(newHeight!=combinedFragmentHeight){
				execute(new SetResizeCommand(getEditingDomain(), "Resize Operands", new EObjectAdapter(combinedFragmentNode), new Dimension(BoundForEditPart.getWidthFromView(combinedFragmentNode), (int)newHeight)));
			}
		}
	}

	/**
	 * 
	 * @return the height of the combined fragment by computing the size of interaction operand
	 */
	protected int getComputedCombinedFragmentHeight() {
		double childrenCumulativeHeight = getOperandCumulativeHeight();
		
		//add the size of the label
		int newHeight= (int)childrenCumulativeHeight+CCombinedFragmentEditPart.DEFAULT_HEIGHT-CInteractionOperandEditPart.DEFAULT_HEIGHT;
		//there is a minimum size
		if( newHeight<CCombinedFragmentEditPart.DEFAULT_HEIGHT){
			newHeight= CCombinedFragmentEditPart.DEFAULT_HEIGHT;
		}
		return newHeight;
	}

	/**@return the Height of all interaction operand inside the compartment
	 * **/
	protected double getOperandCumulativeHeight() {
		Node compartmentNode=(Node)((GraphicalEditPart)(getHost())).getNotationView();
		double childrenCumulativeHeight =0.0;
		for (Iterator<?> iterator = compartmentNode.getChildren().iterator(); iterator.hasNext();) {
			Node childView = (Node) iterator.next();
			childrenCumulativeHeight= childrenCumulativeHeight+BoundForEditPart.getHeightFromView(childView);
		}
		return childrenCumulativeHeight;
	}
	
}
