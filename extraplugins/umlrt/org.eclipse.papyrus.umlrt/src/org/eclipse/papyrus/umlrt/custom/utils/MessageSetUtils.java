/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.umlrt.custom.utils;

import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageKind;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageSet;
import org.eclipse.papyrus.umlrt.UMLRealTime.UMLRealTimePackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Utility class on {@link RTMessageSet}
 */
public class MessageSetUtils {

	/**
	 * Retrieves the direction for a given element
	 * 
	 * @param object
	 *            the object for which direction is looked after
	 * @return the di
	 */
	public static RTMessageKind getMessageKind(Object object) {
		if (object instanceof RTMessageSet) {
			return ((RTMessageSet) object).getRtMsgKind();
		}

		if (object instanceof Element) {
			Stereotype stereotype = ((Element) object).getAppliedStereotype("UMLRealTime::" + UMLRealTimePackage.eINSTANCE.getRTMessageSet().getName());
			if (stereotype != null) {
				Object value = ((Element) object).getValue(stereotype, UMLRealTimePackage.eINSTANCE.getRTMessageSet_RtMsgKind().getName());
				if (value instanceof RTMessageKind) {
					return ((RTMessageKind) value);
				}
			}
		}

		return null;
	}

}
