/*****************************************************************************
 * Copyright (c) 2017 CEA, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Pierre GAUTIER (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.papyrus.infra.widgets.selectors.StringSelector;
import org.eclipse.swt.widgets.Composite;

/**
 * MultipleStringEditor with fixed type parameter to be used as MultipleStringEditor<?> as can its specified child classes can be.
 *
 * @since 3.1
 */
public class TypedMultipleStringEditor extends MultipleStringEditor<StringSelector> {

	/**
	 * Constructs an Editor for multiple strings values
	 * The widget is a List, with controls to move values up/down, add values and remove values.
	 *
	 * @param parent
	 *            The Composite in which this editor is created
	 * @param style
	 *            The List's style
	 */
	public TypedMultipleStringEditor(final Composite parent, final int style) {
		super(parent, style, true);
	}

}
