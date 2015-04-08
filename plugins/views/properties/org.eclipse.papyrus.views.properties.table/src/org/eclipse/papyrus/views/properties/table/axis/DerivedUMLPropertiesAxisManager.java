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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.table.axis;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;

/**
 * An AxisManager for custom/derived UML features (Such as Multiplicity)
 *
 * @author Camille Letavernier
 *
 */
public class DerivedUMLPropertiesAxisManager extends AbstractAxisManager {

	public static final String AXIS_MANAGER_ID = "org.eclipse.papyrus.uml.nattable.derived.features.axis.manager"; //$NON-NLS-1$

	public static final String PROPERTIES_PREFIX = "uml_derived_features:/"; //$NON-NLS-1$

	public static final String MULTIPLICITY = PROPERTIES_PREFIX + "multiplicity"; //$NON-NLS-1$

	@Override
	public boolean isSlave() {
		return false;
	}

	@Override
	public boolean isDynamic() {
		return false;
	}

	@Override
	public boolean canEditAxisHeader() {
		return true;
	}

	@Override
	public boolean canDestroyAxisElement(Integer axisIndex) {
		return false;
	}

	@Override
	public Command getDestroyAxisElementCommand(TransactionalEditingDomain domain, Integer axisPosition) {
		return null;
	}

	@Override
	public boolean canBeSavedAsConfig() {
		return false;
	}

}
