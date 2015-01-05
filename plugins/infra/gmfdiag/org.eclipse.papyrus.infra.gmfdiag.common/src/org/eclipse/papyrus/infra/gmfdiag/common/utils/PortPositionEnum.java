/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.utils;


/**
 * The Enum PortPositionEnum for the position of ports on border.
 *
 * @author Mickael ADAM
 */
public enum PortPositionEnum {

	/** The inside. */
	INSIDE("inside"), //$NON-NLS-N$

	/** The outside. */
	OUTSIDE("outside"), //$NON-NLS-N$

	/** The online. */
	ONLINE("onLine"); //$NON-NLS-N$

	/** The literal. */
	private String literal;

	/**
	 * Instantiates a new port position enum.
	 *
	 * @param literal
	 *            the literal
	 */
	private PortPositionEnum(String literal) {
		this.literal = literal;
	}

	/**
	 * Gets the literal.
	 *
	 * @return the literal
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return literal;
	}
}
