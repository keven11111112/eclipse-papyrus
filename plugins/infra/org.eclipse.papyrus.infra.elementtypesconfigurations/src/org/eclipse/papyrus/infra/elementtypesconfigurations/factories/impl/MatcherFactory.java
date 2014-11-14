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

public class MatcherFactory implements IMatcherFactory<MatcherConfiguration> {

	public IElementMatcher createElementMatcher(MatcherConfiguration matcherConfiguration) {
		//Try to provide default interpretation
		String matcherClassName = matcherConfiguration.getMatcherClassName();
		IElementMatcher matcher = ClassLoaderHelper.newInstance(matcherClassName, IElementMatcher.class);
		return matcher;
	}
}
