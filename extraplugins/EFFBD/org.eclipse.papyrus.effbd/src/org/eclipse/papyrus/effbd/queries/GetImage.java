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

import org.eclipse.papyrus.effbd.I_EFFBStereotype;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.ImageUtils;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.custompt.URIImage;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/** get the name + the list of applied stereotypes */
public class GetImage implements IJavaQuery2<NamedElement, IImage> {

	private static final UMLLabelProvider UML_LABEL_PROVIDER = new UMLLabelProvider();

	@Override
	public IImage evaluate(NamedElement source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		if (source instanceof OpaqueAction) {
			return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/function16.png");
		}
		if (source instanceof ControlFlow) {
			return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/Flow16.png");
		}
		if (source instanceof DataStoreNode) {
			return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/Data16.png");
		}
		if (source instanceof DecisionNode) {
			if (source.getAppliedStereotype(I_EFFBStereotype.ORBEGIN_STEREOTYPE) != null) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/OR16.png");
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.ITEND_STEREOTYPE) != null) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/IT16.png");
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.LPEND_STEREOTYPE) != null) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/IT16.png");
			}
		}

		if (source instanceof MergeNode) {
			if (source.getAppliedStereotype(I_EFFBStereotype.OREND_STEREOTYPE) != null) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/OR16.png");
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.ITBEGIN_STEREOTYPE) != null) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/IT16.png");
			}
			if (source.getAppliedStereotype(I_EFFBStereotype.LPBEGIN_STEREOTYPE) != null) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/LP16.png");
			}
		}

		if (source instanceof ForkNode) {
			return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/AND16.png");
		}
		if (source instanceof JoinNode) {
			return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/AND16.png");
		}
		if (source instanceof ActivityParameterNode) {
			if ((((ActivityParameterNode) source).getParameter()).getDirection().equals(ParameterDirectionKind.IN_LITERAL)) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/Input16.png");
			}
			if ((((ActivityParameterNode) source).getParameter()).getDirection().equals(ParameterDirectionKind.OUT_LITERAL)) {
				return new URIImage("platform:/plugin/org.eclipse.papyrus.effbd/icons/Output16.png");
			}
		}
		// Delegate to UML2 Edit providers to get localized and inferred names where applicable
		return ImageUtils.wrap(UML_LABEL_PROVIDER.getImage(source));
	}




}
