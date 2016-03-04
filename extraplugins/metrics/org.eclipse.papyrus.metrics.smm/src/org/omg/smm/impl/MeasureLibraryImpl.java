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
package org.omg.smm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.smm.AbstractMeasureElement;
import org.omg.smm.CategoryRelationship;
import org.omg.smm.MeasureLibrary;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measure Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.MeasureLibraryImpl#getMeasureElements <em>Measure Elements</em>}</li>
 *   <li>{@link org.omg.smm.impl.MeasureLibraryImpl#getCategoryRelationships <em>Category Relationships</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MeasureLibraryImpl extends SmmElementImpl implements MeasureLibrary {
	/**
	 * The cached value of the '{@link #getMeasureElements() <em>Measure Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureElements()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractMeasureElement> measureElements;

	/**
	 * The cached value of the '{@link #getCategoryRelationships() <em>Category Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategoryRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<CategoryRelationship> categoryRelationships;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasureLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.MEASURE_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractMeasureElement> getMeasureElements() {
		if (measureElements == null) {
			measureElements = new EObjectContainmentEList<AbstractMeasureElement>(AbstractMeasureElement.class, this, SmmPackage.MEASURE_LIBRARY__MEASURE_ELEMENTS);
		}
		return measureElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CategoryRelationship> getCategoryRelationships() {
		if (categoryRelationships == null) {
			categoryRelationships = new EObjectContainmentEList<CategoryRelationship>(CategoryRelationship.class, this, SmmPackage.MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS);
		}
		return categoryRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmmPackage.MEASURE_LIBRARY__MEASURE_ELEMENTS:
				return ((InternalEList<?>)getMeasureElements()).basicRemove(otherEnd, msgs);
			case SmmPackage.MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS:
				return ((InternalEList<?>)getCategoryRelationships()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.MEASURE_LIBRARY__MEASURE_ELEMENTS:
				return getMeasureElements();
			case SmmPackage.MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS:
				return getCategoryRelationships();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SmmPackage.MEASURE_LIBRARY__MEASURE_ELEMENTS:
				getMeasureElements().clear();
				getMeasureElements().addAll((Collection<? extends AbstractMeasureElement>)newValue);
				return;
			case SmmPackage.MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS:
				getCategoryRelationships().clear();
				getCategoryRelationships().addAll((Collection<? extends CategoryRelationship>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SmmPackage.MEASURE_LIBRARY__MEASURE_ELEMENTS:
				getMeasureElements().clear();
				return;
			case SmmPackage.MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS:
				getCategoryRelationships().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SmmPackage.MEASURE_LIBRARY__MEASURE_ELEMENTS:
				return measureElements != null && !measureElements.isEmpty();
			case SmmPackage.MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS:
				return categoryRelationships != null && !categoryRelationships.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MeasureLibraryImpl
