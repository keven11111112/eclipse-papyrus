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
 * A composite resolver.
 */
class ChainedEObjectResolver implements IEObjectResolver {

	private final IEObjectResolver car;
	private final IEObjectResolver cdr;

	ChainedEObjectResolver(IEObjectResolver first, IEObjectResolver second) {
		super();

		this.car = first;
		this.cdr = second;
	}

	@Override
	public Object resolve(Object object) {
		Object result = car.resolve(object);

		if ((result == null) || (result == object)) {
			result = cdr.resolve(object);
		}

		return result;
	}

}
