/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.uml2.uml.TypedElement;

/**
 * Utility class for <code>org.eclipse.uml2.uml.TypedElement</code><BR>
 */
public class TypedElementUtil {

	public static String getTypeAsString(TypedElement element) {
		return (element.getType() != null) ? UMLLabelInternationalization.getInstance().getLabel(element.getType()) : "<Undefined>";
	}
}
