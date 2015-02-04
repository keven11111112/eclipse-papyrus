/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.properties.protocoleditor;

import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.views.properties.widgets.MultiReference;
import org.eclipse.swt.widgets.Composite;

/**
 * Multiple reference editor with drag and drop support for protocol editor.
 * 
 * @author ysroh
 *
 */
public class MultiReferenceWithDnDSupport extends MultiReference {

	/**
	 * Constructor
	 * 
	 * @param parent
	 * @param style
	 */
	public MultiReferenceWithDnDSupport(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.views.properties.widgets.MultiReference#
	 * createMultipleReferenceEditor(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected MultipleReferenceEditor createMultipleReferenceEditor(
			Composite parent, int style) {
		return new MultipleReferenceEditorWithDnDSupport(parent, style);
	}

}
