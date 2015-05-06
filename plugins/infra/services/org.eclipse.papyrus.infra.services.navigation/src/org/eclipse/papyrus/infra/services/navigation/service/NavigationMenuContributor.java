/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Shuai Li (CEA LIST) <shuai.li@cea.fr> - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.navigation.service;

import java.util.List;

/**
 * Classes that implement this interface returns a list of related objects to the given object in the parameter
 *
 */
public interface NavigationMenuContributor {
	public List<NavigationMenuButton> getButtons(Object fromElement);
}
