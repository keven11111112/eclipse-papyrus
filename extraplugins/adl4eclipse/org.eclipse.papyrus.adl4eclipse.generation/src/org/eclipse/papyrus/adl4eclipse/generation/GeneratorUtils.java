/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.generation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.adltool.reversible.project.StereotypeVersion;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class GeneratorUtils {

	public static String getElementName(Object stereotypedElement) {
		Element element = getElement(stereotypedElement);

		if (element instanceof NamedElement) {
			return ((NamedElement) element).getName();
		}

		return null;
	}

	public static Element getElement(Object stereotypeApplication) {
		if (stereotypeApplication instanceof EObject) {
			return UMLUtil.getBaseElement((EObject) stereotypeApplication);
		}

		return null;
	}

	public static StereotypeVersion getDepdendencyVersion(Object stereotypedDependency, String stereotypeName) {
		Element element = getElement(stereotypedDependency);

		if (element != null) {
			Stereotype stereotype = element.getAppliedStereotype(stereotypeName);

			if (stereotype != null) {
				String floor = (String) element.getValue(stereotype, OSGIStereotypes.VERSIONRANGE_FLOOR_ATT);

				if (floor != null) {
					String ceiling = (String) element.getValue(stereotype, OSGIStereotypes.VERSIONRANGE_CEILING_ATT);
					boolean includeFloor = (boolean) element.getValue(stereotype, OSGIStereotypes.VERSIONRANGE_INCLUDEFLOOR_ATT);
					boolean includeCeiling = (boolean) element.getValue(stereotype, OSGIStereotypes.VERSIONRANGE_INCLUDECEILING_ATT);

					return new StereotypeVersion(floor, ceiling, includeFloor, includeCeiling);
				}
			}
		}

		return null;
	}

}
