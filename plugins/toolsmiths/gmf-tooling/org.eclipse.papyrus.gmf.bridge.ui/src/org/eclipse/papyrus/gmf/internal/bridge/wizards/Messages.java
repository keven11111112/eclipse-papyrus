/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards;

import org.eclipse.osgi.util.NLS;

/**
 * @author dstadnik
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.gmf.internal.bridge.wizards.messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String SimpleModelWizardDomainModelSelectionPageTitle;

	public static String SimpleModelWizardDomainModelSelectionPageDesc;

	public static String SimpleModelWizardGraphModelSelectionPageTitle;

	public static String SimpleModelWizardGraphModelSelectionPageDesc;

	public static String SimpleModelWizardGraphDefinitionPageTitle;

	public static String SimpleModelWizardGraphDefinitionPageDesc;

	public static String SimpleModelWizardToolDefinitionPageDesc;

	public static String SimpleModelWizardToolDefinitionPageTitle;

	public static String SimpleModelWizardToolModelSelectionPageDesc;

	public static String SimpleModelWizardToolModelSelectionPageTitle;

	public static String WizardUtilUnableToOpenEditor;
}
