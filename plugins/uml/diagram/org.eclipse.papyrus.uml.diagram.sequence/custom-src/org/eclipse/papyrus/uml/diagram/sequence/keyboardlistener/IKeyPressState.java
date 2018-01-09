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

/**
 * This interface is used to set the status of a key pressed see also {@link KeyboardListener}
 *
 */
public interface IKeyPressState {

	/**
	 * 
	 * @param isPressed
	 *            true if the key has bee pressed
	 */
	public void setKeyPressState(Boolean isPressed);

}
