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
package org.eclipse.papyrus.aof.core.utils;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.ICollection;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.ISingleton;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

public class Functions {

	public static <E> IUnaryFunction<E, E> identity() {
		return new IUnaryFunction<E, E>() {
			@Override
			public E apply(E element) {
				return element;
			}
		};
	}

	public static IUnaryFunction<Boolean, Boolean> not() {
		return new IUnaryFunction<Boolean, Boolean>() {
			@Override
			public Boolean apply(Boolean element) {
				return !element;
			}
		};
	}

	public static <E> IUnaryFunction<E, Boolean> not(final IUnaryFunction<E, Boolean> function) {
		return new IUnaryFunction<E, Boolean>() {
			@Override
			public Boolean apply(E element) {
				return !function.apply(element);
			}
		};
	}

	public static IUnaryFunction<Object, Boolean> instanceOf(final Class<?> metaClass) {
		return new IUnaryFunction<Object, Boolean>() {
			@Override
			public Boolean apply(Object element) {
				return metaClass.isInstance(element);
			}
		};
	}


	public static IUnaryFunction<Object, Boolean> instanceOf(final IMetaClass<?> metaClass) {
		return new IUnaryFunction<Object, Boolean>() {
			@Override
			public Boolean apply(Object element) {
				return metaClass.isInstance(element);
			}
		};
	}

	/**
	 * Obtains a predicate that tests whether a box is empty (for {@linkplain ICollection collections})
	 * or {@code null} (for {@linkplain ISingleton singletons}).
	 * 
	 * @return the empty-or-null box predicate
	 */
	public static IUnaryFunction<IBox<?>, Boolean> emptyOrNull() {
		return new IUnaryFunction<IBox<?>, Boolean>() {
			@Override
			public Boolean apply(IBox<?> input) {
				return (input.length() == 0) || (input.isSingleton() && (input.get(0) == null)); 
			}
		};
	}
}
