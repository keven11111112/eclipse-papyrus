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
package org.eclipse.papyrus.aof.core.impl.operation;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConditionalBinding;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class BindConditionally<E, F extends E> {

	private IBox<E> leftBox;

	private IBox<F> rightBox;

	private IUnaryFunction<? super IBox<? extends E>, Boolean> condition;

	private IConditionalBinding<E, F> binding;

	public BindConditionally(IBox<E> leftBox, IBox<F> rightBox,
			IUnaryFunction<? super IBox<? extends E>, Boolean> condition) {
		this.leftBox = leftBox;
		this.rightBox = rightBox;
		this.condition = condition;

		if (!leftBox.getConstraints().equals(rightBox)) {
			throw new IllegalArgumentException(
					"Left box " + leftBox + " and right box " + rightBox + " must have the same type");
		}

		binding = new ConditionalBinding();
		binding.setOverrideDisabled(false);
	}

	public IConditionalBinding<E, F> getBinding() {
		return binding;
	}

	private class ConditionalBinding implements IConditionalBinding<E, F> {
		private Observer observer;

		private boolean overrideDisable = true;

		@Override
		public IBox<E> getLeft() {
			return leftBox;
		}

		@Override
		public IBox<F> getRight() {
			return rightBox;
		}

		@Override
		public void setOverrideDisabled(boolean disable) {
			this.overrideDisable = disable;

			if (!disable) {
				if (condition.apply(leftBox) && !leftBox.sameAs(rightBox)) {
					leftBox.assign(rightBox);
				}

				observer = new Observer();
				rightBox.addObserver(observer);
			} else {
				observer.setDisabled(true);
				rightBox.removeObserver(observer);
				observer = null;
			}
		}

		@Override
		public boolean isOverrideDisabled() {
			return overrideDisable;
		}

		@Override
		public IUnaryFunction<? super IBox<? extends E>, Boolean> getCondition() {
			return condition;
		}

		//
		// Nested types
		//

		private class Observer extends DefaultObserver<F> {

			private boolean checkCondition() {
				return !isOverrideDisabled() && condition.apply(leftBox);
			}

			@Override
			public void added(int index, F element) {
				if (checkCondition()) {
					leftBox.add(index, element);
				}
			}

			@Override
			public void removed(int index, F element) {
				if (checkCondition()) {
					leftBox.removeAt(index);
				}
			}

			@Override
			public void replaced(int index, F newElement, F oldElement) {
				if (checkCondition()) {
					leftBox.set(index, newElement);
				}
			}

			@Override
			public void moved(int newIndex, int oldIndex, F element) {
				if (checkCondition()) {
					leftBox.move(newIndex, oldIndex);
				}
			}

		}
	}

}
