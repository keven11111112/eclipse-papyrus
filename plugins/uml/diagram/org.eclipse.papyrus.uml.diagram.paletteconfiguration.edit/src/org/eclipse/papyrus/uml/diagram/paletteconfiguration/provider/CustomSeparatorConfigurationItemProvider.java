/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * Custom Item provider for SeparatorConfiguration.
 */
public class CustomSeparatorConfigurationItemProvider extends SeparatorConfigurationItemProvider {

	/** the separator label */
	private static final String SEPARATOR = "-------------";

	/**
	 * Constructor.
	 */
	public CustomSeparatorConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		// separator don't have child
		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		return SEPARATOR;
	}

}
