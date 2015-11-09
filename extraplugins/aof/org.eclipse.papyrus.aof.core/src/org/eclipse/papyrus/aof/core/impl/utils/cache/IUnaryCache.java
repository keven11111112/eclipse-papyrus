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

public interface IUnaryCache<K, V> {
	V get(K key);

	void put(K key, V value);

	/**
	 * Removes a cached association, if it is present.
	 * 
	 * @param key
	 *            the key to remove, if it is currently associated to the
	 *            {@code value}
	 * @param value
	 *            the associated value to remove, if it is present under the
	 *            {@code key}
	 */
	void remove(K key, V value);
}
