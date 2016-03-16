package org.eclipse.papyrus.uml.diagram.paletteconfiguration.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.paletteconfiguration.messages.messages"; //$NON-NLS-1$

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
