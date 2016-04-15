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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.infra.services.navigation.service.NavigableElement;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationContributor;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * NavigationContributor to navigate from TypedElement to their Type
 *
 */
public class ActivityEdgeNavigationContributor implements NavigationContributor {

	public List<NavigableElement> getNavigableElements(Object fromElement) {
		List<NavigableElement> result = new LinkedList<NavigableElement>();
		
		Element element = UMLUtil.resolveUMLElement(fromElement);
		if (element instanceof ActivityEdge) {
			ActivityEdge edge = (ActivityEdge) element;
			
			if (edge.getTarget() != null) {
				result.add(new TargetNavigableElement(edge));
			}
			
			if (edge.getSource() != null) {
				result.add(new SourceNavigableElement(edge));
			}
		}

		return result;
	}
}
