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

import java.sql.Timestamp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.Observation#getObserver <em>Observer</em>}</li>
 *   <li>{@link org.omg.smm.Observation#getTool <em>Tool</em>}</li>
 *   <li>{@link org.omg.smm.Observation#getWhenObserved <em>When Observed</em>}</li>
 *   <li>{@link org.omg.smm.Observation#getScopes <em>Scopes</em>}</li>
 *   <li>{@link org.omg.smm.Observation#getObservedMeasures <em>Observed Measures</em>}</li>
 *   <li>{@link org.omg.smm.Observation#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.omg.smm.Observation#getRequestedMeasures <em>Requested Measures</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getObservation()
 * @model
 * @generated
 */
public interface Observation extends SmmElement {
	/**
	 * Returns the value of the '<em><b>Observer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observer</em>' attribute.
	 * @see #setObserver(String)
	 * @see org.omg.smm.SmmPackage#getObservation_Observer()
	 * @model
	 * @generated
	 */
	String getObserver();

	/**
	 * Sets the value of the '{@link org.omg.smm.Observation#getObserver <em>Observer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observer</em>' attribute.
	 * @see #getObserver()
	 * @generated
	 */
	void setObserver(String value);

	/**
	 * Returns the value of the '<em><b>Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool</em>' attribute.
	 * @see #setTool(String)
	 * @see org.omg.smm.SmmPackage#getObservation_Tool()
	 * @model
	 * @generated
	 */
	String getTool();

	/**
	 * Sets the value of the '{@link org.omg.smm.Observation#getTool <em>Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool</em>' attribute.
	 * @see #getTool()
	 * @generated
	 */
	void setTool(String value);

	/**
	 * Returns the value of the '<em><b>When Observed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When Observed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When Observed</em>' attribute.
	 * @see #setWhenObserved(Timestamp)
	 * @see org.omg.smm.SmmPackage#getObservation_WhenObserved()
	 * @model dataType="org.omg.smm.TimeStamp"
	 * @generated
	 */
	Timestamp getWhenObserved();

	/**
	 * Sets the value of the '{@link org.omg.smm.Observation#getWhenObserved <em>When Observed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When Observed</em>' attribute.
	 * @see #getWhenObserved()
	 * @generated
	 */
	void setWhenObserved(Timestamp value);

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.ObservationScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scopes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scopes</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getObservation_Scopes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ObservationScope> getScopes();

	/**
	 * Returns the value of the '<em><b>Observed Measures</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.ObservedMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Measures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed Measures</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getObservation_ObservedMeasures()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ObservedMeasure> getObservedMeasures();

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.Argument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getObservation_Arguments()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Argument> getArguments();

	/**
	 * Returns the value of the '<em><b>Requested Measures</b></em>' reference list.
	 * The list contents are of type {@link org.omg.smm.AbstractMeasureElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requested Measures</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requested Measures</em>' reference list.
	 * @see org.omg.smm.SmmPackage#getObservation_RequestedMeasures()
	 * @model ordered="false"
	 * @generated
	 */
	EList<AbstractMeasureElement> getRequestedMeasures();

} // Observation
