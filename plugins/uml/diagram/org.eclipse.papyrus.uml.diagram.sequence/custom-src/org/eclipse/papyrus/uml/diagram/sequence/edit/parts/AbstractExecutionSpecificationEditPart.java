package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
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
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.LinkLFSVGNodePlateFigure;
import org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AppliedStereotypeCommentCreationEditPolicyEx;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineEditPartUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCommentEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Add implementing IPapyrusEditPart to displaying Stereotypes.
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class AbstractExecutionSpecificationEditPart extends RoundedCompartmentEditPart {

	public static final String EXECUTION_FIX_ANCHOR_POSITION = "Execution Fix Anchor Position";

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
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableShapeEditPolicy() {

			@Override
			protected Command getResizeCommand(ChangeBoundsRequest request) {
				CompoundCommand command = new CompoundCommand();
				command.add(super.getResizeCommand(request));
				EditPart host = getHost();
				LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(host);
				// Calculate children levels
				List<ShapeNodeEditPart> movedChildrenParts = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts((ShapeNodeEditPart) host);
				List<ShapeNodeEditPart> testChildrenParts = new ArrayList<ShapeNodeEditPart>(movedChildrenParts);
				HashMap<ShapeNodeEditPart, Integer> childrenLevels = new HashMap<ShapeNodeEditPart, Integer>();
				Integer currentLevel = 0;
				while (!testChildrenParts.isEmpty()) {
					currentLevel++;
					List<ShapeNodeEditPart> testChildrenPartsNew = new ArrayList<ShapeNodeEditPart>(testChildrenParts);
					HashMap<ShapeNodeEditPart, Integer> childrenLevelsNew = new HashMap<ShapeNodeEditPart, Integer>(childrenLevels);
					for (ShapeNodeEditPart child : testChildrenParts) {
						IFigure figure = child.getFigure();
						Rectangle childRect = figure.getBounds().getCopy();
						if (figure instanceof HandleBounds) {
							childRect = ((HandleBounds) figure).getBounds().getCopy();
						}
						movedChildrenParts.remove(child);
						ShapeNodeEditPart parentTest = LifelineXYLayoutEditPolicy.getParent(lifelinePart, childRect, movedChildrenParts);
						movedChildrenParts.add(child);
						if (childrenLevels.containsKey(parentTest) || parentTest == null) {
							testChildrenPartsNew.remove(child);
							childrenLevelsNew.put(child, currentLevel);
						}
					}
					childrenLevels = childrenLevelsNew;
					testChildrenParts = testChildrenPartsNew;
				}
				// Fetch basic coords
				Rectangle rectRequest = getInitialFeedbackBounds().getCopy();
				getHostFigure().translateToAbsolute(rectRequest);
				rectRequest.translate(0, request.getMoveDelta().y);
				rectRequest.resize(0, request.getSizeDelta().height);
				for (ShapeNodeEditPart child : movedChildrenParts) {
					IFigure figure = child.getFigure();
					Rectangle originalRect = figure.getBounds().getCopy();
					if (figure instanceof HandleBounds) {
						originalRect = ((HandleBounds) figure).getBounds().getCopy();
					}
					Integer level = childrenLevels.get(child);
					Rectangle r = rectRequest.getCopy();
					r.translate(0, level * LifelineXYLayoutEditPolicy.SPACING_HEIGHT);
					r.resize(0, -2 * level * LifelineXYLayoutEditPolicy.SPACING_HEIGHT);
					Rectangle translatedRect = originalRect.getCopy();
					figure.translateToAbsolute(translatedRect);
					if (translatedRect.y < r.y || translatedRect.bottom() > r.bottom()) {
						int moveAmount = 0;
						int resizeAmount = 0;
						if (translatedRect.y < r.y) {
							moveAmount = r.y - translatedRect.y;
							resizeAmount = moveAmount;
						} else { // translatedRect.bottom() > r.bottom()
							resizeAmount = translatedRect.bottom() - r.bottom();
						}
						if (translatedRect.height() - resizeAmount < figure.getMinimumSize().height()) {
							return UnexecutableCommand.INSTANCE;
						}
						// Resize child ES
						ChangeBoundsRequest esRequest = new ChangeBoundsRequest(org.eclipse.gef.RequestConstants.REQ_MOVE);
						esRequest.setEditParts(child);
						esRequest.setResizeDirection(PositionConstants.SOUTH);
						esRequest.setMoveDelta(new Point(0, moveAmount));
						esRequest.setSizeDelta(new Dimension(0, -resizeAmount));
						Command moveESCommand = LifelineXYLayoutEditPolicy.getResizeOrMoveChildrenCommand((LifelineEditPart) lifelinePart, esRequest, false, false, true);
						if (moveESCommand != null && !moveESCommand.canExecute()) {
							// forbid creation of the message if the es can't be moved correctly
							return UnexecutableCommand.INSTANCE;
						} else if (moveESCommand != null) {
							command.add(moveESCommand);
						}
					}
				}
				return command.unwrap();
			}

			@Override
			protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
				request.getMoveDelta().x = 0; // reset offset
				IFigure feedback = getDragSourceFeedbackFigure();
				PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
				getHostFigure().translateToAbsolute(rect);
				IFigure f = getHostFigure();
				Dimension min = f.getMinimumSize().getCopy();
				Dimension max = f.getMaximumSize().getCopy();
				IMapMode mmode = MapModeUtil.getMapMode(f);
				min.height = mmode.LPtoDP(min.height);
				min.width = mmode.LPtoDP(min.width);
				max.height = mmode.LPtoDP(max.height);
				max.width = mmode.LPtoDP(max.width);
				Rectangle originalBounds = rect.getCopy();
				rect.translate(request.getMoveDelta());
				rect.resize(request.getSizeDelta());
				if (min.width > rect.width) {
					rect.width = min.width;
				} else if (max.width < rect.width) {
					rect.width = max.width;
				}
				if (min.height > rect.height) {
					rect.height = min.height;
				} else if (max.height < rect.height) {
					rect.height = max.height;
				}
				if (rect.height == min.height && request.getSizeDelta().height < 0 && request.getMoveDelta().y > 0) { // shrink at north
					Point loc = rect.getLocation();
					loc.y = originalBounds.getBottom().y - min.height;
					rect.setLocation(loc);
					request.getSizeDelta().height = min.height - originalBounds.height;
					request.getMoveDelta().y = loc.y - originalBounds.y;
				}
				if (request.getSizeDelta().height == 0) { // moving
					EditPart parentBar = moveExecutionSpecificationFeedback(request, AbstractExecutionSpecificationEditPart.this, rect);
					if (parentBar == null) {
						parentBar = getParent();
					}
					// Highlight the parentBar when perform moving.
					HighlightUtil.unhighlight();
					HighlightUtil.highlight(parentBar);
				}
				feedback.translateToRelative(rect);
				feedback.setBounds(rect);
			}

			@Override
			protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
				super.eraseChangeBoundsFeedback(request);
				HighlightUtil.unhighlight();
			}
		});
		// install a editpolicy to display stereotypes
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

	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		Object feature = event.getFeature();
		if ((getModel() != null) && (getModel() == event.getNotifier())) {
			if (NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			} else if (NotationPackage.eINSTANCE.getLineTypeStyle_LineType().equals(feature)) {
				refreshLineType();
			}
		} else if (NotationPackage.eINSTANCE.getLocation_X().equals(feature) || NotationPackage.eINSTANCE.getLocation_Y().equals(feature) || NotationPackage.eINSTANCE.getSize_Height().equals(feature)
				|| NotationPackage.eINSTANCE.getSize_Width().equals(feature)) {
			getParent().refresh();
		} else if (UMLPackage.eINSTANCE.getExecutionSpecification_Finish().equals(feature) || UMLPackage.eINSTANCE.getExecutionSpecification_Start().equals(feature)) {
			if (executionSpecificationEndParts != null) {
				for (ExecutionSpecificationEndEditPart child : executionSpecificationEndParts) {
					removeChild(child);
					child.removeFromResource();
				}
				executionSpecificationEndParts = null;
			}
			refreshChildren();
		}
		refreshShadow();
	}

	public class ExecutionSpecificationRectangleFigure extends NodeNamedElementFigure { // RectangleFigure {

		public ExecutionSpecificationRectangleFigure() {
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(60)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(20)));
		}

		@Override
		public IFigure findMouseEventTargetAt(int x, int y) {
			// check children first instead of self
			IFigure f = findMouseEventTargetInDescendantsAt(x, y);
			if (f != null) {
				return f;
			}
			if (!containsPoint(x, y)) {
				return null;
			}
			if (isMouseEventTarget()) {
				return this;
			}
			return null;
		}

		@Override
		public IFigure findFigureAt(int x, int y, TreeSearch search) {
			if (search.prune(this)) {
				return null;
			}
			IFigure child = findDescendantAtExcluding(x, y, search);
			if (child != null) {
				return child;
			}
			if (!containsPoint(x, y)) {
				return null;
			}
			if (search.accept(this)) {
				return this;
			}
			return null;
		}
	}

	@Override
	public abstract ExecutionSpecificationRectangleFigure getPrimaryShape();

	// see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=385604
	protected ShapeNodeEditPart moveExecutionSpecificationFeedback(ChangeBoundsRequest request, AbstractExecutionSpecificationEditPart movedPart, PrecisionRectangle rect) {
		CustomLifelineEditPart lifelineEP = (CustomLifelineEditPart) movedPart.getParent();
		Rectangle copy = rect.getCopy();
		lifelineEP.getPrimaryShape().translateToRelative(copy);
		List<ShapeNodeEditPart> executionSpecificationList = LifelineEditPartUtil.getChildShapeNodeEditPart(lifelineEP);
		List<ShapeNodeEditPart> movedChildrenParts = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts(AbstractExecutionSpecificationEditPart.this);
		executionSpecificationList.remove(movedPart); // ignore current action and its children
		executionSpecificationList.removeAll(movedChildrenParts);
		ShapeNodeEditPart parentBar = LifelineXYLayoutEditPolicy.getParent(lifelineEP, copy, executionSpecificationList);
		Rectangle dotLineBounds = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();
		int dotLineBarLocationX = dotLineBounds.x + dotLineBounds.width / 2 - LifelineXYLayoutEditPolicy.EXECUTION_INIT_WIDTH / 2;
		if (parentBar == null) {
			if (dotLineBarLocationX < copy.x) { // there is no parent bar, move to the center dotline position
				int dx = dotLineBarLocationX - copy.x;
				request.getMoveDelta().x += dx;
				rect.x += dx;
			}
		} else {
			while (!executionSpecificationList.isEmpty()) {
				Rectangle parentBounds = parentBar.getFigure().getBounds();
				int width = parentBounds.width > 0 ? parentBounds.width : LifelineXYLayoutEditPolicy.EXECUTION_INIT_WIDTH;
				int x = parentBounds.x + width / 2 + 1; // affixed to the parent bar
				int dx = x - copy.x;
				rect.x += dx;
				request.getMoveDelta().x += dx;
				copy.x = x;
				// check again to see if the new bar location overlaps with existing bars
				ShapeNodeEditPart part = LifelineXYLayoutEditPolicy.getParent(lifelineEP, copy, executionSpecificationList);
				if (part == parentBar) {
					break;
				} else {
					// if overlaps, go on moving the bar to next x position
					parentBar = part;
				}
			}
		}
		return parentBar;
	}

	/**
	 * Override for add elements on ExecutionSpecification
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			return getParent().getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}

	@Override
	public void showTargetFeedback(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showTargetFeedback(request);
		}
		super.showTargetFeedback(request);
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseTargetFeedback(request);
		}
		super.eraseTargetFeedback(request);
	}

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
			if (connectionEditPart instanceof MessageEditPart) {
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
		if (connEditPart instanceof MessageEditPart) {
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
			if (connectionEditPart instanceof Message3EditPart) {
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
		if (connEditPart instanceof Message3EditPart) {
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
		figure.setLayoutManager(new DelegatingLayout());
		shape = createNodeShape();
		figure.add(shape, new FillParentLocator());
		setupContentPane(shape);
		return figure;
	}

	@Override
	protected NodeFigure createSVGNodePlate() {
		LinkLFSVGNodePlateFigure svgNodePlateFigure = new LinkLFSVGNodePlateFigure(this, -1, -1) {
			/**
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea(org.eclipse.draw2d.geometry.PrecisionPoint)
			 */
			@Override
			protected boolean isDefaultAnchorArea(PrecisionPoint p) {
				return false;
			}

			@Override
			public ConnectionAnchor getConnectionAnchor(String terminal) {
				// Use FixedAnchorEx for MessageSync, this will be invoked by mapConnectionAnchor(termial) operation.
				if (terminal != null && terminal.indexOf("{") != -1 && terminal.indexOf("}") != -1) {
					int position = AnchorHelper.FixedAnchorEx.parsePosition(terminal);
					if (PositionConstants.TOP == position || PositionConstants.BOTTOM == position) {
						return new AnchorHelper.FixedAnchorEx(this, position);
					}
				}
				return super.getConnectionAnchor(terminal);
			}
		};
		svgNodePlateFigure.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(20))); // min height 20
		svgNodePlate = svgNodePlateFigure.withLinkLFEnabled();
		svgNodePlate.setDefaultNodePlate(createNodePlate());
		return svgNodePlate;
	}
}
