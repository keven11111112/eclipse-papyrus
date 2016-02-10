/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.types.converter;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;


/**
 * Converter for Objects to Boolean value
 */
public class ObjectToBooleanConverter extends Converter implements IConverter {

	/**
	 * Creates a new ObjectToBooleanConverter
	 */
	public ObjectToBooleanConverter() {
		super(Object.class, Boolean.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean convert(Object fromObject) {
		if(fromObject == null) {
			return null;
		}

		if(fromObject instanceof Boolean) {
			return ((Boolean)fromObject);
		}

		if(fromObject instanceof String) {
			return Boolean.valueOf((String)fromObject);
		}

		return null;
	}

}
