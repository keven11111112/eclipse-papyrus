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
package org.eclipse.papyrus.infra.elementtypesconfigurations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl#getEditHelperAdviceClassName <em>Edit Helper Advice Class Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AdviceConfigurationImpl extends ConfigurationElementImpl implements AdviceConfiguration {
	/**
	 * The default value of the '{@link #getEditHelperAdviceClassName() <em>Edit Helper Advice Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditHelperAdviceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String EDIT_HELPER_ADVICE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditHelperAdviceClassName() <em>Edit Helper Advice Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditHelperAdviceClassName()
	 * @generated
	 * @ordered
	 */
	protected String editHelperAdviceClassName = EDIT_HELPER_ADVICE_CLASS_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getInheritance() <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritance()
	 * @generated
	 * @ordered
	 */
	protected static final InheritanceKind INHERITANCE_EDEFAULT = InheritanceKind.NONE;

	/**
	 * The cached value of the '{@link #getInheritance() <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritance()
	 * @generated
	 * @ordered
	 */
	protected InheritanceKind inheritance = INHERITANCE_EDEFAULT;

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
		return ElementtypesconfigurationsPackage.Literals.ADVICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditHelperAdviceClassName() {
		return editHelperAdviceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditHelperAdviceClassName(String newEditHelperAdviceClassName) {
		String oldEditHelperAdviceClassName = editHelperAdviceClassName;
		editHelperAdviceClassName = newEditHelperAdviceClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME, oldEditHelperAdviceClassName, editHelperAdviceClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBefore() {
		if (before == null) {
			before = new EDataTypeUniqueEList<String>(String.class, this, ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__BEFORE);
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
			after = new EDataTypeUniqueEList<String>(String.class, this, ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__AFTER);
		}
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritanceKind getInheritance() {
		return inheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritance(InheritanceKind newInheritance) {
		InheritanceKind oldInheritance = inheritance;
		inheritance = newInheritance == null ? INHERITANCE_EDEFAULT : newInheritance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__INHERITANCE, oldInheritance, inheritance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME:
				return getEditHelperAdviceClassName();
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				return getBefore();
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				return getAfter();
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__INHERITANCE:
				return getInheritance();
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
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME:
				setEditHelperAdviceClassName((String)newValue);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				getBefore().clear();
				getBefore().addAll((Collection<? extends String>)newValue);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				getAfter().clear();
				getAfter().addAll((Collection<? extends String>)newValue);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__INHERITANCE:
				setInheritance((InheritanceKind)newValue);
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
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME:
				setEditHelperAdviceClassName(EDIT_HELPER_ADVICE_CLASS_NAME_EDEFAULT);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				getBefore().clear();
				return;
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				getAfter().clear();
				return;
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__INHERITANCE:
				setInheritance(INHERITANCE_EDEFAULT);
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
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME:
				return EDIT_HELPER_ADVICE_CLASS_NAME_EDEFAULT == null ? editHelperAdviceClassName != null : !EDIT_HELPER_ADVICE_CLASS_NAME_EDEFAULT.equals(editHelperAdviceClassName);
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__BEFORE:
				return before != null && !before.isEmpty();
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__AFTER:
				return after != null && !after.isEmpty();
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION__INHERITANCE:
				return inheritance != INHERITANCE_EDEFAULT;
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
		result.append(" (editHelperAdviceClassName: ");
		result.append(editHelperAdviceClassName);
		result.append(", before: ");
		result.append(before);
		result.append(", after: ");
		result.append(after);
		result.append(", inheritance: ");
		result.append(inheritance);
		result.append(')');
		return result.toString();
	}

} //AdviceConfigurationImpl
