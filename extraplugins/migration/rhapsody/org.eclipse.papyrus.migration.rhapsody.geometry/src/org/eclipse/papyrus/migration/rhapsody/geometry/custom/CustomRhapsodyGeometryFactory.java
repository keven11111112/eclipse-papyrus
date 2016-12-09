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
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryFactoryImpl;

public class CustomRhapsodyGeometryFactory extends RhpGeometryFactoryImpl {
	@Override
	public RhapsodyPort createRhapsodyPort() {
		return new CustomRhapsodyPort();
	}

	@Override
	public RhapsodyShape createRhapsodyShape() {
		return new CustomRhapsodyShape();
	}

	@Override
	public TransformMatrix createTransformMatrix() {

		return new CustomTransformMatrix();
	}

	@Override
	public Rectangle createRectangle() {
		return new CustomRectangle();
	}
	
	@Override
	public Point createPoint() {
		return new CustomPoint();
	}

}
