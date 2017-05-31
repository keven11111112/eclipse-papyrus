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
import org.eclipse.nebula.widgets.nattable.NatTable;

/**
 * @author VL222926
 * 
 *         This class allows to fill the popup menu of the table, according to the contribution described in the plugin.xml
 *
 */
public class PapyrusHeaderPopupMenuAction extends AbstractPapyrusPopupMenuAction {



	/**
	 * 
	 * Constructor.
	 *
	 * @param menuId
	 *            the id of the created menu
	 * @param natTable
	 *            the nattable for which this menu is created
	 */
	public PapyrusHeaderPopupMenuAction(final String menuId, final NatTable natTable) {
		super(menuId, natTable);
	}


	/**
	 * 
	 * @param menuManager
	 *            the menu manager
	 */
	protected void addMenuSeparators(final IMenuManager menuManager) {
		super.addMenuSeparators(menuManager);
	}
}
