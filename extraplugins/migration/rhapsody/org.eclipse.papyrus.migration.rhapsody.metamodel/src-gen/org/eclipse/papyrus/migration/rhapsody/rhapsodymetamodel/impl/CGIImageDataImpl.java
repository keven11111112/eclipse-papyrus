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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImageData;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Image Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageDataImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageDataImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageDataImpl#getM_dataSize <em>Mdata Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageDataImpl#getM_data <em>Mdata</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageDataImpl#getM_srcFile <em>Msrc File</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIImageDataImpl#getM_fileModifiedTime <em>Mfile Modified Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIImageDataImpl extends GraphElementsTypeImpl implements CGIImageData {
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
	 * The default value of the '{@link #getM_dataSize() <em>Mdata Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_dataSize()
	 * @generated
	 * @ordered
	 */
	protected static final String MDATA_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_dataSize() <em>Mdata Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_dataSize()
	 * @generated
	 * @ordered
	 */
	protected String m_dataSize = MDATA_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_data() <em>Mdata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_data()
	 * @generated
	 * @ordered
	 */
	protected static final String MDATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_data() <em>Mdata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_data()
	 * @generated
	 * @ordered
	 */
	protected String m_data = MDATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_srcFile() <em>Msrc File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_srcFile()
	 * @generated
	 * @ordered
	 */
	protected static final String MSRC_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_srcFile() <em>Msrc File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_srcFile()
	 * @generated
	 * @ordered
	 */
	protected String m_srcFile = MSRC_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_fileModifiedTime() <em>Mfile Modified Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fileModifiedTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_fileModifiedTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIImageDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIImageData();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getM_pModelObject() {
		if (m_pModelObject == null) {
			m_pModelObject = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.CGI_IMAGE_DATA__MPMODEL_OBJECT);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_IMAGE_DATA__MPPARENT, oldM_pParent, m_pParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_IMAGE_DATA__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_dataSize() {
		return m_dataSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_dataSize(String newM_dataSize) {
		String oldM_dataSize = m_dataSize;
		m_dataSize = newM_dataSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA_SIZE, oldM_dataSize, m_dataSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_data() {
		return m_data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_data(String newM_data) {
		String oldM_data = m_data;
		m_data = newM_data;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA, oldM_data, m_data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_srcFile() {
		return m_srcFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_srcFile(String newM_srcFile) {
		String oldM_srcFile = m_srcFile;
		m_srcFile = newM_srcFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_IMAGE_DATA__MSRC_FILE, oldM_srcFile, m_srcFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_fileModifiedTime() {
		if (m_fileModifiedTime == null) {
			m_fileModifiedTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_IMAGE_DATA__MFILE_MODIFIED_TIME);
		}
		return m_fileModifiedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPMODEL_OBJECT:
				return getM_pModelObject();
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPPARENT:
				if (resolve) return getM_pParent();
				return basicGetM_pParent();
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA_SIZE:
				return getM_dataSize();
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA:
				return getM_data();
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MSRC_FILE:
				return getM_srcFile();
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MFILE_MODIFIED_TIME:
				return getM_fileModifiedTime();
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
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPMODEL_OBJECT:
				getM_pModelObject().clear();
				getM_pModelObject().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPPARENT:
				setM_pParent((GraphElementsType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA_SIZE:
				setM_dataSize((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA:
				setM_data((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MSRC_FILE:
				setM_srcFile((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MFILE_MODIFIED_TIME:
				getM_fileModifiedTime().clear();
				getM_fileModifiedTime().addAll((Collection<? extends String>)newValue);
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
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPMODEL_OBJECT:
				getM_pModelObject().clear();
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPPARENT:
				setM_pParent((GraphElementsType)null);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA_SIZE:
				setM_dataSize(MDATA_SIZE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA:
				setM_data(MDATA_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MSRC_FILE:
				setM_srcFile(MSRC_FILE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MFILE_MODIFIED_TIME:
				getM_fileModifiedTime().clear();
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
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPMODEL_OBJECT:
				return m_pModelObject != null && !m_pModelObject.isEmpty();
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MPPARENT:
				return m_pParent != null;
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA_SIZE:
				return MDATA_SIZE_EDEFAULT == null ? m_dataSize != null : !MDATA_SIZE_EDEFAULT.equals(m_dataSize);
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MDATA:
				return MDATA_EDEFAULT == null ? m_data != null : !MDATA_EDEFAULT.equals(m_data);
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MSRC_FILE:
				return MSRC_FILE_EDEFAULT == null ? m_srcFile != null : !MSRC_FILE_EDEFAULT.equals(m_srcFile);
			case UMLRhapsodyPackage.CGI_IMAGE_DATA__MFILE_MODIFIED_TIME:
				return m_fileModifiedTime != null && !m_fileModifiedTime.isEmpty();
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
		result.append(" (m_dataSize: "); //$NON-NLS-1$
		result.append(m_dataSize);
		result.append(", m_data: "); //$NON-NLS-1$
		result.append(m_data);
		result.append(", m_srcFile: "); //$NON-NLS-1$
		result.append(m_srcFile);
		result.append(", m_fileModifiedTime: "); //$NON-NLS-1$
		result.append(m_fileModifiedTime);
		result.append(')');
		return result.toString();
	}

} //CGIImageDataImpl
