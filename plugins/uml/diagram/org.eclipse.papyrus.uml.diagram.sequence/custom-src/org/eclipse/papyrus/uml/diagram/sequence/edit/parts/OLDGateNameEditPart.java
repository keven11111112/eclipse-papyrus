/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.geometry.Point;

/**
 * 1. Refactoring with a BorderItemLabelEditPart.
 * 2. Add displaying stereotypes.
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 * @since 3.0
 *
 * @deprecated
 */
@Deprecated
public class OLDGateNameEditPart {

	public static final String GATE_NAME_TYPE = "Gate_Name";

	static {
		BorderItemLabelEditPart.registerSnapBackPosition(GATE_NAME_TYPE, new Point(-32, 0));
	}

	@Deprecated
	private OLDGateNameEditPart() {
		// Deprecated
	}

}
