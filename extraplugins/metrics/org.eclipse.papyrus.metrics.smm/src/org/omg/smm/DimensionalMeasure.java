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
 * A representation of the model object '<em><b>Dimensional Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.DimensionalMeasure#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.omg.smm.DimensionalMeasure#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getDimensionalMeasure()
 * @model abstract="true"
 * @generated
 */
public interface DimensionalMeasure extends Measure {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #setUnit(UnitOfMeasure)
	 * @see org.omg.smm.SmmPackage#getDimensionalMeasure_Unit()
	 * @model required="true"
	 * @generated
	 */
	UnitOfMeasure getUnit();

	/**
	 * Sets the value of the '{@link org.omg.smm.DimensionalMeasure#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(UnitOfMeasure value);

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' attribute.
	 * @see #setFormula(String)
	 * @see org.omg.smm.SmmPackage#getDimensionalMeasure_Formula()
	 * @model
	 * @generated
	 */
	String getFormula();

	/**
	 * Sets the value of the '{@link org.omg.smm.DimensionalMeasure#getFormula <em>Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' attribute.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(String value);

} // DimensionalMeasure
