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
import org.eclipse.uml2.uml.Element;

/**
 * Navigable element representing the target of a directed relationship
 *
 */
public class SourceNavigableElement extends GenericNavigableElement {

	public SourceNavigableElement(DirectedRelationship relationship) {
		super(relationship.getSources().get(0));
	}
	
	public SourceNavigableElement(ActivityEdge edge) {
		super(edge.getSource());
	}
	
	public SourceNavigableElement(Element element) {
		super(element);
	}

	@Override
	public String getLabel() {
		return "Go to source" + getElementLabel() + "...";
	}

	@Override
	public String getDescription() {
		return "Go to the source:" + getElementLabel();
	}
}
