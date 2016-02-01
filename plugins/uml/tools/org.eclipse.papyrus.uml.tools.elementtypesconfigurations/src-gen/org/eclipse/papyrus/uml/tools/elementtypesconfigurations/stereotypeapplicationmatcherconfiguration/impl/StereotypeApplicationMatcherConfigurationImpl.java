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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AbstractMatcherConfigurationImpl;

import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Application Matcher Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationImpl#getStereotypesQualifiedNames <em>Stereotypes Qualified Names</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationImpl#getProfileUri <em>Profile Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StereotypeApplicationMatcherConfigurationImpl extends AbstractMatcherConfigurationImpl implements StereotypeApplicationMatcherConfiguration {
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
	 * The default value of the '{@link #getProfileUri() <em>Profile Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileUri()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileUri() <em>Profile Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileUri()
	 * @generated
	 * @ordered
	 */
	protected String profileUri = PROFILE_URI_EDEFAULT;

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
	public String getProfileUri() {
		return profileUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileUri(String newProfileUri) {
		String oldProfileUri = profileUri;
		profileUri = newProfileUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__PROFILE_URI, oldProfileUri, profileUri));
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__PROFILE_URI:
				return getProfileUri();
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__PROFILE_URI:
				setProfileUri((String)newValue);
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__PROFILE_URI:
				setProfileUri(PROFILE_URI_EDEFAULT);
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__PROFILE_URI:
				return PROFILE_URI_EDEFAULT == null ? profileUri != null : !PROFILE_URI_EDEFAULT.equals(profileUri);
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
		result.append(", profileUri: ");
		result.append(profileUri);
		result.append(')');
		return result.toString();
	}

} //StereotypeApplicationMatcherConfigurationImpl
