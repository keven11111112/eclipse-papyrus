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

/**
 * A private interface implemented by all {@link IVisualTypeProvider} operations.
 */
interface IVisualTypeOperation {
	/**
	 * Queries the type identifier of the diagram that is the context of the visual-type operation.
	 * 
	 * @return the contextual diagram type
	 */
	String getDiagramType();
}
