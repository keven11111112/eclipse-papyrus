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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IRequirement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsLabelType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TransitionsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IDefault Drvd Trans</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getStaticReaction <em>Static Reaction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getItsTarget <em>Its Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getItsLabel <em>Its Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getItsSource <em>Its Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getOfState <em>Of State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getErrorStatus <em>Error Status</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDefaultDrvdTransImpl#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IDefaultDrvdTransImpl extends DefaultTransTypeImpl implements IDefaultDrvdTrans {
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
	 * The default value of the '{@link #getStaticReaction() <em>Static Reaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticReaction()
	 * @generated
	 * @ordered
	 */
	protected static final String STATIC_REACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStaticReaction() <em>Static Reaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticReaction()
	 * @generated
	 * @ordered
	 */
	protected String staticReaction = STATIC_REACTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItsTarget() <em>Its Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsTarget()
	 * @generated
	 * @ordered
	 */
	protected ItsTargetType itsTarget;

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
	 * The cached value of the '{@link #getCodeUpdateCGTime() <em>Code Update CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeUpdateCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> codeUpdateCGTime;

	/**
	 * The default value of the '{@link #getRequiremenTracabilityHandle() <em>Requiremen Tracability Handle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiremenTracabilityHandle()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequiremenTracabilityHandle() <em>Requiremen Tracability Handle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiremenTracabilityHandle()
	 * @generated
	 * @ordered
	 */
	protected String requiremenTracabilityHandle = REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected IDescription description;

	/**
	 * The cached value of the '{@link #getItsLabel() <em>Its Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsLabel()
	 * @generated
	 * @ordered
	 */
	protected ItsLabelType itsLabel;

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
	 * The default value of the '{@link #getItsSource() <em>Its Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsSource()
	 * @generated
	 * @ordered
	 */
	protected static final String ITS_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getItsSource() <em>Its Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsSource()
	 * @generated
	 * @ordered
	 */
	protected String itsSource = ITS_SOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOfState() <em>Of State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfState()
	 * @generated
	 * @ordered
	 */
	protected IState ofState;

	/**
	 * The default value of the '{@link #getErrorStatus() <em>Error Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getErrorStatus() <em>Error Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorStatus()
	 * @generated
	 * @ordered
	 */
	protected String errorStatus = ERROR_STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInheritsFromHandle() <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritsFromHandle()
	 * @generated
	 * @ordered
	 */
	protected IDefaultDrvdTrans inheritsFromHandle;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected IRequirement annotations;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IStereotype stereotypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IDefaultDrvdTransImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIDefaultDrvdTrans();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStaticReaction() {
		return staticReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticReaction(String newStaticReaction) {
		String oldStaticReaction = staticReaction;
		staticReaction = newStaticReaction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STATIC_REACTION, oldStaticReaction, staticReaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsTargetType getItsTarget() {
		if (itsTarget != null && itsTarget.eIsProxy()) {
			InternalEObject oldItsTarget = (InternalEObject)itsTarget;
			itsTarget = (ItsTargetType)eResolveProxy(oldItsTarget);
			if (itsTarget != oldItsTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET, oldItsTarget, itsTarget));
			}
		}
		return itsTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsTargetType basicGetItsTarget() {
		return itsTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsTarget(ItsTargetType newItsTarget) {
		ItsTargetType oldItsTarget = itsTarget;
		itsTarget = newItsTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET, oldItsTarget, itsTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequiremenTracabilityHandle() {
		return requiremenTracabilityHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiremenTracabilityHandle(String newRequiremenTracabilityHandle) {
		String oldRequiremenTracabilityHandle = requiremenTracabilityHandle;
		requiremenTracabilityHandle = newRequiremenTracabilityHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDescription getDescription() {
		if (description != null && description.eIsProxy()) {
			InternalEObject oldDescription = (InternalEObject)description;
			description = (IDescription)eResolveProxy(oldDescription);
			if (description != oldDescription) {
				InternalEObject newDescription = (InternalEObject)description;
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION, oldDescription, description));
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDescription basicGetDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(IDescription newDescription, NotificationChain msgs) {
		IDescription oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(IDescription newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsLabelType getItsLabel() {
		if (itsLabel != null && itsLabel.eIsProxy()) {
			InternalEObject oldItsLabel = (InternalEObject)itsLabel;
			itsLabel = (ItsLabelType)eResolveProxy(oldItsLabel);
			if (itsLabel != oldItsLabel) {
				InternalEObject newItsLabel = (InternalEObject)itsLabel;
				NotificationChain msgs = oldItsLabel.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL, null, null);
				if (newItsLabel.eInternalContainer() == null) {
					msgs = newItsLabel.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL, oldItsLabel, itsLabel));
			}
		}
		return itsLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsLabelType basicGetItsLabel() {
		return itsLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItsLabel(ItsLabelType newItsLabel, NotificationChain msgs) {
		ItsLabelType oldItsLabel = itsLabel;
		itsLabel = newItsLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL, oldItsLabel, newItsLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsLabel(ItsLabelType newItsLabel) {
		if (newItsLabel != itsLabel) {
			NotificationChain msgs = null;
			if (itsLabel != null)
				msgs = ((InternalEObject)itsLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL, null, msgs);
			if (newItsLabel != null)
				msgs = ((InternalEObject)newItsLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL, null, msgs);
			msgs = basicSetItsLabel(newItsLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL, newItsLabel, newItsLabel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getItsSource() {
		return itsSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsSource(String newItsSource) {
		String oldItsSource = itsSource;
		itsSource = newItsSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_SOURCE, oldItsSource, itsSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState getOfState() {
		if (ofState != null && ofState.eIsProxy()) {
			InternalEObject oldOfState = (InternalEObject)ofState;
			ofState = (IState)eResolveProxy(oldOfState);
			if (ofState != oldOfState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OF_STATE, oldOfState, ofState));
			}
		}
		return ofState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState basicGetOfState() {
		return ofState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOfState(IState newOfState) {
		IState oldOfState = ofState;
		ofState = newOfState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OF_STATE, oldOfState, ofState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorStatus() {
		return errorStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorStatus(String newErrorStatus) {
		String oldErrorStatus = errorStatus;
		errorStatus = newErrorStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ERROR_STATUS, oldErrorStatus, errorStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDefaultDrvdTrans getInheritsFromHandle() {
		if (inheritsFromHandle != null && inheritsFromHandle.eIsProxy()) {
			InternalEObject oldInheritsFromHandle = (InternalEObject)inheritsFromHandle;
			inheritsFromHandle = (IDefaultDrvdTrans)eResolveProxy(oldInheritsFromHandle);
			if (inheritsFromHandle != oldInheritsFromHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
			}
		}
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDefaultDrvdTrans basicGetInheritsFromHandle() {
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritsFromHandle(IDefaultDrvdTrans newInheritsFromHandle) {
		IDefaultDrvdTrans oldInheritsFromHandle = inheritsFromHandle;
		inheritsFromHandle = newInheritsFromHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequirement getAnnotations() {
		if (annotations != null && annotations.eIsProxy()) {
			InternalEObject oldAnnotations = (InternalEObject)annotations;
			annotations = (IRequirement)eResolveProxy(oldAnnotations);
			if (annotations != oldAnnotations) {
				InternalEObject newAnnotations = (InternalEObject)annotations;
				NotificationChain msgs = oldAnnotations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS, null, null);
				if (newAnnotations.eInternalContainer() == null) {
					msgs = newAnnotations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS, oldAnnotations, annotations));
			}
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequirement basicGetAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotations(IRequirement newAnnotations, NotificationChain msgs) {
		IRequirement oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS, oldAnnotations, newAnnotations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotations(IRequirement newAnnotations) {
		if (newAnnotations != annotations) {
			NotificationChain msgs = null;
			if (annotations != null)
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS, newAnnotations, newAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStereotype getStereotypes() {
		if (stereotypes != null && stereotypes.eIsProxy()) {
			InternalEObject oldStereotypes = (InternalEObject)stereotypes;
			stereotypes = (IStereotype)eResolveProxy(oldStereotypes);
			if (stereotypes != oldStereotypes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STEREOTYPES, oldStereotypes, stereotypes));
			}
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStereotype basicGetStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(IStereotype newStereotypes) {
		IStereotype oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL:
				return basicSetItsLabel(null, msgs);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
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
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STATIC_REACTION:
				return getStaticReaction();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET:
				if (resolve) return getItsTarget();
				return basicGetItsTarget();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ID:
				return getId();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL:
				if (resolve) return getItsLabel();
				return basicGetItsLabel();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__NAME:
				return getName();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_SOURCE:
				return getItsSource();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OF_STATE:
				if (resolve) return getOfState();
				return basicGetOfState();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ERROR_STATUS:
				return getErrorStatus();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__INHERITS_FROM_HANDLE:
				if (resolve) return getInheritsFromHandle();
				return basicGetInheritsFromHandle();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
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
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STATIC_REACTION:
				setStaticReaction((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET:
				setItsTarget((ItsTargetType)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL:
				setItsLabel((ItsLabelType)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_SOURCE:
				setItsSource((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OF_STATE:
				setOfState((IState)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ERROR_STATUS:
				setErrorStatus((String)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IDefaultDrvdTrans)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS:
				setAnnotations((IRequirement)newValue);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STEREOTYPES:
				setStereotypes((IStereotype)newValue);
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
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STATIC_REACTION:
				setStaticReaction(STATIC_REACTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET:
				setItsTarget((ItsTargetType)null);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL:
				setItsLabel((ItsLabelType)null);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_SOURCE:
				setItsSource(ITS_SOURCE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OF_STATE:
				setOfState((IState)null);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ERROR_STATUS:
				setErrorStatus(ERROR_STATUS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IDefaultDrvdTrans)null);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS:
				setAnnotations((IRequirement)null);
				return;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STEREOTYPES:
				setStereotypes((IStereotype)null);
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
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STATIC_REACTION:
				return STATIC_REACTION_EDEFAULT == null ? staticReaction != null : !STATIC_REACTION_EDEFAULT.equals(staticReaction);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET:
				return itsTarget != null;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL:
				return itsLabel != null;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_SOURCE:
				return ITS_SOURCE_EDEFAULT == null ? itsSource != null : !ITS_SOURCE_EDEFAULT.equals(itsSource);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OF_STATE:
				return ofState != null;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ERROR_STATUS:
				return ERROR_STATUS_EDEFAULT == null ? errorStatus != null : !ERROR_STATUS_EDEFAULT.equals(errorStatus);
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__INHERITS_FROM_HANDLE:
				return inheritsFromHandle != null;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ANNOTATIONS:
				return annotations != null;
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STEREOTYPES:
				return stereotypes != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TransitionsType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.TRANSITIONS_TYPE__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STATIC_REACTION: return UMLRhapsodyPackage.TRANSITIONS_TYPE__STATIC_REACTION;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET: return UMLRhapsodyPackage.TRANSITIONS_TYPE__ITS_TARGET;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ID: return UMLRhapsodyPackage.TRANSITIONS_TYPE__ID;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__CODE_UPDATE_CG_TIME: return UMLRhapsodyPackage.TRANSITIONS_TYPE__CODE_UPDATE_CG_TIME;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__REQUIREMEN_TRACABILITY_HANDLE: return UMLRhapsodyPackage.TRANSITIONS_TYPE__REQUIREMEN_TRACABILITY_HANDLE;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION: return UMLRhapsodyPackage.TRANSITIONS_TYPE__DESCRIPTION;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL: return UMLRhapsodyPackage.TRANSITIONS_TYPE__ITS_LABEL;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.TRANSITIONS_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MY_STATE: return UMLRhapsodyPackage.TRANSITIONS_TYPE__MY_STATE;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OBJECT_CREATION: return UMLRhapsodyPackage.TRANSITIONS_TYPE__OBJECT_CREATION;
				case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__NAME: return UMLRhapsodyPackage.TRANSITIONS_TYPE__NAME;
				default: return -1;
			}
		}
		if (baseClass == ElementsType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DependsOnType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TransitionsType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__STATIC_REACTION: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__STATIC_REACTION;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__ITS_TARGET: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_TARGET;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__ID: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ID;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__CODE_UPDATE_CG_TIME: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__CODE_UPDATE_CG_TIME;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__REQUIREMEN_TRACABILITY_HANDLE: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__REQUIREMEN_TRACABILITY_HANDLE;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__DESCRIPTION: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__DESCRIPTION;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__ITS_LABEL: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__ITS_LABEL;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__MY_STATE: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__MY_STATE;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__OBJECT_CREATION;
				case UMLRhapsodyPackage.TRANSITIONS_TYPE__NAME: return UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS__NAME;
				default: return -1;
			}
		}
		if (baseClass == ElementsType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DependsOnType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", staticReaction: "); //$NON-NLS-1$
		result.append(staticReaction);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", itsSource: "); //$NON-NLS-1$
		result.append(itsSource);
		result.append(", errorStatus: "); //$NON-NLS-1$
		result.append(errorStatus);
		result.append(')');
		return result.toString();
	}

} //IDefaultDrvdTransImpl
