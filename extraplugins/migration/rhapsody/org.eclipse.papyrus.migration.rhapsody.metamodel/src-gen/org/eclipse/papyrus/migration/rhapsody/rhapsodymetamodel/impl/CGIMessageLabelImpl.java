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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationRole;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Message Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMessageLabelImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMessageLabelImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMessageLabelImpl#getM_pCommunicationConnection <em>MpCommunication Connection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMessageLabelImpl#getPercent <em>Percent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIMessageLabelImpl extends GraphElementsTypeImpl implements CGIMessageLabel {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected IMessage m_pModelObject;

	/**
	 * The default value of the '{@link #getM_pParent() <em>MpParent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected static final String MPPARENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_pParent() <em>MpParent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected String m_pParent = MPPARENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pCommunicationConnection() <em>MpCommunication Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pCommunicationConnection()
	 * @generated
	 * @ordered
	 */
	protected CGIAssociationRole m_pCommunicationConnection;

	/**
	 * The default value of the '{@link #getPercent() <em>Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercent()
	 * @generated
	 * @ordered
	 */
	protected static final String PERCENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPercent() <em>Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercent()
	 * @generated
	 * @ordered
	 */
	protected String percent = PERCENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIMessageLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIMessageLabel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMessage getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (IMessage)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMessage basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(IMessage newM_pModelObject) {
		IMessage oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_pParent() {
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pParent(String newM_pParent) {
		String oldM_pParent = m_pParent;
		m_pParent = newM_pParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIAssociationRole getM_pCommunicationConnection() {
		if (m_pCommunicationConnection != null && m_pCommunicationConnection.eIsProxy()) {
			InternalEObject oldM_pCommunicationConnection = (InternalEObject)m_pCommunicationConnection;
			m_pCommunicationConnection = (CGIAssociationRole)eResolveProxy(oldM_pCommunicationConnection);
			if (m_pCommunicationConnection != oldM_pCommunicationConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPCOMMUNICATION_CONNECTION, oldM_pCommunicationConnection, m_pCommunicationConnection));
			}
		}
		return m_pCommunicationConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIAssociationRole basicGetM_pCommunicationConnection() {
		return m_pCommunicationConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pCommunicationConnection(CGIAssociationRole newM_pCommunicationConnection) {
		CGIAssociationRole oldM_pCommunicationConnection = m_pCommunicationConnection;
		m_pCommunicationConnection = newM_pCommunicationConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPCOMMUNICATION_CONNECTION, oldM_pCommunicationConnection, m_pCommunicationConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPercent() {
		return percent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercent(String newPercent) {
		String oldPercent = percent;
		percent = newPercent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MESSAGE_LABEL__PERCENT, oldPercent, percent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPPARENT:
				return getM_pParent();
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPCOMMUNICATION_CONNECTION:
				if (resolve) return getM_pCommunicationConnection();
				return basicGetM_pCommunicationConnection();
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__PERCENT:
				return getPercent();
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
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPMODEL_OBJECT:
				setM_pModelObject((IMessage)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPPARENT:
				setM_pParent((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPCOMMUNICATION_CONNECTION:
				setM_pCommunicationConnection((CGIAssociationRole)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__PERCENT:
				setPercent((String)newValue);
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
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPMODEL_OBJECT:
				setM_pModelObject((IMessage)null);
				return;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPPARENT:
				setM_pParent(MPPARENT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPCOMMUNICATION_CONNECTION:
				setM_pCommunicationConnection((CGIAssociationRole)null);
				return;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__PERCENT:
				setPercent(PERCENT_EDEFAULT);
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
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPPARENT:
				return MPPARENT_EDEFAULT == null ? m_pParent != null : !MPPARENT_EDEFAULT.equals(m_pParent);
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__MPCOMMUNICATION_CONNECTION:
				return m_pCommunicationConnection != null;
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL__PERCENT:
				return PERCENT_EDEFAULT == null ? percent != null : !PERCENT_EDEFAULT.equals(percent);
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
		result.append(" (m_pParent: "); //$NON-NLS-1$
		result.append(m_pParent);
		result.append(", percent: "); //$NON-NLS-1$
		result.append(percent);
		result.append(')');
		return result.toString();
	}

} //CGIMessageLabelImpl
