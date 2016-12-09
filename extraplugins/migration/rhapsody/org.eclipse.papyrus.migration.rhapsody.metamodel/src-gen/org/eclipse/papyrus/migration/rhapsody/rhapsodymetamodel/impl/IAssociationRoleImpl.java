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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.AssociationsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationRole;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifierRole;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IAssociation Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getM_fAssocType1 <em>MfAssoc Type1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getM_fAssocType2 <em>MfAssoc Type2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getM_pSource <em>MpSource</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getM_pTarget <em>MpTarget</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getM_pFormalAssoc1 <em>MpFormal Assoc1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getM_pFormalAssoc2 <em>MpFormal Assoc2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationRoleImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IAssociationRoleImpl extends IModelElementImpl implements IAssociationRole {
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
	 * The default value of the '{@link #getM_fAssocType1() <em>MfAssoc Type1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fAssocType1()
	 * @generated
	 * @ordered
	 */
	protected static final String MFASSOC_TYPE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_fAssocType1() <em>MfAssoc Type1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fAssocType1()
	 * @generated
	 * @ordered
	 */
	protected String m_fAssocType1 = MFASSOC_TYPE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_fAssocType2() <em>MfAssoc Type2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fAssocType2()
	 * @generated
	 * @ordered
	 */
	protected static final String MFASSOC_TYPE2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_fAssocType2() <em>MfAssoc Type2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fAssocType2()
	 * @generated
	 * @ordered
	 */
	protected String m_fAssocType2 = MFASSOC_TYPE2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pSource() <em>MpSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pSource()
	 * @generated
	 * @ordered
	 */
	protected IClassifierRole m_pSource;

	/**
	 * The cached value of the '{@link #getM_pTarget() <em>MpTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pTarget()
	 * @generated
	 * @ordered
	 */
	protected IClassifierRole m_pTarget;

	/**
	 * The cached value of the '{@link #getM_pFormalAssoc1() <em>MpFormal Assoc1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pFormalAssoc1()
	 * @generated
	 * @ordered
	 */
	protected AssociationsType m_pFormalAssoc1;

	/**
	 * The cached value of the '{@link #getM_pFormalAssoc2() <em>MpFormal Assoc2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pFormalAssoc2()
	 * @generated
	 * @ordered
	 */
	protected AssociationsType m_pFormalAssoc2;

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
	protected IAssociationRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIAssociationRole();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__MY_STATE, oldMyState, myState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_fAssocType1() {
		return m_fAssocType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_fAssocType1(String newM_fAssocType1) {
		String oldM_fAssocType1 = m_fAssocType1;
		m_fAssocType1 = newM_fAssocType1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE1, oldM_fAssocType1, m_fAssocType1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_fAssocType2() {
		return m_fAssocType2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_fAssocType2(String newM_fAssocType2) {
		String oldM_fAssocType2 = m_fAssocType2;
		m_fAssocType2 = newM_fAssocType2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE2, oldM_fAssocType2, m_fAssocType2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole getM_pSource() {
		if (m_pSource != null && m_pSource.eIsProxy()) {
			InternalEObject oldM_pSource = (InternalEObject)m_pSource;
			m_pSource = (IClassifierRole)eResolveProxy(oldM_pSource);
			if (m_pSource != oldM_pSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPSOURCE, oldM_pSource, m_pSource));
			}
		}
		return m_pSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole basicGetM_pSource() {
		return m_pSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pSource(IClassifierRole newM_pSource) {
		IClassifierRole oldM_pSource = m_pSource;
		m_pSource = newM_pSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPSOURCE, oldM_pSource, m_pSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole getM_pTarget() {
		if (m_pTarget != null && m_pTarget.eIsProxy()) {
			InternalEObject oldM_pTarget = (InternalEObject)m_pTarget;
			m_pTarget = (IClassifierRole)eResolveProxy(oldM_pTarget);
			if (m_pTarget != oldM_pTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPTARGET, oldM_pTarget, m_pTarget));
			}
		}
		return m_pTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole basicGetM_pTarget() {
		return m_pTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pTarget(IClassifierRole newM_pTarget) {
		IClassifierRole oldM_pTarget = m_pTarget;
		m_pTarget = newM_pTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPTARGET, oldM_pTarget, m_pTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationsType getM_pFormalAssoc1() {
		if (m_pFormalAssoc1 != null && m_pFormalAssoc1.eIsProxy()) {
			InternalEObject oldM_pFormalAssoc1 = (InternalEObject)m_pFormalAssoc1;
			m_pFormalAssoc1 = (AssociationsType)eResolveProxy(oldM_pFormalAssoc1);
			if (m_pFormalAssoc1 != oldM_pFormalAssoc1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC1, oldM_pFormalAssoc1, m_pFormalAssoc1));
			}
		}
		return m_pFormalAssoc1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationsType basicGetM_pFormalAssoc1() {
		return m_pFormalAssoc1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pFormalAssoc1(AssociationsType newM_pFormalAssoc1) {
		AssociationsType oldM_pFormalAssoc1 = m_pFormalAssoc1;
		m_pFormalAssoc1 = newM_pFormalAssoc1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC1, oldM_pFormalAssoc1, m_pFormalAssoc1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationsType getM_pFormalAssoc2() {
		if (m_pFormalAssoc2 != null && m_pFormalAssoc2.eIsProxy()) {
			InternalEObject oldM_pFormalAssoc2 = (InternalEObject)m_pFormalAssoc2;
			m_pFormalAssoc2 = (AssociationsType)eResolveProxy(oldM_pFormalAssoc2);
			if (m_pFormalAssoc2 != oldM_pFormalAssoc2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC2, oldM_pFormalAssoc2, m_pFormalAssoc2));
			}
		}
		return m_pFormalAssoc2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationsType basicGetM_pFormalAssoc2() {
		return m_pFormalAssoc2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pFormalAssoc2(AssociationsType newM_pFormalAssoc2) {
		AssociationsType oldM_pFormalAssoc2 = m_pFormalAssoc2;
		m_pFormalAssoc2 = newM_pFormalAssoc2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC2, oldM_pFormalAssoc2, m_pFormalAssoc2));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IASSOCIATION_ROLE__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_ROLE__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__ID:
				return getId();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE1:
				return getM_fAssocType1();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE2:
				return getM_fAssocType2();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPSOURCE:
				if (resolve) return getM_pSource();
				return basicGetM_pSource();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPTARGET:
				if (resolve) return getM_pTarget();
				return basicGetM_pTarget();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC1:
				if (resolve) return getM_pFormalAssoc1();
				return basicGetM_pFormalAssoc1();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC2:
				if (resolve) return getM_pFormalAssoc2();
				return basicGetM_pFormalAssoc2();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__NAME:
				return getName();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE1:
				setM_fAssocType1((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE2:
				setM_fAssocType2((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPSOURCE:
				setM_pSource((IClassifierRole)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPTARGET:
				setM_pTarget((IClassifierRole)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC1:
				setM_pFormalAssoc1((AssociationsType)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC2:
				setM_pFormalAssoc2((AssociationsType)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE1:
				setM_fAssocType1(MFASSOC_TYPE1_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE2:
				setM_fAssocType2(MFASSOC_TYPE2_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPSOURCE:
				setM_pSource((IClassifierRole)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPTARGET:
				setM_pTarget((IClassifierRole)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC1:
				setM_pFormalAssoc1((AssociationsType)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC2:
				setM_pFormalAssoc2((AssociationsType)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE1:
				return MFASSOC_TYPE1_EDEFAULT == null ? m_fAssocType1 != null : !MFASSOC_TYPE1_EDEFAULT.equals(m_fAssocType1);
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MFASSOC_TYPE2:
				return MFASSOC_TYPE2_EDEFAULT == null ? m_fAssocType2 != null : !MFASSOC_TYPE2_EDEFAULT.equals(m_fAssocType2);
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPSOURCE:
				return m_pSource != null;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPTARGET:
				return m_pTarget != null;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC1:
				return m_pFormalAssoc1 != null;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MPFORMAL_ASSOC2:
				return m_pFormalAssoc2 != null;
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IASSOCIATION_ROLE__UML_DEPENDENCY_ID:
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
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", m_fAssocType1: "); //$NON-NLS-1$
		result.append(m_fAssocType1);
		result.append(", m_fAssocType2: "); //$NON-NLS-1$
		result.append(m_fAssocType2);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //IAssociationRoleImpl
