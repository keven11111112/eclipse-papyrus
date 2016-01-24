/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 425270
 *
 /*****************************************************************************/
package org.eclipse.papyrus.effbd.queries;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.effbd.I_EFFBStereotype;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.tools.providers.DelegatingItemLabelProvider;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueAction;

/** get the name + the list of applied stereotypes */
public class GetComplexName implements IJavaQuery2<NamedElement, String> {


	private static final IItemLabelProvider labelProvider = new DelegatingItemLabelProvider();

	@Override
	public String evaluate(NamedElement source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		ParameterValue parameterValue = parameterValues.getParameterValueByName("eObject"); //$NON-NLS-1$
		if (parameterValue.getValue() instanceof EStructuralFeature) {
			return ((EStructuralFeature) parameterValue.getValue()).getName();
		}
		if (source instanceof OpaqueAction && ((OpaqueAction) source).getBodies().size() > 0) {
			return "" + source.getName() + ":" + ((OpaqueAction) source).getBodies().get(0);
		}

		if (source instanceof ControlFlow && source.getName() == null) {
			if (((ControlFlow) source).getSource() != null && ((ControlFlow) source).getTarget() != null) {
				return "" + ((ControlFlow) source).getSource().getName() + " to " + ((ControlFlow) source).getTarget().getName();
			}
		}

		if (source instanceof DecisionNode) {
			if (source.getAppliedStereotype(I_EFFBStereotype.ORBEGIN_STEREOTYPE) != null) {
				return " OR (begin):" + (source).getName();
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.ITEND_STEREOTYPE) != null) {
				return " IT (End):" + (source).getName();
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.LPEND_STEREOTYPE) != null) {
				return " LP (END):" + (source).getName();
			}
		}
		if (source instanceof MergeNode) {
			if (source.getAppliedStereotype(I_EFFBStereotype.OREND_STEREOTYPE) != null) {
				return " OR (end):" + (source).getName();
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.ITBEGIN_STEREOTYPE) != null) {
				return " IT (begin):" + (source).getName();
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.LPBEGIN_STEREOTYPE) != null) {
				return " LP (begin):" + (source).getName();
			}
		}
		if (source instanceof ForkNode) {
			return " AND (begin):" + (source).getName();
		}
		if (source instanceof JoinNode) {
			return " AND (end):" + (source).getName();
		}
		// Delegate to UML2 Edit providers to get localized and inferred names where applicable
		return labelProvider.getText(source);
	}
}
