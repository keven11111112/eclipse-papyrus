/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.core;

/**
 * Represents singleton boxes containing exactly one element.
 * <p>
 * It defines a default element that is used when clearing the box .
 */
public interface IOne<E> extends ISingleton<E> {

	/**
	 * Returns the default element of this one box.
	 * <p>
	 * For consistency reasons, the default element can only be changed when clearing the box (@see #clear(Object))
	 *
	 * @return the default element of this one box
	 * 
	 * @see #isDefault()
	 */
	E getDefaultElement();

	/**
	 * Clear this one box and redefines its new default element.
	 *
	 * @param newDefaultElement
	 *            the new default element of this one box
	 *            
	 * @see #clear()
	 * @see #isDefault()
	 */
	void clear(E newDefaultElement);
	
	/**
	 * Queries whether my value is what it is because I am defaulted.
	 * 
	 * @return whether I am in the default (unset) state
	 * 
	 * @see #clear()
	 */
	boolean isDefault();

	/**
	 * {@inheritDoc}
	 * 
	 * Clearing an {@code IOne} returns it to the {@link #isDefault() default} state.
	 *
	 * @see #isDefault()
	 * @see #getDefaultElement()
	 */
	@Override
	void clear();
}
