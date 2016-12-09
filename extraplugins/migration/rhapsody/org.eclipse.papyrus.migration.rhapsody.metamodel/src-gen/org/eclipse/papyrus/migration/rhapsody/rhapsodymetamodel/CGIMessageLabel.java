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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CGI Message Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getM_pCommunicationConnection <em>MpCommunication Connection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getPercent <em>Percent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIMessageLabel()
 * @model
 * @generated
 */
public interface CGIMessageLabel extends GraphElementsType {
	/**
	 * Returns the value of the '<em><b>MpModel Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpModel Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpModel Object</em>' reference.
	 * @see #setM_pModelObject(IMessage)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIMessageLabel_M_pModelObject()
	 * @model
	 * @generated
	 */
	IMessage getM_pModelObject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getM_pModelObject <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpModel Object</em>' reference.
	 * @see #getM_pModelObject()
	 * @generated
	 */
	void setM_pModelObject(IMessage value);

	/**
	 * Returns the value of the '<em><b>MpParent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpParent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpParent</em>' attribute.
	 * @see #setM_pParent(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIMessageLabel_M_pParent()
	 * @model
	 * @generated
	 */
	String getM_pParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getM_pParent <em>MpParent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpParent</em>' attribute.
	 * @see #getM_pParent()
	 * @generated
	 */
	void setM_pParent(String value);

	/**
	 * Returns the value of the '<em><b>MpCommunication Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpCommunication Connection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpCommunication Connection</em>' reference.
	 * @see #setM_pCommunicationConnection(CGIAssociationRole)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIMessageLabel_M_pCommunicationConnection()
	 * @model
	 * @generated
	 */
	CGIAssociationRole getM_pCommunicationConnection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getM_pCommunicationConnection <em>MpCommunication Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpCommunication Connection</em>' reference.
	 * @see #getM_pCommunicationConnection()
	 * @generated
	 */
	void setM_pCommunicationConnection(CGIAssociationRole value);

	/**
	 * Returns the value of the '<em><b>Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percent</em>' attribute.
	 * @see #setPercent(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIMessageLabel_Percent()
	 * @model
	 * @generated
	 */
	String getPercent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel#getPercent <em>Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percent</em>' attribute.
	 * @see #getPercent()
	 * @generated
	 */
	void setPercent(String value);

} // CGIMessageLabel
