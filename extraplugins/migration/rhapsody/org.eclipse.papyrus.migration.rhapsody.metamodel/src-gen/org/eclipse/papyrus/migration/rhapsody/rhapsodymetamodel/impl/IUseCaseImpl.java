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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.AssociationsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End1_Type;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End2_Type;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityGraph;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnnotation;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAttribute;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEmbededFile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IGeneralization;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISubsystem;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCase;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCaseStereoType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.NestedStateChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OperationsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TheMainDiagramType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IUse Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getWeakCGTime <em>Weak CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getStrongCGTime <em>Strong CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getClassModifier <em>Class Modifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getInheritances <em>Inheritances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getUseCaseStereoTypes <em>Use Case Stereo Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getEntryPoints <em>Entry Points</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getCmheader <em>Cmheader</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getOwnerHandle <em>Owner Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getDeclaratives <em>Declaratives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getStateCharts <em>State Charts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getItsStateChart <em>Its State Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getEmbededFiles <em>Embeded Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getObjectLinks <em>Object Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IUseCaseImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IUseCaseImpl extends IClassifierImpl implements IUseCase {
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
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<IMHyperLink> hyperLinks;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected IDescription description;

	/**
	 * The cached value of the '{@link #getInheritances() <em>Inheritances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritances()
	 * @generated
	 * @ordered
	 */
	protected EList<IGeneralization> inheritances;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationsType> associations;

	/**
	 * The cached value of the '{@link #getUseCaseStereoTypes() <em>Use Case Stereo Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCaseStereoTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IUseCaseStereoType> useCaseStereoTypes;

	/**
	 * The default value of the '{@link #getEntryPoints() <em>Entry Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPoints()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_POINTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryPoints() <em>Entry Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPoints()
	 * @generated
	 * @ordered
	 */
	protected String entryPoints = ENTRY_POINTS_EDEFAULT;

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
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclarativesType> diagrams;

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
	 * The cached value of the '{@link #getOwnerHandle() <em>Owner Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerHandle()
	 * @generated
	 * @ordered
	 */
	protected ISubsystem ownerHandle;

	/**
	 * The cached value of the '{@link #getDeclaratives() <em>Declaratives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaratives()
	 * @generated
	 * @ordered
	 */
	protected EList<DependsOnType> declaratives;

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
	 * The cached value of the '{@link #getStateCharts() <em>State Charts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateCharts()
	 * @generated
	 * @ordered
	 */
	protected EList<IActivityGraph> stateCharts;

	/**
	 * The cached value of the '{@link #getItsStateChart() <em>Its State Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsStateChart()
	 * @generated
	 * @ordered
	 */
	protected NestedStateChartType itsStateChart;

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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<IAnnotation> annotations;

	/**
	 * The cached value of the '{@link #getEmbededFiles() <em>Embeded Files</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmbededFiles()
	 * @generated
	 * @ordered
	 */
	protected IEmbededFile embededFiles;

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
	 * The cached value of the '{@link #getObjectLinks() <em>Object Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<IObjectLink> objectLinks;

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
	protected IUseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIUseCase();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__MULTIPLICITY, oldMultiplicity, multiplicity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IUSE_CASE__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMHyperLink> getHyperLinks() {
		if (hyperLinks == null) {
			hyperLinks = new EObjectContainmentEList.Resolving<IMHyperLink>(IMHyperLink.class, this, UMLRhapsodyPackage.IUSE_CASE__HYPER_LINKS);
		}
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWeakCGTime() {
		if (weakCGTime == null) {
			weakCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IUSE_CASE__WEAK_CG_TIME);
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
			strongCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IUSE_CASE__STRONG_CG_TIME);
		}
		return strongCGTime;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__CLASS_MODIFIER, oldClassModifier, classModifier));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IGeneralization> getInheritances() {
		if (inheritances == null) {
			inheritances = new EObjectContainmentEList.Resolving<IGeneralization>(IGeneralization.class, this, UMLRhapsodyPackage.IUSE_CASE__INHERITANCES);
		}
		return inheritances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssociationsType> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList.Resolving<AssociationsType>(AssociationsType.class, this, UMLRhapsodyPackage.IUSE_CASE__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUseCaseStereoType> getUseCaseStereoTypes() {
		if (useCaseStereoTypes == null) {
			useCaseStereoTypes = new EObjectContainmentEList.Resolving<IUseCaseStereoType>(IUseCaseStereoType.class, this, UMLRhapsodyPackage.IUSE_CASE__USE_CASE_STEREO_TYPES);
		}
		return useCaseStereoTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryPoints() {
		return entryPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryPoints(String newEntryPoints) {
		String oldEntryPoints = entryPoints;
		entryPoints = newEntryPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__ENTRY_POINTS, oldEntryPoints, entryPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.IUSE_CASE__DEPENDENCIES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__LAST_ID, oldLastID, lastID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclarativesType> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectResolvingEList<DeclarativesType>(DeclarativesType.class, this, UMLRhapsodyPackage.IUSE_CASE__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IUSE_CASE__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__CMHEADER, oldCmheader, cmheader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISubsystem getOwnerHandle() {
		if (ownerHandle != null && ownerHandle.eIsProxy()) {
			InternalEObject oldOwnerHandle = (InternalEObject)ownerHandle;
			ownerHandle = (ISubsystem)eResolveProxy(oldOwnerHandle);
			if (ownerHandle != oldOwnerHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IUSE_CASE__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
			}
		}
		return ownerHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISubsystem basicGetOwnerHandle() {
		return ownerHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerHandle(ISubsystem newOwnerHandle) {
		ISubsystem oldOwnerHandle = ownerHandle;
		ownerHandle = newOwnerHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependsOnType> getDeclaratives() {
		if (declaratives == null) {
			declaratives = new EObjectContainmentEList.Resolving<DependsOnType>(DependsOnType.class, this, UMLRhapsodyPackage.IUSE_CASE__DECLARATIVES);
		}
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationsType> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList.Resolving<OperationsType>(OperationsType.class, this, UMLRhapsodyPackage.IUSE_CASE__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IActivityGraph> getStateCharts() {
		if (stateCharts == null) {
			stateCharts = new EObjectContainmentEList.Resolving<IActivityGraph>(IActivityGraph.class, this, UMLRhapsodyPackage.IUSE_CASE__STATE_CHARTS);
		}
		return stateCharts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedStateChartType getItsStateChart() {
		if (itsStateChart != null && itsStateChart.eIsProxy()) {
			InternalEObject oldItsStateChart = (InternalEObject)itsStateChart;
			itsStateChart = (NestedStateChartType)eResolveProxy(oldItsStateChart);
			if (itsStateChart != oldItsStateChart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IUSE_CASE__ITS_STATE_CHART, oldItsStateChart, itsStateChart));
			}
		}
		return itsStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedStateChartType basicGetItsStateChart() {
		return itsStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsStateChart(NestedStateChartType newItsStateChart) {
		NestedStateChartType oldItsStateChart = itsStateChart;
		itsStateChart = newItsStateChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__ITS_STATE_CHART, oldItsStateChart, itsStateChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAttribute> getAttrs() {
		if (attrs == null) {
			attrs = new EObjectContainmentEList.Resolving<IAttribute>(IAttribute.class, this, UMLRhapsodyPackage.IUSE_CASE__ATTRS);
		}
		return attrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAnnotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList.Resolving<IAnnotation>(IAnnotation.class, this, UMLRhapsodyPackage.IUSE_CASE__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEmbededFile getEmbededFiles() {
		if (embededFiles != null && embededFiles.eIsProxy()) {
			InternalEObject oldEmbededFiles = (InternalEObject)embededFiles;
			embededFiles = (IEmbededFile)eResolveProxy(oldEmbededFiles);
			if (embededFiles != oldEmbededFiles) {
				InternalEObject newEmbededFiles = (InternalEObject)embededFiles;
				NotificationChain msgs = oldEmbededFiles.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES, null, null);
				if (newEmbededFiles.eInternalContainer() == null) {
					msgs = newEmbededFiles.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES, oldEmbededFiles, embededFiles));
			}
		}
		return embededFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEmbededFile basicGetEmbededFiles() {
		return embededFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmbededFiles(IEmbededFile newEmbededFiles, NotificationChain msgs) {
		IEmbededFile oldEmbededFiles = embededFiles;
		embededFiles = newEmbededFiles;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES, oldEmbededFiles, newEmbededFiles);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmbededFiles(IEmbededFile newEmbededFiles) {
		if (newEmbededFiles != embededFiles) {
			NotificationChain msgs = null;
			if (embededFiles != null)
				msgs = ((InternalEObject)embededFiles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES, null, msgs);
			if (newEmbededFiles != null)
				msgs = ((InternalEObject)newEmbededFiles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES, null, msgs);
			msgs = basicSetEmbededFiles(newEmbededFiles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES, newEmbededFiles, newEmbededFiles));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IObjectLink> getObjectLinks() {
		if (objectLinks == null) {
			objectLinks = new EObjectContainmentEList.Resolving<IObjectLink>(IObjectLink.class, this, UMLRhapsodyPackage.IUSE_CASE__OBJECT_LINKS);
		}
		return objectLinks;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IUSE_CASE__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IUSE_CASE__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IUSE_CASE__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IUSE_CASE__HYPER_LINKS:
				return ((InternalEList<?>)getHyperLinks()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__INHERITANCES:
				return ((InternalEList<?>)getInheritances()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__USE_CASE_STEREO_TYPES:
				return ((InternalEList<?>)getUseCaseStereoTypes()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__DECLARATIVES:
				return ((InternalEList<?>)getDeclaratives()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__STATE_CHARTS:
				return ((InternalEList<?>)getStateCharts()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__ATTRS:
				return ((InternalEList<?>)getAttrs()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES:
				return basicSetEmbededFiles(null, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_LINKS:
				return ((InternalEList<?>)getObjectLinks()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IUSE_CASE__PROPERTIES:
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
			case UMLRhapsodyPackage.IUSE_CASE__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.IUSE_CASE__ID:
				return getId();
			case UMLRhapsodyPackage.IUSE_CASE__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IUSE_CASE__NAME:
				return getName();
			case UMLRhapsodyPackage.IUSE_CASE__THE_MAIN_DIAGRAM:
				if (resolve) return getTheMainDiagram();
				return basicGetTheMainDiagram();
			case UMLRhapsodyPackage.IUSE_CASE__HYPER_LINKS:
				return getHyperLinks();
			case UMLRhapsodyPackage.IUSE_CASE__WEAK_CG_TIME:
				return getWeakCGTime();
			case UMLRhapsodyPackage.IUSE_CASE__STRONG_CG_TIME:
				return getStrongCGTime();
			case UMLRhapsodyPackage.IUSE_CASE__CLASS_MODIFIER:
				return getClassModifier();
			case UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IUSE_CASE__INHERITANCES:
				return getInheritances();
			case UMLRhapsodyPackage.IUSE_CASE__ASSOCIATIONS:
				return getAssociations();
			case UMLRhapsodyPackage.IUSE_CASE__USE_CASE_STEREO_TYPES:
				return getUseCaseStereoTypes();
			case UMLRhapsodyPackage.IUSE_CASE__ENTRY_POINTS:
				return getEntryPoints();
			case UMLRhapsodyPackage.IUSE_CASE__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.IUSE_CASE__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.IUSE_CASE__DIAGRAMS:
				return getDiagrams();
			case UMLRhapsodyPackage.IUSE_CASE__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IUSE_CASE__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IUSE_CASE__CMHEADER:
				return getCmheader();
			case UMLRhapsodyPackage.IUSE_CASE__OWNER_HANDLE:
				if (resolve) return getOwnerHandle();
				return basicGetOwnerHandle();
			case UMLRhapsodyPackage.IUSE_CASE__DECLARATIVES:
				return getDeclaratives();
			case UMLRhapsodyPackage.IUSE_CASE__OPERATIONS:
				return getOperations();
			case UMLRhapsodyPackage.IUSE_CASE__STATE_CHARTS:
				return getStateCharts();
			case UMLRhapsodyPackage.IUSE_CASE__ITS_STATE_CHART:
				if (resolve) return getItsStateChart();
				return basicGetItsStateChart();
			case UMLRhapsodyPackage.IUSE_CASE__ATTRS:
				return getAttrs();
			case UMLRhapsodyPackage.IUSE_CASE__ANNOTATIONS:
				return getAnnotations();
			case UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES:
				if (resolve) return getEmbededFiles();
				return basicGetEmbededFiles();
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IUSE_CASE__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_LINKS:
				return getObjectLinks();
			case UMLRhapsodyPackage.IUSE_CASE__PROPERTIES:
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
			case UMLRhapsodyPackage.IUSE_CASE__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__HYPER_LINKS:
				getHyperLinks().clear();
				getHyperLinks().addAll((Collection<? extends IMHyperLink>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__WEAK_CG_TIME:
				getWeakCGTime().clear();
				getWeakCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__STRONG_CG_TIME:
				getStrongCGTime().clear();
				getStrongCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__CLASS_MODIFIER:
				setClassModifier((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__INHERITANCES:
				getInheritances().clear();
				getInheritances().addAll((Collection<? extends IGeneralization>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends AssociationsType>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__USE_CASE_STEREO_TYPES:
				getUseCaseStereoTypes().clear();
				getUseCaseStereoTypes().addAll((Collection<? extends IUseCaseStereoType>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ENTRY_POINTS:
				setEntryPoints((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DeclarativesType>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__CMHEADER:
				setCmheader((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OWNER_HANDLE:
				setOwnerHandle((ISubsystem)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DECLARATIVES:
				getDeclaratives().clear();
				getDeclaratives().addAll((Collection<? extends DependsOnType>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationsType>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__STATE_CHARTS:
				getStateCharts().clear();
				getStateCharts().addAll((Collection<? extends IActivityGraph>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ITS_STATE_CHART:
				setItsStateChart((NestedStateChartType)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ATTRS:
				getAttrs().clear();
				getAttrs().addAll((Collection<? extends IAttribute>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends IAnnotation>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES:
				setEmbededFiles((IEmbededFile)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_LINKS:
				getObjectLinks().clear();
				getObjectLinks().addAll((Collection<? extends IObjectLink>)newValue);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__PROPERTIES:
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
			case UMLRhapsodyPackage.IUSE_CASE__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)null);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__HYPER_LINKS:
				getHyperLinks().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__WEAK_CG_TIME:
				getWeakCGTime().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__STRONG_CG_TIME:
				getStrongCGTime().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__CLASS_MODIFIER:
				setClassModifier(CLASS_MODIFIER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__INHERITANCES:
				getInheritances().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__USE_CASE_STEREO_TYPES:
				getUseCaseStereoTypes().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ENTRY_POINTS:
				setEntryPoints(ENTRY_POINTS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DIAGRAMS:
				getDiagrams().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__CMHEADER:
				setCmheader(CMHEADER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OWNER_HANDLE:
				setOwnerHandle((ISubsystem)null);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__DECLARATIVES:
				getDeclaratives().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OPERATIONS:
				getOperations().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__STATE_CHARTS:
				getStateCharts().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ITS_STATE_CHART:
				setItsStateChart((NestedStateChartType)null);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ATTRS:
				getAttrs().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES:
				setEmbededFiles((IEmbededFile)null);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_LINKS:
				getObjectLinks().clear();
				return;
			case UMLRhapsodyPackage.IUSE_CASE__PROPERTIES:
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
			case UMLRhapsodyPackage.IUSE_CASE__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.IUSE_CASE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IUSE_CASE__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IUSE_CASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IUSE_CASE__THE_MAIN_DIAGRAM:
				return theMainDiagram != null;
			case UMLRhapsodyPackage.IUSE_CASE__HYPER_LINKS:
				return hyperLinks != null && !hyperLinks.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__WEAK_CG_TIME:
				return weakCGTime != null && !weakCGTime.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__STRONG_CG_TIME:
				return strongCGTime != null && !strongCGTime.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__CLASS_MODIFIER:
				return CLASS_MODIFIER_EDEFAULT == null ? classModifier != null : !CLASS_MODIFIER_EDEFAULT.equals(classModifier);
			case UMLRhapsodyPackage.IUSE_CASE__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IUSE_CASE__INHERITANCES:
				return inheritances != null && !inheritances.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__USE_CASE_STEREO_TYPES:
				return useCaseStereoTypes != null && !useCaseStereoTypes.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__ENTRY_POINTS:
				return ENTRY_POINTS_EDEFAULT == null ? entryPoints != null : !ENTRY_POINTS_EDEFAULT.equals(entryPoints);
			case UMLRhapsodyPackage.IUSE_CASE__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.IUSE_CASE__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IUSE_CASE__CMHEADER:
				return CMHEADER_EDEFAULT == null ? cmheader != null : !CMHEADER_EDEFAULT.equals(cmheader);
			case UMLRhapsodyPackage.IUSE_CASE__OWNER_HANDLE:
				return ownerHandle != null;
			case UMLRhapsodyPackage.IUSE_CASE__DECLARATIVES:
				return declaratives != null && !declaratives.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__STATE_CHARTS:
				return stateCharts != null && !stateCharts.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__ITS_STATE_CHART:
				return itsStateChart != null;
			case UMLRhapsodyPackage.IUSE_CASE__ATTRS:
				return attrs != null && !attrs.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__EMBEDED_FILES:
				return embededFiles != null;
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IUSE_CASE__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IUSE_CASE__OBJECT_LINKS:
				return objectLinks != null && !objectLinks.isEmpty();
			case UMLRhapsodyPackage.IUSE_CASE__PROPERTIES:
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
		if (baseClass == End1_Type.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == End2_Type.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IUSE_CASE__MULTIPLICITY: return UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY;
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
		if (baseClass == End1_Type.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == End2_Type.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY: return UMLRhapsodyPackage.IUSE_CASE__MULTIPLICITY;
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
		result.append(" (multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", weakCGTime: "); //$NON-NLS-1$
		result.append(weakCGTime);
		result.append(", strongCGTime: "); //$NON-NLS-1$
		result.append(strongCGTime);
		result.append(", classModifier: "); //$NON-NLS-1$
		result.append(classModifier);
		result.append(", EntryPoints: "); //$NON-NLS-1$
		result.append(entryPoints);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", cmheader: "); //$NON-NLS-1$
		result.append(cmheader);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //IUseCaseImpl
