/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Remove old implementation to generic shape uses
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.draw2d;

import java.util.Collections;

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure;

/**
 * Figure for structured activity node and its derived element
 *
 * @author arthur daussy
 *
 */
public class StructuredActivityNodeFigure extends RoundedCompartmentFigure {

	/**
	 * Compartment for activity node
	 */
	private static final String STRUCTURED_ACTIVITY_NODE_COMPARTMENT = "StructuredActivityNodeCompartment";

	/**
	 * Constructor
	 */
	public StructuredActivityNodeFigure() {
		super(Collections.singletonList(STRUCTURED_ACTIVITY_NODE_COMPARTMENT));
	}

	/**
	 * Compartment for activity node
	 */
	public RectangleFigure getStructuredActivityNodeCompartment() {
		return getCompartment(STRUCTURED_ACTIVITY_NODE_COMPARTMENT);
	}

	/**
	 * Get the keywork compartment
	 *
	 * @return
	 */
	public WrappingLabel getKeyword() {
		return getNameLabel();
	}
}
