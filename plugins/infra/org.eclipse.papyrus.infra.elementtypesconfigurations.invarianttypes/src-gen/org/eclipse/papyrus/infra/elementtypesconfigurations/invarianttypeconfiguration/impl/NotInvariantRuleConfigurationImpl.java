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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Invariant Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.NotInvariantRuleConfigurationImpl#getComposedRule <em>Composed Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NotInvariantRuleConfigurationImpl extends InvariantRuleConfigurationImpl implements NotInvariantRuleConfiguration {
	/**
	 * The cached value of the '{@link #getComposedRule() <em>Composed Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposedRule()
	 * @generated
	 * @ordered
	 */
	protected InvariantRuleConfiguration composedRule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotInvariantRuleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantTypeConfigurationPackage.Literals.NOT_INVARIANT_RULE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantRuleConfiguration getComposedRule() {
		if (composedRule != null && composedRule.eIsProxy()) {
			InternalEObject oldComposedRule = (InternalEObject)composedRule;
			composedRule = (InvariantRuleConfiguration)eResolveProxy(oldComposedRule);
			if (composedRule != oldComposedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InvariantTypeConfigurationPackage.NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE, oldComposedRule, composedRule));
			}
		}
		return composedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantRuleConfiguration basicGetComposedRule() {
		return composedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposedRule(InvariantRuleConfiguration newComposedRule) {
		InvariantRuleConfiguration oldComposedRule = composedRule;
		composedRule = newComposedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantTypeConfigurationPackage.NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE, oldComposedRule, composedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InvariantTypeConfigurationPackage.NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE:
				if (resolve) return getComposedRule();
				return basicGetComposedRule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InvariantTypeConfigurationPackage.NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE:
				setComposedRule((InvariantRuleConfiguration)newValue);
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
			case InvariantTypeConfigurationPackage.NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE:
				setComposedRule((InvariantRuleConfiguration)null);
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
			case InvariantTypeConfigurationPackage.NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE:
				return composedRule != null;
		}
		return super.eIsSet(featureID);
	}

} //NotInvariantRuleConfigurationImpl
