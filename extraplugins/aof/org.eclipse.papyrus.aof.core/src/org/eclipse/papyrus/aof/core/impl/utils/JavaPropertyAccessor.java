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

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

/**
 * Defines an AOF function object that represents a JavaBean property getter.
 * 
 * @author obeaudoux
 *
 * @param <A>
 *            The type of
 * @param <B>
 */
public class JavaPropertyAccessor<A, B> implements IUnaryFunction<A, IBox<B>> {

	private Method propertyAccessor;
	private String propertyName;

	public JavaPropertyAccessor(String propertyName) {
		this.propertyName = propertyName;
	}

	private Method getPropertyAccessor(A object) {
		if (propertyAccessor == null) {
			try {
				PropertyDescriptor property = null;
				PropertyDescriptor[] properties = Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors();
				int i = 0;
				while ((i < properties.length) && (property == null)) {
					if (properties[i].getName().equals(propertyName)) {
						property = properties[i];
					}
					else {
						i++;
					}
				}
				propertyAccessor = property.getReadMethod();
			} catch (IntrospectionException e) {
			}
		}
		return propertyAccessor;
	}

	public IBox<B> apply(A object) {
		Object result = null;
		try {
			result = getPropertyAccessor(object).invoke(object);
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (InvocationTargetException e) {
		}
		return (IBox<B>) result;
	}
}
