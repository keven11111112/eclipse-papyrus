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

import java.util.Map;
import java.util.Objects;

public abstract class AbstractUnaryCache<K, W, V> implements IUnaryCache<K, V> {
	private final Map<K, W> cache;

	protected AbstractUnaryCache(Map<K, W> cache) {
		super();

		this.cache = cache;
	}

	@Override
	public V get(K key) {
		W stored = cache.get(key);
		return (stored == null) ? null : extract(stored);
	}

	protected abstract V extract(W stored);

	@Override
	public void put(K key, V value) {
		cache.put(key, encapsulate(value));
	}

	protected abstract W encapsulate(V value);

	@Override
	public void remove(K key, V value) {
		if (Objects.equals(get(key), value)) {
			cache.remove(key);
		}
	}
}