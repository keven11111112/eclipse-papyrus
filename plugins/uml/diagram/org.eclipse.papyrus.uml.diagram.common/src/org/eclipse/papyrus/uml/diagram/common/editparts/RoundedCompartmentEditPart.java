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
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.PapyrusRoundedEditPartHelper;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;

/**
 * The Class RoundedCompartmentEditPart.
 */
public abstract class RoundedCompartmentEditPart extends NamedElementEditPart {

	/** The Constant DEFAULT_HAS_HEADER. True if has a header, as interaction figure */
	private static final boolean DEFAULT_HAS_HEADER = false;

	/** The Constant DEFAULT_BORDER_STYLE. */
	private static final int DEFAULT_BORDER_STYLE = Graphics.LINE_SOLID;

	/** The Constant DEFAULT_CORNER_HEIGHT. */
	private static final int DEFAULT_CORNER_HEIGHT = 0;

	/** The Constant DEFAULT_CORNER_WIDTH. */
	private static final int DEFAULT_CORNER_WIDTH = 0;

	private static final int[] DEFAULT_CUTOM_DASH = new int[] { 5, 5 };

	/** The Constant DEFAULT_FLOATING_LABEL_OFFSET_HEIGHT. */
	private static final int DEFAULT_FLOATING_LABEL_OFFSET_HEIGHT = 0;

	/** The Constant DEFAULT_FLOATING_LABEL_OFFSET_WIDTH. */
	private static final int DEFAULT_FLOATING_LABEL_OFFSET_WIDTH = 0;

	/** The Constant DEFAULT_IS_FLOATING_LABEL_CONSTRAINED. */
	private static final boolean DEFAULT_IS_FLOATING_LABEL_CONSTRAINED = false;

	/** The Constant DEFAULT_IS_OVAL. */
	private static final boolean DEFAULT_IS_OVAL = false;

	/** The Constant DEFAULT_IS_PACKAGE. */
	private static final boolean DEFAULT_IS_PACKAGE = false;

	/** The Constant DEFAULT_USE_ORIGINAL_COLORS. */
	private static final boolean DEFAULT_USE_ORIGINAL_COLORS = true;

	/** The Constant DEFAULT_SHADOW_WIDTH. */
	private static final int DEFAULT_SHADOW_WIDTH = 4;

	/**
	 * Instantiates a new rounded compartment edit part.
	 *
	 * @param view
	 *            the view
	 */
	public RoundedCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * Creates the default edit policies.
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// Install Edit Policy to Hide/show compartment, in particular for the symbol compartment
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
	}

	/**
	 * Refresh visuals.
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		// Refresh all visual settings for the Rounded Compartment Figure child
		PapyrusRoundedEditPartHelper.refreshRadius(this, getDefaultCornerWidth(), getDefaultCornerHeight());
		PapyrusRoundedEditPartHelper.refreshOval(this, getDefaultIsOvalValue());
		PapyrusRoundedEditPartHelper.refreshFloatingName(this, getDefaultIsFloatingNameConstrained(), getDefaultFloatingLabelOffsetWidth(), getDefaultFloatingLabelOffsetHeight());
		PapyrusRoundedEditPartHelper.refreshBorderStyle(this, getDefaultBorderStyle(), getDefaultCutomDash());
		PapyrusRoundedEditPartHelper.refreshHasHeader(this, getDefaultHasHeader());
		PapyrusRoundedEditPartHelper.refreshShadowWidth(this, getDefaultShadowWidth());
		PapyrusRoundedEditPartHelper.refreshPackage(this, getDefaultIsPackage());
		PapyrusRoundedEditPartHelper.refreshShadowColor(this, getDefaultShadowColor());
		super.refreshVisuals();
	}

	/**
	 * Gets the default shadow color.
	 *
	 * @return the default shadow color
	 */
	private String getDefaultShadowColor() {
		// When null the color is the same that the border line.
		return null;
	}

	/**
	 * Gets the default is package.
	 *
	 * @return the default is package
	 */
	protected boolean getDefaultIsPackage() {
		return DEFAULT_IS_PACKAGE;
	}

	/**
	 * Gets the default shadow width.
	 *
	 * @return the default shadow width
	 */
	private int getDefaultShadowWidth() {
		return DEFAULT_SHADOW_WIDTH;
	}

	/**
	 * Gets the default border style.
	 *
	 * @return the default border style
	 */
	protected int getDefaultBorderStyle() {
		return DEFAULT_BORDER_STYLE;
	}

	/**
	 * Gets the default corner height value.
	 *
	 * @return the default corner height value
	 */
	protected int getDefaultCornerHeight() {
		return DEFAULT_CORNER_HEIGHT;
	}

	/**
	 * Gets the default corner width value.
	 *
	 * @return the default corner width value
	 */
	protected int getDefaultCornerWidth() {
		return DEFAULT_CORNER_WIDTH;
	}

	/**
	 * Gets the default custom dash.
	 *
	 * @return the default custom dash
	 */
	private int[] getDefaultCutomDash() {
		return DEFAULT_CUTOM_DASH;
	}

	/**
	 * Gets the default floating name offset height.
	 *
	 * @return the default floating name offset height
	 */
	protected int getDefaultFloatingLabelOffsetHeight() {
		return DEFAULT_FLOATING_LABEL_OFFSET_HEIGHT;
	}

	/**
	 * Gets the default floating name offset width.
	 *
	 * @return the default floating name offset width
	 */
	protected int getDefaultFloatingLabelOffsetWidth() {
		return DEFAULT_FLOATING_LABEL_OFFSET_WIDTH;
	}

	/**
	 * Gets the default is name constrained.
	 *
	 * @return the default is name constrained
	 */
	protected boolean getDefaultIsFloatingNameConstrained() {
		return DEFAULT_IS_FLOATING_LABEL_CONSTRAINED;
	}

	/**
	 * Gets the default is oval value.
	 *
	 * @return the default is oval value
	 */
	protected boolean getDefaultIsOvalValue() {
		return DEFAULT_IS_OVAL;
	}

	/**
	 * Gets the default setting of use original colors.
	 *
	 * @return the default use original colors
	 */
	protected boolean getDefaultUseOriginalColors() {
		return DEFAULT_USE_ORIGINAL_COLORS;
	}

	/**
	 * Gets the default has header.
	 *
	 * @return the default has header
	 */
	protected boolean getDefaultHasHeader() {
		return DEFAULT_HAS_HEADER;
	}
}
