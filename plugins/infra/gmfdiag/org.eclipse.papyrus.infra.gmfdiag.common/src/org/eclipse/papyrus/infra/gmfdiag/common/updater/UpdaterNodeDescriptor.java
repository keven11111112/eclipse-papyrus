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

package org.eclipse.papyrus.infra.gmfdiag.common.updater;

import org.eclipse.emf.ecore.EObject;

/**
 * @since 2.0
 */
public class UpdaterNodeDescriptor {

	private final EObject myModelElement;

	private final String myVisualID;

	public UpdaterNodeDescriptor(EObject modelElement, String visualID) {
		myModelElement = modelElement;
		myVisualID = visualID;
	}

	public EObject getModelElement() {
		return myModelElement;
	}

	public String getVisualID() {
		return myVisualID;
	}

}
