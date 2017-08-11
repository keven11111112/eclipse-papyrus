/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.keyboardlistener;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * This listener listen keyboard and affect the behavior of the grid
 *
 */
public class KeyboardListener implements Listener {

	protected IKeyPressState keyPressState;
	protected boolean state;
	protected int keyboard;

	/**
	 * Constructor.
	 *
	 */
	public KeyboardListener(IKeyPressState keyPressState, int keyboard, boolean state) {
		this.keyPressState = keyPressState;
		this.state = state;
		this.keyboard = keyboard;
	}

	@Override
	public void handleEvent(Event event) {
		if (event.keyCode == keyboard) {
			keyPressState.setKeyPressState(state);
		}
	}
}
