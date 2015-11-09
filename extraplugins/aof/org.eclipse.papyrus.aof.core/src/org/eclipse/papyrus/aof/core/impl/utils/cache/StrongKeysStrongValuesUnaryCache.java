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

import java.util.HashMap;

public class StrongKeysStrongValuesUnaryCache<K, V> extends AbstractUnaryCache<K, V, V> {
	public StrongKeysStrongValuesUnaryCache() {
		super(new HashMap<K, V>());
	}

	@Override
	protected V extract(V stored) {
		return stored;
	}

	@Override
	protected V encapsulate(V value) {
		return value;
	}

}
