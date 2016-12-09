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

import java.util.List;

import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryFactory;

public class RectangleOperations {

	public static Rectangle getRectangle(List<String> polygonList) {
		
		if(polygonList.size() ==9){
			Rectangle ret= RhpGeometryFactory.eINSTANCE.createRectangle();
			for(int i=1; i<polygonList.size(); i+=2){
				ret.getPoints().add(PointsOperations.getPoint(polygonList.get(i), polygonList.get(i+1)));
			}
			return ret;
		}
		return null;
	}


	public static Point getTopLeft(final Rectangle rectangle) {
		return rectangle.getPoints().get(0);
	}

	public static Point getTopRight(final Rectangle rectangle) {
		return rectangle.getPoints().get(1);
	}

	public static Point getBottomRight(final Rectangle rectangle) {
		return rectangle.getPoints().get(2);
	}

	public static Point getBottomLeft(final Rectangle rectangle) {
		return rectangle.getPoints().get(3);
	}
}
