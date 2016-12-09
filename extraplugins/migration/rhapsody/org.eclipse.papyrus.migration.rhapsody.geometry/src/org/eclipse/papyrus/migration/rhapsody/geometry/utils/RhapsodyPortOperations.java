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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

public class RhapsodyPortOperations extends RhapsodyShapeOperations{

	public static String M_POSITION_FEATURE_NAME = UMLRhapsodyPackage.eINSTANCE.getCGIPortConnector_M_position().getName();

	
	public static void initializeShape(RhapsodyPort rhpPort, EObject rhpMMObj) {
		initializeTransform(rhpPort, rhpMMObj);
		initializeRectangle(rhpPort, rhpMMObj);
		initializeParent(rhpPort, rhpMMObj);
		initializeParentEdge(rhpPort);
		initializePositionAndSize(rhpPort);		
		fixPortOffsets(rhpPort);
	}
	
	

	
	
	public static void initializeRectangle(RhapsodyShape rhpShape, EObject rhpMMObj) {
		Object polygonObj = GeometryUtils.getFeatureValue(rhpMMObj, M_POSITION_FEATURE_NAME);
		if (polygonObj instanceof List){
			@SuppressWarnings("unchecked")
			Rectangle rectangle = RectangleOperations.getRectangle((List<String>) polygonObj);
			rhpShape.setRectangle(rectangle);
		}
		
	}

	private static void fixPortOffsets(RhapsodyPort rhpPort) {
		double xOffset = 0;
		double yOffset = 0;

		// TODO : manage corner ?

		switch (rhpPort.getPosition()) {
		case EAST:
			
			//top left corner has turned of 90� to right and has become the top right corner
			yOffset=20;
			break;
		case NORTH:
			xOffset=20;
			break;
		case SOUTH:
			//top left has become bottom right
			xOffset =-40;
			break;
		case WEST:
			//top left has become  bottom left
			yOffset =-40;
			break;
		default:
			break;
		}
		Point offset = PointsOperations.getPoint(xOffset, yOffset);
		//Point offset = PointsOperations.getPoint(0, 0);
		Point absolutePosition = rhpPort.getAbsolutePosition();
		Point relativePosition = rhpPort.getParentRelativePosition();
		rhpPort.setAbsolutePosition(absolutePosition.add(offset));
		rhpPort.setParentRelativePosition(relativePosition.add(offset));
		
	}


	private static void initializeParentEdge(RhapsodyPort rhpPort) {
		TransformMatrix transform = rhpPort.getTransform();
		if (transform != null){
			boolean topOrBottom = transform.getB() ==0.0 || Math.abs(transform.getA()/transform.getB()) >100;
			if (topOrBottom){
				if (transform.getA() >0){
					rhpPort.setPosition(Position.NORTH);
				}else {
					rhpPort.setPosition(Position.SOUTH);
				}
			}else {
				if (transform.getB() >0){
					rhpPort.setPosition(Position.EAST);
				}else {
					rhpPort.setPosition(Position.WEST);
				}
			}
		}
		else {
			rhpPort.setPosition(Position.NORTH);
		}
	}



	

	
}
