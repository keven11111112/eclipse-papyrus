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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ISend Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction#getM_hTarget <em>MhTarget</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction#getM_hEvent <em>MhEvent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction#getArgValCount <em>Arg Val Count</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction#getGraphElements <em>Graph Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getISendAction()
 * @model
 * @generated
 */
public interface ISendAction extends IAction {
	/**
	 * Returns the value of the '<em><b>MhTarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MhTarget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MhTarget</em>' reference.
	 * @see #setM_hTarget(M_hTargetType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getISendAction_M_hTarget()
	 * @model
	 * @generated
	 */
	M_hTargetType getM_hTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction#getM_hTarget <em>MhTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MhTarget</em>' reference.
	 * @see #getM_hTarget()
	 * @generated
	 */
	void setM_hTarget(M_hTargetType value);

	/**
	 * Returns the value of the '<em><b>MhEvent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MhEvent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MhEvent</em>' containment reference.
	 * @see #setM_hEvent(IEventHandle)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getISendAction_M_hEvent()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IEventHandle getM_hEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction#getM_hEvent <em>MhEvent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MhEvent</em>' containment reference.
	 * @see #getM_hEvent()
	 * @generated
	 */
	void setM_hEvent(IEventHandle value);

	/**
	 * Returns the value of the '<em><b>Arg Val Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arg Val Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arg Val Count</em>' attribute.
	 * @see #setArgValCount(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getISendAction_ArgValCount()
	 * @model
	 * @generated
	 */
	String getArgValCount();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction#getArgValCount <em>Arg Val Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arg Val Count</em>' attribute.
	 * @see #getArgValCount()
	 * @generated
	 */
	void setArgValCount(String value);

	/**
	 * Returns the value of the '<em><b>Graph Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHandleWithData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getISendAction_GraphElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IHandleWithData> getGraphElements();

} // ISendAction
