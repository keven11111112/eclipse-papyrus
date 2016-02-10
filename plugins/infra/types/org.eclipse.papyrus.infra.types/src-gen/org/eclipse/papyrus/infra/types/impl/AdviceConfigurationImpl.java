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
package org.eclipse.papyrus.infra.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.types.AdviceConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AdviceConfigurationImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AdviceConfigurationImpl#getAfter <em>After</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AdviceConfigurationImpl extends ConfigurationElementImpl implements AdviceConfiguration {
	/**
	 * The cached value of the '{@link #getBefore() <em>Before</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected EList<String> before;

	/**
	 * The cached value of the '{@link #getAfter() <em>After</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected EList<String> after;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdviceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementTypesConfigurationsPackage.Literals.ADVICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBefore() {
		if (before == null) {
			before = new EDataTypeUniqueEList<String>(String.class, this, ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__BEFORE);
		}
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAfter() {
		if (after == null) {
			after = new EDataTypeUniqueEList<String>(String.class, this, ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__AFTER);
		}
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				return getBefore();
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				return getAfter();
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
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				getBefore().clear();
				getBefore().addAll((Collection<? extends String>)newValue);
				return;
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				getAfter().clear();
				getAfter().addAll((Collection<? extends String>)newValue);
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
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				getBefore().clear();
				return;
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				getAfter().clear();
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
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				return before != null && !before.isEmpty();
			case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				return after != null && !after.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (before: ");
		result.append(before);
		result.append(", after: ");
		result.append(after);
		result.append(')');
		return result.toString();
	}

} //AdviceConfigurationImpl
