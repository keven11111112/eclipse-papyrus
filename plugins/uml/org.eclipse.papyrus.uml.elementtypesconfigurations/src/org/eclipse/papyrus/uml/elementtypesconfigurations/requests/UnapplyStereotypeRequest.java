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

package org.eclipse.papyrus.uml.elementtypesconfigurations.requests;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class UnapplyStereotypeRequest extends AbstractStereotypeRequest {

	/**
	 * Constructor.
	 *
	 * @param umlPackage
	 * @param profile
	 * @param editingDomain
	 */
	public UnapplyStereotypeRequest(Element umlElement, Stereotype stereotype, TransactionalEditingDomain editingDomain) {
		super(editingDomain, umlElement, stereotype);
	}


}
