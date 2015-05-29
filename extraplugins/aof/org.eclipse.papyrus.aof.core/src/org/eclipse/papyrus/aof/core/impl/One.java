/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IOne;

public class One<E> extends Singleton<E>implements IOne<E> {

	private E defaultElement;

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
	}

	// IConstrained

	@Override
	public IConstraints getConstraints() {
		return IConstraints.ONE;
	}

	// IWritable

	@Override
	public void remove(E element) {
		if (!contains(element)) {
			throw new IllegalStateException("Element " + element + " is not contained in " + this);
		} else {
			removeAt(0);
		}
	}

	@Override
	public void removeAt(int index) {
		if (index != 0) {
			throw new IndexOutOfBoundsException("Index " + index + " should be 0");
		}
		getDelegate().set(0, defaultElement);
	}

	// IBox

	@Override
	public IBox<E> snapshot() {
		IBox<E> box = AOFFactory.INSTANCE.createOne(defaultElement);
		box.assign(this);
		return box;
	}


}
