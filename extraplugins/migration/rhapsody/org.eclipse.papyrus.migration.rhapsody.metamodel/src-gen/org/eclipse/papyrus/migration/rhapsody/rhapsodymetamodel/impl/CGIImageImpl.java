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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImageData;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageImpl#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageImpl#getM_pImageViewData <em>MpImage View Data</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageImpl#getM_points <em>Mpoints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIImageImpl extends GraphElementsTypeImpl implements CGIImage {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> m_pModelObject;

	/**
	 * The cached value of the '{@link #getM_pParent() <em>MpParent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected GraphElementsType m_pParent;

	/**
	 * The cached value of the '{@link #getM_transform() <em>Mtransform</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_transform()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_transform;

	/**
	 * The cached value of the '{@link #getM_pImageViewData() <em>MpImage View Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pImageViewData()
	 * @generated
	 * @ordered
	 */
	protected CGIImageData m_pImageViewData;

	/**
	 * The cached value of the '{@link #getM_points() <em>Mpoints</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_points()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_points;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIImageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIImage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getM_pModelObject() {
		if (m_pModelObject == null) {
			m_pModelObject = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.CGI_IMAGE__MPMODEL_OBJECT);
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphElementsType getM_pParent() {
		if (m_pParent != null && m_pParent.eIsProxy()) {
			InternalEObject oldM_pParent = (InternalEObject)m_pParent;
			m_pParent = (GraphElementsType)eResolveProxy(oldM_pParent);
			if (m_pParent != oldM_pParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_IMAGE__MPPARENT, oldM_pParent, m_pParent));
			}
		}
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphElementsType basicGetM_pParent() {
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pParent(GraphElementsType newM_pParent) {
		GraphElementsType oldM_pParent = m_pParent;
		m_pParent = newM_pParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_IMAGE__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_transform() {
		if (m_transform == null) {
			m_transform = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_IMAGE__MTRANSFORM);
		}
		return m_transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIImageData getM_pImageViewData() {
		if (m_pImageViewData != null && m_pImageViewData.eIsProxy()) {
			InternalEObject oldM_pImageViewData = (InternalEObject)m_pImageViewData;
			m_pImageViewData = (CGIImageData)eResolveProxy(oldM_pImageViewData);
			if (m_pImageViewData != oldM_pImageViewData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_IMAGE__MPIMAGE_VIEW_DATA, oldM_pImageViewData, m_pImageViewData));
			}
		}
		return m_pImageViewData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIImageData basicGetM_pImageViewData() {
		return m_pImageViewData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pImageViewData(CGIImageData newM_pImageViewData) {
		CGIImageData oldM_pImageViewData = m_pImageViewData;
		m_pImageViewData = newM_pImageViewData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_IMAGE__MPIMAGE_VIEW_DATA, oldM_pImageViewData, m_pImageViewData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_points() {
		if (m_points == null) {
			m_points = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_IMAGE__MPOINTS);
		}
		return m_points;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_IMAGE__MPMODEL_OBJECT:
				return getM_pModelObject();
			case UMLRhapsodyPackage.CGI_IMAGE__MPPARENT:
				if (resolve) return getM_pParent();
				return basicGetM_pParent();
			case UMLRhapsodyPackage.CGI_IMAGE__MTRANSFORM:
				return getM_transform();
			case UMLRhapsodyPackage.CGI_IMAGE__MPIMAGE_VIEW_DATA:
				if (resolve) return getM_pImageViewData();
				return basicGetM_pImageViewData();
			case UMLRhapsodyPackage.CGI_IMAGE__MPOINTS:
				return getM_points();
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
			case UMLRhapsodyPackage.CGI_IMAGE__MPMODEL_OBJECT:
				getM_pModelObject().clear();
				getM_pModelObject().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MPPARENT:
				setM_pParent((GraphElementsType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MTRANSFORM:
				getM_transform().clear();
				getM_transform().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MPIMAGE_VIEW_DATA:
				setM_pImageViewData((CGIImageData)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MPOINTS:
				getM_points().clear();
				getM_points().addAll((Collection<? extends String>)newValue);
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
			case UMLRhapsodyPackage.CGI_IMAGE__MPMODEL_OBJECT:
				getM_pModelObject().clear();
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MPPARENT:
				setM_pParent((GraphElementsType)null);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MTRANSFORM:
				getM_transform().clear();
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MPIMAGE_VIEW_DATA:
				setM_pImageViewData((CGIImageData)null);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE__MPOINTS:
				getM_points().clear();
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
			case UMLRhapsodyPackage.CGI_IMAGE__MPMODEL_OBJECT:
				return m_pModelObject != null && !m_pModelObject.isEmpty();
			case UMLRhapsodyPackage.CGI_IMAGE__MPPARENT:
				return m_pParent != null;
			case UMLRhapsodyPackage.CGI_IMAGE__MTRANSFORM:
				return m_transform != null && !m_transform.isEmpty();
			case UMLRhapsodyPackage.CGI_IMAGE__MPIMAGE_VIEW_DATA:
				return m_pImageViewData != null;
			case UMLRhapsodyPackage.CGI_IMAGE__MPOINTS:
				return m_points != null && !m_points.isEmpty();
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
		result.append(" (m_transform: "); //$NON-NLS-1$
		result.append(m_transform);
		result.append(", m_points: "); //$NON-NLS-1$
		result.append(m_points);
		result.append(')');
		return result.toString();
	}

} //CGIImageImpl
