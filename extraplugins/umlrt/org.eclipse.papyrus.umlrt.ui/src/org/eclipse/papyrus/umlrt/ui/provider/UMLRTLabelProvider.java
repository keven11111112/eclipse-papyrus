/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.umlrt.ui.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * UML-RT specific label provider.
 */
public class UMLRTLabelProvider extends UMLLabelProvider {

	/**
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider#getImage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param element
	 * @return
	 */
	@Override
	protected Image getImage(EObject element) {
		return super.getImage(element);
	}

}
