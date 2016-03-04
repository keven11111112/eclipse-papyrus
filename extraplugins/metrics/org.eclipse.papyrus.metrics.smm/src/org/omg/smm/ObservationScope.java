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
 * A representation of the model object '<em><b>Observation Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.ObservationScope#getScopeUri <em>Scope Uri</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getObservationScope()
 * @model
 * @generated
 */
public interface ObservationScope extends SmmElement {
	/**
	 * Returns the value of the '<em><b>Scope Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope Uri</em>' attribute.
	 * @see #setScopeUri(String)
	 * @see org.omg.smm.SmmPackage#getObservationScope_ScopeUri()
	 * @model required="true"
	 * @generated
	 */
	String getScopeUri();

	/**
	 * Sets the value of the '{@link org.omg.smm.ObservationScope#getScopeUri <em>Scope Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope Uri</em>' attribute.
	 * @see #getScopeUri()
	 * @generated
	 */
	void setScopeUri(String value);

} // ObservationScope
