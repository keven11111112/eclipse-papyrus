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
package org.eclipse.papyrus.infra.types.core.notification.events;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public abstract class AbstractUnexecutableEvent extends AbstractTypesEvent {

	public AbstractUnexecutableEvent(IEditCommandRequest req, IEditHelper editHelper, ICommand command) {
		super(req, editHelper);
		this.command = command;
	}

	/**
	 * @return the command
	 */
	public ICommand getCommand() {
		return command;
	}

	private ICommand command;




	/**
	 * 
	 * @see org.eclipse.papyrus.infra.types.core.notification.events.ITypesEvent#getEventType()
	 *
	 * @return
	 */
	@Override
	public TypesEventKind getEventType() {
		return TypesEventKind.Unexecutable;
	}
}
