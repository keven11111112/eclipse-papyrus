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
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.viewpoints.policy.listener;

import org.eclipse.papyrus.infra.viewpoints.policy.Activator;

/**
 * @since 1.2
 */
public interface IPolicyCheckerListenerExtensionPoint {


	/** ID of the extension point */
	public final static String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".policycheckerlistener";

	public static final String LISTENER_CLASS = "listenerClass";
}
