/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.model.extensionpoints;

import org.eclipse.papyrus.propertylifecycle.model.Activator;

/**
 * The needed informations to identify and declare an extension that will be registered as a StrategySet
 *
 */
public interface IStrategySetExtensionPoint {

	public final static String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".propertylifecyclestrategyset";

	public static final String PATH = "path";

	public static final String ID = "id";

}
