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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CCollaborationChart;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIBox;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaboration;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CCollaboration Chart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CCollaborationChartImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CCollaborationChartImpl#getM_pRoot <em>MpRoot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CCollaborationChartImpl extends GraphicChartTypeImpl implements CCollaborationChart {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected ICollaboration m_pModelObject;

	/**
	 * The cached value of the '{@link #getM_pRoot() <em>MpRoot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pRoot()
	 * @generated
	 * @ordered
	 */
	protected CGIBox m_pRoot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CCollaborationChartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCCollaborationChart();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICollaboration getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (ICollaboration)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CCOLLABORATION_CHART__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICollaboration basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(ICollaboration newM_pModelObject) {
		ICollaboration oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CCOLLABORATION_CHART__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIBox getM_pRoot() {
		if (m_pRoot != null && m_pRoot.eIsProxy()) {
			InternalEObject oldM_pRoot = (InternalEObject)m_pRoot;
			m_pRoot = (CGIBox)eResolveProxy(oldM_pRoot);
			if (m_pRoot != oldM_pRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CCOLLABORATION_CHART__MPROOT, oldM_pRoot, m_pRoot));
			}
		}
		return m_pRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIBox basicGetM_pRoot() {
		return m_pRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pRoot(CGIBox newM_pRoot) {
		CGIBox oldM_pRoot = m_pRoot;
		m_pRoot = newM_pRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CCOLLABORATION_CHART__MPROOT, oldM_pRoot, m_pRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPROOT:
				if (resolve) return getM_pRoot();
				return basicGetM_pRoot();
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
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPMODEL_OBJECT:
				setM_pModelObject((ICollaboration)newValue);
				return;
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPROOT:
				setM_pRoot((CGIBox)newValue);
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
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPMODEL_OBJECT:
				setM_pModelObject((ICollaboration)null);
				return;
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPROOT:
				setM_pRoot((CGIBox)null);
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
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CCOLLABORATION_CHART__MPROOT:
				return m_pRoot != null;
		}
		return super.eIsSet(featureID);
	}

} //CCollaborationChartImpl
