/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.menu;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.IStructuredSelection;

public abstract class NamePropertyTester extends PropertyTester {
	/**
	 * property associated with the parameter linked to the command in the plugin.xml
	 */
	public static final String PARAMETER_ID = new String("org.eclipse.papyrus.infra.ui.menu.quickformatcommandParameter"); //$NON-NLS-1$
	/**
	 * property to test if a diagram has the required edit policy
	 */
	public static final String IS_NAME_CHANGEABLE = "isNameChangeable"; //$NON-NLS-1$


	/**
	 *
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_NAME_CHANGEABLE.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isNameChangeable((IStructuredSelection) receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}
	
	protected abstract boolean isNameChangeable(IStructuredSelection selection);
}
