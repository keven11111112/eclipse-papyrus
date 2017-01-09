/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Jeremie Tatibouet (CEA) - Apply Fix fUML12-35 Initial execution of an activity is not run to completion
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;

/**
 * A signal event occurrence represents the occurrence of a signal event due to the receipt
 * of a specific signal instance.
 */
public class SignalEventOccurrence extends EventOccurrence {

	/*
	 * The signal instance whose receipt caused this signal event occurrence.
	 */
	public SignalInstance signalInstance;

	@Override
	public boolean match(Trigger trigger) {
		// Match a trigger if it references a signal event whose signal is the type of the 
		// signal instance or one of its super types
		boolean matches = false;
		if(trigger.getEvent() instanceof SignalEvent){
			SignalEvent event = (SignalEvent) trigger.getEvent();
			matches = this.signalInstance.isInstanceOf(event.getSignal());
		}
		return matches;
	}


	@Override
	public List<ParameterValue> getParameterValues() {
		// Return parameter values for feature of the signal instance, in order.
		// These are intended to be treated as if they are the values of effective
		// parameters of direction "in".
		List<ParameterValue> parameterValues = new ArrayList<ParameterValue>();
		List<FeatureValue> memberValues = this.signalInstance.getMemberValues();
		for(int i = 0; i < memberValues.size(); i++){
			FeatureValue feature = memberValues.get(i);
			ParameterValue parameterValue = new ParameterValue();
			parameterValue.values = feature.values;
			parameterValues.add(parameterValue);
		}
		return parameterValues;
	}
}
