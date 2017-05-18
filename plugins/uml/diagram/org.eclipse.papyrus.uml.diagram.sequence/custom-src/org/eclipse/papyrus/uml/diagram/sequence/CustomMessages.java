/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence;

import org.eclipse.osgi.util.NLS;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessages extends NLS {

	static {
		NLS.initializeMessages("custom-messages", CustomMessages.class); //$NON-NLS-1$
	}

	private CustomMessages() {
	}

	public static String MoveMessageCommand_Label;

	public static String SelectOrCreateDialog_CreateLabel;

	public static String SelectOrCreateDialog_NameLabel;

	public static String SelectOrCreateDialog_OwnerLabel;

	public static String SelectOrCreateDialog_SelectLabel;

	public static String SelectOrCreateDialog_NothingLabel;

	public static String SelectOrCreateDialog_TypeLabel;

	public static String CommandHelper_CreateMessage;

	/**
	 * Error message for when an error occurs in FragmentOrderingKeeper evaluation.
	 */
	public static String FragmentOrderingKeeper_error;

	/**
	 * Error notification title when a link can not be dropped
	 *
	 */
	public static String DropError_DefaultTitle;

	/**
	 * Error notification message when a link can not be dropped
	 *
	 */
	public static String DropError_DefaultTxt;

	/**
	 * Error notification title when a message can not be dropped because it goes uphill
	 *
	 */
	public static String DropError_UphillMessageTitle;

	/**
	 * Error notification message when a message can not be dropped because it goes uphill
	 *
	 */
	public static String DropError_UphillMessageTxt;

	/**
	 * Warning notification title when the resize of an interaction operand may have an erratic behavior
	 *
	 */
	public static String Warning_ResizeInteractionOperandTitle;

	/**
	 * Warning notification message when the resize of an interaction operand may have an erratic behavior
	 *
	 */
	public static String Warning_ResizeInteractionOperandTxt;

	/**
	 * Preference messages
	 */
	public static String DiagramsPreferencePage_notificationGroup_label = "Automatic creations";

	public static String DiagramsPreferencePage_executionSpecificationWithSyncMsg_label = "When creating a synchronous message, also create:";

	public static String DiagramsPreferencePage_executionSpecificationWithAsyncMsg_label = "When creating an asynchronous message, also create:";

	public static String DiagramsPreferencePage_createBehaviorExecutionSpecification = "A Behavior Execution Specification";

	public static String DiagramsPreferencePage_createActionExecutionSpecification = "An Action Execution Specification";

	public static String DiagramsPreferencePage_createNoExecutionSpecification = "Nothing";

	/**
	 * the preferences
	 */
	public static String PREF_EXECUTION_SPECIFICATION_SYNC_MSG = "org.eclipse.papyrus.uml.diagram.sequence.executionSpecificationWithSyncMsg";

	public static String PREF_EXECUTION_SPECIFICATION_ASYNC_MSG = "org.eclipse.papyrus.uml.diagram.sequence.executionSpecificationWithAsyncMsg"; //$NON-NLS-1$

	/** trace massages */
	public static String SEQUENCE_DEBUG = "SequenceDebug"; // //$NON-NLS-0$

	public static String SEQUENCE_DEBUG_REFERENCEGRID = "SequenceDebugGrid"; // //$NON-NLS-0$

	public static String SEQUENCE_DEBUG_UTIL = "SequenceDebugUtil"; // //$NON-NLS-0$

}
