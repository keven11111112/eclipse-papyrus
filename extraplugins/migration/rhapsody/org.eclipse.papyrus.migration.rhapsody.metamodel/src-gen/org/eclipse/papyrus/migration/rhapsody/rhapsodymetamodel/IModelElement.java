/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IModel Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This object this be the common one for all Rhapsody Semantic Element
 * Diagram seems considered as a semantic element in Rhapsody
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIModelElement()
 * @model
 * @generated
 */
public interface IModelElement extends EObject {

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * As the object IModelElement seems be the common Rhapsody semantic element, 
	 * we remove the field "displayName" of all elements owning a such field, and we put it here.
	 * All semantic Rhapsody elements should extend this one now.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIModelElement_DisplayName()
	 * @model
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);
} // IModelElement
