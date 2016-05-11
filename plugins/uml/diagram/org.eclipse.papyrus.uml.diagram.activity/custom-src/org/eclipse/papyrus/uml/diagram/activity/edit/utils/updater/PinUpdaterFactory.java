/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jérémie TATIBOUET (CEA LIST) - Initial API and implementation
 *   Sébastien REVOL (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater;

import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.SendSignalAction;

public class PinUpdaterFactory {

	/**
	 * Singleton reference
	 */
	private static PinUpdaterFactory INSTANCE;

	/**
	 * Constructor.
	 */
	private PinUpdaterFactory() {
	}

	/**
	 * Provide access to the singleton instance
	 * 
	 * @return INSTANCE
	 *         the singleton
	 */
	public static PinUpdaterFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PinUpdaterFactory();
		}
		return INSTANCE;
	}

	/**
	 * Provide a pin updater for the given activity node. This update encapsulates
	 * logic to derive activity node pins.
	 * 
	 * @param node
	 *            the activity node
	 * @return updater
	 *         the pin updater for the given activity node
	 */
	@SuppressWarnings("unchecked")
	public <T extends ActivityNode> IPinUpdater<T> instantiate(ActivityNode node) {
		IPinUpdater<T> updater = null;
		if (node instanceof CallBehaviorAction) {
			updater = (IPinUpdater<T>) new CallBehaviorActionPinUpdater();
		} else if (node instanceof CallOperationAction) {
			updater = (IPinUpdater<T>) new CallOperationActionPinUpdater();
		} else if (node instanceof SendSignalAction) {
			updater = (IPinUpdater<T>) new SendSignalActionPinUpdater();
		}
		return updater;
	}
}
