/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OutputPinInValSpecActItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class OutputPinInValSpecActEditPart extends

BorderedBorderItemEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3077;

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
	public OutputPinInValSpecActEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OutputPinInValSpecActItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}





	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case OutputPinInValSpecActLabelEditPart.VISUAL_ID:
				case OutputPinInValSpecActAppliedStereotypeEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
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
		PinDescriptor figure = new PinDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public PinDescriptor getPrimaryShape() {
		return (PinDescriptor)primaryShape;
	}


	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof OutputPinInValSpecActLabelEditPart || borderItemEditPart instanceof OutputPinInValSpecActAppliedStereotypeEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(16, 16);

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
	 *        instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(OutputPinInValSpecActLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SendObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SequenceNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SendObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SequenceNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3064);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ConditionalNode_3069);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ExpansionRegion_3070);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ExpansionNode_3074);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ExpansionNode_3075);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.LoopNode_3071);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SequenceNode_3073);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.StructuredActivityNode_3065);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3077);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.DataStoreNode_3078);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3064);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ConditionalNode_3069);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ExpansionRegion_3070);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ExpansionNode_3074);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ExpansionNode_3075);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.LoopNode_3071);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SequenceNode_3073);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.StructuredActivityNode_3065);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3077);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.DataStoreNode_3078);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		types.add(UMLElementTypes.ExceptionHandler_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3064);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ConditionalNode_3069);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ExpansionRegion_3070);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ExpansionNode_3074);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ExpansionNode_3075);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.LoopNode_3071);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SequenceNode_3073);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.StructuredActivityNode_3065);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3077);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.DataStoreNode_3078);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3064);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ConditionalNode_3069);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ExpansionRegion_3070);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ExpansionNode_3074);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ExpansionNode_3075);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.LoopNode_3071);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SequenceNode_3073);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.StructuredActivityNode_3065);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3077);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.DataStoreNode_3078);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ConditionalNode_3069);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ExpansionRegion_3070);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.LoopNode_3071);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.SequenceNode_3073);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3065);
		}
		if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
		}
		return types;
	}





	/**
	 * @generated
	 */
	public class PinDescriptor extends RectangleFigure {


		/**
		 * @generated
		 */
		private Polyline fOptionalArrowFigure;


		/**
		 * @generated
		 */
		public PinDescriptor() {
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(16)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fOptionalArrowFigure = new Polyline();
			fOptionalArrowFigure.setLineWidth(1);

			this.add(fOptionalArrowFigure);


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
		public Polyline getOptionalArrowFigure() {
			return fOptionalArrowFigure;
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
				prefColor = PreferenceConstantHelper.getElementConstant("OutputPin", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("OutputPin", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("OutputPin", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("OutputPin", PreferenceConstantHelper.COLOR_GRADIENT);
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
}
