/*****************************************************************************
 * Copyright (c) 2017 CEA
 *
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
package org.eclipse.papyrus.uml.service.types.utils;

/**
 * Constants used in the sequence diagram
 * @since 3.0
 */
public interface SequenceRequestConstant {

	/** A constant representing the container of an interactionFragment. It can be an Interaction or an InteractionOperand */
	public static final String INTERACTIONFRAGMENT_CONTAINER = "InteractionFragment Container"; //$NON-NLS-1$

	/** The occurrence specification(s) which are the nearest from a creation request */
	public static final String NEAREST_OCCURRENCE_SPECIFICATION = "Nearest occurrence specification"; //$NON-NLS-1$

	/** Add in the request that a element cover another element */
	public static final String COVERED = "Element Covers this one"; //$NON-NLS-1$

	/** when you create a message, sometimes you create after another event **/
	public static final String PREVIOUS_EVENT = "previous event"; //$NON-NLS-1$
	/** when you create a message, sometimes you create after another event for the target **/
	public static final String SECOND_PREVIOUS_EVENT = "second previous event"; //$NON-NLS-1$

	public static final String MESSAGE_SENTEVENT_REPLACE_EXECUTIONEVENT = "MESSAGE_SENTEVENT_REPLACE_EXECUTIONEVENT";
	public static final String MESSAGE_RECEIVEEVENT_REPLACE_EXECUTIONEVENT  = "MESSAGE_RECEIVEEVENT_REPLACE_EXECUTIONEVENT";
	
	/** the start of Execution specification can be replace by an event of a message */
	public static final String REPLACE_EXECUTION_SPECIFICATION_START = "REPLACE_EXECUTION_SPECIFICATION_START"; //$NON-NLS-1$
	/** the finish of Execution specification can be replace by an event of a message */
	public static final String REPLACE_EXECUTION_SPECIFICATION_FINISH = "REPLACE_EXECUTION_SPECIFICATION_FINISH"; //$NON-NLS-1$
 
}
