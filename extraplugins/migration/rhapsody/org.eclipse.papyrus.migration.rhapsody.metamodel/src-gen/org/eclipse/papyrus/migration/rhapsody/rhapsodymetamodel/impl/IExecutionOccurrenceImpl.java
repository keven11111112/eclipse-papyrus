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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IExecutionOccurrence;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IExecution Occurrence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IExecutionOccurrenceImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IExecutionOccurrenceImpl#getM_startMessage <em>Mstart Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IExecutionOccurrenceImpl#getM_endMessage <em>Mend Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IExecutionOccurrenceImpl#getM_length <em>Mlength</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IExecutionOccurrenceImpl extends IModelElementImpl implements IExecutionOccurrence {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_startMessage() <em>Mstart Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_startMessage()
	 * @generated
	 * @ordered
	 */
	protected IMessage m_startMessage;

	/**
	 * The cached value of the '{@link #getM_endMessage() <em>Mend Message</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_endMessage()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> m_endMessage;

	/**
	 * The default value of the '{@link #getM_length() <em>Mlength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_length()
	 * @generated
	 * @ordered
	 */
	protected static final String MLENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_length() <em>Mlength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_length()
	 * @generated
	 * @ordered
	 */
	protected String m_length = MLENGTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IExecutionOccurrenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIExecutionOccurrence();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMessage getM_startMessage() {
		if (m_startMessage != null && m_startMessage.eIsProxy()) {
			InternalEObject oldM_startMessage = (InternalEObject)m_startMessage;
			m_startMessage = (IMessage)eResolveProxy(oldM_startMessage);
			if (m_startMessage != oldM_startMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MSTART_MESSAGE, oldM_startMessage, m_startMessage));
			}
		}
		return m_startMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMessage basicGetM_startMessage() {
		return m_startMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_startMessage(IMessage newM_startMessage) {
		IMessage oldM_startMessage = m_startMessage;
		m_startMessage = newM_startMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MSTART_MESSAGE, oldM_startMessage, m_startMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getM_endMessage() {
		if (m_endMessage == null) {
			m_endMessage = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MEND_MESSAGE);
		}
		return m_endMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_length() {
		return m_length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_length(String newM_length) {
		String oldM_length = m_length;
		m_length = newM_length;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MLENGTH, oldM_length, m_length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__ID:
				return getId();
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MSTART_MESSAGE:
				if (resolve) return getM_startMessage();
				return basicGetM_startMessage();
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MEND_MESSAGE:
				return getM_endMessage();
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MLENGTH:
				return getM_length();
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
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MSTART_MESSAGE:
				setM_startMessage((IMessage)newValue);
				return;
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MEND_MESSAGE:
				getM_endMessage().clear();
				getM_endMessage().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MLENGTH:
				setM_length((String)newValue);
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
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MSTART_MESSAGE:
				setM_startMessage((IMessage)null);
				return;
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MEND_MESSAGE:
				getM_endMessage().clear();
				return;
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MLENGTH:
				setM_length(MLENGTH_EDEFAULT);
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
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MSTART_MESSAGE:
				return m_startMessage != null;
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MEND_MESSAGE:
				return m_endMessage != null && !m_endMessage.isEmpty();
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE__MLENGTH:
				return MLENGTH_EDEFAULT == null ? m_length != null : !MLENGTH_EDEFAULT.equals(m_length);
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
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", m_length: "); //$NON-NLS-1$
		result.append(m_length);
		result.append(')');
		return result.toString();
	}

} //IExecutionOccurrenceImpl
