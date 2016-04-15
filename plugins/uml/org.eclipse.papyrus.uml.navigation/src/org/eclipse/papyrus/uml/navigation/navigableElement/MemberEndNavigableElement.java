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

import org.eclipse.uml2.uml.Property;

/**
 * Navigable element representing the target of a directed relationship
 *
 */
public class MemberEndNavigableElement extends GenericNavigableElement {

	public MemberEndNavigableElement(Property property) {
		super(property.getType());
	}

	@Override
	public String getLabel() {
		return "Go to member end type" + getElementLabel() + "...";
	}

	@Override
	public String getDescription() {
		return "Go to the member end type of this association:" + getElementLabel();
	}
}
