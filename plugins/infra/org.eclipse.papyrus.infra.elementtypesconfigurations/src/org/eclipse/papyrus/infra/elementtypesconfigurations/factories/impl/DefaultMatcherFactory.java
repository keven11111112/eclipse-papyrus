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
package org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl;

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.IMatcherFactory;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;

public class DefaultMatcherFactory implements IMatcherFactory<MatcherConfiguration> {

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl.AbstractMatcherFactory#createElementMatcher(org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration)
	 *
	 * @param matcherConfiguration
	 * @return
	 */
	@Override
	public IElementMatcher createElementMatcher(MatcherConfiguration matcherConfiguration) {
		String matcherClassName = matcherConfiguration.getMatcherClassName();
		IElementMatcher matcher = ClassLoaderHelper.newInstance(matcherClassName, IElementMatcher.class);
		return matcher;
	}
}
