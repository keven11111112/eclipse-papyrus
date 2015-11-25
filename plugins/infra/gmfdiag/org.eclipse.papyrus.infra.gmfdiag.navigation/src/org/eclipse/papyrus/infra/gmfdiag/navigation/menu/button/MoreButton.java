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

package org.eclipse.papyrus.infra.gmfdiag.navigation.menu.button;

import org.eclipse.papyrus.infra.services.navigation.service.NavigationMenuButton;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class MoreButton extends NavigationMenuButton {
	public MoreButton() {
		super("More...", AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.uml.diagram.common", "/icons/separator.gif").createImage(), "More...");
	}
} // end MoreButton