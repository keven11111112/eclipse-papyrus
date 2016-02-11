/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.services.resourceloading.impl;

import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.resourceloading.IStrategyChooser;

/**
 * Factory for the model-set's {@link IStrategyChooser}.
 */
public class StrategyChooserFactory implements IServiceFactory {

	public StrategyChooserFactory() {
		super();
	}

	@Override
	public Object createServiceInstance() throws ServiceException {
		return ProxyManager.getStrategyChooser();
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {

	}

	@Override
	public void startService() throws ServiceException {
		// Pass
	}

	@Override
	public void disposeService() throws ServiceException {
		// Pass
	}

}
