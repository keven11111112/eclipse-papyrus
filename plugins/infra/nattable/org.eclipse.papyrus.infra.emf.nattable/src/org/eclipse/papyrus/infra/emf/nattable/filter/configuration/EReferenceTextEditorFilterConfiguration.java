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

package org.eclipse.papyrus.infra.emf.nattable.filter.configuration;

import org.eclipse.papyrus.infra.nattable.filter.configuration.TextEditorFilterConfiguration;

/**
 * String editor used for ereference
 *
 */
public class EReferenceTextEditorFilterConfiguration extends TextEditorFilterConfiguration {

	/**
	 * the id of this filter configuration
	 */
	private static final String ID = "org.eclipse.papyrus.infra.emf.nattable.ereference.text"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.infra.nattable.filter.configuration.TextEditorFilterConfiguration#getConfigurationDescription()
	 *
	 * @return
	 */
	@Override
	public String getConfigurationDescription() {
		return super.getConfigurationDescription();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.filter.configuration.TextEditorFilterConfiguration#getConfigurationId()
	 *
	 * @return
	 */
	@Override
	public String getConfigurationId() {
		return ID;
	}
}
