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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MatcherConfigurationImpl;

import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Application Matcher Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationImpl#getStereotypesQualifiedNames <em>Stereotypes Qualified Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeApplicationMatcherConfigurationImpl extends MatcherConfigurationImpl implements StereotypeApplicationMatcherConfiguration {
	/**
	 * The cached value of the '{@link #getStereotypesQualifiedNames() <em>Stereotypes Qualified Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypesQualifiedNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stereotypesQualifiedNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypeApplicationMatcherConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StereotypeApplicationMatcherConfigurationPackage.Literals.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStereotypesQualifiedNames() {
		if (stereotypesQualifiedNames == null) {
			stereotypesQualifiedNames = new EDataTypeUniqueEList<String>(String.class, this, StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__STEREOTYPES_QUALIFIED_NAMES);
		}
		return stereotypesQualifiedNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__STEREOTYPES_QUALIFIED_NAMES:
				return getStereotypesQualifiedNames();
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__STEREOTYPES_QUALIFIED_NAMES:
				getStereotypesQualifiedNames().clear();
				getStereotypesQualifiedNames().addAll((Collection<? extends String>)newValue);
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__STEREOTYPES_QUALIFIED_NAMES:
				getStereotypesQualifiedNames().clear();
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__STEREOTYPES_QUALIFIED_NAMES:
				return stereotypesQualifiedNames != null && !stereotypesQualifiedNames.isEmpty();
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
		result.append(" (stereotypesQualifiedNames: ");
		result.append(stereotypesQualifiedNames);
		result.append(')');
		return result.toString();
	}

} //StereotypeApplicationMatcherConfigurationImpl
