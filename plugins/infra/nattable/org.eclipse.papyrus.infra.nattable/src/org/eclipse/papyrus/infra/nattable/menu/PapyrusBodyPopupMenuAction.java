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
 * The Body popup menu for the table
 *
 */
public class PapyrusBodyPopupMenuAction extends AbstractPapyrusPopupMenuAction {

	/**
	 * 
	 * Constructor.
	 *
	 * @param menuId
	 *            the id of the body menu
	 * @param nattable
	 *            the nattable for which we are creating the body menu
	 */
	public PapyrusBodyPopupMenuAction(final String menuId, final NatTable nattable) {
		super(menuId, nattable);
	}


	/**
	 * @see org.eclipse.papyrus.infra.nattable.menu.AbstractPapyrusPopupMenuAction#addMenuSeparators(org.eclipse.jface.action.MenuManager)
	 *
	 * @param menuManager
	 */
	@Override
	protected void addMenuSeparators(IMenuManager menuManager) {
		super.addMenuSeparators(menuManager);

		Separator separator = new Separator(MenuConstants.CELL_SEPARATOR_ID);
		separator.setVisible(true);
		menuManager.add(separator);

		separator = new Separator(MenuConstants.ROWS_AND_COLUMNS_SEPARATOR_ID);
		separator.setVisible(true);
		menuManager.add(separator);

		separator = new Separator(MenuConstants.CREATIONS_SEPARATOR_ID);
		separator.setVisible(true);
		menuManager.add(separator);

		separator = new Separator(MenuConstants.TOOLS_SEPARATOR_ID);
		separator.setVisible(true);
		menuManager.add(separator);

		// commented to avoid to pollute the table menu with global contribution
		// separator = new Separator(MenuConstants.ADDITIONS_SEPARATOR_ID);
		// separator.setVisible(true);
		// menuManager.add(separator);
	}
}
