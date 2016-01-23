/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.emf.spi.resolver;

/**
 * A non-resolver.
 */
final class IdentityEObjectResolver implements IEObjectResolver {
	static final IdentityEObjectResolver INSTANCE = new IdentityEObjectResolver();

	private IdentityEObjectResolver() {
		super();
	}

	@Override
	public Object resolve(Object object) {
		return object;
	}

	@Override
	public IEObjectResolver compose(IEObjectResolver other) {
		return other;
	}
}
