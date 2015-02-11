/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.GetChildLayoutEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.RoundedRectangleNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.common.editparts.FloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.locator.RoundedRectangleLabelPositionLocator;

public class CustomActivityEditPart extends ActivityEditPart {

	/** The Constant CORNER_HEIGHT. */
	private static final int CORNER_HEIGHT = 15;

	/** The Constant CORNER_WIDTH. */
	private static final int CORNER_WIDTH = 15;

	/**
	 * Constructor.
	 *
	 * @param view
	 *            the view
	 */
	public CustomActivityEditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.parts.BroadcastSignalActionEditPart#createDefaultEditPolicies()
	 *
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new GetChildLayoutEditPolicy());
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.parts.BroadcastSignalActionEditPart#createNodePlate()
	 *
	 * @return
	 */
	@Override
	protected NodeFigure createNodePlate() {
		String prefElementId = "Activity";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.HEIGHT);
		DefaultSizeNodeFigure result = new RoundedRectangleNodePlateFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));

		// DefaultSizeNodeFigure result = new RoundedRectangleNodePlateFigure(-20, -20);
		return result;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.parts.BroadcastSignalActionEditPart#addBorderItem(org.eclipse.draw2d.IFigure, org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart)
	 *
	 * @param borderItemContainer
	 * @param borderItemEditPart
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof FloatingLabelEditPart) {
			// Create specific locator
			RoundedRectangleLabelPositionLocator locator = new RoundedRectangleLabelPositionLocator(getMainFigure(), PositionConstants.SOUTH);
			// Offset from the parent for the attached case
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * Gets the default corner height.
	 *
	 * @return the default corner height
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart#getDefaultCornerHeight()
	 */
	@Override
	protected int getDefaultCornerHeight() {
		return CORNER_HEIGHT;
	}

	/**
	 * Gets the default corner width.
	 *
	 * @return the default corner width
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart#getDefaultCornerWidth()
	 */
	@Override
	protected int getDefaultCornerWidth() {
		return CORNER_WIDTH;
	}

}