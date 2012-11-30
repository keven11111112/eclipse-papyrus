/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.BorderedScalableImageFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ShapeFlowLayout;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.NotificationManager;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ShapeService;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.Util;

/**
 * 
 * The decorator to represent shapes for a given view. This decorator adds a set of small
 * images provided by the {@link ShapeService}.
 * 3 positions are defined for the decoration :
 * <ul>
 * <li>if the representation is an affixed child node : in {@link PositionConstants#NORTH_WEST} or {@link PositionConstants#SOUTH_EAST} following its
 * position/parent and margin =1</li>
 * <li>else if the element is in a compartment list : {@link PositionConstants#EAST} and margin =-1</li>
 * <li>else {@link PositionConstants#SOUTH_EAST} and margin = -1</li>
 * </ul>
 */
public class ShapeDecorator extends AbstractDecorator implements NotificationListener {

	protected NotificationManager notificationManager;

	/** default vertical margin */ 
	protected static final int MARGIN_HEIGHT = 4;
	
	/** default horizontal margin */
	protected static final int MARGIN_WIDTH = 4;
	
	/** default image height */
	protected static final int IMAGE_WIDTH = 36; // 32
	
	/** default image width */
	protected static final int IMAGE_HEIGHT = 36; // 32
	
	/**
	 * Creates a new <code>ShapeDecorator</code> for the decorator target
	 * passed in.
	 * 
	 * @param decoratorTarget
	 *        the object to be decorated
	 */
	public ShapeDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	/**
	 * getDecoratorTargetClassifier Utility method to determine if the
	 * decoratorTarget is a supported type for this decorator and return the
	 * associated Classifier element.
	 * 
	 * @param decoratorTarget
	 *        IDecoratorTarget to check and return valid Classifier target.
	 * @return node Node if IDecoratorTarget can be supported, null otherwise.
	 */
	static public Node getDecoratorTargetNode(IDecoratorTarget decoratorTarget) {
		DescriptionStyle descStyle = null;
		View node = (View)decoratorTarget.getAdapter(View.class);
		if(node != null && !(node instanceof Diagram)) {
			descStyle = (DescriptionStyle)node.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());

			if(descStyle != null) {
				return (Node)node;
			}
		}
		return null;

	}

	/**
	 * Creates the appropriate review decoration if all the criteria is
	 * satisfied by the view passed in.
	 */

	public void refresh() {
		removeDecoration();
		
		Node node = getDecoratorTargetNode(getDecoratorTarget());
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);

		// should check if the shapes decorations are asked to be drawn
		
		if(node != null) {
			DescriptionStyle descStyle = getDescriptionStyle(node);

			if(descStyle != null) {
				boolean hasShapes = ShapeService.getInstance().hasShapeToDisplay(node);
				if(hasShapes) {
					List<RenderedImage> shapesToDisplay = ShapeService.getInstance().getShapesToDisplay(node);
					if(!shapesToDisplay.isEmpty()) {
						IFigure figure = new Figure();
						//figure.setBorder(new LineBorder(1));
						IMapMode mm = MapModeUtil.getMapMode(((IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class)).getFigure());
						figure.setSize(mm.DPtoLP(shapesToDisplay.size()*IMAGE_WIDTH), mm.DPtoLP(IMAGE_HEIGHT));
						figure.setLayoutManager(new ShapeFlowLayout());

						for(RenderedImage image : shapesToDisplay) {
							BorderedScalableImageFigure subFigure = new BorderedScalableImageFigure(image, false, false, true);
							figure.add(subFigure);	
						}
						
						if(isInCompartmentList(node) && !Util.isAffixedChildNode(gep)) {
							setDecoration(getDecoratorTarget().addShapeDecoration(figure, getDirection(node), -1, false));
						} else {
							Locator locator = new OverlayLocator(gep.getFigure(), getDirection(node));
							setDecoration(getDecoratorTarget().addDecoration(figure, locator, false));
						}
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		refresh();
	}

	/**
	 * Returns the direction to set the decorator for the node
	 * 
	 * @param node
	 *        the node
	 * @return the direction to set the decorator for the node direction can be
	 *         :
	 *         <ul>
	 *         <li> {@link PositionConstants#NORTH_WEST} or {@link PositionConstants#SOUTH_EAST}</li> if the node is an Affixed Child Node
	 *         <li>{@link PositionConstants#EAST}</li> if the node is in a compartment list
	 *         <li>{@link PositionConstants#SOUTH_EAST}</li> in other cases
	 *         </ul>
	 */
	protected Direction getDirection(Node node) {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		assert gep != null;
		if(gep.getParent() != null) {
			if(isInCompartmentList(node) && !Util.isAffixedChildNode(gep)) {
				return IDecoratorTarget.Direction.EAST;
			}
		}
		return IDecoratorTarget.Direction.NORTH_WEST;
	}

	/**
	 * Tests if the compartment is a compartment list
	 * 
	 * @param node
	 *        the node on which we want add an Overlay
	 * @return <code>true</code> if the compartment is managed by an {@link XYLayoutEditPolicy}
	 */
	protected boolean isInCompartmentList(Node node) {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		if(gep != null && gep.getRoot() != null) {
			EObject container = node.eContainer();
			if(container instanceof View) {
				EditPart EP = DiagramEditPartsUtil.getEditPartFromView((View)container, gep);
				EditPolicy editPolicy = EP.getEditPolicy(EditPolicy.LAYOUT_ROLE);
				if(!(editPolicy instanceof XYLayoutEditPolicy)) { // we are in a compartment list
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * getDescriptionStyle Accessor to retrieve the description style from a
	 * Node.
	 * 
	 * @param node
	 *        Node to retrieve the description style from.
	 * @return DescriptionStyle style object
	 */
	protected DescriptionStyle getDescriptionStyle(Node node) {
		return (DescriptionStyle)node.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());
	}

	/**
	 * Adds listeners on
	 * <ul>
	 * <li>Affixed Child Node</li>
	 * <li>graphical parent, when its a {@link Property} (we add the listener on its Type)</li>
	 * </ul>
	 */
	public void activate() {
		View view = getView();
		if(view == null) {
			return;
		}
		// listens for modifications on the container of the compartment, i.e. the figure that handle stereotype management (ClassifierView for example)
		notificationManager = ShapeService.getInstance().createNotificationManager(getDiagramEventBroker(), view.eContainer(), this);
	}

	/**
	 * Removes the listeners and the decorations
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		notificationManager.dispose();
		notificationManager = null;
		super.deactivate();
	}

	protected View getView() {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		if(gep ==null) {
			return null;
		}
		View view = ((View)gep.getModel());
		return view;
	}

	protected TransactionalEditingDomain getTransactionalEditingDomain(IGraphicalEditPart editPart) {
		if(editPart!=null) {
			return editPart.getEditingDomain();
		}
		return null;
	}
	
	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain(gep);
		if(editingDomain != null) {
			return DiagramEventBroker.getInstance(editingDomain);
		}
		return null;
	}

	public class OverlayLocator implements Locator {

		/** the reference figure */
		private IFigure reference;

		/** the Overlay Position */
		private Direction position = null;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param reference
		 *        the reference figure
		 * @param position
		 *        the overlay position
		 */
		public OverlayLocator(IFigure reference, IDecoratorTarget.Direction position) {
			assert reference != null;
			this.reference = reference;
			this.position = position;
		}

		/**
		 * 
		 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
		 * 
		 * @param target
		 *        the overlay figure to locate
		 */
		public void relocate(IFigure target) {
			Rectangle bounds = reference instanceof HandleBounds ? new PrecisionRectangle(((HandleBounds)reference).getHandleBounds()) : new PrecisionRectangle(reference.getBounds());

			reference.translateToAbsolute(bounds);
			target.translateToRelative(bounds);

			int width = IMAGE_WIDTH;
			int height = IMAGE_HEIGHT;
			// retrieve the lisf of scalable figures => children of the child.
			if(target.getChildren().size() == 1)  {
				IFigure parentFigure = (IFigure)target.getChildren().get(0);
				if(parentFigure.getChildren().size() > 1 ){
					width = parentFigure.getChildren().size()*IMAGE_WIDTH + (parentFigure.getChildren().size() -  1) * MARGIN_WIDTH /* margin inside */;
				}
			} 

			if(Direction.NORTH_WEST.equals(this.position)) {
				target.setLocation(bounds.getTopLeft().getTranslated(MARGIN_WIDTH, MARGIN_HEIGHT));
			} else if(Direction.NORTH.equals(this.position)) {
				target.setLocation(bounds.getTop().getTranslated(0, MARGIN_HEIGHT));
			} else if(Direction.NORTH_EAST.equals(this.position)) {
				target.setLocation(bounds.getTopRight().getTranslated(-MARGIN_WIDTH - width,  MARGIN_HEIGHT));
			} else if(Direction.SOUTH_WEST.equals(this.position)) {
				target.setLocation(bounds.getBottomLeft().getTranslated(MARGIN_WIDTH, -MARGIN_HEIGHT - height));
			} else if(Direction.SOUTH.equals(this.position)) {
				target.setLocation(bounds.getBottom().getTranslated(0, -MARGIN_HEIGHT-height));
			} else if(Direction.SOUTH_EAST.equals(this.position)) {
				target.setLocation(bounds.getBottomRight().getTranslated(-MARGIN_WIDTH - width, -MARGIN_HEIGHT-height));
			} else if(Direction.WEST.equals(this.position)) {
				target.setLocation(bounds.getLeft().getTranslated(MARGIN_WIDTH, 0));
			} else if(Direction.EAST.equals(this.position)) {
				target.setLocation(bounds.getRight().getTranslated(-MARGIN_WIDTH-width, 0));
			} else if(Direction.CENTER.equals(this.position)) {
				target.setLocation(bounds.getCenter().getTranslated(0, 0));
			}
			
			//IMapMode mm = MapModeUtil.getMapMode(((IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class)).getFigure());
			//target.setSize(mm.DPtoLP(width), mm.DPtoLP(height));
		}
	}
}
