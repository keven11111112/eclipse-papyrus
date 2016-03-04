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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observed Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.ObservedMeasure#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link org.omg.smm.ObservedMeasure#getMeasure <em>Measure</em>}</li>
 *   <li>{@link org.omg.smm.ObservedMeasure#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getObservedMeasure()
 * @model
 * @generated
 */
public interface ObservedMeasure extends SmmElement {
	/**
	 * Returns the value of the '<em><b>Measurements</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.Measurement}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.Measurement#getObservedMeasure <em>Observed Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurements</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getObservedMeasure_Measurements()
	 * @see org.omg.smm.Measurement#getObservedMeasure
	 * @model opposite="observedMeasure" containment="true" ordered="false"
	 * @generated
	 */
	EList<Measurement> getMeasurements();

	/**
	 * Returns the value of the '<em><b>Measure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' reference.
	 * @see #setMeasure(Measure)
	 * @see org.omg.smm.SmmPackage#getObservedMeasure_Measure()
	 * @model required="true"
	 * @generated
	 */
	Measure getMeasure();

	/**
	 * Sets the value of the '{@link org.omg.smm.ObservedMeasure#getMeasure <em>Measure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure</em>' reference.
	 * @see #getMeasure()
	 * @generated
	 */
	void setMeasure(Measure value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.Argument}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.Argument#getObservedMeasure <em>Observed Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getObservedMeasure_Arguments()
	 * @see org.omg.smm.Argument#getObservedMeasure
	 * @model opposite="observedMeasure" containment="true" ordered="false"
	 * @generated
	 */
	EList<Argument> getArguments();

} // ObservedMeasure
