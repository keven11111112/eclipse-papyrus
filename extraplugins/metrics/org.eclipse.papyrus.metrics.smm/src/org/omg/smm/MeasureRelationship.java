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
 * A representation of the model object '<em><b>Measure Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.MeasureRelationship#getInfluence <em>Influence</em>}</li>
 *   <li>{@link org.omg.smm.MeasureRelationship#getMeasurandQuery <em>Measurand Query</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getMeasureRelationship()
 * @model abstract="true"
 * @generated
 */
public interface MeasureRelationship extends SmmRelationship {
	/**
	 * Returns the value of the '<em><b>Influence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.omg.smm.Influence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Influence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Influence</em>' attribute.
	 * @see org.omg.smm.Influence
	 * @see #setInfluence(Influence)
	 * @see org.omg.smm.SmmPackage#getMeasureRelationship_Influence()
	 * @model
	 * @generated
	 */
	Influence getInfluence();

	/**
	 * Sets the value of the '{@link org.omg.smm.MeasureRelationship#getInfluence <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Influence</em>' attribute.
	 * @see org.omg.smm.Influence
	 * @see #getInfluence()
	 * @generated
	 */
	void setInfluence(Influence value);

	/**
	 * Returns the value of the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurand Query</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurand Query</em>' reference.
	 * @see #setMeasurandQuery(Operation)
	 * @see org.omg.smm.SmmPackage#getMeasureRelationship_MeasurandQuery()
	 * @model
	 * @generated
	 */
	Operation getMeasurandQuery();

	/**
	 * Sets the value of the '{@link org.omg.smm.MeasureRelationship#getMeasurandQuery <em>Measurand Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurand Query</em>' reference.
	 * @see #getMeasurandQuery()
	 * @generated
	 */
	void setMeasurandQuery(Operation value);

} // MeasureRelationship
