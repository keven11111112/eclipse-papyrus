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

package org.eclipse.papyrus.infra.editor.welcome;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * The Papyrus Editor's <em>Welcome Page</em> management service.
 */
public interface IWelcomePageService extends IService {

	/**
	 * Obtains the service registry that owns me.
	 * 
	 * @return my registry
	 */
	ServicesRegistry getOwner();

	/**
	 * Queries whether the welcome page can be closed at this instant.
	 * 
	 * @return whether the welcome page may be closed by the user
	 */
	boolean canCloseWelcomePage();

	/**
	 * Ensures that the welcome page is open. If it is not open, then it is
	 * opened and activated. Otherwise, if it is not active, it is activated.
	 */
	void openWelcomePage();

	/**
	 * Resets the layout of the Welcome Page to the defaults, undoing any
	 * custom re-organization that the user may have done.
	 */
	void resetWelcomePage();

	Resource getWelcomeResource();

	Welcome getWelcome();
}
