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
 * A representation of the model object '<em><b>Binary Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.BinaryMeasure#getFunctor <em>Functor</em>}</li>
 *   <li>{@link org.omg.smm.BinaryMeasure#getCustomFunctor <em>Custom Functor</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getBinaryMeasure()
 * @model
 * @generated
 */
public interface BinaryMeasure extends DimensionalMeasure {
	/**
	 * Returns the value of the '<em><b>Functor</b></em>' attribute.
	 * The literals are from the enumeration {@link org.omg.smm.BinaryFunctor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functor</em>' attribute.
	 * @see org.omg.smm.BinaryFunctor
	 * @see #setFunctor(BinaryFunctor)
	 * @see org.omg.smm.SmmPackage#getBinaryMeasure_Functor()
	 * @model required="true"
	 * @generated
	 */
	BinaryFunctor getFunctor();

	/**
	 * Sets the value of the '{@link org.omg.smm.BinaryMeasure#getFunctor <em>Functor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functor</em>' attribute.
	 * @see org.omg.smm.BinaryFunctor
	 * @see #getFunctor()
	 * @generated
	 */
	void setFunctor(BinaryFunctor value);

	/**
	 * Returns the value of the '<em><b>Custom Functor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Functor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Functor</em>' reference.
	 * @see #setCustomFunctor(Operation)
	 * @see org.omg.smm.SmmPackage#getBinaryMeasure_CustomFunctor()
	 * @model
	 * @generated
	 */
	Operation getCustomFunctor();

	/**
	 * Sets the value of the '{@link org.omg.smm.BinaryMeasure#getCustomFunctor <em>Custom Functor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Functor</em>' reference.
	 * @see #getCustomFunctor()
	 * @generated
	 */
	void setCustomFunctor(Operation value);

} // BinaryMeasure
