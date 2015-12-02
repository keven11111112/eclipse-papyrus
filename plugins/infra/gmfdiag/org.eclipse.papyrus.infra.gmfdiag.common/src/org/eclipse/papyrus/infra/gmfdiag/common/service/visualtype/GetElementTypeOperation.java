/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.service.visualtype;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * The {@link IVisualTypeProvider#getElementType(Diagram, String)} operation.
 */
public class GetElementTypeOperation implements IOperation, IVisualTypeOperation {

	private Diagram diagram;
	private String viewType;

	public GetElementTypeOperation(Diagram diagram, String viewType) {
		super();

		this.diagram = diagram;
		this.viewType = viewType;
	}

	@Override
	public Object execute(IProvider provider) {
		IElementType result = null;

		if (provider instanceof IVisualTypeProvider) {
			result = ((IVisualTypeProvider) provider).getElementType(diagram, viewType);
		}

		return result;
	}

	@Override
	public String getDiagramType() {
		return diagram.getType();
	}

}
