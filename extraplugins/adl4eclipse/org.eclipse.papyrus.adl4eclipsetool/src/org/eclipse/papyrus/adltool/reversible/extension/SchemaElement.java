/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adltool.reversible.extension;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a schema element defined by an extension point.
 */
public class SchemaElement {

	private String name;
	private String type;
	private int minOccurs;
	private int maxOccurs;
	private List<SchemaAttribute> attributes;

	public SchemaElement(String name) {
		setName(name);

		attributes = new ArrayList<>();
	}

	/**
	 * Gets the element name.
	 *
	 * @return the name of the element.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the element name.
	 *
	 * @param name the name of the element.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds an attribute to this element.
	 *
	 * @param attribute
	 */
	public void addAttribute(SchemaAttribute attribute) {
		attributes.add(attribute);
	}

	/**
	 * Gets the list of attributes.
	 *
	 * @return
	 */
	public List<SchemaAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * Gets the element's type.
	 *
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the element's type.
	 *
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;

	}

	/**
	 * Gets the minimum occurrences parameter of the element.
	 *
	 * @return
	 */
	public int getMinOccurs() {
		return minOccurs;
	}

	/**
	 * Sets the minimum occurrences parameter of the element.
	 *
	 * @param minOccurs
	 */
	public void setMinOccurs(int minOccurs) {
		this.minOccurs = minOccurs;
	}

	/**
	 * Gets the maximum occurrences parameter of the element.
	 *
	 * @return
	 */
	public int getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * Sets the maximum occurrences parameter of the element.
	 *
	 * @param maxOccurs
	 */
	public void setMaxOccurs(int maxOccurs) {
		this.maxOccurs = maxOccurs;
	}

}
