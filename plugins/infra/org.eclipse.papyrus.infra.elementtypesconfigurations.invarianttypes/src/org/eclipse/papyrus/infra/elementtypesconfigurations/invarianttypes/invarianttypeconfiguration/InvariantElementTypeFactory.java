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
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration;

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.SpecializationTypeFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration;

public class InvariantElementTypeFactory extends SpecializationTypeFactory {

	@Override
	protected IElementMatcher createElementMatcher(SpecializationTypeConfiguration configuration) {
		if (configuration instanceof InvariantTypeConfiguration) {
			return new DefaultInvariantElementMatcher((InvariantTypeConfiguration) configuration);
		}
		return null;
	}

}
