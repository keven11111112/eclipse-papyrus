/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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
package org.eclipse.papyrus.infra.elementtypesconfigurations.notification;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IElementTypesConfigurationsEvent;

/**
 * Singleton used to register eventsChains listeners ({@link IElementTypesConfigurationsEventsChainListener})
 */
public class ElementTypesConfigurationsListenersRegistry {

	private static Set<IElementTypesConfigurationsEventsChainListener> eventChainListeners = null;

	private static Set<IElementTypesConfigurationsEventsListener> eventListeners = null;

	private static ElementTypesConfigurationsListenersRegistry instance = null;

	private ElementTypesConfigurationsListenersRegistry() {
	}

	public static synchronized ElementTypesConfigurationsListenersRegistry getInstance() {
		if (instance == null) {
			instance = new ElementTypesConfigurationsListenersRegistry();
			init();
		}
		return instance;
	}

	public static void init() {
		eventChainListeners = new HashSet<IElementTypesConfigurationsEventsChainListener>();
		eventListeners = new HashSet<IElementTypesConfigurationsEventsListener>();
	}

	public void addEventChainListener(IElementTypesConfigurationsEventsChainListener listener) {
		eventChainListeners.add(listener);
	}

	public void removeEventChainListener(IElementTypesConfigurationsEventsChainListener listener) {
		eventChainListeners.remove(listener);
	}

	public void addEventListener(IElementTypesConfigurationsEventsListener listener) {
		eventListeners.add(listener);
	}

	public void removeEventChainListener(IElementTypesConfigurationsEventsListener listener) {
		eventListeners.remove(listener);
	}

	public void notifyChain(ElementTypesConfigurationsEventsChain chain) {
		for (IElementTypesConfigurationsEventsChainListener eventsChainListener : eventChainListeners) {
			eventsChainListener.notifyChain(chain);
		}
	}

	public void notifyEvent(IElementTypesConfigurationsEvent event) {
		for (IElementTypesConfigurationsEventsListener eventsListener : eventListeners) {
			eventsListener.notifyEvent(event);
		}
	}
}
