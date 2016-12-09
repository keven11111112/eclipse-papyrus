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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End1_Type;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End2_Type;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEnd;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAttribute;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IGeneralization;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPort;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IRequirement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateChart;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pBaseType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OperationsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TheMainDiagramType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IActor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getWeakCGTime <em>Weak CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getStrongCGTime <em>Strong CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getStateCharts <em>State Charts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getItsStateChart <em>Its State Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getClassModifier <em>Class Modifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getInheritances <em>Inheritances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getComponentFiles <em>Component Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActorImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IActorImpl extends IClassifierImpl implements IActor {
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
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String MULTIPLICITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String multiplicity = MULTIPLICITY_EDEFAULT;

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
	 * The cached value of the '{@link #getTheMainDiagram() <em>The Main Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheMainDiagram()
	 * @generated
	 * @ordered
	 */
	protected TheMainDiagramType theMainDiagram;

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
	 * The cached value of the '{@link #getWeakCGTime() <em>Weak CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeakCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> weakCGTime;

	/**
	 * The cached value of the '{@link #getStrongCGTime() <em>Strong CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrongCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> strongCGTime;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationsType> operations;

	/**
	 * The cached value of the '{@link #getStateCharts() <em>State Charts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateCharts()
	 * @generated
	 * @ordered
	 */
	protected IStateChart stateCharts;

	/**
	 * The cached value of the '{@link #getItsStateChart() <em>Its State Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsStateChart()
	 * @generated
	 * @ordered
	 */
	protected IClass itsStateChart;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<IAssociationEnd> associations;

	/**
	 * The default value of the '{@link #getClassModifier() <em>Class Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassModifier()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_MODIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassModifier() <em>Class Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassModifier()
	 * @generated
	 * @ordered
	 */
	protected String classModifier = CLASS_MODIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected IMHyperLink hyperLinks;

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
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected IPort ports;

	/**
	 * The cached value of the '{@link #getInheritances() <em>Inheritances</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritances()
	 * @generated
	 * @ordered
	 */
	protected IGeneralization inheritances;

	/**
	 * The cached value of the '{@link #getAttrs() <em>Attrs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrs()
	 * @generated
	 * @ordered
	 */
	protected EList<IAttribute> attrs;

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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> annotations;

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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected IPropertyContainer properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIActor();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__OBJECT_CREATION, oldObjectCreation, objectCreation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(String newMultiplicity) {
		String oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__MULTIPLICITY, oldMultiplicity, multiplicity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.IACTOR__DEPENDENCIES);
		}
		return dependencies;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__LAST_ID, oldLastID, lastID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWeakCGTime() {
		if (weakCGTime == null) {
			weakCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IACTOR__WEAK_CG_TIME);
		}
		return weakCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStrongCGTime() {
		if (strongCGTime == null) {
			strongCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IACTOR__STRONG_CG_TIME);
		}
		return strongCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationsType> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList.Resolving<OperationsType>(OperationsType.class, this, UMLRhapsodyPackage.IACTOR__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChart getStateCharts() {
		if (stateCharts != null && stateCharts.eIsProxy()) {
			InternalEObject oldStateCharts = (InternalEObject)stateCharts;
			stateCharts = (IStateChart)eResolveProxy(oldStateCharts);
			if (stateCharts != oldStateCharts) {
				InternalEObject newStateCharts = (InternalEObject)stateCharts;
				NotificationChain msgs = oldStateCharts.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__STATE_CHARTS, null, null);
				if (newStateCharts.eInternalContainer() == null) {
					msgs = newStateCharts.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__STATE_CHARTS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__STATE_CHARTS, oldStateCharts, stateCharts));
			}
		}
		return stateCharts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChart basicGetStateCharts() {
		return stateCharts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateCharts(IStateChart newStateCharts, NotificationChain msgs) {
		IStateChart oldStateCharts = stateCharts;
		stateCharts = newStateCharts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__STATE_CHARTS, oldStateCharts, newStateCharts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateCharts(IStateChart newStateCharts) {
		if (newStateCharts != stateCharts) {
			NotificationChain msgs = null;
			if (stateCharts != null)
				msgs = ((InternalEObject)stateCharts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__STATE_CHARTS, null, msgs);
			if (newStateCharts != null)
				msgs = ((InternalEObject)newStateCharts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__STATE_CHARTS, null, msgs);
			msgs = basicSetStateCharts(newStateCharts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__STATE_CHARTS, newStateCharts, newStateCharts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass getItsStateChart() {
		if (itsStateChart != null && itsStateChart.eIsProxy()) {
			InternalEObject oldItsStateChart = (InternalEObject)itsStateChart;
			itsStateChart = (IClass)eResolveProxy(oldItsStateChart);
			if (itsStateChart != oldItsStateChart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__ITS_STATE_CHART, oldItsStateChart, itsStateChart));
			}
		}
		return itsStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass basicGetItsStateChart() {
		return itsStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsStateChart(IClass newItsStateChart) {
		IClass oldItsStateChart = itsStateChart;
		itsStateChart = newItsStateChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__ITS_STATE_CHART, oldItsStateChart, itsStateChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAssociationEnd> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList.Resolving<IAssociationEnd>(IAssociationEnd.class, this, UMLRhapsodyPackage.IACTOR__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassModifier() {
		return classModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassModifier(String newClassModifier) {
		String oldClassModifier = classModifier;
		classModifier = newClassModifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__CLASS_MODIFIER, oldClassModifier, classModifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMHyperLink getHyperLinks() {
		if (hyperLinks != null && hyperLinks.eIsProxy()) {
			InternalEObject oldHyperLinks = (InternalEObject)hyperLinks;
			hyperLinks = (IMHyperLink)eResolveProxy(oldHyperLinks);
			if (hyperLinks != oldHyperLinks) {
				InternalEObject newHyperLinks = (InternalEObject)hyperLinks;
				NotificationChain msgs = oldHyperLinks.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__HYPER_LINKS, null, null);
				if (newHyperLinks.eInternalContainer() == null) {
					msgs = newHyperLinks.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__HYPER_LINKS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__HYPER_LINKS, oldHyperLinks, hyperLinks));
			}
		}
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMHyperLink basicGetHyperLinks() {
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHyperLinks(IMHyperLink newHyperLinks, NotificationChain msgs) {
		IMHyperLink oldHyperLinks = hyperLinks;
		hyperLinks = newHyperLinks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__HYPER_LINKS, oldHyperLinks, newHyperLinks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHyperLinks(IMHyperLink newHyperLinks) {
		if (newHyperLinks != hyperLinks) {
			NotificationChain msgs = null;
			if (hyperLinks != null)
				msgs = ((InternalEObject)hyperLinks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__HYPER_LINKS, null, msgs);
			if (newHyperLinks != null)
				msgs = ((InternalEObject)newHyperLinks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__HYPER_LINKS, null, msgs);
			msgs = basicSetHyperLinks(newHyperLinks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__HYPER_LINKS, newHyperLinks, newHyperLinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IACTOR__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPort getPorts() {
		if (ports != null && ports.eIsProxy()) {
			InternalEObject oldPorts = (InternalEObject)ports;
			ports = (IPort)eResolveProxy(oldPorts);
			if (ports != oldPorts) {
				InternalEObject newPorts = (InternalEObject)ports;
				NotificationChain msgs = oldPorts.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PORTS, null, null);
				if (newPorts.eInternalContainer() == null) {
					msgs = newPorts.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PORTS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__PORTS, oldPorts, ports));
			}
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPort basicGetPorts() {
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPorts(IPort newPorts, NotificationChain msgs) {
		IPort oldPorts = ports;
		ports = newPorts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__PORTS, oldPorts, newPorts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPorts(IPort newPorts) {
		if (newPorts != ports) {
			NotificationChain msgs = null;
			if (ports != null)
				msgs = ((InternalEObject)ports).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PORTS, null, msgs);
			if (newPorts != null)
				msgs = ((InternalEObject)newPorts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PORTS, null, msgs);
			msgs = basicSetPorts(newPorts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__PORTS, newPorts, newPorts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IGeneralization getInheritances() {
		if (inheritances != null && inheritances.eIsProxy()) {
			InternalEObject oldInheritances = (InternalEObject)inheritances;
			inheritances = (IGeneralization)eResolveProxy(oldInheritances);
			if (inheritances != oldInheritances) {
				InternalEObject newInheritances = (InternalEObject)inheritances;
				NotificationChain msgs = oldInheritances.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__INHERITANCES, null, null);
				if (newInheritances.eInternalContainer() == null) {
					msgs = newInheritances.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__INHERITANCES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__INHERITANCES, oldInheritances, inheritances));
			}
		}
		return inheritances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IGeneralization basicGetInheritances() {
		return inheritances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInheritances(IGeneralization newInheritances, NotificationChain msgs) {
		IGeneralization oldInheritances = inheritances;
		inheritances = newInheritances;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__INHERITANCES, oldInheritances, newInheritances);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritances(IGeneralization newInheritances) {
		if (newInheritances != inheritances) {
			NotificationChain msgs = null;
			if (inheritances != null)
				msgs = ((InternalEObject)inheritances).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__INHERITANCES, null, msgs);
			if (newInheritances != null)
				msgs = ((InternalEObject)newInheritances).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__INHERITANCES, null, msgs);
			msgs = basicSetInheritances(newInheritances, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__INHERITANCES, newInheritances, newInheritances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAttribute> getAttrs() {
		if (attrs == null) {
			attrs = new EObjectContainmentEList.Resolving<IAttribute>(IAttribute.class, this, UMLRhapsodyPackage.IACTOR__ATTRS);
		}
		return attrs;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IRequirement> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList.Resolving<IRequirement>(IRequirement.class, this, UMLRhapsodyPackage.IACTOR__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFile> getComponentFiles() {
		if (componentFiles == null) {
			componentFiles = new EObjectContainmentEList.Resolving<IFile>(IFile.class, this, UMLRhapsodyPackage.IACTOR__COMPONENT_FILES);
		}
		return componentFiles;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTOR__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTOR__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTOR__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IACTOR__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTOR__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTOR__STATE_CHARTS:
				return basicSetStateCharts(null, msgs);
			case UMLRhapsodyPackage.IACTOR__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTOR__HYPER_LINKS:
				return basicSetHyperLinks(null, msgs);
			case UMLRhapsodyPackage.IACTOR__PORTS:
				return basicSetPorts(null, msgs);
			case UMLRhapsodyPackage.IACTOR__INHERITANCES:
				return basicSetInheritances(null, msgs);
			case UMLRhapsodyPackage.IACTOR__ATTRS:
				return ((InternalEList<?>)getAttrs()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTOR__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IACTOR__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTOR__COMPONENT_FILES:
				return ((InternalEList<?>)getComponentFiles()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTOR__PROPERTIES:
				return basicSetProperties(null, msgs);
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
			case UMLRhapsodyPackage.IACTOR__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IACTOR__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IACTOR__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.IACTOR__ID:
				return getId();
			case UMLRhapsodyPackage.IACTOR__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IACTOR__NAME:
				return getName();
			case UMLRhapsodyPackage.IACTOR__THE_MAIN_DIAGRAM:
				if (resolve) return getTheMainDiagram();
				return basicGetTheMainDiagram();
			case UMLRhapsodyPackage.IACTOR__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.IACTOR__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.IACTOR__WEAK_CG_TIME:
				return getWeakCGTime();
			case UMLRhapsodyPackage.IACTOR__STRONG_CG_TIME:
				return getStrongCGTime();
			case UMLRhapsodyPackage.IACTOR__OPERATIONS:
				return getOperations();
			case UMLRhapsodyPackage.IACTOR__STATE_CHARTS:
				if (resolve) return getStateCharts();
				return basicGetStateCharts();
			case UMLRhapsodyPackage.IACTOR__ITS_STATE_CHART:
				if (resolve) return getItsStateChart();
				return basicGetItsStateChart();
			case UMLRhapsodyPackage.IACTOR__ASSOCIATIONS:
				return getAssociations();
			case UMLRhapsodyPackage.IACTOR__CLASS_MODIFIER:
				return getClassModifier();
			case UMLRhapsodyPackage.IACTOR__HYPER_LINKS:
				if (resolve) return getHyperLinks();
				return basicGetHyperLinks();
			case UMLRhapsodyPackage.IACTOR__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IACTOR__PORTS:
				if (resolve) return getPorts();
				return basicGetPorts();
			case UMLRhapsodyPackage.IACTOR__INHERITANCES:
				if (resolve) return getInheritances();
				return basicGetInheritances();
			case UMLRhapsodyPackage.IACTOR__ATTRS:
				return getAttrs();
			case UMLRhapsodyPackage.IACTOR__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IACTOR__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IACTOR__ANNOTATIONS:
				return getAnnotations();
			case UMLRhapsodyPackage.IACTOR__COMPONENT_FILES:
				return getComponentFiles();
			case UMLRhapsodyPackage.IACTOR__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
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
			case UMLRhapsodyPackage.IACTOR__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__WEAK_CG_TIME:
				getWeakCGTime().clear();
				getWeakCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__STRONG_CG_TIME:
				getStrongCGTime().clear();
				getStrongCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationsType>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__STATE_CHARTS:
				setStateCharts((IStateChart)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__ITS_STATE_CHART:
				setItsStateChart((IClass)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends IAssociationEnd>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__CLASS_MODIFIER:
				setClassModifier((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__HYPER_LINKS:
				setHyperLinks((IMHyperLink)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__PORTS:
				setPorts((IPort)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__INHERITANCES:
				setInheritances((IGeneralization)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__ATTRS:
				getAttrs().clear();
				getAttrs().addAll((Collection<? extends IAttribute>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends IRequirement>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__COMPONENT_FILES:
				getComponentFiles().clear();
				getComponentFiles().addAll((Collection<? extends IFile>)newValue);
				return;
			case UMLRhapsodyPackage.IACTOR__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
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
			case UMLRhapsodyPackage.IACTOR__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)null);
				return;
			case UMLRhapsodyPackage.IACTOR__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__WEAK_CG_TIME:
				getWeakCGTime().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__STRONG_CG_TIME:
				getStrongCGTime().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__OPERATIONS:
				getOperations().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__STATE_CHARTS:
				setStateCharts((IStateChart)null);
				return;
			case UMLRhapsodyPackage.IACTOR__ITS_STATE_CHART:
				setItsStateChart((IClass)null);
				return;
			case UMLRhapsodyPackage.IACTOR__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__CLASS_MODIFIER:
				setClassModifier(CLASS_MODIFIER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__HYPER_LINKS:
				setHyperLinks((IMHyperLink)null);
				return;
			case UMLRhapsodyPackage.IACTOR__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__PORTS:
				setPorts((IPort)null);
				return;
			case UMLRhapsodyPackage.IACTOR__INHERITANCES:
				setInheritances((IGeneralization)null);
				return;
			case UMLRhapsodyPackage.IACTOR__ATTRS:
				getAttrs().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTOR__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IACTOR__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__COMPONENT_FILES:
				getComponentFiles().clear();
				return;
			case UMLRhapsodyPackage.IACTOR__PROPERTIES:
				setProperties((IPropertyContainer)null);
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
			case UMLRhapsodyPackage.IACTOR__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IACTOR__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IACTOR__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.IACTOR__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IACTOR__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IACTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IACTOR__THE_MAIN_DIAGRAM:
				return theMainDiagram != null;
			case UMLRhapsodyPackage.IACTOR__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.IACTOR__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.IACTOR__WEAK_CG_TIME:
				return weakCGTime != null && !weakCGTime.isEmpty();
			case UMLRhapsodyPackage.IACTOR__STRONG_CG_TIME:
				return strongCGTime != null && !strongCGTime.isEmpty();
			case UMLRhapsodyPackage.IACTOR__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case UMLRhapsodyPackage.IACTOR__STATE_CHARTS:
				return stateCharts != null;
			case UMLRhapsodyPackage.IACTOR__ITS_STATE_CHART:
				return itsStateChart != null;
			case UMLRhapsodyPackage.IACTOR__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case UMLRhapsodyPackage.IACTOR__CLASS_MODIFIER:
				return CLASS_MODIFIER_EDEFAULT == null ? classModifier != null : !CLASS_MODIFIER_EDEFAULT.equals(classModifier);
			case UMLRhapsodyPackage.IACTOR__HYPER_LINKS:
				return hyperLinks != null;
			case UMLRhapsodyPackage.IACTOR__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IACTOR__PORTS:
				return ports != null;
			case UMLRhapsodyPackage.IACTOR__INHERITANCES:
				return inheritances != null;
			case UMLRhapsodyPackage.IACTOR__ATTRS:
				return attrs != null && !attrs.isEmpty();
			case UMLRhapsodyPackage.IACTOR__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IACTOR__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IACTOR__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UMLRhapsodyPackage.IACTOR__COMPONENT_FILES:
				return componentFiles != null && !componentFiles.isEmpty();
			case UMLRhapsodyPackage.IACTOR__PROPERTIES:
				return properties != null;
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
		if (baseClass == M_pBaseType.class) {
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
		if (baseClass == M_subjectType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IACTOR__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.IACTOR__OBJECT_CREATION: return UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == End1_Type.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == End2_Type.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IACTOR__MULTIPLICITY: return UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY;
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
		if (baseClass == M_pBaseType.class) {
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
		if (baseClass == M_subjectType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.IACTOR__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.IACTOR__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == End1_Type.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == End2_Type.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY: return UMLRhapsodyPackage.IACTOR__MULTIPLICITY;
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
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", weakCGTime: "); //$NON-NLS-1$
		result.append(weakCGTime);
		result.append(", strongCGTime: "); //$NON-NLS-1$
		result.append(strongCGTime);
		result.append(", classModifier: "); //$NON-NLS-1$
		result.append(classModifier);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(')');
		return result.toString();
	}

} //IActorImpl
