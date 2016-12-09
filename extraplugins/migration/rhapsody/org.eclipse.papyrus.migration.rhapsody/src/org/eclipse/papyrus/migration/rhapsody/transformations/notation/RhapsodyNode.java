/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.transformations.notation;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;

/**
 * @author sr246418
 *
 */
public class RhapsodyNode {

	/**
	 * Constructor.
	 *
	 */
	
	int topLeft[];
	int topRight[];
	int bottomRight[];
	int bottomLeft[];
	
	float xPos;
	float yPos;
	
	float xRatio;
	float yRatio;
	
	
	
	public RhapsodyNode(List<String> polygon,  List<String> transform) {
	
			topLeft = new int[]{Integer.parseInt(polygon.get(1)),Integer.parseInt(polygon.get(2))};
			topRight =new int[] {Integer.parseInt(polygon.get(3)),Integer.parseInt(polygon.get(4))};
			bottomRight =new int[] {Integer.parseInt(polygon.get(5)),Integer.parseInt(polygon.get(6))};
			bottomLeft = new int[] {Integer.parseInt(polygon.get(7)),Integer.parseInt(polygon.get(8))};
			
			xPos = Float.parseFloat(transform.get(4));
			yPos = Float.parseFloat(transform.get(5));
			
			xRatio = Float.parseFloat(transform.get(0));
			yRatio = Float.parseFloat(transform.get(3));
			
	}
	
	
	public int getX(){
		return Math.round(xPos);
	}
	
	public int getY(){
		return Math.round(yPos);
	}
	
	public int getHeight(){
		return Math.round(yRatio *(bottomLeft[1]-topLeft[1]));
	}
	
	public int getWidth(){
		return Math.round(xRatio*(topRight[0]-topLeft[0]));
	}
	
	public int getRelativeHeight(){
		return (bottomLeft[1]-topLeft[1]);
	}
	
	public int getRelativeWidth(){
		return (topRight[0]-topLeft[0]);
	}
	
	
	public Anchor getAnchor(List<String> port){
		IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		int xPort =Integer.parseInt(port.get(0));
		if (xPort< topLeft[0]){
			xPort = topLeft[0];
		}
		if (xPort> topRight[0]){
			xPort = topRight[0];
		}
		
		int yPort = Integer.parseInt(port.get(1));
		if (yPort< topLeft[1]){
			yPort= topLeft[1];
		}
		if (yPort> bottomLeft[1]){
			yPort= bottomLeft[1];
		}
	
		float xRatio = new Float(xPort)/new Float(getRelativeWidth());
		float yRatio = new Float(yPort)/new Float(getRelativeHeight());
		
		if (xRatio >1){
			xRatio =1;
		}
		if(yRatio >1){
			yRatio = 1;
		}
		
		String id = "("+xRatio+","+yRatio+")";
		anchor.setId(id);
		return anchor;
		
	}
	
	
}
