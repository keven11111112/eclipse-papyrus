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
 * A representation of the model object '<em><b>ITriggered</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getConcurrency <em>Concurrency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getProtection <em>Protection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getMyState <em>My State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered()
 * @model
 * @generated
 */
public interface ITriggered extends OperationsType, M_pFormalMessageType, ItemsType, IModelElement {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_Args()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IVariable> getArgs();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' reference.
	 * @see #setReturnType(IType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_ReturnType()
	 * @model
	 * @generated
	 */
	IType getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getReturnType <em>Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(IType value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_Abstract()
	 * @model
	 * @generated
	 */
	String getAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #getAbstract()
	 * @generated
	 */
	void setAbstract(String value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_Final()
	 * @model
	 * @generated
	 */
	String getFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #getFinal()
	 * @generated
	 */
	void setFinal(String value);

	/**
	 * Returns the value of the '<em><b>Concurrency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concurrency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concurrency</em>' attribute.
	 * @see #setConcurrency(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_Concurrency()
	 * @model
	 * @generated
	 */
	String getConcurrency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getConcurrency <em>Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concurrency</em>' attribute.
	 * @see #getConcurrency()
	 * @generated
	 */
	void setConcurrency(String value);

	/**
	 * Returns the value of the '<em><b>Protection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protection</em>' attribute.
	 * @see #setProtection(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_Protection()
	 * @model
	 * @generated
	 */
	String getProtection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getProtection <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protection</em>' attribute.
	 * @see #getProtection()
	 * @generated
	 */
	void setProtection(String value);

	/**
	 * Returns the value of the '<em><b>Modified Time Weak</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified Time Weak</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified Time Weak</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_ModifiedTimeWeak()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getModifiedTimeWeak();

	/**
	 * Returns the value of the '<em><b>My State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My State</em>' attribute.
	 * @see #setMyState(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITriggered_MyState()
	 * @model
	 * @generated
	 */
	String getMyState();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered#getMyState <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My State</em>' attribute.
	 * @see #getMyState()
	 * @generated
	 */
	void setMyState(String value);

} // ITriggered
