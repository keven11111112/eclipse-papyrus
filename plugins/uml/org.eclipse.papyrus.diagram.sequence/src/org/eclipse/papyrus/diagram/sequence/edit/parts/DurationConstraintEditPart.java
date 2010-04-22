/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.diagram.common.draw2d.LinesBorder;
import org.eclipse.papyrus.diagram.sequence.edit.policies.DurationConstraintItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.TimeRelatedSelectionEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class DurationConstraintEditPart extends

AbstractBorderItemEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3021;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public DurationConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DurationConstraintItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * This method creates a specific edit policy for time realted elements
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#getPrimaryDragEditPolicy()
	 * 
	 * @return <code>EditPolicy</code>
	 * @generated NOT
	 */
	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new TimeRelatedSelectionEditPolicy();
	}


	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		DurationConstraintFigure figure = new DurationConstraintFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public DurationConstraintFigure getPrimaryShape() {
		return (DurationConstraintFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof DurationConstraintLabelEditPart) {
			((DurationConstraintLabelEditPart)childEditPart).setLabel(getPrimaryShape().getDurationConstraintLabel());
			return true;
		}


		return false;
	}


	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof DurationConstraintLabelEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}


	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(-1, -1);

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}


	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(DurationConstraintLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Comment_3009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Continuation_3016);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.StateInvariant_3017);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.CombinedFragment_3018);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.TimeObservation_3020);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.DestructionEvent_3022);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4010) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.TimeConstraint_3019);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.DurationConstraint_3021);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		return types;
	}





	/**
	 * @generated
	 */
	public class DurationConstraintFigure extends RectangleFigure {

		/**
		 * Height of the arrow end
		 * 
		 * @generated NOT
		 */
		private static final int ARROW_HEIGHT = 8;

		/**
		 * Width of the half of the arrow end
		 * 
		 * @generated NOT
		 */
		private static final int ARROW_SEMI_WIDTH = 7;

		/**
		 * @generated
		 */
		private Polyline fDurationArrow;

		/**
		 * @generated
		 */
		private WrappingLabel fDurationConstraintLabel;


		/**
		 * @generated
		 */
		public DurationConstraintFigure() {

			CenterLayout layoutThis = new CenterLayout();


			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(40), getMapMode().DPtoLP(-1)));
			this.setBorder(createBorder0());
			createContents();
		}

		/**
		 * Sets the bounds of this Figure to the Rectangle <i>rect</i>.
		 * This also updates sub-figures.
		 * 
		 * @see Figure#setBounds(Rectangle)
		 * @param rect
		 *        The new bounds
		 * @generated NOT
		 */
		public void setBounds(Rectangle rect) {
			updateArrow(rect.width, rect.height);
			super.setBounds(rect);
		}

		/**
		 * Update the arrow polyline taking in account new figure's size
		 * 
		 * @param figureWidth
		 *        the new figure width
		 * @param figureHeight
		 *        the new figure height
		 * @generated NOT
		 */
		public void updateArrow(int figureWidth, int figureHeight) {
			// handle insets to avoid figure growing indefinitely
			figureWidth -= getInsets().left + getInsets().right;
			figureHeight -= getInsets().top + getInsets().bottom;
			if(getDurationArrow() != null) {
				PointList points = new PointList(8);
				points.addPoint(figureWidth / 2 - ARROW_SEMI_WIDTH, getLineWidth() / 2 + ARROW_HEIGHT);
				points.addPoint(figureWidth / 2, getLineWidth() / 2);
				points.addPoint(figureWidth / 2 + ARROW_SEMI_WIDTH, getLineWidth() / 2 + ARROW_HEIGHT);
				points.addPoint(figureWidth / 2, getLineWidth() / 2);
				points.addPoint(figureWidth / 2, figureHeight - getLineWidth());
				points.addPoint(figureWidth / 2 - ARROW_SEMI_WIDTH, figureHeight - getLineWidth() * 2 - ARROW_HEIGHT);
				points.addPoint(figureWidth / 2, figureHeight - getLineWidth() * 2);
				points.addPoint(figureWidth / 2 + ARROW_SEMI_WIDTH, figureHeight - getLineWidth() * 2 - ARROW_HEIGHT);
				getDurationArrow().setPoints(points);
			}
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fDurationArrow = new Polyline();
			fDurationArrow.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			fDurationArrow.addPoint(new Point(getMapMode().DPtoLP(10), getMapMode().DPtoLP(0)));
			fDurationArrow.setLineWidth(1);

			this.add(fDurationArrow);



			fDurationConstraintLabel = new WrappingLabel();




			fDurationConstraintLabel.setTextAlignment(PositionConstants.CENTER);




			fDurationConstraintLabel.setAlignment(PositionConstants.CENTER);




			fDurationConstraintLabel.setBackgroundColor(getBackgroundColor());




			fDurationConstraintLabel.setTextWrap(true);




			fDurationConstraintLabel.setTextJustification(PositionConstants.CENTER);



			this.add(fDurationConstraintLabel);


		}

		/**
		 * @generated
		 */
		private Border createBorder0() {
			LinesBorder result = new LinesBorder();




			result.setSides(PositionConstants.TOP | PositionConstants.BOTTOM);



			return result;
		}



		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}



		/**
		 * @generated
		 */
		public Polyline getDurationArrow() {
			return fDurationArrow;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getDurationConstraintLabel() {
			return fDurationConstraintLabel;
		}


	}




	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("DurationConstraint", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("DurationConstraint", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("DurationConstraint", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("DurationConstraint", PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}

		if(result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			return getParent().getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}
}
