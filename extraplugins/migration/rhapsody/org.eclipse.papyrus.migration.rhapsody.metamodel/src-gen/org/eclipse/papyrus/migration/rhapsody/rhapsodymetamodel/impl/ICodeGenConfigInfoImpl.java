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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICodeGenConfigInfo;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEmbededFile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFolder;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ICode Gen Config Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getScopeType <em>Scope Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getAdditionalSources <em>Additional Sources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getStandardHeaders <em>Standard Headers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getIncludePath <em>Include Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getTargetMain <em>Target Main</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getInstrumentation <em>Instrumentation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getTimeModel <em>Time Model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getM_generateActors <em>Mgenerate Actors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getStatechartImplementation <em>Statechart Implementation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getInitializationCode <em>Initialization Code</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getChecksList <em>Checks List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getScopeElements <em>Scope Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getWeakCGTime <em>Weak CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getStrongCGTime <em>Strong CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getM_allInAnimScope <em>Mall In Anim Scope</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getM_generateUsecases <em>Mgenerate Usecases</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getInitialInstances <em>Initial Instances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getCmheader <em>Cmheader</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getAnimScopeElements <em>Anim Scope Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getEmbededFiles <em>Embeded Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICodeGenConfigInfoImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ICodeGenConfigInfoImpl extends DependsOnTypeImpl implements ICodeGenConfigInfo {
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
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<IMHyperLink> hyperLinks;

	/**
	 * The default value of the '{@link #getScopeType() <em>Scope Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeType()
	 * @generated
	 * @ordered
	 */
	protected static final String SCOPE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScopeType() <em>Scope Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeType()
	 * @generated
	 * @ordered
	 */
	protected String scopeType = SCOPE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibraries() <em>Libraries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraries()
	 * @generated
	 * @ordered
	 */
	protected static final String LIBRARIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibraries() <em>Libraries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraries()
	 * @generated
	 * @ordered
	 */
	protected String libraries = LIBRARIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdditionalSources() <em>Additional Sources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalSources()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDITIONAL_SOURCES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdditionalSources() <em>Additional Sources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalSources()
	 * @generated
	 * @ordered
	 */
	protected String additionalSources = ADDITIONAL_SOURCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getStandardHeaders() <em>Standard Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardHeaders()
	 * @generated
	 * @ordered
	 */
	protected static final String STANDARD_HEADERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStandardHeaders() <em>Standard Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardHeaders()
	 * @generated
	 * @ordered
	 */
	protected String standardHeaders = STANDARD_HEADERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIncludePath() <em>Include Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludePath()
	 * @generated
	 * @ordered
	 */
	protected static final String INCLUDE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIncludePath() <em>Include Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludePath()
	 * @generated
	 * @ordered
	 */
	protected String includePath = INCLUDE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetMain() <em>Target Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMain()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_MAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetMain() <em>Target Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMain()
	 * @generated
	 * @ordered
	 */
	protected String targetMain = TARGET_MAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstrumentation() <em>Instrumentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstrumentation()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTRUMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstrumentation() <em>Instrumentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstrumentation()
	 * @generated
	 * @ordered
	 */
	protected String instrumentation = INSTRUMENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeModel() <em>Time Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeModel()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeModel() <em>Time Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeModel()
	 * @generated
	 * @ordered
	 */
	protected String timeModel = TIME_MODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_generateActors() <em>Mgenerate Actors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_generateActors()
	 * @generated
	 * @ordered
	 */
	protected static final String MGENERATE_ACTORS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_generateActors() <em>Mgenerate Actors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_generateActors()
	 * @generated
	 * @ordered
	 */
	protected String m_generateActors = MGENERATE_ACTORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatechartImplementation() <em>Statechart Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatechartImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final String STATECHART_IMPLEMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatechartImplementation() <em>Statechart Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatechartImplementation()
	 * @generated
	 * @ordered
	 */
	protected String statechartImplementation = STATECHART_IMPLEMENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitializationCode() <em>Initialization Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationCode()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIALIZATION_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitializationCode() <em>Initialization Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationCode()
	 * @generated
	 * @ordered
	 */
	protected String initializationCode = INITIALIZATION_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChecksList() <em>Checks List</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChecksList()
	 * @generated
	 * @ordered
	 */
	protected EList<String> checksList;

	/**
	 * The cached value of the '{@link #getScopeElements() <em>Scope Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> scopeElements;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected IFolder root;

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
	 * The default value of the '{@link #getM_allInAnimScope() <em>Mall In Anim Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_allInAnimScope()
	 * @generated
	 * @ordered
	 */
	protected static final String MALL_IN_ANIM_SCOPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_allInAnimScope() <em>Mall In Anim Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_allInAnimScope()
	 * @generated
	 * @ordered
	 */
	protected String m_allInAnimScope = MALL_IN_ANIM_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_generateUsecases() <em>Mgenerate Usecases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_generateUsecases()
	 * @generated
	 * @ordered
	 */
	protected static final String MGENERATE_USECASES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_generateUsecases() <em>Mgenerate Usecases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_generateUsecases()
	 * @generated
	 * @ordered
	 */
	protected String m_generateUsecases = MGENERATE_USECASES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected IDependency dependencies;

	/**
	 * The cached value of the '{@link #getInitialInstances() <em>Initial Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<IUnit> initialInstances;

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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected IComment annotations;

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
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IClassifier> stereotypes;

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
	 * The cached value of the '{@link #getAnimScopeElements() <em>Anim Scope Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimScopeElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementsType> animScopeElements;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ICodeGenConfigInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getICodeGenConfigInfo();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMHyperLink> getHyperLinks() {
		if (hyperLinks == null) {
			hyperLinks = new EObjectContainmentEList.Resolving<IMHyperLink>(IMHyperLink.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__HYPER_LINKS);
		}
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScopeType() {
		return scopeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopeType(String newScopeType) {
		String oldScopeType = scopeType;
		scopeType = newScopeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_TYPE, oldScopeType, scopeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLibraries() {
		return libraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibraries(String newLibraries) {
		String oldLibraries = libraries;
		libraries = newLibraries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LIBRARIES, oldLibraries, libraries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdditionalSources() {
		return additionalSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalSources(String newAdditionalSources) {
		String oldAdditionalSources = additionalSources;
		additionalSources = newAdditionalSources;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ADDITIONAL_SOURCES, oldAdditionalSources, additionalSources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStandardHeaders() {
		return standardHeaders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardHeaders(String newStandardHeaders) {
		String oldStandardHeaders = standardHeaders;
		standardHeaders = newStandardHeaders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STANDARD_HEADERS, oldStandardHeaders, standardHeaders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIncludePath() {
		return includePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludePath(String newIncludePath) {
		String oldIncludePath = includePath;
		includePath = newIncludePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INCLUDE_PATH, oldIncludePath, includePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetMain() {
		return targetMain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMain(String newTargetMain) {
		String oldTargetMain = targetMain;
		targetMain = newTargetMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TARGET_MAIN, oldTargetMain, targetMain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstrumentation() {
		return instrumentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstrumentation(String newInstrumentation) {
		String oldInstrumentation = instrumentation;
		instrumentation = newInstrumentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INSTRUMENTATION, oldInstrumentation, instrumentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeModel() {
		return timeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeModel(String newTimeModel) {
		String oldTimeModel = timeModel;
		timeModel = newTimeModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TIME_MODEL, oldTimeModel, timeModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_generateActors() {
		return m_generateActors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_generateActors(String newM_generateActors) {
		String oldM_generateActors = m_generateActors;
		m_generateActors = newM_generateActors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_ACTORS, oldM_generateActors, m_generateActors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatechartImplementation() {
		return statechartImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatechartImplementation(String newStatechartImplementation) {
		String oldStatechartImplementation = statechartImplementation;
		statechartImplementation = newStatechartImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STATECHART_IMPLEMENTATION, oldStatechartImplementation, statechartImplementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitializationCode() {
		return initializationCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializationCode(String newInitializationCode) {
		String oldInitializationCode = initializationCode;
		initializationCode = newInitializationCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIALIZATION_CODE, oldInitializationCode, initializationCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getChecksList() {
		if (checksList == null) {
			checksList = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CHECKS_LIST);
		}
		return checksList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getScopeElements() {
		if (scopeElements == null) {
			scopeElements = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_ELEMENTS);
		}
		return scopeElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFolder getRoot() {
		if (root != null && root.eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (IFolder)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				InternalEObject newRoot = (InternalEObject)root;
				NotificationChain msgs = oldRoot.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT, null, null);
				if (newRoot.eInternalContainer() == null) {
					msgs = newRoot.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFolder basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(IFolder newRoot, NotificationChain msgs) {
		IFolder oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(IFolder newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT, null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT, null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT, newRoot, newRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWeakCGTime() {
		if (weakCGTime == null) {
			weakCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__WEAK_CG_TIME);
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
			strongCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STRONG_CG_TIME);
		}
		return strongCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_allInAnimScope() {
		return m_allInAnimScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_allInAnimScope(String newM_allInAnimScope) {
		String oldM_allInAnimScope = m_allInAnimScope;
		m_allInAnimScope = newM_allInAnimScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MALL_IN_ANIM_SCOPE, oldM_allInAnimScope, m_allInAnimScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_generateUsecases() {
		return m_generateUsecases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_generateUsecases(String newM_generateUsecases) {
		String oldM_generateUsecases = m_generateUsecases;
		m_generateUsecases = newM_generateUsecases;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_USECASES, oldM_generateUsecases, m_generateUsecases));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDependency getDependencies() {
		if (dependencies != null && dependencies.eIsProxy()) {
			InternalEObject oldDependencies = (InternalEObject)dependencies;
			dependencies = (IDependency)eResolveProxy(oldDependencies);
			if (dependencies != oldDependencies) {
				InternalEObject newDependencies = (InternalEObject)dependencies;
				NotificationChain msgs = oldDependencies.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES, null, null);
				if (newDependencies.eInternalContainer() == null) {
					msgs = newDependencies.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES, oldDependencies, dependencies));
			}
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDependency basicGetDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependencies(IDependency newDependencies, NotificationChain msgs) {
		IDependency oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES, oldDependencies, newDependencies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(IDependency newDependencies) {
		if (newDependencies != dependencies) {
			NotificationChain msgs = null;
			if (dependencies != null)
				msgs = ((InternalEObject)dependencies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES, null, msgs);
			if (newDependencies != null)
				msgs = ((InternalEObject)newDependencies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES, null, msgs);
			msgs = basicSetDependencies(newDependencies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES, newDependencies, newDependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getInitialInstances() {
		if (initialInstances == null) {
			initialInstances = new EObjectResolvingEList<IUnit>(IUnit.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIAL_INSTANCES);
		}
		return initialInstances;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES, newProperties, newProperties));
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
				NotificationChain msgs = oldAnnotations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS, null, null);
				if (newAnnotations.eInternalContainer() == null) {
					msgs = newAnnotations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS, oldAnnotations, annotations));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS, oldAnnotations, newAnnotations);
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
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS, newAnnotations, newAnnotations));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LAST_ID, oldLastID, lastID));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TAGS);
		}
		return tags;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CMHEADER, oldCmheader, cmheader));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClassifier> getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectResolvingEList<IClassifier>(IClassifier.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementsType> getAnimScopeElements() {
		if (animScopeElements == null) {
			animScopeElements = new EObjectResolvingEList<ElementsType>(ElementsType.class, this, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANIM_SCOPE_ELEMENTS);
		}
		return animScopeElements;
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
				NotificationChain msgs = oldEmbededFiles.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES, null, null);
				if (newEmbededFiles.eInternalContainer() == null) {
					msgs = newEmbededFiles.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES, oldEmbededFiles, embededFiles));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES, oldEmbededFiles, newEmbededFiles);
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
				msgs = ((InternalEObject)embededFiles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES, null, msgs);
			if (newEmbededFiles != null)
				msgs = ((InternalEObject)newEmbededFiles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES, null, msgs);
			msgs = basicSetEmbededFiles(newEmbededFiles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES, newEmbededFiles, newEmbededFiles));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__HYPER_LINKS:
				return ((InternalEList<?>)getHyperLinks()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT:
				return basicSetRoot(null, msgs);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES:
				return basicSetDependencies(null, msgs);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES:
				return basicSetEmbededFiles(null, msgs);
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
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ID:
				return getId();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__NAME:
				return getName();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__HYPER_LINKS:
				return getHyperLinks();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_TYPE:
				return getScopeType();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LIBRARIES:
				return getLibraries();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ADDITIONAL_SOURCES:
				return getAdditionalSources();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STANDARD_HEADERS:
				return getStandardHeaders();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INCLUDE_PATH:
				return getIncludePath();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TARGET_MAIN:
				return getTargetMain();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INSTRUMENTATION:
				return getInstrumentation();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TIME_MODEL:
				return getTimeModel();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_ACTORS:
				return getM_generateActors();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STATECHART_IMPLEMENTATION:
				return getStatechartImplementation();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIALIZATION_CODE:
				return getInitializationCode();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CHECKS_LIST:
				return getChecksList();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_ELEMENTS:
				return getScopeElements();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__WEAK_CG_TIME:
				return getWeakCGTime();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STRONG_CG_TIME:
				return getStrongCGTime();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MALL_IN_ANIM_SCOPE:
				return getM_allInAnimScope();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_USECASES:
				return getM_generateUsecases();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES:
				if (resolve) return getDependencies();
				return basicGetDependencies();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIAL_INSTANCES:
				return getInitialInstances();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TAGS:
				return getTags();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CMHEADER:
				return getCmheader();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STEREOTYPES:
				return getStereotypes();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANIM_SCOPE_ELEMENTS:
				return getAnimScopeElements();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES:
				if (resolve) return getEmbededFiles();
				return basicGetEmbededFiles();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__HYPER_LINKS:
				getHyperLinks().clear();
				getHyperLinks().addAll((Collection<? extends IMHyperLink>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_TYPE:
				setScopeType((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LIBRARIES:
				setLibraries((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ADDITIONAL_SOURCES:
				setAdditionalSources((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STANDARD_HEADERS:
				setStandardHeaders((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INCLUDE_PATH:
				setIncludePath((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TARGET_MAIN:
				setTargetMain((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INSTRUMENTATION:
				setInstrumentation((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TIME_MODEL:
				setTimeModel((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_ACTORS:
				setM_generateActors((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STATECHART_IMPLEMENTATION:
				setStatechartImplementation((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIALIZATION_CODE:
				setInitializationCode((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CHECKS_LIST:
				getChecksList().clear();
				getChecksList().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_ELEMENTS:
				getScopeElements().clear();
				getScopeElements().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT:
				setRoot((IFolder)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__WEAK_CG_TIME:
				getWeakCGTime().clear();
				getWeakCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STRONG_CG_TIME:
				getStrongCGTime().clear();
				getStrongCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MALL_IN_ANIM_SCOPE:
				setM_allInAnimScope((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_USECASES:
				setM_generateUsecases((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES:
				setDependencies((IDependency)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIAL_INSTANCES:
				getInitialInstances().clear();
				getInitialInstances().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS:
				setAnnotations((IComment)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CMHEADER:
				setCmheader((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STEREOTYPES:
				getStereotypes().clear();
				getStereotypes().addAll((Collection<? extends IClassifier>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANIM_SCOPE_ELEMENTS:
				getAnimScopeElements().clear();
				getAnimScopeElements().addAll((Collection<? extends ElementsType>)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES:
				setEmbededFiles((IEmbededFile)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__HYPER_LINKS:
				getHyperLinks().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_TYPE:
				setScopeType(SCOPE_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LIBRARIES:
				setLibraries(LIBRARIES_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ADDITIONAL_SOURCES:
				setAdditionalSources(ADDITIONAL_SOURCES_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STANDARD_HEADERS:
				setStandardHeaders(STANDARD_HEADERS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INCLUDE_PATH:
				setIncludePath(INCLUDE_PATH_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TARGET_MAIN:
				setTargetMain(TARGET_MAIN_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INSTRUMENTATION:
				setInstrumentation(INSTRUMENTATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TIME_MODEL:
				setTimeModel(TIME_MODEL_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_ACTORS:
				setM_generateActors(MGENERATE_ACTORS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STATECHART_IMPLEMENTATION:
				setStatechartImplementation(STATECHART_IMPLEMENTATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIALIZATION_CODE:
				setInitializationCode(INITIALIZATION_CODE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CHECKS_LIST:
				getChecksList().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_ELEMENTS:
				getScopeElements().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT:
				setRoot((IFolder)null);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__WEAK_CG_TIME:
				getWeakCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STRONG_CG_TIME:
				getStrongCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MALL_IN_ANIM_SCOPE:
				setM_allInAnimScope(MALL_IN_ANIM_SCOPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_USECASES:
				setM_generateUsecases(MGENERATE_USECASES_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES:
				setDependencies((IDependency)null);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIAL_INSTANCES:
				getInitialInstances().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS:
				setAnnotations((IComment)null);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CMHEADER:
				setCmheader(CMHEADER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STEREOTYPES:
				getStereotypes().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANIM_SCOPE_ELEMENTS:
				getAnimScopeElements().clear();
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES:
				setEmbededFiles((IEmbededFile)null);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__HYPER_LINKS:
				return hyperLinks != null && !hyperLinks.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_TYPE:
				return SCOPE_TYPE_EDEFAULT == null ? scopeType != null : !SCOPE_TYPE_EDEFAULT.equals(scopeType);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LIBRARIES:
				return LIBRARIES_EDEFAULT == null ? libraries != null : !LIBRARIES_EDEFAULT.equals(libraries);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ADDITIONAL_SOURCES:
				return ADDITIONAL_SOURCES_EDEFAULT == null ? additionalSources != null : !ADDITIONAL_SOURCES_EDEFAULT.equals(additionalSources);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STANDARD_HEADERS:
				return STANDARD_HEADERS_EDEFAULT == null ? standardHeaders != null : !STANDARD_HEADERS_EDEFAULT.equals(standardHeaders);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INCLUDE_PATH:
				return INCLUDE_PATH_EDEFAULT == null ? includePath != null : !INCLUDE_PATH_EDEFAULT.equals(includePath);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TARGET_MAIN:
				return TARGET_MAIN_EDEFAULT == null ? targetMain != null : !TARGET_MAIN_EDEFAULT.equals(targetMain);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INSTRUMENTATION:
				return INSTRUMENTATION_EDEFAULT == null ? instrumentation != null : !INSTRUMENTATION_EDEFAULT.equals(instrumentation);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TIME_MODEL:
				return TIME_MODEL_EDEFAULT == null ? timeModel != null : !TIME_MODEL_EDEFAULT.equals(timeModel);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_ACTORS:
				return MGENERATE_ACTORS_EDEFAULT == null ? m_generateActors != null : !MGENERATE_ACTORS_EDEFAULT.equals(m_generateActors);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STATECHART_IMPLEMENTATION:
				return STATECHART_IMPLEMENTATION_EDEFAULT == null ? statechartImplementation != null : !STATECHART_IMPLEMENTATION_EDEFAULT.equals(statechartImplementation);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIALIZATION_CODE:
				return INITIALIZATION_CODE_EDEFAULT == null ? initializationCode != null : !INITIALIZATION_CODE_EDEFAULT.equals(initializationCode);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CHECKS_LIST:
				return checksList != null && !checksList.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__SCOPE_ELEMENTS:
				return scopeElements != null && !scopeElements.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ROOT:
				return root != null;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__WEAK_CG_TIME:
				return weakCGTime != null && !weakCGTime.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STRONG_CG_TIME:
				return strongCGTime != null && !strongCGTime.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MALL_IN_ANIM_SCOPE:
				return MALL_IN_ANIM_SCOPE_EDEFAULT == null ? m_allInAnimScope != null : !MALL_IN_ANIM_SCOPE_EDEFAULT.equals(m_allInAnimScope);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__MGENERATE_USECASES:
				return MGENERATE_USECASES_EDEFAULT == null ? m_generateUsecases != null : !MGENERATE_USECASES_EDEFAULT.equals(m_generateUsecases);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DEPENDENCIES:
				return dependencies != null;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__INITIAL_INSTANCES:
				return initialInstances != null && !initialInstances.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANNOTATIONS:
				return annotations != null;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CMHEADER:
				return CMHEADER_EDEFAULT == null ? cmheader != null : !CMHEADER_EDEFAULT.equals(cmheader);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__STEREOTYPES:
				return stereotypes != null && !stereotypes.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__ANIM_SCOPE_ELEMENTS:
				return animScopeElements != null && !animScopeElements.isEmpty();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__EMBEDED_FILES:
				return embededFiles != null;
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO__UML_DEPENDENCY_ID:
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
		result.append(", scopeType: "); //$NON-NLS-1$
		result.append(scopeType);
		result.append(", libraries: "); //$NON-NLS-1$
		result.append(libraries);
		result.append(", additionalSources: "); //$NON-NLS-1$
		result.append(additionalSources);
		result.append(", standardHeaders: "); //$NON-NLS-1$
		result.append(standardHeaders);
		result.append(", includePath: "); //$NON-NLS-1$
		result.append(includePath);
		result.append(", targetMain: "); //$NON-NLS-1$
		result.append(targetMain);
		result.append(", instrumentation: "); //$NON-NLS-1$
		result.append(instrumentation);
		result.append(", timeModel: "); //$NON-NLS-1$
		result.append(timeModel);
		result.append(", m_generateActors: "); //$NON-NLS-1$
		result.append(m_generateActors);
		result.append(", statechartImplementation: "); //$NON-NLS-1$
		result.append(statechartImplementation);
		result.append(", initializationCode: "); //$NON-NLS-1$
		result.append(initializationCode);
		result.append(", checksList: "); //$NON-NLS-1$
		result.append(checksList);
		result.append(", weakCGTime: "); //$NON-NLS-1$
		result.append(weakCGTime);
		result.append(", strongCGTime: "); //$NON-NLS-1$
		result.append(strongCGTime);
		result.append(", m_allInAnimScope: "); //$NON-NLS-1$
		result.append(m_allInAnimScope);
		result.append(", m_generateUsecases: "); //$NON-NLS-1$
		result.append(m_generateUsecases);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", cmheader: "); //$NON-NLS-1$
		result.append(cmheader);
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

} //ICodeGenConfigInfoImpl
