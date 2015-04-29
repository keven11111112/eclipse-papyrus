package org.eclipse.papyrus.umlrt.ui.queries;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.Collaboration;

public class DisplayMessagesOnlyQuery implements IJavaQuery2<Collaboration, Boolean> {

	public Boolean evaluate(final Collaboration context,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
					throws DerivedTypedElementException {

		// display only in / out and inout features. They should not be collapsed also
		ParameterValue parameterValue = parameterValues.getParameterValueByName("eStructuralFeature");
		if (parameterValue == null) {
			return false;
		}
		EStructuralFeature eStructuralFeature = (EStructuralFeature) parameterValue.getValue();
		// the eStructure is a containmentReference or Facet Reference?
		if (eStructuralFeature instanceof FacetReference) {
			// check this is in / out or inout
			String name = ((FacetReference)eStructuralFeature).getName();
			if("in".equals(name) || "out".equals(name) || "inout".equals(name) ) {
				return true;
			}
		}
		return false;
	}
}
