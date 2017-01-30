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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEnd;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IAssociation Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationClassImpl#getIsClass <em>Is Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationClassImpl#getM_end1 <em>Mend1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationClassImpl#getM_end2 <em>Mend2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IAssociationClassImpl extends IClassImpl implements IAssociationClass {
	/**
	 * The default value of the '{@link #getIsClass() <em>Is Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsClass()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_CLASS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getIsClass() <em>Is Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsClass()
	 * @generated
	 * @ordered
	 */
	protected String isClass = IS_CLASS_EDEFAULT;
	/**
	 * The cached value of the '{@link #getM_end1() <em>Mend1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_end1()
	 * @generated
	 * @ordered
	 */
	protected IAssociationEnd m_end1;
	/**
	 * The cached value of the '{@link #getM_end2() <em>Mend2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_end2()
	 * @generated
	 * @ordered
	 */
	protected IAssociationEnd m_end2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAssociationClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIAssociationClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsClass() {
		return isClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsClass(String newIsClass) {
		String oldIsClass = isClass;
		isClass = newIsClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_CLASS__IS_CLASS, oldIsClass, isClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEnd getM_end1() {
		if (m_end1 != null && m_end1.eIsProxy()) {
			InternalEObject oldM_end1 = (InternalEObject)m_end1;
			m_end1 = (IAssociationEnd)eResolveProxy(oldM_end1);
			if (m_end1 != oldM_end1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND1, oldM_end1, m_end1));
			}
		}
		return m_end1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEnd basicGetM_end1() {
		return m_end1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_end1(IAssociationEnd newM_end1) {
		IAssociationEnd oldM_end1 = m_end1;
		m_end1 = newM_end1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND1, oldM_end1, m_end1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEnd getM_end2() {
		if (m_end2 != null && m_end2.eIsProxy()) {
			InternalEObject oldM_end2 = (InternalEObject)m_end2;
			m_end2 = (IAssociationEnd)eResolveProxy(oldM_end2);
			if (m_end2 != oldM_end2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND2, oldM_end2, m_end2));
			}
		}
		return m_end2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEnd basicGetM_end2() {
		return m_end2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_end2(IAssociationEnd newM_end2) {
		IAssociationEnd oldM_end2 = m_end2;
		m_end2 = newM_end2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND2, oldM_end2, m_end2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__IS_CLASS:
				return getIsClass();
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND1:
				if (resolve) return getM_end1();
				return basicGetM_end1();
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND2:
				if (resolve) return getM_end2();
				return basicGetM_end2();
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
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__IS_CLASS:
				setIsClass((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND1:
				setM_end1((IAssociationEnd)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND2:
				setM_end2((IAssociationEnd)newValue);
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
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__IS_CLASS:
				setIsClass(IS_CLASS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND1:
				setM_end1((IAssociationEnd)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND2:
				setM_end2((IAssociationEnd)null);
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
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__IS_CLASS:
				return IS_CLASS_EDEFAULT == null ? isClass != null : !IS_CLASS_EDEFAULT.equals(isClass);
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND1:
				return m_end1 != null;
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__MEND2:
				return m_end2 != null;
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
		result.append(" (isClass: "); //$NON-NLS-1$
		result.append(isClass);
		result.append(')');
		return result.toString();
	}

} //IAssociationClassImpl
