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
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.Argument#getType <em>Type</em>}</li>
 *   <li>{@link org.omg.smm.Argument#getValue <em>Value</em>}</li>
 *   <li>{@link org.omg.smm.Argument#getObservedMeasure <em>Observed Measure</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getArgument()
 * @model
 * @generated
 */
public interface Argument extends SmmElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.omg.smm.SmmPackage#getArgument_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.omg.smm.Argument#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

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
	 * @see org.omg.smm.SmmPackage#getArgument_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.omg.smm.Argument#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Observed Measure</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.ObservedMeasure#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Measure</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed Measure</em>' container reference.
	 * @see #setObservedMeasure(ObservedMeasure)
	 * @see org.omg.smm.SmmPackage#getArgument_ObservedMeasure()
	 * @see org.omg.smm.ObservedMeasure#getArguments
	 * @model opposite="arguments" transient="false"
	 * @generated
	 */
	ObservedMeasure getObservedMeasure();

	/**
	 * Sets the value of the '{@link org.omg.smm.Argument#getObservedMeasure <em>Observed Measure</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observed Measure</em>' container reference.
	 * @see #getObservedMeasure()
	 * @generated
	 */
	void setObservedMeasure(ObservedMeasure value);

} // Argument
