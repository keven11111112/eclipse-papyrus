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
package org.eclipse.papyrus.infra.types.core.notification;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.infra.types.core.notification.events.ITypesEvent;

/**
 * Singleton used to register eventsChains listeners ({@link ITypesEventsChainListener})
 */
public class TypesListenersRegistry {

	private static Set<ITypesEventsChainListener> eventChainListeners = null;

	private static Set<ITypesEventsListener> eventListeners = null;

	private static TypesListenersRegistry instance = null;

	private TypesListenersRegistry() {
	}

	public static synchronized TypesListenersRegistry getInstance() {
		if (instance == null) {
			instance = new TypesListenersRegistry();
			init();
		}
		return instance;
	}

	public static void init() {
		eventChainListeners = new HashSet<ITypesEventsChainListener>();
		eventListeners = new HashSet<ITypesEventsListener>();
	}

	public void addEventChainListener(ITypesEventsChainListener listener) {
		eventChainListeners.add(listener);
	}

	public void removeEventChainListener(ITypesEventsChainListener listener) {
		eventChainListeners.remove(listener);
	}

	public void addEventListener(ITypesEventsListener listener) {
		eventListeners.add(listener);
	}

	public void removeEventChainListener(ITypesEventsListener listener) {
		eventListeners.remove(listener);
	}

	public void notifyChain(TypesEventsChain chain) {
		for (ITypesEventsChainListener eventsChainListener : eventChainListeners) {
			eventsChainListener.notifyChain(chain);
		}
	}

	public void notifyEvent(ITypesEvent event) {
		for (ITypesEventsListener eventsListener : eventListeners) {
			eventsListener.notifyEvent(event);
		}
	}
}
