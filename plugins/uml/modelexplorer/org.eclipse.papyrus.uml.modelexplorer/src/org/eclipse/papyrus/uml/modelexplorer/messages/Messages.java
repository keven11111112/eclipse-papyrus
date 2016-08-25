/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.uml.modelexplorer.messages;

import org.eclipse.osgi.util.NLS;

/**
 * The Message Class.
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.modelexplorer.messages.messages"; //$NON-NLS-1$
	public static String CustomizeUMLLabelDialog_ComboCustomizationLabel;
	public static String CustomizeUMLLabelDialog_createButtonTooltip;
	public static String CustomizeUMLLabelDialog_deleteButtonTooltip;
	public static String CustomizeUMLLabelDialog_dialogLabel;
	public static String CustomizeUMLLabelDialog_downButtonTooltip;
	public static String CustomizeUMLLabelDialog_stylesColumnTitle;
	public static String CustomizeUMLLabelDialog_Title;
	public static String CustomizeUMLLabelDialog_typesColumnTitle;
	public static String CustomizeUMLLabelDialog_upButtonTooltip;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
