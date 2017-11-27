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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CCombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CLifeLineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;

/**
 * @author Patrick Tessier
 *
 */
public class BoundForEditPart {

	public static Bounds getBounds(Node node){
		return (Bounds)	node.getLayoutConstraint();
	}
	public static int getHeightFromView(Node node){
		Bounds bounds=BoundForEditPart.getBounds(node);
		if( bounds!=null&& bounds.getHeight()!=-1){
			return bounds.getHeight();
		}
		else{
			if (node.getType().equals(CombinedFragmentEditPart.VISUAL_ID)){
				return CCombinedFragmentEditPart.DEFAULT_HEIGHT;
			}
			if (node.getType().equals(InteractionOperandEditPart.VISUAL_ID)){
				return 40;
			}
			if(node.getType().equals(LifelineEditPart.VISUAL_ID)){
				return CLifeLineEditPart.DEFAUT_HEIGHT;
			}
			return 100;
		}

	}
	public static int getWidthFromView(Node node){
		Bounds bounds=BoundForEditPart.getBounds(node);
		if(bounds!=null&& bounds.getWidth()!=-1){
			return bounds.getWidth();
		}
		else{
			if (node.getType().equals(CombinedFragmentEditPart.VISUAL_ID)){
				return CCombinedFragmentEditPart.DEFAULT_HEIGHT;
			}
			if (node.getType().equals(InteractionOperandEditPart.VISUAL_ID)){
				return 100;
			}
			if(node.getType().equals(LifelineEditPart.VISUAL_ID)){
				return CLifeLineEditPart.DEFAUT_WIDTH;
			}
			return 100;
		}
	}

}
