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
 *     
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.impl.ListDelegate;

public class ListFeatureDelegate<E> extends FeatureDelegate<E> {

	EList<E> list;

	// Delegate to a list that is used as a redundant backing store because
	// the IObserver API cannot handle the bulk add and delete notifications
	// that EMF lists support. For example, clearing a list removes all values
	// and sends a single notification: this can only be translated to a
	// sequence of multiple removed(...) calls on IObservers, but all but one
	// of these calls refers to indices that are no longer valid
	final ListDelegate<E> delegate;

	private final Adapter adapter;
	boolean silentForward;
	boolean silentReverse;

	@SuppressWarnings("unchecked")
	public ListFeatureDelegate(EObject object, EStructuralFeature feature) {
		super(object, feature);

		list = (EList<E>) object.eGet(feature);
		delegate = new ListDelegate();

		// Must always be listening to the EMF list to maintain integrity
		// of our redundant backing store 'proxyBox'
		adapter = new ListForwardNotificationAdapter<E>(this);
		object.eAdapters().add(adapter);
	}

	@Override
	public void setDelegator(IBox<E> delegator) {
		if (getDelegator() != null) {
			throw new IllegalStateException("delegator already set"); //$NON-NLS-1$
		}

		// Now, we can initialize the backing store from the list
		delegate.setDelegator(delegator);
		delegate.assign(list);
		delegate.addObserver(new ListReverseNotificationAdapter<E>(this));

		super.setDelegator(delegator);
	}

	// Iterable

	@Override
	public Iterator<E> iterator() {
		return delegate.iterator();
	}

	// IReadable

	@Override
	public E get(int index) {
		return delegate.get(index);
	}

	@Override
	public int length() {
		return delegate.length();
	}

	@Override
	public int indexOf(E element) {
		return delegate.indexOf(element);
	}

	@Override
	public boolean contains(E element) {
		return delegate.contains(element);
	}

	// IWritable

	@Override
	public void add(E element) {
		delegate.add(element);
	}

	@Override
	public void add(int index, E element) {
		delegate.add(index, element);
	}

	@Override
	public void remove(E element) {
		delegate.remove(element);
	}

	@Override
	public void removeAt(int index) {
		delegate.removeAt(index);
	}

	@Override
	public void clear() {
		delegate.clear();
	}

	@Override
	public void set(int index, E element) {
		delegate.set(index, element);
	}

	@Override
	public void move(int newIndex, int oldIndex) {
		delegate.move(newIndex, oldIndex);
	}

	// IObservable

	@Override
	public void addObserver(IObserver<? super E> observer) {
		delegate.addObserver(observer);
	}

	@Override
	public void removeObserver(IObserver<?> observer) {
		delegate.removeObserver(observer);
	}

	@Override
	public Iterable<IObserver<? super E>> getObservers() {
		return delegate.getObservers();
	}

	@Override
	public boolean isObserved() {
		return delegate.isObserved();
	}
}
