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
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Invariant Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.CompositeInvariantRuleConfigurationImpl#getComposedRules <em>Composed Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeInvariantRuleConfigurationImpl extends InvariantRuleConfigurationImpl implements CompositeInvariantRuleConfiguration {
	/**
	 * The cached value of the '{@link #getComposedRules() <em>Composed Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposedRules()
	 * @generated
	 * @ordered
	 */
	protected EList<InvariantRuleConfiguration> composedRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeInvariantRuleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantTypeConfigurationPackage.Literals.COMPOSITE_INVARIANT_RULE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InvariantRuleConfiguration> getComposedRules() {
		if (composedRules == null) {
			composedRules = new EObjectContainmentEList<InvariantRuleConfiguration>(InvariantRuleConfiguration.class, this, InvariantTypeConfigurationPackage.COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES);
		}
		return composedRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InvariantTypeConfigurationPackage.COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES:
				return ((InternalEList<?>)getComposedRules()).basicRemove(otherEnd, msgs);
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
			case InvariantTypeConfigurationPackage.COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES:
				return getComposedRules();
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
			case InvariantTypeConfigurationPackage.COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES:
				getComposedRules().clear();
				getComposedRules().addAll((Collection<? extends InvariantRuleConfiguration>)newValue);
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
			case InvariantTypeConfigurationPackage.COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES:
				getComposedRules().clear();
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
			case InvariantTypeConfigurationPackage.COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES:
				return composedRules != null && !composedRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeInvariantRuleConfigurationImpl
