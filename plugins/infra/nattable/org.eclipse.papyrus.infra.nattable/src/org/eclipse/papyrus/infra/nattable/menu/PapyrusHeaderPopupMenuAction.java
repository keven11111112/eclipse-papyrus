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

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.ui.menu.PopupMenuAction;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IMenuService;

/**
 * @author VL222926
 * 
 *         This class allows to fill the popup menu of the table, according to the contribution described in the plugin.xml
 *
 */
public class PapyrusHeaderPopupMenuAction extends PopupMenuAction {

	/**
	 * the id of the menu to create, plugins can contribute to the menu using this id;
	 */
	private final String menuId;

	/**
	 * the location used to fill the menu
	 */
	private final String menuLocation;

	/**
	 * The menu manager for the menu creation.
	 */
	private MenuManager menuManager = null;

	/**
	 * The create menu.
	 */
	private Menu menu = null;

	/**
	 * Constructor.
	 *
	 * @param menu
	 */
	public PapyrusHeaderPopupMenuAction(final String menuId) {
		super(null);
		this.menuId = menuId;
		this.menuLocation = new StringBuilder(MenuConstants.POPUP).append(MenuConstants.DELIMITER).append(menuId).toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.ui.menu.PopupMenuAction#run(org.eclipse.nebula.widgets.nattable.NatTable, org.eclipse.swt.events.MouseEvent)
	 */
	@Override
	public void run(final NatTable natTable, final MouseEvent event) {
		if (null != menu && null != menuManager) {
			menu.dispose();
			menuManager.dispose();
		}

		menuManager = new MenuManager(MenuConstants.POPUP, this.menuId);
		menu = menuManager.createContextMenu(natTable);

		addMenuSeparators(menuManager);
		/* This listener allows us to fill the popup menu using extension point contributing to the popup menu of the table */
		menuManager.addMenuListener(new IMenuListener() {

			/**
			 * 
			 * @see org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
			 *
			 * @param manager
			 */
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				IMenuService menuService = PlatformUI.getWorkbench().getService(IMenuService.class);
				if (menuService != null) {
					menuService.populateContributionManager(menuManager, PapyrusHeaderPopupMenuAction.this.menuLocation);
				}
			}
		});

		menu.setVisible(true);
		return;
	}

	/**
	 * 
	 * @param menuManager
	 *            the menu manager
	 */
	protected void addMenuSeparators(final MenuManager menuManager) {
		final Separator general = new Separator(MenuConstants.GENERAL_SEPARATOR_ID);
		general.setVisible(false);
		menuManager.add(general);

		final Separator edit = new Separator(MenuConstants.EDIT_SEPARATOR_ID);
		edit.setVisible(true);
		menuManager.add(edit);
	}


}
