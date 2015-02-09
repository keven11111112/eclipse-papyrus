/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.uml2.uml.Element;


/**
 * Matcher for UML elements that should be stereotyped
 */
public class StereotypeApplicationMatcher implements IElementMatcher {

	private List<String> stereotypesQualifiedNames;

	public StereotypeApplicationMatcher(StereotypeApplicationMatcherConfiguration configuration) {
		this.stereotypesQualifiedNames = configuration.getStereotypesQualifiedNames();
	}


	public boolean matches(EObject eObject) {
		if (!(eObject instanceof Element)) {
			return false;
		}

		if (((Element) eObject).getAppliedStereotypes().isEmpty())
		{
			return false;
		}

		for (String stereotypeQualifiedName : stereotypesQualifiedNames) {
			if (((Element) eObject).getAppliedStereotype(stereotypeQualifiedName) == null) {
				return false;
			}
		}
		return true;

	}

	public List<String> getStereotypesQualifiedNames() {
		return stereotypesQualifiedNames;
	}


	public void setStereotypesQualifiedNames(List<String> stereotypeQualifiedName) {
		this.stereotypesQualifiedNames = stereotypeQualifiedName;
	}

}
