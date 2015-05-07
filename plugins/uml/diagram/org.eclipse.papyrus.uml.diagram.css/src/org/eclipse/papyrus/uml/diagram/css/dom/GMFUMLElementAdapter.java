/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.css.dom;



import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.dom.GMFElementAdapter;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayConstant;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.papyrus.uml.diagram.css.helper.CSSDOMUMLSemanticElementHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * DOM Element Adapter for UML Elements
 *
 * Supports applied stereotypes and stereotype properties
 *
 * @author Camille Letavernier
 *
 */
public class GMFUMLElementAdapter extends GMFElementAdapter {


	/**
	 * Name of the CSS Simple Selector to match on the Stereotype Compartment Shape
	 */
	private static final String STEREOTYPE_COMMENT = "StereotypeComment"; //$NON-NLS-1$


	// Helpers
	public final StereotypeDisplayUtil stereotypeHelper = StereotypeDisplayUtil.getInstance();


	public static final String APPLIED_STEREOTYPES_PROPERTY = "appliedStereotypes"; //$NON-NLS-1$



	/**
	 * The CSS Separator for qualifiers, when we must use CSS ID
	 * When we can use CSS String, we use the standard UML "::" qualifier separator
	 *
	 * NOTE: Separator "__" does not work
	 */
	public static final String QUALIFIER_SEPARATOR = "--"; //$NON-NLS-1$

	public GMFUMLElementAdapter(View view, ExtendedCSSEngine engine) {
		super(view, engine);
		helper = CSSDOMUMLSemanticElementHelper.getInstance();
	}

	/**
	 * {@inheritDoc}
	 *
	 * Applied Stereotypes are manipulated as DOM Attributes
	 */
	@Override
	protected String doGetAttribute(String attr) {

		String parentValue = super.doGetAttribute(attr);

		if (parentValue != null) {
			return parentValue;
		}


		// get stereotype Label attribute
		if (stereotypeHelper.isStereotypeLabel(semanticElement)) {
			String value = getStereotypeLabelAttribute(attr);
			if (value != null && !value.isEmpty()) {
				return value;
			}
		}

		// get stereotype Compartment attribute
		if (stereotypeHelper.isStereotypeCompartment(semanticElement) || stereotypeHelper.isStereotypeBrace(semanticElement)) {
			String value = getStereotypeCompartmentAttribute(attr);
			if (value != null && !value.isEmpty()) {
				return value;
			}
		}


		// get stereotype Property attribute
		if (stereotypeHelper.isStereotypeProperty(semanticElement) || stereotypeHelper.isStereotypeBraceProperty(semanticElement)) {

			String value = getStereotypePropertyAttribute(attr);
			if (value != null && !value.isEmpty()) {
				return value;
			}
		}

		if (semanticElement instanceof Element) {

			// Applied stereotypes
			Element currentElement = (Element) semanticElement;

			// Get applied STereotypes Attributes
			if (APPLIED_STEREOTYPES_PROPERTY.equals(attr)) {
				List<String> appliedStereotypes = new LinkedList<String>();
				for (Stereotype stereotype : currentElement.getAppliedStereotypes()) {
					appliedStereotypes.add(stereotype.getName());
					appliedStereotypes.add(stereotype.getQualifiedName());
				}
				if (!appliedStereotypes.isEmpty()) {
					return ListHelper.deepToString(appliedStereotypes, CSS_VALUES_SEPARATOR);
				}
			}
			for (EObject stereotypeApplication : currentElement.getStereotypeApplications()) {
				EStructuralFeature feature = stereotypeApplication.eClass().getEStructuralFeature(attr);
				if (feature != null) {
					if (feature.isMany()) {
						List<?> values = (List<?>) stereotypeApplication.eGet(feature);
						List<String> cssValues = new LinkedList<String>();
						for (Object value : values) {
							cssValues.add(getCSSValue(feature, value));
						}
						return ListHelper.deepToString(cssValues, CSS_VALUES_SEPARATOR);
					} else {
						Object value = stereotypeApplication.eGet(feature);
						String cssValue = getCSSValue(feature, value);
						return cssValue;
					}
				}
			}

			if (attr.contains(QUALIFIER_SEPARATOR)) {
				List<String> qualifiers = ListHelper.asList(attr.split(QUALIFIER_SEPARATOR)); // Writable list
				String propertyName = qualifiers.remove(qualifiers.size() - 1); // Last element is the property name
				// Remaining strings can be used to build the Stereotype's qualified name
				String stereotypeName = ListHelper.deepToString(qualifiers, "::"); //$NON-NLS-1$
				Stereotype appliedStereotype = currentElement.getAppliedStereotype(stereotypeName);
				if (appliedStereotype != null) {
					EObject stereotypeApplication = currentElement.getStereotypeApplication(appliedStereotype);
					EStructuralFeature feature = stereotypeApplication.eClass().getEStructuralFeature(propertyName);
					if (feature != null) {
						Object value = stereotypeApplication.eGet(feature);
						return getCSSValue(feature, value);
					}
				}
			}
		}
		return null;
	}


	/**
	 * Retrieve the Matching String Value for the StereotypeCompartment Element
	 * 
	 * @param attr
	 *            Attribute of the String to match with
	 * @return The matching value for this Attribute
	 */
	protected String getStereotypeCompartmentAttribute(String attr) {
		if (StereotypeDisplayConstant.STEREOTYPE_COMPARTMENT_NAME.equals(attr)) {

			BasicCompartment propertyCompartment = (BasicCompartment) semanticElement;
			return stereotypeHelper.getName(propertyCompartment);

		}
		return "";
	}

	/**
	 * Retrieve the Matching String Value for the StereotypeCompartment Element
	 * 
	 * @param attr
	 *            Attribute of the String to match with
	 * @return The matching value for this Attribute
	 */
	protected String getStereotypePropertyAttribute(String attr) {
		// CSS can match property level
		if (StereotypeDisplayConstant.STEREOTYPE_PROPERTY_NAME.equals(attr)) {

			DecorationNode propertyLabel = (DecorationNode) semanticElement;
			if (propertyLabel.getElement() instanceof Property) {
				Property prop = (Property) propertyLabel.getElement();
				String propLabel = prop.getName();
				return propLabel;
			}
			// CSS can match Container Name
		} else if (StereotypeDisplayConstant.STEREOTYPE_COMPARTMENT_NAME.equals(attr)) {

			EObject propertyCompartment = ((DecorationNode) semanticElement).eContainer();
			if (stereotypeHelper.isStereotypeCompartment(propertyCompartment)) {

				return stereotypeHelper.getName((DecorationNode) propertyCompartment);
			}

		}
		return "";

	}

	/**
	 * Get the matching Value of the Attribute
	 * 
	 * @param attr
	 *            Attribute of the String to match with
	 * @return The matching value for this Attribute
	 */
	protected String getStereotypeLabelAttribute(String attr) {

		if (StereotypeDisplayConstant.STEREOTYPE_LABEL_NAME.equals(attr)) {
			DecorationNode label = (DecorationNode) semanticElement;

			String stereoName = stereotypeHelper.getName(label);
			return stereoName;

		}

		if (KIND.equals(attr)) {
			if (stereotypeHelper.isStereotypeLabel(semanticElement)) {
				return StereotypeDisplayConstant.STEREOTYPE_LABEL_TYPE;
			}

		}
		return null;
	}



	@Override
	protected String getCSSValue(EStructuralFeature feature, Object value) {
		if (feature instanceof EReference && value instanceof NamedElement) {
			return ((NamedElement) value).getName();
		}
		return super.getCSSValue(feature, value);
	}


	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.dom.GMFElementAdapter#getLocalName()
	 *
	 * @return The Local name for the CSS matching.
	 */
	@Override
	public String getLocalName() {
		if (localName == null) {
			// In case of StereotypeComment type, the selector should match on the Stereotype Comment.
			if (stereotypeHelper.isStereotypeComment(getNotationElement())) {
				return STEREOTYPE_COMMENT;
			}
		}
		return super.getLocalName();
	}
}
