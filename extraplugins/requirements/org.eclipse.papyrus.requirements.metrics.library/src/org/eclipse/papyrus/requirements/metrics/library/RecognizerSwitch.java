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
package org.eclipse.papyrus.requirements.metrics.library;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

public class RecognizerSwitch {

	public static boolean isRecognized(String operationName, Element element) {
		switch (operationName) {
		case "Package or Model": {
			return (element instanceof Package || element instanceof Model);
		}
		}
		return false;
	}

}
