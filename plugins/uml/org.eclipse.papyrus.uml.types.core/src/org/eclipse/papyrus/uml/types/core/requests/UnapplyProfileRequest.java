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

package org.eclipse.papyrus.uml.types.core.requests;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

public class UnapplyProfileRequest extends AbstractProfileRequest {

	public UnapplyProfileRequest(Package umlPackage, Profile profile, TransactionalEditingDomain editingDomain) {
		super(editingDomain, umlPackage, profile);
	}

}
