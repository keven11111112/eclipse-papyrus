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

import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.delegate.BaseDelegate;
import org.eclipse.papyrus.aof.core.impl.operation.Apply;
import org.eclipse.papyrus.aof.core.impl.operation.BinaryZip;
import org.eclipse.papyrus.aof.core.impl.operation.Bind;
import org.eclipse.papyrus.aof.core.impl.operation.Inspect;
import org.eclipse.papyrus.aof.core.impl.operation.Map;
import org.eclipse.papyrus.aof.core.impl.operation.Path;
import org.eclipse.papyrus.aof.core.impl.operation.Select;

public abstract class Box<A> implements IBox<A> {

	private BaseDelegate<A> delegate;

	public BaseDelegate<A> getDelegate() {
		return delegate;
	}
	protected void setDelegate(BaseDelegate<A> delegate) {
		this.delegate = delegate;
	}

	// Constrained

	public boolean isOptional() {
		return getType().isOptional();
	}

	public boolean isSingleton() {
		return getType().isSingleton();
	}

	public boolean isOrdered() {
		return getType().isOrdered();
	}

	public boolean isUnique() {
		return getType().isUnique();
	}

	// Iterable

	public Iterator<A> iterator() {
		return delegate.iterator();
	}

	// Readable

	public A get(int index) {
		if ((index < 0) || (index >= size())) {
			throw new IndexOutOfBoundsException("Index " + index + " should be in interval [0, " + size() + "[");
		}
		return delegate.get(index);
	}

	public int size() {
		return delegate.size();
	}

	public int indexOf(A element) {
		return delegate.indexOf(element);
	}

	// Writable

	public void add(int index, A element) {
		if ((index < 0) || (index > size())) {
			throw new IndexOutOfBoundsException("Index " + index + " should be in interval [0, " + size() + "]");
		}
		if (!isUnique() || (indexOf(element) == -1)) {
			delegate.add(index, element);
		}
	}

	public void append(A element) {
		if (!isUnique() || (indexOf(element) == -1)) {
			delegate.append(element);
		}
	}

	public void removeAt(int index) {
		if ((index < 0) || (index >= size())) {
			throw new IndexOutOfBoundsException("Index " + index + " should be in interval [0, " + size() + "[");
		}
		delegate.removeAt(index);
	}

	public void remove(A element) {
		if (indexOf(element) != -1) {
			delegate.remove(element);
		}
	}

	public void replace(int index, A element) {
		if ((index < 0) || (index >= size())) {
			throw new IndexOutOfBoundsException("Index " + index + " should be in interval [0, " + size() + "[");
		}
		if (!isUnique() || (indexOf(element) == -1)) {
			delegate.replace(index, element);
		}
	}

	public void clear() {
		delegate.clear();
	}

	public void assign(Iterable<A> iterable) {
		delegate.assign(iterable);
	}

	// Observable

	public void addObserver(IObserver<A> observer) {
		delegate.addObserver(observer);
	}

	public void removeObserver(IObserver<A> observer) {
		delegate.removeObserver(observer);
	}

	public List<IObserver<A>> getObservers() {
		return delegate.getObservers();
	}

	// Object

	public String toString() {
		return getType().toString() + delegate.toString();
	}

	// Box

	public void bind(IBox<A> that) {
		new Bind<A>(this, that);
	}

	public IBox<A> inspect(String label) {
		return new Inspect<A>(this, label).getResult();
	}

	public <B> IBox<B> apply(IUnaryFunction<A, B> f) {
		return new Apply<A, B>(this, f).getResult();
	}

	public <B> IBox<B> map(IUnaryFunction<A, B> f) {
		return new Map<A, B>(this, f).getResult();
	}

	public <B> IBox<B> path(IFactory factory, Object aMetaClass, Object property) throws ClassNotFoundException {
		IUnaryFunction<A, IBox<B>> accessor = factory.createPropertyAccessor(property);
		A aDefault = factory.createInstance(aMetaClass);
		return new Path<A, B>(this, aDefault, accessor).getResult();
	}

	public IBox<A> select(IBox<Boolean> b) {
		return new Select<A>(this.zip(b)).getResult();
	}

	public IBox<A> select(IUnaryFunction<A, Boolean> f) {
		return this.select(this.apply(f));
	}

	public <B> IBox<IPair<A, B>> zip(IBox<B> b) {
		return new BinaryZip<A, B>(this, b).getResult();
	}

}
