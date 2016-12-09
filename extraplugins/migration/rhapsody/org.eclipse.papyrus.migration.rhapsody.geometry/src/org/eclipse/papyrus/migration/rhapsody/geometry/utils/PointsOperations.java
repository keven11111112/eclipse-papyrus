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
package org.eclipse.papyrus.migration.rhapsody.geometry.utils;

import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryFactory;

public class PointsOperations {

	public static Point add(Point point1, Point point2) {
		Point ret= RhpGeometryFactory.eINSTANCE.createPoint();
		ret.setX(point1.getX()+ point2.getX());
		ret.setY(point1.getY()+ point2.getY());
		return ret;
	}

	public static Point minus(Point point) {
		Point ret= RhpGeometryFactory.eINSTANCE.createPoint();
		ret.setX(- point.getX());
		ret.setY(- point.getY());
		return ret;
	}

	public static Point minus(Point point1, Point point2) {
		Point ret= RhpGeometryFactory.eINSTANCE.createPoint();
		ret.setX(point1.getX()- point2.getX());
		ret.setY(point1.getY()- point2.getY());
		return ret;
	}

	public static Point getPoint(String string, String string2) {
		return getPoint(Double.parseDouble(string), Double.parseDouble(string2));
		
	}
	
	public static Point getPoint(double x, double y) {
		Point ret = RhpGeometryFactory.eINSTANCE.createPoint();
		ret.setX(x);
		ret.setY(y);
		return ret;
	}

	public static Integer getIntX(Point point) {
		return Integer.valueOf((int) Math.round(point.getX()));// initial code was : point.getX().intValue();
	}


	public static Integer getIntY(Point point) {
		return Integer.valueOf((int) Math.round(point.getY()));// initial code was : point.getY().intValue();
	}

}
