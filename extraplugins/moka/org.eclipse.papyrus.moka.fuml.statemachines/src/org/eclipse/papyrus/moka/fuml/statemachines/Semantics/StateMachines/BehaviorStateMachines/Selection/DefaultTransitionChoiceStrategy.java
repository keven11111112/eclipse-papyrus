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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;

public class DefaultTransitionChoiceStrategy extends TransitionChoiceStrategy {

	@Override
	public TransitionActivation choose(List<TransitionActivation> transitionActivations) {
		return !transitionActivations.isEmpty() ? transitionActivations.get(0) : null;
	}

}
