/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
