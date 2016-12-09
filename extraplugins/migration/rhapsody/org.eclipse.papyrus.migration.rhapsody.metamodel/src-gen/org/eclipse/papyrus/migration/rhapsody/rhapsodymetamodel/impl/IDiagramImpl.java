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
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultSubsystemType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphicChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnnotation;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OwnerHandleType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.PropertiesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TheMainDiagramType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IDiagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getLastModifiedTime <em>Last Modified Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getDefaultSubsystem <em>Default Subsystem</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getOwnerHandle <em>Owner Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getCmheader <em>Cmheader</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getGraphicChart <em>Graphic Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDiagramImpl#getHyperLinks <em>Hyper Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IDiagramImpl extends IUnitImpl implements IDiagram {
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
	 * The default value of the '{@link #getLastModifiedTime() <em>Last Modified Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModifiedTime()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_MODIFIED_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastModifiedTime() <em>Last Modified Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModifiedTime()
	 * @generated
	 * @ordered
	 */
	protected String lastModifiedTime = LAST_MODIFIED_TIME_EDEFAULT;

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
	 * The cached value of the '{@link #getDefaultSubsystem() <em>Default Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSubsystem()
	 * @generated
	 * @ordered
	 */
	protected DefaultSubsystemType defaultSubsystem;

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
	 * The cached value of the '{@link #getOwnerHandle() <em>Owner Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerHandle()
	 * @generated
	 * @ordered
	 */
	protected OwnerHandleType ownerHandle;

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
	 * The default value of the '{@link #getCmheader() <em>Cmheader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmheader()
	 * @generated
	 * @ordered
	 */
	protected static final String CMHEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCmheader() <em>Cmheader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmheader()
	 * @generated
	 * @ordered
	 */
	protected String cmheader = CMHEADER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected PropertiesType properties;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IModelElement stereotypes;

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
	 * The cached value of the '{@link #getGraphicChart() <em>Graphic Chart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicChart()
	 * @generated
	 * @ordered
	 */
	protected GraphicChartType graphicChart;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<IAnnotation> annotations;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<IMHyperLink> hyperLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIDiagram();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifiedTime(String newLastModifiedTime) {
		String oldLastModifiedTime = lastModifiedTime;
		lastModifiedTime = newLastModifiedTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__LAST_MODIFIED_TIME, oldLastModifiedTime, lastModifiedTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultSubsystemType getDefaultSubsystem() {
		if (defaultSubsystem != null && defaultSubsystem.eIsProxy()) {
			InternalEObject oldDefaultSubsystem = (InternalEObject)defaultSubsystem;
			defaultSubsystem = (DefaultSubsystemType)eResolveProxy(oldDefaultSubsystem);
			if (defaultSubsystem != oldDefaultSubsystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM, oldDefaultSubsystem, defaultSubsystem));
			}
		}
		return defaultSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultSubsystemType basicGetDefaultSubsystem() {
		return defaultSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultSubsystem(DefaultSubsystemType newDefaultSubsystem) {
		DefaultSubsystemType oldDefaultSubsystem = defaultSubsystem;
		defaultSubsystem = newDefaultSubsystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM, oldDefaultSubsystem, defaultSubsystem));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION, newDescription, newDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__LAST_ID, oldLastID, lastID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__MY_STATE, oldMyState, myState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OwnerHandleType getOwnerHandle() {
		if (ownerHandle != null && ownerHandle.eIsProxy()) {
			InternalEObject oldOwnerHandle = (InternalEObject)ownerHandle;
			ownerHandle = (OwnerHandleType)eResolveProxy(oldOwnerHandle);
			if (ownerHandle != oldOwnerHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
			}
		}
		return ownerHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OwnerHandleType basicGetOwnerHandle() {
		return ownerHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerHandle(OwnerHandleType newOwnerHandle) {
		OwnerHandleType oldOwnerHandle = ownerHandle;
		ownerHandle = newOwnerHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCmheader() {
		return cmheader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCmheader(String newCmheader) {
		String oldCmheader = cmheader;
		cmheader = newCmheader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__CMHEADER, oldCmheader, cmheader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesType getProperties() {
		if (properties != null && properties.eIsProxy()) {
			InternalEObject oldProperties = (InternalEObject)properties;
			properties = (PropertiesType)eResolveProxy(oldProperties);
			if (properties != oldProperties) {
				InternalEObject newProperties = (InternalEObject)properties;
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDIAGRAM__PROPERTIES, oldProperties, properties));
			}
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesType basicGetProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(PropertiesType newProperties, NotificationChain msgs) {
		PropertiesType oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(PropertiesType newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement getStereotypes() {
		if (stereotypes != null && stereotypes.eIsProxy()) {
			InternalEObject oldStereotypes = (InternalEObject)stereotypes;
			stereotypes = (IModelElement)eResolveProxy(oldStereotypes);
			if (stereotypes != oldStereotypes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDIAGRAM__STEREOTYPES, oldStereotypes, stereotypes));
			}
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement basicGetStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(IModelElement newStereotypes) {
		IModelElement oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IDIAGRAM__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicChartType getGraphicChart() {
		if (graphicChart != null && graphicChart.eIsProxy()) {
			InternalEObject oldGraphicChart = (InternalEObject)graphicChart;
			graphicChart = (GraphicChartType)eResolveProxy(oldGraphicChart);
			if (graphicChart != oldGraphicChart) {
				InternalEObject newGraphicChart = (InternalEObject)graphicChart;
				NotificationChain msgs = oldGraphicChart.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART, null, null);
				if (newGraphicChart.eInternalContainer() == null) {
					msgs = newGraphicChart.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART, oldGraphicChart, graphicChart));
			}
		}
		return graphicChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicChartType basicGetGraphicChart() {
		return graphicChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphicChart(GraphicChartType newGraphicChart, NotificationChain msgs) {
		GraphicChartType oldGraphicChart = graphicChart;
		graphicChart = newGraphicChart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART, oldGraphicChart, newGraphicChart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphicChart(GraphicChartType newGraphicChart) {
		if (newGraphicChart != graphicChart) {
			NotificationChain msgs = null;
			if (graphicChart != null)
				msgs = ((InternalEObject)graphicChart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART, null, msgs);
			if (newGraphicChart != null)
				msgs = ((InternalEObject)newGraphicChart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART, null, msgs);
			msgs = basicSetGraphicChart(newGraphicChart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART, newGraphicChart, newGraphicChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAnnotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList.Resolving<IAnnotation>(IAnnotation.class, this, UMLRhapsodyPackage.IDIAGRAM__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDIAGRAM__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IDIAGRAM__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMHyperLink> getHyperLinks() {
		if (hyperLinks == null) {
			hyperLinks = new EObjectContainmentEList.Resolving<IMHyperLink>(IMHyperLink.class, this, UMLRhapsodyPackage.IDIAGRAM__HYPER_LINKS);
		}
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IDIAGRAM__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART:
				return basicSetGraphicChart(null, msgs);
			case UMLRhapsodyPackage.IDIAGRAM__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IDIAGRAM__HYPER_LINKS:
				return ((InternalEList<?>)getHyperLinks()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.IDIAGRAM__ID:
				return getId();
			case UMLRhapsodyPackage.IDIAGRAM__LAST_MODIFIED_TIME:
				return getLastModifiedTime();
			case UMLRhapsodyPackage.IDIAGRAM__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM:
				if (resolve) return getDefaultSubsystem();
				return basicGetDefaultSubsystem();
			case UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IDIAGRAM__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IDIAGRAM__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.IDIAGRAM__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE:
				if (resolve) return getOwnerHandle();
				return basicGetOwnerHandle();
			case UMLRhapsodyPackage.IDIAGRAM__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IDIAGRAM__NAME:
				return getName();
			case UMLRhapsodyPackage.IDIAGRAM__CMHEADER:
				return getCmheader();
			case UMLRhapsodyPackage.IDIAGRAM__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IDIAGRAM__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IDIAGRAM__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART:
				if (resolve) return getGraphicChart();
				return basicGetGraphicChart();
			case UMLRhapsodyPackage.IDIAGRAM__ANNOTATIONS:
				return getAnnotations();
			case UMLRhapsodyPackage.IDIAGRAM__DISPLAY_NAME:
				return getDisplayName();
			case UMLRhapsodyPackage.IDIAGRAM__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.IDIAGRAM__HYPER_LINKS:
				return getHyperLinks();
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
			case UMLRhapsodyPackage.IDIAGRAM__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__LAST_MODIFIED_TIME:
				setLastModifiedTime((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM:
				setDefaultSubsystem((DefaultSubsystemType)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE:
				setOwnerHandle((OwnerHandleType)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__CMHEADER:
				setCmheader((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__PROPERTIES:
				setProperties((PropertiesType)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__STEREOTYPES:
				setStereotypes((IModelElement)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART:
				setGraphicChart((GraphicChartType)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends IAnnotation>)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__HYPER_LINKS:
				getHyperLinks().clear();
				getHyperLinks().addAll((Collection<? extends IMHyperLink>)newValue);
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
			case UMLRhapsodyPackage.IDIAGRAM__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__LAST_MODIFIED_TIME:
				setLastModifiedTime(LAST_MODIFIED_TIME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM:
				setDefaultSubsystem((DefaultSubsystemType)null);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE:
				setOwnerHandle((OwnerHandleType)null);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__CMHEADER:
				setCmheader(CMHEADER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__PROPERTIES:
				setProperties((PropertiesType)null);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__STEREOTYPES:
				setStereotypes((IModelElement)null);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART:
				setGraphicChart((GraphicChartType)null);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case UMLRhapsodyPackage.IDIAGRAM__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDIAGRAM__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.IDIAGRAM__HYPER_LINKS:
				getHyperLinks().clear();
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
			case UMLRhapsodyPackage.IDIAGRAM__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IDIAGRAM__LAST_MODIFIED_TIME:
				return LAST_MODIFIED_TIME_EDEFAULT == null ? lastModifiedTime != null : !LAST_MODIFIED_TIME_EDEFAULT.equals(lastModifiedTime);
			case UMLRhapsodyPackage.IDIAGRAM__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM:
				return defaultSubsystem != null;
			case UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IDIAGRAM__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IDIAGRAM__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.IDIAGRAM__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE:
				return ownerHandle != null;
			case UMLRhapsodyPackage.IDIAGRAM__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IDIAGRAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IDIAGRAM__CMHEADER:
				return CMHEADER_EDEFAULT == null ? cmheader != null : !CMHEADER_EDEFAULT.equals(cmheader);
			case UMLRhapsodyPackage.IDIAGRAM__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IDIAGRAM__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IDIAGRAM__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IDIAGRAM__GRAPHIC_CHART:
				return graphicChart != null;
			case UMLRhapsodyPackage.IDIAGRAM__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UMLRhapsodyPackage.IDIAGRAM__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case UMLRhapsodyPackage.IDIAGRAM__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.IDIAGRAM__HYPER_LINKS:
				return hyperLinks != null && !hyperLinks.isEmpty();
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
		if (baseClass == M_pModelObjectType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == TheMainDiagramType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IDIAGRAM__ID: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__ID;
				case UMLRhapsodyPackage.IDIAGRAM__LAST_MODIFIED_TIME: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__LAST_MODIFIED_TIME;
				case UMLRhapsodyPackage.IDIAGRAM__REQUIREMEN_TRACABILITY_HANDLE: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__REQUIREMEN_TRACABILITY_HANDLE;
				case UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__DEFAULT_SUBSYSTEM;
				case UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__DESCRIPTION;
				case UMLRhapsodyPackage.IDIAGRAM__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.IDIAGRAM__LAST_ID: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__LAST_ID;
				case UMLRhapsodyPackage.IDIAGRAM__MY_STATE: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__MY_STATE;
				case UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__OWNER_HANDLE;
				case UMLRhapsodyPackage.IDIAGRAM__OBJECT_CREATION: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__OBJECT_CREATION;
				case UMLRhapsodyPackage.IDIAGRAM__NAME: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__NAME;
				case UMLRhapsodyPackage.IDIAGRAM__CMHEADER: return UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__CMHEADER;
				default: return -1;
			}
		}
		if (baseClass == DeclarativesType.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == TargetType.class) {
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
		if (baseClass == M_pModelObjectType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == TheMainDiagramType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__ID: return UMLRhapsodyPackage.IDIAGRAM__ID;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__LAST_MODIFIED_TIME: return UMLRhapsodyPackage.IDIAGRAM__LAST_MODIFIED_TIME;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__REQUIREMEN_TRACABILITY_HANDLE: return UMLRhapsodyPackage.IDIAGRAM__REQUIREMEN_TRACABILITY_HANDLE;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__DEFAULT_SUBSYSTEM: return UMLRhapsodyPackage.IDIAGRAM__DEFAULT_SUBSYSTEM;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__DESCRIPTION: return UMLRhapsodyPackage.IDIAGRAM__DESCRIPTION;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.IDIAGRAM__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__LAST_ID: return UMLRhapsodyPackage.IDIAGRAM__LAST_ID;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__MY_STATE: return UMLRhapsodyPackage.IDIAGRAM__MY_STATE;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__OWNER_HANDLE: return UMLRhapsodyPackage.IDIAGRAM__OWNER_HANDLE;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.IDIAGRAM__OBJECT_CREATION;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__NAME: return UMLRhapsodyPackage.IDIAGRAM__NAME;
				case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE__CMHEADER: return UMLRhapsodyPackage.IDIAGRAM__CMHEADER;
				default: return -1;
			}
		}
		if (baseClass == DeclarativesType.class) {
			switch (baseFeatureID) {
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
		if (baseClass == TargetType.class) {
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
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", lastModifiedTime: "); //$NON-NLS-1$
		result.append(lastModifiedTime);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", cmheader: "); //$NON-NLS-1$
		result.append(cmheader);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(')');
		return result.toString();
	}

} //IDiagramImpl
