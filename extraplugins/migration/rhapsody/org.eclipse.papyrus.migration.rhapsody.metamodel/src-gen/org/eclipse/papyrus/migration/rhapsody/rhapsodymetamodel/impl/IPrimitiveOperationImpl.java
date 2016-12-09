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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.EmbededFilesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityGraph;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IBody;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMSC;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPrimitiveOperation;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateParameter;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IVariable;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItemsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IPrimitive Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getConcurrency <em>Concurrency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getProtection <em>Protection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getItsBody <em>Its Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getMyReturnType <em>My Return Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getDeclaratives <em>Declaratives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getItsActivityGraph <em>Its Activity Graph</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getEmbededFiles <em>Embeded Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IPrimitiveOperationImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IPrimitiveOperationImpl extends OperationsTypeImpl implements IPrimitiveOperation {
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
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<IVariable> args;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected IClassifier returnType;

	/**
	 * The default value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final String ABSTRACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstract()
	 * @generated
	 * @ordered
	 */
	protected String abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinal()
	 * @generated
	 * @ordered
	 */
	protected static final String FINAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinal()
	 * @generated
	 * @ordered
	 */
	protected String final_ = FINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConcurrency() <em>Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurrency()
	 * @generated
	 * @ordered
	 */
	protected static final String CONCURRENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConcurrency() <em>Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurrency()
	 * @generated
	 * @ordered
	 */
	protected String concurrency = CONCURRENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtection() <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtection()
	 * @generated
	 * @ordered
	 */
	protected static final String PROTECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProtection() <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtection()
	 * @generated
	 * @ordered
	 */
	protected String protection = PROTECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatic()
	 * @generated
	 * @ordered
	 */
	protected static final String STATIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatic()
	 * @generated
	 * @ordered
	 */
	protected String static_ = STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstant()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstant()
	 * @generated
	 * @ordered
	 */
	protected String constant = CONSTANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItsBody() <em>Its Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsBody()
	 * @generated
	 * @ordered
	 */
	protected IBody itsBody;

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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected IComment annotations;

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
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IClassifier stereotypes;

	/**
	 * The cached value of the '{@link #getMyReturnType() <em>My Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyReturnType()
	 * @generated
	 * @ordered
	 */
	protected IType myReturnType;

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
	 * The cached value of the '{@link #getDeclaratives() <em>Declaratives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaratives()
	 * @generated
	 * @ordered
	 */
	protected EList<IMSC> declaratives;

	/**
	 * The cached value of the '{@link #getItsActivityGraph() <em>Its Activity Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsActivityGraph()
	 * @generated
	 * @ordered
	 */
	protected IActivityGraph itsActivityGraph;

	/**
	 * The cached value of the '{@link #getEmbededFiles() <em>Embeded Files</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmbededFiles()
	 * @generated
	 * @ordered
	 */
	protected EmbededFilesType embededFiles;

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
	 * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameters()
	 * @generated
	 * @ordered
	 */
	protected ITemplateParameter templateParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IPrimitiveOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIPrimitiveOperation();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__OBJECT_CREATION, oldObjectCreation, objectCreation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MODIFIED_TIME_WEAK);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__NAME, oldName, name));
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES, newProperties, newProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__LAST_ID, oldLastID, lastID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IVariable> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList.Resolving<IVariable>(IVariable.class, this, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier getReturnType() {
		if (returnType != null && returnType.eIsProxy()) {
			InternalEObject oldReturnType = (InternalEObject)returnType;
			returnType = (IClassifier)eResolveProxy(oldReturnType);
			if (returnType != oldReturnType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__RETURN_TYPE, oldReturnType, returnType));
			}
		}
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier basicGetReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(IClassifier newReturnType) {
		IClassifier oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__RETURN_TYPE, oldReturnType, returnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(String newAbstract) {
		String oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFinal() {
		return final_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinal(String newFinal) {
		String oldFinal = final_;
		final_ = newFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcurrency() {
		return concurrency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcurrency(String newConcurrency) {
		String oldConcurrency = concurrency;
		concurrency = newConcurrency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONCURRENCY, oldConcurrency, concurrency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProtection() {
		return protection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtection(String newProtection) {
		String oldProtection = protection;
		protection = newProtection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROTECTION, oldProtection, protection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatic() {
		return static_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatic(String newStatic) {
		String oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstant() {
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstant(String newConstant) {
		String oldConstant = constant;
		constant = newConstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONSTANT, oldConstant, constant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBody getItsBody() {
		if (itsBody != null && itsBody.eIsProxy()) {
			InternalEObject oldItsBody = (InternalEObject)itsBody;
			itsBody = (IBody)eResolveProxy(oldItsBody);
			if (itsBody != oldItsBody) {
				InternalEObject newItsBody = (InternalEObject)itsBody;
				NotificationChain msgs = oldItsBody.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY, null, null);
				if (newItsBody.eInternalContainer() == null) {
					msgs = newItsBody.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY, oldItsBody, itsBody));
			}
		}
		return itsBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBody basicGetItsBody() {
		return itsBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItsBody(IBody newItsBody, NotificationChain msgs) {
		IBody oldItsBody = itsBody;
		itsBody = newItsBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY, oldItsBody, newItsBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsBody(IBody newItsBody) {
		if (newItsBody != itsBody) {
			NotificationChain msgs = null;
			if (itsBody != null)
				msgs = ((InternalEObject)itsBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY, null, msgs);
			if (newItsBody != null)
				msgs = ((InternalEObject)newItsBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY, null, msgs);
			msgs = basicSetItsBody(newItsBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY, newItsBody, newItsBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TAGS);
		}
		return tags;
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
				NotificationChain msgs = oldAnnotations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS, null, null);
				if (newAnnotations.eInternalContainer() == null) {
					msgs = newAnnotations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS, oldAnnotations, annotations));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS, oldAnnotations, newAnnotations);
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
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS, newAnnotations, newAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DEPENDENCIES);
		}
		return dependencies;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STEREOTYPES, oldStereotypes, stereotypes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType getMyReturnType() {
		if (myReturnType != null && myReturnType.eIsProxy()) {
			InternalEObject oldMyReturnType = (InternalEObject)myReturnType;
			myReturnType = (IType)eResolveProxy(oldMyReturnType);
			if (myReturnType != oldMyReturnType) {
				InternalEObject newMyReturnType = (InternalEObject)myReturnType;
				NotificationChain msgs = oldMyReturnType.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE, null, null);
				if (newMyReturnType.eInternalContainer() == null) {
					msgs = newMyReturnType.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE, oldMyReturnType, myReturnType));
			}
		}
		return myReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType basicGetMyReturnType() {
		return myReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMyReturnType(IType newMyReturnType, NotificationChain msgs) {
		IType oldMyReturnType = myReturnType;
		myReturnType = newMyReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE, oldMyReturnType, newMyReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyReturnType(IType newMyReturnType) {
		if (newMyReturnType != myReturnType) {
			NotificationChain msgs = null;
			if (myReturnType != null)
				msgs = ((InternalEObject)myReturnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE, null, msgs);
			if (newMyReturnType != null)
				msgs = ((InternalEObject)newMyReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE, null, msgs);
			msgs = basicSetMyReturnType(newMyReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE, newMyReturnType, newMyReturnType));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION, newDescription, newDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DISPLAY_NAME, oldDisplayName, displayName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMSC> getDeclaratives() {
		if (declaratives == null) {
			declaratives = new EObjectContainmentEList.Resolving<IMSC>(IMSC.class, this, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DECLARATIVES);
		}
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityGraph getItsActivityGraph() {
		if (itsActivityGraph != null && itsActivityGraph.eIsProxy()) {
			InternalEObject oldItsActivityGraph = (InternalEObject)itsActivityGraph;
			itsActivityGraph = (IActivityGraph)eResolveProxy(oldItsActivityGraph);
			if (itsActivityGraph != oldItsActivityGraph) {
				InternalEObject newItsActivityGraph = (InternalEObject)itsActivityGraph;
				NotificationChain msgs = oldItsActivityGraph.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH, null, null);
				if (newItsActivityGraph.eInternalContainer() == null) {
					msgs = newItsActivityGraph.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH, oldItsActivityGraph, itsActivityGraph));
			}
		}
		return itsActivityGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityGraph basicGetItsActivityGraph() {
		return itsActivityGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItsActivityGraph(IActivityGraph newItsActivityGraph, NotificationChain msgs) {
		IActivityGraph oldItsActivityGraph = itsActivityGraph;
		itsActivityGraph = newItsActivityGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH, oldItsActivityGraph, newItsActivityGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsActivityGraph(IActivityGraph newItsActivityGraph) {
		if (newItsActivityGraph != itsActivityGraph) {
			NotificationChain msgs = null;
			if (itsActivityGraph != null)
				msgs = ((InternalEObject)itsActivityGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH, null, msgs);
			if (newItsActivityGraph != null)
				msgs = ((InternalEObject)newItsActivityGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH, null, msgs);
			msgs = basicSetItsActivityGraph(newItsActivityGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH, newItsActivityGraph, newItsActivityGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbededFilesType getEmbededFiles() {
		if (embededFiles != null && embededFiles.eIsProxy()) {
			InternalEObject oldEmbededFiles = (InternalEObject)embededFiles;
			embededFiles = (EmbededFilesType)eResolveProxy(oldEmbededFiles);
			if (embededFiles != oldEmbededFiles) {
				InternalEObject newEmbededFiles = (InternalEObject)embededFiles;
				NotificationChain msgs = oldEmbededFiles.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES, null, null);
				if (newEmbededFiles.eInternalContainer() == null) {
					msgs = newEmbededFiles.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES, oldEmbededFiles, embededFiles));
			}
		}
		return embededFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbededFilesType basicGetEmbededFiles() {
		return embededFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmbededFiles(EmbededFilesType newEmbededFiles, NotificationChain msgs) {
		EmbededFilesType oldEmbededFiles = embededFiles;
		embededFiles = newEmbededFiles;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES, oldEmbededFiles, newEmbededFiles);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmbededFiles(EmbededFilesType newEmbededFiles) {
		if (newEmbededFiles != embededFiles) {
			NotificationChain msgs = null;
			if (embededFiles != null)
				msgs = ((InternalEObject)embededFiles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES, null, msgs);
			if (newEmbededFiles != null)
				msgs = ((InternalEObject)newEmbededFiles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES, null, msgs);
			msgs = basicSetEmbededFiles(newEmbededFiles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES, newEmbededFiles, newEmbededFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateParameter getTemplateParameters() {
		if (templateParameters != null && templateParameters.eIsProxy()) {
			InternalEObject oldTemplateParameters = (InternalEObject)templateParameters;
			templateParameters = (ITemplateParameter)eResolveProxy(oldTemplateParameters);
			if (templateParameters != oldTemplateParameters) {
				InternalEObject newTemplateParameters = (InternalEObject)templateParameters;
				NotificationChain msgs = oldTemplateParameters.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS, null, null);
				if (newTemplateParameters.eInternalContainer() == null) {
					msgs = newTemplateParameters.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS, oldTemplateParameters, templateParameters));
			}
		}
		return templateParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateParameter basicGetTemplateParameters() {
		return templateParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplateParameters(ITemplateParameter newTemplateParameters, NotificationChain msgs) {
		ITemplateParameter oldTemplateParameters = templateParameters;
		templateParameters = newTemplateParameters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS, oldTemplateParameters, newTemplateParameters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateParameters(ITemplateParameter newTemplateParameters) {
		if (newTemplateParameters != templateParameters) {
			NotificationChain msgs = null;
			if (templateParameters != null)
				msgs = ((InternalEObject)templateParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS, null, msgs);
			if (newTemplateParameters != null)
				msgs = ((InternalEObject)newTemplateParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS, null, msgs);
			msgs = basicSetTemplateParameters(newTemplateParameters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS, newTemplateParameters, newTemplateParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY:
				return basicSetItsBody(null, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE:
				return basicSetMyReturnType(null, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DECLARATIVES:
				return ((InternalEList<?>)getDeclaratives()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH:
				return basicSetItsActivityGraph(null, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES:
				return basicSetEmbededFiles(null, msgs);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS:
				return basicSetTemplateParameters(null, msgs);
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
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ID:
				return getId();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__NAME:
				return getName();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ARGS:
				return getArgs();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__RETURN_TYPE:
				if (resolve) return getReturnType();
				return basicGetReturnType();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ABSTRACT:
				return getAbstract();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__FINAL:
				return getFinal();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONCURRENCY:
				return getConcurrency();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROTECTION:
				return getProtection();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STATIC:
				return getStatic();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONSTANT:
				return getConstant();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY:
				if (resolve) return getItsBody();
				return basicGetItsBody();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TAGS:
				return getTags();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE:
				if (resolve) return getMyReturnType();
				return basicGetMyReturnType();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DISPLAY_NAME:
				return getDisplayName();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DECLARATIVES:
				return getDeclaratives();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH:
				if (resolve) return getItsActivityGraph();
				return basicGetItsActivityGraph();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES:
				if (resolve) return getEmbededFiles();
				return basicGetEmbededFiles();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS:
				if (resolve) return getTemplateParameters();
				return basicGetTemplateParameters();
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
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends IVariable>)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__RETURN_TYPE:
				setReturnType((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ABSTRACT:
				setAbstract((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__FINAL:
				setFinal((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONCURRENCY:
				setConcurrency((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROTECTION:
				setProtection((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STATIC:
				setStatic((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONSTANT:
				setConstant((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY:
				setItsBody((IBody)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS:
				setAnnotations((IComment)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STEREOTYPES:
				setStereotypes((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE:
				setMyReturnType((IType)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DECLARATIVES:
				getDeclaratives().clear();
				getDeclaratives().addAll((Collection<? extends IMSC>)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH:
				setItsActivityGraph((IActivityGraph)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES:
				setEmbededFiles((EmbededFilesType)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS:
				setTemplateParameters((ITemplateParameter)newValue);
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
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ARGS:
				getArgs().clear();
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__RETURN_TYPE:
				setReturnType((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONCURRENCY:
				setConcurrency(CONCURRENCY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROTECTION:
				setProtection(PROTECTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONSTANT:
				setConstant(CONSTANT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY:
				setItsBody((IBody)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS:
				setAnnotations((IComment)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STEREOTYPES:
				setStereotypes((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE:
				setMyReturnType((IType)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DECLARATIVES:
				getDeclaratives().clear();
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH:
				setItsActivityGraph((IActivityGraph)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES:
				setEmbededFiles((EmbededFilesType)null);
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS:
				setTemplateParameters((ITemplateParameter)null);
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
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ARGS:
				return args != null && !args.isEmpty();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__RETURN_TYPE:
				return returnType != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ABSTRACT:
				return ABSTRACT_EDEFAULT == null ? abstract_ != null : !ABSTRACT_EDEFAULT.equals(abstract_);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__FINAL:
				return FINAL_EDEFAULT == null ? final_ != null : !FINAL_EDEFAULT.equals(final_);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONCURRENCY:
				return CONCURRENCY_EDEFAULT == null ? concurrency != null : !CONCURRENCY_EDEFAULT.equals(concurrency);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__PROTECTION:
				return PROTECTION_EDEFAULT == null ? protection != null : !PROTECTION_EDEFAULT.equals(protection);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STATIC:
				return STATIC_EDEFAULT == null ? static_ != null : !STATIC_EDEFAULT.equals(static_);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CONSTANT:
				return CONSTANT_EDEFAULT == null ? constant != null : !CONSTANT_EDEFAULT.equals(constant);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_BODY:
				return itsBody != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ANNOTATIONS:
				return annotations != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_RETURN_TYPE:
				return myReturnType != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__DECLARATIVES:
				return declaratives != null && !declaratives.isEmpty();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ITS_ACTIVITY_GRAPH:
				return itsActivityGraph != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__EMBEDED_FILES:
				return embededFiles != null;
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__TEMPLATE_PARAMETERS:
				return templateParameters != null;
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
		if (baseClass == M_subjectType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__OBJECT_CREATION: return UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == ValueType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ID: return UMLRhapsodyPackage.VALUE_TYPE__ID;
				case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_STATE: return UMLRhapsodyPackage.VALUE_TYPE__MY_STATE;
				case UMLRhapsodyPackage.IPRIMITIVE_OPERATION__NAME: return UMLRhapsodyPackage.VALUE_TYPE__NAME;
				default: return -1;
			}
		}
		if (baseClass == M_pFormalMessageType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ItemsType.class) {
			switch (derivedFeatureID) {
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
				case UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.IPRIMITIVE_OPERATION__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.IPRIMITIVE_OPERATION__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == ValueType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.VALUE_TYPE__ID: return UMLRhapsodyPackage.IPRIMITIVE_OPERATION__ID;
				case UMLRhapsodyPackage.VALUE_TYPE__MY_STATE: return UMLRhapsodyPackage.IPRIMITIVE_OPERATION__MY_STATE;
				case UMLRhapsodyPackage.VALUE_TYPE__NAME: return UMLRhapsodyPackage.IPRIMITIVE_OPERATION__NAME;
				default: return -1;
			}
		}
		if (baseClass == M_pFormalMessageType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ItemsType.class) {
			switch (baseFeatureID) {
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
		result.append(", abstract: "); //$NON-NLS-1$
		result.append(abstract_);
		result.append(", final: "); //$NON-NLS-1$
		result.append(final_);
		result.append(", concurrency: "); //$NON-NLS-1$
		result.append(concurrency);
		result.append(", protection: "); //$NON-NLS-1$
		result.append(protection);
		result.append(", static: "); //$NON-NLS-1$
		result.append(static_);
		result.append(", constant: "); //$NON-NLS-1$
		result.append(constant);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(')');
		return result.toString();
	}

} //IPrimitiveOperationImpl
