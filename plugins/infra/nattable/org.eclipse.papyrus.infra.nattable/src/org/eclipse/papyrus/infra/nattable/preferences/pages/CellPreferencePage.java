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

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for configuring Papyrus NatTable cell.
 *
 * @since 4.0
 */
public class CellPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Name of the Unsupported Column Cell Text preference.
	 */
	public static final String UNSUPPORTED_COLUMN_CELL_TEXT = "unsupportedColumnCellText"; //$NON-NLS-1$

	/**
	 * Default constructor.
	 */
	public CellPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Papyrus cell configuration."); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createFieldEditors() {
		addField(new StringFieldEditor(UNSUPPORTED_COLUMN_CELL_TEXT, Messages.CellPreferencePage_UnsupportedColumnCellLabel, getFieldEditorParent()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(final IWorkbench workbench) {
		// Do nothing
	}
}
