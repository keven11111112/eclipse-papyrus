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
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PointImpl;
import org.eclipse.papyrus.migration.rhapsody.geometry.utils.PointsOperations;

public class CustomPoint extends PointImpl {

	@Override
	public Point add(Point point) {
		return PointsOperations.add(this, point);
	}
	
	@Override
	public Point minus() {
		return PointsOperations.minus(this);
	}
	
	@Override
	public Point minus(Point point) {
		return PointsOperations.minus(this, point);
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PointImpl#getIntX()
	 *
	 * @return
	 */
	@Override
	public Integer getIntX() {
		return PointsOperations.getIntX(this);
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PointImpl#getIntY()
	 *
	 * @return
	 */
	@Override
	public Integer getIntY() {
		return PointsOperations.getIntY(this);
	}
}
