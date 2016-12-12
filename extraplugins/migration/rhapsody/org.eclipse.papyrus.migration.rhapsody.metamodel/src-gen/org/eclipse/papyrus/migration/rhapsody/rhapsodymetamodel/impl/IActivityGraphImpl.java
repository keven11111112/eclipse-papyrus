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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityGraph;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEnd;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISwimlane;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IActivity Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getWeakCGTime <em>Weak CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getStrongCGTime <em>Strong CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getItsStateChart <em>Its State Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getClassModifier <em>Class Modifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getSwimlanes <em>Swimlanes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getAnalysisMode <em>Analysis Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IActivityGraphImpl#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IActivityGraphImpl extends NestedStateChartTypeImpl implements IActivityGraph {
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
	 * The cached value of the '{@link #getItsStateChart() <em>Its State Chart</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsStateChart()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> itsStateChart;

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
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<ItsTargetType> states;

	/**
	 * The default value of the '{@link #getBaseVersion() <em>Base Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected String baseVersion = BASE_VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected IActivityDiagram diagram;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected IActivityDiagram views;

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
	 * The cached value of the '{@link #getSwimlanes() <em>Swimlanes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwimlanes()
	 * @generated
	 * @ordered
	 */
	protected EList<ISwimlane> swimlanes;

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
	 * The default value of the '{@link #getAnalysisMode() <em>Analysis Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisMode()
	 * @generated
	 * @ordered
	 */
	protected static final String ANALYSIS_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnalysisMode() <em>Analysis Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisMode()
	 * @generated
	 * @ordered
	 */
	protected String analysisMode = ANALYSIS_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected IComment annotations;

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
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected IMHyperLink hyperLinks;

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
	 * The cached value of the '{@link #getTheMainDiagram() <em>The Main Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheMainDiagram()
	 * @generated
	 * @ordered
	 */
	protected IDiagram theMainDiagram;

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
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected ITag tags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IActivityGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIActivityGraph();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__LAST_ID, oldLastID, lastID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWeakCGTime() {
		if (weakCGTime == null) {
			weakCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__WEAK_CG_TIME);
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
			strongCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__STRONG_CG_TIME);
		}
		return strongCGTime;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getItsStateChart() {
		if (itsStateChart == null) {
			itsStateChart = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__ITS_STATE_CHART);
		}
		return itsStateChart;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__CLASS_MODIFIER, oldClassModifier, classModifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ItsTargetType> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList.Resolving<ItsTargetType>(ItsTargetType.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(String newBaseVersion) {
		String oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__BASE_VERSION, oldBaseVersion, baseVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityDiagram getDiagram() {
		if (diagram != null && diagram.eIsProxy()) {
			InternalEObject oldDiagram = (InternalEObject)diagram;
			diagram = (IActivityDiagram)eResolveProxy(oldDiagram);
			if (diagram != oldDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__DIAGRAM, oldDiagram, diagram));
			}
		}
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityDiagram basicGetDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagram(IActivityDiagram newDiagram) {
		IActivityDiagram oldDiagram = diagram;
		diagram = newDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__DIAGRAM, oldDiagram, diagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityDiagram getViews() {
		if (views != null && views.eIsProxy()) {
			InternalEObject oldViews = (InternalEObject)views;
			views = (IActivityDiagram)eResolveProxy(oldViews);
			if (views != oldViews) {
				InternalEObject newViews = (InternalEObject)views;
				NotificationChain msgs = oldViews.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS, null, null);
				if (newViews.eInternalContainer() == null) {
					msgs = newViews.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS, oldViews, views));
			}
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityDiagram basicGetViews() {
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViews(IActivityDiagram newViews, NotificationChain msgs) {
		IActivityDiagram oldViews = views;
		views = newViews;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS, oldViews, newViews);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViews(IActivityDiagram newViews) {
		if (newViews != views) {
			NotificationChain msgs = null;
			if (views != null)
				msgs = ((InternalEObject)views).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS, null, msgs);
			if (newViews != null)
				msgs = ((InternalEObject)newViews).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS, null, msgs);
			msgs = basicSetViews(newViews, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS, newViews, newViews));
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES, newProperties, newProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ISwimlane> getSwimlanes() {
		if (swimlanes == null) {
			swimlanes = new EObjectContainmentEList.Resolving<ISwimlane>(ISwimlane.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__SWIMLANES);
		}
		return swimlanes;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__STEREOTYPES, oldStereotypes, stereotypes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnalysisMode() {
		return analysisMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisMode(String newAnalysisMode) {
		String oldAnalysisMode = analysisMode;
		analysisMode = newAnalysisMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__ANALYSIS_MODE, oldAnalysisMode, analysisMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComment getAnnotations() {
		if (annotations != null && annotations.eIsProxy()) {
			InternalEObject oldAnnotations = (InternalEObject)annotations;
			annotations = (IComment)eResolveProxy(oldAnnotations);
			if (annotations != oldAnnotations) {
				InternalEObject newAnnotations = (InternalEObject)annotations;
				NotificationChain msgs = oldAnnotations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS, null, null);
				if (newAnnotations.eInternalContainer() == null) {
					msgs = newAnnotations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS, oldAnnotations, annotations));
			}
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComment basicGetAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotations(IComment newAnnotations, NotificationChain msgs) {
		IComment oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS, oldAnnotations, newAnnotations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotations(IComment newAnnotations) {
		if (newAnnotations != annotations) {
			NotificationChain msgs = null;
			if (annotations != null)
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS, newAnnotations, newAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__CODE_UPDATE_CG_TIME);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__DISPLAY_NAME, oldDisplayName, displayName));
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
				NotificationChain msgs = oldHyperLinks.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS, null, null);
				if (newHyperLinks.eInternalContainer() == null) {
					msgs = newHyperLinks.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS, oldHyperLinks, hyperLinks));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS, oldHyperLinks, newHyperLinks);
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
				msgs = ((InternalEObject)hyperLinks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS, null, msgs);
			if (newHyperLinks != null)
				msgs = ((InternalEObject)newHyperLinks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS, null, msgs);
			msgs = basicSetHyperLinks(newHyperLinks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS, newHyperLinks, newHyperLinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDiagram getTheMainDiagram() {
		if (theMainDiagram != null && theMainDiagram.eIsProxy()) {
			InternalEObject oldTheMainDiagram = (InternalEObject)theMainDiagram;
			theMainDiagram = (IDiagram)eResolveProxy(oldTheMainDiagram);
			if (theMainDiagram != oldTheMainDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
			}
		}
		return theMainDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDiagram basicGetTheMainDiagram() {
		return theMainDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheMainDiagram(IDiagram newTheMainDiagram) {
		IDiagram oldTheMainDiagram = theMainDiagram;
		theMainDiagram = newTheMainDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAssociationEnd> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList.Resolving<IAssociationEnd>(IAssociationEnd.class, this, UMLRhapsodyPackage.IACTIVITY_GRAPH__ASSOCIATIONS);
		}
		return associations;
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
				NotificationChain msgs = oldTags.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS, null, null);
				if (newTags.eInternalContainer() == null) {
					msgs = newTags.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS, oldTags, tags));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS, oldTags, newTags);
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
				msgs = ((InternalEObject)tags).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS, null, msgs);
			if (newTags != null)
				msgs = ((InternalEObject)newTags).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS, null, msgs);
			msgs = basicSetTags(newTags, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS, newTags, newTags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS:
				return basicSetViews(null, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__SWIMLANES:
				return ((InternalEList<?>)getSwimlanes()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS:
				return basicSetHyperLinks(null, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS:
				return basicSetTags(null, msgs);
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
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ID:
				return getId();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__NAME:
				return getName();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DISPLAY_NAME:
				return getDisplayName();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__WEAK_CG_TIME:
				return getWeakCGTime();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STRONG_CG_TIME:
				return getStrongCGTime();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ITS_STATE_CHART:
				return getItsStateChart();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CLASS_MODIFIER:
				return getClassModifier();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STATES:
				return getStates();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__BASE_VERSION:
				return getBaseVersion();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DIAGRAM:
				if (resolve) return getDiagram();
				return basicGetDiagram();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS:
				if (resolve) return getViews();
				return basicGetViews();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__SWIMLANES:
				return getSwimlanes();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANALYSIS_MODE:
				return getAnalysisMode();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS:
				if (resolve) return getHyperLinks();
				return basicGetHyperLinks();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__THE_MAIN_DIAGRAM:
				if (resolve) return getTheMainDiagram();
				return basicGetTheMainDiagram();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ASSOCIATIONS:
				return getAssociations();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS:
				if (resolve) return getTags();
				return basicGetTags();
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
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__WEAK_CG_TIME:
				getWeakCGTime().clear();
				getWeakCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STRONG_CG_TIME:
				getStrongCGTime().clear();
				getStrongCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ITS_STATE_CHART:
				getItsStateChart().clear();
				getItsStateChart().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CLASS_MODIFIER:
				setClassModifier((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends ItsTargetType>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__BASE_VERSION:
				setBaseVersion((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DIAGRAM:
				setDiagram((IActivityDiagram)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS:
				setViews((IActivityDiagram)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__SWIMLANES:
				getSwimlanes().clear();
				getSwimlanes().addAll((Collection<? extends ISwimlane>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STEREOTYPES:
				setStereotypes((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANALYSIS_MODE:
				setAnalysisMode((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS:
				setAnnotations((IComment)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS:
				setHyperLinks((IMHyperLink)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__THE_MAIN_DIAGRAM:
				setTheMainDiagram((IDiagram)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends IAssociationEnd>)newValue);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS:
				setTags((ITag)newValue);
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
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__WEAK_CG_TIME:
				getWeakCGTime().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STRONG_CG_TIME:
				getStrongCGTime().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ITS_STATE_CHART:
				getItsStateChart().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CLASS_MODIFIER:
				setClassModifier(CLASS_MODIFIER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STATES:
				getStates().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__BASE_VERSION:
				setBaseVersion(BASE_VERSION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DIAGRAM:
				setDiagram((IActivityDiagram)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS:
				setViews((IActivityDiagram)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__SWIMLANES:
				getSwimlanes().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STEREOTYPES:
				setStereotypes((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANALYSIS_MODE:
				setAnalysisMode(ANALYSIS_MODE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS:
				setAnnotations((IComment)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS:
				setHyperLinks((IMHyperLink)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__THE_MAIN_DIAGRAM:
				setTheMainDiagram((IDiagram)null);
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS:
				setTags((ITag)null);
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
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__WEAK_CG_TIME:
				return weakCGTime != null && !weakCGTime.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STRONG_CG_TIME:
				return strongCGTime != null && !strongCGTime.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ITS_STATE_CHART:
				return itsStateChart != null && !itsStateChart.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CLASS_MODIFIER:
				return CLASS_MODIFIER_EDEFAULT == null ? classModifier != null : !CLASS_MODIFIER_EDEFAULT.equals(classModifier);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STATES:
				return states != null && !states.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__BASE_VERSION:
				return BASE_VERSION_EDEFAULT == null ? baseVersion != null : !BASE_VERSION_EDEFAULT.equals(baseVersion);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DIAGRAM:
				return diagram != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__VIEWS:
				return views != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__SWIMLANES:
				return swimlanes != null && !swimlanes.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANALYSIS_MODE:
				return ANALYSIS_MODE_EDEFAULT == null ? analysisMode != null : !ANALYSIS_MODE_EDEFAULT.equals(analysisMode);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ANNOTATIONS:
				return annotations != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__HYPER_LINKS:
				return hyperLinks != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__THE_MAIN_DIAGRAM:
				return theMainDiagram != null;
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH__TAGS:
				return tags != null;
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
		if (baseClass == ValueType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IACTIVITY_GRAPH__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.IACTIVITY_GRAPH__ID: return UMLRhapsodyPackage.VALUE_TYPE__ID;
				case UMLRhapsodyPackage.IACTIVITY_GRAPH__MY_STATE: return UMLRhapsodyPackage.VALUE_TYPE__MY_STATE;
				case UMLRhapsodyPackage.IACTIVITY_GRAPH__NAME: return UMLRhapsodyPackage.VALUE_TYPE__NAME;
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
		if (baseClass == IModelElement.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IACTIVITY_GRAPH__DISPLAY_NAME: return UMLRhapsodyPackage.IMODEL_ELEMENT__DISPLAY_NAME;
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
		if (baseClass == ValueType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.IACTIVITY_GRAPH__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.VALUE_TYPE__ID: return UMLRhapsodyPackage.IACTIVITY_GRAPH__ID;
				case UMLRhapsodyPackage.VALUE_TYPE__MY_STATE: return UMLRhapsodyPackage.IACTIVITY_GRAPH__MY_STATE;
				case UMLRhapsodyPackage.VALUE_TYPE__NAME: return UMLRhapsodyPackage.IACTIVITY_GRAPH__NAME;
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
		if (baseClass == IModelElement.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.IMODEL_ELEMENT__DISPLAY_NAME: return UMLRhapsodyPackage.IACTIVITY_GRAPH__DISPLAY_NAME;
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
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", weakCGTime: "); //$NON-NLS-1$
		result.append(weakCGTime);
		result.append(", strongCGTime: "); //$NON-NLS-1$
		result.append(strongCGTime);
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", classModifier: "); //$NON-NLS-1$
		result.append(classModifier);
		result.append(", baseVersion: "); //$NON-NLS-1$
		result.append(baseVersion);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", AnalysisMode: "); //$NON-NLS-1$
		result.append(analysisMode);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //IActivityGraphImpl
