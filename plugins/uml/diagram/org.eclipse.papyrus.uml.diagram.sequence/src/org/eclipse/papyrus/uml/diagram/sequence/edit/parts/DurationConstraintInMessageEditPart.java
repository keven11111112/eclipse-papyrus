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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
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
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.DeleteTimeElementWithoutEventPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.DurationConstraintInMessageItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.MoveableNonResizableLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class DurationConstraintInMessageEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3023;

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
	public DurationConstraintInMessageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DurationConstraintInMessageItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ListItemComponentEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new MoveableNonResizableLabelEditPolicy());
		installEditPolicy(DeleteTimeElementWithoutEventPolicy.KEY, new DeleteTimeElementWithoutEventPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case DurationConstraintInMessageAppliedStereotypeEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						@Override
						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
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
		return primaryShape = new DurationObservationConstraint();
	}

	/**
	 * @generated
	 */
	public DurationObservationConstraint getPrimaryShape() {
		return (DurationObservationConstraint) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DurationConstraintInMessageLabelEditPart) {
			((DurationConstraintInMessageLabelEditPart) childEditPart).setLabel(getPrimaryShape().getDurationLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DurationConstraintInMessageLabelEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof DurationConstraintInMessageAppliedStereotypeEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "DurationConstraint";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
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
	@Override
	protected NodeFigure createMainFigure() {
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
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(DurationConstraintInMessageLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(9);
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		types.add(UMLElementTypes.ConstraintContext_8500);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.ConstraintContext_8500);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.ConstraintContext_8500);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.ConstraintContext_8500) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(9);
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
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4010) {
			types.add(UMLElementTypes.Comment_3009);
		} else if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.DurationConstraint_3023);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class DurationObservationConstraint extends WrappingLabel {

		/**
		 * @generated
		 */
		private WrappingLabel fDurationLabel;

		/**
		 * @generated
		 */
		public DurationObservationConstraint() {
			this.setTextWrap(true);
			this.setTextJustification(PositionConstants.CENTER);
			this.setForegroundColor(ColorConstants.black);
			this.setFont(THIS_FONT);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getDurationLabel() {
			return fDurationLabel;
		}
	}

	/**
	 * @generated
	 */
	static final Font THIS_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore) getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;
		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("DurationConstraint", PreferencesConstantsHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("DurationConstraint", PreferencesConstantsHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("DurationConstraint", PreferencesConstantsHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor(preferenceStore, prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferencesConstantsHelper.getElementConstant("DurationConstraint", PreferencesConstantsHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}
		if (result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}
}
