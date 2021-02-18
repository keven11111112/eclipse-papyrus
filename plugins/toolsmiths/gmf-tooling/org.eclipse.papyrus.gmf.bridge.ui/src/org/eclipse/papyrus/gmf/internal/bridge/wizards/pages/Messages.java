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
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages;

import org.eclipse.osgi.util.NLS;

/**
 * @author artem
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.gmf.internal.bridge.wizards.pages.messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String wizardTitle;
	public static String newPageTitle;
	public static String newPageDesc;

	public static String inputPageTitle;
	public static String inputPageDesc;
	public static String inputNeedDomain;
	public static String inputNeedCanvas;
	public static String inputNeedToolDef;

	public static String ecoreSelector;
	public static String graphdefSelector;
	public static String tooldefSelector;

	public static String uriSelectorBrowse;
	public static String uriSelectorLoad;
	public static String uriSelectorWorkspace;
	public static String uriSelectorFilesystem;
	public static String useECore;
	public static String useBasic;
	public static String createBlank;

	public static String rootPageTitle;
	public static String rootPageDesc;
	public static String rootPageGroupTitle;
	public static String rootPageHint;

	public static String mapPageTitle;
	public static String mapPageDesc;
	public static String nodeLabel;
	public static String linkLabel;
	public static String unspecifiedValue;
	public static String mapChange;
	public static String mapAsNode;
	public static String mapAsLink;
	public static String mapRemove;
	public static String mapRestore;
	public static String mapRestoreNode;
	public static String mapRestoreLink;
	public static String mapRestoreText;
	public static String mapNodesList;
	public static String mapLinksList;
	public static String groupStructure;
	public static String groupEdit;
	public static String groupVisual;
	public static String groupConstraints;
	public static String labelSpecialization;
	public static String labelInitializer;
	public static String labelDiagramElement;
	public static String labelElement;
	public static String labelContainment;
	public static String labelTargetFeature;
}
