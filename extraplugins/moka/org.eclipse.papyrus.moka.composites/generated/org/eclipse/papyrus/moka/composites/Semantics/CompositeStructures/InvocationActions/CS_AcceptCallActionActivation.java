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

package org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.AcceptCallActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;

public class CS_AcceptCallActionActivation extends AcceptCallActionActivation{
	
	@Override
	public void accept(EventOccurrence eventOccurrence) {
		// If the accepted event occurrence is a CS_EventOccurrence then the wrapped
		// event occurrence is extracted. The acceptance process is the one define
		// by AcceptCallActionActivation defined in fUML.
		if(eventOccurrence instanceof CS_EventOccurrence){
			super.accept(((CS_EventOccurrence) eventOccurrence).wrappedEventOccurrence);
		}else{
			super.accept(eventOccurrence);
		}
	}
}
