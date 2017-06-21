/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 515806
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.preferences.pages;

import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage;
import org.eclipse.swt.widgets.Composite;

/**
 * A preference page for options used in NatTable.
 * @since 4.0
 */
public class NattablePreferencePage extends AbstractPapyrusPreferencePage {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage#createPageContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createPageContents(Composite parent) {
		// Do nothing - an empty page
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage#getBundleId()
	 */
	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}
}

