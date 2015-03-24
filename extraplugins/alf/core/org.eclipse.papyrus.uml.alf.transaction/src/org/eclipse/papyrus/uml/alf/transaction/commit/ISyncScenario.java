/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commit;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.uml2.uml.Element;

public interface ISyncScenario {
	/**
	 * The core method of a scenario
	 * 
	 * @param target
	 *            - the element for which the scenario is executed
	 * @return command - a command (that may be compound) to be executed in order to perform the synchronization
	 */
	public Command synchronize(Element target, List<Notification> changes);
}
