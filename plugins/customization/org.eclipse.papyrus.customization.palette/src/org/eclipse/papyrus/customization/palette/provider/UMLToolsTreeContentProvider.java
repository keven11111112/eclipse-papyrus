/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.palette.provider;

import java.util.Collection;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;

/**
 * Content provider for available tools viewer
 */
public class UMLToolsTreeContentProvider implements ITreeContentProvider {

	/**
	 * Constructor
	 *
	 * @param viewer
	 *            The viewer whose ContentProvider this content provider is
	 */
	public UMLToolsTreeContentProvider() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(final Object parentElement) {
		Object[] elements = null;

		if (parentElement instanceof Collection<?>) {
			elements = ((Collection<?>) parentElement).toArray();
		} else if (parentElement instanceof PaletteRoot) {
			// paletteUil.getAllEntries(...) to add drawers
			// if so, uncomment the addFilterbutton for drawers in populate tool bar
			elements = PaletteUtil.getAllToolEntries(((PaletteRoot) parentElement)).toArray();
		}

		return elements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(final Object inputElement) {
		Object[] elements = null;

		if (inputElement instanceof Collection<?>) {
			elements = ((Collection<?>) inputElement).toArray();
		} else if (inputElement instanceof PaletteRoot) {
			// paletteUil.getAllEntries(...) to add drawers
			// if so, uncomment the addFilterbutton for drawers in populate tool bar
			elements = PaletteUtil.getAllToolEntries(((PaletteRoot) inputElement)).toArray();
		}

		if (elements == null) {
			elements = new Object[0];
		}
		return elements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(final Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(final Object element) {
		return null != getChildren(element) && 0 < getChildren(element).length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		// Do nothing
	}
}