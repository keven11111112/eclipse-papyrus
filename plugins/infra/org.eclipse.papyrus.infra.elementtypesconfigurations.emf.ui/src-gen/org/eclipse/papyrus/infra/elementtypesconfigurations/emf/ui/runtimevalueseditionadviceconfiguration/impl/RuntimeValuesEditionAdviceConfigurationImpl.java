/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.ViewToDisplay;

import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AbstractAdviceBindingConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runtime Values Edition Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimeValuesEditionAdviceConfigurationImpl#getViewsToDisplay <em>Views To Display</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuntimeValuesEditionAdviceConfigurationImpl extends AbstractAdviceBindingConfigurationImpl implements RuntimeValuesEditionAdviceConfiguration {
	/**
	 * The cached value of the '{@link #getViewsToDisplay() <em>Views To Display</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewsToDisplay()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewToDisplay> viewsToDisplay;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuntimeValuesEditionAdviceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimevalueseditionadviceconfigurationPackage.Literals.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ViewToDisplay> getViewsToDisplay() {
		if (viewsToDisplay == null) {
			viewsToDisplay = new EObjectContainmentEList<ViewToDisplay>(ViewToDisplay.class, this, RuntimevalueseditionadviceconfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY);
		}
		return viewsToDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimevalueseditionadviceconfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY:
				return ((InternalEList<?>)getViewsToDisplay()).basicRemove(otherEnd, msgs);
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
			case RuntimevalueseditionadviceconfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY:
				return getViewsToDisplay();
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
			case RuntimevalueseditionadviceconfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY:
				getViewsToDisplay().clear();
				getViewsToDisplay().addAll((Collection<? extends ViewToDisplay>)newValue);
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
			case RuntimevalueseditionadviceconfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY:
				getViewsToDisplay().clear();
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
			case RuntimevalueseditionadviceconfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY:
				return viewsToDisplay != null && !viewsToDisplay.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RuntimeValuesEditionAdviceConfigurationImpl
