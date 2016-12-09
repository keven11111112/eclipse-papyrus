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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Elements Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphElementsTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphElementsTypeImpl#getM_drawBehavior <em>Mdraw Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphElementsTypeImpl#getM_type <em>Mtype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphElementsTypeImpl#getM_name <em>Mname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphElementsTypeImpl#getM_bIsPreferencesInitialized <em>MbIs Preferences Initialized</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GraphElementsTypeImpl extends M_pRootTypeImpl implements GraphElementsType {
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
	 * The default value of the '{@link #getM_drawBehavior() <em>Mdraw Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_drawBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final String MDRAW_BEHAVIOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_drawBehavior() <em>Mdraw Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_drawBehavior()
	 * @generated
	 * @ordered
	 */
	protected String m_drawBehavior = MDRAW_BEHAVIOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_type() <em>Mtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_type()
	 * @generated
	 * @ordered
	 */
	protected static final String MTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_type() <em>Mtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_type()
	 * @generated
	 * @ordered
	 */
	protected String m_type = MTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_name() <em>Mname</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_name()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_name;

	/**
	 * The default value of the '{@link #getM_bIsPreferencesInitialized() <em>MbIs Preferences Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bIsPreferencesInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final String MBIS_PREFERENCES_INITIALIZED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bIsPreferencesInitialized() <em>MbIs Preferences Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bIsPreferencesInitialized()
	 * @generated
	 * @ordered
	 */
	protected String m_bIsPreferencesInitialized = MBIS_PREFERENCES_INITIALIZED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphElementsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getGraphElementsType();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_drawBehavior() {
		return m_drawBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_drawBehavior(String newM_drawBehavior) {
		String oldM_drawBehavior = m_drawBehavior;
		m_drawBehavior = newM_drawBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MDRAW_BEHAVIOR, oldM_drawBehavior, m_drawBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_type() {
		return m_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_type(String newM_type) {
		String oldM_type = m_type;
		m_type = newM_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MTYPE, oldM_type, m_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_name() {
		if (m_name != null && m_name.eIsProxy()) {
			InternalEObject oldM_name = (InternalEObject)m_name;
			m_name = (CGIText)eResolveProxy(oldM_name);
			if (m_name != oldM_name) {
				InternalEObject newM_name = (InternalEObject)m_name;
				NotificationChain msgs = oldM_name.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME, null, null);
				if (newM_name.eInternalContainer() == null) {
					msgs = newM_name.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME, oldM_name, m_name));
			}
		}
		return m_name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_name() {
		return m_name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_name(CGIText newM_name, NotificationChain msgs) {
		CGIText oldM_name = m_name;
		m_name = newM_name;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME, oldM_name, newM_name);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_name(CGIText newM_name) {
		if (newM_name != m_name) {
			NotificationChain msgs = null;
			if (m_name != null)
				msgs = ((InternalEObject)m_name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME, null, msgs);
			if (newM_name != null)
				msgs = ((InternalEObject)newM_name).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME, null, msgs);
			msgs = basicSetM_name(newM_name, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME, newM_name, newM_name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bIsPreferencesInitialized() {
		return m_bIsPreferencesInitialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bIsPreferencesInitialized(String newM_bIsPreferencesInitialized) {
		String oldM_bIsPreferencesInitialized = m_bIsPreferencesInitialized;
		m_bIsPreferencesInitialized = newM_bIsPreferencesInitialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MBIS_PREFERENCES_INITIALIZED, oldM_bIsPreferencesInitialized, m_bIsPreferencesInitialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME:
				return basicSetM_name(null, msgs);
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
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__ID:
				return getId();
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MDRAW_BEHAVIOR:
				return getM_drawBehavior();
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MTYPE:
				return getM_type();
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME:
				if (resolve) return getM_name();
				return basicGetM_name();
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MBIS_PREFERENCES_INITIALIZED:
				return getM_bIsPreferencesInitialized();
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
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MDRAW_BEHAVIOR:
				setM_drawBehavior((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MTYPE:
				setM_type((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME:
				setM_name((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MBIS_PREFERENCES_INITIALIZED:
				setM_bIsPreferencesInitialized((String)newValue);
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
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MDRAW_BEHAVIOR:
				setM_drawBehavior(MDRAW_BEHAVIOR_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MTYPE:
				setM_type(MTYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME:
				setM_name((CGIText)null);
				return;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MBIS_PREFERENCES_INITIALIZED:
				setM_bIsPreferencesInitialized(MBIS_PREFERENCES_INITIALIZED_EDEFAULT);
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
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MDRAW_BEHAVIOR:
				return MDRAW_BEHAVIOR_EDEFAULT == null ? m_drawBehavior != null : !MDRAW_BEHAVIOR_EDEFAULT.equals(m_drawBehavior);
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MTYPE:
				return MTYPE_EDEFAULT == null ? m_type != null : !MTYPE_EDEFAULT.equals(m_type);
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MNAME:
				return m_name != null;
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE__MBIS_PREFERENCES_INITIALIZED:
				return MBIS_PREFERENCES_INITIALIZED_EDEFAULT == null ? m_bIsPreferencesInitialized != null : !MBIS_PREFERENCES_INITIALIZED_EDEFAULT.equals(m_bIsPreferencesInitialized);
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
		result.append(", m_drawBehavior: "); //$NON-NLS-1$
		result.append(m_drawBehavior);
		result.append(", m_type: "); //$NON-NLS-1$
		result.append(m_type);
		result.append(", m_bIsPreferencesInitialized: "); //$NON-NLS-1$
		result.append(m_bIsPreferencesInitialized);
		result.append(')');
		return result.toString();
	}

} //GraphElementsTypeImpl
