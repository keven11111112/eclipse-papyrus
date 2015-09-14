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

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;

/**
 * A proxy for the Guice {@link Binder} protocol, exposing only a small
 * subset of that API.
 */
public interface BinderProxy {
	/**
	 * @see Binder#bind(Class)
	 */
	<T> AnnotatedBindingBuilder<T> bind(Class<T> clazz);

	/**
	 * @see Binder#bind(TypeLiteral)
	 */
	<T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral);

	/**
	 * @see Binder#bind(Key)
	 */
	<T> LinkedBindingBuilder<T> bind(Key<T> key);

}
