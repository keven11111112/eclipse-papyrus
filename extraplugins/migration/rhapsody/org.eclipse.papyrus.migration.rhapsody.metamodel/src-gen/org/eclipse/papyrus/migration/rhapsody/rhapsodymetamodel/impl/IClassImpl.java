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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ComponentsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ConveyedType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DescriptionType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInterfaceItem;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IRelation;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISubsystem;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateParameter;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsStateChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.LinksType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pBaseType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.NestedStateChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ObjectLinksType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OperationsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.PropertiesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TheMainDiagramType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getWeakCGTime <em>Weak CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getStrongCGTime <em>Strong CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getClassModifier <em>Class Modifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getInheritances <em>Inheritances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getObjectLinks <em>Object Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getStateCharts <em>State Charts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getItsStateChart <em>Its State Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getTriggeredOperations <em>Triggered Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getReceptions <em>Receptions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getPrimitiveOperations <em>Primitive Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getDeclaratives <em>Declaratives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getAssociationElements <em>Association Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getOwnerHandle <em>Owner Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getComponentFiles <em>Component Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getEventHandles <em>Event Handles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getCmheader <em>Cmheader</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IClassImpl#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IClassImpl extends IClassifierImpl implements IClass {
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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected PropertiesType properties;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IUnit> stereotypes;

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
	 * The cached value of the '{@link #getInheritances() <em>Inheritances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritances()
	 * @generated
	 * @ordered
	 */
	protected EList<IModelElement> inheritances;

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
	 * The cached value of the '{@link #getAttrs() <em>Attrs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrs()
	 * @generated
	 * @ordered
	 */
	protected EList<IUnit> attrs;

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
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationsType> associations;

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
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<IRelation> ports;

	/**
	 * The cached value of the '{@link #getObjectLinks() <em>Object Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectLinksType> objectLinks;

	/**
	 * The cached value of the '{@link #getStateCharts() <em>State Charts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateCharts()
	 * @generated
	 * @ordered
	 */
	protected EList<NestedStateChartType> stateCharts;

	/**
	 * The cached value of the '{@link #getItsStateChart() <em>Its State Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsStateChart()
	 * @generated
	 * @ordered
	 */
	protected ItsStateChartType itsStateChart;

	/**
	 * The cached value of the '{@link #getTriggeredOperations() <em>Triggered Operations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggeredOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> triggeredOperations;

	/**
	 * The cached value of the '{@link #getReceptions() <em>Receptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> receptions;

	/**
	 * The cached value of the '{@link #getPrimitiveOperations() <em>Primitive Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationsType> primitiveOperations;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected DescriptionType description;

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
	 * The cached value of the '{@link #getAssociationElements() <em>Association Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> associationElements;

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
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<IMHyperLink> hyperLinks;

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
	 * The cached value of the '{@link #getComponentFiles() <em>Component Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<IFile> componentFiles;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<LinksType> links;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentsType> components;

	/**
	 * The cached value of the '{@link #getEventHandles() <em>Event Handles</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventHandles()
	 * @generated
	 * @ordered
	 */
	protected IInterfaceItem eventHandles;

	/**
	 * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ITemplateParameter> templateParameters;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIClass();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__OBJECT_CREATION, oldObjectCreation, objectCreation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICLASS__MODIFIED_TIME_WEAK);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__LAST_ID, oldLastID, lastID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWeakCGTime() {
		if (weakCGTime == null) {
			weakCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICLASS__WEAK_CG_TIME);
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
			strongCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICLASS__STRONG_CG_TIME);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__MULTIPLICITY, oldMultiplicity, multiplicity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__CLASS_MODIFIER, oldClassModifier, classModifier));
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICLASS__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectResolvingEList<IUnit>(IUnit.class, this, UMLRhapsodyPackage.ICLASS__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationsType> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList.Resolving<OperationsType>(OperationsType.class, this, UMLRhapsodyPackage.ICLASS__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IModelElement> getInheritances() {
		if (inheritances == null) {
			inheritances = new EObjectContainmentEList.Resolving<IModelElement>(IModelElement.class, this, UMLRhapsodyPackage.ICLASS__INHERITANCES);
		}
		return inheritances;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICLASS__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getAttrs() {
		if (attrs == null) {
			attrs = new EObjectContainmentEList.Resolving<IUnit>(IUnit.class, this, UMLRhapsodyPackage.ICLASS__ATTRS);
		}
		return attrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.ICLASS__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssociationsType> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList.Resolving<AssociationsType>(AssociationsType.class, this, UMLRhapsodyPackage.ICLASS__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.ICLASS__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IRelation> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentEList.Resolving<IRelation>(IRelation.class, this, UMLRhapsodyPackage.ICLASS__PORTS);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectLinksType> getObjectLinks() {
		if (objectLinks == null) {
			objectLinks = new EObjectContainmentEList.Resolving<ObjectLinksType>(ObjectLinksType.class, this, UMLRhapsodyPackage.ICLASS__OBJECT_LINKS);
		}
		return objectLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NestedStateChartType> getStateCharts() {
		if (stateCharts == null) {
			stateCharts = new EObjectContainmentEList.Resolving<NestedStateChartType>(NestedStateChartType.class, this, UMLRhapsodyPackage.ICLASS__STATE_CHARTS);
		}
		return stateCharts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsStateChartType getItsStateChart() {
		if (itsStateChart != null && itsStateChart.eIsProxy()) {
			InternalEObject oldItsStateChart = (InternalEObject)itsStateChart;
			itsStateChart = (ItsStateChartType)eResolveProxy(oldItsStateChart);
			if (itsStateChart != oldItsStateChart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICLASS__ITS_STATE_CHART, oldItsStateChart, itsStateChart));
			}
		}
		return itsStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItsStateChartType basicGetItsStateChart() {
		return itsStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsStateChart(ItsStateChartType newItsStateChart) {
		ItsStateChartType oldItsStateChart = itsStateChart;
		itsStateChart = newItsStateChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__ITS_STATE_CHART, oldItsStateChart, itsStateChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getTriggeredOperations() {
		if (triggeredOperations == null) {
			triggeredOperations = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.ICLASS__TRIGGERED_OPERATIONS);
		}
		return triggeredOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getReceptions() {
		if (receptions == null) {
			receptions = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.ICLASS__RECEPTIONS);
		}
		return receptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationsType> getPrimitiveOperations() {
		if (primitiveOperations == null) {
			primitiveOperations = new EObjectContainmentEList.Resolving<OperationsType>(OperationsType.class, this, UMLRhapsodyPackage.ICLASS__PRIMITIVE_OPERATIONS);
		}
		return primitiveOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList.Resolving<IUnit>(IUnit.class, this, UMLRhapsodyPackage.ICLASS__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType getDescription() {
		if (description != null && description.eIsProxy()) {
			InternalEObject oldDescription = (InternalEObject)description;
			description = (DescriptionType)eResolveProxy(oldDescription);
			if (description != oldDescription) {
				InternalEObject newDescription = (InternalEObject)description;
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICLASS__DESCRIPTION, oldDescription, description));
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType basicGetDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(DescriptionType newDescription, NotificationChain msgs) {
		DescriptionType oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(DescriptionType newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICLASS__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclarativesType> getDeclaratives() {
		if (declaratives == null) {
			declaratives = new EObjectContainmentEList.Resolving<DeclarativesType>(DeclarativesType.class, this, UMLRhapsodyPackage.ICLASS__DECLARATIVES);
		}
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getAssociationElements() {
		if (associationElements == null) {
			associationElements = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.ICLASS__ASSOCIATION_ELEMENTS);
		}
		return associationElements;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICLASS__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMHyperLink> getHyperLinks() {
		if (hyperLinks == null) {
			hyperLinks = new EObjectContainmentEList.Resolving<IMHyperLink>(IMHyperLink.class, this, UMLRhapsodyPackage.ICLASS__HYPER_LINKS);
		}
		return hyperLinks;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFile> getComponentFiles() {
		if (componentFiles == null) {
			componentFiles = new EObjectContainmentEList.Resolving<IFile>(IFile.class, this, UMLRhapsodyPackage.ICLASS__COMPONENT_FILES);
		}
		return componentFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LinksType> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList.Resolving<LinksType>(LinksType.class, this, UMLRhapsodyPackage.ICLASS__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentsType> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList.Resolving<ComponentsType>(ComponentsType.class, this, UMLRhapsodyPackage.ICLASS__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInterfaceItem getEventHandles() {
		if (eventHandles != null && eventHandles.eIsProxy()) {
			InternalEObject oldEventHandles = (InternalEObject)eventHandles;
			eventHandles = (IInterfaceItem)eResolveProxy(oldEventHandles);
			if (eventHandles != oldEventHandles) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICLASS__EVENT_HANDLES, oldEventHandles, eventHandles));
			}
		}
		return eventHandles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInterfaceItem basicGetEventHandles() {
		return eventHandles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventHandles(IInterfaceItem newEventHandles) {
		IInterfaceItem oldEventHandles = eventHandles;
		eventHandles = newEventHandles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__EVENT_HANDLES, oldEventHandles, eventHandles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITemplateParameter> getTemplateParameters() {
		if (templateParameters == null) {
			templateParameters = new EObjectContainmentEList.Resolving<ITemplateParameter>(ITemplateParameter.class, this, UMLRhapsodyPackage.ICLASS__TEMPLATE_PARAMETERS);
		}
		return templateParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICLASS__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__CMHEADER, oldCmheader, cmheader));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICLASS__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICLASS__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.ICLASS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__INHERITANCES:
				return ((InternalEList<?>)getInheritances()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__ATTRS:
				return ((InternalEList<?>)getAttrs()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__OBJECT_LINKS:
				return ((InternalEList<?>)getObjectLinks()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__STATE_CHARTS:
				return ((InternalEList<?>)getStateCharts()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__PRIMITIVE_OPERATIONS:
				return ((InternalEList<?>)getPrimitiveOperations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.ICLASS__DECLARATIVES:
				return ((InternalEList<?>)getDeclaratives()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__HYPER_LINKS:
				return ((InternalEList<?>)getHyperLinks()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__COMPONENT_FILES:
				return ((InternalEList<?>)getComponentFiles()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICLASS__TEMPLATE_PARAMETERS:
				return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.ICLASS__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.ICLASS__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.ICLASS__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ICLASS__ID:
				return getId();
			case UMLRhapsodyPackage.ICLASS__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.ICLASS__NAME:
				return getName();
			case UMLRhapsodyPackage.ICLASS__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.ICLASS__WEAK_CG_TIME:
				return getWeakCGTime();
			case UMLRhapsodyPackage.ICLASS__STRONG_CG_TIME:
				return getStrongCGTime();
			case UMLRhapsodyPackage.ICLASS__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.ICLASS__CLASS_MODIFIER:
				return getClassModifier();
			case UMLRhapsodyPackage.ICLASS__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.ICLASS__STEREOTYPES:
				return getStereotypes();
			case UMLRhapsodyPackage.ICLASS__OPERATIONS:
				return getOperations();
			case UMLRhapsodyPackage.ICLASS__INHERITANCES:
				return getInheritances();
			case UMLRhapsodyPackage.ICLASS__THE_MAIN_DIAGRAM:
				if (resolve) return getTheMainDiagram();
				return basicGetTheMainDiagram();
			case UMLRhapsodyPackage.ICLASS__ATTRS:
				return getAttrs();
			case UMLRhapsodyPackage.ICLASS__TAGS:
				return getTags();
			case UMLRhapsodyPackage.ICLASS__ASSOCIATIONS:
				return getAssociations();
			case UMLRhapsodyPackage.ICLASS__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.ICLASS__PORTS:
				return getPorts();
			case UMLRhapsodyPackage.ICLASS__OBJECT_LINKS:
				return getObjectLinks();
			case UMLRhapsodyPackage.ICLASS__STATE_CHARTS:
				return getStateCharts();
			case UMLRhapsodyPackage.ICLASS__ITS_STATE_CHART:
				if (resolve) return getItsStateChart();
				return basicGetItsStateChart();
			case UMLRhapsodyPackage.ICLASS__TRIGGERED_OPERATIONS:
				return getTriggeredOperations();
			case UMLRhapsodyPackage.ICLASS__RECEPTIONS:
				return getReceptions();
			case UMLRhapsodyPackage.ICLASS__PRIMITIVE_OPERATIONS:
				return getPrimitiveOperations();
			case UMLRhapsodyPackage.ICLASS__ANNOTATIONS:
				return getAnnotations();
			case UMLRhapsodyPackage.ICLASS__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.ICLASS__DECLARATIVES:
				return getDeclaratives();
			case UMLRhapsodyPackage.ICLASS__ASSOCIATION_ELEMENTS:
				return getAssociationElements();
			case UMLRhapsodyPackage.ICLASS__OWNER_HANDLE:
				if (resolve) return getOwnerHandle();
				return basicGetOwnerHandle();
			case UMLRhapsodyPackage.ICLASS__HYPER_LINKS:
				return getHyperLinks();
			case UMLRhapsodyPackage.ICLASS__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.ICLASS__COMPONENT_FILES:
				return getComponentFiles();
			case UMLRhapsodyPackage.ICLASS__LINKS:
				return getLinks();
			case UMLRhapsodyPackage.ICLASS__COMPONENTS:
				return getComponents();
			case UMLRhapsodyPackage.ICLASS__EVENT_HANDLES:
				if (resolve) return getEventHandles();
				return basicGetEventHandles();
			case UMLRhapsodyPackage.ICLASS__TEMPLATE_PARAMETERS:
				return getTemplateParameters();
			case UMLRhapsodyPackage.ICLASS__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.ICLASS__CMHEADER:
				return getCmheader();
			case UMLRhapsodyPackage.ICLASS__DISPLAY_NAME:
				return getDisplayName();
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
			case UMLRhapsodyPackage.ICLASS__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__WEAK_CG_TIME:
				getWeakCGTime().clear();
				getWeakCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__STRONG_CG_TIME:
				getStrongCGTime().clear();
				getStrongCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__CLASS_MODIFIER:
				setClassModifier((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__PROPERTIES:
				setProperties((PropertiesType)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__STEREOTYPES:
				getStereotypes().clear();
				getStereotypes().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationsType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__INHERITANCES:
				getInheritances().clear();
				getInheritances().addAll((Collection<? extends IModelElement>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__ATTRS:
				getAttrs().clear();
				getAttrs().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends AssociationsType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends IRelation>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__OBJECT_LINKS:
				getObjectLinks().clear();
				getObjectLinks().addAll((Collection<? extends ObjectLinksType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__STATE_CHARTS:
				getStateCharts().clear();
				getStateCharts().addAll((Collection<? extends NestedStateChartType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__ITS_STATE_CHART:
				setItsStateChart((ItsStateChartType)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__TRIGGERED_OPERATIONS:
				getTriggeredOperations().clear();
				getTriggeredOperations().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__RECEPTIONS:
				getReceptions().clear();
				getReceptions().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__PRIMITIVE_OPERATIONS:
				getPrimitiveOperations().clear();
				getPrimitiveOperations().addAll((Collection<? extends OperationsType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__DESCRIPTION:
				setDescription((DescriptionType)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__DECLARATIVES:
				getDeclaratives().clear();
				getDeclaratives().addAll((Collection<? extends DeclarativesType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__ASSOCIATION_ELEMENTS:
				getAssociationElements().clear();
				getAssociationElements().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__OWNER_HANDLE:
				setOwnerHandle((ISubsystem)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__HYPER_LINKS:
				getHyperLinks().clear();
				getHyperLinks().addAll((Collection<? extends IMHyperLink>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__COMPONENT_FILES:
				getComponentFiles().clear();
				getComponentFiles().addAll((Collection<? extends IFile>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends LinksType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends ComponentsType>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__EVENT_HANDLES:
				setEventHandles((IInterfaceItem)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				getTemplateParameters().addAll((Collection<? extends ITemplateParameter>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__CMHEADER:
				setCmheader((String)newValue);
				return;
			case UMLRhapsodyPackage.ICLASS__DISPLAY_NAME:
				setDisplayName((String)newValue);
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
			case UMLRhapsodyPackage.ICLASS__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__WEAK_CG_TIME:
				getWeakCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__STRONG_CG_TIME:
				getStrongCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__CLASS_MODIFIER:
				setClassModifier(CLASS_MODIFIER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__PROPERTIES:
				setProperties((PropertiesType)null);
				return;
			case UMLRhapsodyPackage.ICLASS__STEREOTYPES:
				getStereotypes().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__OPERATIONS:
				getOperations().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__INHERITANCES:
				getInheritances().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__THE_MAIN_DIAGRAM:
				setTheMainDiagram((TheMainDiagramType)null);
				return;
			case UMLRhapsodyPackage.ICLASS__ATTRS:
				getAttrs().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__PORTS:
				getPorts().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__OBJECT_LINKS:
				getObjectLinks().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__STATE_CHARTS:
				getStateCharts().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__ITS_STATE_CHART:
				setItsStateChart((ItsStateChartType)null);
				return;
			case UMLRhapsodyPackage.ICLASS__TRIGGERED_OPERATIONS:
				getTriggeredOperations().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__RECEPTIONS:
				getReceptions().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__PRIMITIVE_OPERATIONS:
				getPrimitiveOperations().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__DESCRIPTION:
				setDescription((DescriptionType)null);
				return;
			case UMLRhapsodyPackage.ICLASS__DECLARATIVES:
				getDeclaratives().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__ASSOCIATION_ELEMENTS:
				getAssociationElements().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__OWNER_HANDLE:
				setOwnerHandle((ISubsystem)null);
				return;
			case UMLRhapsodyPackage.ICLASS__HYPER_LINKS:
				getHyperLinks().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__COMPONENT_FILES:
				getComponentFiles().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__LINKS:
				getLinks().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__COMPONENTS:
				getComponents().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__EVENT_HANDLES:
				setEventHandles((IInterfaceItem)null);
				return;
			case UMLRhapsodyPackage.ICLASS__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICLASS__CMHEADER:
				setCmheader(CMHEADER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICLASS__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
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
			case UMLRhapsodyPackage.ICLASS__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.ICLASS__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.ICLASS__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.ICLASS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ICLASS__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.ICLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ICLASS__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.ICLASS__WEAK_CG_TIME:
				return weakCGTime != null && !weakCGTime.isEmpty();
			case UMLRhapsodyPackage.ICLASS__STRONG_CG_TIME:
				return strongCGTime != null && !strongCGTime.isEmpty();
			case UMLRhapsodyPackage.ICLASS__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.ICLASS__CLASS_MODIFIER:
				return CLASS_MODIFIER_EDEFAULT == null ? classModifier != null : !CLASS_MODIFIER_EDEFAULT.equals(classModifier);
			case UMLRhapsodyPackage.ICLASS__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.ICLASS__STEREOTYPES:
				return stereotypes != null && !stereotypes.isEmpty();
			case UMLRhapsodyPackage.ICLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case UMLRhapsodyPackage.ICLASS__INHERITANCES:
				return inheritances != null && !inheritances.isEmpty();
			case UMLRhapsodyPackage.ICLASS__THE_MAIN_DIAGRAM:
				return theMainDiagram != null;
			case UMLRhapsodyPackage.ICLASS__ATTRS:
				return attrs != null && !attrs.isEmpty();
			case UMLRhapsodyPackage.ICLASS__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.ICLASS__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case UMLRhapsodyPackage.ICLASS__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.ICLASS__PORTS:
				return ports != null && !ports.isEmpty();
			case UMLRhapsodyPackage.ICLASS__OBJECT_LINKS:
				return objectLinks != null && !objectLinks.isEmpty();
			case UMLRhapsodyPackage.ICLASS__STATE_CHARTS:
				return stateCharts != null && !stateCharts.isEmpty();
			case UMLRhapsodyPackage.ICLASS__ITS_STATE_CHART:
				return itsStateChart != null;
			case UMLRhapsodyPackage.ICLASS__TRIGGERED_OPERATIONS:
				return triggeredOperations != null && !triggeredOperations.isEmpty();
			case UMLRhapsodyPackage.ICLASS__RECEPTIONS:
				return receptions != null && !receptions.isEmpty();
			case UMLRhapsodyPackage.ICLASS__PRIMITIVE_OPERATIONS:
				return primitiveOperations != null && !primitiveOperations.isEmpty();
			case UMLRhapsodyPackage.ICLASS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UMLRhapsodyPackage.ICLASS__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.ICLASS__DECLARATIVES:
				return declaratives != null && !declaratives.isEmpty();
			case UMLRhapsodyPackage.ICLASS__ASSOCIATION_ELEMENTS:
				return associationElements != null && !associationElements.isEmpty();
			case UMLRhapsodyPackage.ICLASS__OWNER_HANDLE:
				return ownerHandle != null;
			case UMLRhapsodyPackage.ICLASS__HYPER_LINKS:
				return hyperLinks != null && !hyperLinks.isEmpty();
			case UMLRhapsodyPackage.ICLASS__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.ICLASS__COMPONENT_FILES:
				return componentFiles != null && !componentFiles.isEmpty();
			case UMLRhapsodyPackage.ICLASS__LINKS:
				return links != null && !links.isEmpty();
			case UMLRhapsodyPackage.ICLASS__COMPONENTS:
				return components != null && !components.isEmpty();
			case UMLRhapsodyPackage.ICLASS__EVENT_HANDLES:
				return eventHandles != null;
			case UMLRhapsodyPackage.ICLASS__TEMPLATE_PARAMETERS:
				return templateParameters != null && !templateParameters.isEmpty();
			case UMLRhapsodyPackage.ICLASS__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.ICLASS__CMHEADER:
				return CMHEADER_EDEFAULT == null ? cmheader != null : !CMHEADER_EDEFAULT.equals(cmheader);
			case UMLRhapsodyPackage.ICLASS__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
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
		if (baseClass == DeclarativesType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
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
				case UMLRhapsodyPackage.ICLASS__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.ICLASS__OBJECT_CREATION: return UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == ValueType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.ICLASS__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.ICLASS__ID: return UMLRhapsodyPackage.VALUE_TYPE__ID;
				case UMLRhapsodyPackage.ICLASS__MY_STATE: return UMLRhapsodyPackage.VALUE_TYPE__MY_STATE;
				case UMLRhapsodyPackage.ICLASS__NAME: return UMLRhapsodyPackage.VALUE_TYPE__NAME;
				default: return -1;
			}
		}
		if (baseClass == ConveyedType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.ICLASS__LAST_ID: return UMLRhapsodyPackage.CONVEYED_TYPE__LAST_ID;
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
		if (baseClass == DeclarativesType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
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
				case UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.ICLASS__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.ICLASS__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == ValueType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.ICLASS__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.VALUE_TYPE__ID: return UMLRhapsodyPackage.ICLASS__ID;
				case UMLRhapsodyPackage.VALUE_TYPE__MY_STATE: return UMLRhapsodyPackage.ICLASS__MY_STATE;
				case UMLRhapsodyPackage.VALUE_TYPE__NAME: return UMLRhapsodyPackage.ICLASS__NAME;
				default: return -1;
			}
		}
		if (baseClass == ConveyedType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.CONVEYED_TYPE__LAST_ID: return UMLRhapsodyPackage.ICLASS__LAST_ID;
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
		result.append(" (umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
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
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", classModifier: "); //$NON-NLS-1$
		result.append(classModifier);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(", cmheader: "); //$NON-NLS-1$
		result.append(cmheader);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(')');
		return result.toString();
	}

} //IClassImpl
