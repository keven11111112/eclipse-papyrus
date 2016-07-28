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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;

public abstract class PseudostateActivation extends VertexActivation {
	
	public boolean canPropagateExecution(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		boolean propagate = super.canPropagateExecution(enteringTransition, eventOccurrence, leastCommonAncestor);
		if(propagate){
			if(!this.outgoingTransitionActivations.isEmpty()){
				propagate = false;	
			}
			int i = 0;
			while(!propagate && i < this.outgoingTransitionActivations.size()){
				propagate = this.outgoingTransitionActivations.get(i).canPropagateExecution(eventOccurrence);
				i++;
			}
		}
		return propagate;
	}
	
}
