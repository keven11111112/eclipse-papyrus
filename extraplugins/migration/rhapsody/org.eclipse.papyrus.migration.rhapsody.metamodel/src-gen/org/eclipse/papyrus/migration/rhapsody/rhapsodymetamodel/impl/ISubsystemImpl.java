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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.EmbededFilesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.HyperLinksType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInterfaceItem;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixLayout;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISubsystem;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.MatrixInstancesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OwnerHandleType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TableInstancesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TheMainDiagramType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ISubsystem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getDefaultComposite <em>Default Composite</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getEventsBaseID <em>Events Base ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getConfigurationRelatedTime <em>Configuration Related Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getCmheader <em>Cmheader</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getDeclaratives <em>Declaratives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getPredefinedTypes <em>Predefined Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getAssociationElements <em>Association Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getOwnerHandle <em>Owner Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getTableLayouts <em>Table Layouts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getMatrixLayouts <em>Matrix Layouts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getTableInstances <em>Table Instances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getMatrixInstances <em>Matrix Instances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getEmbededFiles <em>Embeded Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getComponentFiles <em>Component Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISubsystemImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ISubsystemImpl extends OwnerHandleTypeImpl implements ISubsystem {
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
	 * The cached value of the '{@link #getDefaultComposite() <em>Default Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultComposite()
	 * @generated
	 * @ordered
	 */
	protected IClass defaultComposite;

	/**
	 * The default value of the '{@link #getEventsBaseID() <em>Events Base ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventsBaseID()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENTS_BASE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventsBaseID() <em>Events Base ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventsBaseID()
	 * @generated
	 * @ordered
	 */
	protected String eventsBaseID = EVENTS_BASE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<IClass> classes;

	/**
	 * The cached value of the '{@link #getConfigurationRelatedTime() <em>Configuration Related Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationRelatedTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> configurationRelatedTime;

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
	 * The cached value of the '{@link #getDeclaratives() <em>Declaratives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaratives()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclarativesType> declaratives;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IUnit> types;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IUnit stereotypes;

	/**
	 * The default value of the '{@link #getPredefinedTypes() <em>Predefined Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedTypes()
	 * @generated
	 * @ordered
	 */
	protected static final String PREDEFINED_TYPES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPredefinedTypes() <em>Predefined Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedTypes()
	 * @generated
	 * @ordered
	 */
	protected String predefinedTypes = PREDEFINED_TYPES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<IInterfaceItem> events;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<IUnit> annotations;

	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<IClassifier> useCases;

	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<IClassifier> actors;

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
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<ITag> tags;

	/**
	 * The cached value of the '{@link #getAssociationElements() <em>Association Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> associationElements;

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
	 * The cached value of the '{@link #getOwnerHandle() <em>Owner Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerHandle()
	 * @generated
	 * @ordered
	 */
	protected OwnerHandleType ownerHandle;

	/**
	 * The cached value of the '{@link #getTheMainDiagram() <em>The Main Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheMainDiagram()
	 * @generated
	 * @ordered
	 */
	protected TheMainDiagramType theMainDiagram;

	/**
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected HyperLinksType hyperLinks;

	/**
	 * The cached value of the '{@link #getTableLayouts() <em>Table Layouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableLayouts()
	 * @generated
	 * @ordered
	 */
	protected EList<IModelElement> tableLayouts;

	/**
	 * The cached value of the '{@link #getMatrixLayouts() <em>Matrix Layouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatrixLayouts()
	 * @generated
	 * @ordered
	 */
	protected EList<IMatrixLayout> matrixLayouts;

	/**
	 * The cached value of the '{@link #getTableInstances() <em>Table Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<TableInstancesType> tableInstances;

	/**
	 * The cached value of the '{@link #getMatrixInstances() <em>Matrix Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatrixInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<MatrixInstancesType> matrixInstances;

	/**
	 * The cached value of the '{@link #getEmbededFiles() <em>Embeded Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmbededFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<EmbededFilesType> embededFiles;

	/**
	 * The cached value of the '{@link #getComponentFiles() <em>Component Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<IFile> componentFiles;

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
	protected ISubsystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getISubsystem();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ISUBSYSTEM__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass getDefaultComposite() {
		if (defaultComposite != null && defaultComposite.eIsProxy()) {
			InternalEObject oldDefaultComposite = (InternalEObject)defaultComposite;
			defaultComposite = (IClass)eResolveProxy(oldDefaultComposite);
			if (defaultComposite != oldDefaultComposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISUBSYSTEM__DEFAULT_COMPOSITE, oldDefaultComposite, defaultComposite));
			}
		}
		return defaultComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass basicGetDefaultComposite() {
		return defaultComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultComposite(IClass newDefaultComposite) {
		IClass oldDefaultComposite = defaultComposite;
		defaultComposite = newDefaultComposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__DEFAULT_COMPOSITE, oldDefaultComposite, defaultComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventsBaseID() {
		return eventsBaseID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventsBaseID(String newEventsBaseID) {
		String oldEventsBaseID = eventsBaseID;
		eventsBaseID = newEventsBaseID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__EVENTS_BASE_ID, oldEventsBaseID, eventsBaseID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList.Resolving<IClass>(IClass.class, this, UMLRhapsodyPackage.ISUBSYSTEM__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getConfigurationRelatedTime() {
		if (configurationRelatedTime == null) {
			configurationRelatedTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ISUBSYSTEM__CONFIGURATION_RELATED_TIME);
		}
		return configurationRelatedTime;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES, newProperties, newProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__LAST_ID, oldLastID, lastID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__CMHEADER, oldCmheader, cmheader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclarativesType> getDeclaratives() {
		if (declaratives == null) {
			declaratives = new EObjectContainmentEList.Resolving<DeclarativesType>(DeclarativesType.class, this, UMLRhapsodyPackage.ISUBSYSTEM__DECLARATIVES);
		}
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList.Resolving<IUnit>(IUnit.class, this, UMLRhapsodyPackage.ISUBSYSTEM__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit getStereotypes() {
		if (stereotypes != null && stereotypes.eIsProxy()) {
			InternalEObject oldStereotypes = (InternalEObject)stereotypes;
			stereotypes = (IUnit)eResolveProxy(oldStereotypes);
			if (stereotypes != oldStereotypes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISUBSYSTEM__STEREOTYPES, oldStereotypes, stereotypes));
			}
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit basicGetStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(IUnit newStereotypes) {
		IUnit oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPredefinedTypes() {
		return predefinedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedTypes(String newPredefinedTypes) {
		String oldPredefinedTypes = predefinedTypes;
		predefinedTypes = newPredefinedTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__PREDEFINED_TYPES, oldPredefinedTypes, predefinedTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IInterfaceItem> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList.Resolving<IInterfaceItem>(IInterfaceItem.class, this, UMLRhapsodyPackage.ISUBSYSTEM__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList.Resolving<IUnit>(IUnit.class, this, UMLRhapsodyPackage.ISUBSYSTEM__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClassifier> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectContainmentEList.Resolving<IClassifier>(IClassifier.class, this, UMLRhapsodyPackage.ISUBSYSTEM__USE_CASES);
		}
		return useCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClassifier> getActors() {
		if (actors == null) {
			actors = new EObjectContainmentEList.Resolving<IClassifier>(IClassifier.class, this, UMLRhapsodyPackage.ISUBSYSTEM__ACTORS);
		}
		return actors;
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.ISUBSYSTEM__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getAssociationElements() {
		if (associationElements == null) {
			associationElements = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.ISUBSYSTEM__ASSOCIATION_ELEMENTS);
		}
		return associationElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.ISUBSYSTEM__DEPENDENCIES);
		}
		return dependencies;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISUBSYSTEM__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TheMainDiagramType getTheMainDiagram() {
		if (theMainDiagram != null && theMainDiagram.eIsProxy()) {
			InternalEObject oldTheMainDiagram = (InternalEObject)theMainDiagram;
			theMainDiagram = (TheMainDiagramType)eResolveProxy(oldTheMainDiagram);
			if (theMainDiagram != oldTheMainDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISUBSYSTEM__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
			}
		}
		return theMainDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TheMainDiagramType basicGetTheMainDiagram() {
		return theMainDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheMainDiagram(TheMainDiagramType newTheMainDiagram) {
		TheMainDiagramType oldTheMainDiagram = theMainDiagram;
		theMainDiagram = newTheMainDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyperLinksType getHyperLinks() {
		if (hyperLinks != null && hyperLinks.eIsProxy()) {
			InternalEObject oldHyperLinks = (InternalEObject)hyperLinks;
			hyperLinks = (HyperLinksType)eResolveProxy(oldHyperLinks);
			if (hyperLinks != oldHyperLinks) {
				InternalEObject newHyperLinks = (InternalEObject)hyperLinks;
				NotificationChain msgs = oldHyperLinks.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS, null, null);
				if (newHyperLinks.eInternalContainer() == null) {
					msgs = newHyperLinks.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS, oldHyperLinks, hyperLinks));
			}
		}
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyperLinksType basicGetHyperLinks() {
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHyperLinks(HyperLinksType newHyperLinks, NotificationChain msgs) {
		HyperLinksType oldHyperLinks = hyperLinks;
		hyperLinks = newHyperLinks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS, oldHyperLinks, newHyperLinks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHyperLinks(HyperLinksType newHyperLinks) {
		if (newHyperLinks != hyperLinks) {
			NotificationChain msgs = null;
			if (hyperLinks != null)
				msgs = ((InternalEObject)hyperLinks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS, null, msgs);
			if (newHyperLinks != null)
				msgs = ((InternalEObject)newHyperLinks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS, null, msgs);
			msgs = basicSetHyperLinks(newHyperLinks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS, newHyperLinks, newHyperLinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IModelElement> getTableLayouts() {
		if (tableLayouts == null) {
			tableLayouts = new EObjectContainmentEList.Resolving<IModelElement>(IModelElement.class, this, UMLRhapsodyPackage.ISUBSYSTEM__TABLE_LAYOUTS);
		}
		return tableLayouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMatrixLayout> getMatrixLayouts() {
		if (matrixLayouts == null) {
			matrixLayouts = new EObjectContainmentEList.Resolving<IMatrixLayout>(IMatrixLayout.class, this, UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_LAYOUTS);
		}
		return matrixLayouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TableInstancesType> getTableInstances() {
		if (tableInstances == null) {
			tableInstances = new EObjectContainmentEList.Resolving<TableInstancesType>(TableInstancesType.class, this, UMLRhapsodyPackage.ISUBSYSTEM__TABLE_INSTANCES);
		}
		return tableInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MatrixInstancesType> getMatrixInstances() {
		if (matrixInstances == null) {
			matrixInstances = new EObjectContainmentEList.Resolving<MatrixInstancesType>(MatrixInstancesType.class, this, UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_INSTANCES);
		}
		return matrixInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EmbededFilesType> getEmbededFiles() {
		if (embededFiles == null) {
			embededFiles = new EObjectContainmentEList.Resolving<EmbededFilesType>(EmbededFilesType.class, this, UMLRhapsodyPackage.ISUBSYSTEM__EMBEDED_FILES);
		}
		return embededFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFile> getComponentFiles() {
		if (componentFiles == null) {
			componentFiles = new EObjectContainmentEList.Resolving<IFile>(IFile.class, this, UMLRhapsodyPackage.ISUBSYSTEM__COMPONENT_FILES);
		}
		return componentFiles;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ISUBSYSTEM__CODE_UPDATE_CG_TIME);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISUBSYSTEM__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ISUBSYSTEM__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__DECLARATIVES:
				return ((InternalEList<?>)getDeclaratives()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__USE_CASES:
				return ((InternalEList<?>)getUseCases()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__ACTORS:
				return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS:
				return basicSetHyperLinks(null, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_LAYOUTS:
				return ((InternalEList<?>)getTableLayouts()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_LAYOUTS:
				return ((InternalEList<?>)getMatrixLayouts()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_INSTANCES:
				return ((InternalEList<?>)getTableInstances()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_INSTANCES:
				return ((InternalEList<?>)getMatrixInstances()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__EMBEDED_FILES:
				return ((InternalEList<?>)getEmbededFiles()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISUBSYSTEM__COMPONENT_FILES:
				return ((InternalEList<?>)getComponentFiles()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.ISUBSYSTEM__ID:
				return getId();
			case UMLRhapsodyPackage.ISUBSYSTEM__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.ISUBSYSTEM__NAME:
				return getName();
			case UMLRhapsodyPackage.ISUBSYSTEM__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ISUBSYSTEM__DEFAULT_COMPOSITE:
				if (resolve) return getDefaultComposite();
				return basicGetDefaultComposite();
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS_BASE_ID:
				return getEventsBaseID();
			case UMLRhapsodyPackage.ISUBSYSTEM__CLASSES:
				return getClasses();
			case UMLRhapsodyPackage.ISUBSYSTEM__CONFIGURATION_RELATED_TIME:
				return getConfigurationRelatedTime();
			case UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.ISUBSYSTEM__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.ISUBSYSTEM__CMHEADER:
				return getCmheader();
			case UMLRhapsodyPackage.ISUBSYSTEM__DECLARATIVES:
				return getDeclaratives();
			case UMLRhapsodyPackage.ISUBSYSTEM__TYPES:
				return getTypes();
			case UMLRhapsodyPackage.ISUBSYSTEM__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.ISUBSYSTEM__PREDEFINED_TYPES:
				return getPredefinedTypes();
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS:
				return getEvents();
			case UMLRhapsodyPackage.ISUBSYSTEM__ANNOTATIONS:
				return getAnnotations();
			case UMLRhapsodyPackage.ISUBSYSTEM__USE_CASES:
				return getUseCases();
			case UMLRhapsodyPackage.ISUBSYSTEM__ACTORS:
				return getActors();
			case UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.ISUBSYSTEM__TAGS:
				return getTags();
			case UMLRhapsodyPackage.ISUBSYSTEM__ASSOCIATION_ELEMENTS:
				return getAssociationElements();
			case UMLRhapsodyPackage.ISUBSYSTEM__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.ISUBSYSTEM__OWNER_HANDLE:
				if (resolve) return getOwnerHandle();
				return basicGetOwnerHandle();
			case UMLRhapsodyPackage.ISUBSYSTEM__THE_MAIN_DIAGRAM:
				if (resolve) return getTheMainDiagram();
				return basicGetTheMainDiagram();
			case UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS:
				if (resolve) return getHyperLinks();
				return basicGetHyperLinks();
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_LAYOUTS:
				return getTableLayouts();
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_LAYOUTS:
				return getMatrixLayouts();
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_INSTANCES:
				return getTableInstances();
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_INSTANCES:
				return getMatrixInstances();
			case UMLRhapsodyPackage.ISUBSYSTEM__EMBEDED_FILES:
				return getEmbededFiles();
			case UMLRhapsodyPackage.ISUBSYSTEM__COMPONENT_FILES:
				return getComponentFiles();
			case UMLRhapsodyPackage.ISUBSYSTEM__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.ISUBSYSTEM__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.ISUBSYSTEM__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.ISUBSYSTEM__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ISUBSYSTEM__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DEFAULT_COMPOSITE:
				setDefaultComposite((IClass)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS_BASE_ID:
				setEventsBaseID((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends IClass>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CONFIGURATION_RELATED_TIME:
				getConfigurationRelatedTime().clear();
				getConfigurationRelatedTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CMHEADER:
				setCmheader((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DECLARATIVES:
				getDeclaratives().clear();
				getDeclaratives().addAll((Collection<? extends DeclarativesType>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__STEREOTYPES:
				setStereotypes((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__PREDEFINED_TYPES:
				setPredefinedTypes((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends IInterfaceItem>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__USE_CASES:
				getUseCases().clear();
				getUseCases().addAll((Collection<? extends IClassifier>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends IClassifier>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__ASSOCIATION_ELEMENTS:
				getAssociationElements().clear();
				getAssociationElements().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__OWNER_HANDLE:
				setOwnerHandle((OwnerHandleType)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS:
				setHyperLinks((HyperLinksType)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_LAYOUTS:
				getTableLayouts().clear();
				getTableLayouts().addAll((Collection<? extends IModelElement>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_LAYOUTS:
				getMatrixLayouts().clear();
				getMatrixLayouts().addAll((Collection<? extends IMatrixLayout>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_INSTANCES:
				getTableInstances().clear();
				getTableInstances().addAll((Collection<? extends TableInstancesType>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_INSTANCES:
				getMatrixInstances().clear();
				getMatrixInstances().addAll((Collection<? extends MatrixInstancesType>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__EMBEDED_FILES:
				getEmbededFiles().clear();
				getEmbededFiles().addAll((Collection<? extends EmbededFilesType>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__COMPONENT_FILES:
				getComponentFiles().clear();
				getComponentFiles().addAll((Collection<? extends IFile>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ISUBSYSTEM__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DEFAULT_COMPOSITE:
				setDefaultComposite((IClass)null);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS_BASE_ID:
				setEventsBaseID(EVENTS_BASE_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CLASSES:
				getClasses().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CONFIGURATION_RELATED_TIME:
				getConfigurationRelatedTime().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CMHEADER:
				setCmheader(CMHEADER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DECLARATIVES:
				getDeclaratives().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TYPES:
				getTypes().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__STEREOTYPES:
				setStereotypes((IUnit)null);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__PREDEFINED_TYPES:
				setPredefinedTypes(PREDEFINED_TYPES_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS:
				getEvents().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__USE_CASES:
				getUseCases().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__ACTORS:
				getActors().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__ASSOCIATION_ELEMENTS:
				getAssociationElements().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__OWNER_HANDLE:
				setOwnerHandle((OwnerHandleType)null);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)null);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS:
				setHyperLinks((HyperLinksType)null);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_LAYOUTS:
				getTableLayouts().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_LAYOUTS:
				getMatrixLayouts().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_INSTANCES:
				getTableInstances().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_INSTANCES:
				getMatrixInstances().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__EMBEDED_FILES:
				getEmbededFiles().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__COMPONENT_FILES:
				getComponentFiles().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISUBSYSTEM__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ISUBSYSTEM__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ISUBSYSTEM__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.ISUBSYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ISUBSYSTEM__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__DEFAULT_COMPOSITE:
				return defaultComposite != null;
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS_BASE_ID:
				return EVENTS_BASE_ID_EDEFAULT == null ? eventsBaseID != null : !EVENTS_BASE_ID_EDEFAULT.equals(eventsBaseID);
			case UMLRhapsodyPackage.ISUBSYSTEM__CLASSES:
				return classes != null && !classes.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__CONFIGURATION_RELATED_TIME:
				return configurationRelatedTime != null && !configurationRelatedTime.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.ISUBSYSTEM__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.ISUBSYSTEM__CMHEADER:
				return CMHEADER_EDEFAULT == null ? cmheader != null : !CMHEADER_EDEFAULT.equals(cmheader);
			case UMLRhapsodyPackage.ISUBSYSTEM__DECLARATIVES:
				return declaratives != null && !declaratives.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__TYPES:
				return types != null && !types.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.ISUBSYSTEM__PREDEFINED_TYPES:
				return PREDEFINED_TYPES_EDEFAULT == null ? predefinedTypes != null : !PREDEFINED_TYPES_EDEFAULT.equals(predefinedTypes);
			case UMLRhapsodyPackage.ISUBSYSTEM__EVENTS:
				return events != null && !events.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__USE_CASES:
				return useCases != null && !useCases.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__ACTORS:
				return actors != null && !actors.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.ISUBSYSTEM__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__ASSOCIATION_ELEMENTS:
				return associationElements != null && !associationElements.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__OWNER_HANDLE:
				return ownerHandle != null;
			case UMLRhapsodyPackage.ISUBSYSTEM__THE_MAIN_DIAGRAM:
				return theMainDiagram != null;
			case UMLRhapsodyPackage.ISUBSYSTEM__HYPER_LINKS:
				return hyperLinks != null;
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_LAYOUTS:
				return tableLayouts != null && !tableLayouts.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_LAYOUTS:
				return matrixLayouts != null && !matrixLayouts.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__TABLE_INSTANCES:
				return tableInstances != null && !tableInstances.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__MATRIX_INSTANCES:
				return matrixInstances != null && !matrixInstances.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__EMBEDED_FILES:
				return embededFiles != null && !embededFiles.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__COMPONENT_FILES:
				return componentFiles != null && !componentFiles.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.ISUBSYSTEM__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.ISUBSYSTEM__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.ISUBSYSTEM__UML_DEPENDENCY_ID:
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
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", eventsBaseID: "); //$NON-NLS-1$
		result.append(eventsBaseID);
		result.append(", configurationRelatedTime: "); //$NON-NLS-1$
		result.append(configurationRelatedTime);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", cmheader: "); //$NON-NLS-1$
		result.append(cmheader);
		result.append(", PredefinedTypes: "); //$NON-NLS-1$
		result.append(predefinedTypes);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //ISubsystemImpl
