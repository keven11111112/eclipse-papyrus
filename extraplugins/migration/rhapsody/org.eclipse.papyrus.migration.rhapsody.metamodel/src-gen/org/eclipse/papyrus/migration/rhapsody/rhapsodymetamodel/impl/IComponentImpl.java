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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultSubsystemType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICodeGenConfigInfo;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICodeGenConfigInfoHandle;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponent;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFolder;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OwnerHandleType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IComponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getWeakCGTime <em>Weak CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getStrongCGTime <em>Strong CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getOwnerHandle <em>Owner Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_buildType <em>Mbuild Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_libraries <em>Mlibraries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_additionalSources <em>Madditional Sources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_standardHeaders <em>Mstandard Headers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_includePath <em>Minclude Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_initializationCode <em>Minitialization Code</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_folder <em>Mfolder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getM_configActive <em>Mconfig Active</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getConfigs <em>Configs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getHandlesInMe <em>Handles In Me</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getDeclaratives <em>Declaratives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getVariationPoints <em>Variation Points</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getSelectedVariants <em>Selected Variants</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IComponentImpl#getCmheader <em>Cmheader</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IComponentImpl extends IUnitImpl implements IComponent {
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
	 * The cached value of the '{@link #getOwnerHandle() <em>Owner Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerHandle()
	 * @generated
	 * @ordered
	 */
	protected OwnerHandleType ownerHandle;

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
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IClassifier> stereotypes;

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
	 * The default value of the '{@link #getM_buildType() <em>Mbuild Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_buildType()
	 * @generated
	 * @ordered
	 */
	protected static final String MBUILD_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_buildType() <em>Mbuild Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_buildType()
	 * @generated
	 * @ordered
	 */
	protected String m_buildType = MBUILD_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_libraries() <em>Mlibraries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_libraries()
	 * @generated
	 * @ordered
	 */
	protected static final String MLIBRARIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_libraries() <em>Mlibraries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_libraries()
	 * @generated
	 * @ordered
	 */
	protected String m_libraries = MLIBRARIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_additionalSources() <em>Madditional Sources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_additionalSources()
	 * @generated
	 * @ordered
	 */
	protected static final String MADDITIONAL_SOURCES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_additionalSources() <em>Madditional Sources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_additionalSources()
	 * @generated
	 * @ordered
	 */
	protected String m_additionalSources = MADDITIONAL_SOURCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_standardHeaders() <em>Mstandard Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_standardHeaders()
	 * @generated
	 * @ordered
	 */
	protected static final String MSTANDARD_HEADERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_standardHeaders() <em>Mstandard Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_standardHeaders()
	 * @generated
	 * @ordered
	 */
	protected String m_standardHeaders = MSTANDARD_HEADERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_includePath() <em>Minclude Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_includePath()
	 * @generated
	 * @ordered
	 */
	protected static final String MINCLUDE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_includePath() <em>Minclude Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_includePath()
	 * @generated
	 * @ordered
	 */
	protected String m_includePath = MINCLUDE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_initializationCode() <em>Minitialization Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_initializationCode()
	 * @generated
	 * @ordered
	 */
	protected static final String MINITIALIZATION_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_initializationCode() <em>Minitialization Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_initializationCode()
	 * @generated
	 * @ordered
	 */
	protected String m_initializationCode = MINITIALIZATION_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_folder() <em>Mfolder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_folder()
	 * @generated
	 * @ordered
	 */
	protected IFolder m_folder;

	/**
	 * The cached value of the '{@link #getM_configActive() <em>Mconfig Active</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_configActive()
	 * @generated
	 * @ordered
	 */
	protected ICodeGenConfigInfoHandle m_configActive;

	/**
	 * The cached value of the '{@link #getConfigs() <em>Configs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigs()
	 * @generated
	 * @ordered
	 */
	protected EList<ICodeGenConfigInfo> configs;

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
	 * The cached value of the '{@link #getHandlesInMe() <em>Handles In Me</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandlesInMe()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultSubsystemType> handlesInMe;

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
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected IMHyperLink hyperLinks;

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
	 * The cached value of the '{@link #getDeclaratives() <em>Declaratives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaratives()
	 * @generated
	 * @ordered
	 */
	protected EList<IUnit> declaratives;

	/**
	 * The cached value of the '{@link #getVariationPoints() <em>Variation Points</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariationPoints()
	 * @generated
	 * @ordered
	 */
	protected IUnit variationPoints;

	/**
	 * The cached value of the '{@link #getSelectedVariants() <em>Selected Variants</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedVariants()
	 * @generated
	 * @ordered
	 */
	protected IUnit selectedVariants;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWeakCGTime() {
		if (weakCGTime == null) {
			weakCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME);
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
			strongCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME);
		}
		return strongCGTime;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__OWNER_HANDLE, oldOwnerHandle, ownerHandle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClassifier> getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectResolvingEList<IClassifier>(IClassifier.class, this, UMLRhapsodyPackage.ICOMPONENT__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICOMPONENT__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_buildType() {
		return m_buildType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_buildType(String newM_buildType) {
		String oldM_buildType = m_buildType;
		m_buildType = newM_buildType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MBUILD_TYPE, oldM_buildType, m_buildType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_libraries() {
		return m_libraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_libraries(String newM_libraries) {
		String oldM_libraries = m_libraries;
		m_libraries = newM_libraries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MLIBRARIES, oldM_libraries, m_libraries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_additionalSources() {
		return m_additionalSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_additionalSources(String newM_additionalSources) {
		String oldM_additionalSources = m_additionalSources;
		m_additionalSources = newM_additionalSources;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MADDITIONAL_SOURCES, oldM_additionalSources, m_additionalSources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_standardHeaders() {
		return m_standardHeaders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_standardHeaders(String newM_standardHeaders) {
		String oldM_standardHeaders = m_standardHeaders;
		m_standardHeaders = newM_standardHeaders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MSTANDARD_HEADERS, oldM_standardHeaders, m_standardHeaders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_includePath() {
		return m_includePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_includePath(String newM_includePath) {
		String oldM_includePath = m_includePath;
		m_includePath = newM_includePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MINCLUDE_PATH, oldM_includePath, m_includePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_initializationCode() {
		return m_initializationCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_initializationCode(String newM_initializationCode) {
		String oldM_initializationCode = m_initializationCode;
		m_initializationCode = newM_initializationCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MINITIALIZATION_CODE, oldM_initializationCode, m_initializationCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFolder getM_folder() {
		if (m_folder != null && m_folder.eIsProxy()) {
			InternalEObject oldM_folder = (InternalEObject)m_folder;
			m_folder = (IFolder)eResolveProxy(oldM_folder);
			if (m_folder != oldM_folder) {
				InternalEObject newM_folder = (InternalEObject)m_folder;
				NotificationChain msgs = oldM_folder.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MFOLDER, null, null);
				if (newM_folder.eInternalContainer() == null) {
					msgs = newM_folder.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MFOLDER, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__MFOLDER, oldM_folder, m_folder));
			}
		}
		return m_folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFolder basicGetM_folder() {
		return m_folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_folder(IFolder newM_folder, NotificationChain msgs) {
		IFolder oldM_folder = m_folder;
		m_folder = newM_folder;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MFOLDER, oldM_folder, newM_folder);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_folder(IFolder newM_folder) {
		if (newM_folder != m_folder) {
			NotificationChain msgs = null;
			if (m_folder != null)
				msgs = ((InternalEObject)m_folder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MFOLDER, null, msgs);
			if (newM_folder != null)
				msgs = ((InternalEObject)newM_folder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MFOLDER, null, msgs);
			msgs = basicSetM_folder(newM_folder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MFOLDER, newM_folder, newM_folder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICodeGenConfigInfoHandle getM_configActive() {
		if (m_configActive != null && m_configActive.eIsProxy()) {
			InternalEObject oldM_configActive = (InternalEObject)m_configActive;
			m_configActive = (ICodeGenConfigInfoHandle)eResolveProxy(oldM_configActive);
			if (m_configActive != oldM_configActive) {
				InternalEObject newM_configActive = (InternalEObject)m_configActive;
				NotificationChain msgs = oldM_configActive.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE, null, null);
				if (newM_configActive.eInternalContainer() == null) {
					msgs = newM_configActive.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE, oldM_configActive, m_configActive));
			}
		}
		return m_configActive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICodeGenConfigInfoHandle basicGetM_configActive() {
		return m_configActive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_configActive(ICodeGenConfigInfoHandle newM_configActive, NotificationChain msgs) {
		ICodeGenConfigInfoHandle oldM_configActive = m_configActive;
		m_configActive = newM_configActive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE, oldM_configActive, newM_configActive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_configActive(ICodeGenConfigInfoHandle newM_configActive) {
		if (newM_configActive != m_configActive) {
			NotificationChain msgs = null;
			if (m_configActive != null)
				msgs = ((InternalEObject)m_configActive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE, null, msgs);
			if (newM_configActive != null)
				msgs = ((InternalEObject)newM_configActive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE, null, msgs);
			msgs = basicSetM_configActive(newM_configActive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE, newM_configActive, newM_configActive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ICodeGenConfigInfo> getConfigs() {
		if (configs == null) {
			configs = new EObjectContainmentEList.Resolving<ICodeGenConfigInfo>(ICodeGenConfigInfo.class, this, UMLRhapsodyPackage.ICOMPONENT__CONFIGS);
		}
		return configs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.ICOMPONENT__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefaultSubsystemType> getHandlesInMe() {
		if (handlesInMe == null) {
			handlesInMe = new EObjectResolvingEList<DefaultSubsystemType>(DefaultSubsystemType.class, this, UMLRhapsodyPackage.ICOMPONENT__HANDLES_IN_ME);
		}
		return handlesInMe;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__PROPERTIES, newProperties, newProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__LAST_ID, oldLastID, lastID));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION, newDescription, newDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
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
				NotificationChain msgs = oldHyperLinks.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS, null, null);
				if (newHyperLinks.eInternalContainer() == null) {
					msgs = newHyperLinks.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS, oldHyperLinks, hyperLinks));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS, oldHyperLinks, newHyperLinks);
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
				msgs = ((InternalEObject)hyperLinks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS, null, msgs);
			if (newHyperLinks != null)
				msgs = ((InternalEObject)newHyperLinks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS, null, msgs);
			msgs = basicSetHyperLinks(newHyperLinks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS, newHyperLinks, newHyperLinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ICOMPONENT__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getDeclaratives() {
		if (declaratives == null) {
			declaratives = new EObjectContainmentEList.Resolving<IUnit>(IUnit.class, this, UMLRhapsodyPackage.ICOMPONENT__DECLARATIVES);
		}
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit getVariationPoints() {
		if (variationPoints != null && variationPoints.eIsProxy()) {
			InternalEObject oldVariationPoints = (InternalEObject)variationPoints;
			variationPoints = (IUnit)eResolveProxy(oldVariationPoints);
			if (variationPoints != oldVariationPoints) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__VARIATION_POINTS, oldVariationPoints, variationPoints));
			}
		}
		return variationPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit basicGetVariationPoints() {
		return variationPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariationPoints(IUnit newVariationPoints) {
		IUnit oldVariationPoints = variationPoints;
		variationPoints = newVariationPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__VARIATION_POINTS, oldVariationPoints, variationPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit getSelectedVariants() {
		if (selectedVariants != null && selectedVariants.eIsProxy()) {
			InternalEObject oldSelectedVariants = (InternalEObject)selectedVariants;
			selectedVariants = (IUnit)eResolveProxy(oldSelectedVariants);
			if (selectedVariants != oldSelectedVariants) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOMPONENT__SELECTED_VARIANTS, oldSelectedVariants, selectedVariants));
			}
		}
		return selectedVariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit basicGetSelectedVariants() {
		return selectedVariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedVariants(IUnit newSelectedVariants) {
		IUnit oldSelectedVariants = selectedVariants;
		selectedVariants = newSelectedVariants;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__SELECTED_VARIANTS, oldSelectedVariants, selectedVariants));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOMPONENT__CMHEADER, oldCmheader, cmheader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICOMPONENT__MFOLDER:
				return basicSetM_folder(null, msgs);
			case UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE:
				return basicSetM_configActive(null, msgs);
			case UMLRhapsodyPackage.ICOMPONENT__CONFIGS:
				return ((InternalEList<?>)getConfigs()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICOMPONENT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICOMPONENT__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS:
				return basicSetHyperLinks(null, msgs);
			case UMLRhapsodyPackage.ICOMPONENT__DECLARATIVES:
				return ((InternalEList<?>)getDeclaratives()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME:
				return getWeakCGTime();
			case UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME:
				return getStrongCGTime();
			case UMLRhapsodyPackage.ICOMPONENT__OWNER_HANDLE:
				if (resolve) return getOwnerHandle();
				return basicGetOwnerHandle();
			case UMLRhapsodyPackage.ICOMPONENT__ID:
				return getId();
			case UMLRhapsodyPackage.ICOMPONENT__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.ICOMPONENT__NAME:
				return getName();
			case UMLRhapsodyPackage.ICOMPONENT__STEREOTYPES:
				return getStereotypes();
			case UMLRhapsodyPackage.ICOMPONENT__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ICOMPONENT__MBUILD_TYPE:
				return getM_buildType();
			case UMLRhapsodyPackage.ICOMPONENT__MLIBRARIES:
				return getM_libraries();
			case UMLRhapsodyPackage.ICOMPONENT__MADDITIONAL_SOURCES:
				return getM_additionalSources();
			case UMLRhapsodyPackage.ICOMPONENT__MSTANDARD_HEADERS:
				return getM_standardHeaders();
			case UMLRhapsodyPackage.ICOMPONENT__MINCLUDE_PATH:
				return getM_includePath();
			case UMLRhapsodyPackage.ICOMPONENT__MINITIALIZATION_CODE:
				return getM_initializationCode();
			case UMLRhapsodyPackage.ICOMPONENT__MFOLDER:
				if (resolve) return getM_folder();
				return basicGetM_folder();
			case UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE:
				if (resolve) return getM_configActive();
				return basicGetM_configActive();
			case UMLRhapsodyPackage.ICOMPONENT__CONFIGS:
				return getConfigs();
			case UMLRhapsodyPackage.ICOMPONENT__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.ICOMPONENT__HANDLES_IN_ME:
				return getHandlesInMe();
			case UMLRhapsodyPackage.ICOMPONENT__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.ICOMPONENT__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.ICOMPONENT__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS:
				if (resolve) return getHyperLinks();
				return basicGetHyperLinks();
			case UMLRhapsodyPackage.ICOMPONENT__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.ICOMPONENT__DECLARATIVES:
				return getDeclaratives();
			case UMLRhapsodyPackage.ICOMPONENT__VARIATION_POINTS:
				if (resolve) return getVariationPoints();
				return basicGetVariationPoints();
			case UMLRhapsodyPackage.ICOMPONENT__SELECTED_VARIANTS:
				if (resolve) return getSelectedVariants();
				return basicGetSelectedVariants();
			case UMLRhapsodyPackage.ICOMPONENT__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.ICOMPONENT__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.ICOMPONENT__CMHEADER:
				return getCmheader();
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
			case UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME:
				getWeakCGTime().clear();
				getWeakCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME:
				getStrongCGTime().clear();
				getStrongCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__OWNER_HANDLE:
				setOwnerHandle((OwnerHandleType)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__STEREOTYPES:
				getStereotypes().clear();
				getStereotypes().addAll((Collection<? extends IClassifier>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MBUILD_TYPE:
				setM_buildType((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MLIBRARIES:
				setM_libraries((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MADDITIONAL_SOURCES:
				setM_additionalSources((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MSTANDARD_HEADERS:
				setM_standardHeaders((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MINCLUDE_PATH:
				setM_includePath((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MINITIALIZATION_CODE:
				setM_initializationCode((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MFOLDER:
				setM_folder((IFolder)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE:
				setM_configActive((ICodeGenConfigInfoHandle)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__CONFIGS:
				getConfigs().clear();
				getConfigs().addAll((Collection<? extends ICodeGenConfigInfo>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__HANDLES_IN_ME:
				getHandlesInMe().clear();
				getHandlesInMe().addAll((Collection<? extends DefaultSubsystemType>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS:
				setHyperLinks((IMHyperLink)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__DECLARATIVES:
				getDeclaratives().clear();
				getDeclaratives().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__VARIATION_POINTS:
				setVariationPoints((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__SELECTED_VARIANTS:
				setSelectedVariants((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__CMHEADER:
				setCmheader((String)newValue);
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
			case UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME:
				getWeakCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME:
				getStrongCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__OWNER_HANDLE:
				setOwnerHandle((OwnerHandleType)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__STEREOTYPES:
				getStereotypes().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MBUILD_TYPE:
				setM_buildType(MBUILD_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MLIBRARIES:
				setM_libraries(MLIBRARIES_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MADDITIONAL_SOURCES:
				setM_additionalSources(MADDITIONAL_SOURCES_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MSTANDARD_HEADERS:
				setM_standardHeaders(MSTANDARD_HEADERS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MINCLUDE_PATH:
				setM_includePath(MINCLUDE_PATH_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MINITIALIZATION_CODE:
				setM_initializationCode(MINITIALIZATION_CODE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MFOLDER:
				setM_folder((IFolder)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE:
				setM_configActive((ICodeGenConfigInfoHandle)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__CONFIGS:
				getConfigs().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__HANDLES_IN_ME:
				getHandlesInMe().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS:
				setHyperLinks((IMHyperLink)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__DECLARATIVES:
				getDeclaratives().clear();
				return;
			case UMLRhapsodyPackage.ICOMPONENT__VARIATION_POINTS:
				setVariationPoints((IUnit)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__SELECTED_VARIANTS:
				setSelectedVariants((IUnit)null);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOMPONENT__CMHEADER:
				setCmheader(CMHEADER_EDEFAULT);
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
			case UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME:
				return weakCGTime != null && !weakCGTime.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME:
				return strongCGTime != null && !strongCGTime.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__OWNER_HANDLE:
				return ownerHandle != null;
			case UMLRhapsodyPackage.ICOMPONENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ICOMPONENT__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.ICOMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ICOMPONENT__STEREOTYPES:
				return stereotypes != null && !stereotypes.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__MBUILD_TYPE:
				return MBUILD_TYPE_EDEFAULT == null ? m_buildType != null : !MBUILD_TYPE_EDEFAULT.equals(m_buildType);
			case UMLRhapsodyPackage.ICOMPONENT__MLIBRARIES:
				return MLIBRARIES_EDEFAULT == null ? m_libraries != null : !MLIBRARIES_EDEFAULT.equals(m_libraries);
			case UMLRhapsodyPackage.ICOMPONENT__MADDITIONAL_SOURCES:
				return MADDITIONAL_SOURCES_EDEFAULT == null ? m_additionalSources != null : !MADDITIONAL_SOURCES_EDEFAULT.equals(m_additionalSources);
			case UMLRhapsodyPackage.ICOMPONENT__MSTANDARD_HEADERS:
				return MSTANDARD_HEADERS_EDEFAULT == null ? m_standardHeaders != null : !MSTANDARD_HEADERS_EDEFAULT.equals(m_standardHeaders);
			case UMLRhapsodyPackage.ICOMPONENT__MINCLUDE_PATH:
				return MINCLUDE_PATH_EDEFAULT == null ? m_includePath != null : !MINCLUDE_PATH_EDEFAULT.equals(m_includePath);
			case UMLRhapsodyPackage.ICOMPONENT__MINITIALIZATION_CODE:
				return MINITIALIZATION_CODE_EDEFAULT == null ? m_initializationCode != null : !MINITIALIZATION_CODE_EDEFAULT.equals(m_initializationCode);
			case UMLRhapsodyPackage.ICOMPONENT__MFOLDER:
				return m_folder != null;
			case UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE:
				return m_configActive != null;
			case UMLRhapsodyPackage.ICOMPONENT__CONFIGS:
				return configs != null && !configs.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__HANDLES_IN_ME:
				return handlesInMe != null && !handlesInMe.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.ICOMPONENT__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.ICOMPONENT__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS:
				return hyperLinks != null;
			case UMLRhapsodyPackage.ICOMPONENT__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__DECLARATIVES:
				return declaratives != null && !declaratives.isEmpty();
			case UMLRhapsodyPackage.ICOMPONENT__VARIATION_POINTS:
				return variationPoints != null;
			case UMLRhapsodyPackage.ICOMPONENT__SELECTED_VARIANTS:
				return selectedVariants != null;
			case UMLRhapsodyPackage.ICOMPONENT__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.ICOMPONENT__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.ICOMPONENT__CMHEADER:
				return CMHEADER_EDEFAULT == null ? cmheader != null : !CMHEADER_EDEFAULT.equals(cmheader);
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
		if (baseClass == DefaultSubsystemType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == OwnerHandleType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME: return UMLRhapsodyPackage.OWNER_HANDLE_TYPE__WEAK_CG_TIME;
				case UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME: return UMLRhapsodyPackage.OWNER_HANDLE_TYPE__STRONG_CG_TIME;
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
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DefaultSubsystemType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == OwnerHandleType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.OWNER_HANDLE_TYPE__WEAK_CG_TIME: return UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME;
				case UMLRhapsodyPackage.OWNER_HANDLE_TYPE__STRONG_CG_TIME: return UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME;
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
		result.append(" (weakCGTime: "); //$NON-NLS-1$
		result.append(weakCGTime);
		result.append(", strongCGTime: "); //$NON-NLS-1$
		result.append(strongCGTime);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", m_buildType: "); //$NON-NLS-1$
		result.append(m_buildType);
		result.append(", m_libraries: "); //$NON-NLS-1$
		result.append(m_libraries);
		result.append(", m_additionalSources: "); //$NON-NLS-1$
		result.append(m_additionalSources);
		result.append(", m_standardHeaders: "); //$NON-NLS-1$
		result.append(m_standardHeaders);
		result.append(", m_includePath: "); //$NON-NLS-1$
		result.append(m_includePath);
		result.append(", m_initializationCode: "); //$NON-NLS-1$
		result.append(m_initializationCode);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(", cmheader: "); //$NON-NLS-1$
		result.append(cmheader);
		result.append(')');
		return result.toString();
	}

} //IComponentImpl
