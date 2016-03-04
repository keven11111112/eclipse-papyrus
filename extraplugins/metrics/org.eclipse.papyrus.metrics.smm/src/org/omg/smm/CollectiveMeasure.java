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
 * A representation of the model object '<em><b>Collective Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.CollectiveMeasure#getAccumulator <em>Accumulator</em>}</li>
 *   <li>{@link org.omg.smm.CollectiveMeasure#getCustomAccumulator <em>Custom Accumulator</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getCollectiveMeasure()
 * @model
 * @generated
 */
public interface CollectiveMeasure extends DimensionalMeasure {
	/**
	 * Returns the value of the '<em><b>Accumulator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.omg.smm.Accumulator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accumulator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accumulator</em>' attribute.
	 * @see org.omg.smm.Accumulator
	 * @see #setAccumulator(Accumulator)
	 * @see org.omg.smm.SmmPackage#getCollectiveMeasure_Accumulator()
	 * @model required="true"
	 * @generated
	 */
	Accumulator getAccumulator();

	/**
	 * Sets the value of the '{@link org.omg.smm.CollectiveMeasure#getAccumulator <em>Accumulator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accumulator</em>' attribute.
	 * @see org.omg.smm.Accumulator
	 * @see #getAccumulator()
	 * @generated
	 */
	void setAccumulator(Accumulator value);

	/**
	 * Returns the value of the '<em><b>Custom Accumulator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Accumulator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Accumulator</em>' reference.
	 * @see #setCustomAccumulator(Operation)
	 * @see org.omg.smm.SmmPackage#getCollectiveMeasure_CustomAccumulator()
	 * @model
	 * @generated
	 */
	Operation getCustomAccumulator();

	/**
	 * Sets the value of the '{@link org.omg.smm.CollectiveMeasure#getCustomAccumulator <em>Custom Accumulator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Accumulator</em>' reference.
	 * @see #getCustomAccumulator()
	 * @generated
	 */
	void setCustomAccumulator(Operation value);

} // CollectiveMeasure
