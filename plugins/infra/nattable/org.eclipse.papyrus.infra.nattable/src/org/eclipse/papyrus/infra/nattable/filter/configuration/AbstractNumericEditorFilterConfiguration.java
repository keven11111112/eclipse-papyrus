/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.filter.configuration;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.nattable.filter.PapyrusTextMatchingMode;

/**
 * abstract configuration to filter numerical values
 *
 */
public abstract class AbstractNumericEditorFilterConfiguration extends TextEditorFilterConfiguration {


	/**
	 * @see org.eclipse.papyrus.infra.nattable.filter.configuration.TextEditorFilterConfiguration#configureRegistry(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object, java.lang.String, List<Object>)
	 *
	 * @param configRegistry
	 * @param configLabel
	 * @param columnElement
	 */
	@Override
	public void configureFilter(IConfigRegistry configRegistry, Object columnElement, String configLabel) {
		super.configureFilter(configRegistry, columnElement, configLabel);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.filter.configuration.TextEditorFilterConfiguration#getFilterMatchingMode()
	 *
	 * @return
	 */
	@Override
	protected PapyrusTextMatchingMode getFilterMatchingMode() {
		return PapyrusTextMatchingMode.NUM;
	}
}
