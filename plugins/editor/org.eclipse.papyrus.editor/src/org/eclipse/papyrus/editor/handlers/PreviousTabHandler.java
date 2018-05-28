/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Shuai Li (CEA LIST) <shuai.li@cea.fr> - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.editor.handlers;

/**
 * The handler for the previous tab command that lets the user navigate to
 * the previous page of the active tab-folder with Ctrl+Shift+Tab
 * 
 * @author Shuai Li
 */
public class PreviousTabHandler extends TraverseTabHandler {
	public PreviousTabHandler() {
		super(true);
	}
}
