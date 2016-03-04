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
 * A representation of the model object '<em><b>Rescaled Measurement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.RescaledMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}</li>
 *   <li>{@link org.omg.smm.RescaledMeasurement#getBaseQuery <em>Base Query</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getRescaledMeasurement()
 * @model
 * @generated
 */
public interface RescaledMeasurement extends DimensionalMeasurement {
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
	 * @see org.omg.smm.SmmPackage#getRescaledMeasurement_IsBaseSupplied()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsBaseSupplied();

	/**
	 * Sets the value of the '{@link org.omg.smm.RescaledMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Base Supplied</em>' attribute.
	 * @see #isIsBaseSupplied()
	 * @generated
	 */
	void setIsBaseSupplied(boolean value);

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
	 * @see org.omg.smm.SmmPackage#getRescaledMeasurement_BaseQuery()
	 * @model
	 * @generated
	 */
	Operation getBaseQuery();

	/**
	 * Sets the value of the '{@link org.omg.smm.RescaledMeasurement#getBaseQuery <em>Base Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Query</em>' reference.
	 * @see #getBaseQuery()
	 * @generated
	 */
	void setBaseQuery(Operation value);

} // RescaledMeasurement
