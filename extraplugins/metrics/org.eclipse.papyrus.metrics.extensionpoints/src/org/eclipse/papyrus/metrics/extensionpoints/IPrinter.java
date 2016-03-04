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

import java.util.ArrayList;

import org.eclipse.papyrus.metrics.extensionpoints.helpers.Result;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public interface IPrinter {
	public default String getMeasurandName(Element measurand){
		return (String) ((measurand instanceof NamedElement) ? ((NamedElement) measurand).getQualifiedName() : measurand);
	};
	public abstract void print(ArrayList<Result> measuresResults);

}
