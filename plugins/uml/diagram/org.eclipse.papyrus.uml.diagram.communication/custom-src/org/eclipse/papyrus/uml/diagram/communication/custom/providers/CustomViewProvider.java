/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.providers;

import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.communication.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.communication.providers.UMLViewProvider;

/**
 * CustomViewProvider used to check the type of the diagram when creating an edge.
 * 
 * @since 3.1
 * 
 * @author Fanch BONNABESSE
 *
 */
public class CustomViewProvider extends UMLViewProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean provides(CreateEdgeViewOperation op) {
		if (!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
			return false; // foreign diagram
		}
		return super.provides(op);
	}

}
