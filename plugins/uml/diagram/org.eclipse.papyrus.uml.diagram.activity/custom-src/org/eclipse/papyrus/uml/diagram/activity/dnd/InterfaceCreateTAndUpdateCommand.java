/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.dnd;

import org.eclipse.gef.EditPart;

/**
 * Generic interface for CreateAndUpdate
 *
 *
 */
public interface InterfaceCreateTAndUpdateCommand {
 
	/**
	 * Tests whether the slot compartment edit part is available
	 * @param targetEditPart
	 * @return
	 */
	public boolean isSlotCompartmentAvailable(EditPart targetEditPart);

}
