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

package org.eclipse.papyrus.aof.sync.internal;

import java.lang.annotation.Annotation;

import com.google.inject.Scope;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;

/**
 * A wrapper for {@link ScopedBindingBuilder}s that exposes only that protocol,
 * not additionally {@link LinkedBindingBuilder}.
 */
class ScopedBindingBuilderProxy implements ScopedBindingBuilder {
	private final ScopedBindingBuilder delegate;

	ScopedBindingBuilderProxy(ScopedBindingBuilder delegate) {
		super();

		this.delegate = delegate;
	}

	@Override
	public void in(Class<? extends Annotation> scopeAnnotation) {
		delegate.in(scopeAnnotation);
	}

	@Override
	public void in(Scope scope) {
		delegate.in(scope);
	}

	@Override
	public void asEagerSingleton() {
		delegate.asEagerSingleton();
	}

}
