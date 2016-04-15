/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Shuai Li (CEA LIST) shuai.li@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.navigation.navigableElement;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.DirectedRelationship;

/**
 * Navigable element representing the target of a directed relationship
 *
 */
public class TargetNavigableElement extends GenericNavigableElement {

	public TargetNavigableElement(DirectedRelationship relationship) {
		super(relationship.getTargets().get(0));
	}
	
	public TargetNavigableElement(ActivityEdge edge) {
		super(edge.getTarget());
	}

	@Override
	public String getLabel() {
		return "Go to target" + getElementLabel() + "...";
	}

	@Override
	public String getDescription() {
		return "Go to the target:" + getElementLabel();
	}
}
