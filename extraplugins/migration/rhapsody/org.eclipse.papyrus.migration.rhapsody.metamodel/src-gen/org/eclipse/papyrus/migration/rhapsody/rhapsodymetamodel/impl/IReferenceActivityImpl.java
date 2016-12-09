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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityGraph;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IReferenceActivity;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISwimlane;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IReference Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getStateType <em>State Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getDefaultTrans <em>Default Trans</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getSwimlane <em>Swimlane</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getReferencedActivity <em>Referenced Activity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IReferenceActivityImpl#getMyState <em>My State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IReferenceActivityImpl extends DependsOnTypeImpl implements IReferenceActivity {
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
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IClassifier stereotypes;

	/**
	 * The default value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected static final String MODIFIED_TIME_WEAK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected String modifiedTimeWeak = MODIFIED_TIME_WEAK_EDEFAULT;

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
	 * The cached value of the '{@link #getSwimlane() <em>Swimlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwimlane()
	 * @generated
	 * @ordered
	 */
	protected ISwimlane swimlane;

	/**
	 * The cached value of the '{@link #getReferencedActivity() <em>Referenced Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedActivity()
	 * @generated
	 * @ordered
	 */
	protected IActivityGraph referencedActivity;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IReferenceActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIReferenceActivity();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier getStereotypes() {
		if (stereotypes != null && stereotypes.eIsProxy()) {
			InternalEObject oldStereotypes = (InternalEObject)stereotypes;
			stereotypes = (IClassifier)eResolveProxy(oldStereotypes);
			if (stereotypes != oldStereotypes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STEREOTYPES, oldStereotypes, stereotypes));
			}
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier basicGetStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(IClassifier newStereotypes) {
		IClassifier oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModifiedTimeWeak() {
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedTimeWeak(String newModifiedTimeWeak) {
		String oldModifiedTimeWeak = modifiedTimeWeak;
		modifiedTimeWeak = newModifiedTimeWeak;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MODIFIED_TIME_WEAK, oldModifiedTimeWeak, modifiedTimeWeak));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__PARENT, oldParent, parent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__PARENT, oldParent, parent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STATE_TYPE, oldStateType, stateType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__DEFAULT_TRANS, oldDefaultTrans, defaultTrans));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__SWIMLANE, oldSwimlane, swimlane));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__SWIMLANE, oldSwimlane, swimlane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityGraph getReferencedActivity() {
		if (referencedActivity != null && referencedActivity.eIsProxy()) {
			InternalEObject oldReferencedActivity = (InternalEObject)referencedActivity;
			referencedActivity = (IActivityGraph)eResolveProxy(oldReferencedActivity);
			if (referencedActivity != oldReferencedActivity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__REFERENCED_ACTIVITY, oldReferencedActivity, referencedActivity));
			}
		}
		return referencedActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityGraph basicGetReferencedActivity() {
		return referencedActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedActivity(IActivityGraph newReferencedActivity) {
		IActivityGraph oldReferencedActivity = referencedActivity;
		referencedActivity = newReferencedActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__REFERENCED_ACTIVITY, oldReferencedActivity, referencedActivity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MY_STATE, oldMyState, myState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__ID:
				return getId();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__NAME:
				return getName();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STATE_TYPE:
				return getStateType();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__DEFAULT_TRANS:
				return getDefaultTrans();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__SWIMLANE:
				if (resolve) return getSwimlane();
				return basicGetSwimlane();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__REFERENCED_ACTIVITY:
				if (resolve) return getReferencedActivity();
				return basicGetReferencedActivity();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MY_STATE:
				return getMyState();
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
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STEREOTYPES:
				setStereotypes((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak((String)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__PARENT:
				setParent((IState)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STATE_TYPE:
				setStateType((String)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__DEFAULT_TRANS:
				setDefaultTrans((String)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__SWIMLANE:
				setSwimlane((ISwimlane)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__REFERENCED_ACTIVITY:
				setReferencedActivity((IActivityGraph)newValue);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MY_STATE:
				setMyState((String)newValue);
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
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STEREOTYPES:
				setStereotypes((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak(MODIFIED_TIME_WEAK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__PARENT:
				setParent((IState)null);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STATE_TYPE:
				setStateType(STATE_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__DEFAULT_TRANS:
				setDefaultTrans(DEFAULT_TRANS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__SWIMLANE:
				setSwimlane((ISwimlane)null);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__REFERENCED_ACTIVITY:
				setReferencedActivity((IActivityGraph)null);
				return;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
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
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MODIFIED_TIME_WEAK:
				return MODIFIED_TIME_WEAK_EDEFAULT == null ? modifiedTimeWeak != null : !MODIFIED_TIME_WEAK_EDEFAULT.equals(modifiedTimeWeak);
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__PARENT:
				return parent != null;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__STATE_TYPE:
				return STATE_TYPE_EDEFAULT == null ? stateType != null : !STATE_TYPE_EDEFAULT.equals(stateType);
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__DEFAULT_TRANS:
				return DEFAULT_TRANS_EDEFAULT == null ? defaultTrans != null : !DEFAULT_TRANS_EDEFAULT.equals(defaultTrans);
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__SWIMLANE:
				return swimlane != null;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__REFERENCED_ACTIVITY:
				return referencedActivity != null;
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
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
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", stateType: "); //$NON-NLS-1$
		result.append(stateType);
		result.append(", defaultTrans: "); //$NON-NLS-1$
		result.append(defaultTrans);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(')');
		return result.toString();
	}

} //IReferenceActivityImpl
