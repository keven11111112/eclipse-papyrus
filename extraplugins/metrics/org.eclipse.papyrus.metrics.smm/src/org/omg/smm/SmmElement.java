/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.omg.smm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.SmmElement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.omg.smm.SmmElement#getName <em>Name</em>}</li>
 *   <li>{@link org.omg.smm.SmmElement#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.omg.smm.SmmElement#getInRelationships <em>In Relationships</em>}</li>
 *   <li>{@link org.omg.smm.SmmElement#getOutRelationships <em>Out Relationships</em>}</li>
 *   <li>{@link org.omg.smm.SmmElement#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.omg.smm.SmmElement#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getSmmElement()
 * @model abstract="true"
 * @generated
 */
public interface SmmElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.omg.smm.SmmPackage#getSmmElement_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.omg.smm.SmmElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see org.omg.smm.SmmPackage#getSmmElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.omg.smm.SmmElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Short Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Short Description</em>' attribute.
	 * @see #setShortDescription(String)
	 * @see org.omg.smm.SmmPackage#getSmmElement_ShortDescription()
	 * @model required="true"
	 * @generated
	 */
	String getShortDescription();

	/**
	 * Sets the value of the '{@link org.omg.smm.SmmElement#getShortDescription <em>Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Description</em>' attribute.
	 * @see #getShortDescription()
	 * @generated
	 */
	void setShortDescription(String value);

	/**
	 * Returns the value of the '<em><b>In Relationships</b></em>' reference list.
	 * The list contents are of type {@link org.omg.smm.SmmRelationship}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.SmmRelationship#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Relationships</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Relationships</em>' reference list.
	 * @see org.omg.smm.SmmPackage#getSmmElement_InRelationships()
	 * @see org.omg.smm.SmmRelationship#getTo
	 * @model opposite="to" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<SmmRelationship> getInRelationships();

	/**
	 * Returns the value of the '<em><b>Out Relationships</b></em>' reference list.
	 * The list contents are of type {@link org.omg.smm.SmmRelationship}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.SmmRelationship#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Relationships</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Relationships</em>' reference list.
	 * @see org.omg.smm.SmmPackage#getSmmElement_OutRelationships()
	 * @see org.omg.smm.SmmRelationship#getFrom
	 * @model opposite="from" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<SmmRelationship> getOutRelationships();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getSmmElement_Attributes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getSmmElement_Annotations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

} // SmmElement
