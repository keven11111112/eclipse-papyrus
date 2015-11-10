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

import static org.eclipse.papyrus.aof.core.impl.utils.Equality.optionalEquals;

import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.ISingleton;

public abstract class Singleton<E> extends Box<E>implements ISingleton<E> {

	public Singleton(IFactory factory) {
		super(factory);
	}
	
	// IWritable

	@Override
	public void add(int index, E element) {
		if (index != 0) {
			throw new IndexOutOfBoundsException("Index " + index + " should be 0 for a singleton");
		}
		add(element);
	}

	@Override
	public void add(E element) {
		// Testing the size of the delegate for the case of an empty option
		if (length() == 0) {
			getDelegate().add(0, element);
		} else if (!optionalEquals(get(0), element)) {
			getDelegate().set(0, element);
		}
	}

	@Override
	public void set(int index, E element) {
		if (index != 0) {
			throw new IndexOutOfBoundsException("Index " + index + " should be 0 for a singleton");
		}
		if (length() == 0) {
			getDelegate().add(element);
		} else {
			super.set(index, element);
		}
	}

	@Override
	public void move(int newIndex, int oldIndex) {
		if (newIndex != 0) {
			throw new IndexOutOfBoundsException("Index " + newIndex + " should be 0 for a singleton");
		} else if (oldIndex != 0) {
			throw new IndexOutOfBoundsException("Index " + oldIndex + " should be 0 for a singleton");
		} else {
			getDelegate().move(newIndex, oldIndex);
		}
		// nothing to do: moving an element from index 0 to 0 is useless
	}

	// ISingleton

	@Override
	public E get() {
		return get(0);
	}

	@Override
	public void set(E element) {
		set(0, element);
	}

}
