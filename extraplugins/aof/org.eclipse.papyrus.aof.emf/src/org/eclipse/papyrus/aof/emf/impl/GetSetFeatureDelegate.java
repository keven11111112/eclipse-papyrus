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
package org.eclipse.papyrus.aof.emf.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.impl.BaseDelegate;
import org.eclipse.papyrus.aof.core.impl.utils.Equality;

public class GetSetFeatureDelegate<E> extends FeatureDelegate<E>implements BaseDelegate.IOneDelegate<E> {

	public GetSetFeatureDelegate(EObject object, EStructuralFeature feature) {
		super(object, feature);
	}

	// Iterable

	@Override
	public Iterator<E> iterator() {
		List<E> singleton = new ArrayList<E>();
		if (length() == 1) {
			singleton.add((E) getObject().eGet(getFeature()));
		}
		return singleton.iterator();
	}

	// IReadable

	@Override
	public E get(int index) {
		return (E) getObject().eGet(getFeature());
	}

	// All EMF singleton features behave as Ones with possible null value
	// @see FeatureDelagate.isOptional
	@Override
	public int length() {
		return 1; // (object.eIsSet(feature) || feature.isRequired()) ? 1 : 0;
	}

	@Override
	public int indexOf(E element) {
		Object v = getObject().eGet(getFeature());
		if (v == null) {
			return element == null ? 0 : -1;
		} else {
			return v.equals(element) ? 0 : -1;
		}
	}

	// IWritable

	@Override
	public void add(int index, E element) {
		getObject().eSet(getFeature(), element);
	}

	@Override
	public void removeAt(int index) {
		getObject().eUnset(getFeature());
	}

	@Override
	public void remove(E element) {
		// Don't remove an element that isn't in this box!
		if (Equality.optionalEquals(getObject().eGet(getFeature()), element)) {
			getObject().eUnset(getFeature());
		}
	}

	@Override
	public void set(int index, E element) {
		add(index, element);
	}

	@Override
	public void move(int newIndex, int oldIndex) {
		// do nothing since moving inside a singleton is a nonsense
	}

	@Override
	public void clear() {
		getObject().eUnset(getFeature());
	}

	// IOneDelegate

	@Override
	public E getDefaultElement() {
		return (E) getFeature().getDefaultValue();
	}

	@Override
	public void clear(E newDefaultElement) {
		if (((EClassImpl) getFeature().getEContainingClass()).isFrozen()) {
			throw new UnsupportedOperationException("clear(E)");
		}
		getFeature().setDefaultValue(newDefaultElement);
	}

	// IObservable

	private Adapter adapter;

	@Override
	public void addObserver(IObserver<? super E> observer) {
		super.addObserver(observer);
		if (adapter == null) {
			adapter = new GetSetFeatureNotificationAdapter<E>(this);
			getObject().eAdapters().add(adapter);
		}
	}

	@Override
	public void removeObserver(IObserver<?> observer) {
		super.removeObserver(observer);
		if (!isObserved()) {
			getObject().eAdapters().remove(adapter);
			adapter = null;
		}
	}

}
