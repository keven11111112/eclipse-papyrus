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

package org.eclipse.papyrus.aof.core.utils;

import org.eclipse.papyrus.aof.core.ConstraintsKind;
import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.ICollection;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.ISingleton;

/**
 * An EMF-like switch mechanism for boxes. Override the appropriate case
 * operation to handle the specific kind of box. All of the base implementations
 * of the case variant accepting a specific box interface delegate to the
 * variant for the generic box interface. So, to handle, for example, a sequence
 * whether it implements the {@link ISequence} interface or not, simply override
 * the {@link #caseSequence(IBox)} method.
 */
public class BoxSwitch<E, T> {

	public BoxSwitch() {
		super();
	}

	/**
	 * Switch on the specific constraint-type of a {@code box}.
	 * 
	 * @param box
	 *            the box to switch on
	 * 
	 * @return the switch result, or {@code null} if no case (including the
	 *         {@linkplain #defaultCase(IBox) default case}) matches
	 */
	public T doSwitch(IBox<E> box) {
		T result = null;

		switch (ConstraintsKind.forConstraints(box)) {
		case OPTION:
			if (box instanceof IOption<?>) {
				result = caseOption((IOption<E>) box);
			} else {
				result = caseOption(box);
			}
			break;
		case ONE:
			if (box instanceof IOne<?>) {
				result = caseOne((IOne<E>) box);
			} else {
				result = caseOne(box);
			}
			break;
		case SET:
			if (box instanceof ISet<?>) {
				result = caseSet((ISet<E>) box);
			} else {
				result = caseSet(box);
			}
			break;
		case ORDERED_SET:
			if (box instanceof IOrderedSet<?>) {
				result = caseOrderedSet((IOrderedSet<E>) box);
			} else {
				result = caseOrderedSet(box);
			}
			break;
		case SEQUENCE:
			if (box instanceof ISequence<?>) {
				result = caseSequence((ISequence<E>) box);
			} else {
				result = caseSequence(box);
			}
			break;
		case BAG:
			if (box instanceof IBag<?>) {
				result = caseBag((IBag<E>) box);
			} else {
				result = caseBag(box);
			}
			break;
		}

		if (result == null) {
			if (box.isSingleton()) {
				if (box instanceof ISingleton<?>) {
					result = caseSingleton((ISingleton<E>) box);
				} else {
					result = caseSingleton(box);
				}
			} else {
				if (box instanceof ICollection<?>) {
					result = caseCollection((ICollection<E>) box);
				} else {
					result = caseCollection(box);
				}
			}
		}

		if (result == null) {
			result = defaultCase(box);
		}

		return result;
	}

	public T caseOne(IBox<E> box) {
		return null;
	}

	public T caseOne(IOne<E> one) {
		return caseOne((IBox<E>) one);
	}

	public T caseOption(IBox<E> box) {
		return null;
	}

	public T caseOption(IOption<E> option) {
		return caseOption((IBox<E>) option);
	}

	public T caseSingleton(IBox<E> box) {
		return null;
	}

	public T caseSingleton(ISingleton<E> singleton) {
		return caseSingleton((IBox<E>) singleton);
	}

	public T caseOrderedSet(IBox<E> box) {
		return null;
	}

	public T caseOrderedSet(IOrderedSet<E> orderedSet) {
		return caseOrderedSet((IBox<E>) orderedSet);
	}

	public T caseSet(IBox<E> box) {
		return null;
	}

	public T caseSet(ISet<E> set) {
		return caseSet((IBox<E>) set);
	}

	public T caseSequence(IBox<E> box) {
		return null;
	}

	public T caseSequence(ISequence<E> sequence) {
		return caseSequence((IBox<E>) sequence);
	}

	public T caseBag(IBox<E> box) {
		return null;
	}

	public T caseBag(IBag<E> bag) {
		return caseBag((IBox<E>) bag);
	}

	public T caseCollection(IBox<E> box) {
		return null;
	}

	public T caseCollection(ICollection<E> collection) {
		return caseCollection((IBox<E>) collection);
	}

	public T defaultCase(IBox<E> box) {
		return null;
	}
}
