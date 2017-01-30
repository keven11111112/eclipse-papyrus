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
 * A representation of the model object '<em><b>IAssociation Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass#getIsClass <em>Is Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass#getM_end1 <em>Mend1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass#getM_end2 <em>Mend2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIAssociationClass()
 * @model
 * @generated
 */
public interface IAssociationClass extends IClass {

	/**
	 * Returns the value of the '<em><b>Is Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Class</em>' attribute.
	 * @see #setIsClass(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIAssociationClass_IsClass()
	 * @model
	 * @generated
	 */
	String getIsClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass#getIsClass <em>Is Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Class</em>' attribute.
	 * @see #getIsClass()
	 * @generated
	 */
	void setIsClass(String value);

	/**
	 * Returns the value of the '<em><b>Mend1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mend1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mend1</em>' reference.
	 * @see #setM_end1(IAssociationEnd)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIAssociationClass_M_end1()
	 * @model
	 * @generated
	 */
	IAssociationEnd getM_end1();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass#getM_end1 <em>Mend1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mend1</em>' reference.
	 * @see #getM_end1()
	 * @generated
	 */
	void setM_end1(IAssociationEnd value);

	/**
	 * Returns the value of the '<em><b>Mend2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mend2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mend2</em>' reference.
	 * @see #setM_end2(IAssociationEnd)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIAssociationClass_M_end2()
	 * @model
	 * @generated
	 */
	IAssociationEnd getM_end2();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass#getM_end2 <em>Mend2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mend2</em>' reference.
	 * @see #getM_end2()
	 * @generated
	 */
	void setM_end2(IAssociationEnd value);
} // IAssociationClass
