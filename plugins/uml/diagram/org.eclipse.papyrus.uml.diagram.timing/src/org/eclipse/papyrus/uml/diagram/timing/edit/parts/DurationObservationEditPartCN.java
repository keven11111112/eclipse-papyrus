/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SelectableBorderedNodeFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.TimingDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.DimensioningArrowFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.locator.LabelInCompartmentLocator;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.DurationObservationItemSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class DurationObservationEditPartCN extends NodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 17;

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
	public DurationObservationEditPartCN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DurationObservationItemSemanticEditPolicyCN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new TimingDiagramDragDropEditPolicy());
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
				case DurationObservationNameEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						@Override
						protected List<?> createSelectionHandles() {
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
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new DimensioningArrowFigure();
	}

	/**
	 * org.eclipse.papyrus.uml.diagram.timing.custom.figures.DimensioningArrowFigure
	 * 
	 * @generated
	 */
	@Override
	public DimensioningArrowFigure getPrimaryShape() {
		return (DimensioningArrowFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof DurationObservationNameEditPart) {
			IBorderItemLocator locator = new LabelInCompartmentLocator(getMainFigure());
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(DurationObservationNameEditPart.VISUAL_ID));
	}
}
