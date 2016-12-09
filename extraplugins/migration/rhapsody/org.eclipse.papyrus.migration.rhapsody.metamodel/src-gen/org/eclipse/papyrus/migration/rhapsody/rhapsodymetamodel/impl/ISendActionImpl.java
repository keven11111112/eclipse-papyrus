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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEventHandle;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHandleWithData;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_hTargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ISend Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISendActionImpl#getM_hTarget <em>MhTarget</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISendActionImpl#getM_hEvent <em>MhEvent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISendActionImpl#getArgValCount <em>Arg Val Count</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISendActionImpl#getGraphElements <em>Graph Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ISendActionImpl extends IActionImpl implements ISendAction {
	/**
	 * The cached value of the '{@link #getM_hTarget() <em>MhTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_hTarget()
	 * @generated
	 * @ordered
	 */
	protected M_hTargetType m_hTarget;

	/**
	 * The cached value of the '{@link #getM_hEvent() <em>MhEvent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_hEvent()
	 * @generated
	 * @ordered
	 */
	protected IEventHandle m_hEvent;

	/**
	 * The default value of the '{@link #getArgValCount() <em>Arg Val Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgValCount()
	 * @generated
	 * @ordered
	 */
	protected static final String ARG_VAL_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgValCount() <em>Arg Val Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgValCount()
	 * @generated
	 * @ordered
	 */
	protected String argValCount = ARG_VAL_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphElements() <em>Graph Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphElements()
	 * @generated
	 * @ordered
	 */
	protected EList<IHandleWithData> graphElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISendActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getISendAction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_hTargetType getM_hTarget() {
		if (m_hTarget != null && m_hTarget.eIsProxy()) {
			InternalEObject oldM_hTarget = (InternalEObject)m_hTarget;
			m_hTarget = (M_hTargetType)eResolveProxy(oldM_hTarget);
			if (m_hTarget != oldM_hTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISEND_ACTION__MHTARGET, oldM_hTarget, m_hTarget));
			}
		}
		return m_hTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_hTargetType basicGetM_hTarget() {
		return m_hTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_hTarget(M_hTargetType newM_hTarget) {
		M_hTargetType oldM_hTarget = m_hTarget;
		m_hTarget = newM_hTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISEND_ACTION__MHTARGET, oldM_hTarget, m_hTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEventHandle getM_hEvent() {
		if (m_hEvent != null && m_hEvent.eIsProxy()) {
			InternalEObject oldM_hEvent = (InternalEObject)m_hEvent;
			m_hEvent = (IEventHandle)eResolveProxy(oldM_hEvent);
			if (m_hEvent != oldM_hEvent) {
				InternalEObject newM_hEvent = (InternalEObject)m_hEvent;
				NotificationChain msgs = oldM_hEvent.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISEND_ACTION__MHEVENT, null, null);
				if (newM_hEvent.eInternalContainer() == null) {
					msgs = newM_hEvent.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISEND_ACTION__MHEVENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISEND_ACTION__MHEVENT, oldM_hEvent, m_hEvent));
			}
		}
		return m_hEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEventHandle basicGetM_hEvent() {
		return m_hEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_hEvent(IEventHandle newM_hEvent, NotificationChain msgs) {
		IEventHandle oldM_hEvent = m_hEvent;
		m_hEvent = newM_hEvent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISEND_ACTION__MHEVENT, oldM_hEvent, newM_hEvent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_hEvent(IEventHandle newM_hEvent) {
		if (newM_hEvent != m_hEvent) {
			NotificationChain msgs = null;
			if (m_hEvent != null)
				msgs = ((InternalEObject)m_hEvent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISEND_ACTION__MHEVENT, null, msgs);
			if (newM_hEvent != null)
				msgs = ((InternalEObject)newM_hEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISEND_ACTION__MHEVENT, null, msgs);
			msgs = basicSetM_hEvent(newM_hEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISEND_ACTION__MHEVENT, newM_hEvent, newM_hEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArgValCount() {
		return argValCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgValCount(String newArgValCount) {
		String oldArgValCount = argValCount;
		argValCount = newArgValCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISEND_ACTION__ARG_VAL_COUNT, oldArgValCount, argValCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IHandleWithData> getGraphElements() {
		if (graphElements == null) {
			graphElements = new EObjectContainmentEList.Resolving<IHandleWithData>(IHandleWithData.class, this, UMLRhapsodyPackage.ISEND_ACTION__GRAPH_ELEMENTS);
		}
		return graphElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ISEND_ACTION__MHEVENT:
				return basicSetM_hEvent(null, msgs);
			case UMLRhapsodyPackage.ISEND_ACTION__GRAPH_ELEMENTS:
				return ((InternalEList<?>)getGraphElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.ISEND_ACTION__MHTARGET:
				if (resolve) return getM_hTarget();
				return basicGetM_hTarget();
			case UMLRhapsodyPackage.ISEND_ACTION__MHEVENT:
				if (resolve) return getM_hEvent();
				return basicGetM_hEvent();
			case UMLRhapsodyPackage.ISEND_ACTION__ARG_VAL_COUNT:
				return getArgValCount();
			case UMLRhapsodyPackage.ISEND_ACTION__GRAPH_ELEMENTS:
				return getGraphElements();
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
			case UMLRhapsodyPackage.ISEND_ACTION__MHTARGET:
				setM_hTarget((M_hTargetType)newValue);
				return;
			case UMLRhapsodyPackage.ISEND_ACTION__MHEVENT:
				setM_hEvent((IEventHandle)newValue);
				return;
			case UMLRhapsodyPackage.ISEND_ACTION__ARG_VAL_COUNT:
				setArgValCount((String)newValue);
				return;
			case UMLRhapsodyPackage.ISEND_ACTION__GRAPH_ELEMENTS:
				getGraphElements().clear();
				getGraphElements().addAll((Collection<? extends IHandleWithData>)newValue);
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
			case UMLRhapsodyPackage.ISEND_ACTION__MHTARGET:
				setM_hTarget((M_hTargetType)null);
				return;
			case UMLRhapsodyPackage.ISEND_ACTION__MHEVENT:
				setM_hEvent((IEventHandle)null);
				return;
			case UMLRhapsodyPackage.ISEND_ACTION__ARG_VAL_COUNT:
				setArgValCount(ARG_VAL_COUNT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISEND_ACTION__GRAPH_ELEMENTS:
				getGraphElements().clear();
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
			case UMLRhapsodyPackage.ISEND_ACTION__MHTARGET:
				return m_hTarget != null;
			case UMLRhapsodyPackage.ISEND_ACTION__MHEVENT:
				return m_hEvent != null;
			case UMLRhapsodyPackage.ISEND_ACTION__ARG_VAL_COUNT:
				return ARG_VAL_COUNT_EDEFAULT == null ? argValCount != null : !ARG_VAL_COUNT_EDEFAULT.equals(argValCount);
			case UMLRhapsodyPackage.ISEND_ACTION__GRAPH_ELEMENTS:
				return graphElements != null && !graphElements.isEmpty();
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
		result.append(" (ArgValCount: "); //$NON-NLS-1$
		result.append(argValCount);
		result.append(')');
		return result.toString();
	}

} //ISendActionImpl
