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

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.swt.widgets.Shell;

public interface NavigationMenu {
	public void handleRequest(Object request, Object target);
	public boolean willEnter(Object request, Object target);
	public void exitItem();
	public Object navigate(Object request, Object host);
	public List<Object> getAppendObjects();
	public List<Object> getPrependObjects();
	public void setServicesRegistry(ServicesRegistry registry);
	public void setParentShell(Shell parentShell);
	public void altReleased();
}
