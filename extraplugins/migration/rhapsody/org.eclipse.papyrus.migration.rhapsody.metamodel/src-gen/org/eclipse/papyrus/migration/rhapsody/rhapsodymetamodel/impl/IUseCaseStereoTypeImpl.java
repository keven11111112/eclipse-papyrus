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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCase;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCaseStereoType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IUse Case Stereo Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseStereoTypeImpl#getUseCase <em>Use Case</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseStereoTypeImpl#getStereoType <em>Stereo Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseStereoTypeImpl#getEntryPoint <em>Entry Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IUseCaseStereoTypeImpl extends MinimalEObjectImpl.Container implements IUseCaseStereoType {
	/**
	 * The cached value of the '{@link #getUseCase() <em>Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCase()
	 * @generated
	 * @ordered
	 */
	protected IUseCase useCase;

	/**
	 * The default value of the '{@link #getStereoType() <em>Stereo Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereoType()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREO_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereoType() <em>Stereo Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereoType()
	 * @generated
	 * @ordered
	 */
	protected String stereoType = STEREO_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntryPoint() <em>Entry Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPoint()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryPoint() <em>Entry Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPoint()
	 * @generated
	 * @ordered
	 */
	protected String entryPoint = ENTRY_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IUseCaseStereoTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIUseCaseStereoType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUseCase getUseCase() {
		if (useCase != null && useCase.eIsProxy()) {
			InternalEObject oldUseCase = (InternalEObject)useCase;
			useCase = (IUseCase)eResolveProxy(oldUseCase);
			if (useCase != oldUseCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__USE_CASE, oldUseCase, useCase));
			}
		}
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUseCase basicGetUseCase() {
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCase(IUseCase newUseCase) {
		IUseCase oldUseCase = useCase;
		useCase = newUseCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__USE_CASE, oldUseCase, useCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereoType() {
		return stereoType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereoType(String newStereoType) {
		String oldStereoType = stereoType;
		stereoType = newStereoType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__STEREO_TYPE, oldStereoType, stereoType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryPoint() {
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryPoint(String newEntryPoint) {
		String oldEntryPoint = entryPoint;
		entryPoint = newEntryPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__ENTRY_POINT, oldEntryPoint, entryPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__USE_CASE:
				if (resolve) return getUseCase();
				return basicGetUseCase();
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__STEREO_TYPE:
				return getStereoType();
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__ENTRY_POINT:
				return getEntryPoint();
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
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__USE_CASE:
				setUseCase((IUseCase)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__STEREO_TYPE:
				setStereoType((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__ENTRY_POINT:
				setEntryPoint((String)newValue);
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
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__USE_CASE:
				setUseCase((IUseCase)null);
				return;
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__STEREO_TYPE:
				setStereoType(STEREO_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__ENTRY_POINT:
				setEntryPoint(ENTRY_POINT_EDEFAULT);
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
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__USE_CASE:
				return useCase != null;
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__STEREO_TYPE:
				return STEREO_TYPE_EDEFAULT == null ? stereoType != null : !STEREO_TYPE_EDEFAULT.equals(stereoType);
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE__ENTRY_POINT:
				return ENTRY_POINT_EDEFAULT == null ? entryPoint != null : !ENTRY_POINT_EDEFAULT.equals(entryPoint);
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
		result.append(" (stereoType: "); //$NON-NLS-1$
		result.append(stereoType);
		result.append(", entryPoint: "); //$NON-NLS-1$
		result.append(entryPoint);
		result.append(')');
		return result.toString();
	}

} //IUseCaseStereoTypeImpl
