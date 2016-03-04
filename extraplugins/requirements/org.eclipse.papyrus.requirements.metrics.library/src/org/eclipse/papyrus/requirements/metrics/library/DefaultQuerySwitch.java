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

public class DefaultQuerySwitch {

	public static Object calculateValue(String operationName, Element element) {
		switch (operationName) {
		case "countRequirements": {
			return countRequirements(element);
		}
		}
		return null;
	}

	public static Integer countRequirements(Element element) {
		int numberOfRequirements = 0;
		for (Element e : element.getOwnedElements()) {
			if (e.getAppliedStereotype("SysML::Requirements::Requirement") != null)
				numberOfRequirements++;
		}
		return numberOfRequirements;
	}
}
