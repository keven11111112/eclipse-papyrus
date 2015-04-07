package org.eclipse.papyrus.uml.diagram.activity.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultGraphicalNodeEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.RoundedRectangleNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SelectableBorderedNodeFigure;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.ActivityDiagramChangeStereotypedShapeEditpolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.CreateActionLocalConditionEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.DeleteActionViewEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.locator.PinPositionLocator;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ChangeStereotypedShapeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusRoundedNodeFigure;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class StartObjectBehavoiurActionEditPart extends RoundedCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3113;

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
	public StartObjectBehavoiurActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		// in Papyrus diagrams are not strongly synchronised
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.activity.edit.policies.StartObjectBehavoiurActionCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(RequestConstants.REQ_CREATE, new CreateActionLocalConditionEditPolicy());
		installEditPolicy(RequestConstants.REQ_DELETE, new DeleteActionViewEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(ChangeStereotypedShapeEditPolicy.CHANGE_SHAPE_POLICY, new ActivityDiagramChangeStereotypedShapeEditpolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
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
				case StartObjectBehaviorActionFloatingNameEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						@Override
						protected List<?> createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				case OutputPinInStartObjectBehaviorActionEditPart.VISUAL_ID:
				case InputPinInStartObjectBehaviorActionAsObjectEditPart.VISUAL_ID:
				case ValuePinInStartObjectBehaviorActionAsObjectEditPart.VISUAL_ID:
				case ActionPinInStartObjectBehaviorActionAsObjectEditPart.VISUAL_ID:
				case InputPinInStartObjectBehaviorActionAsArgumentEditPart.VISUAL_ID:
				case ValuePinInStartObjectBehaviorActionAsArgumentEditPart.VISUAL_ID:
				case ActionPinInStartObjectBehaviorActionAsArgumentEditPart.VISUAL_ID:
					return new BorderItemResizableEditPolicy();
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
	 * Papyrus codeGen
	 *
	 * @generated
	 **/
	protected void handleNotificationEvent(Notification event) {
		/*
		 * when a node have external node labels, the methods refreshChildren() remove the EditPart corresponding to the Label from the EditPart
		 * Registry. After that, we can't reset the visibility to true (using the Show/Hide Label Action)!
		 */
		if (NotationPackage.eINSTANCE.getView_Visible().equals(event.getFeature())) {
			Object notifier = event.getNotifier();
			List<?> modelChildren = ((View) getModel()).getChildren();
			if (!(notifier instanceof Edge)) {
				if (modelChildren.contains(event.getNotifier())) {
					return;
				}
			}
		}
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new PapyrusRoundedNodeFigure();
	}

	/**
	 * org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure
	 * 
	 * @generated
	 */
	public PapyrusRoundedNodeFigure getPrimaryShape() {
		return (PapyrusRoundedNodeFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StartObjectBehaviorActionNameEditPart) {
			((StartObjectBehaviorActionNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		// Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof OutputPinInStartObjectBehaviorActionEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(((OutputPinInStartObjectBehaviorActionEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		// Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof InputPinInStartObjectBehaviorActionAsObjectEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((InputPinInStartObjectBehaviorActionAsObjectEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		// Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ValuePinInStartObjectBehaviorActionAsObjectEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ValuePinInStartObjectBehaviorActionAsObjectEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		// Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ActionPinInStartObjectBehaviorActionAsObjectEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ActionPinInStartObjectBehaviorActionAsObjectEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		// Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof InputPinInStartObjectBehaviorActionAsArgumentEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((InputPinInStartObjectBehaviorActionAsArgumentEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		// Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ValuePinInStartObjectBehaviorActionAsArgumentEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ValuePinInStartObjectBehaviorActionAsArgumentEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		// Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ActionPinInStartObjectBehaviorActionAsArgumentEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ActionPinInStartObjectBehaviorActionAsArgumentEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StartObjectBehaviorActionNameEditPart) {
			return true;
		}
		if (childEditPart instanceof OutputPinInStartObjectBehaviorActionEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OutputPinInStartObjectBehaviorActionEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InputPinInStartObjectBehaviorActionAsObjectEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InputPinInStartObjectBehaviorActionAsObjectEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ValuePinInStartObjectBehaviorActionAsObjectEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ValuePinInStartObjectBehaviorActionAsObjectEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ActionPinInStartObjectBehaviorActionAsObjectEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActionPinInStartObjectBehaviorActionAsObjectEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InputPinInStartObjectBehaviorActionAsArgumentEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InputPinInStartObjectBehaviorActionAsArgumentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ValuePinInStartObjectBehaviorActionAsArgumentEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ValuePinInStartObjectBehaviorActionAsArgumentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ActionPinInStartObjectBehaviorActionAsArgumentEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActionPinInStartObjectBehaviorActionAsArgumentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof StartObjectBehaviorActionFloatingNameEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	protected NodeFigure createNodePlate() {
		RoundedRectangleNodePlateFigure result = new RoundedRectangleNodePlateFigure(40, 40);
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
		return new SelectableBorderedNodeFigure(createMainFigureWithSVG());
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
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		super.setLineWidth(width);
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof IPapyrusNodeFigure) {
			((IPapyrusNodeFigure) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(StartObjectBehaviorActionNameEditPart.VISUAL_ID));
	}
}