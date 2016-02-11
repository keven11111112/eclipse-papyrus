/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *  Christian W. Damus = bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui;

import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.services.spi.IContextualServiceRegistryTracker;
import org.eclipse.papyrus.infra.tools.spi.IExecutorServiceFactory;
import org.eclipse.papyrus.infra.ui.util.UIUtil;
import org.eclipse.papyrus.infra.ui.util.WorkbenchPartHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The plug-in's logger
	 */
	public static LogHelper log;

	private ServiceRegistration<IExecutorServiceFactory> executorFactoryReg;
	private ServiceRegistration<IContextualServiceRegistryTracker> serviceRegistryTrackerReg;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);

		IExecutorServiceFactory executorFactory = () -> UIUtil.createUIExecutor(Display.getDefault());
		executorFactoryReg = context.registerService(IExecutorServiceFactory.class, executorFactory, null);

		IContextualServiceRegistryTracker serviceRegistryTracker = () -> {
			ServicesRegistry result = null;
			IEditorPart editor = WorkbenchPartHelper.getCurrentActiveEditorPart();
			if (editor != null) {
				result = editor.getAdapter(ServicesRegistry.class);
			}
			return result;
		};
		serviceRegistryTrackerReg = context.registerService(IContextualServiceRegistryTracker.class, serviceRegistryTracker, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (serviceRegistryTrackerReg != null) {
			serviceRegistryTrackerReg.unregister();
			serviceRegistryTrackerReg = null;
		}
		if (executorFactoryReg != null) {
			executorFactoryReg.unregister();
			executorFactoryReg = null;
		}

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
