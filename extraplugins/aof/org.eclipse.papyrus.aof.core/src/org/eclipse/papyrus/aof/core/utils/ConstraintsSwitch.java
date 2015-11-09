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
import org.eclipse.papyrus.aof.core.IConstraints;

/**
 * An EMF-like switch mechanism for constraints. Override the appropriate case
 * operation to handle the specific kind of constraints.
 */
public class ConstraintsSwitch<T> {

	public ConstraintsSwitch() {
		super();
	}

	/**
	 * Switch on the specific type of {@code constraints}.
	 * 
	 * @param constraints
	 *            the constraints to switch on
	 * 
	 * @return the switch result, or {@code null} if no case (including the
	 *         {@linkplain #defaultCase(IConstraints) default case}) matches
	 */
	public T doSwitch(IConstraints constraints) {
		T result = null;

		switch (ConstraintsKind.forConstraints(constraints)) {
		case OPTION:
			result = caseOption(constraints);
			break;
		case ONE:
			result = caseOne(constraints);
			break;
		case SET:
			result = caseSet(constraints);
			break;
		case ORDERED_SET:
			result = caseOrderedSet(constraints);
			break;
		case SEQUENCE:
			result = caseSequence(constraints);
			break;
		case BAG:
			result = caseBag(constraints);
			break;
		}

		if (result == null) {
			if (constraints.isSingleton()) {
				result = caseSingleton(constraints);
			} else {
				result = caseCollection(constraints);
			}
		}

		if (result == null) {
			result = defaultCase(constraints);
		}

		return result;
	}

	public T caseOne(IConstraints one) {
		return null;
	}

	public T caseOption(IConstraints option) {
		return null;
	}

	public T caseSingleton(IConstraints singleton) {
		return null;
	}

	public T caseOrderedSet(IConstraints orderedSet) {
		return null;
	}

	public T caseSet(IConstraints set) {
		return null;
	}

	public T caseSequence(IConstraints sequence) {
		return null;
	}

	public T caseBag(IConstraints bag) {
		return null;
	}

	public T caseCollection(IConstraints collection) {
		return null;
	}

	public T defaultCase(IConstraints constraints) {
		return null;
	}
}
