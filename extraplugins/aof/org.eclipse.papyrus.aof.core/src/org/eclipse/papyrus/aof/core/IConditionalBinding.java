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

package org.eclipse.papyrus.aof.core;

/**
 * <p>
 * A conditional one-way binding between boxes.
 * </p>
 * <p>
 * The binding is a pair containing the two boxes, in which the
 * {@link IPair#getRight() right} box is conditionally bound to the
 * {@link IPair#getLeft() left} box.
 * </p>
 * <p>
 * The conditional binding is established by invoking
 * {@link org.eclipse.papyrus.aof.core.IBox#bindConditionally(IBox, IUnaryFunction)}
 * on the {@link IPair#getLeft() left} box.
 * </p>
 * <p>
 * It can then be {@linkplain #setOverrideDisabled(boolean) overridden} to
 * forcibly disable it. Forcing enablement is not possible: the binding is only
 * ever enabled if the {@linkplain #getCondition() condition} holds and it is
 * not overridden.
 * </p>
 * 
 * @param <E>
 *            type of the elements of the bound (target or "to") box
 * @param <F>
 *            type of the elements of the binding (source or "from") box
 */
public interface IConditionalBinding<E, F extends E> extends IPair<IBox<E>, IBox<F>> {
	/**
	 * Sets whether to override the enablement condition to forcibly disable the
	 * binding until the override is lifted (if ever).
	 * 
	 * @param disable
	 *            whether to force the binding to be disabled
	 */
	void setOverrideDisabled(boolean disable);

	/**
	 * Sets whether the enablement condition is overridden to forcibly disable
	 * the binding.
	 * 
	 * return whether the binding is forcibly disabled
	 */
	boolean isOverrideDisabled();

	/**
	 * Obtains the enablement condition of the binding. The binding can fire
	 * only when this condition holds for the bound box.
	 * 
	 * @return the enablement condition
	 */
	IUnaryFunction<? super IBox<? extends E>, Boolean> getCondition();
}
