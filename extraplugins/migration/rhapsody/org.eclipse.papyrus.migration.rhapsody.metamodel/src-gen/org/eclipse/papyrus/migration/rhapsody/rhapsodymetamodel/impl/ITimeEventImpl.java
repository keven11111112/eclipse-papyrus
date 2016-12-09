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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISwimlane;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITimeEvent;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ITime Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getStateType <em>State Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getDefaultTrans <em>Default Trans</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getDurationTime <em>Duration Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITimeEventImpl#getSwimlane <em>Swimlane</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ITimeEventImpl extends ItsTargetTypeImpl implements ITimeEvent {
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
	 * The default value of the '{@link #getMyState() <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyState()
	 * @generated
	 * @ordered
	 */
	protected static final String MY_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMyState() <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyState()
	 * @generated
	 * @ordered
	 */
	protected String myState = MY_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected EList<String> modifiedTimeWeak;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected IState parent;

	/**
	 * The default value of the '{@link #getStateType() <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateType()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStateType() <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateType()
	 * @generated
	 * @ordered
	 */
	protected String stateType = STATE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultTrans() <em>Default Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTrans()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_TRANS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultTrans() <em>Default Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTrans()
	 * @generated
	 * @ordered
	 */
	protected String defaultTrans = DEFAULT_TRANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDurationTime() <em>Duration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDurationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String DURATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDurationTime() <em>Duration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDurationTime()
	 * @generated
	 * @ordered
	 */
	protected String durationTime = DURATION_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSwimlane() <em>Swimlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwimlane()
	 * @generated
	 * @ordered
	 */
	protected ISwimlane swimlane;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ITimeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getITimeEvent();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMyState() {
		return myState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyState(String newMyState) {
		String oldMyState = myState;
		myState = newMyState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__MY_STATE, oldMyState, myState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ITIME_EVENT__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (IState)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ITIME_EVENT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(IState newParent) {
		IState oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStateType() {
		return stateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateType(String newStateType) {
		String oldStateType = stateType;
		stateType = newStateType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__STATE_TYPE, oldStateType, stateType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultTrans() {
		return defaultTrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTrans(String newDefaultTrans) {
		String oldDefaultTrans = defaultTrans;
		defaultTrans = newDefaultTrans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__DEFAULT_TRANS, oldDefaultTrans, defaultTrans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDurationTime() {
		return durationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDurationTime(String newDurationTime) {
		String oldDurationTime = durationTime;
		durationTime = newDurationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__DURATION_TIME, oldDurationTime, durationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISwimlane getSwimlane() {
		if (swimlane != null && swimlane.eIsProxy()) {
			InternalEObject oldSwimlane = (InternalEObject)swimlane;
			swimlane = (ISwimlane)eResolveProxy(oldSwimlane);
			if (swimlane != oldSwimlane) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ITIME_EVENT__SWIMLANE, oldSwimlane, swimlane));
			}
		}
		return swimlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISwimlane basicGetSwimlane() {
		return swimlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwimlane(ISwimlane newSwimlane) {
		ISwimlane oldSwimlane = swimlane;
		swimlane = newSwimlane;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITIME_EVENT__SWIMLANE, oldSwimlane, swimlane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.ITIME_EVENT__ID:
				return getId();
			case UMLRhapsodyPackage.ITIME_EVENT__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.ITIME_EVENT__NAME:
				return getName();
			case UMLRhapsodyPackage.ITIME_EVENT__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ITIME_EVENT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case UMLRhapsodyPackage.ITIME_EVENT__STATE_TYPE:
				return getStateType();
			case UMLRhapsodyPackage.ITIME_EVENT__DEFAULT_TRANS:
				return getDefaultTrans();
			case UMLRhapsodyPackage.ITIME_EVENT__DURATION_TIME:
				return getDurationTime();
			case UMLRhapsodyPackage.ITIME_EVENT__SWIMLANE:
				if (resolve) return getSwimlane();
				return basicGetSwimlane();
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
			case UMLRhapsodyPackage.ITIME_EVENT__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__PARENT:
				setParent((IState)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__STATE_TYPE:
				setStateType((String)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__DEFAULT_TRANS:
				setDefaultTrans((String)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__DURATION_TIME:
				setDurationTime((String)newValue);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__SWIMLANE:
				setSwimlane((ISwimlane)newValue);
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
			case UMLRhapsodyPackage.ITIME_EVENT__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__PARENT:
				setParent((IState)null);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__STATE_TYPE:
				setStateType(STATE_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__DEFAULT_TRANS:
				setDefaultTrans(DEFAULT_TRANS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__DURATION_TIME:
				setDurationTime(DURATION_TIME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITIME_EVENT__SWIMLANE:
				setSwimlane((ISwimlane)null);
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
			case UMLRhapsodyPackage.ITIME_EVENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ITIME_EVENT__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.ITIME_EVENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ITIME_EVENT__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.ITIME_EVENT__PARENT:
				return parent != null;
			case UMLRhapsodyPackage.ITIME_EVENT__STATE_TYPE:
				return STATE_TYPE_EDEFAULT == null ? stateType != null : !STATE_TYPE_EDEFAULT.equals(stateType);
			case UMLRhapsodyPackage.ITIME_EVENT__DEFAULT_TRANS:
				return DEFAULT_TRANS_EDEFAULT == null ? defaultTrans != null : !DEFAULT_TRANS_EDEFAULT.equals(defaultTrans);
			case UMLRhapsodyPackage.ITIME_EVENT__DURATION_TIME:
				return DURATION_TIME_EDEFAULT == null ? durationTime != null : !DURATION_TIME_EDEFAULT.equals(durationTime);
			case UMLRhapsodyPackage.ITIME_EVENT__SWIMLANE:
				return swimlane != null;
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
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", stateType: "); //$NON-NLS-1$
		result.append(stateType);
		result.append(", defaultTrans: "); //$NON-NLS-1$
		result.append(defaultTrans);
		result.append(", durationTime: "); //$NON-NLS-1$
		result.append(durationTime);
		result.append(')');
		return result.toString();
	}

} //ITimeEventImpl
