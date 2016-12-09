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

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IColor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IColor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IColorImpl#getM_fgColor <em>Mfg Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IColorImpl#getM_bgColor <em>Mbg Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IColorImpl#getM_bgFlag <em>Mbg Flag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IColorImpl extends MinimalEObjectImpl.Container implements IColor {
	/**
	 * The default value of the '{@link #getM_fgColor() <em>Mfg Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fgColor()
	 * @generated
	 * @ordered
	 */
	protected static final String MFG_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_fgColor() <em>Mfg Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fgColor()
	 * @generated
	 * @ordered
	 */
	protected String m_fgColor = MFG_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bgColor() <em>Mbg Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bgColor()
	 * @generated
	 * @ordered
	 */
	protected static final String MBG_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bgColor() <em>Mbg Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bgColor()
	 * @generated
	 * @ordered
	 */
	protected String m_bgColor = MBG_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bgFlag() <em>Mbg Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bgFlag()
	 * @generated
	 * @ordered
	 */
	protected static final String MBG_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bgFlag() <em>Mbg Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bgFlag()
	 * @generated
	 * @ordered
	 */
	protected String m_bgFlag = MBG_FLAG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IColorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIColor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_fgColor() {
		return m_fgColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_fgColor(String newM_fgColor) {
		String oldM_fgColor = m_fgColor;
		m_fgColor = newM_fgColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLOR__MFG_COLOR, oldM_fgColor, m_fgColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bgColor() {
		return m_bgColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bgColor(String newM_bgColor) {
		String oldM_bgColor = m_bgColor;
		m_bgColor = newM_bgColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLOR__MBG_COLOR, oldM_bgColor, m_bgColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bgFlag() {
		return m_bgFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bgFlag(String newM_bgFlag) {
		String oldM_bgFlag = m_bgFlag;
		m_bgFlag = newM_bgFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLOR__MBG_FLAG, oldM_bgFlag, m_bgFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICOLOR__MFG_COLOR:
				return getM_fgColor();
			case UMLRhapsodyPackage.ICOLOR__MBG_COLOR:
				return getM_bgColor();
			case UMLRhapsodyPackage.ICOLOR__MBG_FLAG:
				return getM_bgFlag();
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
			case UMLRhapsodyPackage.ICOLOR__MFG_COLOR:
				setM_fgColor((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOLOR__MBG_COLOR:
				setM_bgColor((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOLOR__MBG_FLAG:
				setM_bgFlag((String)newValue);
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
			case UMLRhapsodyPackage.ICOLOR__MFG_COLOR:
				setM_fgColor(MFG_COLOR_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOLOR__MBG_COLOR:
				setM_bgColor(MBG_COLOR_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOLOR__MBG_FLAG:
				setM_bgFlag(MBG_FLAG_EDEFAULT);
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
			case UMLRhapsodyPackage.ICOLOR__MFG_COLOR:
				return MFG_COLOR_EDEFAULT == null ? m_fgColor != null : !MFG_COLOR_EDEFAULT.equals(m_fgColor);
			case UMLRhapsodyPackage.ICOLOR__MBG_COLOR:
				return MBG_COLOR_EDEFAULT == null ? m_bgColor != null : !MBG_COLOR_EDEFAULT.equals(m_bgColor);
			case UMLRhapsodyPackage.ICOLOR__MBG_FLAG:
				return MBG_FLAG_EDEFAULT == null ? m_bgFlag != null : !MBG_FLAG_EDEFAULT.equals(m_bgFlag);
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
		result.append(" (m_fgColor: "); //$NON-NLS-1$
		result.append(m_fgColor);
		result.append(", m_bgColor: "); //$NON-NLS-1$
		result.append(m_bgColor);
		result.append(", m_bgFlag: "); //$NON-NLS-1$
		result.append(m_bgFlag);
		result.append(')');
		return result.toString();
	}

} //IColorImpl
