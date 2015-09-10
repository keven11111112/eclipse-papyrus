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

import static org.eclipse.papyrus.adltool.Activator.log;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This class provides the skeletal implementation of the {@link Reversible}
 * interface.<br />
 * The programmer should extend this class in order to create a new reversible
 * adapter.
 *
 * @param <T> The type of the reversible's representation.
 */
public abstract class AbstractReversible<T extends NamedElement> implements Reversible<T> {

	/**
	 * The element that represents the reversed project.
	 */
	protected T representation;

	/**
	 * The stereotype holding the project information.
	 */
	protected Stereotype stereotype;

	/**
	 * Returns an instance of this reversible's representation.
	 *
	 * <p>
	 * <b>Note</b>: This method needs to be implemented by any reversible that
	 * extends the {@link AbstractReversible} class.
	 * </p>
	 *
	 * @return the instance of the representation
	 */
	protected abstract T createRepresentation();

	@Override
	public T getRepresentation() {
		if (representation == null) {
			representation = createRepresentation();
			representation.setName(getId());
		}

		return representation;
	}

	@Override
	public void setRepresentation(T representation) {
		this.representation = representation;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getId() == null ? 0 : getId().hashCode();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Reversible)) {
			return false;
		}

		Reversible<?> other = (Reversible<?>) obj;

		if (getType() != other.getType()) {
			return false;
		}

		if (getId().equals(other.getId())) {
			return true;
		}

		return false;
	}

	@Override
	public boolean applyStereotype() {
		// The getRepresentation() method instantiates the field and avoids null pointer
		stereotype = getRepresentation().getAppliedStereotype(getStereotypeName());

		if (stereotype != null) {
			return true;
		}

		stereotype = getRepresentation().getApplicableStereotype(getStereotypeName());

		if (stereotype != null) {
			getRepresentation().applyStereotype(stereotype);

			return true;
		}

		log.warn("(" + getType() + ") " + getId() + ": stereotype is null");

		return false;
	}

	@Override
	public Class<? extends NamedElement> getRepresentationClass() {
		return getRepresentation().getClass();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends NamedElement> S getElement(Reversible<S> reversible) {
		// The representation is an instance of NamedElement, it should be safe to make the cast
		return (S) getElement(reversible.getId(), reversible.getRepresentationClass());
	}

	@Override
	public <S extends NamedElement> S getElement(String name, Class<S> clazz) {
		for (Element ownedElement : representation.getOwnedElements()) {
			if (clazz.isInstance(ownedElement)) {
				// The warning is checked with the above condition
				@SuppressWarnings("unchecked")
				S element = (S) ownedElement;

				if (name.equals(element.getName())) {
					return element;
				}
			}
		}

		return null;
	}
}
