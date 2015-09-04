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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers;

import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * Command handler that configures synchronization of select nodes (as subsets of a diagram),
 * with special consideration for the redefinition correspondence semantics of state machines
 * in the UML-RT style.
 */
public class SynchronizeNodesHandler extends AbstractSynchronizeViewsHandler<Node, NodeEditPart> {

	public SynchronizeNodesHandler() {
		super(Node.class, NodeEditPart.class);
	}
}
