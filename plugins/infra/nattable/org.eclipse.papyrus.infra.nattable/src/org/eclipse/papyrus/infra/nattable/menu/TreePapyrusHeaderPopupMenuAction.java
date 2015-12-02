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

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

/**
 * @author VL222926
 *
 */
public class TreePapyrusHeaderPopupMenuAction extends PapyrusHeaderPopupMenuAction {

	/**
	 * Constructor.
	 *
	 * @param menuId
	 */
	public TreePapyrusHeaderPopupMenuAction(String menuId) {
		super(menuId);
	}

	
	/**
	 * @see org.eclipse.papyrus.infra.nattable.menu.PapyrusHeaderPopupMenuAction#addMenuSeparators(org.eclipse.jface.action.MenuManager)
	 *
	 * @param menuManager
	 */
	@Override
	protected void addMenuSeparators(final MenuManager menuManager) {
		//1. we add the common separators
		super.addMenuSeparators(menuManager);
		//2. we add a new separator for tree actions
		final Separator tree = new Separator(MenuConstants.TREE_SEPARATOR_ID);
		tree.setVisible(true);
		menuManager.add(tree);

	}
}
