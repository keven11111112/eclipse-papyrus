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

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ViewDescriptorUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CLifeLineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Element;

/**
 * This class is used to manage node element in the compartment by using grill system.
 *
 */
public class GrillingBasedXYLayoutEditPolicy extends XYLayoutWithConstrainedResizedEditPolicy implements IGrillingEditpolicy{



	/**
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		// Used during the drop from the model explorer
		if( request instanceof CreateViewAndElementRequest){
			DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
			GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
			if (grilling!=null){
				grilling.setRespectMargin(false);

			}

		}
		if( request instanceof CreateViewAndElementRequest){
			CreateViewAndElementRequest req=(CreateViewAndElementRequest)request;
			ViewAndElementDescriptor descriptor=(req).getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.COMBINED_FRAGMENT_SHAPE)){
				System.out.println("toto");
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
		////		if( constraint instanceof Rectangle){
		////			DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
		////			GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
		////			if( request instanceof CreateViewAndElementRequest){
		//				String semanticHint=((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getSemanticHint();
		////				if (grilling!=null&&semanticHint!=null){
		////					View row=null;
		////					// do let the user place where he want the life line at the creation
		//					if(semanticHint.equals(LifelineEditPart.VISUAL_ID)){
		////						row=grilling.getRowTolisten(grilling.firstY);
		////						Location boundsRow=(Location)	((Node)row).getLayoutConstraint();
		////						if( boundsRow!=null){
		////							((Rectangle)constraint).setY(boundsRow.getY());
		////							if( request.isSnapToEnabled()){
		////								snapAPoint(((Rectangle)constraint));
		////							}
		////							
		////						}
		////					}
		////
		////				}
		////			}
		////		}
		//
		//		if ( LayoutHelper.UNDEFINED.getLocation().equals(request.getLocation()) ){	
		//			Rectangle rect = (Rectangle)constraint;
		//			rect.setLocation(10,10);
		//			return rect;	
		//		}
		return constraint;	
	}
	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#showLayoutTargetFeedback(org.eclipse.gef.Request)
	 *
	 * @param request
	 */
	@Override
	protected void showLayoutTargetFeedback(Request request) {
		super.showLayoutTargetFeedback(request);
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
		DiagramEditPart diagramEditPart=getDiagramEditPart(getHost());
		GrillingManagementEditPolicy grilling=(GrillingManagementEditPolicy)diagramEditPart.getEditPolicy(GrillingManagementEditPolicy.GRILLING_MANAGEMENT);
		if (grilling!=null){
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
			ICommand boundsCommand = 
					new SetBoundsCommand(editingDomain,
							DiagramUIMessages.SetLocationCommand_Label_Resize,
							new EObjectAdapter(shapeView),
							newBounds); 

			CompoundCommand compoundCommand= new CompoundCommand();
			compoundCommand.add( new ICommandProxy(boundsCommand));
			return compoundCommand;
		}

		return super.createChangeConstraintCommand(child, constraint);
	}



}
