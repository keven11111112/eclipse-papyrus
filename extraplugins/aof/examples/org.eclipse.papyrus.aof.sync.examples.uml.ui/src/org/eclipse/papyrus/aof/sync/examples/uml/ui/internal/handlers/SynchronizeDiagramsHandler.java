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

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * Command handler that configures diagram-to-diagram synchronization, with special
 * consideration for the redefinition correspondence semantics of state machines
 * in the UML-RT style.
 */
public class SynchronizeDiagramsHandler extends AbstractSynchronizeViewsHandler<Diagram, DiagramEditPart> {

	public SynchronizeDiagramsHandler() {
		super(Diagram.class, DiagramEditPart.class);
	}
}
