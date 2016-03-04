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
 * A representation of the model object '<em><b>Grade Measurement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.GradeMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}</li>
 *   <li>{@link org.omg.smm.GradeMeasurement#getValue <em>Value</em>}</li>
 *   <li>{@link org.omg.smm.GradeMeasurement#getBaseQuery <em>Base Query</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getGradeMeasurement()
 * @model
 * @generated
 */
public interface GradeMeasurement extends Measurement {
	/**
	 * Returns the value of the '<em><b>Is Base Supplied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Base Supplied</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Base Supplied</em>' attribute.
	 * @see #setIsBaseSupplied(boolean)
	 * @see org.omg.smm.SmmPackage#getGradeMeasurement_IsBaseSupplied()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsBaseSupplied();

	/**
	 * Sets the value of the '{@link org.omg.smm.GradeMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Base Supplied</em>' attribute.
	 * @see #isIsBaseSupplied()
	 * @generated
	 */
	void setIsBaseSupplied(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.omg.smm.SmmPackage#getGradeMeasurement_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.omg.smm.GradeMeasurement#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Base Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Query</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Query</em>' reference.
	 * @see #setBaseQuery(Operation)
	 * @see org.omg.smm.SmmPackage#getGradeMeasurement_BaseQuery()
	 * @model
	 * @generated
	 */
	Operation getBaseQuery();

	/**
	 * Sets the value of the '{@link org.omg.smm.GradeMeasurement#getBaseQuery <em>Base Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Query</em>' reference.
	 * @see #getBaseQuery()
	 * @generated
	 */
	void setBaseQuery(Operation value);

} // GradeMeasurement
