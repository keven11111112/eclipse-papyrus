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
package org.eclipse.papyrus.aof.emf.impl.delegate;

import java.util.Iterator;

import org.eclipse.emf.common.notify.NotifyingList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ListFeatureDelegate<A> extends FeatureDelegate<A> {

	private NotifyingList<A> list;

	public ListFeatureDelegate(EObject object, EStructuralFeature feature) {
		super(object, feature);
		this.list = (NotifyingList<A>) object.eGet(feature);
	}

	// Iterable

	public Iterator<A> iterator() {
		return list.iterator();
	}

	// Readable

	public A get(int index) {
		return (A) list.get(index);
	}

	public int size() {
		return list.size();
	}

	public int indexOf(A element) {
		return list.indexOf(element);
	}

	// Writable

	public void add(int index, A element) {
		list.add(index, element);
	}

	public void removeAt(int index) {
		list.remove(index);
	}

	public void remove(A element) {
		list.remove(element);
	}

	public void replace(int index, A element) {
		list.move(index, element);
	}

}
