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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.viewpoints.policy.Activator;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;

/**
 * @since 1.2
 */
public class PolicyCheckerNotifier {

	private static PolicyCheckerNotifier notifier;

	private static List<IPolicyCheckerListener> listeners;


	public static synchronized PolicyCheckerNotifier getInstance() {
		if (notifier == null) {
			notifier = new PolicyCheckerNotifier();
			listeners = new ArrayList<IPolicyCheckerListener>();
			notifier.init();
		}
		return notifier;
	}

	public void clearListeners() {
		listeners.clear();
	}

	public void fire(PolicyChecker policyChecker) {
		for (IPolicyCheckerListener policyCheckerListener : listeners) {
			policyCheckerListener.policyCheckerChanged(policyChecker);
		}
	}

	void init() {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IPolicyCheckerListenerExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			try {
				Object listenerClass = configurationElement.createExecutableExtension(IPolicyCheckerListenerExtensionPoint.LISTENER_CLASS);
				if (listenerClass instanceof IPolicyCheckerListener) {
					listeners.add((IPolicyCheckerListener) listenerClass);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
	}
}
