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

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public class AdviceRequestEvent extends AbstractRequestEvent implements IAdviceEvent {

	private IEditHelperAdvice advice;

	private IEditHelperAdvice[] advices;

	public AdviceRequestEvent(IEditCommandRequest req, IEditHelper editHelper, IEditHelperAdvice advice, IEditHelperAdvice[] advices) {
		super(req, editHelper);
		this.advice = advice;
		this.advices = advices;
	}

	/**
	 * @see org.eclipse.papyrus.infra.types.notification.events.IAdviceEvent#getAdvice()
	 *
	 * @return
	 */
	@Override
	public IEditHelperAdvice getAdvice() {
		return advice;
	}

	/**
	 * @see org.eclipse.papyrus.infra.types.notification.events.IAdviceEvent#getAdvices()
	 *
	 * @return
	 */
	@Override
	public IEditHelperAdvice[] getAdvices() {
		return advices;
	}
}
