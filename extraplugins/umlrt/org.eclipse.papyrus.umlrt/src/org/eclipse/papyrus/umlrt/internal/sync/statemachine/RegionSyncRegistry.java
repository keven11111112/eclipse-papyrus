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
import org.eclipse.uml2.uml.Region;

/**
 * Capsule statemachine region synchronization registry.
 */
public class RegionSyncRegistry extends UMLSyncRegistry<Region> {

	public RegionSyncRegistry() {
		super();
	}

	@Override
	public Region getModelOf(EObject backend) {
		return getRedefinedRegion(backend);
	}

	public static Region getRedefinedRegion(EObject region) {
		return (region instanceof Region) ? CapsuleUtils.getSuperRegion((Region) region) : null;
	}
}
