/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.geometry.custom;

import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RectangleImpl;
import org.eclipse.papyrus.migration.rhapsody.geometry.utils.RectangleOperations;

public class CustomRectangle extends RectangleImpl {

	@Override
	public Point getTopLeft() {
		return RectangleOperations.getTopLeft(this);
	}
	@Override
	public Point getTopRight() {
		return RectangleOperations.getTopRight(this);
	}
	@Override
	public Point getBottomRight() {
		return RectangleOperations.getBottomRight(this);
	}
	@Override
	public Point getBottomLeft() {
		return RectangleOperations.getBottomLeft(this);
	}

}
