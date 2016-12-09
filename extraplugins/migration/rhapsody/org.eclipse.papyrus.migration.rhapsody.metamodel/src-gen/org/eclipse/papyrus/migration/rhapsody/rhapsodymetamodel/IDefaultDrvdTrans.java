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
 * A representation of the model object '<em><b>IDefault Drvd Trans</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getItsSource <em>Its Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getOfState <em>Of State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getErrorStatus <em>Error Status</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDefaultDrvdTrans()
 * @model
 * @generated
 */
public interface IDefaultDrvdTrans extends DefaultTransType, TransitionsType, DependsOnType {
	/**
	 * Returns the value of the '<em><b>Its Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Source</em>' attribute.
	 * @see #setItsSource(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDefaultDrvdTrans_ItsSource()
	 * @model
	 * @generated
	 */
	String getItsSource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getItsSource <em>Its Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Source</em>' attribute.
	 * @see #getItsSource()
	 * @generated
	 */
	void setItsSource(String value);

	/**
	 * Returns the value of the '<em><b>Of State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of State</em>' reference.
	 * @see #setOfState(IState)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDefaultDrvdTrans_OfState()
	 * @model
	 * @generated
	 */
	IState getOfState();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getOfState <em>Of State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of State</em>' reference.
	 * @see #getOfState()
	 * @generated
	 */
	void setOfState(IState value);

	/**
	 * Returns the value of the '<em><b>Error Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Status</em>' attribute.
	 * @see #setErrorStatus(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDefaultDrvdTrans_ErrorStatus()
	 * @model
	 * @generated
	 */
	String getErrorStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getErrorStatus <em>Error Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Status</em>' attribute.
	 * @see #getErrorStatus()
	 * @generated
	 */
	void setErrorStatus(String value);

	/**
	 * Returns the value of the '<em><b>Inherits From Handle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherits From Handle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherits From Handle</em>' reference.
	 * @see #setInheritsFromHandle(IDefaultDrvdTrans)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDefaultDrvdTrans_InheritsFromHandle()
	 * @model
	 * @generated
	 */
	IDefaultDrvdTrans getInheritsFromHandle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getInheritsFromHandle <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherits From Handle</em>' reference.
	 * @see #getInheritsFromHandle()
	 * @generated
	 */
	void setInheritsFromHandle(IDefaultDrvdTrans value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference.
	 * @see #setAnnotations(IRequirement)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDefaultDrvdTrans_Annotations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IRequirement getAnnotations();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getAnnotations <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotations</em>' containment reference.
	 * @see #getAnnotations()
	 * @generated
	 */
	void setAnnotations(IRequirement value);

	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' reference.
	 * @see #setStereotypes(IStereotype)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDefaultDrvdTrans_Stereotypes()
	 * @model
	 * @generated
	 */
	IStereotype getStereotypes();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans#getStereotypes <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotypes</em>' reference.
	 * @see #getStereotypes()
	 * @generated
	 */
	void setStereotypes(IStereotype value);

} // IDefaultDrvdTrans
