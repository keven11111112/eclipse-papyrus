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
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

public class WeakKeysWeakValuesBinaryCache<K1, K2, V> implements IBinaryCache<K1, K2, V> {
	private Map<K1, Map<K2, WeakReference<V>>> cache = new WeakHashMap<K1, Map<K2, WeakReference<V>>>();

	@Override
	public V get(K1 key1, K2 key2) {
		Map<K2, WeakReference<V>> cache2 = cache.get(key1);
		if (cache2 == null) {
			return null;
		} else {
			WeakReference<V> ret = cache2.get(key2);
			return ret == null ? null : ret.get();
		}
	}

	@Override
	public void put(K1 key1, K2 key2, V value) {
		Map<K2, WeakReference<V>> cache2 = cache.get(key1);
		if (cache2 == null) {
			cache2 = new WeakHashMap<K2, WeakReference<V>>();
			cache.put(key1, cache2);
		}
		cache2.put(key2, new WeakReference<V>(value));
	}

	@Override
	public Iterable<Map.Entry<K2, V>> get(K1 key) {
		Iterable<Map.Entry<K2, V>> result;
		final Map<K2, WeakReference<V>> cache2 = cache.get(key);

		if (cache2 == null) {
			result = Collections.emptySet();
		} else {
			result = new Iterable<Map.Entry<K2, V>>() {
				@Override
				public Iterator<Map.Entry<K2, V>> iterator() {
					return new DereferencingIterator<K2, V>(cache2.entrySet().iterator());
				}
			};
		}

		return result;
	}

	private static class DereferencingIterator<K, V> implements Iterator<Map.Entry<K, V>> {
		private static final int STATE_READY = 0;
		private static final int STATE_PREPARED = 1;
		private static final int STATE_REMOVABLE = 2;
		private static final int STATE_DONE = 3;

		private final Iterator<? extends Map.Entry<? extends K, ? extends Reference<? extends V>>> delegate;
		private int state = STATE_READY;
		private Map.Entry<K, V> prepared;

		DereferencingIterator(Iterator<? extends Map.Entry<? extends K, ? extends Reference<? extends V>>> delegate) {
			super();

			this.delegate = delegate;
		}

		private void prepare() {
			if (state != STATE_PREPARED) {
				state = STATE_DONE;
				while (delegate.hasNext()) {
					Map.Entry<? extends K, ? extends Reference<? extends V>> next = delegate.next();

					K key = next.getKey();
					V value = next.getValue().get();

					if ((key != null) && (value != null)) {
						prepared = new AbstractMap.SimpleImmutableEntry<K, V>(key, value);
						state = STATE_PREPARED;
						break;
					}
				}
			}
		}

		@Override
		public boolean hasNext() {
			while ((state != STATE_PREPARED) && (state != STATE_DONE)) {
				prepare();
			}

			return state == STATE_PREPARED;
		}

		@Override
		public Entry<K, V> next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			Map.Entry<K, V> result = prepared;
			prepared = null;
			state = STATE_REMOVABLE;
			return result;
		}

		@Override
		public void remove() {
			if (state != STATE_REMOVABLE) {
				throw new IllegalStateException();
			}
			delegate.remove();
			state = STATE_READY;
		}

	}
}
