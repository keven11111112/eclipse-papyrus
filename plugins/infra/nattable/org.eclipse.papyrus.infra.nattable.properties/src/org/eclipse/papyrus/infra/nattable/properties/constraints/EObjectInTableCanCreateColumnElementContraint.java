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
 * The java constraint to define the constraint to create the paste properties from the active nattable editor.
 * 
 * @since 2.1
 */
public class EObjectInTableCanCreateColumnElementContraint extends EObjectInTableJavaConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.constraints.EObjectInTableJavaConstraint#checkMoreConstraints(org.eclipse.papyrus.infra.nattable.model.nattable.Table)
	 */
	@Override
	protected boolean checkMoreConstraints(final Table table) {
		return !CreatableEObjectAxisUtils.getCreatableElementIds(table, true).isEmpty();
	}

}
