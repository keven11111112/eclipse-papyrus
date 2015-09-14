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
import com.google.inject.binder.ScopedBindingBuilder;

/**
 * A scoped binding builder that applies its scope to multiple linked binding builders.
 */
class MultiScopedBindingBuilder implements ScopedBindingBuilder {
	private final Iterable<ScopedBindingBuilder> delegates;

	public MultiScopedBindingBuilder(Iterable<ScopedBindingBuilder> delegates) {
		super();

		this.delegates = delegates;
	}

	@Override
	public void in(Class<? extends Annotation> scopeAnnotation) {
		delegates.forEach(sbb -> sbb.in(scopeAnnotation));
	}

	@Override
	public void in(Scope scope) {
		delegates.forEach(sbb -> sbb.in(scope));
	}

	@Override
	public void asEagerSingleton() {
		delegates.forEach(ScopedBindingBuilder::asEagerSingleton);
	}

}
