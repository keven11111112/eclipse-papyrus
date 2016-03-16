/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.types.ui.properties.widgets;

import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * The Stereotype qualify name property Editor.
 */
public class ViewToDisplayPropertyEditor extends AbstractPropertyEditor {

	/** The stereotype qualify name value editor. */
	private ViewToDisplayValueEditor editor;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The style for the widget
	 */
	public ViewToDisplayPropertyEditor(final Composite parent, final int style) {
		editor = new ViewToDisplayValueEditor(parent, style);
		setEditor(editor);
	}

}
