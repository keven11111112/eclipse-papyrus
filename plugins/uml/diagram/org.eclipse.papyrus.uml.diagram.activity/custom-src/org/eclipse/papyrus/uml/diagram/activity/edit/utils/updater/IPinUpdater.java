/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jérémie TATIBOUET (CEA LIST) - Initial API and implementation
 *   Sébastien REVOL (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater;

import org.eclipse.uml2.uml.ActivityNode;

public interface IPinUpdater<NodeType extends ActivityNode> {

	/**
	 * The role of a 'pin updater' is to enable update of any pin of a particular activity node.
	 * This operation is intended to implement the the general algorithm to update pins.
	 * 
	 * @param node
	 *            the activity node for which the pins need to be updated
	 * 
	 */
	public void updatePins(NodeType node);

}
