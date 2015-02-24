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
package org.eclipse.papyrus.infra.gmfdiag.canonical.strategy;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;


/**
 * The registration of a creation target strategy.
 */
class CreationTargetStrategyRegistration extends Registration<ICreationTargetStrategy, CreationTargetStrategyRegistration> {

	CreationTargetStrategyRegistration(IConfigurationElement config) throws CoreException {
		super(config, ICreationTargetStrategy.class);
	}

}
