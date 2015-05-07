/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.umlrt.internal.sync.statemachine;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.umlrt.custom.utils.CapsuleUtils;
import org.eclipse.papyrus.umlrt.internal.sync.UMLSyncRegistry;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Capsule statemachine inheritance synchronization registry.
 */
public class StateMachineSyncRegistry extends UMLSyncRegistry<StateMachine> {

	public StateMachineSyncRegistry() {
		super();
	}

	@Override
	public StateMachine getModelOf(EObject backend) {
		return getSuperStateMachine(backend);
	}

	public static StateMachine getSuperStateMachine(EObject stateMachine) {
		StateMachine result = null;

		if (stateMachine instanceof StateMachine) {
			result = CapsuleUtils.getSuperBehavior((StateMachine) stateMachine);
		}

		return result;
	}
}
