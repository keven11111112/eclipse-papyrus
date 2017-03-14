/*****************************************************************************
 * Copyright (c) 2013, 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 323802
 *   Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 513580
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.common.messages.messages"; //$NON-NLS-1$

	public static String RollbackNotificationHistoryListener_exception;

	public static String RollbackNotificationHistoryListener_exceptionWithCause;

	public static String RollbackNotificationHistoryListener_readOnly;

	public static String RollbackNotificationHistoryListener_readOnlyWithCause;

	public static String RollbackNotificationHistoryListener_title;

	public static String RollbackNotificationHistoryListener_unknown;

	public static String RollbackNotificationHistoryListener_unknownWithCause;

	public static String UnitsUtils_Centimeters;

	public static String UnitsUtils_Inches;

	public static String UnitsUtils_Pixels;

	public static String MultiPagesEditorActionBarContributor_PapyrusMenu;

	public static String AbstractPapyrusGmfCreateDiagramCommandHandler_CreateDiagramCommandLabel;

	public static String AbstractPapyrusGmfCreateDiagramCommandHandler_NewDiagramName;

	public static String AbstractPapyrusGmfCreateDiagramCommandHandler_NotSupportedEditor;

	public static String AbstractPapyrusGmfCreateDiagramCommandHandler_SelectNewDiagramName;

	public static String AbstractPapyrusGmfCreateDiagramCommandHandler_UnableCreateModelAndDiagram;

	public static String GmfEditorFactory_ErrorCreatingEditorPart;

	public static String GmfEditorFactory_ErrorRetrievingDiagram;

	public static String GmfMultiDiagramDocumentProvider_isModifiable;

	public static String GmfMultiDiagramDocumentProvider_handleElementContentChanged;

	public static String GmfMultiDiagramDocumentProvider_IncorrectInputError;

	public static String GmfMultiDiagramDocumentProvider_NoDiagramInResourceError;

	public static String GmfMultiDiagramDocumentProvider_DiagramLoadingError;

	public static String GmfMultiDiagramDocumentProvider_UnsynchronizedFileSaveError;

	public static String GmfMultiDiagramDocumentProvider_SaveDiagramTask;

	public static String GmfMultiDiagramDocumentProvider_SaveNextResourceTask;

	public static String GmfMultiDiagramDocumentProvider_SaveAsOperation;

	public static String ModelManagerEditor_SavingDeletedFile;

	public static String ModelManagerEditor_SaveAsErrorTitle;

	public static String ModelManagerEditor_SaveAsErrorMessage;

	public static String ModelManagerEditor_SaveErrorTitle;

	public static String ModelManagerEditor_SaveErrorMessage;

	public static String PastePreferencesPage_StrategiesDescription;

	public static String PastePreferencesPage_PageTitle;

	public static String PastePreferencesPage_PageDescription;

	public static String PastePreferencesPage_KeepReferenceDescription;

	// Palette UI //
	/** LAbel for the standard group */
	public static String StandardGroup_Label;

	/** label for the palette action in the palette viewer menu */
	public static String Palette_Action_Label;

	/** tooltip for the palette action in the palette viewer menu */
	public static String Palette_Action_Tooltip;

	public static String PaletteUtil_ErrorMessage_CantReadLocalDefinitionOfFile;

	public static String PaletteUtil_ErrorMessage_NoLocalDefinition;

	public static String PaletteUtil_ErrorMessage_NoRedefinitionFoundWithId;

	public static String PaletteUtil_ErrorMessage_PaletteNullOnContribution;

	public static String PapyrusPalettePreferences_Error_ImpossibleToFindPalette;

	public static String PapyrusPalettePreferences_Error_ImpossibleToFindPaletteInWS;

	public static String PapyrusPalettePreferences_Error_ImpossibleToReadPreferences;

	public static String PapyrusPalettePreferences_ErrorDuringCreation;

	public static String LocalExtendedPaletteProvider_Error_ImpossibleToLoadRessource;

	public static String WorkspaceExtendedPaletteProvider_ImpossibleToReadResourcePalette;

	public static String ResizeBindingPreferencePage_PageTitle;

	public static String ResizeBindingPreferencePage_PageDescription;

	public static String ResizeBindingPreferencePage_HoldingShiftToRecalculateAnchorPositionWhenResizing;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
