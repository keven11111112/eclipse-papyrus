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
 * A representation of the model object '<em><b>Equivalent Measure Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.EquivalentMeasureRelationship#getMapping <em>Mapping</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getEquivalentMeasureRelationship()
 * @model
 * @generated
 */
public interface EquivalentMeasureRelationship extends MeasureRelationship {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' reference.
	 * @see #setMapping(Operation)
	 * @see org.omg.smm.SmmPackage#getEquivalentMeasureRelationship_Mapping()
	 * @model
	 * @generated
	 */
	Operation getMapping();

	/**
	 * Sets the value of the '{@link org.omg.smm.EquivalentMeasureRelationship#getMapping <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Operation value);

} // EquivalentMeasureRelationship
