/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl;

import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IFactory;

public class Bag<E> extends Collection<E>implements IBag<E> {

	public Bag(IFactory factory) {
		super(factory);
	}

	// IConstrained

	@Override
	public IConstraints getConstraints() {
		return IConstraints.BAG;
	}

}
