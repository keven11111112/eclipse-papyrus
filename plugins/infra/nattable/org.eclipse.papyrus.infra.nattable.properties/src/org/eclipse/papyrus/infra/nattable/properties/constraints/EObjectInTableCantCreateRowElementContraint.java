/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.infra.nattable.properties.constraints;

import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.CreatableEObjectAxisUtils;

/**
 * The java constraint to define the constraint to not create the paste properties from the active nattable editor.
 * 
 * @since 2.2
 */
public class EObjectInTableCantCreateRowElementContraint extends EObjectInTableHasTreeFillingConfigurationConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.constraints.EObjectInTableHasTreeFillingConfigurationConstraint#checkMoreConstraints(org.eclipse.papyrus.infra.nattable.model.nattable.Table)
	 */
	@Override
	protected boolean checkMoreConstraints(final Table table) {
		return !super.checkMoreConstraints(table) && CreatableEObjectAxisUtils.getCreatableElementIds(table, false).isEmpty();
	}

}
