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
 *   Soyatec - Initial API and implementation
 *   Céline Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 440230 : Label Margin
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.IPapyrusWrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.RoundedRectangleNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.InteractionRectangleFigure;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.common.util.MessageDirection;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AbstractHeadImpactLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.OLDGateCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionFragmentsCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionHeadImpactLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.StereotypeInteractionFigure;
import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Add implementing IPapyrusEditPart to displaying Stereotypes.
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class OldCustomInteractionEditPart extends InteractionEditPart implements IPapyrusEditPart {

	/**
	 * Default Margin when not present in CSS
	 */
	public static final int DEFAULT_MARGIN = 0;

	/**
	 * CSS Integer property to define the horizontal Label Margin
	 */
	public static final String TOP_MARGIN_PROPERTY = "TopMarginLabel"; // $NON-NLS$

	/**
	 * CSS Integer property to define the vertical Label Margin
	 */
	public static final String LEFT_MARGIN_PROPERTY = "LeftMarginLabel"; // $NON-NLS$

	/**
	 * CSS Integer property to define the horizontal Label Margin
	 */
	public static final String BOTTOM_MARGIN_PROPERTY = "BottomMarginLabel"; // $NON-NLS$

	/**
	 * CSS Integer property to define the vertical Label Margin
	 */
	public static final String RIGHT_MARGIN_PROPERTY = "RightMarginLabel"; // $NON-NLS$

	/**
	 * Notifier for listen and unlisted model element.
	 */
	private NotificationHelper notifier = null;

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public OldCustomInteractionEditPart(View view) {
		super(view);
	}

	/**
	 * Try to use the notifier from super class, if not exist, create new one.
	 */
	protected NotificationHelper getNotifier() {
		if (notifier == null) {
			try {
				Field f = InteractionEditPart.class.getDeclaredField("notifier");
				f.setAccessible(true);
				notifier = (NotificationHelper) f.get(this);
			} catch (Exception e) {
				notifier = new NotificationHelper(new UIAdapterImpl() {

					@Override
					protected void safeNotifyChanged(Notification msg) {
						handleNotificationEvent(msg);
					}
				});
			}
		}
		return notifier;
	}

	public Command getUpdateLifelinesHeightsCommand(Command command) {
		for (Object child : OldCustomInteractionEditPart.this.getChildren()) {
			if (child instanceof InteractionInteractionCompartmentEditPart) {
				InteractionInteractionCompartmentEditPart childEditPart = (InteractionInteractionCompartmentEditPart) child;
				for (Object grandChild : childEditPart.getChildren()) {
					if (grandChild instanceof OLDLifelineEditPart) {
						//command = ((CustomLifelineEditPart) grandChild).getAlignLifelineBottomToParentCommand(command, false);
					}
				}
			}
		}
		return command;
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// Fixed bugs: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134 and https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new InteractionGraphicalNodeEditPolicy());
		// Create gate: https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
		installEditPolicy("Gate Creation Edit Policy", new OLDGateCreationEditPolicy());
		// Ordering fragments after creation, See https://bugs.eclipse.org/bugs/show_bug.cgi?id=403233
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new InteractionFragmentsCreationEditPolicy());
		// Install custom PrimaryDragEditPolicy to preserve anchors for lost and found.
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableShapeEditPolicy() {

			@Override
			protected Command getResizeCommand(ChangeBoundsRequest request) {
				Rectangle newBounds = getInitialFeedbackBounds().getCopy();
				Dimension sizeDelta = request.getSizeDelta();
				newBounds.width += sizeDelta.width;
				newBounds.height += sizeDelta.height;
				Dimension minimumSize = getFigure().getMinimumSize();
				// Avoid to update model when the new size is less than the minimum one.
				if (newBounds.width < minimumSize.width || newBounds.height < minimumSize.height) {
					return UnexecutableCommand.INSTANCE;
				}
				Command command = getUpdateLifelinesHeightsCommand(super.getResizeCommand(request));
				/** Anchors for Lost/Found message were updated, there's no need to preserve positions after resize. */
				// if(command != null && command.canExecute()) {
				// if(newBounds.width >= minimumSize.width && newBounds.height >= minimumSize.height) {
				// command = command.chain(new ICommandProxy(new PreserveAnchorsPositionCommand(CustomInteractionEditPart.this, sizeDelta, PreserveAnchorsPositionCommand.PRESERVE_XY)));
				// }
				// }
				return command;
			}
		});
		// install a editpolicy to display stereotypes
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(AbstractHeadImpactLayoutEditPolicy.HEAD_IMPACT_LAYOUT_POLICY, new InteractionHeadImpactLayoutEditPolicy());
	}

	/**
	 * @Override
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new StereotypeInteractionFigure() {

			@Override
			public Dimension getMinimumSize(int wHint, int hHint) {
				Rectangle bounds = new Rectangle();
				for (Object child : OldCustomInteractionEditPart.this.getChildren()) {
					if (child instanceof InteractionInteractionCompartmentEditPart) {
						InteractionInteractionCompartmentEditPart childEditPart = (InteractionInteractionCompartmentEditPart) child;
						for (Object grandChild : childEditPart.getChildren()) {
							GraphicalEditPart editPart = (GraphicalEditPart) grandChild;
							IFigure figure = editPart.getFigure();
							if (grandChild instanceof OLDLifelineEditPart) {
								Rectangle childBounds = figure.getBounds().getCopy();
								//childBounds.height = ((CustomLifelineEditPart) grandChild).getMinimumHeight(-1);
								bounds.union(childBounds);
							} else {
								bounds.union(figure.getBounds());
							}
						}
						IFigure figure = childEditPart.getFigure();
						Rectangle rectangle = figure.getBounds();
						IFigure parentfigure = OldCustomInteractionEditPart.this.getFigure();
						Rectangle parentRectangle = parentfigure.getBounds();
						Dimension zoomedAddon = new Dimension(10, 16);
						figure.translateToRelative(zoomedAddon);
						bounds.width += parentRectangle.width - rectangle.width + zoomedAddon.width; // border 2x5
						bounds.height += parentRectangle.height - rectangle.height + zoomedAddon.height; // border 2x5 + 2x3
						break;
					}
				}
				return bounds.getSize();
			}

		};
	}

	/**
	 * The changement in the background color of the Container must set the forground color of the
	 * ContainerCompartiment to avoid the separation line betewen the Compartiment and the
	 * ContainerLablel.
	 *
	 * @Override-not
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
			if (primaryShape instanceof InteractionRectangleFigure) {
				InteractionRectangleFigure irf = (InteractionRectangleFigure) primaryShape;
				if (irf.getCompartmentFigure() != null) {
					irf.getCompartmentFigure().setForegroundColor(color);
				}
			}
		}
	}



	@Override
	protected void refreshFont() {
		super.refreshFont();
		refreshBounds();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabelMargin();
	};

	/**
	 * Refresh margin of named element children labels
	 * <ul>
	 * <li>Get Css values</li>
	 * <li>Get all the children figure</li>
	 * <li>If the child is a label then apply the margin</li>
	 * </ul>
	 */
	public void refreshLabelMargin() {
		IFigure figure = null;

		int leftMargin = DEFAULT_MARGIN;
		int rightMargin = DEFAULT_MARGIN;
		int topMargin = DEFAULT_MARGIN;
		int bottomMargin = DEFAULT_MARGIN;

		Object model = this.getModel();



		if (model instanceof View) {
			leftMargin = NotationUtils.getIntValue((View) model, LEFT_MARGIN_PROPERTY, DEFAULT_MARGIN);
			rightMargin = NotationUtils.getIntValue((View) model, RIGHT_MARGIN_PROPERTY, DEFAULT_MARGIN);
			topMargin = NotationUtils.getIntValue((View) model, TOP_MARGIN_PROPERTY, DEFAULT_MARGIN);
			bottomMargin = NotationUtils.getIntValue((View) model, BOTTOM_MARGIN_PROPERTY, DEFAULT_MARGIN);
		}


		// Get all children figures of the Edit Part and set margin according to the retrieve values
		if (this instanceof IPapyrusEditPart) {
			figure = ((IPapyrusEditPart) this).getPrimaryShape();
			List<IPapyrusWrappingLabel> labelChildFigureList = FigureUtils.findChildFigureInstances(figure, IPapyrusWrappingLabel.class);

			for (IPapyrusWrappingLabel label : labelChildFigureList) {
				if (label != null) {
					label.setMarginLabel(leftMargin, topMargin, rightMargin, bottomMargin);
				}
			}
		}
	}


	/**
	 * Handle formal gate's name
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		final NotificationHelper notifier = getNotifier();
		Object feature = notification.getFeature();
		if (UMLPackage.eINSTANCE.getInteraction_FormalGate().equals(feature)) {
			// Handle formal gate
			notifier.unlistenObject((Notifier) notification.getOldValue());
			notifier.listenObject((Notifier) notification.getNewValue());
		} else if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) && notification.getNotifier() instanceof Gate) {
			// Handle modification of formal gate's name
			Gate gate = (Gate) notification.getNotifier();
			String oldStringValue = notification.getOldStringValue();
			String newStringValue = notification.getNewStringValue();
			if (oldStringValue != null && newStringValue != null) {
				String oldPrefix = oldStringValue.split("_")[0];
				String newPrefix = newStringValue.split("_")[0];
				if (!oldPrefix.equals(newPrefix) && (oldPrefix.equals(MessageDirection.IN.getName()) || oldPrefix.equals(MessageDirection.OUT.getName()))) {
					notifier.unlistenObject(gate);
					gate.setName(oldPrefix + "_" + gate.getName());
					notifier.listenObject(gate);
				}
			}
		}
		super.handleNotificationEvent(notification);
		if (!notification.isTouch()) {
			synchronizeSize();
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshBounds()
	 *
	 */

	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		// Add size updater at the beginning of showing this edit part.
		getViewer().getControl().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				synchronizeSize();
			}
		});
	}

	/**
	 * Synchronize real figure size to model of Interaction.
	 * 1. At most time, the size of mode is very important when calculate the bounds of a EditPart, see SequenceUtil.getAbsoluteBounds().
	 * 2. This method would be invoked when the figure size increased automatically, the interaction always allow to show all children, see
	 * primaryShape.getMinimumSize().
	 * 3. In order to avoid update after changes of model, we only care the minimum size of figure.
	 */
	private void synchronizeSize() {
		View view = getNotationView();
		if (view instanceof Shape) {
			LayoutConstraint c = ((Shape) view).getLayoutConstraint();
			if (c instanceof Size) {
				final Size size = (Size) c;
				Dimension realSize = getFigure().getMinimumSize();
				final Dimension sizeDelta = new Dimension();
				if (size.getWidth() != -1 && realSize.width > size.getWidth()) {
					sizeDelta.width = realSize.width;
				}
				if (size.getHeight() != -1 && realSize.height > size.getHeight()) {
					sizeDelta.height = realSize.height;
				}
				if (sizeDelta.width != 0 || sizeDelta.height != 0) {
					AbstractCommand cmd = new AbstractCommand() {

						@Override
						public boolean canExecute() {
							return true;
						}

						@Override
						public boolean canUndo() {
							return false;
						}

						@Override
						public void execute() {
							if (sizeDelta.width != 0) {
								size.setWidth(sizeDelta.width);
							}
							if (sizeDelta.height != 0) {
								size.setHeight(sizeDelta.height);
							}
						}

						@Override
						public void redo() {
							execute();
						}
					};
					CommandHelper.executeCommandWithoutHistory(getEditingDomain(), cmd, true);
				}
				// Handle Start-up and Undo of creating a MessageCreate
				// Other cases of keeping lifelines' heights up to date are handled elsewhere in order to prevent blinking
				Command commandUpdateLifelines = getUpdateLifelinesHeightsCommand(null);
				if (commandUpdateLifelines != null) {
					CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new GEFtoEMFCommandWrapper(commandUpdateLifelines), true);
				}
			}
		}
	}

	/**
	 * Activate a listener for the interactionUse to Handle notification in the refered Interaction
	 */
	@Override
	public void activate() {
		super.activate();
		final NotificationHelper notifier = getNotifier();
		Interaction interaction = (Interaction) resolveSemanticElement();
		if (interaction != null) {
			for (Gate formalGate : interaction.getFormalGates()) {
				notifier.listenObject(formalGate);
			}
		}
	}

	/**
	 * Deactivate a listener for the interactionUse to Handle notification in the refered
	 * Interaction
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		if (notifier != null) {
			notifier.unlistenAll();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeNotify() {
		if (notifier != null) {
			notifier.unlistenAll();
		}
		super.removeNotify();
	}

	/**
	 * Handle found message
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		ConnectionAnchor sourceAnchor = createAnchor(request, UMLElementTypes.Message_FoundEdge, MessageFoundEditPart.VISUAL_ID, MessageFoundEditPart.class);
		if (sourceAnchor == null) {
			sourceAnchor = super.getSourceConnectionAnchor(request);
		}
		return sourceAnchor;
	}

	/**
	 * Handle found message
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		if (connEditPart instanceof MessageFoundEditPart) {
			String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, true);
			if (terminal.length() > 0) {
				PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(terminal);
				return new AnchorHelper.InnerPointAnchor(getFigure(), pt);
			}
		}
		ConnectionAnchor sourceConnectionAnchor = super.getSourceConnectionAnchor(connEditPart);
		// Point referencePoint = sourceConnectionAnchor.getReferencePoint();
		// if(connEditPart instanceof MessageFoundEditPart && referencePoint.x != 0 && referencePoint.y != 0) {
		// sourceConnectionAnchor = new XYAnchor(referencePoint);
		// }
		return sourceConnectionAnchor;
	}

	/**
	 * Handle lost message
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		ConnectionAnchor targetAnchor = createAnchor(request, UMLElementTypes.Message_LostEdge, MessageLostEditPart.VISUAL_ID, MessageLostEditPart.class);
		if (targetAnchor == null) {
			// Enabled to find Anchor for MessageCreate, this would be useful when showing feedbacks.
			// Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134
			targetAnchor = createAnchor(request, UMLElementTypes.Message_CreateEdge, MessageCreateEditPart.VISUAL_ID, MessageCreateEditPart.class);
		}
		if (targetAnchor == null) {
			targetAnchor = super.getTargetConnectionAnchor(request);
		}
		return targetAnchor;
	}

	/**
	 * Handle lost message
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		// Enabled to find Anchor for MessageCreate, this would be useful when showing feedbacks.
		// Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134
		if (connEditPart instanceof MessageLostEditPart || connEditPart instanceof MessageCreateEditPart) {
			String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, false);
			if (terminal.length() > 0) {
				PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(terminal);
				return new AnchorHelper.InnerPointAnchor(getFigure(), pt);
			}
		}
		ConnectionAnchor targetConnectionAnchor = super.getTargetConnectionAnchor(connEditPart);
		// Point referencePoint = targetConnectionAnchor.getReferencePoint();
		// if(connEditPart instanceof MessageLostEditPart && referencePoint.x != 0 && referencePoint.y != 0) {
		// targetConnectionAnchor = new XYAnchor(referencePoint);
		// }
		return targetConnectionAnchor;
	}

	/**
	 * Create Anchor
	 *
	 * @param request
	 *            The request
	 * @param elementType
	 *            The element type of the message
	 * @param visualId
	 *            The visual ID of the message
	 * @param messageType
	 *            The type of the message
	 * @return The connection anchor
	 */
	private ConnectionAnchor createAnchor(Request request, IElementType elementType, String visualId, Class<?> messageType) {
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest) request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for (Object obj : relationshipTypes) {
				if (elementType.equals(obj)) {
					return createAnchor(createRequest.getLocation().getCopy());
				}
			}
		} else if (request instanceof CreateConnectionViewRequest) {
			CreateConnectionViewRequest createRequest = (CreateConnectionViewRequest) request;
			ConnectionViewDescriptor connectionViewDescriptor = createRequest.getConnectionViewDescriptor();
			if (connectionViewDescriptor != null) {
				if (visualId.equals(connectionViewDescriptor.getSemanticHint())) {
					return createAnchor(createRequest.getLocation().getCopy());
				}
			}
		} else if (request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			// Fixed bug creating anchors for MessageLost and MessageFound.
			if (messageType.isInstance(connectionEditPart) && request instanceof LocationRequest) {
				return createAnchor(((LocationRequest) request).getLocation().getCopy());
			}
		}
		return null;
	}

	/**
	 * Create Anchor
	 *
	 * @param location
	 *            The location
	 * @return The connection anchor
	 */
	private ConnectionAnchor createAnchor(Point location) {
		// return new SlidableAnchor(getFigure(), BaseSlidableAnchor.getAnchorRelativeLocation(location, getFigure().getBounds()));
		return AnchorHelper.InnerPointAnchor.createAnchorAtLocation(getFigure(), new PrecisionPoint(location));
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InteractionNameEditPart) {
			return true;
		}
		if (childEditPart instanceof InteractionInteractionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((InteractionInteractionCompartmentEditPart) childEditPart).getFigure());
			return true;
		} else if (childEditPart instanceof OLDGateEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OLDGateEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return super.getContentPaneFor(editPart);
	}

	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof OLDGateEditPart) {
			getBorderedFigure().getBorderItemContainer().add(((OLDGateEditPart) childEditPart).getFigure(), new GateLocator((OLDGateEditPart) childEditPart, getFigure()));
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	@Override
	protected NodeFigure createNodePlate() {
		return new RoundedRectangleNodePlateFigure(857, 757) {

			@Override
			protected ConnectionAnchor createAnchor(PrecisionPoint p) {
				if (p == null) {
					// If the old terminal for the connection anchor cannot be resolved (by SlidableAnchor) a null
					// PrecisionPoint will passed in - this is handled here
					return createDefaultAnchor();
				}
				return new AnchorHelper.IntersectionPointAnchor(this, p);
			}
		};
	}
}
