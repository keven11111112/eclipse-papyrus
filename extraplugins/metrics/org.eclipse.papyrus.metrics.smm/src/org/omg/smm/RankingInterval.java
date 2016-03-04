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
 * A representation of the model object '<em><b>Ranking Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.RankingInterval#getValue <em>Value</em>}</li>
 *   <li>{@link org.omg.smm.RankingInterval#getRanking <em>Ranking</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getRankingInterval()
 * @model
 * @generated
 */
public interface RankingInterval extends Interval {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(BigDecimal)
	 * @see org.omg.smm.SmmPackage#getRankingInterval_Value()
	 * @model required="true"
	 * @generated
	 */
	BigDecimal getValue();

	/**
	 * Sets the value of the '{@link org.omg.smm.RankingInterval#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Ranking</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.RankingMeasure#getInterval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ranking</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ranking</em>' container reference.
	 * @see #setRanking(RankingMeasure)
	 * @see org.omg.smm.SmmPackage#getRankingInterval_Ranking()
	 * @see org.omg.smm.RankingMeasure#getInterval
	 * @model opposite="interval" required="true" transient="false"
	 * @generated
	 */
	RankingMeasure getRanking();

	/**
	 * Sets the value of the '{@link org.omg.smm.RankingInterval#getRanking <em>Ranking</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ranking</em>' container reference.
	 * @see #getRanking()
	 * @generated
	 */
	void setRanking(RankingMeasure value);

} // RankingInterval
