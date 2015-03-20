/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.converter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter;
import org.eclipse.papyrus.infra.widgets.util.ISetPapyrusConverter;

/**
 * 
 * This class allows us to convert UML Object into string and string to UML Object
 *
 */
public class UMLSingleReferenceDisplayConverter extends DisplayConverter implements ISetPapyrusConverter {


	/**
	 * the parser used for references, separated by ','
	 */
	private IPapyrusConverter parser;

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter#canonicalToDisplayValue(java.lang.Object)
	 *
	 * @param canonicalValue
	 * @return
	 */
	@Override
	public Object canonicalToDisplayValue(Object canonicalValue) {
		if (canonicalValue instanceof Object) {
			return parser.canonicalToEditValue(canonicalValue,0);
		}
		return parser.canonicalToEditValue(null,0);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter#displayToCanonicalValue(java.lang.Object)
	 *
	 * @param displayValue
	 * @return
	 */
	@Override
	public Object displayToCanonicalValue(Object displayValue) {
		if (ICellManager.EMPTY_STRING.equals(displayValue) || ICellManager.NULL_VALUE.equals(displayValue)) {
			return null;
		}
		Assert.isTrue(displayValue instanceof String);
		return parser.editToCanonicalValue((String) displayValue, 0);
	}


	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.ISetPapyrusConverter#setPapyrusConverter(org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter)
	 *
	 * @param parser
	 */
	@Override
	public void setPapyrusConverter(IPapyrusConverter parser) {
		this.parser = parser;
	}
}
