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
package org.eclipse.papyrus.adltool.reversible;

import org.eclipse.uml2.uml.NamedElement;

/**
 * The root interface of a reversible adapter.<br />
 *
 * <p>
 * A reversible has:
 * <ul>
 * <li>an identifier that corresponds to the adapted class identifier,</li>
 * <li>a UML representation that should extend the
 * {@link org.eclipse.uml2.uml.NamedElement NamedElement} interface,
 * </li>
 * <li>a type,</li>
 * <li>a stereotype name that will be applied to its representation,</li>
 * <li>and a stereotype that will be applied to the dependency links to this
 * reversible.</li>
 * </ul>
 * </p>
 */
public interface Reversible<T extends NamedElement> {

	enum Type {
		BUNDLE, FEATURE, PLUGIN, EXTENSION_POINT, EXTENSION
	};

	/**
	 * Gets the identifier of the reversible.
	 *
	 * @return the identifier of the reversible
	 */
	String getId();

	/**
	 * Gets stereotype's qualified name that will be applied on the reversed
	 * component.
	 *
	 * @return the stereotype name
	 */
	String getStereotypeName();

	/**
	 * Gets the stereotype's qualified name that will be applied on the
	 * dependency link.
	 *
	 * @return the stereotype name
	 */
	String getDependencyStereotypeName();

	/**
	 * Gets the type of the reversible project.
	 *
	 * @return type of reversible
	 */
	Type getType();

	/**
	 * Gets the representation corresponding to the reversed project. If the
	 * representation is null, this method should instantiate it.
	 *
	 * @return the project's representation
	 */
	T getRepresentation();

	/**
	 * Sets the representation. Used in case the project has already been
	 * reversed and its representation needs to be updated from the one in the
	 * model.
	 *
	 * @param representation
	 */
	void setRepresentation(T representation);

	/**
	 * Applies the stereotype and fills its values.
	 */
	void fillStereotype();

	/**
	 * Returns the runtime class of this reversible's representation.
	 *
	 * @return
	 */
	Class<? extends NamedElement> getRepresentationClass();

	/**
	 * Gets an element of type "clazz" in this reversible's representation or
	 * null if it does not exist.
	 *
	 * @param name the name of the element
	 * @param clazz the type of the element to return
	 * @return the element or null if it does not exist
	 */
	<S extends NamedElement> S getElement(String name, Class<S> clazz);

	/**
	 * Gets a reversible representation in this reversible's representation or
	 * null if it does not exist.
	 *
	 * @param reversible the reversible to retrieve
	 * @return the reversible's representation to retrieve or null if it does
	 *         not exist
	 */
	<S extends NamedElement> S getElement(Reversible<S> reversible);

}
