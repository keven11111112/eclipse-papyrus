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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ReturnInformation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ReplyAction;
import org.eclipse.uml2.uml.Trigger;

public class ReplyActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Reply to the call represented by the return information on
		// the return information pin using the reply values given
		// on the reply value pins.
		ReplyAction action = (ReplyAction) this.node;
		Trigger replyToCall = action.getReplyToCall();
		List<InputPin> replyValuePins = action.getReplyValues();
		InputPin returnInformationPin = action.getReturnInformation();
		List<Value> values = this.takeTokens(returnInformationPin);
		ReturnInformation returnInformation = (ReturnInformation) values.get(0);
		if (replyToCall.getEvent() instanceof CallEvent & 
				((CallEvent)replyToCall.getEvent()).getOperation() == returnInformation.getOperation()) {
			List<ParameterValue> parameterValues = new ArrayList<ParameterValue>();
			int i = 1;
			while (i <= replyValuePins.size()) {
				ParameterValue parameterValue = new ParameterValue();
				parameterValue.values = this.takeTokens(replyValuePins.get(i - 1));
				parameterValues.add(parameterValue);
				i = i + 1;
			}
			returnInformation.reply(parameterValues);
		}
	}

}
