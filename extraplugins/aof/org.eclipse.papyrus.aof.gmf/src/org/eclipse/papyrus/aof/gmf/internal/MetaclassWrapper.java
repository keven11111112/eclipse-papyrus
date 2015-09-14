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

package org.eclipse.papyrus.aof.gmf.internal;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.BaseFactory;
import org.eclipse.papyrus.aof.core.impl.BaseMetaClass;

/**
 * A metaclass shim that provides alternative factory ownership for a metaclass.
 */
public class MetaclassWrapper<C> extends BaseMetaClass<C> {
	private final IMetaClass<C> delegate;

	public MetaclassWrapper(BaseFactory factory, IMetaClass<C> delegate) {
		super(factory);

		this.delegate = delegate;
	}

	@Override
	public boolean isInstance(Object object) {
		return delegate.isInstance(object);
	}

	static <C> IMetaClass<C> unwrap(IMetaClass<C> other) {
		return (other instanceof MetaclassWrapper<?>)
				? ((MetaclassWrapper<C>) other).delegate
				: other;
	}

	@Override
	public boolean isSubTypeOf(IMetaClass<?> that) {
		return delegate.isSubTypeOf(unwrap(that));
	}

	@Override
	public C newInstance() {
		return delegate.newInstance();
	}

	@Override
	public C getDefaultInstance() {
		return delegate.getDefaultInstance();
	}

	@Override
	public void setDefaultInstance(C defaultInstance) {
		delegate.setDefaultInstance(defaultInstance);
	}

	@Override
	protected C computeDefaultInstance() {
		throw new IllegalArgumentException("should never be invoked on the wrapper"); //$NON-NLS-1$
	}

	@Override
	public <E> IUnaryFunction<C, IBox<E>> getPropertyAccessor(Object property) {
		return delegate.getPropertyAccessor(property);
	}

}
