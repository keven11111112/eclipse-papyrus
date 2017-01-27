/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.migration.rhapsody.xmi;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * @author VL222926
 *         This class allows to generate XMI_ID to use for UML element
 */
public class UML_XMI_ID_Helper {

	private static final String PROPERTY_OF_ASSOCIATION__OTHER_END = "-other-end"; //$NON-NLS-1$

	private static final String ASSOCIATION = "-association"; //$NON-NLS-1$

	private static final String CONNECTOR_END = "end"; //$NON-NLS-1$

	public static final String VALUE_SPECIFICATION__LOWER_VALUE = "multiplicity-lower-value"; //$NON-NLS-1$

	public static final String VALUE_SPECIFICATION__UPPER_VALUE = "multiplicity-upper-value"; //$NON-NLS-1$
	
	public static final String MODEL_ELEMENT_OWNED_COMMENT = "modelElement-ownedComment"; //$NON-NLS-1$

	public static final String OF = "of"; //$NON-NLS-1$

	/**
	 * 
	 * @param element
	 *            an element
	 * @return
	 * 		the calculated XMI_ID for the given element, value can be <code>null</code>
	 */
	public static final String calculateIdForUML(EObject element) {
		String result = null;
		if (element instanceof Element) {
			// it is a UML Element
			result = calculateIdForUML((Element) element);
		} else if (element instanceof EObject) {
			// we check if it is a Stereotype Application
			Element baseElement = UMLUtil.getBaseElement(element);
			if (null != baseElement) {
				result = calculateIDForStereotypeApplication(element, baseElement);
			} else {
				result = EMF_XMI_ID_Helper.calculateIdForEMF(element);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param element
	 *            an element
	 * @return
	 * 		the ID calculated for this element
	 */
	private static final String calculateIdForUML(final Element element) {
		String returnedValue = null;
		if(element instanceof OpaqueExpression) {
			returnedValue = calculateId((OpaqueExpression) element);
		}else if(element instanceof InstanceValue) {
			returnedValue = calculateId((InstanceValue) element);
		}else if(element instanceof Comment) {
			returnedValue = calculateId((Comment) element);
		}else if (element instanceof Package) {
			returnedValue = calculateId((Package) element);
		} else if (element instanceof Property) {
			returnedValue = calculateId((Property) element);
		} else if (element instanceof Association) {
			returnedValue = calculateId((Association) element);
		} else if (element instanceof TemplateBinding) {
			returnedValue = calculateId((TemplateBinding) element);
		} else if (element instanceof TemplateParameterSubstitution) {
			returnedValue = calculateId((TemplateParameterSubstitution) element);
		} else if (element instanceof ConnectorEnd) {
			returnedValue = calculateId((ConnectorEnd) element);
		} else if (element instanceof ValueSpecification) {
			returnedValue = calculateId((ValueSpecification) element);
		} else if (element instanceof PackageImport) {
			returnedValue = calculateId((PackageImport) element);
		} else if (element instanceof ProfileApplication) {
			returnedValue = calculateId((ProfileApplication) element);
		} else {
			// Activator.log.warn(NLS.bind("The element of type {0} has no ID and is not yet managed", element.eClass())); //$NON-NLS-1$
		}
		return returnedValue;
	}

	/**
	 * 
	 * @param comment
	 *            a comment
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(Comment comment) {
		final Element owner = comment.getOwner();
		final String parentId = XMI_ID_Helper.getXMI_ID(owner);
		final StringBuilder builder = new StringBuilder(parentId);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(MODEL_ELEMENT_OWNED_COMMENT);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(getIndexToUseToBuildXMI_ID(owner.getOwnedComments(), comment));
		return builder.toString();
	}
	
	/**
	 * 
	 * @param pack
	 *            a package
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final Package pack) { // use for the package created by the transformation (like this one for user type declaration)
		final Element parent = pack.getOwner();
		final String parentID = XMI_ID_Helper.getXMI_ID(parent);
		final StringBuilder builder = new StringBuilder(parentID);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(pack.eClass().getName());
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(pack.getQualifiedName());
		return builder.toString();
	}

	/**
	 * 
	 * @param property
	 *            a property
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final Property property) {
		final Association association = property.getAssociation();
		final List<Property> ends = association.getMemberEnds();
		final StringBuilder builder = new StringBuilder();
		for (final Property current : ends) {
			if (current != property) {
				builder.append(XMI_ID_Helper.getXMI_ID(current));
				builder.append(PROPERTY_OF_ASSOCIATION__OTHER_END);
				if (ends.size() > 2) {
					builder.append(RpyUtil.ID_SEPARATOR);
					builder.append(getIndexToUseToBuildXMI_ID(ends, current));
				}
				break;
			}
		}

		return builder.toString();
	}

	/**
	 * 
	 * @param association
	 *            an association
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final Association association) {
		final List<Property> ends = association.getMemberEnds();
		final StringBuilder builder = new StringBuilder();
		for (final Property current : ends) {
			if (current.eContainer() != association) {
				builder.append(XMI_ID_Helper.getXMI_ID(current));
				builder.append(ASSOCIATION);
				if (ends.size() > 2) {
					builder.append(RpyUtil.ID_SEPARATOR);
					builder.append(getIndexToUseToBuildXMI_ID(ends, current));
				}
				break;
			}
		}
		return builder.toString();
	}

	/**
	 * 
	 * @param templateBinding
	 *            a templateBinding
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final TemplateBinding templateBinding) {
		final TemplateableElement parent = (TemplateableElement) templateBinding.getOwner();
		final String parentID = XMI_ID_Helper.getXMI_ID(parent);
		final StringBuilder builder = new StringBuilder(parentID);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(templateBinding.eClass().getName());
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(getIndexToUseToBuildXMI_ID(parent.getTemplateBindings(), templateBinding));
		return builder.toString();
	}

	/**
	 * 
	 * @param templateBindingSubsitution
	 *            a templateBindingSubsitution
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final TemplateParameterSubstitution templateBindingSubsitution) {
		final TemplateBinding parent = templateBindingSubsitution.getTemplateBinding();
		final String parentID = XMI_ID_Helper.getXMI_ID(parent);
		final StringBuilder builder = new StringBuilder(parentID);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(templateBindingSubsitution.eClass().getName());
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(getIndexToUseToBuildXMI_ID(parent.getParameterSubstitutions(), templateBindingSubsitution));
		return builder.toString();
	}

	/**
	 * 
	 * @param connectorEnd
	 *            a connectorEnd
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(ConnectorEnd connectorEnd) {
		final Connector owner = (Connector) connectorEnd.getOwner();
		final String parentId = XMI_ID_Helper.getXMI_ID(owner);
		final StringBuilder builder = new StringBuilder(parentId);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(CONNECTOR_END);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(getIndexToUseToBuildXMI_ID(owner.getEnds(), connectorEnd));
		return builder.toString();
	}

	/**
	 * 
	 * @param list
	 *            a list
	 * @param anEObject
	 *            an eobejct
	 * @return
	 * 		the index of the object to use to build the XMI_ID
	 */
	protected static final int getIndexToUseToBuildXMI_ID(final List<? extends EObject> list, final EObject anEObject) {
		return list.indexOf(anEObject) + 1; // +1 to match with an import previously existing at our initial partner and to ease model comparison
	}

	/**
	 * 
	 * @param valueSpec
	 *            a valueSpec
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final ValueSpecification valueSpec) {
		StringBuilder builder = new StringBuilder(XMI_ID_Helper.getXMI_ID(valueSpec.eContainer()));
		builder.append(RpyUtil.ID_SEPARATOR);
		if (valueSpec instanceof ValueSpecification && valueSpec.eContainingFeature() == UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue()) {
			builder.append(VALUE_SPECIFICATION__LOWER_VALUE);
		} else if (valueSpec instanceof ValueSpecification && valueSpec.eContainingFeature() == UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) {
			builder.append(VALUE_SPECIFICATION__UPPER_VALUE);
		} else {
			builder = new StringBuilder(); // no idea ?
		}
		return builder.toString();
	}

	/**
	 * 
	 * @param packageImport
	 *            a packageImport
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final PackageImport packageImport) {
		final EObject parent = packageImport.eContainer();
		final String parentID = XMI_ID_Helper.getXMI_ID(parent);
		final StringBuilder builder = new StringBuilder(parentID);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(packageImport.eClass().getName());
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(((PackageImport) packageImport).getImportedPackage().getQualifiedName());
		return builder.toString();
	}

	/**
	 * 
	 * @param profileApplication
	 *            a profileApplication
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final ProfileApplication profileApplication) {
		final EObject parent = profileApplication.eContainer();
		final String parentID = XMI_ID_Helper.getXMI_ID(parent);
		final StringBuilder builder = new StringBuilder(parentID);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(profileApplication.eClass().getName());
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(((ProfileApplication) profileApplication).getAppliedProfile().getQualifiedName());
		return builder.toString();
	}


	/**
	 * 
	 * @param eobject
	 *            an eobject representing a stereotype application
	 * @return
	 * 		the calculated XMI_ID for the given element
	 */
	private static final String calculateIDForStereotypeApplication(final EObject stereotypeApplication, final Element baseElement) {
		final StringBuilder builder = new StringBuilder();
		String baseElementId = XMI_ID_Helper.getXMI_ID(baseElement);
		String eClassName = stereotypeApplication.eClass().getName();
		builder.append(eClassName);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(OF);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(baseElementId);
		return builder.toString();
	}
	
	/**
	 * 
	 * @param eobject
	 *            an eobject representing a stereotype application
	 * @return
	 * 		the calculated XMI_ID for the given element
	 */
	private static final String calculateId(final OpaqueExpression opaqueExpression) {
		final EObject parent = opaqueExpression.eContainer();
		final String parentID = XMI_ID_Helper.getXMI_ID(parent);
		final StringBuilder builder = new StringBuilder(parentID);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(opaqueExpression.eClass().getName());
		return builder.toString();
	}
	
	/**
	 * 
	 * @param eobject
	 *            an eobject representing a stereotype application
	 * @return
	 * 		the calculated XMI_ID for the given element
	 */
	private static final String calculateId(final InstanceValue instanceValue) {
		final EObject parent = instanceValue.eContainer();
		final String parentID = XMI_ID_Helper.getXMI_ID(parent);
		final StringBuilder builder = new StringBuilder(parentID);
		builder.append(RpyUtil.ID_SEPARATOR);
		builder.append(instanceValue.eClass().getName());
		return builder.toString();
	}
}
