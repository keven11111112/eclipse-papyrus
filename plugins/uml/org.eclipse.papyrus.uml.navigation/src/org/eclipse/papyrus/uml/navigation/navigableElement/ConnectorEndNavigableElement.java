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

import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * Navigable element representing the target of a directed relationship
 *
 */
public class ConnectorEndNavigableElement extends GenericNavigableElement {
	protected final ConnectorEndDerivedFeatureKind derivedFeatureKind;
	
	public enum ConnectorEndDerivedFeatureKind {
		DEFINING_END,
		PART_WITH_PORT,
		ROLE
	}

	public ConnectorEndNavigableElement(ConnectorEnd end, ConnectorEndDerivedFeatureKind derivedFeatureKind) {
		super(end.getRole());
		
		if (derivedFeatureKind == ConnectorEndDerivedFeatureKind.DEFINING_END) {
			this.element = end.getDefiningEnd();
		} else if (derivedFeatureKind == ConnectorEndDerivedFeatureKind.PART_WITH_PORT) {
			this.element = end.getPartWithPort();
		}
		
		this.derivedFeatureKind = derivedFeatureKind; 
		
		
	}

	@Override
	public String getLabel() {
		if (derivedFeatureKind == ConnectorEndDerivedFeatureKind.DEFINING_END) {
			return "Go to defining end" + getElementLabel() + "...";
		} else if (derivedFeatureKind == ConnectorEndDerivedFeatureKind.PART_WITH_PORT) {
			return "Go to part with port" + getElementLabel() + "...";
		}
		
		return "Go to role" + getElementLabel() + "...";
	}

	@Override
	public String getDescription() {
		return getLabel();
	}
}
