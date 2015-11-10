/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Frederic Jouault - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/

package org.eclipse.papyrus.aof.core;

/**
 * <p>
 * Represents bidirectional bindings between boxes.
 * </p><p>
 * The binding is a pair containing the two boxes, as the following code illustrates:
 * </p>
 * <pre>
 * IBox<E> leftBox = ...
 * IBox<E> rightBox = ...
 * IBinding<E> binding = leftBox.bind(rightBox);
 * assert(binding.getLeft() == leftBox);
 * assert(binding.getRight() == rightBox);
 * </pre>
 * <p>
 * The binding is established by invoking {@link org.eclipse.papyrus.aof.core.IBox#bind(IBox)} on the left box.
 * </p><p>
 * It can be then {@linkplain #disable() disabled} and {@linkplain #enable() enabled}
 * at any time to pause and resume the bonding.
 * </p><p>
 * Also, a binding can be set to {@linkplain #setAutoDisable(boolean) auto-disable}.
 * This effectively provides for uni-directional bindings, which will
 * propagate changes from the right to the left, but if the left is changed, not only
 * will not propagate that change back to the right, but will {@linkplain #disable() disable}
 * the binding to prevent subsequent overwrites of the left-hand side when the right is
 * changed.  The binding may, of course, be re-enabled at any time (but would then still
 * auto-disable as appropriate).
 * </p>
 * 
 * @param <E>
 *            type of the elements of the two bound boxes
 */
public interface IBinding<E> extends IPair<IBox<E>, IBox<E>> {

	/**
	 * Enables the binding, which consists of assigning the right box contents to the left box, then of
	 * resuming the synchronization between the two boxes.
	 */
	void enable();

	/**
	 * Disables the binding, which consists of pausing the synchronization between the two boxes.
	 */
	void disable();

	/**
	 * Queries whether I am enabled, as an observable box that can be operated on in the
	 * usual AOF way.  The resulting box is mutable: updating it changes my enablement state
	 * as via {@link #enable()} or {@linkplain #disable()} methods.
	 * 
	 * @return whether I am synchronizing changes between my left and right boxes
	 * 
	 * @see #enable()
	 * @see #disable()
	 */
	IOne<Boolean> isEnabled();
	
	/**
	 * Queries whether I automatically disable myself on detection of a change to my
	 * left-hand side.
	 * 
	 * @return whether I am set to auto-disable
	 * 
	 * @see {@link #setAutoDisable(boolean)}
	 */
	boolean isAutoDisable();
	
	/**
	 * Sets whether to auto-disable myself on detection of a change to my left-hand side.
	 * 
	 * @param autoDisable whether to auto-disable
	 * 
	 * @see #isAutoDisable()
	 */
	void setAutoDisable(boolean autoDisable);
}
