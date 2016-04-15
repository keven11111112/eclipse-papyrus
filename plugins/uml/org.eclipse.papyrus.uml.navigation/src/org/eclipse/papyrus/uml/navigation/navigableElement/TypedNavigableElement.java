/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.navigation.navigableElement;

import java.util.Collections;

import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.navigation.service.ExtendedNavigableElement;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * Navigates from a TypedElement to its Type declaration
 *
 * @author Camille Letavernier
 */
public class TypedNavigableElement extends GenericNavigableElement {
	/**
	 *
	 * @param type
	 *            The Type to navigate to. May be null.
	 */
	public TypedNavigableElement(Type type) {
		super(type);
	}

	public String getLabel() {
		String label = "Go to type" + getElementLabel() + "...";
		return label;
	}

	public String getDescription() {
		return "Go to the type of this typed element: " + getElementLabel();
	}
}
