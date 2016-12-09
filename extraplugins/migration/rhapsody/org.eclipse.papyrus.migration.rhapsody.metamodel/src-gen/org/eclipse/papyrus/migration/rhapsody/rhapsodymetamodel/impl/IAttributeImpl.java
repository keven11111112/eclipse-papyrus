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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAttribute;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILiteralSpecification;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItemsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IAttribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getTypeOf <em>Type Of</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getProtection <em>Protection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getIsReference <em>Is Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getIsConstant <em>Is Constant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getValueSpecifications <em>Value Specifications</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAttributeImpl#getTheMainDiagram <em>The Main Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IAttributeImpl extends IVariableImpl implements IAttribute {
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
	 * The cached value of the '{@link #getTypeOf() <em>Type Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeOf()
	 * @generated
	 * @ordered
	 */
	protected IUnit typeOf;

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
	 * The default value of the '{@link #getIsReference() <em>Is Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsReference()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsReference() <em>Is Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsReference()
	 * @generated
	 * @ordered
	 */
	protected String isReference = IS_REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsConstant() <em>Is Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsConstant()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_CONSTANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsConstant() <em>Is Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsConstant()
	 * @generated
	 * @ordered
	 */
	protected String isConstant = IS_CONSTANT_EDEFAULT;

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
	 * The cached value of the '{@link #getValueSpecifications() <em>Value Specifications</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueSpecifications()
	 * @generated
	 * @ordered
	 */
	protected ILiteralSpecification valueSpecifications;

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
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected IComment annotations;

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
	 * The cached value of the '{@link #getTheMainDiagram() <em>The Main Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheMainDiagram()
	 * @generated
	 * @ordered
	 */
	protected IDiagram theMainDiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIAttribute();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__OBJECT_CREATION, oldObjectCreation, objectCreation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IATTRIBUTE__MODIFIED_TIME_WEAK);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit getTypeOf() {
		if (typeOf != null && typeOf.eIsProxy()) {
			InternalEObject oldTypeOf = (InternalEObject)typeOf;
			typeOf = (IUnit)eResolveProxy(oldTypeOf);
			if (typeOf != oldTypeOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IATTRIBUTE__TYPE_OF, oldTypeOf, typeOf));
			}
		}
		return typeOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit basicGetTypeOf() {
		return typeOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeOf(IUnit newTypeOf) {
		IUnit oldTypeOf = typeOf;
		typeOf = newTypeOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__TYPE_OF, oldTypeOf, typeOf));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__PROTECTION, oldProtection, protection));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsReference() {
		return isReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReference(String newIsReference) {
		String oldIsReference = isReference;
		isReference = newIsReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__IS_REFERENCE, oldIsReference, isReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsConstant() {
		return isConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsConstant(String newIsConstant) {
		String oldIsConstant = isConstant;
		isConstant = newIsConstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__IS_CONSTANT, oldIsConstant, isConstant));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IATTRIBUTE__STEREOTYPES, oldStereotypes, stereotypes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILiteralSpecification getValueSpecifications() {
		if (valueSpecifications != null && valueSpecifications.eIsProxy()) {
			InternalEObject oldValueSpecifications = (InternalEObject)valueSpecifications;
			valueSpecifications = (ILiteralSpecification)eResolveProxy(oldValueSpecifications);
			if (valueSpecifications != oldValueSpecifications) {
				InternalEObject newValueSpecifications = (InternalEObject)valueSpecifications;
				NotificationChain msgs = oldValueSpecifications.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS, null, null);
				if (newValueSpecifications.eInternalContainer() == null) {
					msgs = newValueSpecifications.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS, oldValueSpecifications, valueSpecifications));
			}
		}
		return valueSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILiteralSpecification basicGetValueSpecifications() {
		return valueSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueSpecifications(ILiteralSpecification newValueSpecifications, NotificationChain msgs) {
		ILiteralSpecification oldValueSpecifications = valueSpecifications;
		valueSpecifications = newValueSpecifications;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS, oldValueSpecifications, newValueSpecifications);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueSpecifications(ILiteralSpecification newValueSpecifications) {
		if (newValueSpecifications != valueSpecifications) {
			NotificationChain msgs = null;
			if (valueSpecifications != null)
				msgs = ((InternalEObject)valueSpecifications).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS, null, msgs);
			if (newValueSpecifications != null)
				msgs = ((InternalEObject)newValueSpecifications).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS, null, msgs);
			msgs = basicSetValueSpecifications(newValueSpecifications, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS, newValueSpecifications, newValueSpecifications));
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES, newProperties, newProperties));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.IATTRIBUTE__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.IATTRIBUTE__DEPENDENCIES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__LAST_ID, oldLastID, lastID));
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
				NotificationChain msgs = oldAnnotations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS, null, null);
				if (newAnnotations.eInternalContainer() == null) {
					msgs = newAnnotations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS, oldAnnotations, annotations));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS, oldAnnotations, newAnnotations);
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
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS, newAnnotations, newAnnotations));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IATTRIBUTE__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IATTRIBUTE__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IATTRIBUTE__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS:
				return basicSetValueSpecifications(null, msgs);
			case UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IATTRIBUTE__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IATTRIBUTE__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS:
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
			case UMLRhapsodyPackage.IATTRIBUTE__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IATTRIBUTE__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IATTRIBUTE__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IATTRIBUTE__ID:
				return getId();
			case UMLRhapsodyPackage.IATTRIBUTE__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IATTRIBUTE__NAME:
				return getName();
			case UMLRhapsodyPackage.IATTRIBUTE__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.IATTRIBUTE__TYPE_OF:
				if (resolve) return getTypeOf();
				return basicGetTypeOf();
			case UMLRhapsodyPackage.IATTRIBUTE__PROTECTION:
				return getProtection();
			case UMLRhapsodyPackage.IATTRIBUTE__STATIC:
				return getStatic();
			case UMLRhapsodyPackage.IATTRIBUTE__IS_REFERENCE:
				return getIsReference();
			case UMLRhapsodyPackage.IATTRIBUTE__IS_CONSTANT:
				return getIsConstant();
			case UMLRhapsodyPackage.IATTRIBUTE__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS:
				if (resolve) return getValueSpecifications();
				return basicGetValueSpecifications();
			case UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IATTRIBUTE__TAGS:
				return getTags();
			case UMLRhapsodyPackage.IATTRIBUTE__DEFAULT_VALUE:
				return getDefaultValue();
			case UMLRhapsodyPackage.IATTRIBUTE__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.IATTRIBUTE__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
			case UMLRhapsodyPackage.IATTRIBUTE__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IATTRIBUTE__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.IATTRIBUTE__THE_MAIN_DIAGRAM:
				if (resolve) return getTheMainDiagram();
				return basicGetTheMainDiagram();
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
			case UMLRhapsodyPackage.IATTRIBUTE__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__TYPE_OF:
				setTypeOf((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__PROTECTION:
				setProtection((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__STATIC:
				setStatic((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__IS_REFERENCE:
				setIsReference((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__IS_CONSTANT:
				setIsConstant((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__STEREOTYPES:
				setStereotypes((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS:
				setValueSpecifications((ILiteralSpecification)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS:
				setAnnotations((IComment)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__THE_MAIN_DIAGRAM:
				setTheMainDiagram((IDiagram)newValue);
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
			case UMLRhapsodyPackage.IATTRIBUTE__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__TYPE_OF:
				setTypeOf((IUnit)null);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__PROTECTION:
				setProtection(PROTECTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__IS_REFERENCE:
				setIsReference(IS_REFERENCE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__IS_CONSTANT:
				setIsConstant(IS_CONSTANT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__STEREOTYPES:
				setStereotypes((IUnit)null);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS:
				setValueSpecifications((ILiteralSpecification)null);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS:
				setAnnotations((IComment)null);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.IATTRIBUTE__THE_MAIN_DIAGRAM:
				setTheMainDiagram((IDiagram)null);
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
			case UMLRhapsodyPackage.IATTRIBUTE__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IATTRIBUTE__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IATTRIBUTE__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IATTRIBUTE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IATTRIBUTE__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IATTRIBUTE__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.IATTRIBUTE__TYPE_OF:
				return typeOf != null;
			case UMLRhapsodyPackage.IATTRIBUTE__PROTECTION:
				return PROTECTION_EDEFAULT == null ? protection != null : !PROTECTION_EDEFAULT.equals(protection);
			case UMLRhapsodyPackage.IATTRIBUTE__STATIC:
				return STATIC_EDEFAULT == null ? static_ != null : !STATIC_EDEFAULT.equals(static_);
			case UMLRhapsodyPackage.IATTRIBUTE__IS_REFERENCE:
				return IS_REFERENCE_EDEFAULT == null ? isReference != null : !IS_REFERENCE_EDEFAULT.equals(isReference);
			case UMLRhapsodyPackage.IATTRIBUTE__IS_CONSTANT:
				return IS_CONSTANT_EDEFAULT == null ? isConstant != null : !IS_CONSTANT_EDEFAULT.equals(isConstant);
			case UMLRhapsodyPackage.IATTRIBUTE__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IATTRIBUTE__VALUE_SPECIFICATIONS:
				return valueSpecifications != null;
			case UMLRhapsodyPackage.IATTRIBUTE__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IATTRIBUTE__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IATTRIBUTE__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.IATTRIBUTE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case UMLRhapsodyPackage.IATTRIBUTE__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.IATTRIBUTE__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.IATTRIBUTE__ANNOTATIONS:
				return annotations != null;
			case UMLRhapsodyPackage.IATTRIBUTE__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IATTRIBUTE__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.IATTRIBUTE__THE_MAIN_DIAGRAM:
				return theMainDiagram != null;
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
				case UMLRhapsodyPackage.IATTRIBUTE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.IATTRIBUTE__OBJECT_CREATION: return UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == ValueType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IATTRIBUTE__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.IATTRIBUTE__ID: return UMLRhapsodyPackage.VALUE_TYPE__ID;
				case UMLRhapsodyPackage.IATTRIBUTE__MY_STATE: return UMLRhapsodyPackage.VALUE_TYPE__MY_STATE;
				case UMLRhapsodyPackage.IATTRIBUTE__NAME: return UMLRhapsodyPackage.VALUE_TYPE__NAME;
				default: return -1;
			}
		}
		if (baseClass == ItemsType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
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
				case UMLRhapsodyPackage.IATTRIBUTE__MULTIPLICITY: return UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY;
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
				case UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.IATTRIBUTE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.IATTRIBUTE__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == ValueType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.VALUE_TYPE__MODIFIED_TIME_WEAK: return UMLRhapsodyPackage.IATTRIBUTE__MODIFIED_TIME_WEAK;
				case UMLRhapsodyPackage.VALUE_TYPE__ID: return UMLRhapsodyPackage.IATTRIBUTE__ID;
				case UMLRhapsodyPackage.VALUE_TYPE__MY_STATE: return UMLRhapsodyPackage.IATTRIBUTE__MY_STATE;
				case UMLRhapsodyPackage.VALUE_TYPE__NAME: return UMLRhapsodyPackage.IATTRIBUTE__NAME;
				default: return -1;
			}
		}
		if (baseClass == ItemsType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
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
				case UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY: return UMLRhapsodyPackage.IATTRIBUTE__MULTIPLICITY;
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
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", protection: "); //$NON-NLS-1$
		result.append(protection);
		result.append(", static: "); //$NON-NLS-1$
		result.append(static_);
		result.append(", isReference: "); //$NON-NLS-1$
		result.append(isReference);
		result.append(", isConstant: "); //$NON-NLS-1$
		result.append(isConstant);
		result.append(", defaultValue: "); //$NON-NLS-1$
		result.append(defaultValue);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(')');
		return result.toString();
	}

} //IAttributeImpl
