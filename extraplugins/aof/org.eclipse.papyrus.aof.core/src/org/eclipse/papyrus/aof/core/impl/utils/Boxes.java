/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl.utils;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

public class Boxes {

	public static <A> IBox<A> slice(IBox<A> box, int from, int until) {
		IBox<A> result = AOFFactory.INSTANCE.createBox(box);
		for (int i = from; i < until; i++)
			result.append(box.get(i));
		return result;
	}

	public static <A, B> IBox<B> apply(IBox<A> box, IUnaryFunction<A, B> f) {
		IBox<B> result = AOFFactory.INSTANCE.createBox(box);
		for (A element : box)
			result.append(f.apply(element));
		return result;
	}

	public static int sum(IBox<Integer> box) {
		int result = 0;
		for (Integer i : box)
			result = result + i;
		return result;
	}

}
