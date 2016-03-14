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

/**
 * Specifies a query operation switch that is used to determine a value for a
 * measure during the measuring processes. See
 * {@link org.eclipse.papyrus.metrics.commands.helper.MetricsCalculatorHelper#performMeasurementProcess}
 *
 */
public interface IDefaultQuerySwitch {

	public Object calculateValue(String operationName, Element element);

}
