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

package org.eclipse.papyrus.uml.diagram.sequence.messages;

import org.eclipse.osgi.util.NLS;

/**
 * @since 3.0
 */
public class Messages {

	static {
		NLS.initializeMessages("org.eclipse.papyrus.uml.diagram.sequence.messages.messages", Messages.class); //$NON-NLS-1$
	}

	private Messages() {
	}

	/*************************************************************************
	 *   Preference messages    
	 ************************************************************************/
	
	/**
	 * label for the part of the preference page involved with automatic creations of elements when creating a message
	 */
	public static String DiagramsPreferencePage_notificationGroup_label;
	
	/**
	 * label to ask which behavior should be triggered when creating a synchronous message
	 */
	public static String DiagramsPreferencePage_executionSpecificationWithSyncMsg_label;
	
	/**
	 * label to ask which behavior should be triggered when creating an asynchronous message
	 */
	public static String DiagramsPreferencePage_executionSpecificationWithAsyncMsg_label;

	/**
	 * label specifying that a behavior execution specification and a message reply should be created
	 */
	public static String DiagramsPreferencePage_createBehaviorExecutionSpecificationAndReply;

	/**
	 * label specifying that a behavior execution specification should be created at message target
	 */
	public static String DiagramsPreferencePage_createBehaviorExecutionSpecification;

	/**
	 * label specifying that an action execution specification and a message reply should be created
	 */
	public static String DiagramsPreferencePage_createActionExecutionSpecificationAndReply;
	
	/**
	 * label specifying that an action execution specification should be created at message target
	 */
	public static String DiagramsPreferencePage_createActionExecutionSpecification;
	
	/**
	 * label specifying that only the message should be created
	 */
	public static String DiagramsPreferencePage_createNoExecutionSpecification;
	
	/*************************************************************************
	 *   Command labels    
	 ************************************************************************/
	
	public static String Commands_CreateExecutionSpecification_Label;
	
	public static String Commands_DropDestructionOccurenceSpecification_Label;
	
}

