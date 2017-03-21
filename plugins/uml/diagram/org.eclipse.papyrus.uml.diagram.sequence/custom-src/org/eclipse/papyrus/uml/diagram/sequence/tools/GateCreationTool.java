/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tools;

import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;

/**
 * Tool to create Gate for sequence diagram.
 */
public class GateCreationTool extends CreationTool {
	/**
	 * Constructor.
	 */
	public GateCreationTool() {
		super(new CreationFactory() {

			@Override
			public Object getObjectType() {
				return GateEditPart.GATE_TYPE;
			}

			@Override
			public Object getNewObject() {
				return GateEditPart.GATE_TYPE;
			}
		});
	}
}