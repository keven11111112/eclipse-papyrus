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

public interface IBinaryCache<K1, K2, V> {
	V get(K1 key1, K2 key2);

	void put(K1 key1, K2 key2, V value);

	Iterable<Map.Entry<K2, V>> get(K1 key);
}
