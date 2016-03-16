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
package org.eclipse.papyrus.infra.properties.ui.widgets;

import org.eclipse.papyrus.infra.widgets.editors.IconValueEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * The property editor for Icon with popup.
 */
public class IconPropertyEditor extends AbstractPropertyEditor {

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The style for the widget
	 */
	public IconPropertyEditor(final Composite parent, final int style) {
		setEditor(new IconValueEditor(parent, style));
	}

}
