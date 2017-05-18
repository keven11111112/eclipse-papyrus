/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.infra.editor.welcome.internationalization.widgets.editors;

import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.infra.widgets.editors.BooleanCheckbox;
import org.eclipse.swt.widgets.Composite;

/**
 * This allows to define the boolean checkbox that will be read only if the internationalization load preference is not enabled.
 */
public class BooleanInternationalizationChecbox extends BooleanCheckbox {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            The composite in which the widget will be displayed.
	 * @param style
	 *            The style for the widget.
	 *
	 */
	public BooleanInternationalizationChecbox(final Composite parent, final int style) {
		super(parent, style);
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.BooleanCheckbox#setReadOnly(boolean)
	 *
	 * @param readOnly
	 */
	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly || !InternationalizationPreferencesUtils.isInternationalizationNeedToBeLoaded());
	}
}
