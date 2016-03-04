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
 * A representation of the model object '<em><b>Measure Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.MeasureLibrary#getMeasureElements <em>Measure Elements</em>}</li>
 *   <li>{@link org.omg.smm.MeasureLibrary#getCategoryRelationships <em>Category Relationships</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getMeasureLibrary()
 * @model
 * @generated
 */
public interface MeasureLibrary extends SmmElement {
	/**
	 * Returns the value of the '<em><b>Measure Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.AbstractMeasureElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure Elements</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getMeasureLibrary_MeasureElements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractMeasureElement> getMeasureElements();

	/**
	 * Returns the value of the '<em><b>Category Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.CategoryRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Relationships</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Relationships</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getMeasureLibrary_CategoryRelationships()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<CategoryRelationship> getCategoryRelationships();

} // MeasureLibrary
