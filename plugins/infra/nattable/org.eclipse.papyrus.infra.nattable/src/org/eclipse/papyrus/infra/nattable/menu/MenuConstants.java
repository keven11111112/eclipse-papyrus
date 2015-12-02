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

/**
 * @author VL222926
 *         This class grousp the constant used for table menu
 */
public class MenuConstants {

	/**
	 * Constructor.
	 *
	 */
	private MenuConstants() {
		// to prevent instanciation
	}

	/**
	 * the string popup used to declare the menu location
	 */
	public static final String POPUP = "popup"; //$NON-NLS-1$

	/**
	 * the table body popup menu id
	 */
	public static final String TABLE_POPUP_MENU_ID = "org.eclipse.papyrus.infra.nattable.widget.menu"; //$NON-NLS-1$

	/**
	 * the table row header menu id
	 */
	public static final String ROW_HEADER_POPUP_MENU_ID = "org.eclipse.papyrus.infra.nattable.widget.header.rows.menu"; //$NON-NLS-1$

	/**
	 * the table column header menu id
	 */
	public static final String COLUMN_HEADER_POPUP_MENU_ID = "org.eclipse.papyrus.infra.nattable.header.columns.menu"; //$NON-NLS-1$

	/**
	 * the separator between menu location and menu id
	 */
	public static final String DELIMITER = ":"; //$NON-NLS-1$

	/**
	 * this separator is used to group contribution for tree table
	 */
	public static final String TREE_SEPARATOR_ID = "tree.separator"; //$NON-NLS-1$

	/**
	 * this separator is used to group general contribution
	 */
	public static final String GENERAL_SEPARATOR_ID = "general.separator"; //$NON-NLS-1$

	/**
	 * this separator is used to group edit contribution
	 */
	public static final String EDIT_SEPARATOR_ID = "edit.separator";
}
