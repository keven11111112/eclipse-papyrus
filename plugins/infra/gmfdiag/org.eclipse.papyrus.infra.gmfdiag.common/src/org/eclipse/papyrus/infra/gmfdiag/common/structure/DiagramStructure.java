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

package org.eclipse.papyrus.infra.gmfdiag.common.structure;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

public abstract class DiagramStructure {

	public abstract String getVisualID(View view);

	public abstract String getModelID(View view);

	public abstract String getNodeVisualID(View containerView, EObject domainElement);

	public abstract boolean checkNodeVisualID(View containerView, EObject domainElement, String candidate);

	public abstract boolean isCompartmentVisualID(String visualID);

	public abstract boolean isSemanticLeafVisualID(String visualID);

}
