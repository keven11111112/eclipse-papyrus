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

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;

public interface IAdviceEvent extends IElementTypesConfigurationsEvent {

	/**
	 * @return the advice
	 */
	public IEditHelperAdvice getAdvice();

	/**
	 * @return the advices
	 */
	public IEditHelperAdvice[] getAdvices();
}
