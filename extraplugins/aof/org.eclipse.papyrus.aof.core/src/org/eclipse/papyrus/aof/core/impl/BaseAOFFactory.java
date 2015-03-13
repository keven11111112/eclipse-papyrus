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
package org.eclipse.papyrus.aof.core.impl;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.JavaPropertyAccessor;

/**
 * Java-related version of IFactory (additional implementation of BaseFactory)
 * 
 */
public class BaseAOFFactory extends BaseFactory {

	public <A> IBox<A> createPropertyBox(Object object, Object property) {
		// TODO JavaBean introspection on getter returning the corresponding Box
		throw new UnsupportedOperationException("Method not implemented yet.");
		//return null;
	}

	public <A, B> IUnaryFunction<A, IBox<B>> createPropertyAccessor(Object property) {
		IUnaryFunction<A, IBox<B>> accessor = null;
		if (property instanceof String) {
			accessor = new JavaPropertyAccessor<A, B>((String) property);
		}
		return accessor;
	}

	private static final Boolean ZERO_BOOLEAN = Boolean.FALSE;
	private static final Integer ZERO_INTEGER = new Integer(0);
	private static final Double ZERO_DOUBLE = new Double(0);
	private static final String ZERO_STRING = "";

	public <A> A createInstance(Object clazz) throws ClassNotFoundException {
		// classes for Java primitive types
		if (clazz == Boolean.class) {
			return (A) ZERO_BOOLEAN;
		}
		else if (clazz == Integer.class) {
			return (A) ZERO_INTEGER;
		}
		else if (clazz == Double.class) {
			return (A) ZERO_DOUBLE;
		}
		else if (clazz == String.class) {
			return (A) ZERO_STRING;
		}
		// model-defined classes
		else if (clazz instanceof Class<?>) {
			try {
				return ((Class<A>) clazz).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		}
		else
			throw new ClassNotFoundException("Class " + clazz + " not found");
	}

}
