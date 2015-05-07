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

package org.eclipse.papyrus.umlrt.internal.sync.capsule;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.umlrt.custom.utils.CapsuleUtils;
import org.eclipse.papyrus.umlrt.internal.sync.UMLSyncRegistry;

/**
 * Capsule behavior inheritance synchronization registry.
 */
public class CapsuleSyncRegistry extends UMLSyncRegistry<org.eclipse.uml2.uml.Class> {

	public CapsuleSyncRegistry() {
		super();
	}

	@Override
	public org.eclipse.uml2.uml.Class getModelOf(EObject backend) {
		return getSuperCapsule(backend);
	}

	public static org.eclipse.uml2.uml.Class getSuperCapsule(EObject capsule) {
		org.eclipse.uml2.uml.Class result = null;

		if (capsule instanceof org.eclipse.uml2.uml.Class) {
			result = CapsuleUtils.getSuperCapsule((org.eclipse.uml2.uml.Class) capsule);
		}

		return result;
	}
}
