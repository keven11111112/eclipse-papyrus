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
package org.eclipse.papyrus.aof.core.impl.utils;

import org.eclipse.papyrus.aof.core.IObserver;

public abstract class DefaultObserver<A> implements IObserver<A> {

	public void created(Iterable<A> elements) {
		int i = 0;
		for (A e : elements) {
			added(i, e);
			i++;
		}
	}

	public void added(int index, A element) {
		replaced(index, element, element);
	}

	public void removed(int index, A element) {
	}

	public void replaced(int index, A previousElement, A newElement) {
		removed(index, previousElement);
		added(index, newElement);
	}

}
