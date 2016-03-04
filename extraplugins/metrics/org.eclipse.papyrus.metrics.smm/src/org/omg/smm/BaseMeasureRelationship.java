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
 * A representation of the model object '<em><b>Base Measure Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.BaseMeasureRelationship#getRescaledMeasure <em>Rescaled Measure</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getBaseMeasureRelationship()
 * @model abstract="true"
 * @generated
 */
public interface BaseMeasureRelationship extends MeasureRelationship {
	/**
	 * Returns the value of the '<em><b>Rescaled Measure</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.RescaledMeasure#getRescales <em>Rescales</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rescaled Measure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rescaled Measure</em>' containment reference.
	 * @see #setRescaledMeasure(RescaledMeasure)
	 * @see org.omg.smm.SmmPackage#getBaseMeasureRelationship_RescaledMeasure()
	 * @see org.omg.smm.RescaledMeasure#getRescales
	 * @model opposite="rescales" containment="true"
	 * @generated
	 */
	RescaledMeasure getRescaledMeasure();

	/**
	 * Sets the value of the '{@link org.omg.smm.BaseMeasureRelationship#getRescaledMeasure <em>Rescaled Measure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rescaled Measure</em>' containment reference.
	 * @see #getRescaledMeasure()
	 * @generated
	 */
	void setRescaledMeasure(RescaledMeasure value);

} // BaseMeasureRelationship
