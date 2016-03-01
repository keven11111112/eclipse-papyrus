/*****************************************************************************
 * Copyright (c) 2009, 2016 LIFL, CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus - bug 488791
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;

/**
 * @author dumoulin
 */
public class RootModel extends AbstractModel {

	/**
	 * Child of this root model.
	 */
	private AbstractPanelModel child;

	/**
	 * Constructor.
	 *
	 * @param child
	 */
	public RootModel(AbstractPanelModel child) {
		this.child = child;
		child.setParent(this);
	}

	/**
	 * Return the parent of the model. Can be null in the case of rootModel.
	 *
	 * @return the parent
	 */
	@Override
	public AbstractModel getParent() {
		return null;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	@Override
	public void setParent(AbstractModel parent) {
	}

	/**
	 * Replace the actual child by the new child.
	 *
	 */
	@Override
	public void replaceChild(AbstractPanelModel oldChild, AbstractPanelModel newChild) {

		assert (child == oldChild);
		child = newChild;

	}

	/**
	 * Lookup the folder containing the specified tabItem.
	 *
	 * @param tabItem
	 * @return
	 */
	protected TabFolderModel lookupTabFolder(IPageModel tabItem) {
		return child.lookupTabFolder(tabItem);
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public AbstractPanelModel getChild() {
		return child;
	}

}
