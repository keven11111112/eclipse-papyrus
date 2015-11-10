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

import org.eclipse.papyrus.aof.core.IBinding;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.impl.BaseDelegate;
import org.eclipse.papyrus.aof.core.impl.BaseFactory;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class Bind<E> {

	private IBox<E> leftBox;

	private IBox<E> rightBox;

	private IBinding<E> binding;

	public Bind(IBox<E> leftBox, IBox<E> rightBox) {
		this.leftBox = leftBox;
		this.rightBox = rightBox;

		if (!leftBox.getConstraints().equals(rightBox)) {
			throw new IllegalArgumentException("Left box " + leftBox + " and right box " + rightBox + " must have the same type");
		}

		binding = new Binding();
		binding.enable();
	}


	public IBinding<E> getBinding() {
		return binding;
	}

	private class Binding implements IBinding<E> {
		private LeftRightObserver leftObserver;

		private LeftRightObserver rightObserver;

		private IOne<Boolean> enabled;

		private boolean autoDisable;

		@Override
		public IBox<E> getLeft() {
			return leftBox;
		}

		@Override
		public IBox<E> getRight() {
			return rightBox;
		}

		@Override
		public void enable() {
			// Ignore redundant enablement, otherwise we will lose track of previous
			// observers and effectively be stuck forever in the enabled state
			if (!basicIsEnabled()) {
				if (enabled != null) {
					// Ensure notification on the box
					isEnabled().set(true);
				} else {
					// Nobody's listening
					doEnable();
				}
			}
		}

		private void doEnable() {
			if (!leftBox.sameAs(rightBox)) {
				// init required so that the left box be updated since changes may have occurred while disabled
				leftBox.assign(rightBox);
			}

			leftObserver = new LeftRightObserver();
			rightObserver = new LeftRightObserver();

			// Only add the observers after the initial synchronization
			leftBox.addObserver(leftObserver);
			rightBox.addObserver(rightObserver);
		}

		@Override
		public void disable() {
			if (basicIsEnabled()) {
				if (enabled != null) {
					// Ensure notification on the box
					isEnabled().set(false);
				} else {
					// Nobody's listening
					doDisable();
				}
			}
		}

		private void doDisable() {
			leftObserver.setDisabled(true);
			rightObserver.setDisabled(true);

			leftBox.removeObserver(leftObserver);
			rightBox.removeObserver(rightObserver);

			leftObserver = null;
			rightObserver = null;
		}

		@Override
		public IOne<Boolean> isEnabled() {
			// Don't need or want more than one of these boxes
			if (enabled == null) {
				enabled = (IOne<Boolean>) ((BaseFactory) leftBox.getFactory()).createBox(IConstraints.ONE, new BaseDelegate.OneDelegate<Boolean>() {

					@Override
					protected Boolean read() {
						return basicIsEnabled();
					}

					@Override
					protected void write(Boolean element) {
						if (element) {
							doEnable();
						} else {
							doDisable();
						}
					}

				});
			}

			return enabled;
		}

		protected boolean basicIsEnabled() {
			return (leftObserver != null) && !leftObserver.isDisabled();
		}

		@Override
		public boolean isAutoDisable() {
			return autoDisable;
		}

		@Override
		public void setAutoDisable(boolean autoDisable) {
			this.autoDisable = autoDisable;
		}

		private class LeftRightObserver extends DefaultObserver<E> {

			IObserver<E> getOtherObserver() {
				return (this == leftObserver) ? rightObserver : leftObserver;
			}

			IBox<E> getOtherBox() {
				return (this == leftObserver) ? rightBox : leftBox;
			}

			private boolean autoDisableCheck() {
				boolean result = true;

				if (isAutoDisable() && (this == leftObserver)) {
					// The left-hand side changed. Disable
					result = false;
					disable();
				}

				return result;
			}

			@Override
			public void added(int index, E element) {
				if (autoDisableCheck()) {
					getOtherObserver().setDisabled(true);
					try {
						getOtherBox().add(index, element);
					} finally {
						getOtherObserver().setDisabled(false);
					}
				}
			}

			@Override
			public void removed(int index, E element) {
				if (autoDisableCheck()) {
					getOtherObserver().setDisabled(true);
					try {
						getOtherBox().removeAt(index);
					} finally {
						getOtherObserver().setDisabled(false);
					}
				}
			}

			@Override
			public void replaced(int index, E newElement, E oldElement) {
				if (autoDisableCheck()) {
					getOtherObserver().setDisabled(true);
					try {
						getOtherBox().set(index, newElement);
					} finally {
						getOtherObserver().setDisabled(false);
					}
				}
			}

			@Override
			public void moved(int newIndex, int oldIndex, E element) {
				if (autoDisableCheck()) {
					getOtherObserver().setDisabled(true);
					try {
						getOtherBox().move(newIndex, oldIndex);
					} finally {
						getOtherObserver().setDisabled(false);
					}
				}
			}

		}
	}

}
