/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.converter;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDisplayConverter;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;

/**
 * The display converter for the multi UML reference.
 */
public class MultiUMLReferenceDisplayConverter extends DefaultDisplayConverter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter#displayToCanonicalValue(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell, org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object)
	 */
	@Override
	public Object displayToCanonicalValue(final ILayerCell cell, final IConfigRegistry configRegistry, final Object displayValue) {
		return displayValue;
	}
}
