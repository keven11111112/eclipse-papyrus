/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.editor.welcome.internal.dnd;

import org.eclipse.papyrus.infra.ui.dnd.PapyrusTransfer;
import org.eclipse.ui.forms.widgets.Section;

/**
 * A transfer type for sections dragged around in the welcome page (to rearrange them).
 */
public class WelcomeSectionTransfer extends PapyrusTransfer<Section> {
	private static final WelcomeSectionTransfer INSTANCE = new WelcomeSectionTransfer();

	private WelcomeSectionTransfer() {
		super(Section.class);
	}

	public static WelcomeSectionTransfer getInstance() {
		return INSTANCE;
	}
}
