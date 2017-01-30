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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.FromLinkType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEnd;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAttribute;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.InverseType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_hTargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ToLinkType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IAssociation End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getImplicitClass <em>Implicit Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getOtherClass <em>Other Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getLinkName <em>Link Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getNavigability <em>Navigability</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getInverse <em>Inverse</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getQualifierType <em>Qualifier Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndImpl#getM_associationClass <em>Massociation Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IAssociationEndImpl extends AssociationsTypeImpl implements IAssociationEnd {
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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected IPropertyContainer properties;

	/**
	 * The cached value of the '{@link #getImplicitClass() <em>Implicit Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitClass()
	 * @generated
	 * @ordered
	 */
	protected IClass implicitClass;

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
	 * The cached value of the '{@link #getOtherClass() <em>Other Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherClass()
	 * @generated
	 * @ordered
	 */
	protected ElementsType otherClass;

	/**
	 * The default value of the '{@link #getLinkName() <em>Link Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkName()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkName() <em>Link Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkName()
	 * @generated
	 * @ordered
	 */
	protected String linkName = LINK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected String linkType = LINK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNavigability() <em>Navigability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigability()
	 * @generated
	 * @ordered
	 */
	protected static final String NAVIGABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNavigability() <em>Navigability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigability()
	 * @generated
	 * @ordered
	 */
	protected String navigability = NAVIGABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInverse() <em>Inverse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverse()
	 * @generated
	 * @ordered
	 */
	protected InverseType inverse;

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
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected IAttribute qualifiers;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IStereotype stereotypes;

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
	 * The cached value of the '{@link #getQualifierType() <em>Qualifier Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifierType()
	 * @generated
	 * @ordered
	 */
	protected IType qualifierType;

	/**
	 * The cached value of the '{@link #getM_associationClass() <em>Massociation Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_associationClass()
	 * @generated
	 * @ordered
	 */
	protected IAssociationClass m_associationClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAssociationEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIAssociationEnd();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION, newDescription, newDescription));
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass getImplicitClass() {
		if (implicitClass != null && implicitClass.eIsProxy()) {
			InternalEObject oldImplicitClass = (InternalEObject)implicitClass;
			implicitClass = (IClass)eResolveProxy(oldImplicitClass);
			if (implicitClass != oldImplicitClass) {
				InternalEObject newImplicitClass = (InternalEObject)implicitClass;
				NotificationChain msgs = oldImplicitClass.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS, null, null);
				if (newImplicitClass.eInternalContainer() == null) {
					msgs = newImplicitClass.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS, oldImplicitClass, implicitClass));
			}
		}
		return implicitClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass basicGetImplicitClass() {
		return implicitClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplicitClass(IClass newImplicitClass, NotificationChain msgs) {
		IClass oldImplicitClass = implicitClass;
		implicitClass = newImplicitClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS, oldImplicitClass, newImplicitClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitClass(IClass newImplicitClass) {
		if (newImplicitClass != implicitClass) {
			NotificationChain msgs = null;
			if (implicitClass != null)
				msgs = ((InternalEObject)implicitClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS, null, msgs);
			if (newImplicitClass != null)
				msgs = ((InternalEObject)newImplicitClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS, null, msgs);
			msgs = basicSetImplicitClass(newImplicitClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS, newImplicitClass, newImplicitClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__DISPLAY_NAME, oldDisplayName, displayName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementsType getOtherClass() {
		if (otherClass != null && otherClass.eIsProxy()) {
			InternalEObject oldOtherClass = (InternalEObject)otherClass;
			otherClass = (ElementsType)eResolveProxy(oldOtherClass);
			if (otherClass != oldOtherClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__OTHER_CLASS, oldOtherClass, otherClass));
			}
		}
		return otherClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementsType basicGetOtherClass() {
		return otherClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherClass(ElementsType newOtherClass) {
		ElementsType oldOtherClass = otherClass;
		otherClass = newOtherClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__OTHER_CLASS, oldOtherClass, otherClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkName() {
		return linkName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkName(String newLinkName) {
		String oldLinkName = linkName;
		linkName = newLinkName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__LINK_NAME, oldLinkName, linkName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkType() {
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkType(String newLinkType) {
		String oldLinkType = linkType;
		linkType = newLinkType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__LINK_TYPE, oldLinkType, linkType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNavigability() {
		return navigability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNavigability(String newNavigability) {
		String oldNavigability = navigability;
		navigability = newNavigability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__NAVIGABILITY, oldNavigability, navigability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseType getInverse() {
		if (inverse != null && inverse.eIsProxy()) {
			InternalEObject oldInverse = (InternalEObject)inverse;
			inverse = (InverseType)eResolveProxy(oldInverse);
			if (inverse != oldInverse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__INVERSE, oldInverse, inverse));
			}
		}
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseType basicGetInverse() {
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverse(InverseType newInverse) {
		InverseType oldInverse = inverse;
		inverse = newInverse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__INVERSE, oldInverse, inverse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IASSOCIATION_END__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAttribute getQualifiers() {
		if (qualifiers != null && qualifiers.eIsProxy()) {
			InternalEObject oldQualifiers = (InternalEObject)qualifiers;
			qualifiers = (IAttribute)eResolveProxy(oldQualifiers);
			if (qualifiers != oldQualifiers) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIERS, oldQualifiers, qualifiers));
			}
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAttribute basicGetQualifiers() {
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiers(IAttribute newQualifiers) {
		IAttribute oldQualifiers = qualifiers;
		qualifiers = newQualifiers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIERS, oldQualifiers, qualifiers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStereotype getStereotypes() {
		if (stereotypes != null && stereotypes.eIsProxy()) {
			InternalEObject oldStereotypes = (InternalEObject)stereotypes;
			stereotypes = (IStereotype)eResolveProxy(oldStereotypes);
			if (stereotypes != oldStereotypes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__STEREOTYPES, oldStereotypes, stereotypes));
			}
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStereotype basicGetStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(IStereotype newStereotypes) {
		IStereotype oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IASSOCIATION_END__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType getQualifierType() {
		if (qualifierType != null && qualifierType.eIsProxy()) {
			InternalEObject oldQualifierType = (InternalEObject)qualifierType;
			qualifierType = (IType)eResolveProxy(oldQualifierType);
			if (qualifierType != oldQualifierType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIER_TYPE, oldQualifierType, qualifierType));
			}
		}
		return qualifierType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType basicGetQualifierType() {
		return qualifierType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifierType(IType newQualifierType) {
		IType oldQualifierType = qualifierType;
		qualifierType = newQualifierType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIER_TYPE, oldQualifierType, qualifierType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationClass getM_associationClass() {
		if (m_associationClass != null && m_associationClass.eIsProxy()) {
			InternalEObject oldM_associationClass = (InternalEObject)m_associationClass;
			m_associationClass = (IAssociationClass)eResolveProxy(oldM_associationClass);
			if (m_associationClass != oldM_associationClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IASSOCIATION_END__MASSOCIATION_CLASS, oldM_associationClass, m_associationClass));
			}
		}
		return m_associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationClass basicGetM_associationClass() {
		return m_associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_associationClass(IAssociationClass newM_associationClass) {
		IAssociationClass oldM_associationClass = m_associationClass;
		m_associationClass = newM_associationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END__MASSOCIATION_CLASS, oldM_associationClass, m_associationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS:
				return basicSetImplicitClass(null, msgs);
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
			case UMLRhapsodyPackage.IASSOCIATION_END__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
			case UMLRhapsodyPackage.IASSOCIATION_END__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IASSOCIATION_END__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS:
				if (resolve) return getImplicitClass();
				return basicGetImplicitClass();
			case UMLRhapsodyPackage.IASSOCIATION_END__DISPLAY_NAME:
				return getDisplayName();
			case UMLRhapsodyPackage.IASSOCIATION_END__ID:
				return getId();
			case UMLRhapsodyPackage.IASSOCIATION_END__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IASSOCIATION_END__NAME:
				return getName();
			case UMLRhapsodyPackage.IASSOCIATION_END__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.IASSOCIATION_END__OTHER_CLASS:
				if (resolve) return getOtherClass();
				return basicGetOtherClass();
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_NAME:
				return getLinkName();
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_TYPE:
				return getLinkType();
			case UMLRhapsodyPackage.IASSOCIATION_END__NAVIGABILITY:
				return getNavigability();
			case UMLRhapsodyPackage.IASSOCIATION_END__INVERSE:
				if (resolve) return getInverse();
				return basicGetInverse();
			case UMLRhapsodyPackage.IASSOCIATION_END__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIERS:
				if (resolve) return getQualifiers();
				return basicGetQualifiers();
			case UMLRhapsodyPackage.IASSOCIATION_END__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IASSOCIATION_END__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIER_TYPE:
				if (resolve) return getQualifierType();
				return basicGetQualifierType();
			case UMLRhapsodyPackage.IASSOCIATION_END__MASSOCIATION_CLASS:
				if (resolve) return getM_associationClass();
				return basicGetM_associationClass();
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
			case UMLRhapsodyPackage.IASSOCIATION_END__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS:
				setImplicitClass((IClass)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__OTHER_CLASS:
				setOtherClass((ElementsType)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_NAME:
				setLinkName((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_TYPE:
				setLinkType((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__NAVIGABILITY:
				setNavigability((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__INVERSE:
				setInverse((InverseType)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIERS:
				setQualifiers((IAttribute)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__STEREOTYPES:
				setStereotypes((IStereotype)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIER_TYPE:
				setQualifierType((IType)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MASSOCIATION_CLASS:
				setM_associationClass((IAssociationClass)newValue);
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
			case UMLRhapsodyPackage.IASSOCIATION_END__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS:
				setImplicitClass((IClass)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__OTHER_CLASS:
				setOtherClass((ElementsType)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_NAME:
				setLinkName(LINK_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_TYPE:
				setLinkType(LINK_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__NAVIGABILITY:
				setNavigability(NAVIGABILITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__INVERSE:
				setInverse((InverseType)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIERS:
				setQualifiers((IAttribute)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__STEREOTYPES:
				setStereotypes((IStereotype)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIER_TYPE:
				setQualifierType((IType)null);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END__MASSOCIATION_CLASS:
				setM_associationClass((IAssociationClass)null);
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
			case UMLRhapsodyPackage.IASSOCIATION_END__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
			case UMLRhapsodyPackage.IASSOCIATION_END__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IASSOCIATION_END__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS:
				return implicitClass != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case UMLRhapsodyPackage.IASSOCIATION_END__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IASSOCIATION_END__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IASSOCIATION_END__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IASSOCIATION_END__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.IASSOCIATION_END__OTHER_CLASS:
				return otherClass != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_NAME:
				return LINK_NAME_EDEFAULT == null ? linkName != null : !LINK_NAME_EDEFAULT.equals(linkName);
			case UMLRhapsodyPackage.IASSOCIATION_END__LINK_TYPE:
				return LINK_TYPE_EDEFAULT == null ? linkType != null : !LINK_TYPE_EDEFAULT.equals(linkType);
			case UMLRhapsodyPackage.IASSOCIATION_END__NAVIGABILITY:
				return NAVIGABILITY_EDEFAULT == null ? navigability != null : !NAVIGABILITY_EDEFAULT.equals(navigability);
			case UMLRhapsodyPackage.IASSOCIATION_END__INVERSE:
				return inverse != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIERS:
				return qualifiers != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.IASSOCIATION_END__QUALIFIER_TYPE:
				return qualifierType != null;
			case UMLRhapsodyPackage.IASSOCIATION_END__MASSOCIATION_CLASS:
				return m_associationClass != null;
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
		if (baseClass == M_subjectType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IASSOCIATION_END__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.IASSOCIATION_END__OBJECT_CREATION: return UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == M_hTargetType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IASSOCIATION_END__REQUIREMEN_TRACABILITY_HANDLE: return UMLRhapsodyPackage.MHTARGET_TYPE__REQUIREMEN_TRACABILITY_HANDLE;
				case UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION: return UMLRhapsodyPackage.MHTARGET_TYPE__DESCRIPTION;
				case UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES: return UMLRhapsodyPackage.MHTARGET_TYPE__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == FromLinkType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ToLinkType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS: return UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS;
				default: return -1;
			}
		}
		if (baseClass == IModelElement.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IASSOCIATION_END__DISPLAY_NAME: return UMLRhapsodyPackage.IMODEL_ELEMENT__DISPLAY_NAME;
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
		if (baseClass == M_subjectType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.MSUBJECT_TYPE__UML_DEPENDENCY_ID: return UMLRhapsodyPackage.IASSOCIATION_END__UML_DEPENDENCY_ID;
				case UMLRhapsodyPackage.MSUBJECT_TYPE__OBJECT_CREATION: return UMLRhapsodyPackage.IASSOCIATION_END__OBJECT_CREATION;
				default: return -1;
			}
		}
		if (baseClass == M_hTargetType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.MHTARGET_TYPE__REQUIREMEN_TRACABILITY_HANDLE: return UMLRhapsodyPackage.IASSOCIATION_END__REQUIREMEN_TRACABILITY_HANDLE;
				case UMLRhapsodyPackage.MHTARGET_TYPE__DESCRIPTION: return UMLRhapsodyPackage.IASSOCIATION_END__DESCRIPTION;
				case UMLRhapsodyPackage.MHTARGET_TYPE__PROPERTIES: return UMLRhapsodyPackage.IASSOCIATION_END__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == FromLinkType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ToLinkType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS: return UMLRhapsodyPackage.IASSOCIATION_END__IMPLICIT_CLASS;
				default: return -1;
			}
		}
		if (baseClass == IModelElement.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.IMODEL_ELEMENT__DISPLAY_NAME: return UMLRhapsodyPackage.IASSOCIATION_END__DISPLAY_NAME;
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
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", linkName: "); //$NON-NLS-1$
		result.append(linkName);
		result.append(", linkType: "); //$NON-NLS-1$
		result.append(linkType);
		result.append(", navigability: "); //$NON-NLS-1$
		result.append(navigability);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(')');
		return result.toString();
	}

} //IAssociationEndImpl
