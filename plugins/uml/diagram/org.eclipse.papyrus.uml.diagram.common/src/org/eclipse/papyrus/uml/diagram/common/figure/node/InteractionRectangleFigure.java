/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Patrick Tessier (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;

public class InteractionRectangleFigure extends RoundedCompartmentFigure {


	/** The Internal Structure Compartment */
	private final static String INTERACTION_COMPARTMENT = "interactionCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(INTERACTION_COMPARTMENT);
		}
	};

	/**
	 * Constructor.
	 *
	 */
	public InteractionRectangleFigure() {
		this(null);
	}
	/**
	 * Create a new Classifier figure with the given tag
	 *
	 * @param tagLabel
	 *            a String that will be displayed at the top of the figure
	 */
	public InteractionRectangleFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
	}

	/**
	 * Get the attribute's compartment figure
	 *
	 * @return
	 */
	public IFigure getCompartmentFigure() {
		return getCompartment(INTERACTION_COMPARTMENT);
	}

}
