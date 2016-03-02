package org.eclipse.papyrus.req.reqif.util;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rmf.reqif10.Identifiable;
import org.eclipse.uml2.uml.Element;

public class RequirementUtil {

	protected static final String REQIF_IDENTIFIER = "REQIF_Identifier";

	public static void addID(Identifiable identifiable, Element element) {
		EAnnotation eAnnotation = element.createEAnnotation(REQIF_IDENTIFIER);
		eAnnotation.getDetails().put(REQIF_IDENTIFIER, identifiable.getIdentifier());
	}

	public static String getID(EObject eObject) {
		if(eObject instanceof EModelElement) {
			EModelElement eModelElement = (EModelElement)eObject;
			if(eModelElement.getEAnnotation(REQIF_IDENTIFIER) != null) {
				return eModelElement.getEAnnotation(REQIF_IDENTIFIER).getDetails().get(REQIF_IDENTIFIER);
			}
		}
		return null;
	}
}
