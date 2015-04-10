/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GMFT_Based_RepresentationImpl;

/**
 * this class is overloaded in order to add the implementation of the method validate
 * See Requirement #org.eclipse.papyrus.infra.gmfdiag.expansion.Req_061
 *
 */
public class CustomGMFT_Based_RepresentationImpl extends GMFT_Based_RepresentationImpl {

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.AbstractRepresentationImpl#validate(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 *
	 * @param diagnostic
	 * @param context
	 * @return
	 */
	@Override
	public boolean validate(DiagnosticChain diagnostic, Map context) {
		return ExpansionModelValidationUtil.validate_facrtories(this, diagnostic, context);
	}
}
