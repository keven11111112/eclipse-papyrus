/*
 * Copyright (c) 2006, 2007, 2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - original templates
 *    Michael Golubev (Montages) - API extracted to gmf.tooling.runtime (#372479)
 */
package  org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update;

import org.eclipse.emf.ecore.EObject;

/**
 * @since 3.0
 */
public class UpdaterNodeDescriptor {

	private final EObject myModelElement;

	private final int myVisualID;

	public UpdaterNodeDescriptor(EObject modelElement, int visualID) {
		myModelElement = modelElement;
		myVisualID = visualID;
	}

	public EObject getModelElement() {
		return myModelElement;
	}

	public int getVisualID() {
		return myVisualID;
	}

}
