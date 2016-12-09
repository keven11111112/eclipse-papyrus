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
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl;
import org.eclipse.papyrus.migration.rhapsody.geometry.utils.TransformMatrixOperations;

public class CustomTransformMatrix extends TransformMatrixImpl {

	@Override
	public TransformMatrix add(TransformMatrix matrix) {	
		return TransformMatrixOperations.add(this, matrix);
	}
	
	@Override
	public TransformMatrix minus(TransformMatrix matrix) {
		return TransformMatrixOperations.minus(this, matrix);
	}
	
	@Override
	public TransformMatrix minus() {
		return  TransformMatrixOperations.minus(this);
	}
	
	@Override
	public Point multiply(Point point) {
		return  TransformMatrixOperations.multiply(this, point);
	}
	
	@Override
	public TransformMatrix multiply(TransformMatrix matrix) {
		
		return  TransformMatrixOperations.multiply(this, matrix);
	}
}
