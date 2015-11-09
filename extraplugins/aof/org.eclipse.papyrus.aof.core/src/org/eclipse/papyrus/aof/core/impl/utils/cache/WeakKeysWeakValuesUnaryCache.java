/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Frederic Jouault - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl.utils.cache;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakKeysWeakValuesUnaryCache<K, V> extends AbstractUnaryCache<K, Reference<V>, V> {

	public WeakKeysWeakValuesUnaryCache() {
		super(new WeakHashMap<K, Reference<V>>());
	}

	@Override
	protected V extract(Reference<V> stored) {
		return stored.get();
	}

	@Override
	protected Reference<V> encapsulate(V value) {
		return new WeakReference<>(value);
	}

}
