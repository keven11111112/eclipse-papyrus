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

package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.AbstractUiBindingConfiguration;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.nattable.menu.MenuConstants;
import org.eclipse.papyrus.infra.nattable.menu.PapyrusBodyPopupMenuAction;
import org.eclipse.papyrus.infra.nattable.menu.PapyrusHeaderPopupMenuAction;
import org.eclipse.swt.SWT;

/**
 * @author VL222926
 *         This configuration allows to register popup menu for row header, column header and body of the table
 * @since 2.0
 */
public class TablePopupMenuConfiguration extends AbstractUiBindingConfiguration {

	/**
	 * the configured nattable widget
	 */
	protected final NatTable natTable;

	/**
	 * Constructor.
	 *
	 */
	public TablePopupMenuConfiguration(final NatTable natTable) {
		this.natTable = natTable;
	}


	/**
	 * @see org.eclipse.nebula.widgets.nattable.config.IConfiguration#configureUiBindings(org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry)
	 *
	 * @param uiBindingRegistry
	 */
	@Override
	public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
		registerBodyPopupMenu(uiBindingRegistry);
		registerColumnHeaderPopupMenu(uiBindingRegistry);
		registerRowHeaderPopupMenu(uiBindingRegistry);
	}

	/**
	 * register the menu configuration for the body of the table
	 * 
	 * @param uiBindingRegistry
	 * 
	 */
	protected void registerBodyPopupMenu(final UiBindingRegistry uiBindingRegistry) {
		uiBindingRegistry.registerMouseDownBinding(new MouseEventMatcher(SWT.NONE, GridRegion.BODY, MouseEventMatcher.RIGHT_BUTTON), new PapyrusBodyPopupMenuAction(MenuConstants.BODY_POPUP_MENU_ID, this.natTable));
	}

	/**
	 * register the menu configuration for the row header of the table
	 * 
	 * @param uiBindingRegistry
	 * 
	 */
	protected void registerRowHeaderPopupMenu(final UiBindingRegistry uiBindingRegistry) {
		uiBindingRegistry.registerMouseDownBinding(new MouseEventMatcher(SWT.NONE, GridRegion.ROW_HEADER, MouseEventMatcher.RIGHT_BUTTON), new PapyrusHeaderPopupMenuAction(MenuConstants.ROW_HEADER_POPUP_MENU_ID, this.natTable));
	}

	/**
	 * register the menu configuration for the column header of the table
	 * 
	 * @param uiBindingRegistry
	 * 
	 */
	protected void registerColumnHeaderPopupMenu(final UiBindingRegistry uiBindingRegistry) {
		uiBindingRegistry.registerMouseDownBinding(new MouseEventMatcher(SWT.NONE, GridRegion.COLUMN_HEADER, MouseEventMatcher.RIGHT_BUTTON), new PapyrusHeaderPopupMenuAction(MenuConstants.COLUMN_HEADER_POPUP_MENU_ID, this.natTable));
	}
}
