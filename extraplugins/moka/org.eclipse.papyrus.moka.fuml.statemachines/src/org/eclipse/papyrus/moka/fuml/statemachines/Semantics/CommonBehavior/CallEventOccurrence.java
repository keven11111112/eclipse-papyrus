/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;

public class CallEventOccurrence extends EventOccurrence {

	// Execution associated to the event occurrence
	public CallEventExecution execution;
	
	public List<ParameterValue> getInputParameterValues(){
		List<ParameterValue> parameterValues = null;
		if(this.execution != null){
			parameterValues = this.execution.getInputParameterValues();
		}
		return parameterValues;
	}
}
