/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.databinding;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStringStyleObservableValue;

/**
 * The {@link CustomStringStyleObservableValue} used for connector decoration value.
 * 
 * @author Mickaël ADAM
 * @since 3.1
 */
public final class ConnectionDecorationStyleObservableValue extends CustomStringStyleObservableValue {
	/**
	 * The string used in cased of undefined value.
	 */
	private static final String DEFAULT_VALUE = "default";//$NON-NLS-1$

	/**
	 * Constructor.
	 * 
	 * @param source
	 *            The source.
	 * @param domain
	 *            The editing domain.
	 * @param styleName
	 *            the style name.
	 */
	public ConnectionDecorationStyleObservableValue(final View source, final EditingDomain domain, final String styleName) {
		super(source, domain, styleName);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStringStyleObservableValue#getDefaultValue()
	 */
	@Override
	protected String getDefaultValue() {
		return DEFAULT_VALUE;
	}
}