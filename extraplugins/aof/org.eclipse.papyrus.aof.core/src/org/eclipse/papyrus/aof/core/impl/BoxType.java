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

import org.eclipse.papyrus.aof.core.IBoxType;
import org.eclipse.papyrus.aof.core.IConstrained;

public class BoxType implements IBoxType {

	private boolean optional;
	private boolean singleton;
	private boolean ordered;
	private boolean unique;

	public BoxType(boolean optional, boolean singleton, boolean ordered, boolean unique) {
		this.optional = optional;
		this.singleton = singleton;
		this.ordered = ordered;
		this.unique = unique;
	}

	public boolean isOptional() {
		return optional;
	}

	public boolean isSingleton() {
		return singleton;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public boolean isUnique() {
		return unique;
	}

	public boolean satisfies(IConstrained constraints) {
		return isOptional() == constraints.isOptional() && isSingleton() == constraints.isSingleton()
				&& isOrdered() == constraints.isOrdered() && isUnique() == constraints.isUnique();
	}

	public String toString() {
		if (this == OPTION) {
			return "opt";
		}
		else if (this == ONE) {
			return "one";
		}
		else if (this == SET) {
			return "set";
		}
		else if (this == ORDERED_SET) {
			return "oset";
		}
		else if (this == SEQUENCE) {
			return "seq";
		}
		else /* if (this == BAG) */{
			return "bag";
		}
	}

}
