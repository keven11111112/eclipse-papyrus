/*****************************************************************************
 * Copyright (c) 2010-2017 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 521312
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class MessageFound extends MessageFigure {

	/**
	 * Constructor.
	 *
	 */
	public MessageFound() {
	}

	/**
	 * Constructor.
	 *
	 * @param mapMode
	 */
	public MessageFound(IMapMode mapMode) {
		super(mapMode);
		this.setForegroundColor(ColorConstants.black);
		setSourceDecoration(createSourceDecoration());
	}

	/**
	 * @since 3.0
	 */
	protected RotatableDecoration createSourceDecoration() {
		EllipseDecoration df = new EllipseDecoration();
		df.setPreferredSize(new Dimension(10, 10));
		df.setAlwaysFill(true);
		return df;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.figures.MessageFigure#createTargetDecoration()
	 *
	 * @return
	 */
	@Override
	protected RotatableDecoration createTargetDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		df.setForegroundColor(getForegroundColor());
		return df;
	}
}
