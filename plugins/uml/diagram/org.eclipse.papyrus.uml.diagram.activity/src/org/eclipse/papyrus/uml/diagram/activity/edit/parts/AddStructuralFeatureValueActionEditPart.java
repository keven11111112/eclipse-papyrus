package org.eclipse.papyrus.uml.diagram.activity.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
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
import org.eclipse.gmf.runtime.notation.BasicCompartment;
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
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class AddStructuralFeatureValueActionEditPart extends RoundedCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final String VISUAL_ID = "AddStructuralFeatureValueAction_Shape";

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
	public AddStructuralFeatureValueActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());

		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());

		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.activity.edit.policies.AddStructuralFeatureValueActionCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(RequestConstants.REQ_CREATE, new CreateActionLocalConditionEditPolicy());
		installEditPolicy(RequestConstants.REQ_DELETE, new DeleteActionViewEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY,
				new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(ChangeStereotypedShapeEditPolicy.CHANGE_SHAPE_POLICY,
				new ActivityDiagramChangeStereotypedShapeEditpolicy());
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
				String vid = UMLVisualIDRegistry.getVisualID(childView);
				if (vid != null) {
					switch (vid) {
					case AddStructuralFeatureValueActionFloatingNameEditPart.VISUAL_ID:
						return new BorderItemSelectionEditPolicy() {

							@Override
							protected List<?> createSelectionHandles() {
								MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
								mh.setBorder(null);
								return Collections.singletonList(mh);
							}
						};
					case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
					case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
					case InputPinInAddStructuralFeatureValueActionAsInserAtEditPart.VISUAL_ID:
					case ValuePinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
					case ValuePinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
					case ValuePinInAddStructuralFeatureValueActionAsInserAtEditPart.VISUAL_ID:
					case ActionPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
					case ActionPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
					case ActionPinInAddStructuralFeatureValueActionAsInserAtEditPart.VISUAL_ID:
					case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
						return new BorderItemResizableEditPolicy();
					}
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
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new RoundedCompartmentFigure();
	}

	/**
	 * @generated
	 */
	@Override
	public RoundedCompartmentFigure getPrimaryShape() {
		return (RoundedCompartmentFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AddStructuralFeatureValueActionNameEditPart) {
			((AddStructuralFeatureValueActionNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof InputPinInAddStructuralFeatureValueActionAsObjectEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(
					((InputPinInAddStructuralFeatureValueActionAsObjectEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof InputPinInAddStructuralFeatureValueActionAsValueEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((InputPinInAddStructuralFeatureValueActionAsValueEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof InputPinInAddStructuralFeatureValueActionAsInserAtEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((InputPinInAddStructuralFeatureValueActionAsInserAtEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ValuePinInAddStructuralFeatureValueActionAsObjectEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(
					((ValuePinInAddStructuralFeatureValueActionAsObjectEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ValuePinInAddStructuralFeatureValueActionAsValueEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((ValuePinInAddStructuralFeatureValueActionAsValueEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ValuePinInAddStructuralFeatureValueActionAsInserAtEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((ValuePinInAddStructuralFeatureValueActionAsInserAtEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ActionPinInAddStructuralFeatureValueActionAsObjectEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(
					((ActionPinInAddStructuralFeatureValueActionAsObjectEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ActionPinInAddStructuralFeatureValueActionAsValueEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((ActionPinInAddStructuralFeatureValueActionAsValueEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof ActionPinInAddStructuralFeatureValueActionAsInserAtEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((ActionPinInAddStructuralFeatureValueActionAsInserAtEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Pin locator for Actions
		if (childEditPart instanceof OutputPinInAddStructuralFeatureValueActionAsResultEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.SOUTH);
			getBorderedFigure().getBorderItemContainer().add(
					((OutputPinInAddStructuralFeatureValueActionAsResultEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AddStructuralFeatureValueActionNameEditPart) {
			return true;
		}
		if (childEditPart instanceof InputPinInAddStructuralFeatureValueActionAsObjectEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((InputPinInAddStructuralFeatureValueActionAsObjectEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InputPinInAddStructuralFeatureValueActionAsValueEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((InputPinInAddStructuralFeatureValueActionAsValueEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InputPinInAddStructuralFeatureValueActionAsInserAtEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((InputPinInAddStructuralFeatureValueActionAsInserAtEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ValuePinInAddStructuralFeatureValueActionAsObjectEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((ValuePinInAddStructuralFeatureValueActionAsObjectEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ValuePinInAddStructuralFeatureValueActionAsValueEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((ValuePinInAddStructuralFeatureValueActionAsValueEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ValuePinInAddStructuralFeatureValueActionAsInserAtEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((ValuePinInAddStructuralFeatureValueActionAsInserAtEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ActionPinInAddStructuralFeatureValueActionAsObjectEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((ActionPinInAddStructuralFeatureValueActionAsObjectEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ActionPinInAddStructuralFeatureValueActionAsValueEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((ActionPinInAddStructuralFeatureValueActionAsValueEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ActionPinInAddStructuralFeatureValueActionAsInserAtEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((ActionPinInAddStructuralFeatureValueActionAsInserAtEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof OutputPinInAddStructuralFeatureValueActionAsResultEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((OutputPinInAddStructuralFeatureValueActionAsResultEditPart) childEditPart).getFigure());
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
		if (borderItemEditPart instanceof AddStructuralFeatureValueActionFloatingNameEditPart) {
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
	@Override
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
	@Override
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
	@Override
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
		super.setLineWidth(width);
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineType(int style) {
		if (primaryShape instanceof IPapyrusNodeFigure) {
			((IPapyrusNodeFigure) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(
				UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionNameEditPart.VISUAL_ID));
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 *      Change automatically the type of the output pin with the type of the classifier
	 * @param notification
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if (UMLPackage.Literals.STRUCTURAL_FEATURE_ACTION__STRUCTURAL_FEATURE.equals(feature)) {
			EObject resolvedElement = this.resolveSemanticElement();
			final Object result = resolvedElement.eGet(UMLPackage.Literals.WRITE_STRUCTURAL_FEATURE_ACTION__RESULT);
			final Object object = resolvedElement.eGet(UMLPackage.Literals.STRUCTURAL_FEATURE_ACTION__OBJECT);
			final Object value = resolvedElement.eGet(UMLPackage.Literals.WRITE_STRUCTURAL_FEATURE_ACTION__VALUE);
			Object _feature = notification.getNewValue();
			if (_feature instanceof StructuralFeature) {
				org.eclipse.emf.common.command.Command cmdSetResultType = null;
				org.eclipse.emf.common.command.Command cmdSetObjectType = null;
				org.eclipse.emf.common.command.Command cmdSetValueType = null;
				StructuralFeature newFeature = (StructuralFeature) _feature;
				Element owner = newFeature.getOwner();
				if (newFeature.getFeaturingClassifiers().contains(owner)) {
					cmdSetResultType = SetCommand.create(getEditingDomain(), result,
							UMLPackage.Literals.TYPED_ELEMENT__TYPE, owner);
					cmdSetObjectType = SetCommand.create(getEditingDomain(), object,
							UMLPackage.Literals.TYPED_ELEMENT__TYPE, owner);
				}
				Type type = newFeature.getType();
				if (type != null) {
					cmdSetValueType = SetCommand.create(getEditingDomain(), value,
							UMLPackage.Literals.TYPED_ELEMENT__TYPE, type);
				}
				try {
					if (cmdSetResultType != null) {
						if (cmdSetResultType.canExecute()) {
							CommandStack commandStack = getEditingDomain().getCommandStack();
							if (commandStack instanceof TransactionalCommandStack) {
								((TransactionalCommandStack) commandStack).execute(cmdSetResultType,
										Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
							} else {
								commandStack.execute(cmdSetResultType);
							}
						}
					}
					if (cmdSetValueType != null) {
						if (cmdSetValueType.canExecute()) {
							CommandStack commandStack = getEditingDomain().getCommandStack();
							if (commandStack instanceof TransactionalCommandStack) {
								((TransactionalCommandStack) commandStack).execute(cmdSetValueType,
										Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
							} else {
								commandStack.execute(cmdSetValueType);
							}
						}
					}
					if (cmdSetObjectType != null) {
						if (cmdSetObjectType.canExecute()) {
							CommandStack commandStack = getEditingDomain().getCommandStack();
							if (commandStack instanceof TransactionalCommandStack) {
								((TransactionalCommandStack) commandStack).execute(cmdSetObjectType,
										Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
							} else {
								commandStack.execute(cmdSetObjectType);
							}
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (RollbackException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
