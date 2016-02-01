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
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public class IdentityAdviceEvent extends AbstractIdentityEvent implements IAdviceEvent {

	private IEditHelperAdvice advice;

	private IEditHelperAdvice[] advices;

	private AdvicePhase advicePhase;

	public IdentityAdviceEvent(IEditCommandRequest req, IEditHelper editHelper, IEditHelperAdvice advice, IEditHelperAdvice[] advices, AdvicePhase advicePhase) {
		super(req, editHelper);
		this.advice = advice;
		this.advices = advices;
		this.advicePhase = advicePhase;
	}

	/**
	 * @return the advice
	 */
	@Override
	public IEditHelperAdvice getAdvice() {
		return advice;
	}

	/**
	 * @return the advices
	 */
	@Override
	public IEditHelperAdvice[] getAdvices() {
		return advices;
	}

	/**
	 * @return the advicePhase
	 */
	public AdvicePhase getAdvicePhase() {
		return advicePhase;
	}
}
