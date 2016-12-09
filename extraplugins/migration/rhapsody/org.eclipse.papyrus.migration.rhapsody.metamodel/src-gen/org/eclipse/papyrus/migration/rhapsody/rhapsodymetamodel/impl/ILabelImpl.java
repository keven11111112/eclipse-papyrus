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

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILabel;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTriggerType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ILabel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getItsTrigger <em>Its Trigger</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getItsAction <em>Its Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getItsGuard <em>Its Guard</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILabelImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ILabelImpl extends ItsLabelTypeImpl implements ILabel {
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
	 * The cached value of the '{@link #getItsTrigger() <em>Its Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsTrigger()
	 * @generated
	 * @ordered
	 */
	protected ItsTriggerType itsTrigger;

	/**
	 * The cached value of the '{@link #getItsAction() <em>Its Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsAction()
	 * @generated
	 * @ordered
	 */
	protected IModelElement itsAction;

	/**
	 * The cached value of the '{@link #getItsGuard() <em>Its Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsGuard()
	 * @generated
	 * @ordered
	 */
	protected IModelElement itsGuard;

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
	 * The cached value of the '{@link #getInheritsFromHandle() <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritsFromHandle()
	 * @generated
	 * @ordered
	 */
	protected ILabel inheritsFromHandle;

	/**
	 * The cached value of the '{@link #getCodeUpdateCGTime() <em>Code Update CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeUpdateCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> codeUpdateCGTime;

	/**
	 * The default value of the '{@link #getObjectCreation() <em>Object Creation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectCreation()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_CREATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectCreation() <em>Object Creation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectCreation()
	 * @generated
	 * @ordered
	 */
	protected String objectCreation = OBJECT_CREATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUmlDependencyID() <em>Uml Dependency ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlDependencyID()
	 * @generated
	 * @ordered
	 */
	protected static final String UML_DEPENDENCY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUmlDependencyID() <em>Uml Dependency ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlDependencyID()
	 * @generated
	 * @ordered
	 */
	protected String umlDependencyID = UML_DEPENDENCY_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ILabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getILabel();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsTriggerType getItsTrigger() {
		if (itsTrigger != null && itsTrigger.eIsProxy()) {
			InternalEObject oldItsTrigger = (InternalEObject)itsTrigger;
			itsTrigger = (ItsTriggerType)eResolveProxy(oldItsTrigger);
			if (itsTrigger != oldItsTrigger) {
				InternalEObject newItsTrigger = (InternalEObject)itsTrigger;
				NotificationChain msgs = oldItsTrigger.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_TRIGGER, null, null);
				if (newItsTrigger.eInternalContainer() == null) {
					msgs = newItsTrigger.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_TRIGGER, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILABEL__ITS_TRIGGER, oldItsTrigger, itsTrigger));
			}
		}
		return itsTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsTriggerType basicGetItsTrigger() {
		return itsTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItsTrigger(ItsTriggerType newItsTrigger, NotificationChain msgs) {
		ItsTriggerType oldItsTrigger = itsTrigger;
		itsTrigger = newItsTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__ITS_TRIGGER, oldItsTrigger, newItsTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsTrigger(ItsTriggerType newItsTrigger) {
		if (newItsTrigger != itsTrigger) {
			NotificationChain msgs = null;
			if (itsTrigger != null)
				msgs = ((InternalEObject)itsTrigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_TRIGGER, null, msgs);
			if (newItsTrigger != null)
				msgs = ((InternalEObject)newItsTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_TRIGGER, null, msgs);
			msgs = basicSetItsTrigger(newItsTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__ITS_TRIGGER, newItsTrigger, newItsTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement getItsAction() {
		if (itsAction != null && itsAction.eIsProxy()) {
			InternalEObject oldItsAction = (InternalEObject)itsAction;
			itsAction = (IModelElement)eResolveProxy(oldItsAction);
			if (itsAction != oldItsAction) {
				InternalEObject newItsAction = (InternalEObject)itsAction;
				NotificationChain msgs = oldItsAction.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_ACTION, null, null);
				if (newItsAction.eInternalContainer() == null) {
					msgs = newItsAction.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_ACTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILABEL__ITS_ACTION, oldItsAction, itsAction));
			}
		}
		return itsAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement basicGetItsAction() {
		return itsAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItsAction(IModelElement newItsAction, NotificationChain msgs) {
		IModelElement oldItsAction = itsAction;
		itsAction = newItsAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__ITS_ACTION, oldItsAction, newItsAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsAction(IModelElement newItsAction) {
		if (newItsAction != itsAction) {
			NotificationChain msgs = null;
			if (itsAction != null)
				msgs = ((InternalEObject)itsAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_ACTION, null, msgs);
			if (newItsAction != null)
				msgs = ((InternalEObject)newItsAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_ACTION, null, msgs);
			msgs = basicSetItsAction(newItsAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__ITS_ACTION, newItsAction, newItsAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement getItsGuard() {
		if (itsGuard != null && itsGuard.eIsProxy()) {
			InternalEObject oldItsGuard = (InternalEObject)itsGuard;
			itsGuard = (IModelElement)eResolveProxy(oldItsGuard);
			if (itsGuard != oldItsGuard) {
				InternalEObject newItsGuard = (InternalEObject)itsGuard;
				NotificationChain msgs = oldItsGuard.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_GUARD, null, null);
				if (newItsGuard.eInternalContainer() == null) {
					msgs = newItsGuard.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_GUARD, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILABEL__ITS_GUARD, oldItsGuard, itsGuard));
			}
		}
		return itsGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement basicGetItsGuard() {
		return itsGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItsGuard(IModelElement newItsGuard, NotificationChain msgs) {
		IModelElement oldItsGuard = itsGuard;
		itsGuard = newItsGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__ITS_GUARD, oldItsGuard, newItsGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsGuard(IModelElement newItsGuard) {
		if (newItsGuard != itsGuard) {
			NotificationChain msgs = null;
			if (itsGuard != null)
				msgs = ((InternalEObject)itsGuard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_GUARD, null, msgs);
			if (newItsGuard != null)
				msgs = ((InternalEObject)newItsGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILABEL__ITS_GUARD, null, msgs);
			msgs = basicSetItsGuard(newItsGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__ITS_GUARD, newItsGuard, newItsGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ILABEL__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__MY_STATE, oldMyState, myState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILabel getInheritsFromHandle() {
		if (inheritsFromHandle != null && inheritsFromHandle.eIsProxy()) {
			InternalEObject oldInheritsFromHandle = (InternalEObject)inheritsFromHandle;
			inheritsFromHandle = (ILabel)eResolveProxy(oldInheritsFromHandle);
			if (inheritsFromHandle != oldInheritsFromHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILABEL__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
			}
		}
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILabel basicGetInheritsFromHandle() {
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritsFromHandle(ILabel newInheritsFromHandle) {
		ILabel oldInheritsFromHandle = inheritsFromHandle;
		inheritsFromHandle = newInheritsFromHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ILABEL__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectCreation() {
		return objectCreation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectCreation(String newObjectCreation) {
		String oldObjectCreation = objectCreation;
		objectCreation = newObjectCreation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__OBJECT_CREATION, oldObjectCreation, objectCreation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUmlDependencyID() {
		return umlDependencyID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlDependencyID(String newUmlDependencyID) {
		String oldUmlDependencyID = umlDependencyID;
		umlDependencyID = newUmlDependencyID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILABEL__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ILABEL__ITS_TRIGGER:
				return basicSetItsTrigger(null, msgs);
			case UMLRhapsodyPackage.ILABEL__ITS_ACTION:
				return basicSetItsAction(null, msgs);
			case UMLRhapsodyPackage.ILABEL__ITS_GUARD:
				return basicSetItsGuard(null, msgs);
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
			case UMLRhapsodyPackage.ILABEL__ID:
				return getId();
			case UMLRhapsodyPackage.ILABEL__ITS_TRIGGER:
				if (resolve) return getItsTrigger();
				return basicGetItsTrigger();
			case UMLRhapsodyPackage.ILABEL__ITS_ACTION:
				if (resolve) return getItsAction();
				return basicGetItsAction();
			case UMLRhapsodyPackage.ILABEL__ITS_GUARD:
				if (resolve) return getItsGuard();
				return basicGetItsGuard();
			case UMLRhapsodyPackage.ILABEL__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ILABEL__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.ILABEL__INHERITS_FROM_HANDLE:
				if (resolve) return getInheritsFromHandle();
				return basicGetInheritsFromHandle();
			case UMLRhapsodyPackage.ILABEL__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.ILABEL__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.ILABEL__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
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
			case UMLRhapsodyPackage.ILABEL__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__ITS_TRIGGER:
				setItsTrigger((ItsTriggerType)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__ITS_ACTION:
				setItsAction((IModelElement)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__ITS_GUARD:
				setItsGuard((IModelElement)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((ILabel)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.ILABEL__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
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
			case UMLRhapsodyPackage.ILABEL__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILABEL__ITS_TRIGGER:
				setItsTrigger((ItsTriggerType)null);
				return;
			case UMLRhapsodyPackage.ILABEL__ITS_ACTION:
				setItsAction((IModelElement)null);
				return;
			case UMLRhapsodyPackage.ILABEL__ITS_GUARD:
				setItsGuard((IModelElement)null);
				return;
			case UMLRhapsodyPackage.ILABEL__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.ILABEL__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILABEL__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((ILabel)null);
				return;
			case UMLRhapsodyPackage.ILABEL__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.ILABEL__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILABEL__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
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
			case UMLRhapsodyPackage.ILABEL__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ILABEL__ITS_TRIGGER:
				return itsTrigger != null;
			case UMLRhapsodyPackage.ILABEL__ITS_ACTION:
				return itsAction != null;
			case UMLRhapsodyPackage.ILABEL__ITS_GUARD:
				return itsGuard != null;
			case UMLRhapsodyPackage.ILABEL__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.ILABEL__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.ILABEL__INHERITS_FROM_HANDLE:
				return inheritsFromHandle != null;
			case UMLRhapsodyPackage.ILABEL__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.ILABEL__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.ILABEL__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
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
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //ILabelImpl
