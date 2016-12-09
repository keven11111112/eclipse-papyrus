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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End1_Type;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End2_Type;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.FromLinkType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISysMLPort;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ToLinkType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ISys ML Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getImplicitClass <em>Implicit Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getOtherClass <em>Other Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ISysMLPortImpl#getReversed <em>Reversed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ISysMLPortImpl extends IInstanceImpl implements ISysMLPort {
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
	protected IUnit stereotypes;

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
	 * The cached value of the '{@link #getOtherClass() <em>Other Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherClass()
	 * @generated
	 * @ordered
	 */
	protected IUnit otherClass;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final String DIRECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected String direction = DIRECTION_EDEFAULT;

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
	 * The default value of the '{@link #getReversed() <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReversed()
	 * @generated
	 * @ordered
	 */
	protected static final String REVERSED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReversed() <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReversed()
	 * @generated
	 * @ordered
	 */
	protected String reversed = REVERSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISysMLPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getISysMLPort();
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
				NotificationChain msgs = oldImplicitClass.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS, null, null);
				if (newImplicitClass.eInternalContainer() == null) {
					msgs = newImplicitClass.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS, oldImplicitClass, implicitClass));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS, oldImplicitClass, newImplicitClass);
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
				msgs = ((InternalEObject)implicitClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS, null, msgs);
			if (newImplicitClass != null)
				msgs = ((InternalEObject)newImplicitClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS, null, msgs);
			msgs = basicSetImplicitClass(newImplicitClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS, newImplicitClass, newImplicitClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList.Resolving<IDependency>(IDependency.class, this, UMLRhapsodyPackage.ISYS_ML_PORT__DEPENDENCIES);
		}
		return dependencies;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISYS_ML_PORT__STEREOTYPES, oldStereotypes, stereotypes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__STEREOTYPES, oldStereotypes, stereotypes));
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
				NotificationChain msgs = oldTags.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__TAGS, null, null);
				if (newTags.eInternalContainer() == null) {
					msgs = newTags.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__TAGS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISYS_ML_PORT__TAGS, oldTags, tags));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__TAGS, oldTags, newTags);
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
				msgs = ((InternalEObject)tags).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__TAGS, null, msgs);
			if (newTags != null)
				msgs = ((InternalEObject)newTags).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__TAGS, null, msgs);
			msgs = basicSetTags(newTags, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__TAGS, newTags, newTags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit getOtherClass() {
		if (otherClass != null && otherClass.eIsProxy()) {
			InternalEObject oldOtherClass = (InternalEObject)otherClass;
			otherClass = (IUnit)eResolveProxy(oldOtherClass);
			if (otherClass != oldOtherClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISYS_ML_PORT__OTHER_CLASS, oldOtherClass, otherClass));
			}
		}
		return otherClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit basicGetOtherClass() {
		return otherClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherClass(IUnit newOtherClass) {
		IUnit oldOtherClass = otherClass;
		otherClass = newOtherClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__OTHER_CLASS, oldOtherClass, otherClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(String newDirection) {
		String oldDirection = direction;
		direction = newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__DIRECTION, oldDirection, direction));
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
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION, newDescription, newDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__LAST_ID, oldLastID, lastID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReversed() {
		return reversed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReversed(String newReversed) {
		String oldReversed = reversed;
		reversed = newReversed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISYS_ML_PORT__REVERSED, oldReversed, reversed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS:
				return basicSetImplicitClass(null, msgs);
			case UMLRhapsodyPackage.ISYS_ML_PORT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISYS_ML_PORT__TAGS:
				return basicSetTags(null, msgs);
			case UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION:
				return basicSetDescription(null, msgs);
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
			case UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS:
				if (resolve) return getImplicitClass();
				return basicGetImplicitClass();
			case UMLRhapsodyPackage.ISYS_ML_PORT__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.ISYS_ML_PORT__DEPENDENCIES:
				return getDependencies();
			case UMLRhapsodyPackage.ISYS_ML_PORT__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.ISYS_ML_PORT__TAGS:
				if (resolve) return getTags();
				return basicGetTags();
			case UMLRhapsodyPackage.ISYS_ML_PORT__OTHER_CLASS:
				if (resolve) return getOtherClass();
				return basicGetOtherClass();
			case UMLRhapsodyPackage.ISYS_ML_PORT__DIRECTION:
				return getDirection();
			case UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.ISYS_ML_PORT__LAST_ID:
				return getLastID();
			case UMLRhapsodyPackage.ISYS_ML_PORT__REVERSED:
				return getReversed();
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
			case UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS:
				setImplicitClass((IClass)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends IDependency>)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__STEREOTYPES:
				setStereotypes((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__TAGS:
				setTags((ITag)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__OTHER_CLASS:
				setOtherClass((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__DIRECTION:
				setDirection((String)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__LAST_ID:
				setLastID((String)newValue);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__REVERSED:
				setReversed((String)newValue);
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
			case UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS:
				setImplicitClass((IClass)null);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__DEPENDENCIES:
				getDependencies().clear();
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__STEREOTYPES:
				setStereotypes((IUnit)null);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__TAGS:
				setTags((ITag)null);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__OTHER_CLASS:
				setOtherClass((IUnit)null);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__LAST_ID:
				setLastID(LAST_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISYS_ML_PORT__REVERSED:
				setReversed(REVERSED_EDEFAULT);
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
			case UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS:
				return implicitClass != null;
			case UMLRhapsodyPackage.ISYS_ML_PORT__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.ISYS_ML_PORT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case UMLRhapsodyPackage.ISYS_ML_PORT__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.ISYS_ML_PORT__TAGS:
				return tags != null;
			case UMLRhapsodyPackage.ISYS_ML_PORT__OTHER_CLASS:
				return otherClass != null;
			case UMLRhapsodyPackage.ISYS_ML_PORT__DIRECTION:
				return DIRECTION_EDEFAULT == null ? direction != null : !DIRECTION_EDEFAULT.equals(direction);
			case UMLRhapsodyPackage.ISYS_ML_PORT__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.ISYS_ML_PORT__LAST_ID:
				return LAST_ID_EDEFAULT == null ? lastID != null : !LAST_ID_EDEFAULT.equals(lastID);
			case UMLRhapsodyPackage.ISYS_ML_PORT__REVERSED:
				return REVERSED_EDEFAULT == null ? reversed != null : !REVERSED_EDEFAULT.equals(reversed);
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
		if (baseClass == M_pFormalMessageType.class) {
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
				case UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS: return UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS;
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
				case UMLRhapsodyPackage.ISYS_ML_PORT__MULTIPLICITY: return UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY;
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
		if (baseClass == M_pFormalMessageType.class) {
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
				case UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS: return UMLRhapsodyPackage.ISYS_ML_PORT__IMPLICIT_CLASS;
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
				case UMLRhapsodyPackage.END2_TYPE__MULTIPLICITY: return UMLRhapsodyPackage.ISYS_ML_PORT__MULTIPLICITY;
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
		result.append(", direction: "); //$NON-NLS-1$
		result.append(direction);
		result.append(", lastID: "); //$NON-NLS-1$
		result.append(lastID);
		result.append(", reversed: "); //$NON-NLS-1$
		result.append(reversed);
		result.append(')');
		return result.toString();
	}

} //ISysMLPortImpl
