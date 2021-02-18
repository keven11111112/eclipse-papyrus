/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.gmf.mappings;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Choice Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Label based on a feature (reference or attribute) from domain model and list of choices
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping#getItemsExpression <em>Items Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping#getShowExpression <em>Show Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getOclChoiceLabelMapping()
 * @model
 * @generated
 */
public interface OclChoiceLabelMapping extends LabelMapping {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getOclChoiceLabelMapping_Feature()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='feature.eContainingClass.isSuperTypeOf(mapEntry.domainMetaElement)' description='Label reference must be available in \'Domain Element\' EClass of the labeled mapping entry'"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='feature.oclIsKindOf(ecore::EReference) implies (not(feature.oclAsType(ecore::EReference).containment) and (feature.oclAsType(ecore::EReference).upperBound = 1))' description='Reference feature should not be containment and don\'t be multiple'"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='feature.oclIsKindOf(ecore::EAttribute) implies (itemsExpression <> null)' description='Items expression should be set if feature is an EAttribute'"
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Items Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items Expression</em>' containment reference.
	 * @see #setItemsExpression(ValueExpression)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getOclChoiceLabelMapping_ItemsExpression()
	 * @model containment="true"
	 * @generated
	 */
	ValueExpression getItemsExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping#getItemsExpression <em>Items Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Items Expression</em>' containment reference.
	 * @see #getItemsExpression()
	 * @generated
	 */
	void setItemsExpression(ValueExpression value);

	/**
	 * Returns the value of the '<em><b>Show Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Expression</em>' containment reference.
	 * @see #setShowExpression(ValueExpression)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getOclChoiceLabelMapping_ShowExpression()
	 * @model containment="true"
	 * @generated
	 */
	ValueExpression getShowExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping#getShowExpression <em>Show Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Expression</em>' containment reference.
	 * @see #getShowExpression()
	 * @generated
	 */
	void setShowExpression(ValueExpression value);

} // OclChoiceLabelMapping
