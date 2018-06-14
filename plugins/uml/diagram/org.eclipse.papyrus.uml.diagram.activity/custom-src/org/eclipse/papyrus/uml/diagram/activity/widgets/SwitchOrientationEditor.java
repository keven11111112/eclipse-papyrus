/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.widgets;

import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * The switch orientation editor.
 * 
 * @since 3.2
 */
public class SwitchOrientationEditor extends AbstractPropertyEditor {

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The style for the widget
	 */
	public SwitchOrientationEditor(final Composite parent, final int style) {
		super(new SwitchOrientationWidget(parent, style));
	}

}
