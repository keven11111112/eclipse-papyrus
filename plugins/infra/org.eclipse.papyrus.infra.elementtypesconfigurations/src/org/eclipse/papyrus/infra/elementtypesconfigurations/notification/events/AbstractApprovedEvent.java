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

public abstract class AbstractApprovedEvent extends AbstractElementTypesConfigurationsEvent {

	public AbstractApprovedEvent(IEditCommandRequest req, IEditHelper editHelper) {
		super(req, editHelper);
	}

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IElementTypesConfigurationsEvent#getEventType()
	 *
	 * @return
	 */
	@Override
	public ElementTypesConfigurationsEventType getEventType() {
		return ElementTypesConfigurationsEventType.Approved;
	}
}
