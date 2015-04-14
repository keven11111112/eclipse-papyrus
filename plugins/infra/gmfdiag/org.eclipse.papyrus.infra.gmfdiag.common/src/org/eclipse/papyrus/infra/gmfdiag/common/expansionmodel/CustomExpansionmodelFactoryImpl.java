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

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionmodelFactoryImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GMFT_Based_RepresentationImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.InducedRepresentationImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationKindImpl;

/**
 *  this class is overloaded in order to add the implementation of the method validate
 * See Requirement #Req org.eclipse.papyrus.infra.gmfdiag.expansion.Req_061
 *
 */
public class CustomExpansionmodelFactoryImpl extends ExpansionmodelFactoryImpl {

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionmodelFactoryImpl#createInducedRepresentation()
	 *
	 * @return
	 */
	@Override
	public InducedRepresentation createInducedRepresentation() {
		InducedRepresentationImpl inducedRepresentation = new CustomInducedRepresentationImpl();
		return inducedRepresentation;
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionmodelFactoryImpl#createRepresentation()
	 *
	 * @return
	 */
	@Override
	public Representation createRepresentation() {
			RepresentationImpl representation = new CustomRepresentationImpl();
			return representation;
	}
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionmodelFactoryImpl#createGMFT_Based_Representation()
	 *
	 * @return
	 */
	@Override
	public GMFT_Based_Representation createGMFT_Based_Representation() {
		GMFT_Based_RepresentationImpl gmfT_Based_Representation = new CustomGMFT_Based_RepresentationImpl();
		return gmfT_Based_Representation;
	}
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionmodelFactoryImpl#createRepresentationKind()
	 *
	 * @return
	 */
	@Override
	public RepresentationKind createRepresentationKind() {
		RepresentationKindImpl representationKind = new CustomRepresentationKindImpl();
		return representationKind;
	}
}
