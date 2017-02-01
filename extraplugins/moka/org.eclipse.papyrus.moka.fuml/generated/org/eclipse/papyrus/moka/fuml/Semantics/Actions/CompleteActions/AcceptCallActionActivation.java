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

package org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ReturnInformation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.CallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.OutputPin;

public class AcceptCallActionActivation extends AcceptEventActionActivation {
	
	@Override
	public void accept(EventOccurrence eventOccurrence) {
		// Accept the given event occurrence, which must be a call event occurrence.
		// Place return information for the call on the return information
		// output pin. Then complete the acceptance of the event occurrence
		// as usual.
		AcceptCallAction action = (AcceptCallAction) this.node;
		OutputPin returnInformationPin = action.getReturnInformation();
		ReturnInformation returnInformation = new ReturnInformation();
		returnInformation.callEventOccurrence = (CallEventOccurrence) eventOccurrence;
		this.putToken(returnInformationPin, returnInformation);
		super.accept(eventOccurrence);
	}

}
