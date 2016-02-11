/*****************************************************************************
 * Copyright (c) 2015, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.navigation.menu.button;

import org.eclipse.papyrus.infra.gmfdiag.navigation.Activator;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationMenuButton;

public class MoreButton extends NavigationMenuButton {
	public MoreButton() {
		super("More...", Activator.getDefault().getIcon(Activator.IMG_SEPARATOR), "More...");
	}
} // end MoreButton