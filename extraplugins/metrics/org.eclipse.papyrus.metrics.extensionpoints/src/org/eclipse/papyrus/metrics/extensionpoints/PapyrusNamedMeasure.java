/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.metrics.extensionpoints;

import org.omg.smm.NamedMeasure;
import org.omg.smm.Operation;
import org.omg.smm.Scope;

public abstract class PapyrusNamedMeasure implements NamedMeasure {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.SmmElement#getName()
	 */
	@Override
	public String getName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.DimensionalMeasure#getFormula()
	 */
	@Override
	public String getFormula() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.Measure#getScope()
	 */
	@Override
	public Scope getScope() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.Measure#getDefaultQuery()
	 */
	@Override
	public Operation getDefaultQuery() {
		return null;
	}

}
