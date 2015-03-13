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

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.ISingleton;
import org.eclipse.papyrus.aof.core.impl.operation.Times;

public abstract class Singleton<A> extends Box<A> implements ISingleton<A> {

	public IBox<A> times(IOne<Integer> n) {
		return new Times<A>(this, n).getResult();
	}
	
	public void add(int index, A element) {
		if (index != 0) {
			throw new IndexOutOfBoundsException("Index " + index + " should be in interval [0, " + size() + "[");
		}
		if (indexOf(element) == -1) {
			// Testing size to avoid exception when creating a new singleton (initial size is 0)
			// Best solution so far
			if(getDelegate().size()>0){
				getDelegate().replace(0,element);
			} else {
				getDelegate().add(0, element);
			}
		}
	}
	
	public void append(A element) {
		if (indexOf(element) == -1) {
			// Testing the size of the delegate for the case of an empty option
			if(getDelegate().size()==0){
				getDelegate().add(0,element);
			} else {
				getDelegate().replace(0,element);
			}
		}
	}
	
	//FIXME does not work for empty option assignment nor assign null
	public void assign(Iterable<A> iterable) {
		if(iterable == null){
			throw new NullPointerException("Collection of elements is null");
		} else {
			for(A iter : iterable){
				add(0,iter);
			}
		}
	}
}
