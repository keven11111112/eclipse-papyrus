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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.SmmModel#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link org.omg.smm.SmmModel#getObservations <em>Observations</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getSmmModel()
 * @model
 * @generated
 */
public interface SmmModel extends SmmElement {
	/**
	 * Returns the value of the '<em><b>Libraries</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.MeasureLibrary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libraries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libraries</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getSmmModel_Libraries()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MeasureLibrary> getLibraries();

	/**
	 * Returns the value of the '<em><b>Observations</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.Observation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observations</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getSmmModel_Observations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Observation> getObservations();

} // SmmModel
