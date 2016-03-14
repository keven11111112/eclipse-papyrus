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

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

/**
 * Specifies a operation switch that is used to calculate measurement scopes.
 * See
 * {@link org.eclipse.papyrus.metrics.commands.helper.MetricsCalculatorHelper#calculateMeasurementScopes}
 *
 */
public interface IRecognizerSwitch {

	/**
	 * @param operationName
	 *            a string that identifies the query operation
	 * @param element
	 *            the input for the query operation
	 * @return true if the result of the query was positive or false otherwise
	 */
	public default boolean isRecognized(String operationName, Element element) {
		switch (operationName) {
		case "Package or Model": {
			return (element instanceof Package || element instanceof Model);
		}
		}
		return false;
	}

}
