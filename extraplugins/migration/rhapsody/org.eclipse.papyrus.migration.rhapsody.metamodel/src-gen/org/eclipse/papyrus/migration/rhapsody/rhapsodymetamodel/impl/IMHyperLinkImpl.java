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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IM Hyper Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getLinkDispName <em>Link Disp Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getIsConfigurationFileHyperLink <em>Is Configuration File Hyper Link</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getLinkTarget <em>Link Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMHyperLinkImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IMHyperLinkImpl extends HyperLinksTypeImpl implements IMHyperLink {
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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected IPropertyContainer properties;

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
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected DependsOnType dependsOn;

	/**
	 * The default value of the '{@link #getLinkDispName() <em>Link Disp Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkDispName()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_DISP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkDispName() <em>Link Disp Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkDispName()
	 * @generated
	 * @ordered
	 */
	protected String linkDispName = LINK_DISP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected String linkType = LINK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsConfigurationFileHyperLink() <em>Is Configuration File Hyper Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsConfigurationFileHyperLink()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_CONFIGURATION_FILE_HYPER_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsConfigurationFileHyperLink() <em>Is Configuration File Hyper Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsConfigurationFileHyperLink()
	 * @generated
	 * @ordered
	 */
	protected String isConfigurationFileHyperLink = IS_CONFIGURATION_FILE_HYPER_LINK_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkTarget() <em>Link Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkTarget() <em>Link Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkTarget()
	 * @generated
	 * @ordered
	 */
	protected String linkTarget = LINK_TARGET_EDEFAULT;

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
	protected IMHyperLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIMHyperLink();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyContainer getProperties() {
		if (properties != null && properties.eIsProxy()) {
			InternalEObject oldProperties = (InternalEObject)properties;
			properties = (IPropertyContainer)eResolveProxy(oldProperties);
			if (properties != oldProperties) {
				InternalEObject newProperties = (InternalEObject)properties;
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES, oldProperties, properties));
			}
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyContainer basicGetProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(IPropertyContainer newProperties, NotificationChain msgs) {
		IPropertyContainer oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(IPropertyContainer newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IM_HYPER_LINK__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependsOnType getDependsOn() {
		if (dependsOn != null && dependsOn.eIsProxy()) {
			InternalEObject oldDependsOn = (InternalEObject)dependsOn;
			dependsOn = (DependsOnType)eResolveProxy(oldDependsOn);
			if (dependsOn != oldDependsOn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IM_HYPER_LINK__DEPENDS_ON, oldDependsOn, dependsOn));
			}
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependsOnType basicGetDependsOn() {
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependsOn(DependsOnType newDependsOn) {
		DependsOnType oldDependsOn = dependsOn;
		dependsOn = newDependsOn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__DEPENDS_ON, oldDependsOn, dependsOn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkDispName() {
		return linkDispName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkDispName(String newLinkDispName) {
		String oldLinkDispName = linkDispName;
		linkDispName = newLinkDispName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__LINK_DISP_NAME, oldLinkDispName, linkDispName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkType() {
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkType(String newLinkType) {
		String oldLinkType = linkType;
		linkType = newLinkType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TYPE, oldLinkType, linkType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsConfigurationFileHyperLink() {
		return isConfigurationFileHyperLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsConfigurationFileHyperLink(String newIsConfigurationFileHyperLink) {
		String oldIsConfigurationFileHyperLink = isConfigurationFileHyperLink;
		isConfigurationFileHyperLink = newIsConfigurationFileHyperLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__IS_CONFIGURATION_FILE_HYPER_LINK, oldIsConfigurationFileHyperLink, isConfigurationFileHyperLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkTarget() {
		return linkTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkTarget(String newLinkTarget) {
		String oldLinkTarget = linkTarget;
		linkTarget = newLinkTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TARGET, oldLinkTarget, linkTarget));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION, newDescription, newDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IM_HYPER_LINK__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION:
				return basicSetDescription(null, msgs);
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
			case UMLRhapsodyPackage.IM_HYPER_LINK__ID:
				return getId();
			case UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IM_HYPER_LINK__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IM_HYPER_LINK__DEPENDS_ON:
				if (resolve) return getDependsOn();
				return basicGetDependsOn();
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_DISP_NAME:
				return getLinkDispName();
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TYPE:
				return getLinkType();
			case UMLRhapsodyPackage.IM_HYPER_LINK__IS_CONFIGURATION_FILE_HYPER_LINK:
				return getIsConfigurationFileHyperLink();
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TARGET:
				return getLinkTarget();
			case UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IM_HYPER_LINK__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IM_HYPER_LINK__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IM_HYPER_LINK__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IM_HYPER_LINK__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__DEPENDS_ON:
				setDependsOn((DependsOnType)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_DISP_NAME:
				setLinkDispName((String)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TYPE:
				setLinkType((String)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__IS_CONFIGURATION_FILE_HYPER_LINK:
				setIsConfigurationFileHyperLink((String)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TARGET:
				setLinkTarget((String)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IM_HYPER_LINK__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__DEPENDS_ON:
				setDependsOn((DependsOnType)null);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_DISP_NAME:
				setLinkDispName(LINK_DISP_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TYPE:
				setLinkType(LINK_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__IS_CONFIGURATION_FILE_HYPER_LINK:
				setIsConfigurationFileHyperLink(IS_CONFIGURATION_FILE_HYPER_LINK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TARGET:
				setLinkTarget(LINK_TARGET_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IM_HYPER_LINK__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IM_HYPER_LINK__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IM_HYPER_LINK__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IM_HYPER_LINK__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IM_HYPER_LINK__DEPENDS_ON:
				return dependsOn != null;
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_DISP_NAME:
				return LINK_DISP_NAME_EDEFAULT == null ? linkDispName != null : !LINK_DISP_NAME_EDEFAULT.equals(linkDispName);
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TYPE:
				return LINK_TYPE_EDEFAULT == null ? linkType != null : !LINK_TYPE_EDEFAULT.equals(linkType);
			case UMLRhapsodyPackage.IM_HYPER_LINK__IS_CONFIGURATION_FILE_HYPER_LINK:
				return IS_CONFIGURATION_FILE_HYPER_LINK_EDEFAULT == null ? isConfigurationFileHyperLink != null : !IS_CONFIGURATION_FILE_HYPER_LINK_EDEFAULT.equals(isConfigurationFileHyperLink);
			case UMLRhapsodyPackage.IM_HYPER_LINK__LINK_TARGET:
				return LINK_TARGET_EDEFAULT == null ? linkTarget != null : !LINK_TARGET_EDEFAULT.equals(linkTarget);
			case UMLRhapsodyPackage.IM_HYPER_LINK__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IM_HYPER_LINK__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IM_HYPER_LINK__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IM_HYPER_LINK__UML_DEPENDENCY_ID:
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
		result.append(", linkDispName: "); //$NON-NLS-1$
		result.append(linkDispName);
		result.append(", linkType: "); //$NON-NLS-1$
		result.append(linkType);
		result.append(", isConfigurationFileHyperLink: "); //$NON-NLS-1$
		result.append(isConfigurationFileHyperLink);
		result.append(", linkTarget: "); //$NON-NLS-1$
		result.append(linkTarget);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //IMHyperLinkImpl
