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

package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import org.eclipse.gef.EditPolicy;

/**
 * A mix-in interface for Papyrus implementations of the canonical edit policy that support conditional activation.
 */
public interface IPapyrusCanonicalEditPolicy {

	/**
	 * Queries whether I am currently active.
	 * 
	 * @return whether I am active
	 * 
	 * @see EditPolicy#activate()
	 */
	boolean isActive();

	/**
	 * Refreshes my activation state, checking perhaps whether I need to be activated or deactivated according to
	 * my activation condition.
	 * 
	 * @see #isActive()
	 * @see EditPolicy#activate()
	 * @see EditPolicy#deactivate()
	 */
	void refreshActive();
}
