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

package org.eclipse.papyrus.moka.composites.Semantics.CommonBehaviors.BasicBehaviors;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions.CS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_InteractionPoint;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.CallEventExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;

public class CS_CallEventExecution extends CallEventExecution{

	// The port manifestation at which the operation call arrived.
	public CS_InteractionPoint interactionPoint;

	@Override
	public EventOccurrence createEventOccurrence() {
		// Wrap the created event occurrence within a CS_EventOccurrence which
		// references the behavior port on which the call was dispatched.
		CS_EventOccurrence wrappingEventOccurrence = new CS_EventOccurrence();
		wrappingEventOccurrence.interactionPoint = this.interactionPoint;
		wrappingEventOccurrence.wrappedEventOccurrence = super.createEventOccurrence();
		return wrappingEventOccurrence;
	}
	
	public Value new_() {
		// Create a new call event execution.
		return new CS_CallEventExecution();
	}
	
	public Value copy() {
		// Create a new call event execution that is a copy of this execution, no
		// referenced interaction point.
		CS_CallEventExecution copy = (CS_CallEventExecution) super.copy();
		copy.interactionPoint = null;
		return copy;
	}
	
}
