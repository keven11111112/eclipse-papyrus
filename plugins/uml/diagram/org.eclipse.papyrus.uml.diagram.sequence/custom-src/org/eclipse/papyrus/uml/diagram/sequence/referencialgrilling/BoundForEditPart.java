/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;

/**
 * @author PT202707
 *
 */
public class BoundForEditPart {

	protected static Bounds getBounds(Node node){
		return (Bounds)	node.getLayoutConstraint();
	}
	public static int getHeightFromView(Node node){
		Bounds bounds=BoundForEditPart.getBounds(node);
		if( bounds.getHeight()!=-1){
			return bounds.getHeight();
		}
		else{
			if (node.getType().equals(CombinedFragmentEditPart.VISUAL_ID)){
				return 40;
			}
			return 100;
		}

	}
	public static int getWidthFromView(Node node){
		Bounds bounds=BoundForEditPart.getBounds(node);
		if( bounds.getWidth()!=-1){
			return bounds.getHeight();
		}
		else{
			if (node.getType().equals(CombinedFragmentEditPart.VISUAL_ID)){
				return 40;
			}
			return 100;
		}
	}

}
