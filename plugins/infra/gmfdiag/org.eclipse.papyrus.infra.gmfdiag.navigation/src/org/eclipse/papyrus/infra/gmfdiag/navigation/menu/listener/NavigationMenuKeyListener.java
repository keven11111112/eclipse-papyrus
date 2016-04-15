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

package org.eclipse.papyrus.infra.gmfdiag.navigation.menu.listener;

import org.eclipse.papyrus.infra.gmfdiag.navigation.menu.DefaultNavigationMenu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

public class NavigationMenuKeyListener implements KeyListener {
	/**
	 *
	 */
	protected DefaultNavigationMenu navigationMenu;

	/**
	 * Constructor.
	 *
	 * @param navigationMenu
	 */
	public NavigationMenuKeyListener(DefaultNavigationMenu navigationMenu) {
		this.navigationMenu = navigationMenu;
	}

	public void keyPressed(KeyEvent e) {
		// Nothing
		// TODO get the hovered over EObject
	}

	public void keyReleased(KeyEvent e) {
		if (e.keyCode == SWT.ALT) {
			navigationMenu.altReleased();
			navigationMenu.exitItem();
		}
	}
} // end NavigationMenuKeyListener