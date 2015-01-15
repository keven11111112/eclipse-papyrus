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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class GetSetFeatureDelegate<A> extends FeatureDelegate<A> {

	public GetSetFeatureDelegate(EObject object, EStructuralFeature feature) {
		super(object, feature);
	}

	// Iterable

	public Iterator<A> iterator() {
		List<A> singleton = new ArrayList<A>();
		if (object.eIsSet(feature)) {
			singleton.add((A) object.eGet(feature));
		}
		return singleton.iterator();
	}

	// Readable

	public A get(int index) {
		return (A) object.eGet(feature);
	}

	public int size() {
		return object.eIsSet(feature) ? 1 : 0;
	}

	public int indexOf(A element) {
		return object.eGet(feature).equals(element) ? 0 : -1;
	}

	// Writable

	public void add(int index, A element) {
		object.eSet(feature, element);
	}

	public void removeAt(int index) {
		object.eUnset(feature);
	}

	public void remove(A element) {
		object.eUnset(feature);
	}

	public void replace(int index, A element) {
		add(index, element);
	}

}
