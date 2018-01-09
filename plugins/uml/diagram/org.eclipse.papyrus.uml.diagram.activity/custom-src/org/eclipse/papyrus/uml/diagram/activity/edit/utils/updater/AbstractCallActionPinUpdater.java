/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   J�r�mie TATIBOUET (CEA LIST) - Initial API and implementation
 *   S�bastien REVOL (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater;

import java.util.List;

import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.OutputPin;

public abstract class AbstractCallActionPinUpdater<NodeType extends CallAction> extends AbstractInvocationActionPinUpdater<NodeType> {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.AbstractInvocationActionPinUpdater#updatePin(org.eclipse.uml2.uml.InvocationAction)
	 *
	 * @param node
	 */
	@Override
	public void updatePins(NodeType node) {
		super.updatePins(node);
		if (node.isSynchronous()) {
			this.update(node.getResults(), this.deriveResults(node));
		} else {
			node.getResults().clear();
		}
	}

	/**
	 * Derive the list of result pins for the CallAction
	 * 
	 * @param node
	 *            the call action for which result pins are derived
	 * 
	 * @return the list of derived result pins
	 */
	public abstract List<OutputPin> deriveResults(NodeType node);
}
