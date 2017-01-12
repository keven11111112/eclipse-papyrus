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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ConveyedType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConstraint;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEvent;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IVariable;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IEvent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getSuperEvent <em>Super Event</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEventImpl#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IEventImpl extends IInterfaceItemImpl implements IEvent {
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
	 * The default value of the '{@link #getLastID() <em>Last ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastID()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastID() <em>Last ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastID()
	 * @generated
	 * @ordered
	 */
	protected String lastID = LAST_ID_EDEFAULT;

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
	 * The default value of the '{@link #getVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final String VIRTUAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtual()
	 * @generated
	 * @ordered
	 */
	protected String virtual = VIRTUAL_EDEFAULT;

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
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<IVariable> args;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected IDescription description;

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
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<IDependency> dependencies;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected ITag tags;

	/**
	 * The cached value of the '{@link #getSuperEvent() <em>Super Event</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> superEvent;

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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected IConstraint annotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIEvent();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__OBJECT_CREATION, oldObjectCreation, objectCreation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastID() {
		return lastID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastID(String newLastID) {
		String oldLastID = lastID;
		lastID = newLastID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__LAST_ID, oldLastID, lastID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVirtual() {
		return virtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtual(String newVirtual) {
		String oldVirtual = virtual;
		virtual = newVirtual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__VIRTUAL, oldVirtual, virtual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IEVENT__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IVariable> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList.Resolving<IVariable>(IVariable.class, this, UMLRhapsodyPackage.IEVENT__ARGS);
		}
		return args;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IEVENT__STEREOTYPES, oldStereotypes, stereotypes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__STEREOTYPES, oldStereotypes, stereotypes));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IEVENT__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__DESCRIPTION, newDescription, newDescription));
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IEVENT__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.IEVENT__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITag getTags() {
		if (tags != null && tags.eIsProxy()) {
			InternalEObject oldTags = (InternalEObject)tags;
			tags = (ITag)eResolveProxy(oldTags);
			if (tags != oldTags) {
				InternalEObject newTags = (InternalEObject)tags;
				NotificationChain msgs = oldTags.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__TAGS, null, null);
				if (newTags.eInternalContainer() == null) {
					msgs = newTags.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__TAGS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IEVENT__TAGS, oldTags, tags));
			}
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITag basicGetTags() {
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTags(ITag newTags, NotificationChain msgs) {
		ITag oldTags = tags;
		tags = newTags;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__TAGS, oldTags, newTags);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTags(ITag newTags) {
		if (newTags != tags) {
			NotificationChain msgs = null;
			if (tags != null)
				msgs = ((InternalEObject)tags).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__TAGS, null, msgs);
			if (newTags != null)
				msgs = ((InternalEObject)newTags).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__TAGS, null, msgs);
			msgs = basicSetTags(newTags, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__TAGS, newTags, newTags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getSuperEvent() {
		if (superEvent == null) {
			superEvent = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.IEVENT__SUPER_EVENT);
		}
		return superEvent;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstraint getAnnotations() {
		if (annotations != null && annotations.eIsProxy()) {
			InternalEObject oldAnnotations = (InternalEObject)annotations;
			annotations = (IConstraint)eResolveProxy(oldAnnotations);
			if (annotations != oldAnnotations) {
				InternalEObject newAnnotations = (InternalEObject)annotations;
				NotificationChain msgs = oldAnnotations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__ANNOTATIONS, null, null);
				if (newAnnotations.eInternalContainer() == null) {
					msgs = newAnnotations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__ANNOTATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IEVENT__ANNOTATIONS, oldAnnotations, annotations));
			}
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstraint basicGetAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotations(IConstraint newAnnotations, NotificationChain msgs) {
		IConstraint oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__ANNOTATIONS, oldAnnotations, newAnnotations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotations(IConstraint newAnnotations) {
		if (newAnnotations != annotations) {
			NotificationChain msgs = null;
			if (annotations != null)
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEVENT__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEVENT__ANNOTATIONS, newAnnotations, newAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IEVENT__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IEVENT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IEVENT__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.IEVENT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IEVENT__TAGS:
				return basicSetTags(null, msgs);
			case UMLRhapsodyPackage.IEVENT__ANNOTATIONS:
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
			case UMLRhapsodyPackage.IEVENT__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IEVENT__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IEVENT__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.IEVENT__ID:
				return getId();
			case UMLRhapsodyPackage.IEVENT__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IEVENT__NAME:
				return getName();
			case UMLRhapsodyPackage.IEVENT__VIRTUAL:
				return getVirtual();
			case UMLRhapsodyPackage.IEVENT__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IEVENT__ARGS:
				return getArgs();
			case UMLRhapsodyPackage.IEVENT__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IEVENT__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IEVENT__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IEVENT__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.IEVENT__TAGS:
				if (resolve) return getTags();
				return basicGetTags();
			case UMLRhapsodyPackage.IEVENT__SUPER_EVENT:
				return getSuperEvent();
			case UMLRhapsodyPackage.IEVENT__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IEVENT__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
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
			case UMLRhapsodyPackage.IEVENT__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__VIRTUAL:
				setVirtual((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends IVariable>)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__STEREOTYPES:
				setStereotypes((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__TAGS:
				setTags((ITag)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__SUPER_EVENT:
				getSuperEvent().clear();
				getSuperEvent().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IEVENT__ANNOTATIONS:
				setAnnotations((IConstraint)newValue);
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
			case UMLRhapsodyPackage.IEVENT__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__VIRTUAL:
				setVirtual(VIRTUAL_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IEVENT__ARGS:
				getArgs().clear();
				return;
			case UMLRhapsodyPackage.IEVENT__STEREOTYPES:
				setStereotypes((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IEVENT__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IEVENT__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.IEVENT__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.IEVENT__TAGS:
				setTags((ITag)null);
				return;
			case UMLRhapsodyPackage.IEVENT__SUPER_EVENT:
				getSuperEvent().clear();
				return;
			case UMLRhapsodyPackage.IEVENT__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEVENT__ANNOTATIONS:
				setAnnotations((IConstraint)null);
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
			case UMLRhapsodyPackage.IEVENT__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IEVENT__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IEVENT__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.IEVENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IEVENT__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IEVENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IEVENT__VIRTUAL:
				return VIRTUAL_EDEFAULT == null ? virtual != null : !VIRTUAL_EDEFAULT.equals(virtual);
			case UMLRhapsodyPackage.IEVENT__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IEVENT__ARGS:
				return args != null && !args.isEmpty();
			case UMLRhapsodyPackage.IEVENT__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IEVENT__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IEVENT__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IEVENT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.IEVENT__TAGS:
				return tags != null;
			case UMLRhapsodyPackage.IEVENT__SUPER_EVENT:
				return superEvent != null && !superEvent.isEmpty();
			case UMLRhapsodyPackage.IEVENT__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IEVENT__ANNOTATIONS:
				return annotations != null;
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
		if (baseClass == M_subjectType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IEVENT__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.IEVENT__OBJECT_CREATION: return UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == M_pFormalMessageType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ConveyedType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IEVENT__LAST_ID: return UMLRhapsodyPackage.CONVEYED_TYPE__LAST_ID;
				default: return -1;
			}
		}
		if (baseClass == TargetType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
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
		if (baseClass == M_subjectType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.IEVENT__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.IEVENT__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == M_pFormalMessageType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ConveyedType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.CONVEYED_TYPE__LAST_ID: return UMLRhapsodyPackage.IEVENT__LAST_ID;
				default: return -1;
			}
		}
		if (baseClass == TargetType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
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
		result.append(" (umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", virtual: "); //$NON-NLS-1$
		result.append(virtual);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(')');
		return result.toString();
	}

} //IEventImpl
