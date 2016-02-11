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

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public abstract class AbstractElementTypesConfigurationsEvent implements IElementTypesConfigurationsEvent {

	/**
	 * Timestamp of the creation of this event
	 */
	private long timestamp;

	/**
	 * The {@link IEditCommandRequest} that triggered this {@link IElementTypesConfigurationsEvent}
	 */
	private IEditCommandRequest request;

	private IEditHelper editHelper;

	public AbstractElementTypesConfigurationsEvent(IEditCommandRequest req, IEditHelper editHelper) {
		this();
		this.request = req;
		this.editHelper = editHelper;
	}

	/**
	 * @return the {@link IEditCommandRequest} that triggered the event
	 */
	public IEditCommandRequest getRequest() {
		return request;
	}

	/**
	 * @return the {@link IEditHelper} that triggered the event
	 */
	public IEditHelper getEditHelper() {
		return editHelper;
	}

	AbstractElementTypesConfigurationsEvent() {
		timestamp = System.currentTimeMillis();
	}

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IElementTypesConfigurationsEvent#getTimestamp()
	 *
	 * @return
	 */
	@Override
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IElementTypesConfigurationsEvent#getEventName()
	 *
	 * @return
	 */
	@Override
	public String getEventName() {
		return this.getClass().getSimpleName();
	}
}
