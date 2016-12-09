/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConnector;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPin;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IPin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPinImpl#getM_type <em>Mtype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPinImpl#getM_isParameterPin <em>Mis Parameter Pin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPinImpl#getM_corePin <em>Mcore Pin</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IPinImpl extends IConnectorImpl implements IPin {
	/**
	 * The cached value of the '{@link #getM_type() <em>Mtype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_type()
	 * @generated
	 * @ordered
	 */
	protected IClassifier m_type;

	/**
	 * The default value of the '{@link #getM_isParameterPin() <em>Mis Parameter Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_isParameterPin()
	 * @generated
	 * @ordered
	 */
	protected static final String MIS_PARAMETER_PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_isParameterPin() <em>Mis Parameter Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_isParameterPin()
	 * @generated
	 * @ordered
	 */
	protected String m_isParameterPin = MIS_PARAMETER_PIN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_corePin() <em>Mcore Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_corePin()
	 * @generated
	 * @ordered
	 */
	protected IConnector m_corePin;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IPinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIPin();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier getM_type() {
		if (m_type != null && m_type.eIsProxy()) {
			InternalEObject oldM_type = (InternalEObject)m_type;
			m_type = (IClassifier)eResolveProxy(oldM_type);
			if (m_type != oldM_type) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPIN__MTYPE, oldM_type, m_type));
			}
		}
		return m_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier basicGetM_type() {
		return m_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_type(IClassifier newM_type) {
		IClassifier oldM_type = m_type;
		m_type = newM_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPIN__MTYPE, oldM_type, m_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_isParameterPin() {
		return m_isParameterPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_isParameterPin(String newM_isParameterPin) {
		String oldM_isParameterPin = m_isParameterPin;
		m_isParameterPin = newM_isParameterPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPIN__MIS_PARAMETER_PIN, oldM_isParameterPin, m_isParameterPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConnector getM_corePin() {
		if (m_corePin != null && m_corePin.eIsProxy()) {
			InternalEObject oldM_corePin = (InternalEObject)m_corePin;
			m_corePin = (IConnector)eResolveProxy(oldM_corePin);
			if (m_corePin != oldM_corePin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPIN__MCORE_PIN, oldM_corePin, m_corePin));
			}
		}
		return m_corePin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConnector basicGetM_corePin() {
		return m_corePin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_corePin(IConnector newM_corePin) {
		IConnector oldM_corePin = m_corePin;
		m_corePin = newM_corePin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPIN__MCORE_PIN, oldM_corePin, m_corePin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IPIN__MTYPE:
				if (resolve) return getM_type();
				return basicGetM_type();
			case UMLRhapsodyPackage.IPIN__MIS_PARAMETER_PIN:
				return getM_isParameterPin();
			case UMLRhapsodyPackage.IPIN__MCORE_PIN:
				if (resolve) return getM_corePin();
				return basicGetM_corePin();
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
			case UMLRhapsodyPackage.IPIN__MTYPE:
				setM_type((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IPIN__MIS_PARAMETER_PIN:
				setM_isParameterPin((String)newValue);
				return;
			case UMLRhapsodyPackage.IPIN__MCORE_PIN:
				setM_corePin((IConnector)newValue);
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
			case UMLRhapsodyPackage.IPIN__MTYPE:
				setM_type((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IPIN__MIS_PARAMETER_PIN:
				setM_isParameterPin(MIS_PARAMETER_PIN_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPIN__MCORE_PIN:
				setM_corePin((IConnector)null);
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
			case UMLRhapsodyPackage.IPIN__MTYPE:
				return m_type != null;
			case UMLRhapsodyPackage.IPIN__MIS_PARAMETER_PIN:
				return MIS_PARAMETER_PIN_EDEFAULT == null ? m_isParameterPin != null : !MIS_PARAMETER_PIN_EDEFAULT.equals(m_isParameterPin);
			case UMLRhapsodyPackage.IPIN__MCORE_PIN:
				return m_corePin != null;
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
		result.append(" (m_isParameterPin: "); //$NON-NLS-1$
		result.append(m_isParameterPin);
		result.append(')');
		return result.toString();
	}

} //IPinImpl
