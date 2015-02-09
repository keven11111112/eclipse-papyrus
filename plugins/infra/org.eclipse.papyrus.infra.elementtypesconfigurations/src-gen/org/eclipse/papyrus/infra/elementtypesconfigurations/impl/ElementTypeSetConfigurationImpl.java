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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>elementType Set Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl#getElementTypeConfigurations <em>Element Type Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl#getAdviceBindingsConfigurations <em>Advice Bindings Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl#getMetamodelNsURI <em>Metamodel Ns URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementTypeSetConfigurationImpl extends ConfigurationElementImpl implements ElementTypeSetConfiguration {
	/**
	 * The cached value of the '{@link #getElementTypeConfigurations() <em>Element Type Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementTypeConfiguration> elementTypeConfigurations;

	/**
	 * The cached value of the '{@link #getAdviceBindingsConfigurations() <em>Advice Bindings Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceBindingsConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<AdviceBindingConfiguration> adviceBindingsConfigurations;

	/**
	 * The default value of the '{@link #getMetamodelNsURI() <em>Metamodel Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetamodelNsURI() <em>Metamodel Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelNsURI()
	 * @generated
	 * @ordered
	 */
	protected String metamodelNsURI = METAMODEL_NS_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementTypeSetConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementtypesconfigurationsPackage.Literals.ELEMENT_TYPE_SET_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementTypeConfiguration> getElementTypeConfigurations() {
		if (elementTypeConfigurations == null) {
			elementTypeConfigurations = new EObjectContainmentEList<ElementTypeConfiguration>(ElementTypeConfiguration.class, this, ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS);
		}
		return elementTypeConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdviceBindingConfiguration> getAdviceBindingsConfigurations() {
		if (adviceBindingsConfigurations == null) {
			adviceBindingsConfigurations = new EObjectContainmentEList<AdviceBindingConfiguration>(AdviceBindingConfiguration.class, this, ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS);
		}
		return adviceBindingsConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetamodelNsURI() {
		return metamodelNsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodelNsURI(String newMetamodelNsURI) {
		String oldMetamodelNsURI = metamodelNsURI;
		metamodelNsURI = newMetamodelNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI, oldMetamodelNsURI, metamodelNsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS:
				return ((InternalEList<?>)getElementTypeConfigurations()).basicRemove(otherEnd, msgs);
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS:
				return ((InternalEList<?>)getAdviceBindingsConfigurations()).basicRemove(otherEnd, msgs);
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS:
				return getElementTypeConfigurations();
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS:
				return getAdviceBindingsConfigurations();
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI:
				return getMetamodelNsURI();
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS:
				getElementTypeConfigurations().clear();
				getElementTypeConfigurations().addAll((Collection<? extends ElementTypeConfiguration>)newValue);
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS:
				getAdviceBindingsConfigurations().clear();
				getAdviceBindingsConfigurations().addAll((Collection<? extends AdviceBindingConfiguration>)newValue);
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI:
				setMetamodelNsURI((String)newValue);
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS:
				getElementTypeConfigurations().clear();
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS:
				getAdviceBindingsConfigurations().clear();
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI:
				setMetamodelNsURI(METAMODEL_NS_URI_EDEFAULT);
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS:
				return elementTypeConfigurations != null && !elementTypeConfigurations.isEmpty();
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS:
				return adviceBindingsConfigurations != null && !adviceBindingsConfigurations.isEmpty();
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI:
				return METAMODEL_NS_URI_EDEFAULT == null ? metamodelNsURI != null : !METAMODEL_NS_URI_EDEFAULT.equals(metamodelNsURI);
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
		result.append(" (metamodelNsURI: ");
		result.append(metamodelNsURI);
		result.append(')');
		return result.toString();
	}

} //ElementTypeSetConfigurationImpl
