/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.nebula.widgets.nattable.NatTable;

/**
 * The body menu for the tree table
 * 
 * @since 2.0
 *
 */
public class TreePapyrusBodyPopupMenuAction extends PapyrusBodyPopupMenuAction {

	/**
	 * 
	 * Constructor.
	 *
	 * @param menuId
	 *            the id of the body menu
	 * @param nattable
	 *            the nattable for which we are creating the body menu
	 */
	public TreePapyrusBodyPopupMenuAction(final String menuId, final NatTable nattable) {
		super(menuId, nattable);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.menu.PapyrusBodyPopupMenuAction#addMenuSeparators(org.eclipse.jface.action.MenuManager)
	 *
	 * @param menuManager
	 */
	protected void addMenuSeparators(IMenuManager menuManager) {
		super.addMenuSeparators(menuManager);
		final Separator separator = new Separator(MenuConstants.TREE_SEPARATOR_ID);
		separator.setVisible(true);
		menuManager.insertAfter(MenuConstants.EDIT_SEPARATOR_ID, separator);
	};


}
