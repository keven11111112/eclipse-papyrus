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
 * The Enum PositionEnum.
 *
 * @author Mickael ADAM
 */
public enum PositionEnum {

	/** The north. */
	NORTH("NORTH", "north"), //$NON-NLS-N$

	/** The south. */
	SOUTH("SOUTH", "south"), //$NON-NLS-N$

	/** The east. */
	EAST("EAST", "east"), //$NON-NLS-N$

	/** The west. */
	WEST("WEST", "west"), //$NON-NLS-N$

	/** The none. */
	NONE("NONE", "none"), //$NON-NLS-N$

	/** The auto. */
	AUTO("AUTO", "AUTO"), //$NON-NLS-N$

	/** The left. */
	LEFT("LEFT", "left"), //$NON-NLS-N$

	/** The right. */
	RIGHT("RIGHT", "right"), //$NON-NLS-N$

	/** The center. */
	CENTER("CENTER", "center"); //$NON-NLS-N$

	/** The name. */
	private String name;

	/** The literal. */
	private String literal;

	/**
	 * Instantiates a new position enum.
	 *
	 * @param name
	 *            the name
	 * @param literal
	 *            the literal
	 */
	private PositionEnum(String name, String literal) {
		this.name = name;
		this.literal = literal;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
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
