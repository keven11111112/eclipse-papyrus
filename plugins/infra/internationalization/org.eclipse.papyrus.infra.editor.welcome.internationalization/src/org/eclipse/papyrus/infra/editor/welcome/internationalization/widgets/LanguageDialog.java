/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.editor.welcome.internationalization.widgets;

import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * The language property dialog widget for the internationalization.
 */
public class LanguageDialog extends AbstractPropertyEditor {

	/**
	 * The LanguageDialog widget.
	 */
	protected org.eclipse.papyrus.infra.editor.welcome.internationalization.widgets.editors.LanguageDialog editor;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed.
	 * @param style
	 *            The style for the widget.
	 */
	public LanguageDialog(final Composite parent, final int style) {
		setEditor(createLanguageDialogEditor(parent, style));
	}

	/**
	 * Creates the language dialog.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed.
	 * @param style
	 *            The style for the widget.
	 * @return The language dialog.
	 */
	protected org.eclipse.papyrus.infra.editor.welcome.internationalization.widgets.editors.LanguageDialog createLanguageDialogEditor(
			final Composite parent, final int style) {
		return editor = new org.eclipse.papyrus.infra.editor.welcome.internationalization.widgets.editors.LanguageDialog(parent, style);
	}

}
