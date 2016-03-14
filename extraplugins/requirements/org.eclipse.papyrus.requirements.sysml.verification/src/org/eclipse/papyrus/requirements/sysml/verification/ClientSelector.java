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
package org.eclipse.papyrus.requirements.sysml.verification;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;

public class ClientSelector implements IClientSelector {

	public boolean selects(Object object) {
		return (object instanceof Element);
	}
}
