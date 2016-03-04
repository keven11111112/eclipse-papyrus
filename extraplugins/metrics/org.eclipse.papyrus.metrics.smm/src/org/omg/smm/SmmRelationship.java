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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.SmmRelationship#getFrom <em>From</em>}</li>
 *   <li>{@link org.omg.smm.SmmRelationship#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getSmmRelationship()
 * @model abstract="true"
 * @generated
 */
public interface SmmRelationship extends SmmElement {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.SmmElement#getOutRelationships <em>Out Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(SmmElement)
	 * @see org.omg.smm.SmmPackage#getSmmRelationship_From()
	 * @see org.omg.smm.SmmElement#getOutRelationships
	 * @model opposite="outRelationships" required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SmmElement getFrom();

	/**
	 * Sets the value of the '{@link org.omg.smm.SmmRelationship#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(SmmElement value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.SmmElement#getInRelationships <em>In Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(SmmElement)
	 * @see org.omg.smm.SmmPackage#getSmmRelationship_To()
	 * @see org.omg.smm.SmmElement#getInRelationships
	 * @model opposite="inRelationships" required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SmmElement getTo();

	/**
	 * Sets the value of the '{@link org.omg.smm.SmmRelationship#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(SmmElement value);

} // SmmRelationship
