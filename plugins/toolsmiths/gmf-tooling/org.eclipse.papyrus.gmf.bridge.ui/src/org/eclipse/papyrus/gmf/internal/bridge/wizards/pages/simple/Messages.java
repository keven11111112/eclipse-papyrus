/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages.simple;

import org.eclipse.osgi.util.NLS;

/**
 * @author dstadnik
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.gmf.internal.bridge.wizards.pages.simple.messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String DefinitionPageDefaults;

	public static String DefinitionPageDeselectAll;

	public static String DefinitionPageElement;

	public static String DefinitionPageElementsToProcess;

	public static String DiagramElementSelectorElement;

	public static String DiagramElementSelectorExContainedNodes;

	public static String DiagramElementSelectorExLinks;

	public static String DiagramElementSelectorNoName;

	public static String GraphDefBuilder0;

	public static String GraphDefBuilder1;

	public static String GraphDefBuilder5;

	public static String GraphDefBuilder6;

	public static String ToolDefBuilder0;

	public static String ToolDefBuilder1;
}
