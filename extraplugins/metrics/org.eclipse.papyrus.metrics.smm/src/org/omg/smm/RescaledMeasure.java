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
 * A representation of the model object '<em><b>Rescaled Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.RescaledMeasure#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.omg.smm.RescaledMeasure#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.omg.smm.RescaledMeasure#getMultiplier <em>Multiplier</em>}</li>
 *   <li>{@link org.omg.smm.RescaledMeasure#getRescales <em>Rescales</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getRescaledMeasure()
 * @model
 * @generated
 */
public interface RescaledMeasure extends DimensionalMeasure {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see org.omg.smm.SmmPackage#getRescaledMeasure_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link org.omg.smm.RescaledMeasure#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(BigDecimal)
	 * @see org.omg.smm.SmmPackage#getRescaledMeasure_Offset()
	 * @model
	 * @generated
	 */
	BigDecimal getOffset();

	/**
	 * Sets the value of the '{@link org.omg.smm.RescaledMeasure#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Multiplier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplier</em>' attribute.
	 * @see #setMultiplier(BigDecimal)
	 * @see org.omg.smm.SmmPackage#getRescaledMeasure_Multiplier()
	 * @model
	 * @generated
	 */
	BigDecimal getMultiplier();

	/**
	 * Sets the value of the '{@link org.omg.smm.RescaledMeasure#getMultiplier <em>Multiplier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplier</em>' attribute.
	 * @see #getMultiplier()
	 * @generated
	 */
	void setMultiplier(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Rescales</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.BaseMeasureRelationship#getRescaledMeasure <em>Rescaled Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rescales</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rescales</em>' container reference.
	 * @see #setRescales(BaseMeasureRelationship)
	 * @see org.omg.smm.SmmPackage#getRescaledMeasure_Rescales()
	 * @see org.omg.smm.BaseMeasureRelationship#getRescaledMeasure
	 * @model opposite="rescaledMeasure" transient="false"
	 * @generated
	 */
	BaseMeasureRelationship getRescales();

	/**
	 * Sets the value of the '{@link org.omg.smm.RescaledMeasure#getRescales <em>Rescales</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rescales</em>' container reference.
	 * @see #getRescales()
	 * @generated
	 */
	void setRescales(BaseMeasureRelationship value);

} // RescaledMeasure
