/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.aof.sync.examples.uml.internal.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Static utilities for working with named elements.
 */
public class NamedElements {

	private NamedElements() {
		super();
	}

	/**
	 * Creates a shallow copy of an {@code element}, essentially just creating a new instance
	 * of the same metaclass as the {@code element} and giving it the same name.
	 * 
	 * @param element
	 *            a named element
	 * 
	 * @return the shallow copy of it
	 */
	public static <T extends NamedElement> T shallowCopy(T element) {
		@SuppressWarnings("unchecked")
		T result = (T) EcoreUtil.create(element.eClass());
		result.setName(element.getName());
		return result;
	}
}
