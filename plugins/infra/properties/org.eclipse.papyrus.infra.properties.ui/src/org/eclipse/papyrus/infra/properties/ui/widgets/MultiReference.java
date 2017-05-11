/*****************************************************************************
 * Copyright (c) 2010, 2017 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 516526
 *****************************************************************************/
package org.eclipse.papyrus.infra.properties.ui.widgets;

import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing multiple references in a List
 *
 * @see org.eclipse.papyrus.widgets.editors.BooleanCheckbox
 *
 * @author Camille Letavernier
 */
public class MultiReference extends AbstractMultiReference<MultipleReferenceEditor> {

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The style for the widget
	 */
	public MultiReference(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Creates the reference editor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The style for the widget
	 * @return The reference editor
	 */
	@Override
	protected MultipleReferenceEditor createMultipleReferenceEditor(Composite parent, int style) {
		return new MultipleReferenceEditor(parent, style);
	}

}
