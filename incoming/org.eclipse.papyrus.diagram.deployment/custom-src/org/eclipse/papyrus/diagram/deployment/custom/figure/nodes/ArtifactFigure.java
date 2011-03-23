/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.diagram.deployment.custom.figure.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.diagram.common.figure.node.CompartmentFigure;
import org.eclipse.papyrus.diagram.deployment.part.UMLDiagramEditorPlugin;


// TODO: Auto-generated Javadoc
/**
 * The Class ArtifactFigure.
 */
public class ArtifactFigure extends CompartmentFigure {


	/** The Internal Structure Compartment. */
	private final static String COMPOSITE_COMPARTMENT = "compositeCompartment";

	/** The List of Compartment. */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(COMPOSITE_COMPARTMENT);
		}
	};

	/**
	 * Instantiates a new artifact figure.
	 */
	public ArtifactFigure() {
		this("artifact");
	}

	/**
	 * Instantiates a new artifact figure.
	 * 
	 * @param tagvalue
	 *        the tagvalue
	 */
	public ArtifactFigure(String tagvalue) {
		super(COMPARTMENT, tagvalue);
		ImageDescriptor IMG_DESC = UMLDiagramEditorPlugin.getBundledImageDescriptor("icons/obj16/ArtifactIcon.gif");
		setAppliedStereotypeIcon(IMG_DESC.createImage(), PositionConstants.RIGHT);
	}

	/**
	 * Gets the composite compartment figure.
	 * 
	 * @return the composite compartment figure
	 */
	public IFigure getCompositeCompartmentFigure() {
		return getCompartment(COMPOSITE_COMPARTMENT);
	}

}
