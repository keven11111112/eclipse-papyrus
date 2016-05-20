/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Activities;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions.CS_CallOperationActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.CallEventExecution;
import org.eclipse.uml2.uml.CallOperationAction;

public class SM_CallOperationActionActivation extends CS_CallOperationActionActivation {
	@Override
	public Execution getCallExecution() {
		// Asynchronous operation calls are not supported on active object
		Execution execution = super.getCallExecution();
		if(execution instanceof CallEventExecution){
			if(!((CallOperationAction)(this.node)).isSynchronous()){
				execution = null;
			}else{
				((CallEventExecution)execution).callerContext = this.getExecutionContext();
			}
		}
		return execution;
	}
}
