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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.AbstractMatcherConfiguration;
import org.eclipse.papyrus.infra.types.AdviceConfiguration;
import org.eclipse.papyrus.infra.types.ConfigurationElement;
import org.eclipse.papyrus.infra.types.ContainerConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage;
import org.eclipse.papyrus.infra.types.InheritanceKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Advice Binding Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getContainerConfiguration <em>Container Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getMatcherConfiguration <em>Matcher Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.impl.AbstractAdviceBindingConfigurationImpl#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractAdviceBindingConfigurationImpl extends MinimalEObjectImpl.Container implements AbstractAdviceBindingConfiguration {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBefore() <em>Before</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected EList<AdviceConfiguration> before;

	/**
	 * The cached value of the '{@link #getAfter() <em>After</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected EList<AdviceConfiguration> after;

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
	protected AbstractMatcherConfiguration matcherConfiguration;

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
	protected AbstractAdviceBindingConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementTypesConfigurationsPackage.Literals.ABSTRACT_ADVICE_BINDING_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdviceConfiguration> getBefore() {
		if (before == null) {
			before = new EObjectResolvingEList<AdviceConfiguration>(AdviceConfiguration.class, this, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE);
		}
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdviceConfiguration> getAfter() {
		if (after == null) {
			after = new EObjectResolvingEList<AdviceConfiguration>(AdviceConfiguration.class, this, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER);
		}
		return after;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__TARGET, oldTarget, target));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, oldContainerConfiguration, newContainerConfiguration);
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
				msgs = ((InternalEObject)containerConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, null, msgs);
			if (newContainerConfiguration != null)
				msgs = ((InternalEObject)newContainerConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, null, msgs);
			msgs = basicSetContainerConfiguration(newContainerConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION, newContainerConfiguration, newContainerConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMatcherConfiguration getMatcherConfiguration() {
		return matcherConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcherConfiguration(AbstractMatcherConfiguration newMatcherConfiguration, NotificationChain msgs) {
		AbstractMatcherConfiguration oldMatcherConfiguration = matcherConfiguration;
		matcherConfiguration = newMatcherConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, oldMatcherConfiguration, newMatcherConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcherConfiguration(AbstractMatcherConfiguration newMatcherConfiguration) {
		if (newMatcherConfiguration != matcherConfiguration) {
			NotificationChain msgs = null;
			if (matcherConfiguration != null)
				msgs = ((InternalEObject)matcherConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, null, msgs);
			if (newMatcherConfiguration != null)
				msgs = ((InternalEObject)newMatcherConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, null, msgs);
			msgs = basicSetMatcherConfiguration(newMatcherConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION, newMatcherConfiguration, newMatcherConfiguration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__INHERITANCE, oldInheritance, inheritance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				return basicSetContainerConfiguration(null, msgs);
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
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
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__IDENTIFIER:
				return getIdentifier();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION:
				return getDescription();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE:
				return getBefore();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER:
				return getAfter();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				return getContainerConfiguration();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				return getMatcherConfiguration();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__INHERITANCE:
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
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE:
				getBefore().clear();
				getBefore().addAll((Collection<? extends AdviceConfiguration>)newValue);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER:
				getAfter().clear();
				getAfter().addAll((Collection<? extends AdviceConfiguration>)newValue);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__TARGET:
				setTarget((ElementTypeConfiguration)newValue);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				setContainerConfiguration((ContainerConfiguration)newValue);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				setMatcherConfiguration((AbstractMatcherConfiguration)newValue);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__INHERITANCE:
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
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE:
				getBefore().clear();
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER:
				getAfter().clear();
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__TARGET:
				setTarget((ElementTypeConfiguration)null);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				setContainerConfiguration((ContainerConfiguration)null);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				setMatcherConfiguration((AbstractMatcherConfiguration)null);
				return;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__INHERITANCE:
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
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE:
				return before != null && !before.isEmpty();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER:
				return after != null && !after.isEmpty();
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__TARGET:
				return target != null;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION:
				return containerConfiguration != null;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION:
				return matcherConfiguration != null;
			case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__INHERITANCE:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConfigurationElement.class) {
			switch (derivedFeatureID) {
				case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION: return ElementTypesConfigurationsPackage.CONFIGURATION_ELEMENT__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == AdviceConfiguration.class) {
			switch (derivedFeatureID) {
				case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE: return ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__BEFORE;
				case ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER: return ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__AFTER;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ConfigurationElement.class) {
			switch (baseFeatureID) {
				case ElementTypesConfigurationsPackage.CONFIGURATION_ELEMENT__DESCRIPTION: return ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == AdviceConfiguration.class) {
			switch (baseFeatureID) {
				case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__BEFORE: return ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE;
				case ElementTypesConfigurationsPackage.ADVICE_CONFIGURATION__AFTER: return ElementTypesConfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(", description: ");
		result.append(description);
		result.append(", inheritance: ");
		result.append(inheritance);
		result.append(')');
		return result.toString();
	}

} //AbstractAdviceBindingConfigurationImpl
