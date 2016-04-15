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

import java.util.Arrays;

import javax.swing.text.StyleConstants.ColorConstants;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.LayoutHelper;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.figure.node.EllipseFigure;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool.CreateAspectUnspecifiedTypeRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CLifeLineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * This class is used to manage node element in the compartment by using grill system.
 *
 */
public class LifeLineXYLayoutEditPolicy extends XYLayoutWithConstrainedResizedEditPolicy implements IGrillingEditpolicy{

	protected DisplayEvent displayEvent;
	/**
	 * Constructor.
	 *
	 */
	public LifeLineXYLayoutEditPolicy() {
		super();

	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#setHost(org.eclipse.gef.EditPart)
	 *
	 * @param host
	 */
	@Override
	public void setHost(EditPart host) {
		// TODO Auto-generated method stub
		super.setHost(host);
		displayEvent= new DisplayEvent(getHost());
	}
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		// Used during the drop from the model explorer
		if( request instanceof CreateViewAndElementRequest){
			CreateViewAndElementRequest req=(CreateViewAndElementRequest)request;
			ViewAndElementDescriptor descriptor=(req).getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE)||
					ElementUtil.isTypeOf(elementType, UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE)){
				// get the element descriptor
				CreateElementRequestAdapter requestAdapter =
						req.getViewAndElementDescriptor().getCreateElementRequestAdapter();
				// get the semantic request
				CreateElementRequest createElementRequest =
						(CreateElementRequest) requestAdapter.getAdapter(
								CreateElementRequest.class);
				View view = (View)getHost().getModel();
				EObject hostElement = ViewUtil.resolveSemanticElement(view);
				createElementRequest.setContainer(hostElement.eContainer());
				createElementRequest.setParameter(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.COVERED, hostElement);
				MessageOccurrenceSpecification mos=displayEvent.getMessageEvent(getHostFigure().getParent().getParent(), ((CreateRequest)request).getLocation());
				if( mos!=null){
					createElementRequest.setParameter(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.REPLACE_EXECUTION_SPECIFICATION_START, mos);
				}
			}
		}
		return super.getCreateCommand(request);
	}
	/* Override to use to deal with causes where the point is UNDERFINED
	 * we will ask the layout helper to find a location for us
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.CreateRequest)
	 */
	protected Object getConstraintFor(CreateRequest request) {
		// Used during the creation from the palette
		Object constraint = super.getConstraintFor(request);
		if(request instanceof CreateViewAndElementRequest){
			CreateViewAndElementRequest req=(CreateViewAndElementRequest)request;
			ViewAndElementDescriptor descriptor=(req).getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE)||
					ElementUtil.isTypeOf(elementType, UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE)){
				Rectangle parentBound=getHostFigure().getBounds();
				if(constraint instanceof Rectangle){
					Rectangle constraintRect= (Rectangle)constraint;
					RootEditPart drep=getHost().getRoot();
					if( drep instanceof DiagramRootEditPart){

						double spacing = ((DiagramRootEditPart)drep).getGridSpacing();
						if( constraintRect.height==-1){
							constraintRect.height=AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT;
						}
						constraintRect.width= AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH;
						constraintRect.x=(parentBound.width/2)-(constraintRect.width/2);
						if(DiagramEditPartsUtil.isSnapToGridActive(getHost())){
							int modulo= AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT/(int)spacing;
							constraintRect.height=modulo*(int)spacing;
						}
					}
				}
			}
		}
		return constraint;	
	}
	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#showLayoutTargetFeedback(org.eclipse.gef.Request)
	 *
	 * @param request
	 */
	@Override
	protected void showLayoutTargetFeedback(Request request) {


		// feed back during the creation from the palette
		RootEditPart drep=getHost().getRoot();
		Rectangle parentBound=getHostFigure().getBounds().getCopy();
		getHostFigure().getParent().translateToAbsolute(parentBound);
		//System.out.println("LifeLineBounds On Screen:"+parentBound);
		if( drep instanceof DiagramRootEditPart){
			double spacing = ((DiagramRootEditPart)drep).getGridSpacing();
			if(request instanceof CreateAspectUnspecifiedTypeRequest){
				IElementType elementType = (IElementType)((CreateAspectUnspecifiedTypeRequest)request).getElementTypes().get(0);
				if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE)||
						ElementUtil.isTypeOf(elementType, UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE)){
					((CreateRequest)request).setLocation(new Point((parentBound.x+(parentBound.width/2)-AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH/2),((CreateRequest)request).getLocation().y));
					int modulo= AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT/(int)spacing;
					((CreateRequest)request).setSize(new Dimension(AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH,modulo*(int)spacing));


					displayEvent.addFigureEvent(getHostFigure().getParent().getParent(), ((CreateRequest)request).getLocation());
				}

			}

			if(request instanceof ChangeBoundsRequest){
				//test
				((ChangeBoundsRequest)request).setMoveDelta(new Point(0, ((ChangeBoundsRequest)request).getMoveDelta().y));
			}
		}

		super.showLayoutTargetFeedback(request);
	}
	/**
	 * @see org.eclipse.gef.editpolicies.GraphicalEditPolicy#addFeedback(org.eclipse.draw2d.IFigure)
	 *
	 * @param figure
	 */
	@Override
	protected void addFeedback(IFigure figure) {
		super.addFeedback(figure);



	}
	/**
	 * @see org.eclipse.gef.editpolicies.GraphicalEditPolicy#removeFeedback(org.eclipse.draw2d.IFigure)
	 *
	 * @param figure
	 */
	@Override
	protected void removeFeedback(IFigure figure) {

		displayEvent.removeFigureEvent(getHostFigure().getParent().getParent());
		super.removeFeedback(figure);

	}

	/** 
	 * Called in response to a <tt>REQ_RESIZE_CHILDREN</tt> request.
	 * 
	 * This implementation creates a <tt>SetPropertyCommand</i> and sets
	 * the <tt>ID_BOUNDS</tt> property value to the supplied constraints.
	 * 
	 * @param child the element being resized.
	 * @param constraint the elements new bounds.
	 * @return {@link SetBoundsCommand}
	 */
	protected Command createChangeConstraintCommand(
			EditPart child,
			Object constraint) {
		Rectangle newBounds = (Rectangle) constraint;
		View shapeView = (View) child.getModel();

		if( child instanceof AbstractExecutionSpecificationEditPart){
			RootEditPart drep=getHost().getRoot();
			if( drep instanceof DiagramRootEditPart){
				double spacing = ((DiagramRootEditPart)drep).getGridSpacing();
				Rectangle parentBound=getHostFigure().getBounds();
				newBounds.setLocation(new Point((parentBound.width/2)-(AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH/2),newBounds.getLocation().y));
				if( newBounds.height==-1){
					newBounds.height=AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT;
				}
				if(DiagramEditPartsUtil.isSnapToGridActive(getHost())){
					int modulo= newBounds.height/(int)spacing;
					newBounds.setSize(new Dimension(AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH,modulo*(int)spacing));
				}

			}
		}

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		ICommand boundsCommand = 
				new SetBoundsCommand(editingDomain,
						DiagramUIMessages.SetLocationCommand_Label_Resize,
						new EObjectAdapter(shapeView),
						newBounds); 
		CompoundCommand compoundCommand= new CompoundCommand();
		compoundCommand.add( new ICommandProxy(boundsCommand));

		return compoundCommand;
	}




}
