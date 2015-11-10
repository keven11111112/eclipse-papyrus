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
package org.eclipse.papyrus.aof.core.impl;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;

public class One<E> extends Singleton<E>implements IOne<E> {

	public One(IFactory factory) {
		super(factory);
	}
	
	private E defaultElement;
	private boolean isDefault = true;

	@Override
	public E getDefaultElement() {
		return defaultElement;
	}

	@Override
	public void clear(E newDefaultElement) {
		defaultElement = newDefaultElement;
		clear();
	}

	@Override
	public void clear() {
		add(defaultElement);
		isDefault = true;
	}
	
	@Override
	public void assign(Iterable<? extends E> iterable) {
		super.assign(iterable);
		unsetDefault();
	}

	@Override
	public boolean isDefault() {
		return isDefault;
	}

	void unsetDefault() {
		isDefault = false;
	}

	// IConstrained

	@Override
	public IConstraints getConstraints() {
		return IConstraints.ONE;
	}

	// IWritable

	@Override
	public void remove(E element) {
		removeAt(0);
	}

	@Override
	public void removeAt(int index) {
		if (index != 0) {
			throw new IndexOutOfBoundsException("Index " + index + " should be 0");
		}
		getDelegate().set(0, getDefaultElement());
		unsetDefault();
	}

	@Override
	public void add(E element) {
		unsetDefault();
		super.add(element);
	}

	@Override
	public void set(int index, E element) {
		unsetDefault();
		super.set(index, element);
	}

	@Override
	public void move(int newIndex, int oldIndex) {
		unsetDefault();
		super.move(newIndex, oldIndex);
	}

	// IBox

	@Override
	public IBox<E> snapshot() {
		IBox<E> box = getFactory().createOne(getDefaultElement());
		box.assign(this);
		return box;
	}

	//
	// Nested types
	//

	/**
	 * A specific {@link IOne one} implementation for the delegation use case.
	 */
	public static class Delegator<E> extends One<E> {
		private BaseDelegate.IOneDelegate<E> delegate;

		public Delegator(IFactory factory) {
			super(factory);
		}

		/**
		 * Sets the delegate, which must be specifically a
		 * {@link BaseDelegate.IOneDelegate}.
		 *
		 * @param delegate
		 *            the delegate
		 * 
		 * @throws IllegalArgumentException
		 *             if the {@code delegate} is {@code null} or something that
		 *             is not a {@link BaseDelegate.IOneDelegate}
		 */
		@SuppressWarnings("unchecked")
		@Override
		protected void setDelegate(BaseDelegate<E> delegate) {
			if (!(delegate instanceof BaseDelegate.IOneDelegate<?>)) {
				throw new IllegalArgumentException("delegate is not a BaseDelegate.IOneDelegate");
			}

			this.delegate = (BaseDelegate.IOneDelegate<E>) delegate;
			super.setDelegate(delegate);
		}

		protected BaseDelegate.IOneDelegate<E> getOneDelegate() {
			return delegate;
		}

		@Override
		public E getDefaultElement() {
			return getOneDelegate().getDefaultElement();
		}

		@Override
		public void clear() {
			getDelegate().clear();
		}

		@Override
		public void clear(E newDefaultElement) {
			getOneDelegate().clear(newDefaultElement);
		}

		@Override
		public boolean isDefault() {
			return getOneDelegate().isDefault();
		}
	}
}
