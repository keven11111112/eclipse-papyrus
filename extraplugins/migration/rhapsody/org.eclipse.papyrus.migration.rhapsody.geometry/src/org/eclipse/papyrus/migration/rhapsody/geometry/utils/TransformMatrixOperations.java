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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryFactory;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;

public class TransformMatrixOperations {
	
	
	private static List<String> fixList(List<String> transformList) {
		List<String> ret = new ArrayList<>(transformList.size());
		int sourceIndex=0;
		int targetIndex =0;
		while(sourceIndex< transformList.size()){
			String current = transformList.get(sourceIndex);
			if (current.startsWith("e") && sourceIndex>0 ){
				String previous= transformList.get(sourceIndex-1);
				current = previous + current;
				ret.set(targetIndex-1, current);		
				sourceIndex++;
			}else {
				ret.add(targetIndex, current);
				sourceIndex++;
				targetIndex++;
			}
			
		}
		return ret;
	}

	
	public static TransformMatrix createMatrix(List<String> transformList){
		List<String> fixedList = fixList(transformList);
		TransformMatrix transform = RhpGeometryFactory.eINSTANCE.createTransformMatrix();
		
		transform.setA(Double.parseDouble(fixedList.get(0)));
		transform.setB(Double.parseDouble(fixedList.get(1)));
		transform.setC(Double.parseDouble(fixedList.get(2)));
		transform.setD(Double.parseDouble(fixedList.get(3)));
		transform.setE(Double.parseDouble(fixedList.get(4)));
		transform.setF(Double.parseDouble(fixedList.get(5)));
		
		return transform;
	}
	
	public static TransformMatrix add(TransformMatrix matrix1, TransformMatrix matrix2) {
		TransformMatrix ret = RhpGeometryFactory.eINSTANCE.createTransformMatrix();
		ret.setA(matrix1.getA() + matrix2.getA());
		ret.setB(matrix1.getB() + matrix2.getB());
		ret.setC(matrix1.getC() + matrix2.getC());
		ret.setD(matrix1.getD() + matrix2.getD());
		ret.setE(matrix1.getE() + matrix2.getE());
		ret.setF(matrix1.getF() + matrix2.getF());
		return ret;
	}
	
	public static TransformMatrix minus(TransformMatrix matrix1, TransformMatrix matrix2) {
		TransformMatrix ret = RhpGeometryFactory.eINSTANCE.createTransformMatrix();
		ret.setA(matrix1.getA() - matrix2.getA());
		ret.setB(matrix1.getB() - matrix2.getB());
		ret.setC(matrix1.getC() - matrix2.getC());
		ret.setD(matrix1.getD() - matrix2.getD());
		ret.setE(matrix1.getE() - matrix2.getE());
		ret.setF(matrix1.getF() - matrix2.getF());
		return ret;
	}
	
	
	public static TransformMatrix minus(TransformMatrix matrix) {
		TransformMatrix ret = RhpGeometryFactory.eINSTANCE.createTransformMatrix();
		ret.setA(-matrix.getA());
		ret.setB(-matrix.getB());
		ret.setC(-matrix.getC());
		ret.setD(-matrix.getD());
		ret.setE(-matrix.getE());
		ret.setF(-matrix.getF());
		return ret;
	}
	

	public static Point multiply(TransformMatrix matrix ,Point point) {
		Point ret= RhpGeometryFactory.eINSTANCE.createPoint();
		//cf https://www.w3.org/TR/SVG/coords.html
		Double x = (matrix.getA()* point.getX()) + (matrix.getC()*point.getY() ) +matrix.getE();
		Double y = (matrix.getB() * point.getX() ) + (matrix.getD()* point.getY()+ matrix.getF());
		
		ret.setX(x);
		ret.setY(y);
		
		return ret;
	}
	
	
	public static TransformMatrix multiply(TransformMatrix matrix1, TransformMatrix matrix2) {
		TransformMatrix ret = RhpGeometryFactory.eINSTANCE.createTransformMatrix();
		//cf  https://www.w3.org/TR/SVG/coords.html
		ret.setA(matrix1.getA()*matrix2.getA() +  matrix1.getC()*matrix2.getB());
		ret.setB(matrix1.getB()*matrix2.getA() +  matrix1.getD()*matrix2.getB());
		ret.setC(matrix1.getA()*matrix2.getC() +  matrix1.getC()*matrix2.getD());
		ret.setD(matrix1.getB()*matrix2.getC() +  matrix1.getD()*matrix2.getD());
		ret.setE(matrix1.getA()*matrix2.getE() +  matrix1.getC()*matrix2.getF()+ matrix1.getE());
		ret.setF(matrix1.getB()*matrix2.getE() +  matrix1.getD()*matrix2.getF()+ matrix1.getF());
		
		return ret;
	}


	public static TransformMatrix getIdentityTransform() {
		TransformMatrix ret = RhpGeometryFactory.eINSTANCE.createTransformMatrix();
		ret.setA(1.0);
		ret.setB(0.0);
		ret.setC(0.0);
		ret.setD(1.0);
		ret.setE(0.0);
		ret.setF(0.0);
		
		return ret;
	}
}
