package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AppliedStereotypeCommentCreationEditPolicyEx;
import org.eclipse.papyrus.uml.diagram.sequence.figures.ExecutionSpecificationNodePlate;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.ConnectYCoordinateToGrillingEditPolicy;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCommentEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.ExecutionSpecification;

/**
 * Add implementing IPapyrusEditPart to displaying Stereotypes.
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class AbstractExecutionSpecificationEditPart extends RoundedCompartmentEditPart {

	public static final String EXECUTION_FIX_ANCHOR_POSITION = "Execution Fix Anchor Position";
	public static int DEFAUT_HEIGHT=100;
	public static int DEFAUT_WIDTH=20;
	
	private List<ExecutionSpecificationEndEditPart> executionSpecificationEndParts;

	public AbstractExecutionSpecificationEditPart(View view) {
		super(view);
	}

	@Override
	public List getChildren() {
		if (executionSpecificationEndParts == null) {
			initExecutionSpecificationEndEditPart();
		}
		return super.getChildren();
	}

	protected void initExecutionSpecificationEndEditPart() {
		EObject element = this.resolveSemanticElement();
		if (!(element instanceof ExecutionSpecification)) {
			return;
		}
		executionSpecificationEndParts = new ArrayList<ExecutionSpecificationEndEditPart>();
		ExecutionSpecification execution = (ExecutionSpecification) element;
		final ExecutionSpecificationEndEditPart startPart = new ExecutionSpecificationEndEditPart(execution.getStart(), this, new RelativeLocator(getFigure(), PositionConstants.NORTH));
		executionSpecificationEndParts.add(startPart);
		final ExecutionSpecificationEndEditPart finishPart = new ExecutionSpecificationEndEditPart(execution.getFinish(), this, new RelativeLocator(getFigure(), PositionConstants.SOUTH));
		executionSpecificationEndParts.add(finishPart);
		Diagram diagram = ((View) this.getModel()).getDiagram();
		startPart.rebuildLinks(diagram);
		finishPart.rebuildLinks(diagram);
		addChild(startPart, -1);
		addChild(finishPart, -1);
	}

	static class FillParentLocator implements Locator {

		@Override
		public void relocate(IFigure target) {
			target.setBounds(target.getParent().getBounds());
		}
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(ConnectYCoordinateToGrillingEditPolicy.CONNECT_TO_GRILLING_MANAGEMENT, new ConnectYCoordinateToGrillingEditPolicy());
		installEditPolicy(AppliedStereotypeCommentEditPolicy.APPLIED_STEREOTYPE_COMMENT, new AppliedStereotypeCommentCreationEditPolicyEx());
	}

	@Override
	protected void setLineWidth(int width) {
		if (getPrimaryShape() instanceof NodeFigure) {
			((NodeFigure) getPrimaryShape()).setLineWidth(width);
		}
	}

	/**
	 * Override to set the transparency to the correct figure
	 */
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	/**
	 * sets the back ground color of this edit part
	 *
	 * @param color
	 *            the new value of the back ground color
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		getPrimaryShape().setBackgroundColor(color);
		getPrimaryShape().setIsUsingGradient(false);
		getPrimaryShape().setGradientData(-1, -1, 0);
	}

	/**
	 * Override to set the gradient data to the correct figure
	 */
	@Override
	protected void setGradient(GradientData gradient) {
		IPapyrusNodeFigure fig = getPrimaryShape();
		FillStyle style = (FillStyle) getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if (gradient != null) {
			fig.setIsUsingGradient(true);
			fig.setGradientData(style.getFillColor(), gradient.getGradientColor1(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	@Override
	public boolean supportsGradient() {
		return true;
	}

//	@Override
//	protected void handleNotificationEvent(Notification event) {
//		super.handleNotificationEvent(event);
//		Object feature = event.getFeature();
//		if ((getModel() != null) && (getModel() == event.getNotifier())) {
//			if (NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
//				refreshLineWidth();
//			} else if (NotationPackage.eINSTANCE.getLineTypeStyle_LineType().equals(feature)) {
//				refreshLineType();
//			}
//		} else if (NotationPackage.eINSTANCE.getLocation_X().equals(feature) || NotationPackage.eINSTANCE.getLocation_Y().equals(feature) || NotationPackage.eINSTANCE.getSize_Height().equals(feature)
//				|| NotationPackage.eINSTANCE.getSize_Width().equals(feature)) {
//			getParent().refresh();
//		} else if (UMLPackage.eINSTANCE.getExecutionSpecification_Finish().equals(feature) || UMLPackage.eINSTANCE.getExecutionSpecification_Start().equals(feature)) {
//			if (executionSpecificationEndParts != null) {
//				for (ExecutionSpecificationEndEditPart child : executionSpecificationEndParts) {
//					removeChild(child);
//					child.removeFromResource();
//				}
//				executionSpecificationEndParts = null;
//			}
//			refreshChildren();
//		}
//		refreshShadow();
//	}

	@Override
	public abstract ExecutionSpecificationRectangleFigure getPrimaryShape();

	// see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=385604
//	protected ShapeNodeEditPart moveExecutionSpecificationFeedback(ChangeBoundsRequest request, AbstractExecutionSpecificationEditPart movedPart, PrecisionRectangle rect) {
//		OLDLifelineEditPart lifelineEP = (OLDLifelineEditPart) movedPart.getParent();
//		Rectangle copy = rect.getCopy();
//		lifelineEP.getPrimaryShape().translateToRelative(copy);
//		List<ShapeNodeEditPart> executionSpecificationList = LifelineEditPartUtil.getChildShapeNodeEditPart(lifelineEP);
//		List<ShapeNodeEditPart> movedChildrenParts = OLDLifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts(AbstractExecutionSpecificationEditPart.this);
//		executionSpecificationList.remove(movedPart); // ignore current action and its children
//		executionSpecificationList.removeAll(movedChildrenParts);
//		ShapeNodeEditPart parentBar = OLDLifelineXYLayoutEditPolicy.getParent(lifelineEP, copy, executionSpecificationList);
//		Rectangle dotLineBounds = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();
//		int dotLineBarLocationX = dotLineBounds.x + dotLineBounds.width / 2 - OLDLifelineXYLayoutEditPolicy.EXECUTION_INIT_WIDTH / 2;
//		if (parentBar == null) {
//			if (dotLineBarLocationX < copy.x) { // there is no parent bar, move to the center dotline position
//				int dx = dotLineBarLocationX - copy.x;
//				request.getMoveDelta().x += dx;
//				rect.x += dx;
//			}
//		} else {
//			while (!executionSpecificationList.isEmpty()) {
//				Rectangle parentBounds = parentBar.getFigure().getBounds();
//				int width = parentBounds.width > 0 ? parentBounds.width : OLDLifelineXYLayoutEditPolicy.EXECUTION_INIT_WIDTH;
//				int x = parentBounds.x + width / 2 + 1; // affixed to the parent bar
//				int dx = x - copy.x;
//				rect.x += dx;
//				request.getMoveDelta().x += dx;
//				copy.x = x;
//				// check again to see if the new bar location overlaps with existing bars
//				ShapeNodeEditPart part = OLDLifelineXYLayoutEditPolicy.getParent(lifelineEP, copy, executionSpecificationList);
//				if (part == parentBar) {
//					break;
//				} else {
//					// if overlaps, go on moving the bar to next x position
//					parentBar = part;
//				}
//			}
//		}
//		return parentBar;
//	}

//	/**
//	 * Override for add elements on ExecutionSpecification
//	 */
//	@Override
//	public Command getCommand(Request request) {
//		if (request instanceof CreateUnspecifiedTypeRequest) {
//			return getParent().getCommand(request);
//		}
//		return super.getCommand(request);
//	}
//
//	/**
//	 * @generated NOT Override for redirecting creation request to the lifeline
//	 */
//	@Override
//	public void showSourceFeedback(Request request) {
//		if (request instanceof CreateUnspecifiedTypeRequest) {
//			getParent().showSourceFeedback(request);
//		}
//		super.showSourceFeedback(request);
//	}
//
//	/**
//	 * @generated NOT Override for redirecting creation request to the lifeline
//	 */
//	@Override
//	public void eraseSourceFeedback(Request request) {
//		if (request instanceof CreateUnspecifiedTypeRequest) {
//			getParent().eraseSourceFeedback(request);
//		}
//		super.eraseSourceFeedback(request);
//	}
//
//	@Override
//	public void showTargetFeedback(Request request) {
//		if (request instanceof CreateUnspecifiedTypeRequest) {
//			getParent().showTargetFeedback(request);
//		}
//		super.showTargetFeedback(request);
//	}
//
//	@Override
//	public void eraseTargetFeedback(Request request) {
//		if (request instanceof CreateUnspecifiedTypeRequest) {
//			getParent().eraseTargetFeedback(request);
//		}
//		super.eraseTargetFeedback(request);
//	}

	/**
	 * Add connection on top off the figure during the feedback.
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		Object fixPos = request.getExtendedData().get(EXECUTION_FIX_ANCHOR_POSITION);
		if (fixPos != null && (fixPos.equals(PositionConstants.TOP) || fixPos.equals(PositionConstants.BOTTOM))) {
			return new AnchorHelper.FixedAnchorEx(getFigure(), (Integer) fixPos);
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest) request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for (Object obj : relationshipTypes) {
				if (UMLElementTypes.Message_SynchEdge.equals(obj)) {
					// Sync Message
					if (!createRequest.getTargetEditPart().equals(createRequest.getSourceEditPart())) {
						return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.TOP);
					}
					// otherwise, this is a recursive call, let destination free
				}
			}
		} else if (request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if (connectionEditPart instanceof MessageSyncEditPart) {
				// Sync Message
				return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.TOP);
			}
		}
		// Fixed bug about computing target anchor when creating message sync.
		else if (request instanceof CreateConnectionViewRequest) {
			CreateConnectionViewRequest createRequest = (CreateConnectionViewRequest) request;
			ConnectionViewDescriptor viewDesc = ((CreateConnectionViewRequest) request).getConnectionViewDescriptor();
			if (((IHintedType) UMLElementTypes.Message_SynchEdge).getSemanticHint().equals(viewDesc.getSemanticHint())) {
				// Sync Message
				if (!createRequest.getTargetEditPart().equals(createRequest.getSourceEditPart())) {
					return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.TOP);
				}
			}
		}
		return super.getTargetConnectionAnchor(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 *
	 * @param connEditPart
	 *            The connection edit part.
	 * @return The anchor.
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		if (connEditPart instanceof MessageSyncEditPart) {
			// Sync Message
			return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.TOP);
		}
		final org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connection = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) connEditPart;
		String t = null;
		try {
			t = (String) getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

				@Override
				public void run() {
					Anchor a = ((Edge) connection.getModel()).getTargetAnchor();
					if (a instanceof IdentityAnchor) {
						setResult(((IdentityAnchor) a).getId());
					} else {
						setResult(""); //$NON-NLS-1$
					}
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "getTargetConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "getTargetConnectionAnchor", e); //$NON-NLS-1$
		}
		if (t != null && !"".equals(t)) {
			int position = AnchorHelper.FixedAnchorEx.parsePosition(t);
			if (position != -1) {
				return new AnchorHelper.FixedAnchorEx(getFigure(), position);
			}
		}
		return super.getTargetConnectionAnchor(connEditPart);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 *
	 * @param request
	 *            The request
	 * @return The anchor
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		Object fixPos = request.getExtendedData().get(EXECUTION_FIX_ANCHOR_POSITION);
		if (fixPos != null && (fixPos.equals(PositionConstants.TOP) || fixPos.equals(PositionConstants.BOTTOM))) {
			return new AnchorHelper.FixedAnchorEx(getFigure(), (Integer) fixPos);
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest) request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for (Object obj : relationshipTypes) {
				if (UMLElementTypes.Message_ReplyEdge.equals(obj)) {
					// Reply Message
					return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.BOTTOM);
				}
			}
		} else if (request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if (connectionEditPart instanceof MessageReplyEditPart) {
				// Reply Message
				return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.BOTTOM);
			}
		}
		return super.getSourceConnectionAnchor(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 *
	 * @param connEditPart
	 *            The connection edit part.
	 * @return The anchor.
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		if (connEditPart instanceof MessageReplyEditPart) {
			// Reply Message
			return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.BOTTOM);
		}
		final org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connection = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) connEditPart;
		String t = null;
		try {
			t = (String) getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

				@Override
				public void run() {
					Anchor a = ((Edge) connection.getModel()).getSourceAnchor();
					if (a instanceof IdentityAnchor) {
						setResult(((IdentityAnchor) a).getId());
					} else {
						setResult(""); //$NON-NLS-1$
					}
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "getSourceConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "getSourceConnectionAnchor", e); //$NON-NLS-1$
		}
		if (t != null && !"".equals(t)) {
			int position = AnchorHelper.FixedAnchorEx.parsePosition(t);
			if (position != -1) {
				return new AnchorHelper.FixedAnchorEx(getFigure(), position);
			}
		}
		return super.getSourceConnectionAnchor(connEditPart);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshTransparency();
		refreshShadow();
	}

	@Override
	protected NodeFigure createMainFigureWithSVG() {
		NodeFigure figure = createSVGNodePlate();
		// bug 494019: [Sequence Diagram] Opening Luna Sequence Diagram into Neon doesn't work : change the layout from DelegatingLayout to StackLayout
		figure.setLayoutManager(new DelegatingLayout() {
			/**
			 * Override it to verify type of constraint.
			 * 
			 * @see org.eclipse.draw2d.DelegatingLayout#layout(org.eclipse.draw2d.IFigure)
			 */
			@Override
			public void layout(IFigure parent) {
				List<?> children = parent.getChildren();
				for (int i = 0; i < children.size(); i++) {
					IFigure child = (IFigure) children.get(i);

					Object locator = getConstraint(child);
					if (locator instanceof Locator) {
						((Locator) locator).relocate(child);
					}
				}
			}
		});
		shape = createNodeShape();
		figure.add(shape, new FillParentLocator());
		setupContentPane(shape);
		return figure;
	}

	@Override
	protected NodeFigure createSVGNodePlate() {
		ExecutionSpecificationNodePlate svgNodePlateFigure= new ExecutionSpecificationNodePlate(this, -1, -1);
		svgNodePlateFigure.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(20))); // min height 20
		svgNodePlate = svgNodePlateFigure.withLinkLFEnabled();
		svgNodePlate.setDefaultNodePlate(createNodePlate());
		return svgNodePlate;
	}
	
}
