/**
 * Copyright (c) 2015 ESEO.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Olivier Beaudoux - code generated from model Population.ecore
 * 
 */
package org.eclipse.papyrus.aof.emf.samples.population.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.aof.emf.samples.population.Person;
import org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.impl.PersonImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.impl.PersonImpl#getBirthDay <em>Birth Day</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.impl.PersonImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.impl.PersonImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.impl.PersonImpl#getSpouse <em>Spouse</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends MinimalEObjectImpl.Container implements Person {
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
	 * The default value of the '{@link #getBirthDay() <em>Birth Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDay()
	 * @generated
	 * @ordered
	 */
	protected static final Date BIRTH_DAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthDay() <em>Birth Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDay()
	 * @generated
	 * @ordered
	 */
	protected Date birthDay = BIRTH_DAY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> children;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Person parent;

	/**
	 * The cached value of the '{@link #getSpouse() <em>Spouse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpouse()
	 * @generated
	 * @ordered
	 */
	protected Person spouse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PopulationPackage.Literals.PERSON;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getBirthDay() {
		return birthDay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBirthDay(Date newBirthDay) {
		Date oldBirthDay = birthDay;
		birthDay = newBirthDay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__BIRTH_DAY, oldBirthDay, birthDay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<Person>(Person.class, this, PopulationPackage.PERSON__CHILDREN, PopulationPackage.PERSON__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (Person)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PopulationPackage.PERSON__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Person newParent, NotificationChain msgs) {
		Person oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Person newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, PopulationPackage.PERSON__CHILDREN, Person.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, PopulationPackage.PERSON__CHILDREN, Person.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getSpouse() {
		if (spouse != null && spouse.eIsProxy()) {
			InternalEObject oldSpouse = (InternalEObject)spouse;
			spouse = (Person)eResolveProxy(oldSpouse);
			if (spouse != oldSpouse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PopulationPackage.PERSON__SPOUSE, oldSpouse, spouse));
			}
		}
		return spouse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetSpouse() {
		return spouse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpouse(Person newSpouse) {
		Person oldSpouse = spouse;
		spouse = newSpouse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__SPOUSE, oldSpouse, spouse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PopulationPackage.PERSON__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case PopulationPackage.PERSON__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, PopulationPackage.PERSON__CHILDREN, Person.class, msgs);
				return basicSetParent((Person)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PopulationPackage.PERSON__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case PopulationPackage.PERSON__PARENT:
				return basicSetParent(null, msgs);
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
			case PopulationPackage.PERSON__NAME:
				return getName();
			case PopulationPackage.PERSON__BIRTH_DAY:
				return getBirthDay();
			case PopulationPackage.PERSON__CHILDREN:
				return getChildren();
			case PopulationPackage.PERSON__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case PopulationPackage.PERSON__SPOUSE:
				if (resolve) return getSpouse();
				return basicGetSpouse();
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
			case PopulationPackage.PERSON__NAME:
				setName((String)newValue);
				return;
			case PopulationPackage.PERSON__BIRTH_DAY:
				setBirthDay((Date)newValue);
				return;
			case PopulationPackage.PERSON__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Person>)newValue);
				return;
			case PopulationPackage.PERSON__PARENT:
				setParent((Person)newValue);
				return;
			case PopulationPackage.PERSON__SPOUSE:
				setSpouse((Person)newValue);
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
			case PopulationPackage.PERSON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PopulationPackage.PERSON__BIRTH_DAY:
				setBirthDay(BIRTH_DAY_EDEFAULT);
				return;
			case PopulationPackage.PERSON__CHILDREN:
				getChildren().clear();
				return;
			case PopulationPackage.PERSON__PARENT:
				setParent((Person)null);
				return;
			case PopulationPackage.PERSON__SPOUSE:
				setSpouse((Person)null);
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
			case PopulationPackage.PERSON__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PopulationPackage.PERSON__BIRTH_DAY:
				return BIRTH_DAY_EDEFAULT == null ? birthDay != null : !BIRTH_DAY_EDEFAULT.equals(birthDay);
			case PopulationPackage.PERSON__CHILDREN:
				return children != null && !children.isEmpty();
			case PopulationPackage.PERSON__PARENT:
				return parent != null;
			case PopulationPackage.PERSON__SPOUSE:
				return spouse != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", birthDay: ");
		result.append(birthDay);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
