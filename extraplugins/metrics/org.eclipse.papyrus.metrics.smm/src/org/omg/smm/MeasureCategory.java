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
 * A representation of the model object '<em><b>Measure Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.MeasureCategory#getCategory <em>Category</em>}</li>
 *   <li>{@link org.omg.smm.MeasureCategory#getCategoryElement <em>Category Element</em>}</li>
 *   <li>{@link org.omg.smm.MeasureCategory#getCategoryMeasure <em>Category Measure</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getMeasureCategory()
 * @model
 * @generated
 */
public interface MeasureCategory extends AbstractMeasureElement {
	/**
	 * Returns the value of the '<em><b>Category</b></em>' reference list.
	 * The list contents are of type {@link org.omg.smm.MeasureCategory}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.MeasureCategory#getCategoryElement <em>Category Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' reference list.
	 * @see org.omg.smm.SmmPackage#getMeasureCategory_Category()
	 * @see org.omg.smm.MeasureCategory#getCategoryElement
	 * @model opposite="categoryElement" ordered="false"
	 * @generated
	 */
	EList<MeasureCategory> getCategory();

	/**
	 * Returns the value of the '<em><b>Category Element</b></em>' reference list.
	 * The list contents are of type {@link org.omg.smm.MeasureCategory}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.MeasureCategory#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Element</em>' reference list.
	 * @see org.omg.smm.SmmPackage#getMeasureCategory_CategoryElement()
	 * @see org.omg.smm.MeasureCategory#getCategory
	 * @model opposite="category" ordered="false"
	 * @generated
	 */
	EList<MeasureCategory> getCategoryElement();

	/**
	 * Returns the value of the '<em><b>Category Measure</b></em>' reference list.
	 * The list contents are of type {@link org.omg.smm.Measure}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.Measure#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Measure</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Measure</em>' reference list.
	 * @see org.omg.smm.SmmPackage#getMeasureCategory_CategoryMeasure()
	 * @see org.omg.smm.Measure#getCategory
	 * @model opposite="category" ordered="false"
	 * @generated
	 */
	EList<Measure> getCategoryMeasure();

} // MeasureCategory
