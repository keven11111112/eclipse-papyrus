/**
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.propertylifecycle.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.propertylifecycle.AbstractTrigger;
import org.eclipse.papyrus.propertylifecycle.AbstractValueProcessor;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl#getFeatureLabel <em>Feature Label</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl#getPriority <em>Priority</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl#getTriggers <em>Triggers</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl#getValueProcessor <em>Value Processor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementPropertyImpl extends MinimalEObjectImpl.Container implements ElementProperty {
	/**
	 * The default value of the '{@link #getFeatureLabel() <em>Feature Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFeatureLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureLabel() <em>Feature Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFeatureLabel()
	 * @generated
	 * @ordered
	 */
	protected String featureLabel = FEATURE_LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PRIORITY_EDEFAULT = new Integer(0);

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected Integer priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTrigger> triggers;

	/**
	 * The cached value of the '{@link #getValueProcessor() <em>Value Processor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getValueProcessor()
	 * @generated
	 * @ordered
	 */
	protected AbstractValueProcessor valueProcessor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ElementPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertylifecyclePackage.Literals.ELEMENT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getFeatureLabel() {
		return featureLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setFeatureLabel(String newFeatureLabel) {
		String oldFeatureLabel = featureLabel;
		featureLabel = newFeatureLabel;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_PROPERTY__FEATURE_LABEL, oldFeatureLabel, featureLabel));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Integer getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setPriority(Integer newPriority) {
		Integer oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_PROPERTY__PRIORITY, oldPriority, priority));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<AbstractTrigger> getTriggers() {
		if (triggers == null) {
			triggers = new EObjectContainmentEList<AbstractTrigger>(AbstractTrigger.class, this, PropertylifecyclePackage.ELEMENT_PROPERTY__TRIGGERS);
		}
		return triggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AbstractValueProcessor getValueProcessor() {
		return valueProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetValueProcessor(AbstractValueProcessor newValueProcessor, NotificationChain msgs) {
		AbstractValueProcessor oldValueProcessor = valueProcessor;
		valueProcessor = newValueProcessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR, oldValueProcessor, newValueProcessor);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setValueProcessor(AbstractValueProcessor newValueProcessor) {
		if (newValueProcessor != valueProcessor) {
			NotificationChain msgs = null;
			if (valueProcessor != null) {
				msgs = ((InternalEObject) valueProcessor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR, null, msgs);
			}
			if (newValueProcessor != null) {
				msgs = ((InternalEObject) newValueProcessor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR, null, msgs);
			}
			msgs = basicSetValueProcessor(newValueProcessor, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR, newValueProcessor, newValueProcessor));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PropertylifecyclePackage.ELEMENT_PROPERTY__TRIGGERS:
			return ((InternalEList<?>) getTriggers()).basicRemove(otherEnd, msgs);
		case PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR:
			return basicSetValueProcessor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PropertylifecyclePackage.ELEMENT_PROPERTY__FEATURE_LABEL:
			return getFeatureLabel();
		case PropertylifecyclePackage.ELEMENT_PROPERTY__PRIORITY:
			return getPriority();
		case PropertylifecyclePackage.ELEMENT_PROPERTY__TRIGGERS:
			return getTriggers();
		case PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR:
			return getValueProcessor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PropertylifecyclePackage.ELEMENT_PROPERTY__FEATURE_LABEL:
			setFeatureLabel((String) newValue);
			return;
		case PropertylifecyclePackage.ELEMENT_PROPERTY__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case PropertylifecyclePackage.ELEMENT_PROPERTY__TRIGGERS:
			getTriggers().clear();
			getTriggers().addAll((Collection<? extends AbstractTrigger>) newValue);
			return;
		case PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR:
			setValueProcessor((AbstractValueProcessor) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PropertylifecyclePackage.ELEMENT_PROPERTY__FEATURE_LABEL:
			setFeatureLabel(FEATURE_LABEL_EDEFAULT);
			return;
		case PropertylifecyclePackage.ELEMENT_PROPERTY__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case PropertylifecyclePackage.ELEMENT_PROPERTY__TRIGGERS:
			getTriggers().clear();
			return;
		case PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR:
			setValueProcessor((AbstractValueProcessor) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PropertylifecyclePackage.ELEMENT_PROPERTY__FEATURE_LABEL:
			return FEATURE_LABEL_EDEFAULT == null ? featureLabel != null : !FEATURE_LABEL_EDEFAULT.equals(featureLabel);
		case PropertylifecyclePackage.ELEMENT_PROPERTY__PRIORITY:
			return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
		case PropertylifecyclePackage.ELEMENT_PROPERTY__TRIGGERS:
			return triggers != null && !triggers.isEmpty();
		case PropertylifecyclePackage.ELEMENT_PROPERTY__VALUE_PROCESSOR:
			return valueProcessor != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (featureLabel: "); //$NON-NLS-1$
		result.append(featureLabel);
		result.append(", priority: "); //$NON-NLS-1$
		result.append(priority);
		result.append(')');
		return result.toString();
	}

} // ElementPropertyImpl
