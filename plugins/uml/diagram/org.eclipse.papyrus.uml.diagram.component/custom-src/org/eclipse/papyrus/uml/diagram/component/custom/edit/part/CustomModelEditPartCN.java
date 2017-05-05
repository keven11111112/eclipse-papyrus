/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageFigure;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;

/**
 * this a specific editpart used to overload the method createNodePlate
 * @since 3.0
 */
public class CustomModelEditPartCN extends ModelEditPartCN {

	protected static final String ICONS_PATH = "icons/Triangle.gif"; //$NON-NLS-1$

	/**
	 *
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomModelEditPartCN(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IFigure createNodeShape() {
		primaryShape = new PackageFigure();
		((PackageFigure) primaryShape).setTagIcon(Activator.getPluginIconImage(Activator.ID, ICONS_PATH));
		return primaryShape;
	}
}
