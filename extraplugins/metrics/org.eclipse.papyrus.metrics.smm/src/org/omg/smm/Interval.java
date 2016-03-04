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

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.Interval#getMaximumEndpoint <em>Maximum Endpoint</em>}</li>
 *   <li>{@link org.omg.smm.Interval#isMaximumOpen <em>Maximum Open</em>}</li>
 *   <li>{@link org.omg.smm.Interval#getMinimumEndpoint <em>Minimum Endpoint</em>}</li>
 *   <li>{@link org.omg.smm.Interval#isMinimumOpen <em>Minimum Open</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getInterval()
 * @model abstract="true"
 * @generated
 */
public interface Interval extends SmmElement {
	/**
	 * Returns the value of the '<em><b>Maximum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Endpoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Endpoint</em>' attribute.
	 * @see #setMaximumEndpoint(BigDecimal)
	 * @see org.omg.smm.SmmPackage#getInterval_MaximumEndpoint()
	 * @model
	 * @generated
	 */
	BigDecimal getMaximumEndpoint();

	/**
	 * Sets the value of the '{@link org.omg.smm.Interval#getMaximumEndpoint <em>Maximum Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Endpoint</em>' attribute.
	 * @see #getMaximumEndpoint()
	 * @generated
	 */
	void setMaximumEndpoint(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Maximum Open</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Open</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Open</em>' attribute.
	 * @see #setMaximumOpen(boolean)
	 * @see org.omg.smm.SmmPackage#getInterval_MaximumOpen()
	 * @model default="false"
	 * @generated
	 */
	boolean isMaximumOpen();

	/**
	 * Sets the value of the '{@link org.omg.smm.Interval#isMaximumOpen <em>Maximum Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Open</em>' attribute.
	 * @see #isMaximumOpen()
	 * @generated
	 */
	void setMaximumOpen(boolean value);

	/**
	 * Returns the value of the '<em><b>Minimum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Endpoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Endpoint</em>' attribute.
	 * @see #setMinimumEndpoint(BigDecimal)
	 * @see org.omg.smm.SmmPackage#getInterval_MinimumEndpoint()
	 * @model
	 * @generated
	 */
	BigDecimal getMinimumEndpoint();

	/**
	 * Sets the value of the '{@link org.omg.smm.Interval#getMinimumEndpoint <em>Minimum Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Endpoint</em>' attribute.
	 * @see #getMinimumEndpoint()
	 * @generated
	 */
	void setMinimumEndpoint(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Minimum Open</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Open</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Open</em>' attribute.
	 * @see #setMinimumOpen(boolean)
	 * @see org.omg.smm.SmmPackage#getInterval_MinimumOpen()
	 * @model default="false"
	 * @generated
	 */
	boolean isMinimumOpen();

	/**
	 * Sets the value of the '{@link org.omg.smm.Interval#isMinimumOpen <em>Minimum Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Open</em>' attribute.
	 * @see #isMinimumOpen()
	 * @generated
	 */
	void setMinimumOpen(boolean value);

} // Interval
