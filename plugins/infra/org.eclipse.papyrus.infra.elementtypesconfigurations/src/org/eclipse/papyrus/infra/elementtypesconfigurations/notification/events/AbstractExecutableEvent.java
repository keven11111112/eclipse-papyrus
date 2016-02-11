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
package org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public abstract class AbstractExecutableEvent extends AbstractElementTypesConfigurationsEvent {

	private ICommand command;


	public AbstractExecutableEvent(IEditCommandRequest req, IEditHelper editHelper, ICommand command) {
		super(req, editHelper);
		this.command = command;
	}

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IElementTypesConfigurationsEvent#getEventType()
	 *
	 * @return
	 */
	@Override
	public ElementTypesConfigurationsEventType getEventType() {
		return ElementTypesConfigurationsEventType.Executable;
	}

	/**
	 * @return the command
	 */
	public ICommand getCommand() {
		return command;
	}
}
