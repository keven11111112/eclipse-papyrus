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
package org.eclipse.papyrus.metrics.extensionpoints.interfaces;

import java.util.ArrayList;

import org.eclipse.papyrus.metrics.extensionpoints.helpers.Result;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Declares the contract for all the results viewers
 *
 */
public interface IResultsViewer {
	/**
	 * @param measurand
	 *            the element that was the scope of the observation
	 * @return a appropriate representation of the element' name
	 */
	public default String getMeasurandName(Element measurand) {
		return (String) ((measurand instanceof NamedElement) ? ((NamedElement) measurand).getQualifiedName()
				: measurand);
	};

	/**
	 * Present the results to the users
	 * @param measuresResults a list of instances of {@link Result} 
	 */
	public abstract void show(ArrayList<Result> measuresResults);
}
