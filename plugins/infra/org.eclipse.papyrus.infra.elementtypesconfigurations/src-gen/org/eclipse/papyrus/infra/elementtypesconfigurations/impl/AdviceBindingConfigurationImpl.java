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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advice Binding Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl#getContainerConfiguration <em>Container Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl#getMatcherConfiguration <em>Matcher Configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdviceBindingConfigurationImpl extends AdviceConfigurationImpl implements AdviceBindingConfiguration {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ElementTypeConfiguration target;

	/**
	 * The cached value of the '{@link #getContainerConfiguration() <em>Container Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ContainerConfiguration containerConfiguration;

	/**
	 * The cached value of the '{@link #getMatcherConfiguration() <em>Matcher Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcherConfiguration()
	 * @generated
	 * @ordered
	 */
	protected MatcherConfiguration matcherConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdviceBindingConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementtypesconfigurationsPackage.Literals.ADVICE_BINDING_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTypeConfiguration getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ElementTypeConfiguration)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTypeConfiguration basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ElementTypeConfiguration newTarget) {
		ElementTypeConfiguration oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerConfiguration getContainerConfiguration() {
		return containerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerConfiguration(ContainerConfiguration newContainerConfiguration, NotificationChain msgs) {
		ContainerConfiguration oldContainerConfiguration = containerConfiguration;
		containerConfiguration = newContainerConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, oldContainerConfiguration, newContainerConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerConfiguration(ContainerConfiguration newContainerConfiguration) {
		if (newContainerConfiguration != containerConfiguration) {
			NotificationChain msgs = null;
			if (containerConfiguration != null)
				msgs = ((InternalEObject)containerConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, null, msgs);
			if (newContainerConfiguration != null)
				msgs = ((InternalEObject)newContainerConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, null, msgs);
			msgs = basicSetContainerConfiguration(newContainerConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, newContainerConfiguration, newContainerConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatcherConfiguration getMatcherConfiguration() {
		return matcherConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcherConfiguration(MatcherConfiguration newMatcherConfiguration, NotificationChain msgs) {
		MatcherConfiguration oldMatcherConfiguration = matcherConfiguration;
		matcherConfiguration = newMatcherConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, oldMatcherConfiguration, newMatcherConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcherConfiguration(MatcherConfiguration newMatcherConfiguration) {
		if (newMatcherConfiguration != matcherConfiguration) {
			NotificationChain msgs = null;
			if (matcherConfiguration != null)
				msgs = ((InternalEObject)matcherConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, null, msgs);
			if (newMatcherConfiguration != null)
				msgs = ((InternalEObject)newMatcherConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, null, msgs);
			msgs = basicSetMatcherConfiguration(newMatcherConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, newMatcherConfiguration, newMatcherConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				return basicSetContainerConfiguration(null, msgs);
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				return basicSetMatcherConfiguration(null, msgs);
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
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				return getContainerConfiguration();
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				return getMatcherConfiguration();
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
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__TARGET:
				setTarget((ElementTypeConfiguration)newValue);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				setContainerConfiguration((ContainerConfiguration)newValue);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				setMatcherConfiguration((MatcherConfiguration)newValue);
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
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__TARGET:
				setTarget((ElementTypeConfiguration)null);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				setContainerConfiguration((ContainerConfiguration)null);
				return;
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				setMatcherConfiguration((MatcherConfiguration)null);
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
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__TARGET:
				return target != null;
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				return containerConfiguration != null;
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				return matcherConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //AdviceBindingConfigurationImpl
