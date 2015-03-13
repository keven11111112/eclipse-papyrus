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
import org.eclipse.papyrus.aof.core.IOne;

public class One<A> extends Singleton<A> implements IOne<A> {
	
	private A defaultElement;

	public A getDefaultElement() {
		return defaultElement;
	}

	public void setDefaultElement(A defaultValue) {
		this.defaultElement = defaultValue;
	}
	
	public void remove(A element) {
		if (indexOf(element) != -1) {
			getDelegate().replace(0,defaultElement);
		}
	}
	
	public void removeAt(int index) {
		if ((index < 0) || (index >= size())) {
			throw new IndexOutOfBoundsException("Index " + index + " should be in interval [0, " + size() + "[");
		}
		getDelegate().replace(0,defaultElement);
	}

	public IBoxType getType() {
		return IBoxType.ONE;
	}

}
