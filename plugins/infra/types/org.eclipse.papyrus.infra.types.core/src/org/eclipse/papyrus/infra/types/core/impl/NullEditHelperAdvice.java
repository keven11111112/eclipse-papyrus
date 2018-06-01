/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.types.core.impl;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;

public class NullEditHelperAdvice extends AbstractEditHelperAdvice {

	private static NullEditHelperAdvice instance = null;

	private NullEditHelperAdvice() {
		super();
	}

	public static final synchronized NullEditHelperAdvice getInstance() {
		if(instance == null) {
			instance = new NullEditHelperAdvice();
		}
		return instance;
	}
}
