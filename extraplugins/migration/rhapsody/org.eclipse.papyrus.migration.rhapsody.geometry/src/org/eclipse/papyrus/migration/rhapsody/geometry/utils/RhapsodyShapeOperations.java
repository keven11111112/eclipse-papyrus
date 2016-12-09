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
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryFactory;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIPortConnector;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

public class RhapsodyShapeOperations {

	public static String M_POLYGON_FEATURE_NAME = UMLRhapsodyPackage.eINSTANCE.getCGIGenericElement_M_polygon().getName();
	public static String M_PARENT_FEATURE_NAME = UMLRhapsodyPackage.eINSTANCE.getCGIGenericElement_M_pParent().getName();
	public static String M_TRANSFORM_FEATURE_NAME = UMLRhapsodyPackage.eINSTANCE.getCGIGenericElement_M_transform().getName();
	
	
	public static void initializeShape(RhapsodyShape rhpShape, EObject rhpMMObj) {
		initializeTransform(rhpShape, rhpMMObj);
		initializeRectangle(rhpShape, rhpMMObj);
		initializeParent(rhpShape, rhpMMObj);
		initializePositionAndSize(rhpShape);
		
	}
	
	public static RhapsodyShape createRhapsodyShape(GraphElementsType graphElement) {
		RhapsodyShape shape;
		if (isPort(graphElement)){
			shape =  RhpGeometryFactory.eINSTANCE.createRhapsodyPort();
		}else {
			shape = RhpGeometryFactory.eINSTANCE.createRhapsodyShape();
		}
		
		shape.setRhapsodyMetamodelObject(graphElement);
		return shape;
	}


	
	private static boolean isPort(GraphElementsType graphElement) {
		
		return graphElement instanceof CGIPortConnector;
	}

	public static void initializePositionAndSize(RhapsodyShape rhpShape) {
		Point point ;
		if (rhpShape.getRectangle() == null){
			point = PointsOperations.getPoint("0", "0");
		}else {
			point = rhpShape.getRectangle().getTopLeft();
		}
		TransformMatrix transfo = rhpShape.getTransform();
		
		RhapsodyShape parentShape = rhpShape.getParent();
		
		while (parentShape != null && parentShape.getTransform() != null){
			transfo = parentShape.getTransform().multiply(transfo);
			parentShape = parentShape.getParent();
		}
		Point absoluteTopLeft = transfo.multiply(point);
		rhpShape.setAbsolutePosition(absoluteTopLeft);
		
		if (rhpShape.getParent()==null){
			rhpShape.setParentRelativePosition(PointsOperations.getPoint("0", "0"));
		}else {
			rhpShape.setParentRelativePosition(absoluteTopLeft.minus(rhpShape.getParent().getAbsolutePosition()));
		}
		
		if(rhpShape.getRectangle()!= null){
			Point absoluteBottomRight = transfo.multiply(rhpShape.getRectangle().getBottomRight());
			Point relativeBottomRight = absoluteBottomRight.minus(absoluteTopLeft);
			rhpShape.setHeight(relativeBottomRight.getIntY());
			rhpShape.setWidth(relativeBottomRight.getIntX());
		}
	}





	private static List<RhapsodyShape> collectParentShapes(RhapsodyShape rhpShape) {
		Vector<RhapsodyShape> ret = new Vector<>();
		RhapsodyShape parent = rhpShape.getParent();
		while(parent !=null){
			ret.add(0, parent);
			parent = rhpShape.getParent();
		}
		return ret;
	}



	public static void initializeParent(RhapsodyShape rhpShape, EObject rhpMMObj) {
		Object parentObj = GeometryUtils.getFeatureValue(rhpMMObj,M_PARENT_FEATURE_NAME);
		if (parentObj instanceof EObject){
			RhapsodyShape parentShape = RhpGeometryFactory.eINSTANCE.createRhapsodyShape();
			parentShape.setRhapsodyMetamodelObject((EObject) parentObj);
			rhpShape.setParent(parentShape);
		}
	}

	public static void initializeRectangle(RhapsodyShape rhpShape, EObject rhpMMObj) {
		Object polygonObj = GeometryUtils.getFeatureValue(rhpMMObj, M_POLYGON_FEATURE_NAME);
		if (polygonObj instanceof List){
			@SuppressWarnings("unchecked")
			Rectangle rectangle = RectangleOperations.getRectangle((List<String>) polygonObj);
			rhpShape.setRectangle(rectangle);
		}
		
	}

	public static void initializeTransform(RhapsodyShape rhpShape, EObject rhpMMObj) {
		Object transformObj = GeometryUtils.getFeatureValue(rhpMMObj,M_TRANSFORM_FEATURE_NAME);
		if (transformObj instanceof EList && !((EList)transformObj).isEmpty()){
			@SuppressWarnings("unchecked")
			TransformMatrix transform= TransformMatrixOperations.createMatrix((EList<String>) transformObj);
			rhpShape.setTransform(transform);
		}else {
			rhpShape.setTransform(TransformMatrixOperations.getIdentityTransform());
		}
	}



	

	
}
