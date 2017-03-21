/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.messages.messages"; //$NON-NLS-1$

	public static String CustomPaletteconfigurationEditor_NewTool;

	public static String CustomPaletteconfigurationEditor_Create_Drawer_Tooltip;
	public static String CustomPaletteconfigurationEditor_RemoveButtonTooltip;
	public static String CustomPaletteconfigurationEditor_Create_Separator_Tooltip;
	public static String CustomPaletteconfigurationEditor_Create_Stack_Tooltip;
	public static String CustomPaletteconfigurationEditor_Create_Tool_Tooltip;
	public static String CustomPaletteCreationPage_Palette_Identifier_Tooltip;
	public static String ReferenceDialog_EditValue;

	public static String PaletteToolActionsPropertyEditor_AddAction;
	public static String PaletteToolActionsPropertyEditor_AppliedActions;
	public static String PaletteToolActionsPropertyEditor_DownAction;
	public static String PaletteToolActionsPropertyEditor_invalidAdvice;
	public static String PaletteToolActionsPropertyEditor_RemoveAction;
	public static String PaletteToolActionsPropertyEditor_UpAction;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
