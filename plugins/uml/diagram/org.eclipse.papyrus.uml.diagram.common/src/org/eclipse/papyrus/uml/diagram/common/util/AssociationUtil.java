package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.uml2.uml.Property;

public class AssociationUtil {

	public static boolean isAssociationEndProperty(Property property) {
		return property.getAssociation() != null;
	}
}
